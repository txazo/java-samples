package org.txazo.java.samples.lombok.with;

import lombok.AllArgsConstructor;
import lombok.With;

/**
 * @author tuxiaozhou
 * @date 2021/7/29
 */
@AllArgsConstructor
public class Bean {

    private Long id;

    @With
    private String name;

}
