package org.txazo.java.samples.lombok.synchronize;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private final Object $lock = new Object[0];
    private static final Object $LOCK = new Object[0];
    private final Object lock = new Object[0];

    public void test1() {
        synchronized (this.lock) {
        }
    }

    public void test2() {
        synchronized (this.$lock) {
        }
    }

    public static void test3() {
        synchronized ($LOCK) {
        }
    }

    public static void test4() {
        synchronized ($LOCK) {
        }
    }

}
