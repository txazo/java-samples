package org.txazo.java.samples.spring.feign;

import feign.Headers;
import feign.RequestLine;

/**
 * @author tuxiaozhou
 * @date 2021/10/1
 */
public interface OpenService {

    @RequestLine("POST /open/login")
    @Headers({"Content-Type: application/json"})
    OpenLoginResponse openLogin(OpenLoginRequest request);

}
