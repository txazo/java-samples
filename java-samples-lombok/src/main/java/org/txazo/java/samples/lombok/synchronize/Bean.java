package org.txazo.java.samples.lombok.synchronize;

import lombok.Synchronized;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class Bean {

    private final Object lock = new Object[0];

    @Synchronized("lock")
    public void test1() {
    }

    @Synchronized
    public void test2() {
    }

    @Synchronized
    public static void test3() {
    }

    @Synchronized
    public static void test4() {
    }

}
