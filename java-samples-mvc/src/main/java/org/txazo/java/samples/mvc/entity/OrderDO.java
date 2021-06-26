package org.txazo.java.samples.mvc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDO implements Serializable {

    private Long id;

    private String orderId;

}
