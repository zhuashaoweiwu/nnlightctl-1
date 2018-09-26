package com.nnlightctl.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;

import java.io.IOException;

public class HBaseUtils {

    private static Configuration configuration;
    private static HConnection connection;

    public static synchronized Configuration getConfiguration() {
        if (configuration == null) {
            configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.property.clientPort", "2181");
            configuration.set("hbase.zookeeper.quorum", "192.168.9.156,192.168.9.157,192.168.9.158");
            configuration.set("hbase.master", "192.168.9.152:60000");
        }

        return configuration;
    }

    public static synchronized HConnection getConnection() throws IOException {
        if (connection == null) {
            connection = HConnectionManager.createConnection(getConfiguration());
        }

        return connection;
    }
}
