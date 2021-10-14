package org.txazo.java.samples.spring.feign;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author tuxiaozhou
 * @date 2021/10/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationMain.class})
public class OpenServiceTest {

    @Resource
    private OpenService openService;

    @Test
    public void testOpenLogin() {
        OpenLoginRequest request = OpenLoginRequest.builder()
                .userName("admin")
                .password("123456")
                .build();
        OpenLoginResponse response = openService.openLogin(request);
        System.out.println(new Gson().toJson(response));
        response = openService.openLogin(request);
        System.out.println(new Gson().toJson(response));
        response = openService.openLogin(request);
        System.out.println(new Gson().toJson(response));
        response = openService.openLogin(request);
        System.out.println(new Gson().toJson(response));
    }

}
