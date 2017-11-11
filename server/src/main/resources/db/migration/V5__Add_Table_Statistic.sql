SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for statisticinfo
-- ----------------------------
DROP TABLE IF EXISTS `statisticinfo`;
CREATE TABLE `statisticinfo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RequestUrl` varchar(255) DEFAULT NULL,
  `RequestUserID` int(11) DEFAULT '0' COMMENT '0 if not a login User',
  `RequestIP` varchar(255) DEFAULT NULL COMMENT 'the ip request source from',
  `RequestDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;