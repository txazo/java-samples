package org.txazo.java.samples.lombok.builder;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private Long id;
    private String name;

    LombokBean(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static LombokBean.BeanBuilder builder() {
        return new LombokBean.BeanBuilder();
    }

    public static class BeanBuilder {
        private Long id;
        private String name;

        BeanBuilder() {
        }

        public LombokBean.BeanBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public LombokBean.BeanBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public LombokBean build() {
            return new LombokBean(this.id, this.name);
        }

        @Override
        public String toString() {
            return "LombokBean.BeanBuilder(id=" + this.id + ", name=" + this.name + ")";
        }

    }

}
