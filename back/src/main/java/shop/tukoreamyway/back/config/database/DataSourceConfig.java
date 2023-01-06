package shop.tukoreamyway.back.config.database;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
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
}
