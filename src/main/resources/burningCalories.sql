--用户表
CREATE TABLE burning_user (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  username varchar(50) NOT NULL COMMENT '用户名,不可重复',
  password    varchar(50) NOT NULL COMMENT '用户密码,MD5加密 ',
  gender int(1) NOT NULL ,
  role int(1) NOT NULL COMMENT '身份 0-普通用户 1-营养师 2-',
  phone varchar(11) NOT NULL,
  email  varchar(50)  DEFAULT NULL COMMENT '邮箱',
  height int DEFAULT NULL COMMENT '身高',
  weight int DEFAULT NULL COMMENT '体重',
  birth datetime NOT NULL COMMENT '生日',
  avatar_url varchar(500) NOT NULL COMMENT '头像url',
  backgurand_url varchar(500) NOT NULL COMMENT '背景url',
  create_time datetime  NOT NULL COMMENT '创建时间',
  update_time datetime  NOT NULL COMMENT '最后一次更新时间',
  UNIQUE user_no_pwd_index (username, password) USING BTREE,
  UNIQUE phone_index (phone) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;



--饮食表
CREATE TABLE burning_food (
  id int(11) PRIMARY KEY AUTO_INCREMENT ,
  foodname varchar(200) NOT NULL COMMENT '食物名',
  update_method int(1) NOT NULL COMMENT '上传方式: 1-拍照上传 0-手动添加',
  food_image varchar(500) NOT NULL COMMENT '食物图片',
  calories int NOT NULL COMMENT '卡路里',
  food_time datetime NOT NULL COMMENT '入食时间',
  create_time datetime NOT NULL COMMENT '发布时间',
  UNIQUE time_index (food_time) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

--运动表
CREATE TABLE burning_sport (
  id int(11) PRIMARY KEY AUTO_INCREMENT ,
  sportname varchar(200) NOT NULL COMMENT '运动名',
  calories int NOT NULL COMMENT '消耗卡路里',
  food_time datetime NOT NULL COMMENT '开始时间',
  continue_time int NOT NULL COMMENT '运动时长',
  UNIQUE time_index (food_time) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;
