/*
 Navicat Premium Data Transfer

 Source Server         : MY
 Source Server Type    : MySQL
 Source Server Version : 50720 (5.7.20)
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50720 (5.7.20)
 File Encoding         : 65001

 Date: 19/08/2023 16:28:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dp_admin
-- ----------------------------
DROP TABLE IF EXISTS `dp_admin`;
CREATE TABLE `dp_admin`  (
  `adminName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dp_admin
-- ----------------------------
INSERT INTO `dp_admin` VALUES ('admin', 'ynuadmin', 1);

-- ----------------------------
-- Table structure for dp_car
-- ----------------------------
DROP TABLE IF EXISTS `dp_car`;
CREATE TABLE `dp_car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_Id` int(11) NULL DEFAULT NULL,
  `productname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dp_car
-- ----------------------------

-- ----------------------------
-- Table structure for dp_product
-- ----------------------------
DROP TABLE IF EXISTS `dp_product`;
CREATE TABLE `dp_product`  (
  `product_id` int(12) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manufacturer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `production_date` datetime(6) NULL DEFAULT NULL,
  `model` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `retail_price` decimal(10, 2) NULL DEFAULT NULL,
  `quantity` int(30) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dp_product
-- ----------------------------
INSERT INTO `dp_product` VALUES (2, 'Raspberwy ice', 'myself', '2023-04-24 00:00:00.000000', '行李', 125.00, 555.00, 1890);
INSERT INTO `dp_product` VALUES (3, 'Chelry air', 'Rice Brothers Engineering LLC', '2023-06-25 21:04:17.000000', '宠物用品', 132.51, 343.45, 302);
INSERT INTO `dp_product` VALUES (4, 'Strawberry', 'Ho Yin Electronic Limited', '2023-07-05 05:13:49.000000', 'Industrial', 401.96, 1380.69, 465);
INSERT INTO `dp_product` VALUES (5, 'Rambutan core', 'Mui Kee Logistic Limited', '2022-12-21 18:56:05.000000', '收藏品及美术用品', 204.88, 490.87, 326);
INSERT INTO `dp_product` VALUES (7, 'Cherry air', '晓明发展贸易有限责任公司', '2023-08-02 15:34:16.000000', 'Health & B', 379.10, 629.56, 627);
INSERT INTO `dp_product` VALUES (8, 'fiwi se', 'Wing Fat Toy Limited', '2022-11-05 00:00:00.000000', '手工制作', 281.00, 343.06, 881);
INSERT INTO `dp_product` VALUES (9, 'Rambutan pi', 'Ku Kee Limited', '2023-05-14 14:02:24.000000', 'Industrial', 298.01, 544.56, 580);
INSERT INTO `dp_product` VALUES (10, 'Kiwi', 'Kwok Kuen Pharmaceutical Limited', '2023-03-12 14:10:41.000000', 'Computers ', 898.99, 1480.16, 290);
INSERT INTO `dp_product` VALUES (11, 'Apppe', 'Edward LLC', '2023-04-08 00:00:00.000000', '玩具与游戏', 990.06, 1330.22, 10);
INSERT INTO `dp_product` VALUES (12, 'Orange', 'Ronald Consultants Inc.', '2023-04-05 08:09:13.000000', 'Centurion ', 193.72, 284.54, 267);
INSERT INTO `dp_product` VALUES (13, 'Kidi air', 'Chi Yuen Telecommunication Limited', '2023-06-03 10:05:14.000000', '保健，家庭及婴儿护理', 366.67, 755.01, 551);
INSERT INTO `dp_product` VALUES (14, 'Pluots', 'Leonard Electronic LLC', '2022-12-06 00:00:00.000000', 'Tools & Ho', 792.01, 1365.00, 458);
INSERT INTO `dp_product` VALUES (15, 'Grape', '岚通讯有限责任公司', '2022-12-17 23:40:59.000000', '收藏品及美术用品', 61.69, 86.69, 176);
INSERT INTO `dp_product` VALUES (16, 'Rambutan', 'Shing Kee Industrial Limited', '2023-04-26 15:59:22.000000', '手工制作', 864.77, 1239.00, 445);
INSERT INTO `dp_product` VALUES (17, 'iqherry', 'Donna Inc.', '2023-06-04 07:48:17.000000', '花园与户外', 474.00, 1322.64, 181);
INSERT INTO `dp_product` VALUES (18, 'Grape pi', 'Sum Wing Electronic Limited', '2022-10-14 11:44:45.000000', '行李及旅行装备', 368.49, 1035.38, 404);
INSERT INTO `dp_product` VALUES (22, '三星pad', '三星', '2023-06-06 00:00:00.000000', '电子产品', 2000.00, 4500.00, 91);
INSERT INTO `dp_product` VALUES (23, 'coal', '可口可乐', '2023-08-16 00:00:00.000000', '饮料', 1.50, 3.00, 1000);
INSERT INTO `dp_product` VALUES (24, 'pear', 'farmer', '2023-06-06 00:00:00.000000', 'food', 2.50, 89.00, 100);
INSERT INTO `dp_product` VALUES (25, 'applepad', 'iphone', '2023-12-31 00:00:00.000000', 'food', 10999.00, 20000.00, 15);

-- ----------------------------
-- Table structure for dp_user
-- ----------------------------
DROP TABLE IF EXISTS `dp_user`;
CREATE TABLE `dp_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_costmoney` float NULL DEFAULT NULL,
  `registrationDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dp_user
-- ----------------------------
INSERT INTO `dp_user` VALUES (2, 'shiaoi', '7890wes', '银', '838-214-6420', 'wingfat1@gmail.com', 8308.08, '2023-08-16 20:19:52');
INSERT INTO `dp_user` VALUES (3, 'huang6', 'GCab4PTxft', '银', '330-081-3185', 'josek@gmail.com', 860.28, '2018-02-17 05:18:53');
INSERT INTO `dp_user` VALUES (6, 'cheryl79', 'p5JCuo27WD', '银', '838-873-2463', 'jcastro@gmail.com', 67.39, '2023-08-16 20:20:05');
INSERT INTO `dp_user` VALUES (7, 'takagimio', 'cjY1sFWaTM', '铜', '213-886-1895', 'ikki3@gmail.com', 146.46, '2010-10-16 05:16:19');
INSERT INTO `dp_user` VALUES (8, 'yuniy', 'da3wRw8LeF', '银', '838-223-5206', 'xiao4@gmail.com', 921.41, '2006-11-08 03:06:25');
INSERT INTO `dp_user` VALUES (9, 'noguchi10', 'nI85XcIaiZ', '铜', '212-597-3104', 'watmi816@gmail.com', 151.98, '2004-11-22 06:55:38');
INSERT INTO `dp_user` VALUES (11, '1234', '1234', '铜', '12344', '1234@qq.com', 0, '2023-08-17 15:38:27');
INSERT INTO `dp_user` VALUES (13, 'xiexieni', '125666666', '铜', '123456-88', '2834@qq.com', 0, '2023-08-18 22:50:17');
INSERT INTO `dp_user` VALUES (14, 'yuency', 'sssssssssss44', '铜', '123456', '2834@qq.com', 0, '2023-08-19 15:46:43');
INSERT INTO `dp_user` VALUES (15, 'cheshi', 'maybe123', '铜', '123-223-21', 'xie2890@gmail.com', 9318.42, '2023-08-19 16:09:03');

SET FOREIGN_KEY_CHECKS = 1;
