package org.txazo.java.samples.netty.core;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -6561824509008461841L;

    private long responseId;
    private String data;

}
