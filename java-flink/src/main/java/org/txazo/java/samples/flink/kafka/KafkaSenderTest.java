package org.txazo.java.samples.flink.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;

/**
 * @author tuxiaozhou
 * @date 2021/10/12
 */
public class KafkaSenderTest {

    private static final String[] PATH_SET = new String[]{"/index", "/user", "/home", "/order"};

    /**
     * brew install kafka
     * cd /usr/local/Cellar/kafka/3.0.0
     * zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
     * kafka-server-start /usr/local/etc/kafka/server.properties
     * kafka-topics --create --bootstrap-server 127.0.0.1:9092 --replication-factor 1 --partitions 1 --topic flink-kafka-input-topic
     * kafka-topics --create --bootstrap-server 127.0.0.1:9092 --replication-factor 1 --partitions 1 --topic flink-kafka-ouput-topic
     * kafka-topics --list --bootstrap-server 127.0.0.1:9092
     * <p>
     * kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic flink-kafka-input-topic --from-beginning
     * kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic flink-kafka-ouput-topic --from-beginning
     */
    public static void main(String[] args) throws Exception {
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(buildKafkaProducerProperties());
        while (true) {
            sendKafkaSource(kafkaProducer);
            Thread.sleep(RandomUtils.nextInt(1, 1000));
        }
    }

    private static void sendKafkaSource(KafkaProducer<String, String> kafkaProducer) {
        KafkaSource kafkaSource = new KafkaSource();
        kafkaSource.setPath(PATH_SET[RandomUtils.nextInt(0, PATH_SET.length)]);
        kafkaSource.setTimestamp(new Date());
        ProducerRecord<String, String> record = new ProducerRecord<>("flink-kafka-input-topic", JSON.toJSONString(kafkaSource));
        kafkaProducer.send(record);
    }

    private static Properties buildKafkaProducerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "flink-kafka-group");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

}
