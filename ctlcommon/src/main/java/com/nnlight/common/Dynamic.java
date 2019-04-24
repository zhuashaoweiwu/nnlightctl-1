package com.nnlight.common;

import com.nnlightctl.net.CommandData;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Dynamic {


    public static CommandData continuationCommand(byte[] data) throws NoSuchFieldException {
        CommandData commandData = new CommandData();
        ControlTransformation controlTransformation = new ControlTransformation.Builder().build();
        for (SystemConfig.Ilength ilength : SystemConfig.Ilength.values()) {
            Object o = SystemConfig.getInfo.optionIlength(ilength, controlTransformation,data);
            if (PubMethod.isEmpty(o)) continue;
            System.out.println(ilength.name() + "******" + "  " + o);
            setValue(commandData, commandData.getClass(), ilength.name(), CommandData.class.getDeclaredField(ilength.name()).getType(), o);
            System.out.println(ilength.name() + "******");
        }
        return commandData;
    }


    public static void setValue(Object obj, Class<?> clazz, String filedName, Class<?> typeClass, Object value) {
        filedName = removeLine(filedName);
        String methodName = SystemConfig.getInfo.getCacheKey.PREFIX + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
        try {
            clazz.getDeclaredMethod(methodName, new Class[]{typeClass}).invoke(obj, new Object[]{getClassTypeValue(typeClass, value)});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static Object getClassTypeValue(Class<?> typeClass, Object value) {
        if (typeClass == int.class || value instanceof Integer) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == short.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == byte.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == double.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == long.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == String.class) {
            if (null == value) {
                return "";
            }
            return value;
        } else if (typeClass == boolean.class) {
            if (null == value) {
                return true;
            }
            return value;
        } else if (typeClass == BigDecimal.class) {
            if (null == value) {
                return new BigDecimal(0);
            }
            return new BigDecimal(value + "");
        } else {
            return typeClass.cast(value);
        }
    }


    public static String removeLine(String str) {
        if (null != str && str.contains("_")) {
            int i = str.indexOf("_");
            char ch = str.charAt(i + 1);
            char newCh = (ch + "").substring(0, 1).toUpperCase().toCharArray()[0];
            String newStr = str.replace(str.charAt(i + 1), newCh);
            String newStr2 = newStr.replace("_", "");
            return newStr2;
        }
        return str;
    }


}
