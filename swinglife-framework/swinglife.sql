/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50620
 Source Host           : localhost
 Source Database       : lepu

 Target Server Version : 50620
 File Encoding         : utf-8

 Date: 04/29/2016 10:33:42 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `hibernate_sequence`
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES ('1'), ('1');
COMMIT;

-- ----------------------------
--  Table structure for `t_system_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_menu`;
CREATE TABLE `t_system_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_system_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_menu` VALUES ('9', '2016-04-27 22:57:57', '2016-04-28 16:04:46', '系统管理', '#', '系统管理菜单', '0', 'fa-desktop', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_system_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_permission`;
CREATE TABLE `t_system_permission` (
  `id` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  `systemMenu_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5a8gytlvm0an1yqkq5sputywd` (`systemMenu_id`),
  KEY `FKp0v6jppquqix071dd3hi51nk2` (`menuId`),
  CONSTRAINT `FK5a8gytlvm0an1yqkq5sputywd` FOREIGN KEY (`systemMenu_id`) REFERENCES `t_system_menu` (`id`),
  CONSTRAINT `FKp0v6jppquqix071dd3hi51nk2` FOREIGN KEY (`menuId`) REFERENCES `t_system_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `t_system_permission`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_permission` VALUES ('1', null, null, null, '1', null, '/home', '/home', null, null, '/home', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_system_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `t_system_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_role` VALUES ('1', null, null, '管理员', '管理员', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_system_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role_menu`;
CREATE TABLE `t_system_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_system_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_role_menu` VALUES ('57', '9', '1', null, '0'), ('58', '10', '1', null, '9');
COMMIT;

-- ----------------------------
--  Table structure for `t_system_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role_permission`;
CREATE TABLE `t_system_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `t_system_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `t_system_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_user` VALUES ('1', null, null, '123', 'admin', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_system_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user_role`;
CREATE TABLE `t_system_user_role` (
  `id` int(11) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q66dfvmpy2ww5ku0um356r3bo` (`roleId`),
  UNIQUE KEY `UK_t0kjxfahny12ospx222fndxuy` (`userId`),
  CONSTRAINT `FK2lykdvfnhud5i1vt68bhtj5jp` FOREIGN KEY (`userId`) REFERENCES `t_system_user` (`id`),
  CONSTRAINT `FKosb86byv1pk2sn91gi4hksvq` FOREIGN KEY (`roleId`) REFERENCES `t_system_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `t_system_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_system_user_role` VALUES ('1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
