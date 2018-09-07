CREATE TABLE `tbl_account` (
  `id`             BIGINT(11) NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `account_no`     VARCHAR(100)        DEFAULT NULL
  COMMENT '客户编号',
  `account_name`   VARCHAR(100)        DEFAULT NULL
  COMMENT '客户名称',
  `account_phone`  VARCHAR(100)        DEFAULT NULL
  COMMENT '客户手机号',
  `account_email`  VARCHAR(100)        DEFAULT NULL
  COMMENT '客户邮箱',
  `account_point`  DECIMAL(50, 2)      DEFAULT NULL
  COMMENT '客户积分',
  `account_amount` DECIMAL(50, 2)      DEFAULT NULL
  COMMENT '账户余额',
  `account_sex`    VARCHAR(2)          DEFAULT NULL
  COMMENT '客户性别',
  `account_status` VARCHAR(100)        DEFAULT NULL
  COMMENT '客户状态',
  `create_date`    TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `update_date`    TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',
  `creator`        VARCHAR(100)        DEFAULT NULL
  COMMENT '创建人',
  `updator`        VARCHAR(100)        DEFAULT NULL
  COMMENT '更新人',
  `is_deleted`     VARCHAR(2)          DEFAULT '0'
  COMMENT '是否删除',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 611080
  DEFAULT CHARSET = utf8
  COMMENT = '客户表';

-- 记录发送的消息
CREATE TABLE `tbl_cap_message` (
  `id`           BIGINT(11) NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `message_no`   VARCHAR(100)        DEFAULT NULL
  COMMENT '消息编号',
  `message_body` VARCHAR(1000)       DEFAULT NULL
  COMMENT '消息体',
  `message_type` VARCHAR(50)         DEFAULT NULL
  COMMENT '消息类型',
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
  COMMENT = '消息表';

-- 消息消费方判断消息是否重复消费
CREATE TABLE `tbl_cap_message_consume` (
  `id`           BIGINT(11) NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `message_no`   VARCHAR(100)        DEFAULT NULL
  COMMENT '消息编号',
  `message_body` VARCHAR(1000)       DEFAULT NULL
  COMMENT '消息体',
  `message_type` VARCHAR(50)         DEFAULT NULL
  COMMENT '消息类型',
  `consume_date` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '消费时间',
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
  COMMENT = '消息消费表';


