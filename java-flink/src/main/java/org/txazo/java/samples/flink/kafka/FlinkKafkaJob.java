package org.txazo.java.samples.flink.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

/**
 * @author tuxiaozhou
 * @date 2021/10/12
 */
public class FlinkKafkaJob {

    public static void main(String[] args) throws Exception {
        // Stream执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Kafka输入流
        DataStream<String> stream = env.addSource(new FlinkKafkaConsumer<>(
                "flink-kafka-input-topic",
                new SimpleStringSchema(),
                buildKafkaConsumerProperties()
        )).name("flink-kafka-source");

        // reduce流
        DataStream<String> reduceStream = stream.map(FlinkKafkaJob::map)
                .keyBy(KafkaSource::getPath)
                .timeWindow(Time.seconds(10))
                .apply(new FlinkKafkaFunction())
                .name("flink-kafka-reduce");

        // 输出流
        reduceStream.addSink(new FlinkKafkaProducer<>(
                "flink-kafka-ouput-topic",
                new SimpleStringSchema(),
                buildKafkaProducerProperties()
        )).name("flink-kafka-sink");

        System.out.println("flink-kafka-job start");
        env.execute("flink-kafka-job");
    }

    private static KafkaSource map(String source) {
        System.out.println("flink-kafka-job receive kafka message " + source);
        return JSON.parseObject(source, KafkaSource.class);
    }

    private static Properties buildKafkaConsumerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "flink-kafka-group");
        return props;
    }

    private static Properties buildKafkaProducerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        return props;
    }

}
