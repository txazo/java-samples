package org.txazo.java.samples.lombok.var;

import lombok.var;

import java.util.ArrayList;

/**
 * @author tuxiaozhou
 * @date 2021/7/31
 */
public class Bean {

    public void test() {
        var list = new ArrayList<String>();
        list.add("lombok");
    }

}
