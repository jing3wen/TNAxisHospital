/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 02/11/2021 15:17:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DATE` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
  `USER_PHONE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REGISTRATION_ID` int(0) NULL DEFAULT NULL COMMENT '号码id',
  `DEPARTMENT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (7, '2021-10-30 21:04:22', '12345678910', 3, '内科');
INSERT INTO `order` VALUES (9, '2021-10-30 21:05:29', '12345678913', 3, '内科');
INSERT INTO `order` VALUES (10, '2021-10-30 23:59:35', '12345678916', 3, '外科');
INSERT INTO `order` VALUES (11, '2021-10-31 09:07:48', '12345678915', 3, '外科');
INSERT INTO `order` VALUES (12, '2021-10-31 09:08:03', '12345678918', 3, '外科');
INSERT INTO `order` VALUES (13, '2021-10-31 09:09:10', '12345678917', 3, '外科');
INSERT INTO `order` VALUES (17, '2021-10-31 18:41:59', '12345678910', 3, '外科');
INSERT INTO `order` VALUES (21, '2021-11-02 14:27:49', '213124', 5, '外科');
INSERT INTO `order` VALUES (25, '2021-11-02 15:05:51', '13755683487', 5, '外科');
INSERT INTO `order` VALUES (26, '2021-11-02 15:05:53', '13755683487', 5, '外科');
INSERT INTO `order` VALUES (27, '2021-11-02 15:05:54', '13755683487', 5, '外科');
INSERT INTO `order` VALUES (28, '2021-11-02 15:05:55', '13755683487', 5, '外科');
INSERT INTO `order` VALUES (29, '2021-11-02 15:08:20', '13755683487', 5, '外科');

-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DATE` date NULL DEFAULT NULL COMMENT '日期',
  `DEPARTMENT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `REMAINING` int(0) NULL DEFAULT NULL COMMENT '号码剩余个数',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '号码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of registration
-- ----------------------------
INSERT INTO `registration` VALUES (1, '2021-07-22', '外科', 19);
INSERT INTO `registration` VALUES (2, '2021-10-30', '内科', 7);
INSERT INTO `registration` VALUES (3, '2021-10-31', '外科', 5);
INSERT INTO `registration` VALUES (4, '2021-10-31', '内科', 0);
INSERT INTO `registration` VALUES (5, '2021-11-02', '外科', 306);
INSERT INTO `registration` VALUES (6, '2021-11-02', '内科', 0);

SET FOREIGN_KEY_CHECKS = 1;
