package shop.tukoreamyway.back.config.database;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"shop.tukoreamyway.back"})
public class DataSourceConfig {
  private final Environment env;

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
  public DataSource masterDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari.salve")
  public DataSource slaveDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @DependsOn({"masterDataSource", "slaveDataSource"})
  @Bean
  public DataSource routingDataSource() {
    AbstractRoutingDataSource dataSourceRouter = new DataSourceRouter();

    dataSourceRouter.setTargetDataSources(generateDataSourceMap());
    dataSourceRouter.setDefaultTargetDataSource(masterDataSource());
    return dataSourceRouter;
  }

  @DependsOn({"routingDataSource"})
  @Bean
  public DataSource dataSource() {
    return new LazyConnectionDataSourceProxy(routingDataSource());
  }

  private Map<Object, Object> generateDataSourceMap() {
    Map<Object, Object> dataSourceMap = new HashMap<>();
    dataSourceMap.put(DataSourceType.MASTER, masterDataSource());
    dataSourceMap.put(DataSourceType.SLAVE, slaveDataSource());
    return dataSourceMap;
  }

  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setDataSource(dataSource);
    em.setPackagesToScan("shop.tukoreamyway.back");

    Map<String, Object> properties = new HashMap<>();
    properties.put(
        "hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
    properties.put(
        "hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
    em.setJpaPropertyMap(properties);

    return em;
  }

  @Primary
  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);

    return transactionManager;
  }
}
