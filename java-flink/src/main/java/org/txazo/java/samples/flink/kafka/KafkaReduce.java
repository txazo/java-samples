package org.txazo.java.samples.flink.kafka;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tuxiaozhou
 * @date 2021/10/12
 */
@Data
public class KafkaReduce implements Serializable {

    private String path;

    private Long count;

    private Date windowStart;

    private Date windowEnd;

}
