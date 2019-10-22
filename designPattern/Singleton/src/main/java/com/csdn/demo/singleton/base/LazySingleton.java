package com.csdn.demo.singleton.base;

import java.util.Objects;

/**
 * 单例的懒汉式实现
 *
 * @author tony
 */
public class LazySingleton {

    /**
     * 定义一个变量来存储创建好的实例
     */
    private static LazySingleton uniqueInstance = null;

    /**
     * 私有化构造方法，可以在内部控制创建实例的数目
     */
    private LazySingleton() {

    }

    /**
     * 定义一个方法来为客户端提供类实例
     * @return 类实例
     */
    public static synchronized LazySingleton getInstance() {
        if (Objects.isNull(uniqueInstance)) {
            uniqueInstance = new LazySingleton();
        }
        return uniqueInstance;
    }

    /**
     * 单例可以有自己的属性 如：paramA
     */
    private String paramA;

    /**
     * 单例也可以有自己的操作
     */
    public void operation() {
        // 功能处理
    }

    public String getParamA() {
        return paramA;
    }

}
