/*
Navicat MySQL Data Transfer

Source Server         : 学习库
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : skillgather

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-11-27 00:08:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coreframe_menu
-- ----------------------------
DROP TABLE IF EXISTS `coreframe_menu`;
CREATE TABLE `coreframe_menu` (
  `ID` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单名',
  `Parentid` int(11) NOT NULL DEFAULT '-1' COMMENT '父ID',
  `Url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '请求链接',
  `Ico` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '菜单图标',
  `BadgeIco` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '徽章',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='菜单的动态管理';

-- ----------------------------
-- Records of coreframe_menu
-- ----------------------------
INSERT INTO `coreframe_menu` VALUES ('00000000001', '入库管理', '-1', 'userinfo', 'menu-icon fa fa-list', '');
INSERT INTO `coreframe_menu` VALUES ('00000000002', '出库管理', '-1', 'PermissionAction', 'menu-icon fa fa-desktop', '');
INSERT INTO `coreframe_menu` VALUES ('00000000003', '入库记账', '1', 'test', 'test', '');
INSERT INTO `coreframe_menu` VALUES ('00000000004', '待修入库', '1', 'test2', 'test2', '');
INSERT INTO `coreframe_menu` VALUES ('00000000005', '待修出库', '2', 'test3', 'test3', '');
INSERT INTO `coreframe_menu` VALUES ('00000000006', '出库上报', '2', 'test4', 'test4', '');
INSERT INTO `coreframe_menu` VALUES ('00000000007', '出库明细', '-1', 'PermissionAction', 'menu-icon fa fa-desktop', '');
INSERT INTO `coreframe_menu` VALUES ('00000000036', 'ee', '-1', '', 'menu-icon fafa-lemon-o', '');
INSERT INTO `coreframe_menu` VALUES ('00000000037', 'permission_action', '36', '/eee/PermissionAction', '', '');
INSERT INTO `coreframe_menu` VALUES ('00000000038', 'permission_company', '36', '/eee/PermissionCompany', '', '');
INSERT INTO `coreframe_menu` VALUES ('00000000039', 'permission_department', '36', '/eee/PermissionDepartment', '', '');

-- ----------------------------
-- Table structure for coreframe_urltoview
-- ----------------------------
DROP TABLE IF EXISTS `coreframe_urltoview`;
CREATE TABLE `coreframe_urltoview` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ShowUrl` varchar(255) NOT NULL DEFAULT '' COMMENT '访问链接',
  `MapingUrl` varchar(255) NOT NULL DEFAULT '' COMMENT '映射链接',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='请求映射视图';

-- ----------------------------
-- Records of coreframe_urltoview
-- ----------------------------
INSERT INTO `coreframe_urltoview` VALUES ('1', '/', 'login');
INSERT INTO `coreframe_urltoview` VALUES ('2', '/login.html', 'login');
INSERT INTO `coreframe_urltoview` VALUES ('3', '/index.html', 'login');
INSERT INTO `coreframe_urltoview` VALUES ('4', '/main.html', 'aceplus/home');
INSERT INTO `coreframe_urltoview` VALUES ('5', '/home.html', 'aceplus/home');
INSERT INTO `coreframe_urltoview` VALUES ('6', '/er4', 'error/4xx');
INSERT INTO `coreframe_urltoview` VALUES ('7', '/er5', 'error/5xx');
INSERT INTO `coreframe_urltoview` VALUES ('18', '/codegenerator/SystemGeneratortable', '/codegenerator/SystemGeneratortable');
INSERT INTO `coreframe_urltoview` VALUES ('24', '/eee/PermissionAction', '/aceplus/eee/PermissionAction');
INSERT INTO `coreframe_urltoview` VALUES ('25', '/eee/PermissionCompany', '/aceplus/eee/PermissionCompany');
INSERT INTO `coreframe_urltoview` VALUES ('26', '/eee/PermissionDepartment', '/aceplus/eee/PermissionDepartment');

-- ----------------------------
-- Table structure for coreframe_user
-- ----------------------------
DROP TABLE IF EXISTS `coreframe_user`;
CREATE TABLE `coreframe_user` (
  `ID` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `UserName` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `Password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `TrueName` varchar(12) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='实现用户动态的新增、修改、删除、查看、查询等基本功能！';

-- ----------------------------
-- Records of coreframe_user
-- ----------------------------
INSERT INTO `coreframe_user` VALUES ('00000000001', 'sa', '123', '王强', '0');
INSERT INTO `coreframe_user` VALUES ('00000000006', '方法ff订单ddd', 'ffff', 'ff', '0');
INSERT INTO `coreframe_user` VALUES ('00000000007', 'dddddd', 'ddddddffff', 'dddddddddddd', '0');

-- ----------------------------
-- Table structure for generator_table
-- ----------------------------
DROP TABLE IF EXISTS `generator_table`;
CREATE TABLE `generator_table` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `TableName` varchar(255) NOT NULL DEFAULT '' COMMENT '表名',
  `MenuName` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单名',
  `IsCreat` bit(1) NOT NULL COMMENT '已生成',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='扫描到需要生产系统的表';

-- ----------------------------
-- Records of generator_table
-- ----------------------------
INSERT INTO `generator_table` VALUES ('1', 'permission_action', 'permission_action', '');
INSERT INTO `generator_table` VALUES ('2', 'permission_company', 'permission_company', '');
INSERT INTO `generator_table` VALUES ('3', 'permission_department', 'permission_department', '');
INSERT INTO `generator_table` VALUES ('4', 'permission_module', 'permission_module', '\0');
INSERT INTO `generator_table` VALUES ('5', 'permission_permit', 'permission_permit', '\0');
INSERT INTO `generator_table` VALUES ('6', 'permission_permit_group', 'permission_permit_group', '\0');
INSERT INTO `generator_table` VALUES ('7', 'permission_role', 'permission_role', '\0');
INSERT INTO `generator_table` VALUES ('8', 'permission_user', 'permission_user', '\0');
INSERT INTO `generator_table` VALUES ('9', 'permission_user_permit', 'permission_user_permit', '\0');
INSERT INTO `generator_table` VALUES ('10', 'system_generatortable', 'system_generatortable', '\0');
INSERT INTO `generator_table` VALUES ('11', 'system_menu', 'system_menu', '\0');

-- ----------------------------
-- Table structure for permission_action
-- ----------------------------
DROP TABLE IF EXISTS `permission_action`;
CREATE TABLE `permission_action` (
  `ID` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ActionCode` varchar(2) NOT NULL DEFAULT '' COMMENT '操作码',
  `ActionName` varchar(10) NOT NULL DEFAULT '' COMMENT '操作名',
  `ActionValue` varchar(20) NOT NULL DEFAULT '' COMMENT '操作值',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='操作';

-- ----------------------------
-- Records of permission_action
-- ----------------------------
INSERT INTO `permission_action` VALUES ('00000000001', '12', '22', '223555', '0');

-- ----------------------------
-- Table structure for permission_company
-- ----------------------------
DROP TABLE IF EXISTS `permission_company`;
CREATE TABLE `permission_company` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CompanyCode` varchar(3) NOT NULL DEFAULT '' COMMENT '公司编码',
  `CompanyName` varchar(20) NOT NULL DEFAULT '' COMMENT '公司名称',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公司';

-- ----------------------------
-- Records of permission_company
-- ----------------------------
INSERT INTO `permission_company` VALUES ('1', '123', '测试5', '0');
INSERT INTO `permission_company` VALUES ('2', '456', '测试277', '0');

-- ----------------------------
-- Table structure for permission_department
-- ----------------------------
DROP TABLE IF EXISTS `permission_department`;
CREATE TABLE `permission_department` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `DepartmentCode` varchar(3) NOT NULL DEFAULT '' COMMENT '部门编号',
  `DepartmentName` varchar(20) NOT NULL DEFAULT '' COMMENT '部门名称',
  `ParentDepartment` varchar(3) NOT NULL DEFAULT '' COMMENT '父级部门',
  `DepartmentDescription` varchar(256) NOT NULL DEFAULT '' COMMENT '部门描述',
  `CompanyCode` varchar(3) NOT NULL DEFAULT '' COMMENT '公司代码',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_department
-- ----------------------------

-- ----------------------------
-- Table structure for permission_module
-- ----------------------------
DROP TABLE IF EXISTS `permission_module`;
CREATE TABLE `permission_module` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `ModuleCode` varchar(4) NOT NULL DEFAULT '',
  `ModuleName` varchar(20) NOT NULL DEFAULT '',
  `ModuleValue` varchar(20) DEFAULT '',
  `LinkUrl` varchar(256) DEFAULT '',
  `ParentModule` varchar(4) NOT NULL DEFAULT '-1',
  `ModuleDescription` varchar(256) DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='此表兼容了简单的菜单栏控制权限和按钮级别权限控制。针对菜单栏权限可以直接使用此表作为权限表，用户登录后直接获取有权限的菜单在显示。';

-- ----------------------------
-- Records of permission_module
-- ----------------------------

-- ----------------------------
-- Table structure for permission_permit
-- ----------------------------
DROP TABLE IF EXISTS `permission_permit`;
CREATE TABLE `permission_permit` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `PermitCode` varchar(6) NOT NULL DEFAULT '',
  `ModuleCode` varchar(4) NOT NULL DEFAULT '',
  `ActionCode` varchar(2) NOT NULL DEFAULT '',
  `PermitValue` varchar(20) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_permit
-- ----------------------------

-- ----------------------------
-- Table structure for permission_permit_group
-- ----------------------------
DROP TABLE IF EXISTS `permission_permit_group`;
CREATE TABLE `permission_permit_group` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `GroupCode` varchar(3) NOT NULL DEFAULT '',
  `GroupName` varchar(20) NOT NULL DEFAULT '',
  `PermitCodes` varchar(4000) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_permit_group
-- ----------------------------

-- ----------------------------
-- Table structure for permission_role
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `RoleCode` varchar(3) NOT NULL DEFAULT '',
  `RoleName` varchar(20) NOT NULL DEFAULT '',
  `RoleDescription` varchar(256) NOT NULL DEFAULT '',
  `GroupCodes` varchar(4000) NOT NULL DEFAULT '',
  `PermitCodes` varchar(4000) NOT NULL DEFAULT '',
  `ParentRole` varchar(3) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_role
-- ----------------------------

-- ----------------------------
-- Table structure for permission_user_permit
-- ----------------------------
DROP TABLE IF EXISTS `permission_user_permit`;
CREATE TABLE `permission_user_permit` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL DEFAULT '0',
  `RoleCodes` varchar(100) NOT NULL DEFAULT '',
  `GroupCodes` varchar(4000) NOT NULL DEFAULT '',
  `PermitCodes` varchar(4000) NOT NULL DEFAULT '',
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_user_permit
-- ----------------------------
