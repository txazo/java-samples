package org.txazo.java.samples.lombok.nonnull;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
    }

}
