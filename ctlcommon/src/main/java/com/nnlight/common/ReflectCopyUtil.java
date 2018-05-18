package com.nnlight.common;

import java.lang.reflect.Field;

/**
 * Created by lin on 2017/5/19.
 */
public class ReflectCopyUtil {
    private static Field searchFieldFromArray(Field field, Field[] searchArray) {
        for (Field f : searchArray) {
            if (f.getName().equals(field.getName())) {
                return f;
            }
        }

        return null;
    }

    public static void beanSameFieldCopy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }

        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] sourceSuperFields = sourceClass.getSuperclass().getDeclaredFields();
        //合并源本类及父类字段数组
        Field[] allSourceField = new Field[sourceFields.length + sourceSuperFields.length];
        int k = 0;
        for (int i = 0; i < allSourceField.length; ++i) {
            if (i < sourceFields.length) {
                allSourceField[i] = sourceFields[i];
            } else {
                allSourceField[i] = sourceSuperFields[k++];
            }
        }

        //合并目标本类及父类字段数组
        Field[] targetFields = targetClass.getDeclaredFields();
        Field[] targetSupperFields = targetClass.getSuperclass().getDeclaredFields();
        Field[] allTargetField = new Field[targetFields.length + targetSupperFields.length];
        k = 0;
        for (int i = 0; i < allTargetField.length; ++i) {
            if (i < targetFields.length) {
                allTargetField[i] = targetFields[i];
            } else {
                allTargetField[i] = targetSupperFields[k++];
            }
        }

        //开始copy值
        for (Field sourceF : allSourceField) {
            sourceF.setAccessible(true);

            Field targetF = searchFieldFromArray(sourceF, allTargetField);

            if (targetF != null) {
                targetF.setAccessible(true);
                try {
                    targetF.set(target, sourceF.get(source));
                } catch (IllegalAccessException e) {
                    continue;
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
