package com.nnlight.common;

import org.springframework.jdbc.core.JdbcTemplate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
            String[] types = {"TABLE"};
            tabs = dbMetaData.getTables(null, null, tableName, types);
            if (tabs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tabs.close();
            conn.close();
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       System.out.println("昨天时间："+getTableNameByDate("nnlightctl_lighting_vol_ele_record"));
        Calendar currentDate = new GregorianCalendar();

        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        System.out.println(format.format(currentDate.getTime().clone()));

    }
    /*
     * 得到今天能耗时间表明
     * */
    public static String getTableNameByDate(String rootTableName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        calendar.add(calendar.DATE,0);

        String date2= dateFormat.format(calendar.getTime());

        return rootTableName + "_" + date2;
    }
    /*
    * 得到昨天能耗时间表明
    * */
    public static String getTableNameByDateTest(String rootTableName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        calendar.add(calendar.DATE,-1);

        String date2= dateFormat.format(calendar.getTime());

        return rootTableName + "_" + date2;
    }
    /*
    * 获取本月已经获取本月已过去的所有日期表明
    * */
    public static List<String> getAllMonthEnd(String rootTableName){
        List<String> resultList = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String today = dateFormat.format(new Date());
        int days = Integer.parseInt(today.substring(8));
        String month = today.substring(0, 8);
        for(int i=1;i<=days;i++) {
            String date = null;
            if(i<10) {
                date = rootTableName + "_" +month+"0"+String.valueOf(i);
            }else {
                date = rootTableName + "_" +month+String.valueOf(i);
            }
            resultList.add(date);
        }
        return resultList;
    }
    /*
    * 获取一段时间内所有时间表明
    * */
    public static List<String> findDates(Date dBegin, Date dEnd,String rootTableName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        List <String>lDate = new ArrayList<String>();
        lDate.add(rootTableName + "_" +dateFormat.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(rootTableName + "_" +dateFormat.format(calBegin.getTime()));
        }
        return lDate;
    }


    public static class ObjectTransferUtil {
        public static byte[] object2ByteArray(Object source) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(source);
                byte[] bytes = byteArrayOutputStream.toByteArray();
                objectOutputStream.close();
                return bytes;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static Object byteArray2Object(byte[] bytes) {
            if (bytes == null || bytes.length <= 0) {
                throw new RuntimeException("字节数组不可为空");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
                return objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static void main(String[] args) {
            Integer integer = new Integer(88);
            System.out.println("before:" + integer);
            Integer alfterInteger = (Integer)byteArray2Object(object2ByteArray(integer));
            System.out.println("after:" + alfterInteger);

            byte[] bytes = object2ByteArray(null);
            System.out.print("[");
            for (int i = 0; i < bytes.length; ++i) {
                System.out.print(bytes[i]);
                System.out.print(", ");
            }
            System.out.println("]");

            System.out.println((Object) null);

            Object o = byteArray2Object(bytes);
            System.out.println(o);
        }
    }
}
