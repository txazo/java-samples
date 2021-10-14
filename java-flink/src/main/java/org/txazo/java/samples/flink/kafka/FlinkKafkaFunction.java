package org.txazo.java.samples.flink.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.Date;

/**
 * @author tuxiaozhou
 * @date 2021/10/12
 */
public class FlinkKafkaFunction implements WindowFunction<KafkaSource, String, String, TimeWindow> {

    @Override
    public void apply(String key, TimeWindow window, Iterable<KafkaSource> input, Collector<String> ouput) throws Exception {
        System.out.println("flink-kafka-job function key=" + key);

        long count = 0;
        for (KafkaSource source : input) {
            count++;
        }

        KafkaReduce reduce = new KafkaReduce();
        reduce.setPath(key);
        reduce.setCount(count);
        reduce.setWindowStart(new Date(window.getStart()));
        reduce.setWindowEnd(new Date(window.getEnd()));
        ouput.collect(JSON.toJSONString(reduce));
    }

}
