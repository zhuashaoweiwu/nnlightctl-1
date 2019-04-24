package com.nnlight.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author feng.wang
 * @description: copy from okdiweb
 * @date 2014-9-5
 * @version: 1.0.0
 */
public class PubMethod {

    public static final String[] flag = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    static String  regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";

    static String  regExNumber = "[0-9]{17}";

    static String  regCOPE = "imei";

    public static final String regExp = "^1[3|4|5|7|8][0-9]{9}$";

    public static final String TOKEN = "AT+IMEIALL\r\n";




    public static StringBuffer concat(StringBuffer srcStr, String addStr, String splitStr) {
        if (PubMethod.isEmpty(addStr)) {
            return srcStr;
        }
        if (!PubMethod.isEmpty(srcStr) && srcStr.length() > 0 && !PubMethod.isEmpty(addStr)) {
            srcStr.append(splitStr).append(addStr);
        } else {
            srcStr.append(addStr);
        }
        return srcStr;
    }


    public static int getAge(Date birthDate) {

        if (birthDate == null)
            throw new
                    RuntimeException("出生日期不能为null");

        int age = 0;

        Date now = new Date();

        SimpleDateFormat format_y = new
                SimpleDateFormat("yyyy");
        SimpleDateFormat format_M = new
                SimpleDateFormat("MM");

        String birth_year =
                format_y.format(birthDate);
        String this_year =
                format_y.format(now);

        String birth_month =
                format_M.format(birthDate);
        String this_month =
                format_M.format(now);

        // 初步，估算
        age =
                Integer.parseInt(this_year) - Integer.parseInt(birth_year);

        // 如果未到出生月份，则age - 1
        if
                (this_month.compareTo(birth_month) < 0)
            age -=
                    1;
        if (age <
                0)
            age =
                    0;
        return age;
    }

    /**
     * List 浅拷贝
     *
     * @param src
     * @param dest
     */
    public static void copyCollectionByAdd(Collection<Object> src, Collection<Object> dest) {
        if (PubMethod.isEmpty(src) || PubMethod.isEmpty(dest))
            return;

        // for (int i = 0 ; i< src.size() ;i++) {//jdk 1.4
        for (Object obj : src) {// jdk 1.5 以上版本
            // Object obj = src.get(i);
            dest.add(obj);
        }
    }


    // 判断是否存在 单引号。
    public static boolean isContainSingleQuotes(String str) {
        if (str.indexOf("'") >= 0)
            return true;
        else
            return false;
    }

    // 判断是否为空。
    public static boolean isEmpty(String Value) {
        return (Value == null || Value.trim().equals("") || Value.trim().equals("null"));
    }

    /*
     * @function:判空 @author:
     */
    public static boolean isEmpty(List<?> list) {
        if (list == null || list.size() == 0)
            return true;
        else
            return false;
    }

    /*
     * @function:判空 @author:
     */
    public static boolean isEmpty(Set<?> set) {
        if (set == null || set.size() == 0)
            return true;
        else
            return false;
    }

    /*
     * @function:判空 @author:
     */
    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null || map.size() == 0)
            return true;
        else
            return false;
    }

    // 判断是否为空。
    public static boolean isEmpty(byte[] Value) {
        if (Value == null || Value.length == 0)
            return true;
        else
            return false;
    }

    // 判断是否为空。
    public static boolean isEmpty(Object Value) {
        if (Value == null)
            return true;
        else
            return false;
    }


    public static boolean isEmpty(StringBuffer value) {
        if (value == null || value.length() <= 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Double value) {
        if (value == null || value.doubleValue() == 0.0)
            return true;
        else
            return false;
    }

    // 判断是否为空。
    public static boolean isEmpty(Long obj) {
        if (obj == null || obj.longValue() == 0)
            return true;
        else
            return false;
    }

    // 判断是否为空。
    public static boolean isEmpty(Object[] Value) {
        if (Value == null || Value.length == 0)
            return true;
        else
            return false;
    }

    // 返回有效状态值
    public static int validState() {
        return 1;
    }

    // 返回无效状态值
    public static int invalidState() {
        return 0;
    }

    // 判断状态是否有效。0无效、1有效、9删除。
    public static boolean isValid(int state) {
        if (state == 1)
            return true;
        else
            return false;
    }

    // Set集合到List的转换
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getList(Set set) {
        List list = new ArrayList();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * 把List转换为Set
     *
     * @param
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Set convertList2Set(List list) {
        if (list == null || list.size() == 0)
            return null;
        Set set = new HashSet();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next());
        }
        return set;
    }

    /**
     * 用户名正则验证
     *
     * @param account 用户名
     * @return
     */
    public static boolean regexAccount(String account) {
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(account);
        boolean find = m.find();
        return find;

    }

    /**
     * 密码正则验证
     *
     * @param
     * @return
     */
    public static boolean regexPwd(String pwd) {

        return true;

    }

    /**
     * 获取系统操作时间
     *
     * @param
     * @return String
     */
    public static String getSysOptDate() {
        Calendar date = Calendar.getInstance();
        Date sysDate = date.getTime();
        String optDate = PubMethod.dateToString(sysDate, "yyyy-MM-dd HH:mm:ss");
        return optDate;
    }

    /**
     * 字符串转换为Date类型
     *
     * @param
     * @return Date
     */
    public static String dateToString(Date dteValue, String strFormat) {
        if (PubMethod.isEmpty(dteValue)) {
            return null;
        }
        SimpleDateFormat clsFormat = new SimpleDateFormat(strFormat);
        return clsFormat.format(dteValue);
    }

    /**
     * Description（方法描述）:生成随机六位密码(数字+英文) Author（开发人员）:ＨaiＦｅｎｇ.Ｈｅ Receive
     * parameters(接收参数): Return parameters(返回参数):
     */
    public static String createPassword() {
        StringBuffer idenCode = new StringBuffer(); // 生成密码
        Random ran = new Random();
        for (int i = 0; i < 6; i++) {
            idenCode.append(flag[ran.nextInt(36)]);
        }
        return idenCode.toString();
    }

    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static Timestamp getSysTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * <功能详细描述>
     * 创 建 人:  文超
     * 创建时间:  2014-4-23 下午1:40:15
     *
     * @param time 单位（秒）
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Timestamp getSysAfterTimestamp(int time) {
        return new Timestamp(System.currentTimeMillis() + time * 1000);
    }

    /**
     * 把date 转换为 timestamp
     *
     * @param
     * @return
     */
    public static Timestamp dateToTimestamp(Date date) {
        if (PubMethod.isEmpty(date)) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }


    public static String handSting(String string) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(string);
        return m.replaceAll("").trim().toLowerCase();
    }

    public static Map<Integer,String> regEx(String string) {
        if(PubMethod.isEmpty(string)) return new HashMap<>();
        String[] imeis = string.split(regCOPE);
        Map<Integer,String> resMap = new HashMap<Integer, String>();
        for (int i = 0 ; i < imeis.length;i ++) {
            Pattern pattern = Pattern.compile (regExNumber);
            Matcher matcher = pattern.matcher (imeis[i]);
            while (matcher.find ()) {resMap.put(Integer.parseInt(imeis[i].substring(0,1)),matcher.group ()); }
        }
        return resMap;
    }

}
