package com.nnlightctl.dynamicdatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    private AtomicInteger counter = new AtomicInteger();

    private DataSource master;

    private List<DataSource> slaves;

    @Override
    protected Object determineCurrentLookupKey() {
        //do nothing
        return null;
    }

    @Override
    public void afterPropertiesSet() {
        //do nothing
    }

    /**
     * 根据标识获取数据源
     *
     * @return
     */
    @Override
    protected DataSource determineTargetDataSource() {
        DataSource dataSource = null;
        if (DateSourceHolder.isMaster()) {
            dataSource = master;
        } else {
            int count = counter.getAndIncrement();
            if (count > 1000000)
                counter.set(0);
            //轮循策略
            int sequence = count % slaves.size();
            dataSource = slaves.get(sequence);
        }

        //调试，打印出DataSource
        if (dataSource instanceof com.alibaba.druid.pool.DruidDataSource) {
            com.alibaba.druid.pool.DruidDataSource ds = (com.alibaba.druid.pool.DruidDataSource) dataSource;
            String jdbcUrl = ds.getUrl();
            logger.info(">>>>>>>DataSource>>>>>>use jdbc " + "; url : " + jdbcUrl);
        }

        return dataSource;
    }

    public DataSource getMaster() {
        return master;
    }

    public void setMaster(DataSource master) {
        this.master = master;
    }

    public List<DataSource> getSlaves() {
        return slaves;
    }

    public void setSlaves(List<DataSource> slaves) {
        this.slaves = slaves;
    }
}
