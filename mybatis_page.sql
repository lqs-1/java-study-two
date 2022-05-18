/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.56.101:3306
 Source Schema         : mybatis_page

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 29/04/2022 16:11:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES (1, 'lqs', 12);
INSERT INTO `page` VALUES (2, '1', 10);
INSERT INTO `page` VALUES (3, '1', 10);
INSERT INTO `page` VALUES (4, '1', 10);
INSERT INTO `page` VALUES (5, '1', 10);
INSERT INTO `page` VALUES (6, '1', 10);
INSERT INTO `page` VALUES (7, '1', 10);
INSERT INTO `page` VALUES (8, '1', 10);
INSERT INTO `page` VALUES (9, '1', 10);
INSERT INTO `page` VALUES (10, '1', 10);
INSERT INTO `page` VALUES (11, '1', 10);
INSERT INTO `page` VALUES (12, '1', 10);
INSERT INTO `page` VALUES (13, '1', 10);
INSERT INTO `page` VALUES (14, '1', 10);
INSERT INTO `page` VALUES (15, '1', 10);
INSERT INTO `page` VALUES (16, '1', 10);
INSERT INTO `page` VALUES (17, '1', 10);
INSERT INTO `page` VALUES (18, '1', 10);
INSERT INTO `page` VALUES (19, '1', 10);
INSERT INTO `page` VALUES (20, '1', 10);
INSERT INTO `page` VALUES (21, '1', 10);
INSERT INTO `page` VALUES (22, '1', 10);
INSERT INTO `page` VALUES (23, '1', 10);
INSERT INTO `page` VALUES (24, '1', 10);
INSERT INTO `page` VALUES (25, '1', 10);
INSERT INTO `page` VALUES (26, '1', 10);
INSERT INTO `page` VALUES (27, '1', 10);
INSERT INTO `page` VALUES (28, '1', 10);
INSERT INTO `page` VALUES (29, '1', 10);
INSERT INTO `page` VALUES (30, '1', 10);
INSERT INTO `page` VALUES (31, '1', 10);
INSERT INTO `page` VALUES (32, '1', 10);
INSERT INTO `page` VALUES (33, '1', 10);
INSERT INTO `page` VALUES (34, '1', 10);
INSERT INTO `page` VALUES (35, '1', 10);
INSERT INTO `page` VALUES (36, '1', 10);
INSERT INTO `page` VALUES (37, '1', 10);
INSERT INTO `page` VALUES (38, '1', 10);
INSERT INTO `page` VALUES (39, '1', 10);
INSERT INTO `page` VALUES (40, '1', 10);
INSERT INTO `page` VALUES (41, '1', 10);
INSERT INTO `page` VALUES (42, '1', 10);
INSERT INTO `page` VALUES (43, '1', 10);
INSERT INTO `page` VALUES (44, '1', 10);
INSERT INTO `page` VALUES (45, '1', 10);
INSERT INTO `page` VALUES (46, '1', 10);
INSERT INTO `page` VALUES (47, '1', 10);
INSERT INTO `page` VALUES (48, '1', 10);
INSERT INTO `page` VALUES (49, '1', 10);
INSERT INTO `page` VALUES (50, '1', 10);
INSERT INTO `page` VALUES (51, '1', 10);
INSERT INTO `page` VALUES (52, '1', 10);
INSERT INTO `page` VALUES (53, '1', 10);
INSERT INTO `page` VALUES (54, '1', 10);
INSERT INTO `page` VALUES (55, '1', 10);
INSERT INTO `page` VALUES (56, '1', 10);
INSERT INTO `page` VALUES (57, '1', 10);
INSERT INTO `page` VALUES (58, '1', 10);
INSERT INTO `page` VALUES (59, '1', 10);
INSERT INTO `page` VALUES (60, '1', 10);
INSERT INTO `page` VALUES (61, '1', 10);
INSERT INTO `page` VALUES (62, '1', 10);
INSERT INTO `page` VALUES (63, '1', 10);
INSERT INTO `page` VALUES (64, '1', 10);
INSERT INTO `page` VALUES (65, '1', 10);
INSERT INTO `page` VALUES (66, '1', 10);
INSERT INTO `page` VALUES (67, '1', 10);
INSERT INTO `page` VALUES (68, '1', 10);
INSERT INTO `page` VALUES (69, '1', 10);
INSERT INTO `page` VALUES (70, '1', 10);
INSERT INTO `page` VALUES (71, '1', 10);
INSERT INTO `page` VALUES (72, '1', 10);
INSERT INTO `page` VALUES (73, '1', 10);
INSERT INTO `page` VALUES (74, '1', 10);
INSERT INTO `page` VALUES (75, '1', 10);
INSERT INTO `page` VALUES (76, '1', 10);
INSERT INTO `page` VALUES (77, '1', 10);
INSERT INTO `page` VALUES (78, '1', 10);
INSERT INTO `page` VALUES (79, '1', 10);
INSERT INTO `page` VALUES (80, '1', 10);
INSERT INTO `page` VALUES (81, '1', 10);
INSERT INTO `page` VALUES (82, '1', 10);
INSERT INTO `page` VALUES (83, '1', 10);
INSERT INTO `page` VALUES (84, '1', 10);
INSERT INTO `page` VALUES (85, '1', 10);
INSERT INTO `page` VALUES (86, '1', 10);
INSERT INTO `page` VALUES (87, '1', 10);
INSERT INTO `page` VALUES (88, '1', 10);
INSERT INTO `page` VALUES (89, '1', 10);
INSERT INTO `page` VALUES (90, '1', 10);
INSERT INTO `page` VALUES (91, '1', 10);
INSERT INTO `page` VALUES (92, '1', 10);
INSERT INTO `page` VALUES (93, '1', 10);
INSERT INTO `page` VALUES (94, '1', 10);
INSERT INTO `page` VALUES (95, '1', 10);
INSERT INTO `page` VALUES (96, '1', 10);
INSERT INTO `page` VALUES (97, '1', 10);
INSERT INTO `page` VALUES (98, '1', 10);
INSERT INTO `page` VALUES (99, '1', 10);
INSERT INTO `page` VALUES (100, '1', 10);
INSERT INTO `page` VALUES (101, '1', 10);
INSERT INTO `page` VALUES (102, '1', 10);
INSERT INTO `page` VALUES (103, '1', 10);
INSERT INTO `page` VALUES (104, '1', 10);
INSERT INTO `page` VALUES (105, '1', 10);
INSERT INTO `page` VALUES (106, '1', 10);
INSERT INTO `page` VALUES (107, '1', 10);
INSERT INTO `page` VALUES (108, '1', 10);
INSERT INTO `page` VALUES (109, '1', 10);
INSERT INTO `page` VALUES (110, '1', 10);
INSERT INTO `page` VALUES (111, '1', 10);
INSERT INTO `page` VALUES (112, '1', 10);
INSERT INTO `page` VALUES (113, '1', 10);
INSERT INTO `page` VALUES (114, '1', 10);
INSERT INTO `page` VALUES (115, '1', 10);

SET FOREIGN_KEY_CHECKS = 1;
