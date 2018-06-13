package com.nnlightctl.druid;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import com.alibaba.druid.stat.JdbcSqlStatValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DruidStatLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

    private static final Logger logger = LoggerFactory.getLogger(DruidStatLogger.class);

    @Override
    public void log(DruidDataSourceStatValue statValue) {
        super.log(statValue);
        List<JdbcSqlStatValue> jdbcSqlStatValueList = statValue.getSqlList();
        for (JdbcSqlStatValue jdbcSqlStatValue : jdbcSqlStatValueList) {
            logger.info(jdbcSqlStatValue.getSql());
            logger.info(jdbcSqlStatValue.getLastSlowParameters());
        }
    }
}
