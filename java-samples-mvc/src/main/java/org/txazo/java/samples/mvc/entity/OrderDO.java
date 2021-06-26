package org.txazo.java.samples.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("orderDO")
public class OrderDO implements Serializable {

    private Long id;

    private String orderId;

    private Long buyerId;

}
