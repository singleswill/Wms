/*
 Navicat Premium Data Transfer

 Source Server         : 16.16.16.134
 Source Server Type    : MySQL
 Source Server Version : 50741
 Source Host           : 16.16.16.134:3306
 Source Schema         : wms

 Target Server Type    : MySQL
 Target Server Version : 50741
 File Encoding         : 65001

 Date: 27/06/2023 10:50:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` int(11) NOT NULL COMMENT '商品id（身份标识）',
  `record_time` datetime(0) NOT NULL COMMENT '出库时间',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '消息正文',
  `read_status` int(1) NOT NULL COMMENT '阅读状态（0-未读，1-已读）',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, '2023-06-27 10:05:47', 'c测试', 1);

-- ----------------------------
-- Table structure for wms_goods
-- ----------------------------
DROP TABLE IF EXISTS `wms_goods`;
CREATE TABLE `wms_goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID（身份标识）',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `goods_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `goods_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品规格',
  `goods_price` double(20, 0) NOT NULL DEFAULT 0 COMMENT '商品单价',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_goods
-- ----------------------------
INSERT INTO `wms_goods` VALUES (1, 'iphone17', '手机', '1', 1000);
INSERT INTO `wms_goods` VALUES (2, 'iphone15', '手机', '1', 6000);

-- ----------------------------
-- Table structure for wms_ledger
-- ----------------------------
DROP TABLE IF EXISTS `wms_ledger`;
CREATE TABLE `wms_ledger`  (
  `ledger_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `resp_id` int(11) NOT NULL COMMENT '仓库id',
  `number` int(11) NOT NULL COMMENT '交易数量',
  `record_time` datetime(0) NULL DEFAULT NULL COMMENT '入库/出库时间',
  `record_status` int(1) NOT NULL COMMENT '入库/出库（0-出库，1-入库）',
  PRIMARY KEY (`ledger_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_ledger
-- ----------------------------
INSERT INTO `wms_ledger` VALUES (1, 1, 1, 200, '2023-06-25 21:34:33', 0);
INSERT INTO `wms_ledger` VALUES (2, 1, 1, 2, '2023-06-27 09:46:09', 1);

-- ----------------------------
-- Table structure for wms_resp_goods
-- ----------------------------
DROP TABLE IF EXISTS `wms_resp_goods`;
CREATE TABLE `wms_resp_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resp_id` int(11) NOT NULL COMMENT '仓库id',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_resp_goods
-- ----------------------------
INSERT INTO `wms_resp_goods` VALUES (1, 1, 200, 1);

-- ----------------------------
-- Table structure for wms_resposity
-- ----------------------------
DROP TABLE IF EXISTS `wms_resposity`;
CREATE TABLE `wms_resposity`  (
  `resp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库id',
  `resp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库名称',
  `resp_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  PRIMARY KEY (`resp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_resposity
-- ----------------------------
INSERT INTO `wms_resposity` VALUES (1, '北京', '北京海淀区');

SET FOREIGN_KEY_CHECKS = 1;
