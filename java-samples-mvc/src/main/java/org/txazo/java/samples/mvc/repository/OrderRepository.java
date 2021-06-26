package org.txazo.java.samples.mvc.repository;

import org.springframework.stereotype.Component;
import org.txazo.java.samples.mvc.entity.OrderDO;
import org.txazo.java.samples.mvc.mapper.OrderMapper;
import org.txazo.java.tools.mvc.mapper.BaseMapper;
import org.txazo.java.tools.mvc.repository.AbstractBaseRepository;

import javax.annotation.Resource;

@Component
public class OrderRepository extends AbstractBaseRepository<OrderDO> {

    @Resource
    private OrderMapper orderMapper;

    @Override
    protected BaseMapper<OrderDO> getMapper() {
        return orderMapper;
    }

}
