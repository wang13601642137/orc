CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号，自增主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `created_by` int(11) NOT NULL COMMENT '创建人',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `updated_by` int(11) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';


CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员编号，自增主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) NOT NULL COMMENT '状态：0 有效；1 无效',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `created_by` int(11) NOT NULL COMMENT '创建人',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `updated_by` int(11) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员';
