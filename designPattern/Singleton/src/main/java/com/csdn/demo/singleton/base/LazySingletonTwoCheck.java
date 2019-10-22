package com.csdn.demo.singleton.base;

import java.util.Objects;

/**
 * 单例的懒汉式--双重校验机制实现
 *
 * @author tony
 */
public class LazySingletonTwoCheck {

    /**
     * 对保存实例的变量添加volatile的修饰
     * <p>
     *     1、被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存，
     *     从而确保多个线程能正确的处理该变量。
     * </p>
     * <p>
     *     2、由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率不是很高。
     *     因此一般建议，没有特别的需要，不要使用。
     * </p>
     */
    private volatile static LazySingletonTwoCheck uniqueInstance = null;

    /**
     * 私有化构造方法
     */
    private LazySingletonTwoCheck() {

    }

    /**
     * 定义一个方法来为客户端提供类实例
     * @return 类实例
     */
    private static LazySingletonTwoCheck getInstance() {
        // 先检查实例是否存在，如果不存在才进入下面的同步块
        if (Objects.isNull(uniqueInstance)) {
            // 同步块，线程安全地创建实例
            synchronized (LazySingletonTwoCheck.class) {
                // 再次检查实例是否存在，如果不存在才真正地创建实例
                if (Objects.isNull(uniqueInstance)) {
                    uniqueInstance = new LazySingletonTwoCheck();
                }
            }
        }
        return uniqueInstance;
    }


}
