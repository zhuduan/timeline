ALTER TABLE `user`
ADD COLUMN `Password`  varchar(256) NULL COMMENT '加密后的密码' AFTER `Phone`;

ALTER TABLE `user`
ADD UNIQUE INDEX `unique_name` (`Name`) USING BTREE ;

