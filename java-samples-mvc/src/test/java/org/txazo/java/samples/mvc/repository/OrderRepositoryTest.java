package org.txazo.java.samples.mvc.repository;

import org.junit.Test;
import org.txazo.java.samples.mvc.AbstractTest;
import org.txazo.java.samples.mvc.entity.OrderDO;

import javax.annotation.Resource;

public class OrderRepositoryTest extends AbstractTest {

    @Resource
    private OrderRepository orderRepository;

    @Test
    public void add() {
        OrderDO orderDO = OrderDO.builder()
                .orderId("2021062100001")
                .build();
        orderRepository.add(orderDO);
    }

}
