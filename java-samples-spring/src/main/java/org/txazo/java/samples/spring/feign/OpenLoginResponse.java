package org.txazo.java.samples.spring.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tuxiaozhou
 * @date 2021/10/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenLoginResponse implements Serializable {

    private String openId;

}
