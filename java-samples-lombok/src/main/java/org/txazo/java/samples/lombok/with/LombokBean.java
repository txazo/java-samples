package org.txazo.java.samples.lombok.with;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private Long id;
    private String name;

    public LombokBean(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public LombokBean withName(final String name) {
        return this.name == name ? this : new LombokBean(this.id, name);
    }

}
