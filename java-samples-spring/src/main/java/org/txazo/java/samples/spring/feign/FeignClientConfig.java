package org.txazo.java.samples.spring.feign;

import com.google.gson.Gson;
import feign.Client;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author tuxiaozhou
 * @date 2021/10/1
 */
//@Configuration
public class FeignClientConfig {

    @Resource
    private Gson gson;

    @Bean
    public okhttp3.OkHttpClient okHttp3Client() {
        return new okhttp3.OkHttpClient();
    }

    @Bean
    public OkHttpClient okHttpClient(okhttp3.OkHttpClient okHttp3Client) {
        return new OkHttpClient(okHttp3Client);
    }

    @Bean
    public OpenService openService(OkHttpClient okHttpClient) {
        return buildFeignClient(okHttpClient, OpenService.class, "http://127.0.0.1:8080");
    }

    public <T> T buildFeignClient(Client client, Class<T> apiType, String url) {
        return Feign.builder()
                .client(client)
                .encoder(new GsonEncoder(gson))
                .decoder(new GsonDecoder(gson))
                .options(new Request.Options(1000, 3000))
                .retryer(new Retryer.Default(100, 1000, 3))
                .target(apiType, url);
    }

}
