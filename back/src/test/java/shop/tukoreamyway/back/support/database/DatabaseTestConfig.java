package shop.tukoreamyway.back.support.database;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class DatabaseTestConfig {

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean config = new DatabaseConfigBean();
        config.setAllowEmptyFields(true);
        config.setDatatypeFactory(new H2DataTypeFactory());
        return config;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(DataSource dataSource) {
        DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection = new DatabaseDataSourceConnectionFactoryBean();
        dbUnitDatabaseConnection.setDataSource(dataSource);
        dbUnitDatabaseConnection.setDatabaseConfig(dbUnitDatabaseConfig());
        return dbUnitDatabaseConnection;
    }
}
