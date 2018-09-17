/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : ft

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-09-17 21:55:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dic
-- ----------------------------
DROP TABLE IF EXISTS `t_dic`;
CREATE TABLE `t_dic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典表ID',
  `value` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类型值',
  `label` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类型名称',
  `type` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类型',
  `name` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '字典名称',
  `delFlag` int(1) DEFAULT '1' COMMENT '数据是否有效:1 有效 0 删除',
  `createBy` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '创建者',
  `createDate` datetime DEFAULT NULL COMMENT '创建日期',
  `updateBy` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  `updateDate` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of t_dic
-- ----------------------------
INSERT INTO `t_dic` VALUES ('1', '1', '销量最高', 'level', '产品优先级', '1', '1', '2018-09-12 16:49:13', '1', '2018-09-12 16:51:02');
INSERT INTO `t_dic` VALUES ('2', '2', '推荐产品', 'level', '产品优先级', '1', '1', '2018-09-12 16:49:13', '1', '2018-09-12 16:50:09');
INSERT INTO `t_dic` VALUES ('3', '3', '常规产品', 'level', '产品优先级', '1', '1', '2018-09-12 16:49:13', '1', '2018-09-12 16:50:57');
INSERT INTO `t_dic` VALUES ('4', '4', '下架产品', 'level', '产品优先级', '1', '1', '2018-09-17 21:20:34', '1', '2018-09-17 21:22:11');
