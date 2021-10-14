package org.txazo.java.samples.spring.feign;

import com.google.gson.Gson;
import com.netflix.client.ClientFactory;
import com.netflix.client.config.IClientConfig;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import feign.Client;
import feign.Request;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.hystrix.HystrixFeign;
import feign.okhttp.OkHttpClient;
import feign.ribbon.LBClient;
import feign.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author tuxiaozhou
 * @date 2021/10/1
 */
@Configuration
public class FeignHystrixClientConfig {

    @Resource
    private Gson gson;

    public FeignHystrixClientConfig() throws Exception {
        // 加载open-service.properties
        ConfigurationManager.loadPropertiesFromResources("open-service.properties");
    }

    @Bean
    public okhttp3.OkHttpClient okHttp3Client() {
        return new okhttp3.OkHttpClient();
    }

    @Bean
    public OkHttpClient okHttpClient(okhttp3.OkHttpClient okHttp3Client) {
        return new OkHttpClient(okHttp3Client);
    }

    @Bean
    public RibbonClient ribbonClient(OkHttpClient okHttpClient) {
        return RibbonClient.builder()
                .delegate(okHttpClient)
                .lbClientFactory(clientName -> {
                    IClientConfig config = ClientFactory.getNamedConfig(clientName);
                    ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);
                    ZoneAwareLoadBalancer<? extends Server> zb = (ZoneAwareLoadBalancer<? extends Server>) lb;
                    zb.setRule(new RandomRule());
                    return LBClient.create(lb, config);
                })
                .build();
    }

    @Bean
    public OpenService openService(RibbonClient ribbonClient) {
        return buildFeignClient(ribbonClient, OpenService.class, "http://open-service/");
    }

    public <T> T buildFeignClient(Client client, Class<T> apiType, String url) {
        // Feign替换为HystrixFeign
        return HystrixFeign.builder()
                .client(client)
                .encoder(new GsonEncoder(gson))
                .decoder(new GsonDecoder(gson))
                .options(new Request.Options(1000, 3000))
                .retryer(new Retryer.Default(100, 1000, 3))
                .target(apiType, url);
    }

}
