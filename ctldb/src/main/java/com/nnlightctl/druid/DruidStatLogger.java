package com.nnlightctl.druid;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import com.alibaba.druid.stat.JdbcSqlStatValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.JMException;
import java.util.List;
import java.util.Map;

public class DruidStatLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

    private static final Logger logger = LoggerFactory.getLogger(DruidStatLogger.class);

    @Override
    public void log(DruidDataSourceStatValue statValue) {
        super.log(statValue);
        List<JdbcSqlStatValue> jdbcSqlStatValueList = statValue.getSqlList();
        for (JdbcSqlStatValue jdbcSqlStatValue : jdbcSqlStatValueList) {
            logger.info(jdbcSqlStatValue.getSql());
            try {
                Map<String, Object> data = jdbcSqlStatValue.getData();
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    logger.info("Param : [" + entry.getKey() + ", " + entry.getValue() + "]");
                }
            } catch (JMException e) {
                logger.error(e.getMessage());
            }
            String lastSlowParameters = jdbcSqlStatValue.getLastSlowParameters();
            if (lastSlowParameters != null && !lastSlowParameters.isEmpty()) {
                logger.info(lastSlowParameters);
            }
        }
    }
}
