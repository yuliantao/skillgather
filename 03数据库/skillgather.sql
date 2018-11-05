/*
Navicat MySQL Data Transfer

Source Server         : 知识库
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : skillgather

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-06 00:23:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission_action
-- ----------------------------
DROP TABLE IF EXISTS `permission_action`;
CREATE TABLE `permission_action` (
  `ActionCode` varchar(2) NOT NULL DEFAULT '',
  `ActionName` varchar(10) NOT NULL DEFAULT '',
  `ActionValue` varchar(20) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ActionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_action
-- ----------------------------
INSERT INTO `permission_action` VALUES ('12', '22', '22', '0');

-- ----------------------------
-- Table structure for permission_company
-- ----------------------------
DROP TABLE IF EXISTS `permission_company`;
CREATE TABLE `permission_company` (
  `CompanyCode` varchar(3) NOT NULL DEFAULT '',
  `CompanyName` varchar(20) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CompanyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_company
-- ----------------------------

-- ----------------------------
-- Table structure for permission_department
-- ----------------------------
DROP TABLE IF EXISTS `permission_department`;
CREATE TABLE `permission_department` (
  `DepartmentCode` varchar(3) NOT NULL DEFAULT '',
  `DepartmentName` varchar(20) NOT NULL DEFAULT '',
  `ParentDepartment` varchar(3) NOT NULL DEFAULT '',
  `DepartmentDescription` varchar(256) NOT NULL DEFAULT '',
  `CompanyCode` varchar(3) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`DepartmentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_department
-- ----------------------------

-- ----------------------------
-- Table structure for permission_module
-- ----------------------------
DROP TABLE IF EXISTS `permission_module`;
CREATE TABLE `permission_module` (
  `ModuleCode` varchar(4) NOT NULL DEFAULT '',
  `ModuleName` varchar(20) NOT NULL DEFAULT '',
  `ModuleValue` varchar(20) DEFAULT '',
  `LinkUrl` varchar(256) DEFAULT '',
  `ParentModule` varchar(4) NOT NULL DEFAULT '-1',
  `ModuleDescription` varchar(256) DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ModuleCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='此表兼容了简单的菜单栏控制权限和按钮级别权限控制。针对菜单栏权限可以直接使用此表作为权限表，用户登录后直接获取有权限的菜单在显示。';

-- ----------------------------
-- Records of permission_module
-- ----------------------------

-- ----------------------------
-- Table structure for permission_permit
-- ----------------------------
DROP TABLE IF EXISTS `permission_permit`;
CREATE TABLE `permission_permit` (
  `PermitCode` varchar(6) NOT NULL DEFAULT '',
  `ModuleCode` varchar(4) NOT NULL DEFAULT '',
  `ActionCode` varchar(2) NOT NULL DEFAULT '',
  `PermitValue` varchar(20) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PermitCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_permit
-- ----------------------------

-- ----------------------------
-- Table structure for permission_permit_group
-- ----------------------------
DROP TABLE IF EXISTS `permission_permit_group`;
CREATE TABLE `permission_permit_group` (
  `GroupCode` varchar(3) NOT NULL DEFAULT '',
  `GroupName` varchar(20) NOT NULL DEFAULT '',
  `PermitCodes` varchar(4000) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`GroupCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_permit_group
-- ----------------------------

-- ----------------------------
-- Table structure for permission_role
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `RoleCode` varchar(3) NOT NULL DEFAULT '',
  `RoleName` varchar(20) NOT NULL DEFAULT '',
  `RoleDescription` varchar(256) NOT NULL DEFAULT '',
  `GroupCodes` varchar(4000) NOT NULL DEFAULT '',
  `PermitCodes` varchar(4000) NOT NULL DEFAULT '',
  `ParentRole` varchar(3) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`RoleCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_role
-- ----------------------------

-- ----------------------------
-- Table structure for permission_user
-- ----------------------------
DROP TABLE IF EXISTS `permission_user`;
CREATE TABLE `permission_user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动生成用户ID号，递增模式',
  `UserName` varchar(20) NOT NULL DEFAULT '',
  `Password` varchar(50) NOT NULL DEFAULT '',
  `TrueName` varchar(12) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_user
-- ----------------------------
INSERT INTO `permission_user` VALUES ('1', 'sa', '123', '王强', '0');

-- ----------------------------
-- Table structure for permission_user_permit
-- ----------------------------
DROP TABLE IF EXISTS `permission_user_permit`;
CREATE TABLE `permission_user_permit` (
  `UserId` int(11) NOT NULL DEFAULT '0',
  `RoleCodes` varchar(100) NOT NULL DEFAULT '',
  `GroupCodes` varchar(4000) NOT NULL DEFAULT '',
  `PermitCodes` varchar(4000) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_user_permit
-- ----------------------------
