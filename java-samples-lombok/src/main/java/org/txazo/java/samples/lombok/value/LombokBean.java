package org.txazo.java.samples.lombok.value;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private final Long id;
    private final String name;

    private LombokBean(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static LombokBean of(final Long id, final String name) {
        return new LombokBean(id, name);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Bean)) {
            return false;
        } else {
            LombokBean other = (LombokBean) o;
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null) {
                if (other$id != null) {
                    return false;
                }
            } else if (!this$id.equals(other$id)) {
                return false;
            }

            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null) {
                if (other$name != null) {
                    return false;
                }
            } else if (!this$name.equals(other$name)) {
                return false;
            }

            return true;
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Bean(id=" + this.getId() + ", name=" + this.getName() + ")";
    }

}
