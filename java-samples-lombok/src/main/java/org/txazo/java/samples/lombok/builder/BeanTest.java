package org.txazo.java.samples.lombok.builder;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class BeanTest {

    public static void main(String[] args) {
        Bean bean = Bean.builder().id(1L).name("root").build();
    }

}
