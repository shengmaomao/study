package com.csdn.demo.singleton.base;

/**
 * 单例的懒汉式--性能比较好的实现
 * <p>
 *     方案:Lazy initialization holder class模式
 * <p>
 *     这个模式总和使用了Java的类级内部类和多线程缺省同步锁的知识，很巧妙的同时实现了延迟加载和线程安全
 *
 * @author tony
 */
public class LazySingletonPerfect {

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
     * 而且只有被调用到时才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static LazySingletonPerfect uniqueInstance = new LazySingletonPerfect();
    }

    /**
     * 私有化构造方法
     */
    private LazySingletonPerfect() {

    }

    /**
     * 定义一个方法来为客户端提供类实例
     * <p>
     *     当getInstance方法第一次被调用的时候，它第一次读取SingletonHolder.instance，导致SingletonHolder类得到初始化；
     *     而这个类在装载并被初始化的时候，会初始化它的静态与，从而创建Singleton的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，
     *     并由虚拟机来保证它的线程安全性
     * @return 类实例
     */
    private static LazySingletonPerfect getInstance() {
        return SingletonHolder.uniqueInstance;
    }

}
