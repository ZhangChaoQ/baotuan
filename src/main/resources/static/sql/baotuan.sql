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

 Date: 05/04/2020 19:06:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brokerages
-- ----------------------------
DROP TABLE IF EXISTS `brokerages`;
CREATE TABLE `brokerages`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '金额',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `brokerages_type_id` int(11) NULL DEFAULT NULL COMMENT '分佣类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '金额记录' ROW_FORMAT = Dynamic;

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
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '测试公告', '这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告', '2020-04-04 16:47:49');
INSERT INTO `notice` VALUES (2, '测试公告', '这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告这是一条测试公告', '2020-04-04 16:47:54');

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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金额记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '提款金额',
  `pay_money` double(255, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `pay_status_id` int(11) NULL DEFAULT NULL COMMENT '支付状态',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '转款记录 ' ROW_FORMAT = Dynamic;

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
INSERT INTO `task` VALUES (1, '抖音测试', '点赞+关注', 100, 0, 100.50, 'https://v.douyin.com/72wmSN/', 1, '2020-03-12 19:50:23');
INSERT INTO `task` VALUES (2, '抖音测试2', '点赞+关注', 100, 8, 100.50, 'https://v.douyin.com/72wWSN/', 1, '2020-03-23 04:13:15');

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
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '上传文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upload_file
-- ----------------------------
INSERT INTO `upload_file` VALUES (1, '登录', '/upload/2020-04-05/040cd4fd-4254-4ed5-9f9a-f3a885ed6e1b.jpg', 127472, '2020-04-05 10:04:08');
INSERT INTO `upload_file` VALUES (2, '登录', '/upload/2020-04-05/05d2e4cf-d34a-429d-a2ed-ffd5df3b3942.jpg', 127472, '2020-04-05 10:05:06');
INSERT INTO `upload_file` VALUES (3, '登录', '/upload/2020-04-05/28197f28-4ef9-4db0-98fd-4d84ed5b4435.jpg', 127472, '2020-04-05 10:05:50');
INSERT INTO `upload_file` VALUES (4, '登录', '/upload/2020-04-05/03d6a34b-45b0-4354-9f00-cf77f3dfeddf.jpg', 127472, '2020-04-05 10:08:34');
INSERT INTO `upload_file` VALUES (5, '登录', '/upload/2020-04-05/835f47ba-5eca-4168-bfe9-8c70802217ee.jpg', 127472, '2020-04-05 10:09:25');
INSERT INTO `upload_file` VALUES (6, '登录', '/upload/2020-04-05/db777fe8-2065-474b-82bb-43a5ec9fb0d5.jpg', 127472, '2020-04-05 10:11:47');
INSERT INTO `upload_file` VALUES (7, '登录', '/upload/2020-04-05/49e8686e-6716-450f-894f-84dc6efde783.jpg', 127472, '2020-04-05 10:12:58');
INSERT INTO `upload_file` VALUES (8, '登录', '/upload/2020-04-05/4f995a7f-cdc2-4313-8570-0b7a786178a1.jpg', 127472, '2020-04-05 10:14:29');
INSERT INTO `upload_file` VALUES (9, '登录', '/upload/2020-04-05/976fa789-b015-44d9-bf22-44e60dfbd246.jpg', 127472, '2020-04-05 10:15:09');
INSERT INTO `upload_file` VALUES (10, '登录', '/upload/2020-04-05/47dde68c-6bed-44b5-9e0a-17f4de10160e.jpg', 127472, '2020-04-05 10:16:11');
INSERT INTO `upload_file` VALUES (11, '登录', '/upload/2020-04-05/96059927-a227-4423-87e0-6ba8453c13b1.jpg', 127472, '2020-04-05 10:16:41');
INSERT INTO `upload_file` VALUES (12, '登录', '/upload/2020-04-05/5ae41624-fa1c-4b28-b22d-6e1e126d7484.jpg', 127472, '2020-04-05 10:17:28');
INSERT INTO `upload_file` VALUES (13, '登录', '/upload/2020-04-05/910505f4-ba3a-4dae-a057-20b2ec4e5f35.jpg', 127472, '2020-04-05 10:18:44');
INSERT INTO `upload_file` VALUES (14, '登录', '/upload/2020-04-05/17532c57-87e9-46a0-82c8-0e7c2b9bfd55.jpg', 127472, '2020-04-05 10:20:52');
INSERT INTO `upload_file` VALUES (15, '登录', '/upload/2020-04-05/e609a6d6-c0d5-48de-8c6b-a21ff9840169.jpg', 127472, '2020-04-05 10:20:52');
INSERT INTO `upload_file` VALUES (16, '登录', '/upload/2020-04-05/4d23fdc6-d622-47df-8671-27cf5f9b7216.jpg', 127472, '2020-04-05 10:21:34');
INSERT INTO `upload_file` VALUES (17, '登录', '/upload/2020-04-05/1731635d-eabc-4e00-b385-59a08333f627.jpg', 127472, '2020-04-05 10:23:53');
INSERT INTO `upload_file` VALUES (18, '登录', '/upload/2020-04-05/ce239785-6523-46a1-86ac-f646ca734b73.jpg', 127472, '2020-04-05 10:24:47');
INSERT INTO `upload_file` VALUES (19, '登录', '/upload/2020-04-05/6bac940a-e044-4ed9-a48a-281dbc0c54f4.jpg', 127472, '2020-04-05 10:26:31');
INSERT INTO `upload_file` VALUES (20, '登录', '/upload/2020-04-05/f77ad988-7591-467e-b801-eb1563aad1cd.jpg', 127472, '2020-04-05 10:26:47');
INSERT INTO `upload_file` VALUES (21, '登录', '/upload/2020-04-05/9aa0601c-271f-4221-9b63-8de4417742c7.jpg', 127472, '2020-04-05 10:27:48');
INSERT INTO `upload_file` VALUES (22, '登录', '/upload/2020-04-05/8c588460-5f35-4813-8d83-2af66ee5d70f.jpg', 127472, '2020-04-05 10:28:50');
INSERT INTO `upload_file` VALUES (23, '登录', '/upload/2020-04-05/79e5756d-7e2c-48e6-a02b-b56c58b9ee09.jpg', 127472, '2020-04-05 10:30:25');
INSERT INTO `upload_file` VALUES (24, '登录', '/upload/2020-04-05/4a1fee4f-30aa-4498-9329-788a15a2e63b.jpg', 127472, '2020-04-05 10:33:23');
INSERT INTO `upload_file` VALUES (25, '登录', '/upload/2020-04-05/3fba77d3-e9ca-405a-8b40-4c2f53eea457.jpg', 127472, '2020-04-05 10:34:34');
INSERT INTO `upload_file` VALUES (26, '登录', '/upload/2020-04-05/ed9d4a28-a0f3-4261-8597-0e71586b5b76.jpg', 127472, '2020-04-05 10:34:56');
INSERT INTO `upload_file` VALUES (27, '登录', '/upload/2020-04-05/4775310e-27d6-4f3e-95f8-319f2a5a8ca7.jpg', 127472, '2020-04-05 10:38:07');
INSERT INTO `upload_file` VALUES (28, '登录', '/upload/2020-04-05/24430480-4624-47f2-9bb2-2a1f67ee0b2f.jpg', 127472, '2020-04-05 10:39:16');
INSERT INTO `upload_file` VALUES (29, '登录', '/upload/2020-04-05/f9937f24-426c-4eb8-a378-b1e734e3212d.jpg', 127472, '2020-04-05 10:40:28');
INSERT INTO `upload_file` VALUES (30, '登录', '/upload/2020-04-05/52df6823-f5a0-4ddf-b6d2-3448bce98fb7.jpg', 127472, '2020-04-05 10:53:36');
INSERT INTO `upload_file` VALUES (31, '登录', '/upload/2020-04-05/9c6a8012-bac6-44d6-8e59-e839afab1c26.jpg', 127472, '2020-04-05 10:54:22');
INSERT INTO `upload_file` VALUES (32, '登录', '/upload/2020-04-05/3c7e1dfc-2b9c-4a50-8714-6b29c1dd9a96.jpg', 127472, '2020-04-05 10:59:10');
INSERT INTO `upload_file` VALUES (33, '登录', '/upload/2020-04-05/da72f56f-fc5c-4d93-8a9d-7a82342c356d.jpg', 127472, '2020-04-05 11:02:10');

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
  `url` int(255) NULL DEFAULT NULL COMMENT '任务图片链接',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `task_id`(`task_id`) USING BTREE,
  INDEX `task_status_id`(`task_status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户任务记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_task
-- ----------------------------
INSERT INTO `user_task` VALUES (1, 1, 1, 1, '2020-04-05 10:03:49', NULL);
INSERT INTO `user_task` VALUES (2, 1, 2, 1, '2020-04-05 10:03:50', NULL);

-- ----------------------------
-- View structure for view_user
-- ----------------------------
DROP VIEW IF EXISTS `view_user`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_user` AS select `user`.`id` AS `id`,`user`.`code` AS `user_code`,`user`.`phone` AS `phone`,`user`.`password` AS `password`,`user`.`invite_code` AS `invite_code`,`user`.`user_id` AS `user_id`,`user`.`Alipay_account` AS `zfb_account`,`user`.`Alipay_url` AS `zfb_url`,`user`.`money` AS `money`,`user`.`member_id` AS `member_id`,`user`.`enabled` AS `enabled`,`member`.`code` AS `code`,`member`.`name` AS `name`,`inviter`.`code` AS `inviter_code`,`inviter`.`invite_code` AS `inviter_invite_code`,`inviter_member`.`code` AS `inviter_member_code`,`inviter_member`.`name` AS `inviter_member_name`,`inviter_member`.`money` AS `user_member_money`,`inviter_member`.`money` AS `inviter_member_money`,`member`.`task_number` AS `task_number` from (((`user` left join `member` on((`user`.`member_id` = `member`.`id`))) left join `user` `inviter` on((`user`.`user_id` = `inviter`.`id`))) left join `member` `inviter_member` on((`inviter`.`member_id` = `member`.`id`)));

-- ----------------------------
-- View structure for view_user_task
-- ----------------------------
DROP VIEW IF EXISTS `view_user_task`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_user_task` AS select `user_task`.`id` AS `id`,`user_task`.`user_id` AS `user_id`,`user_task`.`task_id` AS `task_id`,`user_task`.`task_status_id` AS `task_status_id`,`user`.`money` AS `user_money`,`task`.`money` AS `task_money`,`user`.`user_id` AS `invite_id`,`task`.`createtime` AS `createtime`,`task`.`title` AS `title`,`task`.`context` AS `context`,`task`.`url` AS `url`,`user_task`.`createtime` AS `user_task_createtime`,`user_task`.`url` AS `upload_file_id`,`upload_file`.`name` AS `name`,`upload_file`.`url` AS `file_url`,`upload_file`.`size` AS `size`,`upload_file`.`createtime` AS `upload_time`,`task_status`.`name` AS `task_status_name`,`task_status`.`code` AS `task_status_code` from ((((`user_task` left join `user` on((`user_task`.`user_id` = `user`.`id`))) left join `task` on((`user_task`.`task_id` = `task`.`id`))) left join `upload_file` on((`user_task`.`url` = `upload_file`.`id`))) left join `task_status` on((`user_task`.`task_status_id` = `task_status`.`id`)));

SET FOREIGN_KEY_CHECKS = 1;
