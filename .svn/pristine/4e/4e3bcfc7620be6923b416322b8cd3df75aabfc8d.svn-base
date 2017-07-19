/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_practical_training_v1_0_0

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-07-12 18:22:20
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `begin_create_time` datetime DEFAULT NULL,
  `comment_number` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `course_id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_create_time` datetime DEFAULT NULL,
  `limit_number` int(11) NOT NULL,
  `other_id` int(11) NOT NULL,
  `p_comment_id` int(11) NOT NULL,
  `pic_img` varchar(255) DEFAULT NULL,
  `praise_count` int(11) NOT NULL,
  `reply_count` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('12', '历史', '22', '2017-07-05 16:24:22', '历史', '阿达阿萨德', '12', '1', '1');

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
  `KPOINT_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) DEFAULT '0' COMMENT '课程id',
  `NAME` varchar(300) DEFAULT NULL COMMENT '节点名称',
  `PARENT_ID` int(11) DEFAULT '0' COMMENT '父级ID',
  `ADD_TIME` datetime DEFAULT NULL COMMENT '添加时间',
  `SORT` int(11) DEFAULT '0' COMMENT '显示排序',
  `VIDEO_URL` varchar(500) DEFAULT NULL COMMENT '视频地址',
  `TEACHER_ID` int(11) DEFAULT '0' COMMENT '讲师id',
  `KPOINT_TYPE` int(1) DEFAULT '0' COMMENT '节点类型 0文件目录 1视频',
  `VIDEO_TYPE` varchar(30) DEFAULT NULL COMMENT '视频类型',
  `FILE_TYPE` varchar(20) DEFAULT NULL COMMENT 'VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集',
  `CONTENT` longtext COMMENT '文本',
  PRIMARY KEY (`KPOINT_ID`),
  KEY `course_id` (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='知识点的基本信息';

-- ----------------------------
-- Records of course_kpoint
-- ----------------------------
INSERT INTO `course_kpoint` VALUES ('144', '2', '新建视频', '0', '2017-07-07 17:52:14', '0', null, '0', '0', null, null, null);
INSERT INTO `course_kpoint` VALUES ('145', '2', '新建视频', '0', '2017-07-07 17:52:16', '0', null, '0', '0', null, null, null);
INSERT INTO `course_kpoint` VALUES ('146', '2', '新建视频', '0', '2017-07-07 17:52:18', '0', null, '0', '0', null, null, null);
INSERT INTO `course_kpoint` VALUES ('147', '2', '新建视频', '0', '2017-07-07 17:55:23', '0', null, '0', '0', null, null, null);
INSERT INTO `course_kpoint` VALUES ('151', '12', '新建视频', '0', '2017-07-07 18:26:15', '0', null, '0', '0', null, null, null);
INSERT INTO `course_kpoint` VALUES ('152', '12', '新建视频', '0', '2017-07-07 18:26:16', '0', null, '0', '0', null, null, null);
INSERT INTO `course_kpoint` VALUES ('153', '12', '新建视频', '0', '2017-07-07 18:26:22', '0', null, '0', '0', null, null, null);

-- ----------------------------
-- Table structure for course_note
-- ----------------------------
DROP TABLE IF EXISTS `course_note`;
CREATE TABLE `course_note` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(11) DEFAULT '0' COMMENT '用户ID',
  `COURSE_ID` int(11) NOT NULL DEFAULT '0' COMMENT '课程id',
  `KPOINT_ID` int(11) NOT NULL DEFAULT '0' COMMENT '节点ID',
  `CONTENT` longtext NOT NULL COMMENT '笔记信息',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `STATUS` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0公开1隐藏',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_receive
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_system
-- ----------------------------

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `target_id` bigint(20) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of praise
-- ----------------------------

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
  `browse_count` int(11) NOT NULL,
  `comment_user_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_create_time` datetime DEFAULT NULL,
  `model_time` varchar(255) DEFAULT NULL,
  `order_falg` varchar(255) DEFAULT NULL,
  `pic_img` varchar(255) DEFAULT NULL,
  `praise_count` int(11) NOT NULL,
  `questions_tag_id` bigint(20) DEFAULT NULL,
  `reply_count` int(11) NOT NULL,
  `show_name` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('21', '2017-07-01 14:33:44', '3', '1', '0', '前端开发');
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
INSERT INTO `subject` VALUES ('57', '2017-07-07 14:52:20', '29', '0', '0', 'C  ');
INSERT INTO `subject` VALUES ('58', '2017-07-07 14:52:38', '31', '0', '0', 'Android');
INSERT INTO `subject` VALUES ('59', '2017-07-07 14:52:55', '31', '0', '0', 'IOS');
INSERT INTO `subject` VALUES ('60', '2017-07-07 14:53:08', '31', '0', '0', 'Cocos2d-x');
INSERT INTO `subject` VALUES ('61', '2017-07-07 14:53:37', '34', '0', '0', 'MySQL');
INSERT INTO `subject` VALUES ('62', '2017-07-07 14:53:50', '34', '0', '0', 'MongoDB');
INSERT INTO `subject` VALUES ('63', '2017-07-07 14:54:09', '36', '0', '0', '大数据');
INSERT INTO `subject` VALUES ('64', '2017-07-07 14:55:06', '36', '0', '0', '云计算');
INSERT INTO `subject` VALUES ('65', '2017-07-07 14:55:36', '39', '0', '0', '动画动效');

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_operation
-- ----------------------------

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
INSERT INTO `teacher` VALUES ('7', '宋汪洋', '他一直是一个非常牛逼的老师~', '', '0', '2017-07-01 17:59:42', '0', '22');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='模板文件表';

-- ----------------------------
-- Records of template_file
-- ----------------------------
INSERT INTO `template_file` VALUES ('13', 'text/2017-07-10/', '20170710111753.xlsx', '批量创建学员用户导入数据模板', '2017-07-10 11:19:21', '0', '0', null);

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
INSERT INTO `user` VALUES ('35', '2017-07-07 19:12:15', '0', '', '3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d', '', null, null, 'admin', '2', null, null, '0', null);
INSERT INTO `user` VALUES ('43', '2017-07-12 18:09:53', '27', '785396938@qq.com', 'a7698ef8ca151fab8c035d003f581509eee8d8b8', '18774052122', null, '男', 'xiechangsong', '0', '谢昌松', null, '0', null);
INSERT INTO `user` VALUES ('44', '2017-07-12 18:09:53', '23', '45789562@qq.com', '3a39b76b57d23f9a58072cad5c685713fcbffa28', '18874589658', null, '男', 'qiufeng', '0', '邱风', null, '0', null);
INSERT INTO `user` VALUES ('45', '2017-07-12 18:09:53', '25', 'wangrong@163.com', '007aa226b1d9b60592da320bcbfa04ba45a9d3ff', '17485965236', null, '女', 'wangrong', '0', '王蓉', null, '0', null);

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
