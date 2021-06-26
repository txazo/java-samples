package org.txazo.java.samples.netty.core.handler;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.txazo.java.samples.netty.core.Request;
import org.txazo.java.samples.netty.core.Response;
import org.txazo.java.samples.netty.core.service.UserService;
import org.txazo.java.samples.netty.core.service.UserServiceImpl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteServiceHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Object> serviceMap = new HashMap<>();
    private ExecutorService executor = Executors.newFixedThreadPool(20);

    public RemoteServiceHandler() {
        serviceMap.put(UserService.class.getName(), new UserServiceImpl());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Request) {
            final Request request = (Request) msg;
            final Channel channel = ctx.channel();
            executor.submit(new Runnable() {

                @Override
                public void run() {
                    long requestId = request.getRequestId();
                    Response response = new Response();
                    response.setResponseId(requestId);

                    try {
                        Object serviceInstance = serviceMap.get(request.getClassType());
                        Method[] methods = serviceInstance.getClass().getMethods();
                        for (Method method : methods) {
                            if (method.getName().equals(request.getMethodName())) {
                                response.setData(JSON.toJSONString(method.invoke(serviceInstance, request.getArgs())));
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.setData(null);
                    }

                    channel.writeAndFlush(response);
                }

            });
        }
    }

}
