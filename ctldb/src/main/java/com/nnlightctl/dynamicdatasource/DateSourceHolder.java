package com.nnlightctl.dynamicdatasource;

import javax.sql.DataSource;

public class DateSourceHolder {

    private static final String MASTER = "master";
    private static final String SLAVE = "slave";

    private static final ThreadLocal<String> dataSource = new ThreadLocal<>();
    private static final ThreadLocal<DataSource> masterLocal = new ThreadLocal<>();
    private static final ThreadLocal<DataSource> slaveLocal = new ThreadLocal<>();

    private static void setDataSource(String dataSourceKey) {
        dataSource.set(dataSourceKey);
    }

    private static String getDataSource() {
        return dataSource.get();
    }

    public static boolean isMaster() {
        return getDataSource() == MASTER;
    }

    public static boolean isSlave() {
        return getDataSource() == SLAVE;
    }

    public static void setSlave(DataSource dataSource) {
        slaveLocal.set(dataSource);
    }

    public static void setMaster(DataSource dataSource) {
        masterLocal.set(dataSource);
    }

    public static void setMaster() {
        setDataSource(MASTER);
    }

    public static void setSlave() {
        setDataSource(SLAVE);
    }

    public static void clearDataSource() {
        dataSource.remove();
        masterLocal.remove();
        slaveLocal.remove();
    }

}
