CREATE TABLE `tbl_param` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `param_type` varchar(100) DEFAULT NULL COMMENT '参数类型',
  `param_code` varchar(100) DEFAULT NULL COMMENT '参数code',
  `param_value` varchar(256) DEFAULT NULL COMMENT '参数值',
  `param_url` varchar(1024) DEFAULT NULL COMMENT '参数url',
  `param_desc` varchar(256) DEFAULT NULL COMMENT '参数描述',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(100) DEFAULT NULL COMMENT '创建人',
  `updator` varchar(100) DEFAULT NULL COMMENT '更新人',
  `is_deleted` varchar(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=611080 DEFAULT CHARSET=utf8 COMMENT='参数表';

