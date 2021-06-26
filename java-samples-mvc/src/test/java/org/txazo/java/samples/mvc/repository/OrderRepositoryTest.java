package org.txazo.java.samples.mvc.repository;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.txazo.java.samples.mvc.AbstractTest;
import org.txazo.java.samples.mvc.entity.OrderDO;
import org.txazo.java.tools.mvc.common.Query;
import org.txazo.java.tools.mvc.result.PageResult;

import javax.annotation.Resource;
import java.util.List;

public class OrderRepositoryTest extends AbstractTest {

    @Resource
    private OrderRepository orderRepository;

    @Test
    public void add() {
        OrderDO orderDO = OrderDO.builder()
                .orderId("2021062100002")
                .build();
        Assert.assertEquals(1, orderRepository.add(orderDO));
    }

    @Test
    public void update() {
        OrderDO orderDO = OrderDO.builder()
                .id(1L)
                .buyerId(1000L)
                .build();
        Assert.assertEquals(1, orderRepository.update(orderDO));
    }

    @Test
    public void delete() {
        Assert.assertEquals(1, orderRepository.delete(1L));
    }

    @Test
    public void get() {
        OrderDO orderDO = orderRepository.get(1L);
        Assert.assertNotNull(orderDO);
    }

    @Test
    public void getList() {
        List<OrderDO> orderDOList = orderRepository.getList(
                Lists.newArrayList(1L, 2L)
        );
        Assert.assertTrue(orderDOList != null && orderDOList.size() > 1);
    }

    @Test
    public void query() {
        Query query = Query.newBuilder()
                .whereEquals("buyer_id", 1234L)
                .whereSql("id >", 3L)
                .orderBy("create_time", "desc")
                .page(1, 10);
        PageResult<OrderDO> pageResult = orderRepository.query(query);
        Assert.assertTrue(pageResult != null && pageResult.getList() != null);
    }

}
