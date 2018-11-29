package com.wcx.framework.mvpproject.component.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MVPInstantiationUtils {
    public static final int FIRSTGENERICITY = 0;

    public static <T> T getInstantiation(Object object, int i) {
        try {
            Class<?> aClass = object.getClass();
            Type type = aClass.getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<T> tClass = (Class<T>) parameterizedType.getActualTypeArguments()[i];
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

}
