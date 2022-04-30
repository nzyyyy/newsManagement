/*
 Navicat Premium Data Transfer

 Source Server         : linux
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 59.110.216.139:3306
 Source Schema         : newsDB

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 30/04/2022 14:10:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for newInfo
-- ----------------------------
DROP TABLE IF EXISTS `newInfo`;
CREATE TABLE `newInfo`  (
  `newId` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `published` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`newId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newInfo
-- ----------------------------
INSERT INTO `newInfo` VALUES (1, '关键时刻，中央开了一次很不寻常的会议！', '关键时刻，中央开了一次很不寻常的会议！', '一是会议通稿的时间，不是傍晚的新闻联播，而是中午12点半，非常罕见；\r\n\r\n二是会议的用词，新华社通稿从头至尾，强烈的紧迫感和使命感，扑面而来。\r\n\r\n比如，对4月29日这次政治局会议，新华社的报道，开头除了指出今年“成绩来之不易”外，马上就是当下的形势判断：\r\n\r\n会议指出，新冠肺炎疫情和乌克兰危机导致风险挑战增多，我国经济发展环境的复杂性、严峻性、不确定性上升，稳增长、稳就业、稳物价面临新的挑战。做好经济工作、切实保障和改善民生至关重要。要坚定信心、攻坚克难，确保党中央大政方针落实到位。\r\n\r\n今年的形势，确实不容乐观，我相信，大家都很清楚。\r\n\r\n两个最重要的风险挑战：新冠疫情、乌克兰危机。', 1);
INSERT INTO `newInfo` VALUES (5, '上海战“疫” 凡人微光｜方舱里的感动', '抗疫期间，方舱医院是承载希望的“生命之舟”。', '在这里，有人白衣执甲、逆行而上；有人相互帮助、传递温暖；有的人乐观积极、努力生活……\r\n\r\n每个人都可以是一束微光，能够点燃希望。让我们为自己加油，为上海加油。', 1);
INSERT INTO `newInfo` VALUES (6, '页面测试标题', '页面测试简介', '页面测试内容', 1);
INSERT INTO `newInfo` VALUES (7, '新闻3', '新闻描述3', '新闻内容3', 1);
INSERT INTO `newInfo` VALUES (8, '新闻4', '新闻描述4', '新闻内容4', 0);
INSERT INTO `newInfo` VALUES (9, '新闻5', '新闻描述5', '新闻内容5', 1);
INSERT INTO `newInfo` VALUES (12, '这是标题', '这是简介', '这是内容', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `authority` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'user',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `user_email_uindex`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'ningzy1210@gmail.com', '$2a$10$nkyA5r419Nd0nTObDRf6yOuPco/flHA3gcyBFs1UhbdDtmcXVRcpy', 'admin');
INSERT INTO `user` VALUES (4, '212195687@qq.com', '$2a$10$oR/hGP0whEwfT0FhLIPx8ODgIl.oFMvsn8qwhP/.pFaNdMKpUC9ta', 'user');
INSERT INTO `user` VALUES (6, '2890655702@qq.com', '$2a$10$63rUkgwWuNCH0VAeIMelku1k1G.qlVqD4vca7bGHVNs/e2CeIcQXC', 'admin');
INSERT INTO `user` VALUES (7, '123456@qq.com', '$2a$10$XqFgcL1dCsh1brDh.cDj5eOfLdnbRendWsJhRP.ikIaIbYGrkMcOi', 'admin');
INSERT INTO `user` VALUES (8, '123456@163.com', '$2a$10$F.vJq1CfrVQGo4snyHK1jeiZYwoPFHERbyvRXD.O5xyAzv.Xm1k5K', 'user');

SET FOREIGN_KEY_CHECKS = 1;
