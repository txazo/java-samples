package org.txazo.java.samples.lombok.requiredargsconstructor;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private final Long id;
    private String name;

    public LombokBean(final Long id) {
        this.id = id;
    }

}
