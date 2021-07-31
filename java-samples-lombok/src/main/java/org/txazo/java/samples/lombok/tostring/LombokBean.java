package org.txazo.java.samples.lombok.tostring;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Bean(id=" + this.id + ", name=" + this.name + ")";
    }

}
