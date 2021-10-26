#### Flink Idea Debug

* 右键`Open Module Settings`
* 选`Libraries`，添加`flink-dist_2.11-1.10.0.jar`

Source -> Transformation -> Sink

#### 时间

* 事件时间
* 提取时间
* 处理时间

#### 窗口

* 滚动窗口
* 滑动窗口

#### 流转换

* filter(): 过滤，FilterFunction、RichFilterFunction
* map(): 一对一转换，MapFunction、RichMapFunction
* flatMap(): 一对多转换，FlatMapFunction、RichFlatMapFunction

#### 分区

* keyBy(): 按key分区
* maxBy()

#### 状态存储

* ValueState
* 状态清除
