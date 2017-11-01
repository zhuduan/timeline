-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(300) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', 'hello');
INSERT INTO `item` VALUES ('2', 'world');
INSERT INTO `item` VALUES ('3', 'aa');