CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号，自增主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `created_by` int(11) NOT NULL COMMENT '创建人',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `updated_by` int(11) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='管理员';

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车添加记录编号，自增主键',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `product_id` int(11) NOT NULL COMMENT '商品编号',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `created_by` int(11) NOT NULL COMMENT '创建人',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  `updated_by` int(11) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='购物车';

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类编号，自增主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0 有效；1 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='商品分类';

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='会员';

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号，自增主键',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `category_id` int(11) NOT NULL COMMENT '商品分类',
  `quantity` int(11) NOT NULL COMMENT '库存',
  `description` varchar(500) NOT NULL COMMENT '描述',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0 有效；1 无效',
  `image_url` varchar(200) NOT NULL COMMENT '商品图片',
  `sale` tinyint(1) NOT NULL DEFAULT '0' COMMENT '上架/下架：0 上架；1 下架',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `created_by` int(11) NOT NULL COMMENT '创建人',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  `updated_by` int(11) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='商品';

CREATE TABLE `product_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号，自增主键',
  `product_id` int(11) NOT NULL COMMENT '商品编号',
  `product_name` varchar(50) NOT NULL COMMENT '商品名称',
  `product_quantity` int(11) NOT NULL DEFAULT '1' COMMENT '商品数量',
  `status` int(11) NOT NULL COMMENT '订单状态：0 有效；1 无效',
  `amount` decimal(10,2) NOT NULL COMMENT '订单金额',
  `consignee_name` varchar(50) NOT NULL COMMENT '收货人姓名',
  `consignee_address` varchar(100) NOT NULL COMMENT '收货人地址',
  `consignee_mobile` varchar(11) NOT NULL COMMENT '收货人手机号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `created_by` int(11) NOT NULL COMMENT '创建人',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  `update_by` int(11) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='订单';
