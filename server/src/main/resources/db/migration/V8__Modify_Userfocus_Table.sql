/*
Navicat MySQL Data Transfer

Source Server         : localhost_monitor
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : timeline

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-09 22:54:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userfocus
-- ----------------------------
DROP TABLE IF EXISTS `userfocus`;
CREATE TABLE `userfocus` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `SubjectID` int(11) DEFAULT NULL,
  `IsValid` int(11) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Unique_Index_UserID_SubjectID` (`UserID`,`SubjectID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
