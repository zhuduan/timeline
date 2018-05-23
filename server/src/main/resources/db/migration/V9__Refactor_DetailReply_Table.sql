SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for detailreply
-- ----------------------------
DROP TABLE IF EXISTS `detailreply`;
CREATE TABLE `detailreply` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DetailID` int(11) DEFAULT NULL,
  `Title` varchar(300) DEFAULT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `AuthorID` int(11) DEFAULT NULL,
  `ToReplyID` int(11) DEFAULT 0 COMMENT 'to definite the reply, and 0 means not a sub reply',
  `IsValid` tinyint(4) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
