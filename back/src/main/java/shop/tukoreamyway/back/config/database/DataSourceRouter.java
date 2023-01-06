package shop.tukoreamyway.back.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class DataSourceRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        if(TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
            return DataSourceType.SLAVE;
        }
        return DataSourceType.MASTER;
    }
}
