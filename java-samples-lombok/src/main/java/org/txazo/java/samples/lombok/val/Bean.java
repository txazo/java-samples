package org.txazo.java.samples.lombok.val;

import lombok.val;

import java.util.ArrayList;

/**
 * @author tuxiaozhou
 * @date 2021/7/31
 */
public class Bean {

    public void test() {
        val list = new ArrayList<String>();
        list.add("lombok");
    }

}
