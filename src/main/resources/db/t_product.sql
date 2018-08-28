CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `name` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '产品名称',
  `type` int(1) DEFAULT NULL COMMENT '产品类型',
  `price` double(10,2) DEFAULT NULL COMMENT '产品价格',
  `discount` double(3,2) DEFAULT NULL COMMENT '折扣',
  `manufacturer` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '生产厂家',
  `sales` int(10) DEFAULT NULL COMMENT '销量',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  `description` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '产品描述',
  `img1` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片1路径',
  `img2` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片2路径',
  `img3` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片3路径',
  `img4` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片4路径',
  `img5` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片5路径',
  `img6` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片6路径',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '创建人',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `updateBy` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

