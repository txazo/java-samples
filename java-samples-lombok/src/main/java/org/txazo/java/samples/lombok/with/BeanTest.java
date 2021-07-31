package org.txazo.java.samples.lombok.with;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class BeanTest {

    public static void main(String[] args) {
        Bean bean = new Bean(1L, "root");
        Bean copy = bean.withName("admin");
    }

}
