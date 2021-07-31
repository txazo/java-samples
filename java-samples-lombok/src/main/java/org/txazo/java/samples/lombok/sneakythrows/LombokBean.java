package org.txazo.java.samples.lombok.sneakythrows;

import lombok.Lombok;

import java.io.UnsupportedEncodingException;

/**
 * @author tuxiaozhou
 * @date 2021/7/30
 */
public class LombokBean {

    public String utf8ToString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

}
