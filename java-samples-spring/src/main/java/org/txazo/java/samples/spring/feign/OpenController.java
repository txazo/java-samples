package org.txazo.java.samples.spring.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author tuxiaozhou
 * @date 2021/10/1
 */
@RestController
@RequestMapping("/open")
public class OpenController {

    @Value("${server.port:80}")
    private Integer serverPort;

    @ResponseBody
    @PostMapping("/login")
    public OpenLoginResponse login(@RequestBody OpenLoginRequest request) {
        System.out.println("http://127.0.0.1:" + serverPort + "/open/login");
        return new OpenLoginResponse(request.getUserName() + "-" + UUID.randomUUID().toString());
    }

}
