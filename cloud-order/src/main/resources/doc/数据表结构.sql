CREATE TABLE `tbl_order` (
  `id`           BIGINT(11) NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `order_no`     VARCHAR(100)        DEFAULT NULL
  COMMENT '订单号',
  `order_amount` DECIMAL(50, 2)      DEFAULT NULL
  COMMENT '订单金额',
  `order_source` VARCHAR(256)        DEFAULT NULL
  COMMENT '订单来源',
  `order_status` VARCHAR(100)        DEFAULT NULL
  COMMENT '订单状态',
  `account_id`   VARCHAR(100)        DEFAULT NULL
  COMMENT '客户id',
  `create_date`  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `update_date`  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',
  `creator`      VARCHAR(100)        DEFAULT NULL
  COMMENT '创建人',
  `updator`      VARCHAR(100)        DEFAULT NULL
  COMMENT '更新人',
  `is_deleted`   VARCHAR(2)          DEFAULT '0'
  COMMENT '是否删除',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 611080
  DEFAULT CHARSET = utf8
  COMMENT = '订单表';

