package org.txazo.java.samples.lombok.value;

import lombok.Value;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
@Value(staticConstructor = "of")
public class Bean {

    private Long id;
    private String name;

}
