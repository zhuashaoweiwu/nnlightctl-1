package com.nnlight.common;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableNameUtil {
    public static String getTableNameByDate(String rootTableName, Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        return rootTableName + "_" + dateFormat.format(date);
    }

    public static boolean isTableExist(JdbcTemplate jt, String tableName) throws Exception {
        Connection conn = jt.getDataSource().getConnection();
        ResultSet tabs = null;
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            String[]   types   =   { "TABLE" };
            tabs = dbMetaData.getTables(null, null, tableName, types);
            if (tabs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            tabs.close();
            conn.close();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getTableNameByDate("nnlightctl_table_test", new Date()));
    }
}
