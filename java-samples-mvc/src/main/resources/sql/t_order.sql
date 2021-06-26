DROP TABLE `t_order`;

CREATE TABLE `t_order`
(
    `id`                     bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `order_id`               varchar(32)         NOT NULL DEFAULT '' COMMENT '订单ID',
    `buyer_id`               bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '买家ID',
    `create_time`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE `uniq_order_id` (`order_id`),
    KEY `idx_create_time` (`create_time`),
    KEY `idx_update_time` (`update_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单表';
