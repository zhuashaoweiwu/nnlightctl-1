package com.nnlightctl.dynamicdatasource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

public class DynamicDataSourceTransactionManager extends DataSourceTransactionManager {

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        boolean readOnly = definition.isReadOnly();//获取当前事务切点的方法的读写属性（在spring的xml或者事务注解中的配置）
        if (readOnly)
            DateSourceHolder.setSlave();
        else
            DateSourceHolder.setMaster();
        super.doBegin(transaction, definition);
    }

    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        super.doCleanupAfterCompletion(transaction);
        DateSourceHolder.clearDataSource();
    }
}
