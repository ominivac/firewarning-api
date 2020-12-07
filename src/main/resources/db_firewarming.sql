/*
 Navicat Premium Data Transfer

 Source Server         : mysqlLocal
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : db_firewarming

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 07/12/2020 08:43:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for empresa
-- ----------------------------
DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fantasia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contato` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of empresa
-- ----------------------------
INSERT INTO `empresa` VALUES (1, '4841551551554', 'empresa 1', '85.98783311');
INSERT INTO `empresa` VALUES (2, '1212121212', 'Nacional Gas', '85.345.3213');
INSERT INTO `empresa` VALUES (3, '03373373371264', 'Tropigás', '8532640002');
INSERT INTO `empresa` VALUES (4, '00073372371264', 'Petrolusa', '8532630002');

-- ----------------------------
-- Table structure for empresa_incidentes
-- ----------------------------
DROP TABLE IF EXISTS `empresa_incidentes`;
CREATE TABLE `empresa_incidentes`  (
  `empresa_id` int(11) NOT NULL,
  `incidentes_id` int(11) NOT NULL,
  UNIQUE INDEX `UK_m12m354g4nhqwt1ujw927fvuv`(`incidentes_id`) USING BTREE,
  INDEX `FKbkbhu5j6dstmuirdl4lcnwe56`(`empresa_id`) USING BTREE,
  CONSTRAINT `FKbkbhu5j6dstmuirdl4lcnwe56` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK1cfgtisexoxpyg71li7igrd9m` FOREIGN KEY (`incidentes_id`) REFERENCES `incidente` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (7);

-- ----------------------------
-- Table structure for incidente
-- ----------------------------
DROP TABLE IF EXISTS `incidente`;
CREATE TABLE `incidente`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nivel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comentario` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `empresa_id` int(11) NULL DEFAULT NULL,
  `empresa` tinyblob NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `empresa_id_fk`(`empresa_id`) USING BTREE,
  CONSTRAINT `empresa_id_fk` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKld48608ul7kxoesjsqou6sh1f` FOREIGN KEY (`id`) REFERENCES `empresa` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of incidente
-- ----------------------------
INSERT INTO `incidente` VALUES (1, 'DANGER', 'Explosão de caldeira no setor 1', 'Resolvido', 1, NULL);
INSERT INTO `incidente` VALUES (2, 'WARNING', 'Principio de incêndio próximo à refinaria B1', 'Resolvido', 2, NULL);
INSERT INTO `incidente` VALUES (3, 'DANGER', 'Fogo', 'Perigo', 2, NULL);

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario`  (
  `nome` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tipo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('Roberto Sousa', 'robertokbs@gmail.com', 'Admin', 1);
INSERT INTO `usuario` VALUES ('Maria Clara', 'm_clara@yahoo.com', 'Sistema', 2);
INSERT INTO `usuario` VALUES ('Claudio Maciel', 'cladio_m@gmail.com', 'População', 3);
INSERT INTO `usuario` VALUES ('Ana Ferreirra', 'anafer@yahoo.com', 'População', 4);
INSERT INTO `usuario` VALUES ('Fernanda Gentil', 'fernanda_gentil3993@gmail.com', 'Sistema', 6);

SET FOREIGN_KEY_CHECKS = 1;
