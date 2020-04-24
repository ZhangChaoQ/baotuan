/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : baotuan

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 24/04/2020 09:42:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brokerage
-- ----------------------------
DROP TABLE IF EXISTS `brokerage`;
CREATE TABLE `brokerage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '金额',
  `brokerage_type_id` int(11) NULL DEFAULT NULL COMMENT '余额类型',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `brokerage_status_id` int(11) NULL DEFAULT 2 COMMENT '到款状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '余额记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for brokerage_status
-- ----------------------------
DROP TABLE IF EXISTS `brokerage_status`;
CREATE TABLE `brokerage_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '到款状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brokerage_status
-- ----------------------------
INSERT INTO `brokerage_status` VALUES (1, 'Success', '申请成功', NULL);
INSERT INTO `brokerage_status` VALUES (2, 'Failed', '申请驳回', NULL);
INSERT INTO `brokerage_status` VALUES (3, 'Unpaid', '等待审核', NULL);

-- ----------------------------
-- Table structure for brokerage_type
-- ----------------------------
DROP TABLE IF EXISTS `brokerage_type`;
CREATE TABLE `brokerage_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '余额类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brokerage_type
-- ----------------------------
INSERT INTO `brokerage_type` VALUES (1, 'Withdraw', '提现记录', NULL);
INSERT INTO `brokerage_type` VALUES (2, 'Task', '任务奖励', NULL);
INSERT INTO `brokerage_type` VALUES (3, 'Brokerage', '分佣奖励', NULL);
INSERT INTO `brokerage_type` VALUES (4, 'Invite', '邀请奖励', NULL);

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
INSERT INTO `member` VALUES (2, 'Low', '初级会员', '每天可接8个任务', 299.00, 299.00, 8, NULL, NULL);
INSERT INTO `member` VALUES (3, 'Middle', '中级会员', '每天可接15个任务', 599.00, 300.00, 15, NULL, NULL);
INSERT INTO `member` VALUES (4, 'High', '高级会员', '每天可接25个任务', 999.00, 400.00, 25, NULL, NULL);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `context` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `enabled` tinyint(1) NULL DEFAULT 0 COMMENT '发布状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_img
-- ----------------------------
DROP TABLE IF EXISTS `pay_img`;
CREATE TABLE `pay_img`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付图片地址',
  `enabled` tinyint(1) NULL DEFAULT 0 COMMENT '当前可用 0：不可用 1：可用',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_info
-- ----------------------------
DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买内容',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `pay_money` double(255, 2) NULL DEFAULT NULL COMMENT '应付金额',
  `pay_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付单号',
  `pay_status_id` int(11) NULL DEFAULT NULL COMMENT '审核状态',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败理由',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购买核对' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_status
