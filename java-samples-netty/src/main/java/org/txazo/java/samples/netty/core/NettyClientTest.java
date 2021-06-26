package org.txazo.java.samples.netty.core;

import org.txazo.java.samples.netty.core.client.NettyClientProxy;
import org.txazo.java.samples.netty.core.service.UserService;

public class NettyClientTest {

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        client.start();
        NettyClientProxy<UserService> clientProxy = new NettyClientProxy(UserService.class, client.getChannel());
        UserService userService = clientProxy.getRemoteProxy();

        System.out.println(userService.getUser(1));

//        AtomicInteger counter = new AtomicInteger(1);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<CompletableFuture> tasks = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tasks.add(CompletableFuture.runAsync(() -> {
//                while (true) {
//                    System.out.println(userService.getUser(counter.getAndIncrement()));
//                }
//            }, executorService));
//        }
//
//        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[]{})).join();
    }

}
