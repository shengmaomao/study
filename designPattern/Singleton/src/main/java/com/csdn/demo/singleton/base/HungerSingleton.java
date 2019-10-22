package com.csdn.demo.singleton.base;

/**
 * 单例的饿汉式实现
 *
 * @author tony
 */
public class HungerSingleton {

    /**
     * 定义一个变量来存储创建好的类实例，直接在这里创建
     */
    private static HungerSingleton uniqueSingleton = new HungerSingleton();

    /**
     * 私有化构造方法
     */
    private HungerSingleton() {

    }

    /**
     * 定义一个方法为客户端提供类实例
     * @return 类实例
     */
    public static synchronized HungerSingleton getInstance() {
        return uniqueSingleton;
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
