/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_practical_training_v1_0_0

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-04 18:34:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `click_num` int(11) NOT NULL,
  `comment_num` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `key_word` varchar(255) DEFAULT NULL,
  `praise_count` int(11) NOT NULL,
  `publish_time` datetime DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `source` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for article_content
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_content
-- ----------------------------

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `preset_number` int(11) NOT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', 'java', '2017-07-07 19:21:25', '200', 'java', '0');
INSERT INTO `class_info` VALUES ('2', 'java专业班', '2017-07-08 13:13:58', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('3', 'java专业班', '2017-07-08 13:15:09', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('4', 'java专业班', '2017-07-08 15:31:50', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('5', 'java专业班', '2017-07-08 15:39:52', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('6', 'java专业班', '2017-07-11 16:59:38', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('7', 'java专业班', '2017-07-12 11:11:42', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('8', 'java专业班', '2017-07-17 16:24:35', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('9', 'java专业班', '2017-07-17 18:21:32', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('10', 'java专业班', '2017-07-27 16:30:31', '100', '专业的java班级，让你快且精的学好java', '0');
INSERT INTO `class_info` VALUES ('11', 'java专业班', '2017-07-31 11:48:09', '100', '专业的java班级，让你快且精的学好java', '0');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `begin_create_time` datetime DEFAULT NULL,
  `comment_number` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_create_time` datetime DEFAULT NULL,
  `limit_number` int(11) DEFAULT NULL,
  `other_id` int(11) DEFAULT NULL,
  `p_comment_id` int(11) DEFAULT NULL,
  `pic_img` varchar(255) DEFAULT NULL,
  `praise_count` int(11) DEFAULT NULL,
  `reply_count` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('3', '2017-07-07 17:16:00', null, '422', '流年似锦，幽幽浮生', '3', 'java123', '470799037@qq.com', null, '332', '1', '2', '/1.png', '646', '666', '3', '3', 'wangrong', null);
INSERT INTO `comment` VALUES ('4', '2017-07-08 10:30:33', null, '0', '该靠着你肩膀', '3', 'java123', 'wangrong@163.com', null, '0', '0', '0', null, '544', '0', '2', '36', 'wangrong', null);
INSERT INTO `comment` VALUES ('5', '2017-07-19 10:30:40', null, '0', '该靠着你肩膀', '3', 'java123', 'wangrong@163.com', null, '0', '0', '0', null, '8887', '0', '2', '36', 'wangrong', null);
INSERT INTO `comment` VALUES ('6', '2017-07-19 11:46:30', null, '0', '该靠着你肩膀', '3', 'java123', 'wangrong@163.com', null, '0', '0', '0', null, '667', '0', '2', '36', 'wangrong', null);
INSERT INTO `comment` VALUES ('7', '2017-07-19 14:13:16', null, '0', '该靠着你肩膀', '3', 'java123', 'wangrong@163.com', null, '0', '0', '0', null, '332', '0', '0', '36', 'wangrong', null);
INSERT INTO `comment` VALUES ('8', '2017-07-26 16:05:35', null, '0', '', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('9', '2017-07-26 16:05:48', null, '0', '王溶', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('10', '2017-07-26 16:05:55', null, '0', '王溶', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('11', '2017-07-26 16:07:14', null, '0', '', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('12', '2017-07-26 16:07:18', null, '0', '机票【记录', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('13', '2017-07-26 16:09:01', null, '0', 'ogihji ', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('14', '2017-07-26 16:09:39', null, '0', 'hghgh', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('15', '2017-07-26 16:11:54', null, '0', 'gfdggf', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('16', '2017-07-26 16:13:08', null, '0', 'hfdhgdd', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('17', '2017-07-26 16:16:10', null, '0', '1111111111111', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('18', '2017-07-26 16:19:49', null, '0', '1111111111111', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('19', '2017-07-26 16:21:44', null, '0', '333333', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('20', '2017-07-26 16:22:02', null, '0', '333333', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('21', '2017-07-26 16:26:47', null, '0', '345646', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('22', '2017-07-26 16:27:50', null, '0', 'eeeee', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('23', '2017-07-26 16:28:22', null, '0', 'rqqqqq', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('24', '2017-07-26 16:29:23', null, '0', 'qweqweqwe', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('25', '2017-07-26 16:30:06', null, '0', '吃西瓜不吐西瓜皮', '2', null, '23213213@.com', null, '789', '0', '0', null, '123', '456', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('26', '2017-07-26 16:31:56', null, '0', '88888', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('27', '2017-07-26 16:32:47', null, '0', '44444444', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('28', '2017-07-26 16:33:09', null, '0', '44444444', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('29', '2017-07-26 16:42:46', null, '0', 'dasdsa ', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('30', '2017-07-26 16:43:01', null, '0', 'dasdsa ', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('31', '2017-07-26 17:34:37', null, '0', 'dsad ', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('32', '2017-07-31 10:19:35', null, '0', '', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('33', '2017-07-31 10:27:15', null, '0', '', '2', null, '23213213@.com', null, '0', '0', '0', null, '0', '0', '2', '22', 'songwangyang', null);
INSERT INTO `comment` VALUES ('34', '2017-07-31 12:16:09', null, '0', '', '12', null, '45789562@qq.com', null, '0', '0', '0', null, '0', '0', '2', '44', 'qiufeng', null);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `COURSE_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `COURSE_NAME` varchar(300) NOT NULL DEFAULT '' COMMENT '课程名称',
  `SUBJECT_ID` int(11) NOT NULL DEFAULT '0' COMMENT '课程专业ID',
  `ADD_TIME` datetime DEFAULT NULL COMMENT '添加时间',
  `TITLE` varchar(200) NOT NULL DEFAULT '' COMMENT '课程简介',
  `CONTEXT` longtext COMMENT '课程详情',
  `LESSION_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '总课时',
  `SEQUENCE` int(1) DEFAULT '0' COMMENT '序列',
  `IS_RECOMMEND` int(2) NOT NULL DEFAULT '0' COMMENT '是否加入推荐 0=否 1=是',
  PRIMARY KEY (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('12', '历史', '58', '2017-07-05 16:24:22', '历史', '阿达阿萨德', '12', '1', '1');
INSERT INTO `course` VALUES ('14', 'Android常用异常集及解决方案', '58', '2017-07-18 11:03:13', '介绍Android常见异常的种类及常见发生场景，如何高效的调试，异常捕获，错误日志上报等等', '', '100', '0', '1');
INSERT INTO `course` VALUES ('15', 'PHP消息队列实现及应用', '53', '2017-07-18 11:03:46', '消息队列是个高大上的名词儿，本质上就是如何业务进行排队处理，最常的使用场景就是发送短信的时候使用短信队列。但消息队列可以做的不止是这一类场景，它在解耦、消峰、异步、一致性等方面都有很大的用武之地。因此如何合理使用消息队列来处理一些特殊的业务需求，这就是我们这节课要解决的内容。 课程所需库文件：http://pan.baidu.com/s/1bQg038', '', '130', '0', '1');
INSERT INTO `course` VALUES ('16', '星级评分原理和实现（下）', '49', '2017-07-18 11:04:27', '本课程总会讲解如何使用纯CSS代码提交评分、js利用雪碧图等来实现星级评分如何点亮半个星星、四分之一课星星。', '', '10', '0', '1');
INSERT INTO `course` VALUES ('17', 'iOS推送通知', '59', '2017-07-18 11:06:13', '本课程将带你了解iOS的push原理，如何搭建push环境，push的交互设置，以及该如何实现推送消息。并且会给大家分别讲解Local Push的一般用法和高级用法，以及push的相关业务功能介绍。', '', '142', '0', '1');
INSERT INTO `course` VALUES ('18', '带你开发类似Pokemon Go的AR游戏', '59', '2017-07-18 11:06:47', '带你开发类似Pokemon Go的AR游戏：课程介绍，开发环境配置，游戏场景一：有卡识别，游戏场景二：无卡识别，游戏菜单场景，导出 iOS 平台并运行，导出 Android 平台并运行，课程总结。', '', '100', '0', '0');

-- ----------------------------
-- Table structure for course_catalog
-- ----------------------------
DROP TABLE IF EXISTS `course_catalog`;
CREATE TABLE `course_catalog` (
  `CATALOG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型 0=目录 1=章节',
  `COURSE_ID` int(11) DEFAULT '0' COMMENT '课程id',
  `catalog_name` varchar(300) DEFAULT NULL COMMENT '目录名称',
  `ADD_TIME` datetime DEFAULT NULL COMMENT '添加时间',
  `SORT` int(11) DEFAULT '0' COMMENT '显示排序',
  `kpoint_type` int(4) DEFAULT NULL,
  PRIMARY KEY (`CATALOG_ID`),
  KEY `course_id` (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程目录表';

-- ----------------------------
-- Records of course_catalog
-- ----------------------------
INSERT INTO `course_catalog` VALUES ('169', '12', '课程介绍', '2017-07-17 19:47:21', '1', null);
INSERT INTO `course_catalog` VALUES ('172', '12', '消息中间件的概述', '2017-07-18 10:22:50', '0', null);
INSERT INTO `course_catalog` VALUES ('179', '14', '新创建视频', '2017-07-18 11:39:00', '0', null);
INSERT INTO `course_catalog` VALUES ('180', '12', '结课', '2017-07-24 14:08:42', '0', null);

-- ----------------------------
-- Table structure for course_favorites
-- ----------------------------
DROP TABLE IF EXISTS `course_favorites`;
CREATE TABLE `course_favorites` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `COURSE_ID` int(11) DEFAULT '0' COMMENT '课程id',
  `USER_ID` int(11) DEFAULT '0' COMMENT '用户ID',
  `ADD_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`),
  KEY `user_id` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏';

-- ----------------------------
-- Records of course_favorites
-- ----------------------------

-- ----------------------------
-- Table structure for course_kpoint
-- ----------------------------
DROP TABLE IF EXISTS `course_kpoint`;
CREATE TABLE `course_kpoint` (
  `KPOINT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(300) DEFAULT NULL COMMENT '节点名称',
  `PARENT_ID` int(11) DEFAULT '0' COMMENT '父级ID',
  `ADD_TIME` datetime DEFAULT NULL COMMENT '添加时间',
  `SORT` int(11) DEFAULT '0' COMMENT '显示排序',
  `VIDEO_URL` varchar(500) DEFAULT NULL COMMENT '视频地址',
  `TEACHER_ID` int(11) DEFAULT '0' COMMENT '讲师id',
  `KPOINT_TYPES` int(1) DEFAULT '0' COMMENT '节点类型 0文件目录 1视频',
  `VIDEO_TYPE` varchar(30) DEFAULT NULL COMMENT '视频类型',
  `FILE_TYPE` varchar(20) DEFAULT NULL COMMENT 'VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集',
  `CONTENT` longtext COMMENT '文本',
  `COURSE_ID` int(11) NOT NULL,
  `PAPER_ID` int(11) DEFAULT NULL COMMENT '试卷ID',
  `TEST_TYPE` int(2) DEFAULT '0' COMMENT '检测类型',
  PRIMARY KEY (`KPOINT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='知识点的基本信息';

-- ----------------------------
-- Records of course_kpoint
-- ----------------------------
INSERT INTO `course_kpoint` VALUES ('183', '课程安排', '169', '2017-07-17 19:47:23', '0', 'http://localhost:4000/video/2017-07-18/20170718102002.mp4', '0', '1', null, null, null, '12', null, '0');
INSERT INTO `course_kpoint` VALUES ('185', ' 为什么使用消息中间件', '169', '2017-07-18 09:53:24', '0', 'http://szv1.mukewang.com/5947639ee420e564688b45e8/H.mp4', '0', '1', null, null, null, '12', null, '0');
INSERT INTO `course_kpoint` VALUES ('186', '消息中间件概述', '172', '2017-07-18 10:25:08', '0', 'http://localhost:4000/video/2017-07-18/20170718105624.mp4', '0', '1', null, null, null, '12', null, '0');
INSERT INTO `course_kpoint` VALUES ('187', ' JMS规范', '172', '2017-07-18 10:46:48', '0', 'http://szv1.mukewang.com/5947639ee420e564688b45e8/H.mp4', '0', '1', null, null, null, '12', null, '0');
INSERT INTO `course_kpoint` VALUES ('188', '章节测试', '169', '2017-07-24 14:10:01', '0', null, '0', '2', null, null, null, '12', '1', '0');
INSERT INTO `course_kpoint` VALUES ('189', '结课测试', '180', '2017-07-24 16:21:32', '0', null, '0', '0', null, null, null, '12', '0', '0');
INSERT INTO `course_kpoint` VALUES ('190', '测试', '180', '2017-07-27 16:41:59', '0', null, '0', '1', null, null, null, '18', '0', '0');
INSERT INTO `course_kpoint` VALUES ('192', 'JIEL', '0', '2017-08-04 09:05:13', '0', null, '0', '0', null, null, null, '0', '2', '0');

-- ----------------------------
-- Table structure for course_note
-- ----------------------------
DROP TABLE IF EXISTS `course_note`;
CREATE TABLE `course_note` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(11) DEFAULT '0' COMMENT '用户ID',
  `COURSE_ID` int(11) DEFAULT '0' COMMENT '课程id',
  `KPOINT_ID` int(11) DEFAULT '0' COMMENT '节点ID',
  `CONTENT` longtext COMMENT '笔记信息',
  `UPDATE_TIME` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `STATUS` tinyint(4) DEFAULT '0' COMMENT '0公开1隐藏',
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CUS_ID` (`KPOINT_ID`),
  KEY `POINT_ID` (`COURSE_ID`),
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记信息';

-- ----------------------------
-- Records of course_note
-- ----------------------------

-- ----------------------------
-- Table structure for course_studyhistory
-- ----------------------------
DROP TABLE IF EXISTS `course_studyhistory`;
CREATE TABLE `course_studyhistory` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL COMMENT '用户id',
  `COURSE_ID` int(11) NOT NULL COMMENT '课程id',
  `KPOINT_ID` int(11) NOT NULL COMMENT '节点id',
  `PLAYERCOUNT` int(11) NOT NULL DEFAULT '0' COMMENT '观看次数,累加',
  `COURSE_NAME` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `KPOINT_NAME` varchar(50) DEFAULT NULL COMMENT '节点名称',
  `DATABACK` text COMMENT 'playercount小于20时记录,备注观看的时间，叠加',
  `UPDATE_TIME` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后观看时间',
  `logo` varchar(255) DEFAULT NULL,
  `pic_img` varchar(255) DEFAULT NULL,
  `query_limit` int(11) NOT NULL,
  `show_name` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `update_time_format` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_img` varchar(255) DEFAULT NULL,
  `user_show_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `user_course_id` (`USER_ID`,`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='课程播放记录(学习记录)';

-- ----------------------------
-- Records of course_studyhistory
-- ----------------------------
INSERT INTO `course_studyhistory` VALUES ('1', '7', '19', '17', '43', '听力口语', '第一课时：输入与输出和用户交互', '2015-09-08 06:11:56,2015-09-08 06:10:23,2015-09-08 05:35:42,2015-09-08 05:33:20,2015-09-08 03:20:59,2015-09-08 03:18:42,2015-09-08 02:22:56,2015-09-07 07:10:08,2015-09-07 07:09:10,2015-09-07 07:08:14,2015-09-07 07:00:17,2015-09-07 06:57:51,2015-09-07 06:57:12,2015-09-07 06:57:05,2015-09-07 06:56:24,2015-09-07 06:56:17,2015-09-07 06:55:40,2015-09-07 06:54:26,2015-09-07 06:52:53,2015-09-07 06:52:08,2015-09-07 06:47:17,2015-09-07 06:46:44,2015-09-07 06:42:31,2015-09-07 06:40:39,2015-09-07 06:38:23,', '2015-09-08 14:11:56', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('2', '7', '19', '18', '4', '听力口语', '第二课时：输入出和用户交互', '2015-09-07 06:56:20,2015-09-07 06:55:44,2015-09-07 06:54:36,2015-09-06 02:55:27,', '2015-09-07 14:56:20', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('3', '7', '10', '5', '105', '零基础入门学习Python课程学习', '第一节', '2016-06-15 08:33:12,2016-05-10 07:55:39,2015-10-22 06:30:07,2015-10-22 06:27:55,2015-10-22 06:23:07,2015-10-14 06:42:28,2015-10-14 06:42:14,2015-10-14 03:50:54,2015-09-29 01:34:58,2015-09-29 01:34:00,2015-09-29 01:32:53,2015-09-29 01:32:43,2015-09-28 06:31:56,2015-09-28 06:30:58,2015-09-28 06:30:13,2015-09-28 06:26:02,2015-09-19 09:45:35,2015-09-19 09:43:10,2015-09-19 09:43:08,2015-09-19 09:43:02,2015-09-19 09:32:05,2015-09-19 09:28:32,2015-09-19 09:27:16,2015-09-19 09:27:12,2015-09-19 09:27:08,', '2016-06-15 16:33:12', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('4', '7', '14', '16', '21', 'XHTML CSS2 JS整站制作教程课程学习', 'XHTML CSS2 JS整站制作教程课1', '2016-02-27 08:39:06,2016-02-03 03:54:56,2016-02-03 03:52:23,2016-02-03 03:49:19,2016-02-03 03:49:16,2016-02-03 03:49:15,2016-02-03 03:49:06,2016-02-03 03:49:05,2016-02-03 03:49:03,2016-02-03 03:49:02,2016-02-03 03:49:00,2016-02-03 03:48:55,2015-10-29 09:26:02,2015-10-29 09:25:51,2015-10-29 09:25:37,2015-09-08 09:35:18,2015-09-08 09:34:34,2015-09-08 09:34:01,2015-09-08 09:32:56,2015-09-08 09:32:07,2015-09-08 09:31:46,', '2016-02-27 16:39:06', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('5', '7', '10', '2', '33', '零基础入门学习Python课程学习', '第二节', '2015-10-14 07:06:24,2015-10-14 06:42:16,2015-10-14 03:50:56,2015-09-29 01:34:59,2015-09-29 01:34:01,2015-09-29 01:32:54,2015-09-29 01:32:51,2015-09-28 06:31:58,2015-09-28 06:31:00,2015-09-28 06:30:15,2015-09-28 06:26:41,2015-09-19 09:45:36,2015-09-19 09:43:09,2015-09-19 09:43:03,2015-09-19 09:32:07,2015-09-19 09:28:33,2015-09-19 09:27:16,2015-09-19 09:27:13,2015-09-19 09:27:09,2015-09-19 09:26:29,2015-09-19 09:26:17,2015-09-19 05:40:04,2015-09-18 08:34:03,2015-09-10 10:03:07,2015-09-10 08:12:59,', '2015-10-14 15:06:24', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('6', '10', '10', '5', '1', '零基础入门学习Python课程学习', '少年时代', '2015-09-09 20:30:57,', '2015-09-09 16:30:57', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('7', '6', '14', '16', '2', 'XHTML CSS2 JS整站制作教程课程学习', 'XHTML CSS2 JS整站制作教程课1', '2015-09-24 02:26:54,2015-09-10 03:39:11,', '2015-09-24 10:26:54', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('8', '6', '14', '34', '2', 'XHTML CSS2 JS整站制作教程课程学习', 'XHTML CSS2 JS整站制作教程课2', '2015-09-10 03:39:24,2015-09-10 03:39:17,', '2015-09-10 11:39:24', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('9', '6', '14', '33', '1', 'XHTML CSS2 JS整站制作教程课程学习', 'XHTML CSS2 JS 第二章 一节', '2015-09-10 03:39:21,', '2015-09-10 11:39:21', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('10', '7', '10', '4', '20', '零基础入门学习Python课程学习', '第一节', '2015-10-14 07:06:30,2015-10-14 06:42:26,2015-10-14 06:42:22,2015-10-14 03:51:35,2015-10-14 03:51:01,2015-09-29 01:35:01,2015-09-29 01:32:57,2015-09-28 06:32:15,2015-09-28 06:31:02,2015-09-28 06:28:33,2015-09-28 06:28:10,2015-09-28 06:27:25,2015-09-19 09:27:18,2015-09-18 08:34:13,2015-09-10 08:12:54,2015-09-10 08:12:47,2015-09-10 08:11:07,2015-09-10 08:10:16,2015-09-10 08:08:20,2015-09-10 08:06:53,', '2015-10-14 15:06:30', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('11', '7', '10', '44', '120', '零基础入门学习Python课程学习', '文本演示', '2016-06-15 08:33:10,2016-05-17 01:57:48,2016-05-17 01:56:39,2016-05-17 01:55:09,2016-05-17 01:52:00,2016-05-17 01:39:28,2016-05-17 01:34:43,2016-05-17 01:21:18,2016-05-17 01:15:12,2016-05-10 09:25:00,2016-05-10 09:24:52,2016-05-10 09:14:14,2016-05-10 09:13:21,2016-05-10 09:13:12,2016-05-10 09:13:07,2016-05-10 09:09:12,2016-05-10 09:09:04,2016-05-10 08:28:05,2016-05-10 08:20:18,2016-05-10 08:17:45,2016-05-10 07:55:37,2016-05-10 07:47:27,2016-05-10 07:46:40,2016-05-10 07:43:38,2016-05-10 07:43:06,', '2016-06-15 16:33:10', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('12', '7', '10', '54', '4', '零基础入门学习Python课程学习', '乐视云视频', '2015-09-29 01:35:17,2015-09-28 10:24:11,2015-09-19 09:13:58,2015-09-19 05:40:45,', '2015-09-29 09:35:17', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('13', '7', '10', '49', '2', '零基础入门学习Python课程学习', '新创建视频1', '2015-10-14 03:51:07,2015-10-14 03:51:03,', '2015-10-14 11:51:07', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('14', '7', '10', '53', '1', '零基础入门学习Python课程学习', '新创建视频2', '2015-10-14 03:51:04,', '2015-10-14 11:51:04', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('15', '7', '14', '34', '8', 'XHTML CSS2 JS整站制作教程课程学习', 'XHTML CSS2 JS整站制作教程课2', '2016-02-03 03:49:15,2016-02-03 03:49:08,2016-02-03 03:49:06,2016-02-03 03:49:04,2016-02-03 03:49:03,2016-02-03 03:49:01,2016-02-03 03:48:58,2015-10-29 09:25:40,', '2016-02-03 11:49:15', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('16', '7', '14', '33', '2', 'XHTML CSS2 JS整站制作教程课程学习', 'XHTML CSS2 JS 第二章 一节', '2016-02-27 08:39:11,2015-10-29 09:25:54,', '2016-02-27 16:39:11', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('17', '6', '16', '37', '1', '20世纪西方音乐', '第一节', '2016-01-30 08:57:38,', '2016-01-30 16:57:38', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('18', '10', '16', '37', '1', '20世纪西方音乐', '第一节', '2016-01-30 08:58:49,', '2016-01-30 16:58:49', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('19', '66', '24', '54', '1', 'XHTML CSS2 JS整站制作教程课程学习(2)', '第一节', '2016-02-01 02:13:11,', '2016-02-01 10:13:11', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('20', '66', '10', '44', '2', '零基础入门学习Python课程学习', '主讲课程', '2016-02-01 02:30:23,2016-02-01 02:13:55,', '2016-02-01 10:30:23', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('21', '66', '10', '5', '1', '零基础入门学习Python课程学习', '第一节', '2016-02-01 02:30:26,', '2016-02-01 10:30:26', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('22', '6', '11', '49', '2', '影想力摄影小课堂', '课程一', '2016-02-02 01:18:33,2016-02-02 01:17:47,', '2016-02-02 09:18:33', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('23', '7', '16', '37', '1', '20世纪西方音乐', '第一节', '2016-02-03 08:02:45,', '2016-02-03 16:02:45', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('24', '6', '10', '44', '3', '零基础入门学习Python课程学习', '主讲课程', '2016-02-24 02:50:55,2016-02-24 01:49:05,2016-02-24 01:48:10,', '2016-02-24 10:50:55', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('25', '6', '12', '50', '1', '数学给宝宝带来的兴趣', '第一节', '2016-02-24 01:50:39,', '2016-02-24 09:50:39', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('26', '6', '21', '56', '1', '搜索引擎优化技术', '第一节', '2016-02-24 05:58:43,', '2016-02-24 13:58:43', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('27', '7', '10', '63', '62', '零基础入门学习Python课程学习', '因酷云视频1', '2016-07-12 05:56:51,2016-07-12 05:53:55,2016-07-12 05:51:45,2016-07-12 05:48:31,2016-07-12 05:47:08,2016-06-16 11:18:34,2016-06-16 11:02:17,2016-06-16 10:45:52,2016-06-16 10:45:07,2016-06-16 10:43:51,2016-06-16 10:43:32,2016-06-16 10:42:36,2016-06-16 10:42:28,2016-06-16 10:42:16,2016-06-16 10:37:35,2016-06-16 10:33:32,2016-06-16 10:33:21,2016-06-16 10:31:02,2016-06-15 08:32:41,2016-06-15 08:24:58,2016-05-17 01:57:49,2016-05-17 01:57:43,2016-05-17 01:56:43,2016-05-17 01:56:28,2016-05-17 01:55:11,', '2016-07-12 13:56:51', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('28', '7', '10', '64', '1', '零基础入门学习Python课程学习', '本地上传视频测试', '2016-07-12 05:47:09,', '2016-07-12 13:47:09', null, null, '0', null, null, null, null, null, null);
INSERT INTO `course_studyhistory` VALUES ('29', '7', '10', '65', '3', '零基础入门学习Python课程学习', '新创建视频', '2016-07-12 05:54:00,2016-07-12 05:51:47,2016-07-12 05:48:32,', '2016-07-12 13:54:00', null, null, '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for course_subject
-- ----------------------------
DROP TABLE IF EXISTS `course_subject`;
CREATE TABLE `course_subject` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) NOT NULL DEFAULT '0' COMMENT '课程id',
  `SUBJECT_ID` int(11) NOT NULL DEFAULT '0' COMMENT '分类id',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `course_subject` (`COURSE_ID`,`SUBJECT_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of course_subject
-- ----------------------------
INSERT INTO `course_subject` VALUES ('13', '4', '222');
INSERT INTO `course_subject` VALUES ('14', '5', '209');
INSERT INTO `course_subject` VALUES ('15', '6', '209');
INSERT INTO `course_subject` VALUES ('16', '3', '206');
INSERT INTO `course_subject` VALUES ('17', '7', '210');
INSERT INTO `course_subject` VALUES ('18', '8', '217');

-- ----------------------------
-- Table structure for course_teacher
-- ----------------------------
DROP TABLE IF EXISTS `course_teacher`;
CREATE TABLE `course_teacher` (
  `COURSE_ID` int(11) DEFAULT NULL COMMENT '课程id',
  `TEACHER_ID` int(11) DEFAULT NULL COMMENT '讲师id',
  `id` int(11) NOT NULL,
  KEY `course_id` (`COURSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程讲师关联';

-- ----------------------------
-- Records of course_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for examination_questions
-- ----------------------------
DROP TABLE IF EXISTS `examination_questions`;
CREATE TABLE `examination_questions` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `questions_type` int(4) NOT NULL COMMENT '试题类型（0：单选题:1：多选题 2：判断题 3：填空题 4：简答题等）',
  `questions_classify` int(4) NOT NULL DEFAULT '0' COMMENT '试题分类',
  `subject_id` int(11) NOT NULL COMMENT '专业',
  `difficulty` int(2) NOT NULL COMMENT '难度（0：简单 1：入门 2：困难）  ',
  `questions_title` varchar(1000) NOT NULL COMMENT '试题标题  ',
  `questions_option` varchar(1000) DEFAULT NULL COMMENT '试题答案选项  ',
  `correct` varchar(1000) NOT NULL COMMENT '答案  ',
  `answer_analysis` text NOT NULL COMMENT '答案分析  ',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `status` int(2) DEFAULT '0' COMMENT '状态 0：正常 1：冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='试题题库表';

-- ----------------------------
-- Records of examination_questions
-- ----------------------------
INSERT INTO `examination_questions` VALUES ('1', '1', '1', '29', '1', '下列哪种说法是正确的（）', 'A:实例方法可直接调用超类的实例方法,B:实例方法可直接调用超类的类方法,C:实例方法可直接调用其他类的实例方法,D:实例方法可直接调用本类的 类方法', 'D', '好好看看书吧', '2017-07-18 15:53:23', '1');
INSERT INTO `examination_questions` VALUES ('2', '0', '1', '21', '0', '什么是css？', 'A:12,B:13,C:14,D:样式文件', 'BCD', '答案分析答案分析答案分析', '2017-07-18 15:58:04', '1');
INSERT INTO `examination_questions` VALUES ('3', '0', '0', '21', '0', '什么是css？', 'A:12,B:13,C:14,D:样式文件', 'D', '答案分析答案分析答案分析', '2017-07-18 16:55:00', '1');
INSERT INTO `examination_questions` VALUES ('4', '2', '0', '54', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '0');
INSERT INTO `examination_questions` VALUES ('5', '3', '0', '21', '0', '\n某日上午，没有完成作业的史某被刘老师叫到讲桌前，然后刘老师向全班下达任务：“每个人去打5棍，谁打得不狠就打谁”。结果，全班有40名学生，除了另外4个没有做完作业的学生外，其余35名学生全部动了手，共打了史某175棍，刘老师也亲自动手打了5棍。挨打后，史某疼痛难忍，还被要求坐着听课，直到放学。回家时，他走到家门口就瘫倒了。张母送他就医时发现其臀部大面积红肿，部分已经成了紫红色。几天后，史某仍只能趴在病床上。张母说，儿子现在每天晚上只能趴着睡觉。“不趴着不行啊，屁股疼。晚上稍微碰着一点，都疼得喊‘妈啊，我屁股疼’”。\n从教师职业道德的角度，分析材料中教师行为存在的问题。', null, 'A', '答案分析答案分析答案分析', '2017-07-19 15:40:05', '1');
INSERT INTO `examination_questions` VALUES ('6', '1', '1', '21', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '1');
INSERT INTO `examination_questions` VALUES ('7', '2', '1', '29', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '0');
INSERT INTO `examination_questions` VALUES ('8', '2', '0', '54', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '0');
INSERT INTO `examination_questions` VALUES ('9', '2', '0', '54', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '0');
INSERT INTO `examination_questions` VALUES ('10', '2', '0', '54', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '0');
INSERT INTO `examination_questions` VALUES ('11', '2', '0', '29', '0', '在文件操作中，public String getName()功能是得到文件名  。public String getAbsolutePath()功能是返回文件绝对路径  。', 'A:正确,B:错误', 'A', '答案分析答案分析答案分析', '2017-07-19 15:11:26', '0');
INSERT INTO `examination_questions` VALUES ('12', '0', '0', '49', '0', '下面那些标签是行内标签？', 'A:div,B:span,C:li,D:p', 'B', '<span style=\"color:#E53333;font-family:arial;font-size:13px;white-space:normal;background-color:#FFFFFF;\">块级元素可以设置大小,行内标签不会。</span>', '2017-07-31 14:07:54', '0');
INSERT INTO `examination_questions` VALUES ('13', '2', '0', '50', '0', '使用空标签清除浮动 clear:both（理论上能清楚任何标签，，，增加无意义的标签）', 'A:正确,B:错误', 'A', '', '2017-07-31 14:43:25', '0');
INSERT INTO `examination_questions` VALUES ('14', '1', '0', '49', '0', 'IE和DOM事件流的区别', '[{\"answer\":\"A:执行顺序不一样\"},{\"answer\":\"B:参数不一样\"},{\"answer\":\"C:事件加不加on\"},{\"answer\":\"D:this指向问题\"}]', 'ABCD', '无', '2017-07-31 16:35:05', '1');
INSERT INTO `examination_questions` VALUES ('15', '1', '0', '50', '0', '<span style=\"color:#333333;font-family:&quot;font-size:14px;white-space:normal;background-color:#FFFFFF;\">IE和DOM事件流的区别</span>', 'A:<span style=\"color:#E53333;font-family:&quot;font-size:14px;white-space:normal;background-color:#FFFFFF;\">执行顺序不一样</span>,B:参数不一样,C:事件加不加on,D:this指向问题', 'ABCD', '无', '2017-07-31 16:43:32', '0');
INSERT INTO `examination_questions` VALUES ('16', '1', '0', '50', '0', '<span style=\"color:#333333;font-family:Arial, &quot;font-size:20px;white-space:normal;background-color:#FFFFFF;\">在JavaScript中( )以下哪些是数组的方法？</span>', 'A:<span style=\"color:#333333;font-family:Arial, &quot;font-size:16px;font-weight:bold;white-space:normal;background-color:#FFFFFF;\">add()</span>,B:<span style=\"color:#333333;font-family:Arial, &quot;font-size:16px;font-weight:bold;white-space:normal;background-color:#FFFFFF;\">&nbsp;join()</span>,C:<span style=\"color:#333333;font-family:Arial, &quot;font-size:16px;font-weight:bold;white-space:normal;background-color:#FFFFFF;\">sort()</span>,D:<span style=\"color:#333333;font-family:Arial, &quot;font-size:16px;font-weight:bold;white-space:normal;background-color:#FFFFFF;\">length()</span>', 'ABCD', '无', '2017-08-01 11:01:45', '0');
INSERT INTO `examination_questions` VALUES ('17', '1', '0', '50', '0', '<span style=\"color:#333333;font-family:Arial, &quot;font-size:20px;white-space:normal;background-color:#FFFFFF;\">在JavaScript中( )以下哪些是数组的方法？</span>', 'A:add(),B:join(),C:sort(),D:length()', 'ABCD', '无', '2017-08-01 11:03:11', '0');

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(200) DEFAULT '' COMMENT '图片地址',
  `link_address` varchar(255) DEFAULT NULL COMMENT '图链接地址',
  `title` varchar(255) DEFAULT NULL COMMENT '图标题',
  `type` varchar(50) DEFAULT NULL COMMENT '图片类型',
  `series_number` int(11) DEFAULT '0' COMMENT '序列号',
  `preview_url` varchar(255) DEFAULT NULL COMMENT '略缩图片地址',
  `color` varchar(255) DEFAULT '' COMMENT '背景色',
  `describes` varchar(600) DEFAULT '' COMMENT '图片描述',
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='banner图管理';

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('3', 'C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.8024206894220877790.8080\\upload\\temp\\017072515225山东省.png', 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('4', 'C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.5409504271992610987.8080\\upload\\temp\\0170725152253.png', 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('5', 'C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.686254142645787725.8080\\upload\\temp\\017072515225山东省.png', 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('6', 'C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.5735341519338277857.8080\\upload\\temp\\0170725152253.png', 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('7', 'C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.796314765814878327.8080\\upload\\temp\\017072515225山东省.png', 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('8', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('9', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('10', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('11', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('12', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('13', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('14', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('15', null, 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');
INSERT INTO `images` VALUES ('16', 'images/2017-07-28/20170728104701.png', 'www.sohu.com', '首页', '1', '1', 'ret', '123456', '首页轮播图片');

-- ----------------------------
-- Table structure for meta
-- ----------------------------
DROP TABLE IF EXISTS `meta`;
CREATE TABLE `meta` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type_id` int(10) unsigned NOT NULL COMMENT '所属类型ID',
  `value` varchar(255) NOT NULL COMMENT '元数据的代码值（一般是英文字符）',
  `label` text NOT NULL COMMENT '元数据的标签文本（一般是中文名称）',
  `group` varchar(255) NOT NULL COMMENT '所属群组',
  `status` int(10) unsigned NOT NULL COMMENT '元数据状态：0=停用，1=启用',
  `meta_order` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '元数据顺序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_type_id_and_value` (`type_id`,`value`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='元数据表';

-- ----------------------------
-- Records of meta
-- ----------------------------

-- ----------------------------
-- Table structure for meta_type
-- ----------------------------
DROP TABLE IF EXISTS `meta_type`;
CREATE TABLE `meta_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '类型名称',
  `code` varchar(255) NOT NULL COMMENT '类型代码',
  `status` int(11) unsigned NOT NULL COMMENT '类型状态：0=停用，1=启用',
  `type_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '类型排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='元数据类型表';

-- ----------------------------
-- Records of meta_type
-- ----------------------------

-- ----------------------------
-- Table structure for msg_receive
-- ----------------------------
DROP TABLE IF EXISTS `msg_receive`;
CREATE TABLE `msg_receive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `receiving_cus_id` bigint(20) DEFAULT NULL,
  `showname` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_receive
-- ----------------------------
INSERT INTO `msg_receive` VALUES ('3', '2017-07-08 09:53:02', '从撒旦撒', null, null, '25', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('4', '2017-07-08 09:53:03', '从撒旦撒', null, null, '26', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('5', '2017-07-08 09:55:06', 'fdsadsad', null, null, '25', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('6', '2017-07-08 09:55:06', 'fdsadsad', null, null, '26', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('7', '2017-07-08 10:02:28', '<img src=\"http://localhost:4000/view/admin/static/common/kindeditor/plugins/emoticons/images/18.gif\" border=\"0\" alt=\"\" />', null, null, '25', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('8', '2017-07-08 10:03:51', '<img src=\"http://localhost:4000/view/admin/static/common/kindeditor/plugins/emoticons/images/20.gif\" border=\"0\" alt=\"\" />', null, null, '26', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('9', '2017-07-08 10:04:26', '<img src=\"http://localhost:4000/view/admin/static/common/kindeditor/plugins/emoticons/images/32.gif\" border=\"0\" alt=\"\" />', null, null, '25', null, '0', '0', null);
INSERT INTO `msg_receive` VALUES ('10', '2017-07-08 10:04:51', '<img src=\"http://localhost:4000/view/admin/static/common/kindeditor/plugins/emoticons/images/19.gif\" border=\"0\" alt=\"\" />', null, null, '26', null, '0', '0', null);

-- ----------------------------
-- Table structure for msg_system
-- ----------------------------
DROP TABLE IF EXISTS `msg_system`;
CREATE TABLE `msg_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `add_time_str` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_system
-- ----------------------------
INSERT INTO `msg_system` VALUES ('1', '2017-07-04 14:45:43', null, '哈哈哈', '2017-07-11 14:46:27', '0', '2017-07-10 14:46:37');
INSERT INTO `msg_system` VALUES ('2', '2017-07-27 14:49:09', null, '悠悠浮生，年华似锦。', '2017-07-10 14:46:37', '0', null);
INSERT INTO `msg_system` VALUES ('4', '2017-07-08 10:24:42', null, '都十分大方的说法', null, '0', null);
INSERT INTO `msg_system` VALUES ('5', '2017-07-10 11:00:09', null, 'dfsf<img src=\"http://localhost:4000/view/admin/static/common/kindeditor/plugins/emoticons/images/33.gif\" border=\"0\" alt=\"\" />', null, '0', null);
INSERT INTO `msg_system` VALUES ('6', '2017-07-10 11:01:14', null, 'sadsa<img src=\"http://localhost:4000/view/admin/static/common/kindeditor/plugins/emoticons/images/14.gif\" border=\"0\" alt=\"\" />', null, '0', null);
INSERT INTO `msg_system` VALUES ('7', '2017-07-10 11:07:19', null, 'ggf', null, '0', null);
INSERT INTO `msg_system` VALUES ('8', '2017-07-13 16:22:47', null, 'deds', null, '0', null);

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `target_id` int(20) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of praise
-- ----------------------------
INSERT INTO `praise` VALUES ('1', '2017-07-11 18:07:06', '2', '2', '2');
INSERT INTO `praise` VALUES ('10', '2017-07-20 15:22:18', '5', '2', '36');
INSERT INTO `praise` VALUES ('14', '2017-07-31 16:21:42', '4', '2', '44');

-- ----------------------------
-- Table structure for query_course_note
-- ----------------------------
DROP TABLE IF EXISTS `query_course_note`;
CREATE TABLE `query_course_note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `kpoint_id` bigint(20) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `point_name` varchar(255) DEFAULT NULL,
  `short_content` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of query_course_note
-- ----------------------------

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `begin_create_time` datetime DEFAULT NULL,
  `browse_count` int(11) DEFAULT NULL,
  `comment_user_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_create_time` datetime DEFAULT NULL,
  `model_time` varchar(255) DEFAULT NULL,
  `order_falg` varchar(255) DEFAULT NULL,
  `pic_img` varchar(255) DEFAULT NULL,
  `praise_count` int(11) DEFAULT NULL,
  `questions_tag_id` bigint(20) DEFAULT NULL,
  `reply_count` int(11) DEFAULT NULL,
  `show_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', null, null, '0', null, '付出与收获成正比！', null, null, null, null, null, null, '22', null, '0', null, '0', null, '0');
INSERT INTO `questions` VALUES ('2', '2017-07-20 17:19:16', null, '0', null, '愿意付出多少？', null, '785396938@qq.com', null, null, null, null, '99', null, '0', 'admin', '0', '付出', '1');

-- ----------------------------
-- Table structure for questions_comment
-- ----------------------------
DROP TABLE IF EXISTS `questions_comment`;
CREATE TABLE `questions_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `begin_create_time` datetime DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_create_time` datetime DEFAULT NULL,
  `is_best` int(11) NOT NULL,
  `limit_size` int(11) NOT NULL,
  `order_flag` varchar(255) DEFAULT NULL,
  `pic_img` varchar(255) DEFAULT NULL,
  `praise_count` int(11) NOT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `questions_status` int(11) NOT NULL,
  `questions_title` varchar(255) DEFAULT NULL,
  `reply_count` int(11) NOT NULL,
  `show_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions_comment
-- ----------------------------

-- ----------------------------
-- Table structure for questions_tag
-- ----------------------------
DROP TABLE IF EXISTS `questions_tag`;
CREATE TABLE `questions_tag` (
  `questions_tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `questions_tag_name` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`questions_tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions_tag
-- ----------------------------

-- ----------------------------
-- Table structure for questions_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `questions_tag_relation`;
CREATE TABLE `questions_tag_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `questions_id` bigint(20) DEFAULT NULL,
  `questions_tag_id` bigint(20) DEFAULT NULL,
  `tag_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions_tag_relation
-- ----------------------------

-- ----------------------------
-- Table structure for statistics_day
-- ----------------------------
DROP TABLE IF EXISTS `statistics_day`;
CREATE TABLE `statistics_day` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `daily_course_number` bigint(20) DEFAULT NULL,
  `daily_user_number` bigint(20) DEFAULT NULL,
  `login_num` bigint(20) DEFAULT NULL,
  `registered_num` bigint(20) DEFAULT NULL,
  `statistics_time` datetime DEFAULT NULL,
  `video_viewing_num` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statistics_day
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0' COMMENT '父id  默认为0  0=父专业',
  `sort` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subject_name` varchar(255) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('29', '2017-07-01 15:18:13', '0', '2', '0', '后端开发');
INSERT INTO `subject` VALUES ('31', '2017-07-06 11:50:40', '0', '3', '0', '移动开发');
INSERT INTO `subject` VALUES ('34', '2017-07-07 09:37:54', '3', '4', '0', '数据库');
INSERT INTO `subject` VALUES ('36', '2017-07-07 10:06:58', '22', '5', '0', '云计算');
INSERT INTO `subject` VALUES ('38', '2017-07-07 10:07:01', '35', '6', '0', '运维');
INSERT INTO `subject` VALUES ('39', '2017-07-07 10:07:22', '0', '7', '0', 'UI设计');
INSERT INTO `subject` VALUES ('49', '2017-07-07 14:50:12', '21', '0', '0', 'HTML/CSS');
INSERT INTO `subject` VALUES ('50', '2017-07-07 14:50:31', '21', '0', '0', 'JavaScript');
INSERT INTO `subject` VALUES ('51', '2017-07-07 14:51:11', '21', '0', '0', 'Html5');
INSERT INTO `subject` VALUES ('52', '2017-07-07 14:51:22', '21', '0', '0', 'CSS3');
INSERT INTO `subject` VALUES ('53', '2017-07-07 14:51:32', '29', '0', '0', 'php');
INSERT INTO `subject` VALUES ('54', '2017-07-07 14:51:47', '29', '0', '0', 'Java');
INSERT INTO `subject` VALUES ('55', '2017-07-07 14:51:57', '29', '0', '0', 'Python');
INSERT INTO `subject` VALUES ('56', '2017-07-07 14:52:13', '29', '0', '0', 'C');
INSERT INTO `subject` VALUES ('58', '2017-07-07 14:52:38', '31', '0', '0', 'Android');
INSERT INTO `subject` VALUES ('59', '2017-07-07 14:52:55', '31', '0', '0', 'IOS');
INSERT INTO `subject` VALUES ('60', '2017-07-07 14:53:08', '31', '0', '0', 'Cocos2d-x');
INSERT INTO `subject` VALUES ('61', '2017-07-07 14:53:37', '34', '0', '0', 'MySQL');
INSERT INTO `subject` VALUES ('62', '2017-07-07 14:53:50', '34', '0', '0', 'MongoDB');
INSERT INTO `subject` VALUES ('63', '2017-07-07 14:54:09', '36', '0', '0', '大数据');
INSERT INTO `subject` VALUES ('64', '2017-07-07 14:55:06', '36', '0', '0', '云计算');
INSERT INTO `subject` VALUES ('65', '2017-07-07 14:55:36', '39', '0', '0', '动画动效');
INSERT INTO `subject` VALUES ('66', '2017-07-18 16:50:21', '0', '0', '0', '新建专业');
INSERT INTO `subject` VALUES ('67', '2017-08-01 10:26:58', '49', '0', '0', '新建专业');

-- ----------------------------
-- Table structure for sys_function
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `function_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `function_name` varchar(255) DEFAULT NULL,
  `function_type` int(11) NOT NULL,
  `function_url` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_login_ip` varchar(255) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `login_pwd` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login_log`;
CREATE TABLE `sys_user_login_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `os_name` varchar(255) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_operation
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_operation`;
CREATE TABLE `sys_user_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户记录表',
  `name` varchar(50) DEFAULT NULL COMMENT '操作人',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `operation` varchar(50) DEFAULT NULL COMMENT '操作描述',
  `time` datetime DEFAULT NULL COMMENT '操作时间',
  `remarks` text COMMENT '备注',
  `end_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_operation
-- ----------------------------
INSERT INTO `sys_user_operation` VALUES ('1', '1', '2', '2', '2017-07-04 09:11:42', '2', null, null);
INSERT INTO `sys_user_operation` VALUES ('2', '12', '1', '1', '2017-07-19 14:37:05', '22', null, null);
INSERT INTO `sys_user_operation` VALUES ('3', '1', null, null, '2017-07-04 15:20:05', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('4', '1', '2', null, '2017-07-04 15:22:15', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('5', 'admin', null, null, '2017-07-10 17:34:15', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('6', 'admin', null, null, '2017-07-10 18:10:23', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('7', 'admin', null, null, '2017-07-10 18:15:12', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('8', 'admin', null, null, '2017-07-11 09:05:32', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('10', 'admin', null, '注册用户', '2017-07-11 09:47:32', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('11', 'admin', null, '修改', '2017-07-17 16:23:54', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('12', 'admin', '2', '修改用户信息', '2017-07-17 17:12:40', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('13', 'admin', '2', '修改用户信息', '2017-07-17 17:43:09', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('14', 'admin', '2', '修改用户信息', '2017-07-17 17:44:54', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('15', 'admin', '2', '修改用户信息', '2017-07-17 18:30:23', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('16', 'admin', '3', '删除教师角色', '2017-07-17 18:43:34', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('17', 'admin', '3', '删除教师角色', '2017-07-17 18:47:03', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('18', 'admin', '1', '注册用户角色', '2017-07-21 15:22:17', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('19', 'admin', '1', '注册用户角色', '2017-07-21 15:22:31', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('20', 'admin', '2', '修改用户信息', '2017-07-21 15:33:10', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('21', 'admin', '2', '修改用户信息', '2017-07-21 15:35:50', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('22', 'admin', '1', '新增教师角色', '2017-07-21 17:20:37', null, null, null);
INSERT INTO `sys_user_operation` VALUES ('23', 'admin', '2', '修改用户信息', '2017-08-01 10:35:30', null, null, null);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `real_name` varchar(12) NOT NULL COMMENT '教师名称',
  `profile` text NOT NULL COMMENT '教师简介',
  `pic_path` varchar(200) DEFAULT '' COMMENT '图片路径',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '状态:0正常1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('7', 'ç§é£', 'å¾ç', 'images/2017-07-31/20170731154806.jpg', '0', '2017-07-01 17:59:42', '0', '22');
INSERT INTO `teacher` VALUES ('8', '宋汪洋', '他一直是一个非常牛逼的老师', '', '0', '2017-07-01 17:59:42', '1000', '22');
INSERT INTO `teacher` VALUES ('9', '宋汪洋', '他一直是一个非常牛逼的老师', '', '0', '2017-07-01 17:59:42', '1000', '22');
INSERT INTO `teacher` VALUES ('11', '王溶', '他一直是一个非常牛逼的老师~', 'C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.3707308324823593520.8080\\upload\\images\\20170707093715.png', '0', '2017-07-07 09:37:17', '1000', '25');

-- ----------------------------
-- Table structure for template_file
-- ----------------------------
DROP TABLE IF EXISTS `template_file`;
CREATE TABLE `template_file` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_address` varchar(300) DEFAULT NULL COMMENT '文件地址',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `profile` varchar(255) NOT NULL DEFAULT '' COMMENT '文件简介',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '类型',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态  0正常 1异常',
  `context` longtext COMMENT '详情  文件地址为空的时候该字段用做协议详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='模板文件表';

-- ----------------------------
-- Records of template_file
-- ----------------------------
INSERT INTO `template_file` VALUES ('13', 'text/2017-07-10/', '20170710111753.xlsx', '批量创建学员用户导入数据模板', '2017-07-10 11:19:21', '0', '0', null);

-- ----------------------------
-- Table structure for test_assembly
-- ----------------------------
DROP TABLE IF EXISTS `test_assembly`;
CREATE TABLE `test_assembly` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `paper_id` int(11) NOT NULL COMMENT '试卷id',
  `assembly_type` int(2) NOT NULL COMMENT '组卷题型 （0：单选题:1：多选题 2：判断题 3：填空题 4：简答题等）  ',
  `show_name` varchar(255) DEFAULT NULL COMMENT '显示名称（一般默认显示题型）  ',
  `single_score` int(3) NOT NULL COMMENT '单题分数  ',
  `questions_number` int(2) NOT NULL COMMENT '题目数量',
  `assembly_describe` text NOT NULL COMMENT '题目描述  ',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='试卷组卷表';

-- ----------------------------
-- Records of test_assembly
-- ----------------------------

-- ----------------------------
-- Table structure for test_paper
-- ----------------------------
DROP TABLE IF EXISTS `test_paper`;
CREATE TABLE `test_paper` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `paper_name` varchar(255) NOT NULL COMMENT '试卷标题',
  `subject_id` int(11) NOT NULL COMMENT '专业',
  `paper_type` int(2) NOT NULL COMMENT '试卷类型 （0：模拟考试 1：课后作业）  ',
  `answer_time` int(5) DEFAULT NULL COMMENT '答题时间 单位为分钟  ',
  `total_score` int(3) NOT NULL COMMENT '试卷总分  ',
  `difficulty` int(2) NOT NULL COMMENT '难度（0：简单 1：普通 2：困难）  ',
  `paper_describe` text NOT NULL COMMENT '试卷描述  ',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `test_set` varchar(255) DEFAULT NULL COMMENT '试题id存放地',
  `status` int(2) DEFAULT '0' COMMENT '状态 0：启用1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='试卷表';

-- ----------------------------
-- Records of test_paper
-- ----------------------------
INSERT INTO `test_paper` VALUES ('1', '创建试卷测试', '29', '1', '40', '60', '1', '修改试卷功能节点测试', null, '11,12,13,4,15,16,17,6,7,8,9,10', '0');
INSERT INTO `test_paper` VALUES ('2', '创建试卷测试1', '21', '0', '60', '100', '0', '创建试卷测试功能节点', '2017-07-20 15:15:19', '1,2,3,4,5,6,7', '0');
INSERT INTO `test_paper` VALUES ('3', '前端结课试卷', '21', '1', '60', '100', '0', '试卷包括单选题、多选题、简答题等', '2017-07-24 16:25:53', null, '0');
INSERT INTO `test_paper` VALUES ('4', '史上最全前端面试题', '21', '1', '90', '100', '0', '标签闭合、标签小写、不乱嵌套、提高搜索机器人搜索几率、使用外 链css和js脚本、结构行为表现的分离、文件下载与页面速度更快、内容能被更多的用户所访问、内容能被更广泛的设备所访问、更少的代码和组件，容易维 护、改版方便，不需要变动页面内容、提供打印版本而不需要复制内容、提高网站易用性；', '2017-07-31 14:50:31', null, '0');
INSERT INTO `test_paper` VALUES ('5', 'PHP结课测试', '53', '1', '100', '120', '0', '为了兼顾IIS下PHP的效率和安全，微软给出了FastCGI的解决方案。FastCGI可以让PHP的进程重复利用而不是每一个新的请求就重开一个进程。同时FastCGI也可以允许几个进程同时执行。这样既解决了CGI进程模式消耗太大的问题，又利用上了CGI进程模式不存在线程安全问题的优势。', '2017-07-31 17:20:03', null, '1');

-- ----------------------------
-- Table structure for test_score
-- ----------------------------
DROP TABLE IF EXISTS `test_score`;
CREATE TABLE `test_score` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `paper_id` int(11) NOT NULL COMMENT '试卷标题',
  `user_id` int(11) NOT NULL COMMENT '参加测试用户',
  `score` decimal(10,2) NOT NULL COMMENT '测试成绩  ',
  `test_time` datetime NOT NULL COMMENT '测试时间 ',
  `answer` varchar(1000) NOT NULL COMMENT '正确答案',
  `user_answer` varchar(1000) NOT NULL COMMENT '用户答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='考试成绩记录表';

-- ----------------------------
-- Records of test_score
-- ----------------------------
INSERT INTO `test_score` VALUES ('3', '2', '35', '50.00', '2017-07-26 16:09:29', '[D, D]', '[b, d]');
INSERT INTO `test_score` VALUES ('4', '2', '35', '50.00', '2017-07-26 17:12:50', '[D, D]', '[b, d]');
INSERT INTO `test_score` VALUES ('5', '2', '35', '0.00', '2017-07-26 17:15:19', '[BCD, D]', '[b, bcd]');
INSERT INTO `test_score` VALUES ('6', '2', '35', '0.00', '2017-07-26 17:17:26', '[BCD, D]', '[b, bcd]');
INSERT INTO `test_score` VALUES ('7', '2', '35', '0.00', '2017-07-26 17:20:11', '[BCD, D]', '[b, bcd]');
INSERT INTO `test_score` VALUES ('8', '2', '35', '100.00', '2017-07-26 17:20:58', '[BCD, D]', '[bcd, d]');
INSERT INTO `test_score` VALUES ('9', '2', '35', '80.00', '2017-07-26 17:37:45', '[BCD, D, D, A, A]', '[bcd, d, d, a, c]');
INSERT INTO `test_score` VALUES ('10', '1', '44', '0.00', '2017-08-01 11:06:12', '[B]', '[A]');
INSERT INTO `test_score` VALUES ('11', '1', '44', '6.00', '2017-08-01 11:18:43', '[B]', '[B]');
INSERT INTO `test_score` VALUES ('12', '1', '44', '20.00', '2017-08-01 17:08:22', '[B, ABCD, ABCD, ABCD, A, A, A, A, A, A, A]', '[B, BCD, BD, BC, B, A, B, A, B, A, B]');
INSERT INTO `test_score` VALUES ('13', '1', '44', '10.00', '2017-08-01 17:19:21', '[B, ABCD, ABCD, ABCD, A, A, A, A, A, A, A]', '[B, CD, BC, ABCD, B, B, B, B, B, B, B]');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_type` int(11) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `pic_path` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('35', '2017-07-07 19:12:15', '0', '', '', '', null, null, 'admin', '0', null, 'images/2017-08-01/20170801103631.png', '0', null);
INSERT INTO `user` VALUES ('43', '2017-07-12 18:09:53', '27', '785396938@qq.com', 'a7698ef8ca151fab8c035d003f581509eee8d8b8', '18774052122', null, '男', 'xiechangsong', '0', '谢昌松', null, '0', null);
INSERT INTO `user` VALUES ('44', '2017-07-12 18:09:53', '0', '45789562@qq.com', '3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d', '18874589658', null, '男', 'qiufeng', '0', '邱风', null, '0', null);
INSERT INTO `user` VALUES ('45', '2017-07-12 18:09:53', '0', 'wangrong@163.com', '', '17485965236', null, '女', 'wangrong', '0', '王蓉', 'images/2017-08-01/20170801104823.png', '0', null);

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desired_position` varchar(255) DEFAULT NULL,
  `expected_salary` double NOT NULL,
  `profiles` varchar(255) DEFAULT NULL,
  `specialty` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc2fr118twu8aratnm1qop1mn9` (`user_id`),
  CONSTRAINT `FKc2fr118twu8aratnm1qop1mn9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail
-- ----------------------------

-- ----------------------------
-- Table structure for user_email_msg
-- ----------------------------
DROP TABLE IF EXISTS `user_email_msg`;
CREATE TABLE `user_email_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_email_msg
-- ----------------------------

-- ----------------------------
-- Table structure for user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `os_name` varchar(255) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_mobile_msg
-- ----------------------------
DROP TABLE IF EXISTS `user_mobile_msg`;
CREATE TABLE `user_mobile_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_mobile_msg
-- ----------------------------

-- ----------------------------
-- Table structure for website_course
-- ----------------------------
DROP TABLE IF EXISTS `website_course`;
CREATE TABLE `website_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_num` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of website_course
-- ----------------------------

-- ----------------------------
-- Table structure for website_ehcache
-- ----------------------------
DROP TABLE IF EXISTS `website_ehcache`;
CREATE TABLE `website_ehcache` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ehcache_desc` varchar(255) DEFAULT NULL,
  `ehcache_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of website_ehcache
-- ----------------------------

-- ----------------------------
-- Table structure for web_site_images_type
-- ----------------------------
DROP TABLE IF EXISTS `web_site_images_type`;
CREATE TABLE `web_site_images_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_site_images_type
-- ----------------------------
