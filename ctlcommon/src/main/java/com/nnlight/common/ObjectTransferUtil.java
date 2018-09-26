package com.nnlight.common;

import java.io.*;

public class ObjectTransferUtil {
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
