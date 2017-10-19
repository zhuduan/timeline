-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SubjectID` int(11) NOT NULL,
  `Title` varchar(300) DEFAULT NULL,
  `Content` text,
  `PicUrl` varchar(255) DEFAULT NULL,
  `PicDes` varchar(255) DEFAULT NULL,
  `AuthorID` int(11) DEFAULT NULL,
  `ContributorIDs` varchar(255) DEFAULT NULL,
  `OccurrenceTime` datetime DEFAULT NULL COMMENT '事件发生的具体事件',
  `Language` int(11) DEFAULT NULL COMMENT '1-CN, 2-EN, ',
  `ReplyCount` int(11) DEFAULT '0',
  `LikeCount` int(11) DEFAULT '0',
  `IsValid` tinyint(11) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for detaillink
-- ----------------------------
DROP TABLE IF EXISTS `detaillink`;
CREATE TABLE `detaillink` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DetailID_Language` varchar(255) DEFAULT NULL COMMENT '用于标识link的归属，构成结构DetailID_Language',
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
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `IsValid` tinyint(4) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(300) DEFAULT '' COMMENT '专题标题',
  `Content` text,
  `PicUrl` varchar(300) DEFAULT NULL,
  `PicDes` varchar(300) DEFAULT NULL,
  `AuthorID` int(11) DEFAULT NULL,
  `ContributorIDs` varchar(300) DEFAULT NULL COMMENT '贡献者ID list',
  `Category` varchar(255) DEFAULT NULL COMMENT '专题的分类',
  `Tags` varchar(255) DEFAULT NULL COMMENT '专题的tags，用逗号分隔',
  `StartTime` datetime DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `Language` int(11) DEFAULT '1' COMMENT '1-CN, 2-EN, ',
  `RelatedSubjectIDs` varchar(255) DEFAULT NULL COMMENT '用于关联不同的语言下的相同内容的Subject Id List',
  `IsValid` tinyint(4) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `PicUrl` varchar(255) DEFAULT NULL,
  `Role` tinyint(11) DEFAULT '0' COMMENT '用户属于的角色 - 用于权限管理',
  `Authority` tinyint(11) DEFAULT '0' COMMENT '用户的操作权限：读、删、改 - 用于权限控制',
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `WechatAccount` varchar(255) DEFAULT NULL,
  `WeiboAccount` varchar(255) DEFAULT NULL,
  `GoogleAccount` varchar(255) DEFAULT NULL,
  `IsValid` tinyint(11) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for usercontribute
-- ----------------------------
DROP TABLE IF EXISTS `usercontribute`;
CREATE TABLE `usercontribute` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SubjectID` int(11) DEFAULT NULL,
  `DetailID` int(11) DEFAULT NULL,
  `IsValid` int(11) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userfocus
-- ----------------------------
DROP TABLE IF EXISTS `userfocus`;
CREATE TABLE `userfocus` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `SubjectID` int(11) DEFAULT NULL,
  `IsValid` int(11) DEFAULT '1' COMMENT '0-delete, 1-valid',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;