-- ----------------------------
INSERT INTO `pay_status` VALUES (1, 'Unpaid', '待支付', '用户发起提现');
INSERT INTO `pay_status` VALUES (2, 'Paid', '支付完成', '提现到账');
INSERT INTO `pay_status` VALUES (3, 'Failed', '失败', '驳回');

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
-- Table structure for sys_brokerages
-- ----------------------------
DROP TABLE IF EXISTS `sys_brokerages`;
CREATE TABLE `sys_brokerages`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '金额',
  `pay_money` double(255, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `brokerage_id` int(11) NULL DEFAULT NULL COMMENT '申请提现id',
  `sys_brokerages_status_id` int(11) NULL DEFAULT NULL COMMENT '到款状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '金额记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_brokerages_status
-- ----------------------------
DROP TABLE IF EXISTS `sys_brokerages_status`;
CREATE TABLE `sys_brokerages_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '支付状态id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_brokerages_status
-- ----------------------------
INSERT INTO `sys_brokerages_status` VALUES (1, 'Success', '支付成功', NULL);
INSERT INTO `sys_brokerages_status` VALUES (2, 'Failed', '请求驳回', NULL);
INSERT INTO `sys_brokerages_status` VALUES (3, 'Unpaid', '等待审核', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3');

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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '提款金额',
  `pay_money` double(255, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `pay_status_id` int(11) NULL DEFAULT NULL COMMENT '支付状态',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pay_type` tinyint(1) NULL DEFAULT 0 COMMENT '0转入 1支出',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '转款记录   会员、转款' ROW_FORMAT = Dynamic;

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
  `enabled` tinyint(1) NULL DEFAULT 0 COMMENT '任务发布状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_type_id`(`task_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务' ROW_FORMAT = Dynamic;

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
INSERT INTO `task_status` VALUES (1, 'Unfinished', '未完成', NULL);
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
  `Alipay_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝用户名',
  `Alipay_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝账号',
  `Alipay_url` int(11) NULL DEFAULT NULL COMMENT '支付宝二维码',
  `money` double(255, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  `member_id` int(11) NULL DEFAULT 1 COMMENT '会员id',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用(1:启用 0:禁用)',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `zfb_url`(`Alipay_url`) USING BTREE,
  INDEX `member_id`(`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '0-0A-00001', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'h530Bq', -1, NULL, NULL, NULL, 0.00, 1, 0, '2020-04-22 10:17:05');

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
  `url` int(255) NULL DEFAULT NULL COMMENT '任务图片链接',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `task_id`(`task_id`) USING BTREE,
  INDEX `task_status_id`(`task_status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户任务记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for view_pay_info
-- ----------------------------
DROP VIEW IF EXISTS `view_pay_info`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_pay_info` AS select `pay_info`.`id` AS `id`,`pay_info`.`user_id` AS `user_id`,`pay_info`.`pay_money` AS `pay_money`,`pay_info`.`pay_code` AS `pay_code`,`pay_info`.`pay_status_id` AS `pay_status_id`,`pay_info`.`createtime` AS `createtime`,`pay_info`.`content` AS `content`,`pay_info`.`reason` AS `reason`,`user`.`name` AS `name`,`user`.`code` AS `code`,`user`.`phone` AS `phone`,`user`.`Alipay_name` AS `Alipay_name`,`user`.`Alipay_account` AS `Alipay_account`,`pay_status`.`code` AS `pay_status_code`,`pay_status`.`name` AS `pay_status_name` from ((`pay_info` left join `user` on((`pay_info`.`user_id` = `user`.`id`))) left join `pay_status` on((`pay_info`.`pay_status_id` = `pay_status`.`id`)));

-- ----------------------------
-- View structure for view_sys_brokerages
-- ----------------------------
DROP VIEW IF EXISTS `view_sys_brokerages`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_sys_brokerages` AS select `sys_brokerages`.`id` AS `id`,`sys_brokerages`.`user_id` AS `user_id`,`sys_brokerages`.`money` AS `money`,`sys_brokerages`.`pay_money` AS `pay_money`,`sys_brokerages`.`createtime` AS `createtime`,`user`.`code` AS `code`,`user`.`phone` AS `phone`,`sys_brokerages`.`brokerage_id` AS `brokerage_id`,`sys_brokerages`.`sys_brokerages_status_id` AS `sys_brokerages_status_id`,`sys_brokerages_status`.`code` AS `sys_brokerages_status_code`,`sys_brokerages_status`.`name` AS `sys_brokerages_status_name`,`user`.`Alipay_name` AS `Alipay_name`,`user`.`Alipay_account` AS `Alipay_account`,`user`.`Alipay_url` AS `Alipay_url`,`upload_file`.`url` AS `file_url` from (((`sys_brokerages` left join `user` on((`sys_brokerages`.`user_id` = `user`.`id`))) left join `sys_brokerages_status` on((`sys_brokerages`.`sys_brokerages_status_id` = `sys_brokerages_status`.`id`))) left join `upload_file` on((`user`.`Alipay_url` = `upload_file`.`id`)));

-- ----------------------------
-- View structure for view_sys_withdrawals
-- ----------------------------
DROP VIEW IF EXISTS `view_sys_withdrawals`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_sys_withdrawals` AS select `sys_withdrawals`.`id` AS `id`,`sys_withdrawals`.`user_id` AS `user_id`,`sys_withdrawals`.`money` AS `money`,`sys_withdrawals`.`pay_money` AS `pay_money`,`sys_withdrawals`.`pay_status_id` AS `pay_status_id`,`sys_withdrawals`.`createtime` AS `createtime`,`sys_withdrawals`.`pay_type` AS `pay_type`,`pay_status`.`code` AS `pay_status_code`,`pay_status`.`name` AS `pay_status_name`,`user`.`code` AS `code`,`user`.`name` AS `name`,`user`.`phone` AS `phone` from ((`sys_withdrawals` left join `pay_status` on((`sys_withdrawals`.`pay_status_id` = `pay_status`.`id`))) left join `user` on((`sys_withdrawals`.`user_id` = `user`.`id`)));

-- ----------------------------
-- View structure for view_task
-- ----------------------------
DROP VIEW IF EXISTS `view_task`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_task` AS select `task`.`id` AS `id`,`task`.`title` AS `title`,`task`.`context` AS `context`,`task`.`number` AS `number`,`task`.`surplus` AS `surplus`,`task`.`money` AS `money`,`task`.`url` AS `url`,`task`.`task_type_id` AS `task_type_id`,`task`.`createtime` AS `createtime`,`task_type`.`code` AS `task_type_code`,`task_type`.`name` AS `task_type_name`,`task`.`enabled` AS `enabled` from (`task` left join `task_type` on((`task`.`task_type_id` = `task_type`.`id`)));

-- ----------------------------
-- View structure for view_user
-- ----------------------------
DROP VIEW IF EXISTS `view_user`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_user` AS select `user`.`id` AS `id`,`user`.`code` AS `code`,`user`.`name` AS `name`,`user`.`phone` AS `phone`,`user`.`password` AS `password`,`user`.`invite_code` AS `invite_code`,`user`.`user_id` AS `user_id`,`user`.`Alipay_name` AS `Alipay_name`,`user`.`Alipay_account` AS `Alipay_account`,`user`.`Alipay_url` AS `Alipay_url`,`user`.`money` AS `money`,`user`.`member_id` AS `member_id`,`user`.`enabled` AS `enabled`,`user`.`createtime` AS `createtime`,`member`.`code` AS `member_code`,`member`.`name` AS `member_name`,`member`.`money` AS `user_member_money`,`member`.`task_number` AS `task_number`,`inviter`.`code` AS `inviter_code`,`inviter`.`invite_code` AS `inviter_invite_code`,`inviter_member`.`code` AS `inviter_member_code`,`inviter_member`.`name` AS `inviter_member_name`,`inviter_member`.`money` AS `inviter_member_money`,`upload_file`.`url` AS `url` from ((((`user` left join `member` on((`user`.`member_id` = `member`.`id`))) left join `user` `inviter` on((`user`.`user_id` = `inviter`.`id`))) left join `member` `inviter_member` on((`inviter`.`member_id` = `inviter_member`.`id`))) left join `upload_file` on((`user`.`Alipay_url` = `upload_file`.`id`)));

-- ----------------------------
-- View structure for view_user_task
-- ----------------------------
DROP VIEW IF EXISTS `view_user_task`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_user_task` AS select `user_task`.`id` AS `id`,`user_task`.`user_id` AS `user_id`,`user_task`.`task_id` AS `task_id`,`user_task`.`task_status_id` AS `task_status_id`,`user`.`money` AS `user_money`,`task`.`money` AS `task_money`,`user`.`user_id` AS `invite_id`,`task`.`createtime` AS `createtime`,`task`.`title` AS `title`,`task`.`context` AS `context`,`task`.`url` AS `url`,`user_task`.`createtime` AS `user_task_createtime`,`user_task`.`url` AS `upload_file_id`,`upload_file`.`name` AS `name`,`upload_file`.`url` AS `file_url`,`upload_file`.`size` AS `size`,`upload_file`.`createtime` AS `upload_time`,`task_status`.`name` AS `task_status_name`,`task_status`.`code` AS `task_status_code` from ((((`user_task` left join `user` on((`user_task`.`user_id` = `user`.`id`))) left join `task` on((`user_task`.`task_id` = `task`.`id`))) left join `upload_file` on((`user_task`.`url` = `upload_file`.`id`))) left join `task_status` on((`user_task`.`task_status_id` = `task_status`.`id`)));

SET FOREIGN_KEY_CHECKS = 1;
