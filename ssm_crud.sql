/*
Navicat MySQL Data Transfer

Source Server         : hello
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ssm_crud

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-05-29 15:14:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(50) DEFAULT NULL,
  `catname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comefrom` varchar(255) DEFAULT NULL,
  `tozootime` date DEFAULT NULL,
  `catdescribe` varchar(255) DEFAULT NULL,
  `classes` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cat
-- ----------------------------
INSERT INTO `cat` VALUES ('4', 'M', '狸猫', '7', '宫廷', '2020-04-11', '雍容华贵123', '猫科');
INSERT INTO `cat` VALUES ('5', 'M', '玲珑', '3', '北冰洋', '2020-04-17', '毛体光滑，闪闪发亮', '猫科');
INSERT INTO `cat` VALUES ('6', 'M', '小可爱', '6', '女儿国', '2020-04-17', '爱瞌睡，爱睡觉', '猫科');
INSERT INTO `cat` VALUES ('7', 'M', '加菲猫', '6', '测试地点', '2020-04-16', '测试描述,测试喵喵', '猫科');
INSERT INTO `cat` VALUES ('10', 'M', '下功夫的', '6', '6666', '2020-05-03', '666666666666666', '猫科');
INSERT INTO `cat` VALUES ('11', 'M', '铛铛', '5', '葫芦岛', '2020-05-08', '眼眸深邃', '猫科');
INSERT INTO `cat` VALUES ('12', 'M', '普普', '5', '普陀路', '2020-04-30', '小巧玲珑', '猫科');
INSERT INTO `cat` VALUES ('13', 'F', '爱爱', '9', '阿根廷', '2020-04-17', '黑乎乎的大眼睛', '猫科');
INSERT INTO `cat` VALUES ('14', 'F', '欣欣', '9', '瑞士', '2020-12-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('15', 'F', '欣可', '8', '哈根达斯', '2020-12-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('16', 'F', '凯瑞克', '8', '日内瓦', '2020-12-17', '毛发光滑', '猫科');
INSERT INTO `cat` VALUES ('17', 'F', '可可', '4', '哈根达斯', '2000-12-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('18', 'F', '琪琪', '9', '哈根达斯', '2005-12-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('19', 'F', '瑞瑞', '6', '梵蒂冈', '2020-12-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('20', 'M', '葫芦', '9', '哈根达斯', '2020-12-17', '毛发长', '猫科');
INSERT INTO `cat` VALUES ('21', 'F', '发欣', '66', '哈根达斯', '2020-01-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('22', 'M', '白白', '9', '哈根达斯', '2020-02-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('23', 'F', '宝贝', '64', '哈根达斯', '2020-08-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('24', 'F', '贝贝', '9', '哈根达斯', '2020-04-17', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('25', 'M', '宝宝', '6', '哈根达斯', '2020-12-07', '白白胖胖', '猫科');
INSERT INTO `cat` VALUES ('26', 'F', '欢欢', '9', '哈根达斯', '2020-08-17', '白白胖胖', '猫科');

-- ----------------------------
-- Table structure for dog
-- ----------------------------
DROP TABLE IF EXISTS `dog`;
CREATE TABLE `dog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(50) DEFAULT NULL,
  `dogname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comefrom` varchar(255) DEFAULT NULL,
  `tozootime` date DEFAULT NULL,
  `dogdescribe` varchar(255) DEFAULT NULL,
  `classes` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dog
-- ----------------------------
INSERT INTO `dog` VALUES ('2', 'M', '豆豆狗', '65', '小村庄', '2020-04-03', '红色绿色', '犬科');
INSERT INTO `dog` VALUES ('3', 'M', '恶犬', '3', '北极', '2020-04-11', '凶悍可爱123', '犬科');
INSERT INTO `dog` VALUES ('4', 'M', '泰迪', '9', '家养', '2020-04-02', '毛毛很长', '犬科');
INSERT INTO `dog` VALUES ('5', 'M', '斗牛犬', '3', '舞池', '2020-04-11', '恶狠狠的', '犬科');
INSERT INTO `dog` VALUES ('7', 'M', '毛毛', '6', '岛国', '2020-04-18', '象毛毛虫一样', '犬科');
INSERT INTO `dog` VALUES ('8', 'M', '法斗', '2', '法国', '2020-05-06', '毛发比较短', '犬科');
INSERT INTO `dog` VALUES ('9', 'M', '哎呦', '2', '斯里兰卡', '2020-05-10', '胖乎乎的', '犬科');
INSERT INTO `dog` VALUES ('10', 'M', '旺旺', '9', '红海', '2020-05-01', '小不点', '犬科');
INSERT INTO `dog` VALUES ('11', 'M', '红红红', '5', '南非', '2020-05-02', '红色的毛', '犬科');
INSERT INTO `dog` VALUES ('12', 'M', '豆豆', '9', '法国', '2020-05-14', '豆黄色毛发', '犬科');

-- ----------------------------
-- Table structure for ele
-- ----------------------------
DROP TABLE IF EXISTS `ele`;
CREATE TABLE `ele` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(150) DEFAULT NULL,
  `elename` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comefrom` varchar(255) DEFAULT NULL,
  `tozootime` date DEFAULT NULL,
  `eledescribe` varchar(255) DEFAULT NULL,
  `classes` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ele
-- ----------------------------
INSERT INTO `ele` VALUES ('2', 'M', '长鼻象', '6', '长鼻村', '2020-04-12', '鼻子很长', '脊索动物');
INSERT INTO `ele` VALUES ('4', 'M', '海茅', '5', '东海', '2020-05-10', '身体呈一个3字形状', '脊索动物');
INSERT INTO `ele` VALUES ('14', 'F', '欣欣', '9', '瑞士', '2020-12-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('15', 'F', '欣可', '8', '哈根达斯', '2020-12-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('16', 'F', '凯瑞克', '8', '日内瓦', '2020-12-17', '毛发光滑', '脊索动物');
INSERT INTO `ele` VALUES ('17', 'F', '可可', '4', '哈根达斯', '2000-12-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('18', 'F', '琪琪', '9', '日内瓦', '2005-12-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('19', 'F', '瑞瑞', '6', '梵蒂冈', '2020-12-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('20', 'M', '葫芦', '9', '哈根达斯', '2020-12-17', '毛发长', '脊索动物');
INSERT INTO `ele` VALUES ('21', 'F', '发欣', '66', '日内瓦', '2020-01-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('22', 'M', '白白', '9', '哈根达斯', '2020-02-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('23', 'F', '宝贝', '64', '日内瓦', '2020-08-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('24', 'F', '贝贝', '9', '日内瓦', '2020-04-17', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('25', 'M', '宝宝', '6', '日内瓦', '2020-12-07', '白白胖胖', '脊索动物');
INSERT INTO `ele` VALUES ('26', 'F', '欢欢', '9', '哈根达斯', '2020-08-17', '白白胖胖', '脊索动物');

-- ----------------------------
-- Table structure for fish
-- ----------------------------
DROP TABLE IF EXISTS `fish`;
CREATE TABLE `fish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(150) DEFAULT NULL,
  `fishname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comefrom` varchar(255) DEFAULT NULL,
  `tozootime` date DEFAULT NULL,
  `fishdescribe` varchar(255) DEFAULT NULL,
  `classes` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fish
-- ----------------------------
INSERT INTO `fish` VALUES ('2', 'M', '黄花鱼', '5', '山河', '2020-04-10', '身体呈黄色', '鱼类');
INSERT INTO `fish` VALUES ('3', 'M', '鳜鱼', '6', '中国长江', '2020-04-10', '体型较大', '鱼类');
INSERT INTO `fish` VALUES ('4', 'M', '鲫鱼', '9', '黄河', '2020-05-01', '身体光滑', '鱼类');
INSERT INTO `fish` VALUES ('14', 'F', '欣欣', '9', '瑞士', '2020-12-17', '白白胖胖', '鱼类');
INSERT INTO `fish` VALUES ('15', 'F', '欣可', '8', '哈根达斯', '2020-12-17', '鱼体呈金黄色', '鱼类');
INSERT INTO `fish` VALUES ('16', 'F', '凯瑞克', '8', '日内瓦', '2020-12-17', '毛发光滑', '鱼类');
INSERT INTO `fish` VALUES ('17', 'F', '可可', '4', '哈根达斯', '2000-12-17', '鱼体呈金黄色', '鱼类');
INSERT INTO `fish` VALUES ('18', 'F', '琪琪', '9', '日内瓦', '2005-12-17', '白白胖胖', '鱼类');
INSERT INTO `fish` VALUES ('19', 'F', '瑞瑞', '6', '梵蒂冈', '2020-12-17', '鱼体呈金黄色', '鱼类');
INSERT INTO `fish` VALUES ('20', 'M', '葫芦', '9', '哈根达斯', '2020-12-17', '毛发长', '鱼类');
INSERT INTO `fish` VALUES ('21', 'F', '发欣', '66', '日内瓦', '2020-01-17', '白白胖胖', '鱼类');
INSERT INTO `fish` VALUES ('22', 'M', '白白', '9', '哈根达斯', '2020-02-17', '鱼体呈金黄色', '鱼类');
INSERT INTO `fish` VALUES ('23', 'F', '宝贝', '64', '日内瓦', '2020-08-17', '白白胖胖', '鱼类');
INSERT INTO `fish` VALUES ('24', 'F', '贝贝', '9', '日内瓦', '2020-04-17', '鱼体呈金黄色', '鱼类');
INSERT INTO `fish` VALUES ('25', 'M', '宝宝', '6', '日内瓦', '2020-12-07', '白白胖胖', '鱼类');
INSERT INTO `fish` VALUES ('26', 'F', '欢欢', '9', '哈根达斯', '2020-08-17', '白白胖胖', '鱼类');

-- ----------------------------
-- Table structure for horse1
-- ----------------------------
DROP TABLE IF EXISTS `horse1`;
CREATE TABLE `horse1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(150) DEFAULT NULL,
  `horsename` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comefrom` varchar(255) DEFAULT NULL,
  `tozootime` date NOT NULL,
  `horsedescribe` varchar(255) DEFAULT NULL,
  `classes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90898986 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of horse1
-- ----------------------------
INSERT INTO `horse1` VALUES ('11', 'M', '草原马', '12', '中国', '2020-03-30', '发一份黑白相间', '马科');
INSERT INTO `horse1` VALUES ('13', 'F', '草原马3', '8', '中国', '2020-03-03', '发一份白色透明', '马科');
INSERT INTO `horse1` VALUES ('14', 'M', '草原马4', '9', '中国', '2020-03-17', '发一份红黑相间', '马科');
INSERT INTO `horse1` VALUES ('15', 'M', '草原马5', '11', '中国', '2019-05-21', '发一份黄白相间', '马科');
INSERT INTO `horse1` VALUES ('16', 'F', '草原马6', '2', '中国', '2020-03-17', '发一份红白相间', '马科');
INSERT INTO `horse1` VALUES ('18', 'F', '草原马8', '6', '中国', '2020-04-20', '发一份蓝黑相间', '马科');
INSERT INTO `horse1` VALUES ('89', '公', '你好', '45', '埃及', '2020-04-04', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('100', '公', '测试', '23', '测试', '2020-04-10', '测试是的是的复古想过自己创造JX', '马科');
INSERT INTO `horse1` VALUES ('878', 'M', '人生如果', '6', 'cvzzzzx', '2020-04-08', 'yonggan', '马科');
INSERT INTO `horse1` VALUES ('890', '公', '你好', '45', '埃及', '2020-04-04', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('88888', '公', '你好', '45', '埃及', '2020-04-04', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('89099', '公', '你好', '45', '埃及', '2020-04-04', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('908989', '公', '你好', '45', '埃及', '2020-04-03', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('89889898', '公', '鞍马', '45', '埃及', '2020-04-03', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('90898934', '公', '你好', '45', '埃及', '2020-04-03', '你好漂亮', '马科');
INSERT INTO `horse1` VALUES ('90898935', '公', '小草原', '56', '大草原', '2020-04-09', '草原奔跑', '马科');
INSERT INTO `horse1` VALUES ('90898936', '公', '黑马', '58', '天山', '2020-04-10', '雪白，较小', '马科');
INSERT INTO `horse1` VALUES ('90898937', '公', '重复马', '88', '古埃及', '2020-04-03', '金黄色的金字塔', '马科');
INSERT INTO `horse1` VALUES ('90898938', '公', '小黑马', '45', '故此单', '2020-04-03', 'ICDAU噢G从', '马科');
INSERT INTO `horse1` VALUES ('90898939', '公', '很反感', '6', '6好看吗', '2020-04-04', '赋予开门红不给你', '马科');
INSERT INTO `horse1` VALUES ('90898940', '公', '额非法人防', '45', '太让人', '2020-04-11', '高富帅大V', '马科');
INSERT INTO `horse1` VALUES ('90898941', 'M', '晚上', '6', '小区', '2020-04-18', '自行车', '马科');
INSERT INTO `horse1` VALUES ('90898942', 'M', '红色', '55', '红色', '2020-04-03', '黑色', '马科');
INSERT INTO `horse1` VALUES ('90898943', 'M', '玲玲', '7', '青海自治区', '2020-04-15', '小巧玲珑，精致可爱', '马科');
INSERT INTO `horse1` VALUES ('90898944', 'M', '灵灵', '5', '森林', '2020-04-04', '很好看', '马科');
INSERT INTO `horse1` VALUES ('90898945', 'M', '新增测试', '3', '新增地点', '2020-04-04', '新增描述', '马科');
INSERT INTO `horse1` VALUES ('90898946', 'M', '测试测试', '6', '测试', '2020-04-08', '测试描述', '马科');
INSERT INTO `horse1` VALUES ('90898947', 'M', '123456', '123456', '123456', '2020-04-17', '123456', '马科');
INSERT INTO `horse1` VALUES ('90898948', 'M', '54546694', '64', '49879', '0000-00-00', '8686', '马科');
INSERT INTO `horse1` VALUES ('90898949', 'M', '袋鼠', '6', '森林', '2020-04-10', '有个大口袋', '马科');
INSERT INTO `horse1` VALUES ('90898950', 'M', '袋鼠', '6', '森林', '2020-04-10', '有个大口袋', '马科');
INSERT INTO `horse1` VALUES ('90898951', 'M', '袋鼠', '6', '森林', '2020-04-10', '有个大口袋', '马科');
INSERT INTO `horse1` VALUES ('90898952', 'M', '红马', '45', '红海', '2020-04-03', '马蹄呈现出红色', '马科');
INSERT INTO `horse1` VALUES ('90898953', 'M', '大象', '6', '大森林', '2020-04-03', '有长长的鼻子', '马科');
INSERT INTO `horse1` VALUES ('90898954', 'M', '大象', '6', '大森林', '2020-04-03', '有长长的鼻子', '马科');
INSERT INTO `horse1` VALUES ('90898955', 'M', '系哦啊想', '6', '662', '2020-04-10', '65133', '马科');
INSERT INTO `horse1` VALUES ('90898956', 'M', '系哦啊想', '6', '662', '2020-04-10', '65133', '马科');
INSERT INTO `horse1` VALUES ('90898957', 'M', '系哦啊想', '6', '662', '2020-04-10', '65133', '马科');
INSERT INTO `horse1` VALUES ('90898958', 'M', '系哦啊想', '6', '662', '2020-04-10', '65133', '马科');
INSERT INTO `horse1` VALUES ('90898959', 'M', '系哦啊想', '6', '662', '2020-04-10', '65133', '马科');
INSERT INTO `horse1` VALUES ('90898960', 'M', '1223223', '452', '66272', '2020-04-09', '25254', '马科');
INSERT INTO `horse1` VALUES ('90898961', 'M', '琪琪', '6', '森林', '2020-04-09', '长长的鼻子', '马科');
INSERT INTO `horse1` VALUES ('90898962', 'M', '小鱼', '2', '沂河', '2020-04-11', '光滑 金黄', '马科');
INSERT INTO `horse1` VALUES ('90898963', 'M', '洗澡能', '5', '242', '2020-04-04', '3838', '马科');
INSERT INTO `horse1` VALUES ('90898964', 'M', '123123', '3', '111111111111', '2020-04-04', '3123223', '马科');
INSERT INTO `horse1` VALUES ('90898965', 'M', '3544346', '12', '36323', '2020-04-09', '+++++++++++', '马科');
INSERT INTO `horse1` VALUES ('90898973', 'M', '赵马', '6', '水牢', '2020-05-14', '哈哈哈哈', '马科');
INSERT INTO `horse1` VALUES ('90898976', 'M', '测试科', '89', '测试', '2020-05-08', '测试', '马科');
INSERT INTO `horse1` VALUES ('90898977', 'M', '额恩恩', '5', '的是C新增', '2020-05-08', '顶顶顶顶顶顶顶顶顶顶', '马科');
INSERT INTO `horse1` VALUES ('90898984', 'M', '测试最后', '5', '5555555', '2020-05-09', '555555555555', '马科');
INSERT INTO `horse1` VALUES ('90898985', 'M', '车上的', '5', '5555555', '2020-05-09', '555555555555', '马科');

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `manageid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `managename` varchar(50) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `classes` varchar(50) DEFAULT NULL,
  `phone` varchar(80) DEFAULT NULL,
  `addr` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`manageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=REDUNDANT;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES ('1', '管理员A', '男', '马科', '1234567899999', 'D:\\imgs\\e4a677c4-ffda-4fe7-aa63-9df70448fc22.png');
INSERT INTO `manage` VALUES ('2', '管理员B', '女', '猫科', '123000', 'D:\\imgs\\068d7ad1-090e-4691-8ee5-0698faa7adbc.png');
INSERT INTO `manage` VALUES ('3', '管理员C', '女', '脊索动物', '999999', '');
INSERT INTO `manage` VALUES ('4', '管理员D', '男', '鱼类', '666666', 'D:\\imgs\\c6aba58b-bf3a-411b-8bdf-871ef85239d0.png');
INSERT INTO `manage` VALUES ('5', '管理员E', '男', '鼠类', '222236', '');

-- ----------------------------
-- Table structure for mouse
-- ----------------------------
DROP TABLE IF EXISTS `mouse`;
CREATE TABLE `mouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(150) DEFAULT NULL,
  `mousename` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `comefrom` varchar(255) DEFAULT NULL,
  `tozootime` date DEFAULT NULL,
  `mousedescribe` varchar(255) DEFAULT NULL,
  `classes` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mouse
-- ----------------------------
INSERT INTO `mouse` VALUES ('1', 'M', '袋鼠', '5', '维多利亚', '2020-04-03', '有个大口袋', '鼠类');
INSERT INTO `mouse` VALUES ('3', 'M', '鼹鼠', '6', '普陀', '2020-05-08', '有两颗大门牙', '鼠类');
INSERT INTO `mouse` VALUES ('4', 'M', '竹鼠', '8', '竹林外', '2020-05-09', '喜欢吃竹子', '鼠类');
INSERT INTO `mouse` VALUES ('14', 'F', '欣欣', '9', '瑞士', '2020-12-17', '白白胖胖', '鱼类');
INSERT INTO `mouse` VALUES ('15', 'F', '欣可', '8', '哈根达斯', '2020-12-17', '体型较小', '鼠类');
INSERT INTO `mouse` VALUES ('16', 'F', '凯瑞克', '8', '日内瓦', '2020-12-17', '毛发光滑', '鼠类');
INSERT INTO `mouse` VALUES ('17', 'F', '可可', '4', '哈根达斯', '2000-12-17', '体型较小', '鼠类');
INSERT INTO `mouse` VALUES ('18', 'F', '琪琪', '9', '日内瓦', '2005-12-17', '白白胖胖', '鼠类');
INSERT INTO `mouse` VALUES ('19', 'F', '瑞瑞', '6', '梵蒂冈', '2020-12-17', '体型较小', '鼠类');
INSERT INTO `mouse` VALUES ('20', 'M', '葫芦', '9', '哈根达斯', '2020-12-17', '毛发长', '鼠类');
INSERT INTO `mouse` VALUES ('21', 'F', '发欣', '66', '日内瓦', '2020-01-17', '白白胖胖', '鼠类');
INSERT INTO `mouse` VALUES ('22', 'M', '白白', '9', '哈根达斯', '2020-02-17', '体型较小', '鼠类');
INSERT INTO `mouse` VALUES ('23', 'F', '宝贝', '64', '日内瓦', '2020-08-17', '白白胖胖', '鼠类');
INSERT INTO `mouse` VALUES ('24', 'F', '贝贝', '9', '日内瓦', '2020-04-17', '体型较小', '鼠类');
INSERT INTO `mouse` VALUES ('25', 'M', '宝宝', '6', '日内瓦', '2020-12-07', '白白胖胖', '鼠类');
INSERT INTO `mouse` VALUES ('26', 'F', '欢欢', '9', '哈根达斯', '2020-08-17', '体型较小', '鼠类');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('hello', '123456', null, null);
INSERT INTO `user` VALUES ('pooo', '123456', null, null);
INSERT INTO `user` VALUES ('user1', '123456', null, null);
INSERT INTO `user` VALUES ('user2', '123456', null, null);
INSERT INTO `user` VALUES ('user3', '123456', '女', '12345678');
INSERT INTO `user` VALUES ('hhhhhh', '7878', '女', '123456');
INSERT INTO `user` VALUES ('lihanli', '123456', '女', '123456');
INSERT INTO `user` VALUES ('lihanli', '123456', '女', '123456');
INSERT INTO `user` VALUES ('lihanli', '123456', '女', '123456');
INSERT INTO `user` VALUES ('小明明', '666666', '女', '123123123');
INSERT INTO `user` VALUES ('', '', '', '');
