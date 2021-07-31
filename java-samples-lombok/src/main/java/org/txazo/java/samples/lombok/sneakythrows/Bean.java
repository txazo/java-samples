package org.txazo.java.samples.lombok.sneakythrows;

import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class Bean {

    @SneakyThrows(UnsupportedEncodingException.class)
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }

}
