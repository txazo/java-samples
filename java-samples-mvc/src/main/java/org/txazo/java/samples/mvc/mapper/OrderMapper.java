package org.txazo.java.samples.mvc.mapper;

import org.springframework.stereotype.Repository;
import org.txazo.java.samples.mvc.entity.OrderDO;
import org.txazo.java.tools.mvc.mapper.BaseMapper;

@Repository
public interface OrderMapper extends BaseMapper<OrderDO> {
}
