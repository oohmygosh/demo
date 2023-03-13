DROP TABLE IF EXISTS user;
CREATE TABLE user (
                       id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
                       name VARCHAR(50) NOT NULL COMMENT '姓名',
                       age INT NOT NULL COMMENT '年龄',
                       sex VARCHAR(10) NULL DEFAULT '男' COMMENT '性别',
                       phone VARCHAR(20) NOT NULL COMMENT '手机号',
                       address VARCHAR(100) NOT NULL COMMENT '详细地址'
);
