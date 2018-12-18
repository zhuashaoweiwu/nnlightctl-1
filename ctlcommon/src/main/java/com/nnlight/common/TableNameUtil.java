package com.nnlight.common;

import org.springframework.jdbc.core.JdbcTemplate;

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
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       // System.out.println("昨天时间："+getTableNameByDateTest("nnlightctl_lighting_vol_ele_record"));

        List<String> list = getAllMonthEnd("nnlightctl_lighting_vol_ele_record");
        for(String date: list){
            System.out.println("本月时间："+date);
        }
        /*Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 0);
        c.set(Calendar.DAY_OF_YEAR,1);//设置为1号,当前日期既为本年第一天

        try{
            List<String> list1 = findDates(c.getTime(),new Date(),"nnlightctl_lighting_vol_ele_record");
            for(String date: list1){
                System.out.println("本年时间："+date);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
*/
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


}
