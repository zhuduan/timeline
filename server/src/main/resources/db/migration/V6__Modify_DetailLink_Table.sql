
-- ----------------------------
-- Table structure for detaillink
-- ----------------------------
DROP TABLE IF EXISTS `detaillink`;
CREATE TABLE `detaillink` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DetailID` int(10) NOT NULL COMMENT '用于标识link的归属，构成结构DetailID_Language',
  `Language` int(10) NOT NULL,
  `Title` varchar(300) DEFAULT NULL,
  `Content` text,
  `PicUrl` varchar(255) DEFAULT NULL,
  `PicDes` varchar(255) DEFAULT NULL,
  `SourceName` varchar(255) DEFAULT NULL COMMENT 'link的来源',
  `SourceLink` varchar(255) DEFAULT NULL COMMENT 'link的地址，用于后面的跳转',
  `Weight` int(11) DEFAULT '1000' COMMENT '权重，用于做排序',
  `Status` int(11) DEFAULT '0' COMMENT 'link的状态归属： 0-默认，1-精选， 2-热门  —— 主要方便后面做管理和筛选',
  `IsValid` int(11) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Unique_DetailID_Language` (`DetailID`,`Language`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
