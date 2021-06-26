CREATE TABLE `t_biggie_withdraw`
(
    `id`                     bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `guid`                   bigint(20)          NOT NULL DEFAULT '0' COMMENT '大神ID',
    `period`                 varchar(32)         NOT NULL DEFAULT '' COMMENT '活动期数，例如20210218',
    `status`                 int(10)             NOT NULL DEFAULT '0' COMMENT '状态，-1:不符合条件，0:未完成，1:已完成，2:已提现',
    `finished_count`         int(10)             NOT NULL DEFAULT '0' COMMENT '完成订单数',
    `first_complete_time`    datetime            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '首单完成时间',
    `second_complete_time`   datetime            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '第二单完成时间',
    `settlement_time`        datetime            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '预计结算时间',
    `settlement_order_id`    varchar(128)        NOT NULL DEFAULT '' COMMENT '结算订单ID',
    `withdraw_order_no`      varchar(64)         NOT NULL DEFAULT '' COMMENT '支付提现订单号',
    `withdraw_time`          datetime            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '支付提现时间',
    `withdraw_amount`        int(10)             NOT NULL DEFAULT '0' COMMENT '支付提现金额',
    `expect_withdraw_amount` int(10)             NOT NULL DEFAULT '0' COMMENT '预计提现金额',
    `withdraw_push_count`    int(10)             NOT NULL DEFAULT '0' COMMENT '发送提现push次数',
    `create_time`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`            datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE `uniq_guid_period` (`guid`, `period`),
    KEY `idx_settlement_time` (`settlement_time`),
    KEY `idx_withdraw_time` (`withdraw_time`),
    KEY `idx_create_time` (`create_time`),
    KEY `idx_update_time` (`update_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='大神限时提现活动表';

alter table t_biggie_withdraw add column `first_complete_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '首单完成时间' after `finished_count`,
                              add column `second_complete_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '第二单完成时间' after `first_complete_time`,
                              drop index `idx_withdraw_time`,
                              add index `idx_first_complete_time` (`first_complete_time`),
                              add index `idx_second_complete_time` (`second_complete_time`);

alter table t_biggie_withdraw
    add column
        `first_complete_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '首单完成时间' after `finished_count`;
alter table t_biggie_withdraw
    add column
        `second_complete_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '第二单完成时间' after `first_complete_time`;

alter table t_biggie_withdraw
    add index `idx_first_complete_time` (`first_complete_time`);
alter table t_biggie_withdraw
    add index `idx_second_complete_time` (`second_complete_time`);

update t_biggie_withdraw set first_complete_time = '2021-06-19 12:00:00' where guid = 193261000114779797 and period = 'ALL';
update t_biggie_withdraw set status = 1, finished_count = 2,
                             first_complete_time = '2021-06-18 12:00:00',
                             second_complete_time = '2021-06-24 12:00:00',
                             settlement_time = '2021-06-27 12:00:00',
                             settlement_order_id = '',
                             expect_withdraw_amount = 2400
where guid = 200600995116952698 and period = 'ALL';
update t_biggie_withdraw set status = 1, finished_count = 2,
                             first_complete_time = '2021-06-20 12:00:00',
                             second_complete_time = '2021-06-21 12:00:00',
                             settlement_time = '2021-06-24 12:00:00',
                             settlement_order_id = '',
                             expect_withdraw_amount = 2400
where guid = 1833903851300087 and period = 'ALL';
insert into t_biggie_withdraw(guid, period, status, finished_count, first_complete_time, second_complete_time, settlement_time, settlement_order_id, expect_withdraw_amount)
values (202310977441888331, 'ALL', 1, 2, '2021-06-09 12:00:00', '2021-06-10 12:00:00', '2021-06-12 12:00:00', '', 2400);
insert into t_biggie_withdraw(guid, period, status, finished_count, withdraw_time)
values (191410674422080033, 'ALL', 2, 2, '2021-06-25 12:00:00');
update t_biggie_withdraw set status = 0, finished_count = 1,
                             first_complete_time = '2021-06-17 12:00:00' where guid = 191401004312081765 and period = 'ALL';
insert into t_biggie_withdraw(guid, period, status, finished_count, first_complete_time, second_complete_time, settlement_time, settlement_order_id, expect_withdraw_amount)
values (191131043251810037, 'ALL', 1, 2, '2021-06-24 12:00:00', '2021-06-25 12:00:00', '2021-06-28 12:00:00', '', 2400);
