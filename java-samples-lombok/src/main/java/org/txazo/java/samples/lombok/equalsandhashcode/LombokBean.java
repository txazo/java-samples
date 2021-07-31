package org.txazo.java.samples.lombok.equalsandhashcode;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    private Long id;
    private String name;

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LombokBean)) {
            return false;
        } else {
            LombokBean other = (LombokBean) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.id;
                Object other$id = other.id;
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$name = this.name;
                Object other$name = other.name;
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
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LombokBean;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $id = this.id;
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.name;
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

}
