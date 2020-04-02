/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : baotuan

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 01/04/2020 20:36:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brokerages
-- ----------------------------
DROP TABLE IF EXISTS `brokerages`;
CREATE TABLE `brokerages`  (
  `id` int(11) NOT NULL COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '金额',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `brokerages_type_id` int(11) NULL DEFAULT NULL COMMENT '分佣类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '金额记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for brokerages_type
-- ----------------------------
DROP TABLE IF EXISTS `brokerages_type`;
CREATE TABLE `brokerages_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '转账类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brokerages_type
-- ----------------------------
INSERT INTO `brokerages_type` VALUES (1, 'Withdraw', '提现记录', '用户提现记录');
INSERT INTO `brokerages_type` VALUES (2, 'Task', '任务奖励', '用户任务所得');
INSERT INTO `brokerages_type` VALUES (3, 'Invite', '邀请奖励', '用户邀请人成为会员所得');
INSERT INTO `brokerages_type` VALUES (4, 'Brokerage', '分佣奖励', '用户邀请人做任务所得');

-- ----------------------------
-- Table structure for gathering
-- ----------------------------
DROP TABLE IF EXISTS `gathering`;
CREATE TABLE `gathering`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收款id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '付款用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '付款金额',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `overtime` datetime(0) NULL DEFAULT NULL COMMENT '到款时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收款记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员等级id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员等级编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员名称',
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员权益',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '会员价格',
  `up_money` double(255, 2) NULL DEFAULT NULL COMMENT '升级费用',
  `task_number` int(11) NULL DEFAULT NULL COMMENT '没日任务数量',
  `url` int(255) NULL DEFAULT NULL COMMENT '支付宝二维码',
  `up_url` int(255) NULL DEFAULT NULL COMMENT '升级二维码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `url`(`url`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 'Regular', '普通会员', '无权益', 0.00, 0.00, 0, NULL, NULL);
INSERT INTO `member` VALUES (2, 'Low', '初级会员', '每天可接8个任务', 299.00, 299.00, 1, NULL, NULL);
INSERT INTO `member` VALUES (3, 'Middle', '中级会员', '每天可接15个任务', 599.00, 300.00, 15, NULL, NULL);
INSERT INTO `member` VALUES (4, 'High', '高级会员', '每天可接25个任务', 999.00, 400.00, 25, NULL, NULL);

-- ----------------------------
-- Table structure for notic
-- ----------------------------
DROP TABLE IF EXISTS `notic`;
CREATE TABLE `notic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_status
-- ----------------------------
DROP TABLE IF EXISTS `pay_status`;
CREATE TABLE `pay_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '支付状态id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_status
-- ----------------------------
INSERT INTO `pay_status` VALUES (1, 'Unpaid', '待支付', '用户发起提现');
INSERT INTO `pay_status` VALUES (2, 'Paid', '支付完成', '提现到账');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `permission_id`(`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后台用户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '后台用户姓名',
  `login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `system_user_id` int(11) NULL DEFAULT NULL COMMENT '系统用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `system_user_role_ibfk_1`(`system_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_withdrawals
-- ----------------------------
DROP TABLE IF EXISTS `sys_withdrawals`;
CREATE TABLE `sys_withdrawals`  (
  `id` int(11) NOT NULL COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '提款金额',
  `pay_money` double(255, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `pay_status_id` int(11) NULL DEFAULT NULL COMMENT '支付状态',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '转款记录 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务标题',
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务描述',
  `number` int(11) NOT NULL COMMENT '任务数量',
  `surplus` int(11) NOT NULL COMMENT '任务剩余数量',
  `money` double(255, 2) NOT NULL DEFAULT 0.00 COMMENT '任务金额',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务链接',
  `task_type_id` int(11) NOT NULL COMMENT '任务类型id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_type_id`(`task_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, '抖音测试', '点赞+关注', 100, 0, 100.50, 'https://v.douyin.com/72wmSN/', 1, '2020-03-19 11:50:23');
INSERT INTO `task` VALUES (2, '抖音测试2', '点赞+关注', 100, 0, 100.50, 'https://v.douyin.com/72wmSN/', 1, '2020-03-30 12:13:15');

-- ----------------------------
-- Table structure for task_status
-- ----------------------------
DROP TABLE IF EXISTS `task_status`;
CREATE TABLE `task_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务状态id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务状态名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务状态简要说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_status
-- ----------------------------
INSERT INTO `task_status` VALUES (1, 'Unfinished', '待完成', NULL);
INSERT INTO `task_status` VALUES (2, 'Finish', '已完成', NULL);

-- ----------------------------
-- Table structure for task_type
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务类型id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务类型编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务类型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务类型简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_type
-- ----------------------------
INSERT INTO `task_type` VALUES (1, 'DY_video', '抖音', '抖音视频');

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上传文件id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传文件名称',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '上传人编码',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传路径',
  `size` double NULL DEFAULT NULL COMMENT '上传文件大小',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '上传文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编码',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电话/登录账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码',
  `invite_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人邀请码',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `Alipay_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝账号',
  `Alipay_url` int(11) NULL DEFAULT NULL COMMENT '支付宝二维码',
  `money` double(255, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  `member_id` int(11) NULL DEFAULT 0 COMMENT '会员id',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用(1:启用 0:禁用)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `zfb_url`(`Alipay_url`) USING BTREE,
  INDEX `member_id`(`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张超群', '0-0A-00001', '18501350323', '00354c49b4a97da913f2a76f437b07f4', 'zhangC', NULL, NULL, NULL, 0.00, 2, 1);

-- ----------------------------
-- Table structure for user_task
-- ----------------------------
DROP TABLE IF EXISTS `user_task`;
CREATE TABLE `user_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户任务id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `task_id` int(11) NOT NULL COMMENT '任务id',
  `task_status_id` int(11) NULL DEFAULT NULL COMMENT '任务状态id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '接取时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `task_id`(`task_id`) USING BTREE,
  INDEX `task_status_id`(`task_status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户任务记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_task
-- ----------------------------
INSERT INTO `user_task` VALUES (1, 1, 1, 0, '2020-04-01 12:30:36');
INSERT INTO `user_task` VALUES (2, 1, 2, 0, '2020-04-01 12:30:37');

-- ----------------------------
-- View structure for view_user
-- ----------------------------
DROP VIEW IF EXISTS `view_user`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_user` AS select `user`.`id` AS `id`,`user`.`code` AS `user_code`,`user`.`phone` AS `phone`,`user`.`password` AS `password`,`user`.`invite_code` AS `invite_code`,`user`.`user_id` AS `user_id`,`user`.`Alipay_account` AS `zfb_account`,`user`.`Alipay_url` AS `zfb_url`,`user`.`money` AS `money`,`user`.`member_id` AS `member_id`,`user`.`enabled` AS `enabled`,`member`.`code` AS `code`,`member`.`name` AS `name`,`inviter`.`code` AS `inviter_code`,`inviter_member`.`code` AS `inviter_member_code`,`inviter_member`.`name` AS `inviter_member_name`,`inviter_member`.`money` AS `user_member_money`,`inviter_member`.`money` AS `inviter_member_money`,`member`.`task_number` AS `task_number` from (((`user` left join `member` on((`user`.`member_id` = `member`.`id`))) left join `user` `inviter` on((`user`.`user_id` = `inviter`.`id`))) left join `member` `inviter_member` on((`inviter`.`member_id` = `member`.`id`)));

-- ----------------------------
-- View structure for view_user_task
-- ----------------------------
DROP VIEW IF EXISTS `view_user_task`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_user_task` AS select `user_task`.`id` AS `id`,`user_task`.`user_id` AS `user_id`,`user_task`.`task_id` AS `task_id`,`user_task`.`task_status_id` AS `task_status_id`,`user`.`money` AS `user_money`,`task`.`money` AS `task_money`,`user`.`user_id` AS `invite_id`,`task`.`createtime` AS `createtime`,`task`.`title` AS `title`,`task`.`context` AS `context`,`task`.`url` AS `url`,`user_task`.`createtime` AS `user_task_createtime` from ((`user_task` left join `user` on((`user_task`.`user_id` = `user`.`id`))) left join `task` on((`user_task`.`task_id` = `task`.`id`)));

SET FOREIGN_KEY_CHECKS = 1;
