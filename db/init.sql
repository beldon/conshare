-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL COMMENT '收藏id',
  `title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '标题',
  `description` text CHARACTER SET utf8mb4 COMMENT '描述',
  `url` varchar(1000) CHARACTER SET utf8mb4 NOT NULL COMMENT '网址',
  `favicon` text COMMENT 'favicon',
  `logo_url` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'logo链接',
  `charset` varchar(255) CHARACTER SET utf8mb4 DEFAULT 'utf-8' COMMENT '网页编码',
  `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `category_id` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '分类id',
  `uid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `cre_time` datetime NOT NULL COMMENT '创建时间',
  `enable` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否可用，1-true，0-false',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `share` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否分享，1-true，0-false',
  `client_count` int(11) NOT NULL DEFAULT '0' COMMENT '点击数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=sjis COMMENT='用户收藏表';

-- ----------------------------
-- Table structure for t_collect_category
-- ----------------------------
DROP TABLE IF EXISTS `t_collect_category`;
CREATE TABLE `t_collect_category` (
  `id` varchar(32) NOT NULL COMMENT '收藏分类id',
  `name` varchar(255) NOT NULL COMMENT '收藏分类名称',
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `pid` varchar(32) DEFAULT 'root' COMMENT '父id，默认是''root''',
  `sort` int(11) DEFAULT '0' COMMENT '排序,越小越靠前',
  `count` int(11) DEFAULT '0' COMMENT '收藏数量',
  `cre_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COMMENT='云收藏分类表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `account` varchar(100) NOT NULL COMMENT '用户账号',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  `nickname` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(500) DEFAULT NULL COMMENT '头像',
  `status` int(1) DEFAULT NULL COMMENT '用户状态，0:正常，1:冻结，2:删除',
  `credits` int(11) DEFAULT '0' COMMENT '用户积分',
  `reg_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `cre_uid` varchar(32) DEFAULT NULL COMMENT '创建用户id',
  `update_time` datetime DEFAULT NULL COMMENT '用户信息更新时间',
  `update_uid` varchar(32) DEFAULT NULL COMMENT '更新的用户id',
  `enable` bit(1) DEFAULT b'1' COMMENT '是否可用，1-true，0-false',
  `admin` bit(1) DEFAULT b'0' COMMENT '是否为管理员，1-true，0-false',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户主表';

-- ----------------------------
-- Table structure for t_user_profile
-- ----------------------------
DROP TABLE IF EXISTS `t_user_profile`;
CREATE TABLE `t_user_profile` (
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `real_name` varchar(100) DEFAULT NULL COMMENT '用户真实姓名',
  `gender` int(1) DEFAULT '0' COMMENT '0:未知，1:男，2:女',
  `birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `mobile` varchar(20) DEFAULT NULL COMMENT '用户手机号码',
  `qq` varchar(11) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `interest` text COMMENT '兴趣',
  `bio` text COMMENT '个人简介',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户副表';
