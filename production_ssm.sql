/*
Navicat MySQL Data Transfer

Source Server         : 111
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : production_ssm

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-01-23 22:04:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `custom`
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom` (
  `custom_id` varchar(40) NOT NULL,
  `custom_name` varchar(20) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `owner_name` varchar(20) DEFAULT NULL,
  `owner_tel` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES ('001', '阿里', '阿里巴巴网络技术有限公司', '中国杭州', '15615616', 'alibaba@126.com', '马云', '1851561561', '1', '<h4>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color:#E53333;\">阿里巴巴</span>网络技术有限公司（简称：阿里巴巴集团）是以曾担任英语教师的马云为首的18人，于1999年在杭州创立，他们相信互联网能够创造公平的竞争环境，让小企业通过创新与科技扩展业务，并在参与国内或全球市场竞争时处于更有利的位置。<br />\r\n阿里巴巴集团经营多项业务，另外也从关联公司的业务和服务中取得经营商业生态系统上的支援。业务和关联公司的业务包括：<span style=\"color:#E53333;\">淘宝网、天猫、聚划算、全球速卖通、阿里巴巴国际交易市场、1688、阿里妈妈、阿里云、蚂蚁金服、菜鸟网络</span>等。\r\n</h4>\r\n<h4>\r\n	2014年9月19日，阿里巴巴集团在纽约证券交易所正式挂牌上市，股票代码“BABA”，创始人和董事局主席为马云。\r\n</h4>\r\n<h4>\r\n	2015年全年，阿里巴巴总营收943.84亿元人民币，净利润688.44亿元人民币。\r\n</h4>\r\n<h4>\r\n	2016年4月6日，阿里巴巴正式宣布已经成为全球最大的零售交易平台。<br />\r\n2016年7月5日，第三方应用商店“豌豆荚”宣布，其应用分发业务并入阿里巴巴移动事业群，双方已正式签订并购协议。<br />\r\n2016年8月，阿里巴巴集团在\"2016中国企业500强\"中排名第148位。\r\n</h4>');
INSERT INTO `custom` VALUES ('002', '网易', '杭州网易养猪公司', '杭州滨江区', '4214324', '2432432', '丁磊', '32143214', '1', '网易 (NASDAQ: NTES)是中国领先的互联网公司，利用最先进的互联网技术，加强人与人之间信息的交流和共享，实现“网聚人的力量”。创始人兼CEO是丁磊。<br />\r\n在开发互联网应用、服务及其它技术方面，网易始终保持业界的领先地位，并在中国互联网行业内率先推出了包括中文全文检索、全中文大容量免费邮件系统、无限容量免费网络相册、免费电子贺卡站、网上虚拟社区、网上拍卖平台、24小时客户服务中心在内的业内领先产品或服务，还通过自主研发推出了一款率先取得白金地位的国产网络游戏。[1]&nbsp;<br />\r\n网易公司推出了门户网站、在线游戏、电子邮箱、在线教育、电子商务、在线音乐、网易bobo等多种服务。<br />');
INSERT INTO `custom` VALUES ('003', '京东', '北京京东世纪贸易有限公司', '中国北京市朝阳区北辰西路8号北辰世纪中心A座', '5001363', 'jd@126.com', '章泽天', '1565156456', '1', '<span style=\"color:#333333;font-family:Helvetica, Arial, Tahoma, &quot;font-size:15px;line-height:22px;background-color:#F2F2F2;\">京东JD.COM-专业的综合网上购物商城，销售超数万品牌、4020万种商品，囊括家电、手机、电脑、母婴、服装等13大品类。秉承客户为先的理念，京东所售商品为<span style=\"color:#E53333;\">正品行货、全国联保、机打发票</span>。1</span><span></span>');
INSERT INTO `custom` VALUES ('004', '新浪', '新浪网络技术股份有限公司', '北京市北四环西路58号理想国际大厦20层', '15612561', '15611561@163.com', '曹国伟', '15614145656', '1', '新浪（NASDAQ：SINA），是一家网络公司的名称，成立于1998年12月，服务大中华地区与海外华人，新浪拥有多家地区性网站，通过旗下五大业务主线为用户提供网络服务，网下的北京新浪、香港新浪、台北新浪、北美新浪等覆盖全球华人社区的全球最大中文门户网站，2012年11月新浪注册用户已突破4亿。<br />\r\n新浪公司是一家服务于中国及全球华人社群的网络媒体公司。新浪通过门户网站新浪网、移动门户手机新浪网和社交网络服务及微博客服务微博组成的数字媒体网络，帮助广大用户通过互联网和移动设备获得专业媒体和用户自生成的多媒体内容（UGC）并与友人进行兴趣分享。<br />');
INSERT INTO `custom` VALUES ('005', '美团', '北京三快在线科技有限公司', '北京市朝阳区望京东路6号 望京国际研发园三期', '15156156156', '156115115@126.com', '王兴', '1561511151', '2', '<div class=\"para\" style=\"font-size:14px;color:#333333;font-family:arial, 宋体, sans-serif;background-color:#FFFFFF;\">\r\n	新浪（NASDAQ：SINA），是一家网络公司的名称，成立于1998年12月，服务大中华地区与海外华人，新浪拥有多家地区性网站，通过旗下五大业务主线为用户提供网络服务，网下的北京新浪、香港新浪、台北新浪、北美新浪等覆盖全球华人社区的全球最大中文门户网站，2012年11月新浪注册用户已突破4亿。<br />\r\n新浪公司是一家服务于中国及全球华人社群的网络媒体公司。新浪通过门户网站新浪网、移动门户手机新浪网和社交网络服务及微博客服务微博组成的数字媒体网络，帮助广大用户通过互联网和移动设备获得专业媒体和用户自生成的多媒体内容（UGC）并与友人进行兴《美团网》是2010年3月4日成立的团购网站。美团网有着“美团一次，美一次”的宣传口号。为消费者发现最值得信赖的商家，让消费者享受超低折扣的优质服务；为商家找到最合适的消费者，给商家提供最大收益的互联网推广。<br />\r\n2014年美团全年交易额突破460亿元，较去年增长180%以上，市场份额占比超过60%，比2013年的53%增长了7个百分点。<br />\r\n2015年1月18日，美团网CEO王兴表示，美团已经完成7亿美元融资，美团估值达到70亿美元，最近两年不考虑上市。<br />\r\n2015年10月8日，大众点评与美团网宣布合并，美团CEO王兴和大众点评CEO张涛将会同时担任联席CEO和联席董事长。11月，阿里确认退出美团，阿里腾讯O2O正式开战。<br />\r\n2015年11月10日，美团CEO王兴发内部邮件表示，将不再担任联席董事长。[1]&nbsp;<br />\r\n2016年8月，北京市食药监局利用高科技手段对互联网违法行为进行搜索监测，为监管部门提供了一批违法线索，查处了一大批违法案件。8月10日，北京市食药监局对美团进行立案调查。<br />\r\n<br />\r\n</div>');
INSERT INTO `custom` VALUES ('006', '蒙牛', '内蒙古蒙牛乳业集团', '呼和浩特', '321321321', '3213321@111', '3132', '3213', '1', '31');
INSERT INTO `custom` VALUES ('007', '百度', '北京百度有限公司', '北京海淀区中关村软件园二期百度科技园', '156151', '561455@baidu.com', '李彦宏', '1561561511', '1', '全球最大的中文搜索引擎');
INSERT INTO `custom` VALUES ('1253', 'aaa', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `c_order`
-- ----------------------------
DROP TABLE IF EXISTS `c_order`;
CREATE TABLE `c_order` (
  `order_id` varchar(40) NOT NULL,
  `custom_id` varchar(40) DEFAULT NULL,
  `product_id` varchar(40) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `request_date` datetime DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_Reference_28` (`product_id`),
  KEY `FK_Reference_5` (`custom_id`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`custom_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_order
-- ----------------------------
INSERT INTO `c_order` VALUES ('000001', '001', '00002', '2016-09-06 10:19:16', '2016-09-26 10:19:21', '<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\">\r\n	<b>订单规范整理要求：</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	1.&nbsp;<b>订单放置以一个文件夹为主；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	2.&nbsp;<b>未下单的客户放在<span>左边</span>，已下单客户放在右边；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	3.&nbsp;<b>未下单客户订单包含（交定金或交全款两种）</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;\">\r\n	<b>交定金的以订单为准，交全额的以质保单为准，可代用订单；</b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:20.5500pt;\">\r\n	<b>夹放标准：客户送货时间越早夹在上面，从早到晚；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	4.&nbsp;<b>已下单订单包括（交定金或者全额两种）同样以订单和质保单为准；分送货时间早晚夹放；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:13.7000pt;\">\r\n	<b>另分清已到货和未到货订单；分两沓，用夹子分开夹放；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>（已到货清单：业务每次到货会有一份到货清单给门店，门店根据业务的到货清单将已到货的单子另外分开；）</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	5.&nbsp;<b>订单如有客户做更改，必须把订单更改单保留且和订单一起夹放，以免遗失，方便与后台核对订单；如若有客户订单整单取消，另有加单或者改单，需重新做一份购销合同，注明原单做废，以最新的那份为准）</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	6.&nbsp;<b>订单确认已送货，且无售后问题，每周整理撤掉已送货订单或质保单；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>（已送货订单：每天售后部经理会给各门店发短信，说明哪一些订单是已经送货的；门店可根据售后经理提供的送货信息清理订单）</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>&nbsp;</b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>&nbsp;</b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>&nbsp;</b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>&nbsp;</b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:20.3000pt;\">\r\n	<b>各门店店员必须熟知各店的订单：</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	1.&nbsp;<b><span>当客人致电门店查询订单时，门店各店员必须在</span>3-5<span>秒之类找到对应的订单；</span></b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	2.&nbsp;<b>要知道客人的付款信息，如有无交定金，全额付款等；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	3.&nbsp;<b>客户姓名、联系方式、地址；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	4.&nbsp;<b>合同编号</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	5.&nbsp;<b>订单是否已经下单，货是否已到；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	6.&nbsp;<b>订单的整单金额为多少，预付多少，剩余多少；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	7.&nbsp;<b>订货的详细内容，颜色，数量等；</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:18.0000pt;text-indent:-18.0000pt;\">\r\n	8.&nbsp;<b>未付款的客人，需要提前三天通知客人前来付余款后，方可送货；</b><b></b> \r\n</p>', '222', '24.00', '美元', '/pic/1482503381808161.jpg,', '/file/订单要求标准(1).doc', '4');
INSERT INTO `c_order` VALUES ('00000111', '002', '00002', '2016-12-22 00:00:00', '2016-12-22 00:00:00', '<h1>\r\n	gfeag<span style=\"color:#E53333;\">eraera</span> \r\n</h1>', '54', '54.00', '54', null, '/file/订单要求标准.doc', '2');
INSERT INTO `c_order` VALUES ('000002', '002', '00005', '2016-09-06 10:19:43', '2016-09-26 10:19:46', '<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\">\r\n	<b>产品订单实施的操作要求</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\">\r\n	<b>&nbsp;</b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>一、订单定义</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>1</span>、业务（客户）订单<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>2</span>、公司高层指令产品生产任务<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>3</span>、营销要求的新产品开发任务<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	以上三种订单渠道要转化为“工厂订单”（即原订单的部分信息在此删掉或简化了）<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>4</span>、其它生产任务为部门自主生产任务单（须经总经理批准后才能安排计划）<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>二、工厂订单的条件</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>1</span>、任何情况下的订单都要有书面文件，凡是以口头下达订单的一律不予接受。<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>2</span>、订单书面文件的内容如下<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	（<span>1</span>）产品名称；（<span>2</span>）数量，（<span>3</span>）交货时间，（<span>4XXX</span>）客户或需求去向；（<span>5</span>）材质；（<span>6</span>）品质要求；（<span>7</span>）技术和工艺条件及要求；（<span>8</span>）注意事项或重要说明<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>3</span>、订单内容须下达订单的责任人填写在单上，如果没有填写或填写错误由下单人或代理填写人负责<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<b>三、订单登记</b><b></b> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>1</span>、订单统一交跟单员登记有效（包括电话订单的接听和记录单在内）<span></span> \r\n</p>\r\n<p class=\"MsoNormal\">\r\n	<span>2</span>、跟单员交已登记的订单给<span>PMC</span>责任人（即生产管控的计划人）\r\n</p>', '32', '32.00', '元', '/pic/1475828588950644.jpg', '/file/产品购销合同2(1).docx', '3');
INSERT INTO `c_order` VALUES ('000003', '003', '00003', '2016-09-13 10:00:00', '2016-09-30 17:00:00', '<strong><span style=\"font-size:16px;\">订单要在30日之前完成，完成后送货至该公司地址。</span></strong>', '121', '3313.00', '元', '/pic/1482200618621182.jpg,', '/file/产品需求文档PRD.pdf', '2');
INSERT INTO `c_order` VALUES ('000006', '003', '00004', '2016-12-01 00:00:00', '2016-12-01 00:00:00', '发发发嘎嘎1', '132', '12.00', '元', null, '/file/购销合同 - 副本 (2).doc', '1');
INSERT INTO `c_order` VALUES ('000009', '002', '00001', '2016-09-28 00:00:00', '2016-09-28 00:00:00', '<h2>\r\n	<span style=\"color:#E53333;\">该订单要在11月5号之前完成</span> \r\n</h2>', '111', '888.00', '元', '/pic/1477451298442216.jpg', '/file/产品购销合同2.docx,/file/购销合同 - 副本 (2).doc', '1');
INSERT INTO `c_order` VALUES ('000010', '001', '00005', '2016-09-28 00:00:00', '2016-09-28 00:00:00', 'ffaf', '11', '11.00', '元', '/pic/1477451098214311.jpg', '/file/购销合同.doc,/file/产品清单.xlsx', '1');
INSERT INTO `c_order` VALUES ('000013', '002', '00004', '2016-12-20 00:00:00', '2016-12-20 00:00:00', null, null, null, '元', '/pic/1482199096212082.jpg,', null, '1');
INSERT INTO `c_order` VALUES ('000014', '001', '00004', '2016-12-04 00:00:00', '2016-12-04 00:00:00', '订单要按质按量完成！', '20', '9.00', '元', '/pic/1482503531511671.jpg,', '/file/购销合同(1)(1).doc', '1');
INSERT INTO `c_order` VALUES ('000015', '002', '00005', '2016-12-03 00:00:00', '2016-12-03 00:00:00', '订单要按质按量完成', '15', '20.00', '元', '/pic/1482503420364321.jpg,/pic/1482503420441752.jpg,', '/file/购销合同(1).doc', '1');
INSERT INTO `c_order` VALUES ('000075', '001', '00003', '2016-12-24 00:00:00', '2016-12-24 00:00:00', '<span style=\"font-size:16px;font-family:SimHei;color:#E53333;\">该订单要在<strong><em><u>12月31号</u></em></strong>之前完成！</span>', '150', '3500.00', '元', '/pic/1482550690746043.jpg,/pic/1482550690868341.jpg,/pic/1482550690928873.jpg,', '/file/产品购销合同(1).docx,/file/产品购销合同(2).docx', '1');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` varchar(40) NOT NULL,
  `department_name` varchar(100) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('001', '项目部', '负责接洽项目，并负责项目进度控制、人员配置调度与风险管控');
INSERT INTO `department` VALUES ('002', '生产部', '负责制定生产计划，并组织生产。');
INSERT INTO `department` VALUES ('003', '物料部', '负责物料收支与调配。');
INSERT INTO `department` VALUES ('004', '财务部', '负责公司财务运作。');
INSERT INTO `department` VALUES ('005', '人力部', '负责公司人事。');
INSERT INTO `department` VALUES ('006', '物流部', '<span style=\"font-size:14px;\">负责公司物流调配。</span>');
INSERT INTO `department` VALUES ('007', '礼仪部', '负责前台接待及会务礼仪。');

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `device_id` varchar(40) NOT NULL,
  `device_name` varchar(100) DEFAULT NULL,
  `device_type_id` varchar(40) DEFAULT NULL,
  `device_status_id` varchar(40) DEFAULT NULL,
  `device_status` varchar(100) DEFAULT NULL,
  `device_purchase_date` datetime DEFAULT NULL,
  `device_purchase_price` decimal(10,2) DEFAULT NULL,
  `device_manufacture_date` datetime DEFAULT NULL,
  `device_service_life` datetime DEFAULT NULL,
  `device_keeper_id` varchar(40) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`device_id`),
  KEY `FK_Reference_18` (`device_type_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`device_type_id`) REFERENCES `device_type` (`device_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('001', '焊接设备', '01', '1', '良好', '2016-08-09 08:08:01', '99.99', '2016-09-09 09:09:01', '2021-09-09 09:09:01', '002', '<span style=\"font-size:14px;\">状态良好.</span>');
INSERT INTO `device` VALUES ('002', '冲压设备', '01', '2', '良好', '2016-08-08 08:08:01', '99.99', '2016-09-09 09:09:02', '2021-09-09 09:09:02', '001', '<p>\r\n	This is good.\r\n</p>');
INSERT INTO `device` VALUES ('003', '空调', '02', '2', '故障', '2016-08-08 08:08:03', '99.97', '2016-09-09 09:09:03', '2021-09-09 09:09:03', '001', 'This is good.');
INSERT INTO `device` VALUES ('004', '冷风机', '02', '2', '故障', '2016-08-08 08:08:03', '99.97', '2016-09-09 09:09:04', '2021-09-09 09:09:04', '001', 'This is good.');
INSERT INTO `device` VALUES ('005', '叉车', '03', '3', '维修', '2016-08-08 08:08:05', '99.95', '2016-09-09 09:09:05', '2021-09-09 09:09:05', '001', 'This is good.');
INSERT INTO `device` VALUES ('006', '机械臂', '03', '3', '维修', '2016-08-08 08:08:05', '99.95', '2016-09-09 09:09:06', '2021-09-09 09:09:06', '002', 'This is good.');

-- ----------------------------
-- Table structure for `device_check`
-- ----------------------------
DROP TABLE IF EXISTS `device_check`;
CREATE TABLE `device_check` (
  `device_check_id` varchar(40) NOT NULL,
  `device_id` varchar(40) DEFAULT NULL,
  `device_check_emp_id` varchar(40) DEFAULT NULL,
  `device_check_date` datetime DEFAULT NULL,
  `device_check_result` varchar(5000) DEFAULT NULL,
  `device_check_fault_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`device_check_id`),
  KEY `FK_Reference_20` (`device_id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_check
-- ----------------------------
INSERT INTO `device_check` VALUES ('001', '001', '002', '2016-07-20 08:08:08', 'Ok。', '无');
INSERT INTO `device_check` VALUES ('002', '002', '001', '2018-08-08 08:08:08', 'Ok', '002');
INSERT INTO `device_check` VALUES ('003', '003', '001', '2018-08-08 08:08:08', 'Ok', '003');
INSERT INTO `device_check` VALUES ('004', '004', '001', '2018-08-08 08:08:08', 'Ok', '004');
INSERT INTO `device_check` VALUES ('005', '005', '001', '2018-08-08 08:08:08', 'Ok', '006');
INSERT INTO `device_check` VALUES ('006', '006', '', '2018-08-08 08:08:08', 'Ok', '005');
INSERT INTO `device_check` VALUES ('321', '001', '001', '2016-12-21 11:05:20', '状态良好', '321');
INSERT INTO `device_check` VALUES ('424', '001', '002', '2016-12-22 00:00:00', '4325435gdg', '4324');

-- ----------------------------
-- Table structure for `device_fault`
-- ----------------------------
DROP TABLE IF EXISTS `device_fault`;
CREATE TABLE `device_fault` (
  `device_fault_id` varchar(40) NOT NULL,
  `device_id` varchar(40) DEFAULT NULL,
  `device_fault_cause` varchar(100) DEFAULT NULL,
  `device_fault_detail` varchar(5000) DEFAULT NULL,
  `device_fault_date` datetime DEFAULT NULL,
  `device_fault_maintenance` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`device_fault_id`),
  KEY `FK_Reference_21` (`device_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_fault
-- ----------------------------
INSERT INTO `device_fault` VALUES ('001', '001', '台风', '哼哼哈嘿.', '2016-10-01 08:08:08', '人工');
INSERT INTO `device_fault` VALUES ('002', '002', '台风', '哼哼哈嘿', '2016-10-06 08:08:08', '人工');
INSERT INTO `device_fault` VALUES ('003', '003', '台风', '哼哼哈嘿', '2016-10-01 08:08:08', '人工');
INSERT INTO `device_fault` VALUES ('004', '004', '台风', '哼哼哈嘿', '2016-10-01 08:08:08', '人工');
INSERT INTO `device_fault` VALUES ('005', '005', '台风', '哼哼哈嘿', '2016-10-01 08:08:08', '人工');
INSERT INTO `device_fault` VALUES ('006', '006', '台风', '哼哼哈嘿', '2016-10-01 08:08:08', '人工');

-- ----------------------------
-- Table structure for `device_maintain`
-- ----------------------------
DROP TABLE IF EXISTS `device_maintain`;
CREATE TABLE `device_maintain` (
  `device_maintain_id` varchar(40) NOT NULL,
  `device_fault_id` varchar(40) DEFAULT NULL,
  `device_maintain_emp_id` varchar(10) DEFAULT NULL,
  `device_maintain_date` datetime DEFAULT NULL,
  `device_maintain_result` varchar(100) DEFAULT NULL,
  `device_maintain_cost` decimal(10,2) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`device_maintain_id`),
  KEY `FK_Reference_22` (`device_fault_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`device_fault_id`) REFERENCES `device_fault` (`device_fault_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_maintain
-- ----------------------------
INSERT INTO `device_maintain` VALUES ('001', '001', '001', '2016-10-07 08:08:08', '维修成功', '88.88', '费用已结清。');
INSERT INTO `device_maintain` VALUES ('002', '002', '001', '2016-10-07 08:08:08', '维修成功', '88.88', 'K.O.');
INSERT INTO `device_maintain` VALUES ('003', '003', '002', '2016-10-07 08:08:08', '维修成功', '88.88', 'K.O.');
INSERT INTO `device_maintain` VALUES ('004', '004', '001', '2016-10-07 08:08:08', '维修成功', '88.88', 'K.O.');
INSERT INTO `device_maintain` VALUES ('005', '005', '002', '2016-10-07 08:08:08', '维修成功', '88.88', 'K.O.');

-- ----------------------------
-- Table structure for `device_type`
-- ----------------------------
DROP TABLE IF EXISTS `device_type`;
CREATE TABLE `device_type` (
  `device_type_id` varchar(40) NOT NULL,
  `device_type_name` varchar(100) DEFAULT NULL,
  `device_type_model` varchar(200) DEFAULT NULL,
  `device_type_spec` varchar(200) DEFAULT NULL,
  `device_type_supplier` varchar(100) DEFAULT NULL,
  `device_type_producer` varchar(100) DEFAULT NULL,
  `device_type_quantity` int(11) DEFAULT NULL,
  `device_type_warranty` datetime DEFAULT NULL,
  PRIMARY KEY (`device_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_type
-- ----------------------------
INSERT INTO `device_type` VALUES ('01', '加工设备', '中', 'A', '福建百斯特贸易有限公司', '福建永辉机械有限公司', '11', '2018-08-08 08:08:08');
INSERT INTO `device_type` VALUES ('02', '冷暖设备', '中', 'B', '珠海格力有限公司', '珠海格力有限公司', '12', '2018-08-08 08:08:08');
INSERT INTO `device_type` VALUES ('03', '传送设备', '小', 'C', '福建永辉机械有限公司', '福建永辉机械有限公司', '13', '2018-08-08 08:08:08');
INSERT INTO `device_type` VALUES ('04', '清洗设备', '大', 'D', '福建百斯特贸易有限公司', '福建永辉机械有限公司', '14', '2018-08-08 08:08:08');
INSERT INTO `device_type` VALUES ('05', '打磨设备', '中', 'E', '厦门天德设备有限公司', '厦门海科设备有限公司', '15', '2018-08-08 08:08:08');
INSERT INTO `device_type` VALUES ('06', '冲压设备', '大', 'A', '厦门天德设备公司', '湖南三一重工', '20', '2016-12-24 11:58:46');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` varchar(40) NOT NULL,
  `emp_name` varchar(40) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `id_code` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `major` varchar(40) DEFAULT NULL,
  `graduate_school` varchar(40) DEFAULT NULL,
  `education_form` varchar(40) DEFAULT NULL,
  `department_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_Reference_30` (`department_id`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('001', '王武', '1', '350321xxxxxxxxxxxx', null, null, '在职', '本科', '学士', '计算机', null, '全日制', '002');
INSERT INTO `employee` VALUES ('002', '张三', '2', '152346842123458618', '1970-01-01', '1970-01-01', '在职', '大专', '无', '软件工程', null, '全日制', '005');
INSERT INTO `employee` VALUES ('003', '刘高升', '1', '156423547861546872', null, null, '在职', '大专', '无', '人力资源', null, '全日制', '001');
INSERT INTO `employee` VALUES ('005', '刘亦菲', '2', '156432486625615156', null, null, '在职', '本科', '学士', '形体礼仪', null, '在职', '007');

-- ----------------------------
-- Table structure for `final_count_check`
-- ----------------------------
DROP TABLE IF EXISTS `final_count_check`;
CREATE TABLE `final_count_check` (
  `f_count_check_id` varchar(40) NOT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  `check_item` varchar(40) DEFAULT NULL,
  `sample` int(11) DEFAULT NULL,
  `check_number` int(11) DEFAULT NULL,
  `unqualify` int(11) DEFAULT NULL,
  `qualify` decimal(3,2) DEFAULT NULL,
  `cdate` datetime DEFAULT NULL,
  `measure_data` varchar(2000) DEFAULT NULL,
  `emp_id` varchar(40) DEFAULT NULL,
  `result` varchar(2000) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`f_count_check_id`),
  KEY `FK_Reference_25` (`order_id`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`order_id`) REFERENCES `c_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of final_count_check
-- ----------------------------
INSERT INTO `final_count_check` VALUES ('20156', '000006', '平整度', '3', '3', '6', '0.89', '2015-05-13 00:00:00', '6', '001', '良', '问题较多，需要重审1');
INSERT INTO `final_count_check` VALUES ('33398', '000003', '透光度', '3', '3', '6', '0.89', '2015-05-13 00:00:00', '6', '001', '良', '问题较多，需要重审');
INSERT INTO `final_count_check` VALUES ('33521', '000006', '重量', '3', '3', '6', '0.89', '2015-05-13 00:00:00', '6', '001', '良', '问题较多，需要重审');
INSERT INTO `final_count_check` VALUES ('33789', '000003', '色差', '3', '3', '6', '0.89', '2015-05-13 00:00:00', '6', '001', '良', '问题较多，需要重审');
INSERT INTO `final_count_check` VALUES ('89658', '000006', '大小', '3', '3', '6', '0.89', '2015-05-13 00:00:00', '6', '001', '良', '问题较多，需要重审');

-- ----------------------------
-- Table structure for `final_measuret_check`
-- ----------------------------
DROP TABLE IF EXISTS `final_measuret_check`;
CREATE TABLE `final_measuret_check` (
  `f_measure_check_id` varchar(40) NOT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  `check_item` varchar(40) DEFAULT NULL,
  `cdate` datetime DEFAULT NULL,
  `measure_data` varchar(2000) DEFAULT NULL,
  `emp_id` varchar(40) DEFAULT NULL,
  `result` varchar(2000) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`f_measure_check_id`),
  KEY `FK_Reference_27` (`order_id`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`order_id`) REFERENCES `c_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of final_measuret_check
-- ----------------------------
INSERT INTO `final_measuret_check` VALUES ('11022', '000006', '材料', '2015-05-13 00:00:00', '36m', '001', '优', '合格率高，做工精致a');
INSERT INTO `final_measuret_check` VALUES ('11069', '000009', '工具', '2015-05-13 00:00:00', '36m', '001', '优', '合格率高，做工精致');
INSERT INTO `final_measuret_check` VALUES ('11079', '000006', '工具', '2015-05-13 00:00:00', '36m', '001', '优', '合格率高，做工精致');
INSERT INTO `final_measuret_check` VALUES ('11749', '000015', '资料', '2015-05-13 00:00:00', '36m', '001', '优', '合格率高，做工精致');
INSERT INTO `final_measuret_check` VALUES ('18969', '000013', '文具', '2015-05-13 00:00:00', '36m', '001', '优', '合格率高，做工精致');
INSERT INTO `final_measuret_check` VALUES ('19519', '000002', '工具', '2015-05-13 00:00:00', '36m', '001', '优', '合格率高，做工精致');

-- ----------------------------
-- Table structure for `manufacture`
-- ----------------------------
DROP TABLE IF EXISTS `manufacture`;
CREATE TABLE `manufacture` (
  `manufacture_sn` varchar(40) NOT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  `technology_id` varchar(40) DEFAULT NULL,
  `launch_quantity` int(11) DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`manufacture_sn`),
  KEY `FK_Reference_26` (`order_id`),
  KEY `FK_Reference_9` (`technology_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`order_id`) REFERENCES `c_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`technology_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manufacture
-- ----------------------------
INSERT INTO `manufacture` VALUES ('0001', '000002', '001', '15', '2016-10-27 09:23:01', '2016-10-28 09:23:05');
INSERT INTO `manufacture` VALUES ('0002', '000003', '002', '213', '2016-12-17 00:00:00', '2016-12-17 00:00:00');
INSERT INTO `manufacture` VALUES ('0003', '000002', '002', '31', '2016-12-17 00:00:00', '2016-12-17 00:00:00');
INSERT INTO `manufacture` VALUES ('0004', '000001', '001', '213', null, null);
INSERT INTO `manufacture` VALUES ('0007', '000003', '002', '143', '2016-12-21 00:00:00', '2016-12-21 00:00:00');

-- ----------------------------
-- Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `material_id` varchar(40) NOT NULL,
  `material_type` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `remaining` int(11) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('BZ3004985112', '包装类', '正常', '50', '用于保护<em></em>和指导产品使用的物品。');
INSERT INTO `material` VALUES ('FJ9810053211', '附件类', '充足', '35', '起到附属作用并具有独立使用功能的元件');
INSERT INTO `material` VALUES ('FM3003745734', '辅料类', '正常', '2', '用于生产及周转的低值辅助材料');
INSERT INTO `material` VALUES ('GM3587100823', '过滤件', '正常', '5', '起到过滤作用的零部件');
INSERT INTO `material` VALUES ('RJ10033214-80', '软胶件', '短缺', '-12', '用于组装主机及附件的且用软质材料');
INSERT INTO `material` VALUES ('SJ0011212178', '塑胶件', '充足', '41', '用于组装主机和附件及后续加工用的注塑件');
INSERT INTO `material` VALUES ('WJ3002123490', '五金件', '正常', '3', '用于组装主机和附件及后序加工用的单个金属件');
INSERT INTO `material` VALUES ('ZJ1006435620', '杂件类', '短缺', '-10', '用于组装主机及附件的用混杂材料加工成的元件');

-- ----------------------------
-- Table structure for `material_consume`
-- ----------------------------
DROP TABLE IF EXISTS `material_consume`;
CREATE TABLE `material_consume` (
  `consume_id` varchar(40) NOT NULL,
  `work_id` varchar(40) DEFAULT NULL,
  `material_id` varchar(40) DEFAULT NULL,
  `consume_amount` int(11) DEFAULT NULL,
  `consume_date` datetime DEFAULT NULL,
  `sender` varchar(40) DEFAULT NULL,
  `receiver` varchar(40) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`consume_id`),
  KEY `FK_Reference_16` (`material_id`),
  KEY `FK_Reference_33` (`work_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material_consume
-- ----------------------------
INSERT INTO `material_consume` VALUES ('A1187899', '001', 'WJ3002123490', '312', '2016-12-03 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '进口原料。');
INSERT INTO `material_consume` VALUES ('A1561810', '001', 'GM3587100823', '450', '2016-11-13 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '进口矿石');
INSERT INTO `material_consume` VALUES ('A1562771', '001', 'FM3003745734', '25', '2016-09-13 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '进口矿石');
INSERT INTO `material_consume` VALUES ('A1620202', '001', 'WJ3002123490', '31', '2016-09-12 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '煤炭焦炭');
INSERT INTO `material_consume` VALUES ('A1880923', '001', 'ZJ1006435620', '45', '2016-08-15 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '不锈钢原料');

-- ----------------------------
-- Table structure for `material_receive`
-- ----------------------------
DROP TABLE IF EXISTS `material_receive`;
CREATE TABLE `material_receive` (
  `receive_id` varchar(40) NOT NULL,
  `material_id` varchar(40) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `receive_date` datetime DEFAULT NULL,
  `sender` varchar(100) DEFAULT NULL,
  `receiver` varchar(40) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`receive_id`),
  KEY `FK_Reference_15` (`material_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material_receive
-- ----------------------------
INSERT INTO `material_receive` VALUES ('B1087893', 'RJ10033214-80', '21', '2016-12-20 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '粉矿3.67。');
INSERT INTO `material_receive` VALUES ('B108897', 'RJ10033214-80', '12', '2016-12-03 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '进口原料4.12');
INSERT INTO `material_receive` VALUES ('B12979001', 'FM3003745734', '51', '2016-12-03 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '纯净废铜5.12');
INSERT INTO `material_receive` VALUES ('B13048855', 'SJ0011212178', '71', '2016-12-03 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '进口原料1.34');
INSERT INTO `material_receive` VALUES ('B13409145', 'RJ10033214-80', '12', '2016-12-03 00:00:00', '齐鲁钢铁公司', '朝阳钢铁公司', '进口原料2.12');

-- ----------------------------
-- Table structure for `process`
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `process_id` varchar(40) NOT NULL,
  `technology_plan_id` varchar(40) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `quota` int(11) DEFAULT NULL,
  PRIMARY KEY (`process_id`),
  KEY `FK_Reference_32` (`technology_plan_id`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`technology_plan_id`) REFERENCES `technology_plan` (`technology_plan_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of process
-- ----------------------------
INSERT INTO `process` VALUES ('01', '001', '5', '3232');
INSERT INTO `process` VALUES ('02', '001', '2', '2');
INSERT INTO `process` VALUES ('03', '002', '4', '8');

-- ----------------------------
-- Table structure for `process_count_check`
-- ----------------------------
DROP TABLE IF EXISTS `process_count_check`;
CREATE TABLE `process_count_check` (
  `p_count_check_id` varchar(40) NOT NULL,
  `process_id` varchar(40) DEFAULT NULL,
  `check_item` varchar(40) DEFAULT NULL,
  `sample` int(11) DEFAULT NULL,
  `check_number` int(11) DEFAULT NULL,
  `unqualify` int(11) DEFAULT NULL,
  `qualify` decimal(3,2) DEFAULT NULL,
  `cdate` datetime DEFAULT NULL,
  `measure_data` varchar(2000) DEFAULT NULL,
  `emp_id` varchar(40) DEFAULT NULL,
  `result` varchar(2000) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`p_count_check_id`),
  KEY `FK_Reference_24` (`process_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`process_id`) REFERENCES `process` (`process_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of process_count_check
-- ----------------------------
INSERT INTO `process_count_check` VALUES ('33124', '03', '电灯', '6', '4', '8', '0.88', '2015-05-13 00:00:00', '12', '001', '优秀', '产品质量过关，外表美观');
INSERT INTO `process_count_check` VALUES ('36124', '03', '电话机', '6', '4', '8', '0.88', '2015-05-13 00:00:00', '12', '003', '优秀', '产品质量过关，外表美观');
INSERT INTO `process_count_check` VALUES ('36174', '03', '包装', '6', '4', '8', '0.88', '2015-05-13 00:00:00', '12', '001', '优秀', '产品质量过关，外表美观');
INSERT INTO `process_count_check` VALUES ('36744', '03', '电话机', '6', '4', '8', '0.88', '2015-05-13 00:00:00', '12', '001', '优秀', '产品质量过关，外表美观');
INSERT INTO `process_count_check` VALUES ('36784', '03', '电话机', '6', '4', '8', '0.88', '2015-05-13 00:00:00', '12', '001', '优秀', '产品质量过关，外表美观');

-- ----------------------------
-- Table structure for `process_measure_check`
-- ----------------------------
DROP TABLE IF EXISTS `process_measure_check`;
CREATE TABLE `process_measure_check` (
  `p_measure_check_id` varchar(40) NOT NULL,
  `process_id` varchar(40) DEFAULT NULL,
  `check_item` varchar(40) DEFAULT NULL,
  `cdate` datetime DEFAULT NULL,
  `measure_data` varchar(2000) DEFAULT NULL,
  `emp_id` varchar(40) DEFAULT NULL,
  `result` varchar(2000) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`p_measure_check_id`),
  KEY `FK_Reference_23` (`process_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`process_id`) REFERENCES `process` (`process_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of process_measure_check
-- ----------------------------
INSERT INTO `process_measure_check` VALUES ('025', '02', '耗时', '2016-12-24 00:00:00', '15h', '002', '良', '耗时良好。');
INSERT INTO `process_measure_check` VALUES ('73689', '03', '耗时', '2015-05-13 00:00:00', '37件', '002', '延时', '工序复杂，耗时1');
INSERT INTO `process_measure_check` VALUES ('79619', '03', '产品合格率', '2015-05-13 00:00:00', '37件', '001', '延时', '工序复杂，耗时');
INSERT INTO `process_measure_check` VALUES ('79689', '03', '工人工时', '2015-05-13 00:00:00', '37件', '003', '延时', '工序复杂，耗时');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` varchar(40) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_type` varchar(100) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('00001', '投影机', '电子设备', '/pic/1482320293986747.png,', '<p class=\"MsoNormal\" style=\"text-indent:24.0000pt;\">\r\n	投影机&nbsp;\r\n</p>\r\n<p class=\"MsoNormal\" align=\"center\" style=\"text-indent:24.0000pt;text-align:center;\">\r\n	&nbsp;\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	<span>基本规格</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	投影机类型	主流工程型\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	投影技术	DLP\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	技术规格	0.7 (对角线) DLP 4:3\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	投影方式 <span>正投</span>+背投+桌面+吊投\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	标准分辨率	1024<span>×</span><span>768</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	对比度	2000:1\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	<span>光学指标</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	亮度	6000流明\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	均匀度	90%\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	镜头焦距 <span>变焦镜头</span> (1.8-2.4:1)　F = 1.7-2.0, f = 25.6-33.8 毫米\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	投影距离	16.77M色\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	影像尺寸	50-600英寸\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	梯形校正 <span>梯形校正</span> ±<span>30</span><span>°</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	图像比例	4:3\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	水平扫描频率	15-91kHz\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	垂直扫描频率	50-85Hz\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	<span>信号接口</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	输出接口	RS-232C 输出 D-sub 9-pin（公）,遥控1 输出 M3 夹套\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	输入接口	VIDEO输入 BNC，S-VIDEO 输入 Mini DIN 4-pin，RGB1/YPBPR输入 BNC<span>×</span><span>5，RGB2 输入 D-sub HD 15-pin，DVI-D 输入 24pin DVI 1.0 compliant, HDCP 兼容，用于单一链接，RS-232C 输入 D-sub 9-pin（母），遥控1 输入 M3 夹套，遥控2 输入 D-sub 9-pin(母) (并行);</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	<span>电气指标</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	灯泡功率	275W UHM<span>×</span><span>2</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	灯泡寿命	3000小时\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	工作电源	220-240 V AC, 50/60 Hz\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	功耗	750W(790 VA) (待机模式下为15W,风扇停用)\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	<span>外观参数</span> \r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	重量	13.9kg\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24pt;\">\r\n	外形尺寸	530<span>×</span><span>429</span><span>×</span><span>167mm。</span>\r\n</p>\r\n<p class=\"MsoNormal\">\r\n	&nbsp;\r\n</p>', '2');
INSERT INTO `product` VALUES ('00002', '壁挂音箱', '电子设备', '/pic/1482319916209646.png,', '<h3 style=\"text-indent:24.0000pt;\">\r\n	<span>壁挂音箱</span> EAW SMS4：\r\n</h3>\r\n<p class=\"MsoNormal\" align=\"center\" style=\"text-indent:24.0000pt;text-align:center;\">\r\n	&nbsp;\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;130mm 高效率低频单元\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;0.5″球顶高音, 恒定指向号角负载\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;内置多抽头定压变压器\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;内置低阻抗分频器\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;重量轻、耐各种气候的高密度聚苯乙烯箱体，适合多种用途，具有隐蔽性\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;箱体具有安装点，配有安装支架，易于安装\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:36pt;text-indent:24pt;\">\r\n	•&nbsp;黑白两种颜色可供选择\r\n</p>', '2');
INSERT INTO `product` VALUES ('00003', '电脑', '电子设备', '/pic/1482321862758014.png,/pic/1482320425582171.png,', '<p class=\"MsoNormal\" style=\"text-indent:24.0000pt;\">\r\n	<br />\r\n</p>\r\n<p class=\"MsoNormal\" style=\"text-indent:24.0000pt;\">\r\n	<span> \r\n	<table class=\"tm-tableAttr\" style=\"margin:0px 0px 10px;padding:0px;border:1px solid #E5E5E5;width:789px;color:#404040;font-family:tahoma, arial, 微软雅黑, sans-serif;font-size:12px;background-color:#FFFFFF;\">\r\n		<tbody>\r\n			<tr class=\"tm-tableAttrSub\">\r\n				<th colspan=\"2\" style=\"text-align:left;background-color:#F7F7F7;\">\r\n					其他属性\r\n				</th>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					台式机类型\r\n				</th>\r\n				<td>\r\n					&nbsp;商用电脑\r\n				</td>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					售后服务\r\n				</th>\r\n				<td>\r\n					&nbsp;全国联保\r\n				</td>\r\n			</tr>\r\n			<tr class=\"tm-tableAttrSub\">\r\n				<th colspan=\"2\" style=\"text-align:left;background-color:#F7F7F7;\">\r\n					存储\r\n				</th>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					内存容量\r\n				</th>\r\n				<td>\r\n					&nbsp;4GB\r\n				</td>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					硬盘容量\r\n				</th>\r\n				<td>\r\n					&nbsp;其他/other\r\n				</td>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					显存容量\r\n				</th>\r\n				<td>\r\n					&nbsp;共享系统内存\r\n				</td>\r\n			</tr>\r\n			<tr class=\"tm-tableAttrSub\">\r\n				<th colspan=\"2\" style=\"text-align:left;background-color:#F7F7F7;\">\r\n					基本参数\r\n				</th>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					品牌\r\n				</th>\r\n				<td>\r\n					&nbsp;Dell/戴尔\r\n				</td>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					系列\r\n				</th>\r\n				<td>\r\n					&nbsp;3653-12N8+21.5\r\n				</td>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					显卡类型\r\n				</th>\r\n				<td>\r\n					&nbsp;集成显卡\r\n				</td>\r\n			</tr>\r\n			<tr class=\"tm-tableAttrSub\">\r\n				<th colspan=\"2\" style=\"text-align:left;background-color:#F7F7F7;\">\r\n					显示\r\n				</th>\r\n			</tr>\r\n			<tr>\r\n				<th style=\"color:#999999;font-weight:400;text-align:right;\">\r\n					显示器类型\r\n				</th>\r\n				<td>\r\n					&nbsp;LCD液晶-宽屏\r\n				</td>\r\n			</tr>\r\n		</tbody>\r\n	</table>\r\n</span> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>', '2');
INSERT INTO `product` VALUES ('00004', '桌子', '家具', '/pic/1482321245928113.png,/pic/1482321246031842.png,', '<p class=\"p\" style=\"margin-left:0.0000pt;text-indent:18.7500pt;vertical-align:baseline;\">\r\n	<br />\r\n</p>\r\n<p class=\"p\" style=\"text-indent:18.75pt;vertical-align:baseline;background:#EEEEEE;\">\r\n	如今的<a href=\"http://www.meilele.com/\"><span>家具</span></a>市场繁杂，光是对品牌的筛选就头痛，更别提款式的筛选了，即便是只针对<a href=\"http://www.meilele.com/keywords/zzzdcz/\"><span>桌子折叠餐桌</span></a>，也是如此。选家具还是要选口碑好的品牌，一张<a href=\"http://www.meilele.com/keywords/zhuozi/\"><span>桌子</span></a><a href=\"http://www.meilele.com/keywords/zhediezhuoyi/\"><span>折叠餐桌</span></a>我们还是要用个几年时间，如果不小心买到黑心商家的伪劣产品，用不了多久就会报废，而且有没有售后服务。接下来，小编为给位介绍几家口碑好的桌子折叠<a href=\"http://www.meilele.com/category-canzhuo/\"><span>餐桌</span></a>品牌及图片欣赏。\r\n</p>\r\n<p class=\"p\" style=\"text-indent:18.75pt;vertical-align:baseline;background:#EEEEEE;\">\r\n	<span>桌子折叠餐桌</span>—荣麟世佳<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 荣麟世佳品牌是中国原创家具开发的领导者，如今已经发展成为集于研发，销售，生产，物流于一体的大型规范的连锁企业。至今成功打造了原创品牌的几大家具系列。主营产品有：桌子折叠餐桌，<a href=\"http://www.meilele.com/keywords/banshijiaju/\"><span>板式家具</span></a>，<a href=\"http://www.meilele.com/keywords/shimujiaju/\"><span>实木家具</span></a>等。桌子折叠餐桌突出<a href=\"http://www.meilele.com/keywords/xiandaijiaju/\"><span>现代</span></a><a href=\"http://www.meilele.com/keywords/muzhijiaju/\"><span>木制家具</span></a>的自然、淳朴和艺术生活的完美再造。\r\n</p>\r\n<p class=\"p\" style=\"text-indent:18.75pt;vertical-align:baseline;background:#EEEEEE;\">\r\n	&nbsp;\r\n</p>\r\n<p class=\"p\" style=\"text-indent:18.75pt;vertical-align:baseline;background:#EEEEEE;\">\r\n	<span>桌子折叠餐桌</span>—喜德来家具<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 购买桌子折叠餐桌，可以选择值得信奈的喜得来家具品牌。喜德来家具是<a href=\"http://www.meilele.com/keywords/banshichuang/\"><span>板式床</span></a>，<a href=\"http://www.meilele.com/keywords/shimushafa/\"><span>实木沙发</span></a>和各种桌子折叠餐桌的大型家具企业。喜德来家具中的桌子折叠餐桌产品，以绿色<a href=\"http://www.meilele.com/keywords/huanbaojiaju/\"><span>环保</span></a>特点为主的，具有耐高温、不褪色、无异味、耐腐蚀、耐磨损五大优势。在好的品牌购买桌子折叠餐桌，不止实用，还具有健康环保的品质。\r\n</p>\r\n<p class=\"p\" style=\"text-indent:18.75pt;vertical-align:baseline;background:#EEEEEE;\">\r\n	&nbsp;\r\n</p>\r\n<p class=\"p\" style=\"text-indent:18.75pt;vertical-align:baseline;background:#EEEEEE;\">\r\n	<span>桌子折叠餐桌</span>—意风家具<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 意风家具是桌子折叠餐桌<a href=\"http://www.meilele.com/keywords/banshijiaju/\"><span>板式</span></a>家具的标志品牌，以国内及欧洲顶级<a href=\"http://www.meilele.com/keywords/hbbc/\"><span>环保板材</span></a>为基础，制造出<a href=\"http://zx.meilele.com/albums/c-21/\"><span>小户型</span></a>家庭必备的桌子折叠餐桌。桌子折叠餐桌有着精细的做工，<a href=\"http://www.meilele.com/keywords/jianyuejiaju/\"><span>简约</span></a><a href=\"http://zx.meilele.com/albums/c-7/\"><span>现代风格</span></a><span>，完整的功能和细致的服务。即使用上一段时间，发觉不喜欢或是质量有问题，这些都属于售后保障的范围内。</span>&nbsp;\r\n</p>\r\n<p>\r\n	<br />\r\n</p>', '2');
INSERT INTO `product` VALUES ('00005', '椅子', '家具', '/pic/1479522851948209.jpg,/pic/1479522852056749.jpg,', '<p class=\"p\" style=\"margin-left:0.0000pt;text-indent:18.7500pt;vertical-align:baseline;\">\r\n	&nbsp;长时间以来，<a href=\"http://www.meilele.com/keywords/yizi/\"><span>椅子</span></a>一直被认为是<a href=\"http://www.meilele.com/\"><span>家居</span></a>生活中最为重要的<a href=\"http://www.meilele.com/\"><span>家具</span></a>之一，人们审美意识提升和对高品质生活方式的追捧，使得高档<a href=\"http://www.meilele.com/keywords/yi/\"><span>椅</span></a><span>子受到追捧，成为了社会地位和身份的一种象征，对于整个空间高贵典雅氛围营造具有不可忽视的作用，高档椅子不只提供了人们的就座，同时还在各种正式场合被大量使用，那么高档椅子款式种类有哪些呢？下面就是对于</span>2016最新高档椅子款式种类的具体介绍，这就一起来了解一下吧。\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:0.0000pt;text-indent:0.0000pt;\">\r\n	&nbsp;\r\n</p>\r\n<table style=\"width:300pt;\">\r\n	<tbody>\r\n		<tr>\r\n			<td width=\"26\" valign=\"center\" style=\"border:31.8750pt none #FFFFFF;\">\r\n				<p class=\"MsoNormal\" style=\"text-indent:0pt;vertical-align:middle;\">\r\n					<span style=\"font-family:微软雅黑;color:#555555;font-size:10.5pt;\">&nbsp;</span>\r\n				</p>\r\n			</td>\r\n			<td width=\"374\" valign=\"center\" style=\"border:31.8750pt none #FFFFFF;\">\r\n				<p class=\"MsoNormal\" style=\"text-indent:0pt;vertical-align:middle;\">\r\n					<b><span class=\"15\" style=\"font-family:微软雅黑;color:#BA0343;font-size:13.5pt;\">高档椅子-</span></b><b><span class=\"15\" style=\"font-family:微软雅黑;color:#FF0000;font-size:10pt;\">现代风格</span></b><span style=\"font-family:微软雅黑;font-size:10.5pt;\"></span>\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n<p class=\"p\" style=\"margin-left:0.0000pt;text-indent:18.7500pt;vertical-align:baseline;\">\r\n	&nbsp;高档椅子在款式<a href=\"http://zx.meilele.com/\"><span>设计</span></a>上更加新颖时尚，其舒适度得到极大提升，这款高档椅子款式设计新颖时尚，采用优质<a href=\"http://www.meilele.com/keywords/buxiugangjiaju/\"><span>不锈钢</span></a>框架，搭配头层黄牛皮制作，使其舒适性和<a href=\"http://zx.meilele.com/\"><span>装饰</span></a><span>性得到极大提升，</span>“外柔内刚”的造型设计，表面厚度弹性层，与人体接触透气、耐磨、耐脏，且不易产生静电。独特的”田“字型<a href=\"http://www.meilele.com/keywords/zhenpijiaju/\"><span>真皮</span></a>靠背、宽大的扶手设计、干净利落的背面、人性化可拆卸靠包、精湛的扪皮工艺，处处给您带来温馨舒适的居家生活，彰显出主人时尚的生活品味。\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:0.0000pt;text-indent:0.0000pt;\">\r\n	&nbsp;\r\n</p>\r\n<p class=\"MsoNormal\" style=\"margin-left:0.0000pt;text-indent:0.0000pt;\">\r\n	&nbsp;\r\n</p>\r\n<table style=\"width:300pt;\">\r\n	<tbody>\r\n		<tr>\r\n			<td width=\"26\" valign=\"center\" style=\"border:31.8750pt none #FFFFFF;\">\r\n				<p class=\"MsoNormal\" style=\"text-indent:0pt;vertical-align:middle;\">\r\n					<span style=\"font-family:微软雅黑;color:#555555;font-size:10.5pt;\">&nbsp;</span>\r\n				</p>\r\n			</td>\r\n			<td width=\"374\" valign=\"center\" style=\"border:31.8750pt none #FFFFFF;\">\r\n				<p class=\"MsoNormal\" style=\"text-indent:0pt;vertical-align:middle;\">\r\n					<b><span class=\"15\" style=\"font-family:微软雅黑;color:#BA0343;font-size:13.5pt;\">高档椅子-</span></b><b><span class=\"15\" style=\"font-family:微软雅黑;color:#FF0000;font-size:10pt;\">美式风格</span></b><span style=\"font-family:微软雅黑;font-size:10.5pt;\"></span>\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n<p class=\"p\" style=\"margin-left:0.0000pt;text-indent:18.7500pt;vertical-align:baseline;\">\r\n	&nbsp;<a href=\"http://www.meilele.com/keywords/danrenyi/\"><span>单人椅</span></a>由于其对空间利用更加合理，使得单人椅被大量使用，图上这款高档椅子款式设计独特新颖，独特的造型设计使其艺术感极佳，圈背造型体现出主人活泼时尚的个性，高背式高档椅子，更适合<a href=\"http://www.meilele.com/category-shufang/\"><span>书房</span></a>使用，能传递出休闲、轻松、舒适的室内氛围，流畅圆弧的弧线造型搭配强烈的颜色对比，使其装饰性和美感别具一格，个人风格强烈，放置在空间一角或是<a href=\"http://zx.meilele.com/albums/c-31/\"><span>阳台</span></a>其装饰性极佳。细节处精湛的工艺处理，将其品质感演绎的淋漓尽致。\r\n</p>', '2');
INSERT INTO `product` VALUES ('00006', '哈尔滨啤酒', '饮品', '/pic/1482321612488579.jpg,', '<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	规格：500ml*3*6\r\n</p>\r\n<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	&nbsp;\r\n</p>\r\n<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	食用方法：开罐即饮\r\n</p>\r\n<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	贮存方法：请置于阴凉处、避免阳光直射\r\n</p>\r\n<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	<span style=\"font-size:18px;\"><span style=\"font-weight:700;\"><span style=\"color:#FF0000;\">温馨提示：<br />\r\n</span></span></span>\r\n</p>\r\n<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	<span style=\"font-size:18px;\"><span style=\"font-weight:700;\"><span style=\"color:#FF0000;\">商品包装升级，新老包装随机发货，介意慎拍！</span></span></span>\r\n</p>', '1');
INSERT INTO `product` VALUES ('00007', '火腿肠', '食品', '/pic/1482286806231225.jpg,/pic/1482286806302546.jpg,/pic/1482286795616255.jpg,', '这是网易猪肉做成的火腿肠', '1');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `parentids` varchar(128) DEFAULT NULL COMMENT '父结点id列表串',
  `sortstring` varchar(128) DEFAULT NULL COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '权限', 'permission', '', 'order:edit', '0', '0/', '0', '1');
INSERT INTO `sys_permission` VALUES ('10', '订单管理', 'menu', '', null, '1', '0/1/', '1.', '1');
INSERT INTO `sys_permission` VALUES ('11', '订单新增', 'permission', 'order/add_judge', 'order:add', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('12', '订单修改', 'permission', 'order/edit_judge', 'order:edit', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('13', '订单删除', 'permission', 'order/delete_judge', 'order:delete', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('20', '客户管理', 'menu', '', '', '1', '0/1/', '2.', '1');
INSERT INTO `sys_permission` VALUES ('21', '客户新增', 'permission', '', 'custom:add', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('22', '客户修改', 'permission', '', 'custom:edit', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('23', '客户删除', 'permission', '', 'custom:delete', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('30', '产品管理', 'menu', null, null, null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('31', '产品新增', 'permission', null, 'product:add', null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('32', '产品修改', 'permission', null, 'product:edit', null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('33', '产品删除', 'permission', null, 'product:delete', null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('40', '部门管理', 'menu', null, null, null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('41', '部门新增', 'permission', null, 'department:add', null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('42', '部门修改', 'permission', null, 'department:edit', null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('43', '部门删除', 'permission', null, 'department:delete', null, null, null, '1');
INSERT INTO `sys_permission` VALUES ('50', '员工管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('51', '员工新增', 'permission', null, 'employee:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('52', '员工修改', 'permission', null, 'employee:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('53', '员工删除', 'permission', null, 'employee:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('60', '作业管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('61', '作业新增', 'permission', null, 'work:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('62', '作业修改', 'permission', null, 'work:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('63', '作业删除', 'permission', null, 'work:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('70', '生产计划管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('71', '生产计划新增', 'permission', null, 'manufacture:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('72', '生产计划修改', 'permission', null, 'manufacture:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('73', '生产计划删除', 'permission', null, 'manufacture:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('80', '生产派工管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('81', '生产派工新增', 'permission', null, 'task:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('82', '生产派工修改', 'permission', null, 'task:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('83', '生产派工删除', 'permission', null, 'task:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('90', '工艺管理', 'menu', null, '', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('91', '工艺新增', 'permission', null, 'technology:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('92', '工艺修改', 'permission', null, 'technology:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('93', '工艺删除', 'permission', null, 'technology:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('100', '工序管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('101', '工序新增', 'permission', null, 'process:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('102', '工序修改', 'permission', null, 'process:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('103', '工序删除', 'permission', null, 'process:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('110', '工艺计划管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('111', '工艺计划新增', 'permission', null, 'technologyPlan:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('112', '工艺计划修改', 'permission', null, 'technologyPlan:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('113', '工艺计划删除', 'permission', null, 'technologyPlan:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('120', '工艺要求管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('121', '工艺要求新增', 'permission', null, 'technologyRequirement:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('122', '工艺要求修改', 'permission', null, 'technologyRequirement:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('123', '工艺要求删除', 'permission', null, 'technologyRequirement:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('130', '成品计数质检', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('131', '成品计数质检新增', 'permission', null, 'fCountCheck:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('132', '成品计数质检修改', 'permission', null, 'fCountCheck:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('133', '成品计数质检删除', 'permission', null, 'fCountCheck:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('140', '成品计量质检', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('141', '成品计量质检新增', 'permission', null, 'fMeasureCheck:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('142', '成品计量质检修改', 'permission', null, 'fMeasureCheck:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('143', '成品计量质检删除', 'permission', null, 'fMeasureCheck:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('150', '工序计数质检', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('151', '工序计数质检新增', 'permission', null, 'pCountCheck:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('152', '工序计数质检修改', 'permission', null, 'pCountCheck:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('153', '工序计数质检删除', 'permission', null, 'pCountCheck:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('160', '工序计量质检', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('161', '工序计量质检新增', 'permission', null, 'pMeasureCheck:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('162', '工序计量质检修改', 'permission', null, 'pMeasureCheck:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('163', '工序计量质检删除', 'permission', null, 'pMeasureCheck:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('170', '不合格品申请', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('171', '不合格品申请新增', 'permission', null, 'unqualify:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('172', '不合格品申请修改', 'permission', null, 'unqualify:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('173', '不合格品申请删除', 'permission', null, 'unqualify:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('180', '物料管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('181', '物料新增', 'permission', null, 'material:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('182', '物料修改', 'permission', null, 'material:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('183', '物料删除', 'permission', null, 'material:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('190', '物料收入', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('191', '物料收入新增', 'permission', null, 'materialReceive:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('192', '物料收入修改', 'permission', null, 'materialReceive:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('193', '物料收入删除', 'permission', null, 'materialReceive:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('200', '用户管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('201', '用户新增', 'permission', null, 'user:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('202', '用户修改', 'permission', null, 'user:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('203', '用户删除', 'permission', null, 'user:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('210', '角色管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('211', '角色新增', 'permission', null, 'role:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('212', '角色修改', 'permission', null, 'role:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('213', '角色删除', 'permission', null, 'role:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('220', '物料消耗', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('221', '物料消耗新增', 'permission', null, 'materialConsume:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('222', '物料消耗修改', 'permission', null, 'materialConsume:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('223', '物料消耗删除', 'permission', null, 'materialConsume:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('230', '设备管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('231', '设备新增', 'permission', null, 'deviceList:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('232', '设备修改', 'permission', null, 'deviceList:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('233', '设备删除', 'permission', null, 'deviceList:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('240', '设备例检管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('241', '设备例检新增', 'permission', null, 'deviceCheck:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('242', '设备例检修改', 'permission', null, 'deviceCheck:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('243', '设备例检删除', 'permission', null, 'deviceCheck:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('250', '设备故障管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('251', '设备故障新增', 'permission', null, 'deviceFault:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('252', '设备故障修改', 'permission', null, 'deviceFault:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('253', '设备故障删除', 'permission', null, 'deviceFault:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('260', '设备维修管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('261', '设备维修新增', 'permission', null, 'deviceMaintain:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('262', '设备维修修改', 'permission', null, 'deviceMaintain:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('263', '设备维修删除', 'permission', null, 'deviceMaintain:delete', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('270', '设备种类管理', 'menu', null, null, null, null, null, null);
INSERT INTO `sys_permission` VALUES ('271', '设备种类新增', 'permission', null, 'deviceType:add', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('272', '设备种类修改', 'permission', null, 'deviceType:edit', null, null, null, null);
INSERT INTO `sys_permission` VALUES ('273', '设备种类删除', 'permission', null, 'deviceType:delete', null, null, null, null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(36) NOT NULL,
  `role_name` varchar(128) NOT NULL,
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('001', '超级管理员', '1');
INSERT INTO `sys_role` VALUES ('002', '订单管理员', '1');
INSERT INTO `sys_role` VALUES ('004', '物料管理员', '1');
INSERT INTO `sys_role` VALUES ('005', '普通用户', '1');
INSERT INTO `sys_role` VALUES ('007', '设备管理员', '1');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(50) NOT NULL,
  `sys_role_id` varchar(50) NOT NULL COMMENT '角色id',
  `sys_permission_id` varchar(300) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1456115611515', '002', '11,12,13,201,202,203,');
INSERT INTO `sys_role_permission` VALUES ('147729449886163', '15615615151', '11,12,13,231,232,233,271,273,');
INSERT INTO `sys_role_permission` VALUES ('147737863632731', '005', '11,33,81,83,91,93,101,102,103,121,192,131,133,151,153,173,273,252,51,53,');
INSERT INTO `sys_role_permission` VALUES ('148007157091762', '004', '181,182,183,191,192,193,221,222,223,');
INSERT INTO `sys_role_permission` VALUES ('148255367614063', '007', null);
INSERT INTO `sys_role_permission` VALUES ('149122370655248', '31931', null);
INSERT INTO `sys_role_permission` VALUES ('149122382565714', '424', null);
INSERT INTO `sys_role_permission` VALUES ('149122469890916', '3213', null);
INSERT INTO `sys_role_permission` VALUES ('149122510431476', '3214321', null);
INSERT INTO `sys_role_permission` VALUES ('149122513769244', '213213213', '11,12,13,');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f21', '001', '11,12,13,21,22,23,31,32,33,61,62,63,71,72,73,81,82,83,91,92,93,101,102,103,111,112,113,121,122,123,181,182,183,191,192,193,221,222,223,131,132,133,141,142,143,151,152,153,161,162,163,171,172,173,231,232,233,271,272,273,241,242,243,251,252,253,261,262,263,41,42,43,51,52,53,201,202,203,211,212,213,');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(64) DEFAULT NULL COMMENT '姓名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('001', '王经理', '11', '1');
INSERT INTO `sys_user` VALUES ('002', '22', '22', '1');
INSERT INTO `sys_user` VALUES ('003', '张三', 'aaa', '1');
INSERT INTO `sys_user` VALUES ('004', 'aa', 'aa', '1');
INSERT INTO `sys_user` VALUES ('005', '11', '11', '1');
INSERT INTO `sys_user` VALUES ('006', '王二', '12345', '2');
INSERT INTO `sys_user` VALUES ('007', '李大山', '11', '1');
INSERT INTO `sys_user` VALUES ('3213', 'ga', '22', '1');
INSERT INTO `sys_user` VALUES ('321321', '55', '55', '1');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `sys_user_id` varchar(32) NOT NULL,
  `sys_role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('001', '001', '001');
INSERT INTO `sys_user_role` VALUES ('147705484492576', '003', '002');
INSERT INTO `sys_user_role` VALUES ('148228593447685', '004', '005');
INSERT INTO `sys_user_role` VALUES ('148232608456017', '002', '001');
INSERT INTO `sys_user_role` VALUES ('148232650257115', '005', '002');
INSERT INTO `sys_user_role` VALUES ('148237251058254', '321321', '004');
INSERT INTO `sys_user_role` VALUES ('148237503507696', '3213', '005');
INSERT INTO `sys_user_role` VALUES ('148249856407793', '006', '002');
INSERT INTO `sys_user_role` VALUES ('148255363744945', '007', '004');

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` varchar(40) NOT NULL,
  `manufacture_sn` varchar(40) DEFAULT NULL,
  `work_id` varchar(40) DEFAULT NULL,
  `task_quantity` int(11) DEFAULT NULL,
  `working_hours` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK_Reference_34` (`manufacture_sn`),
  KEY `FK_Reference_6` (`work_id`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`manufacture_sn`) REFERENCES `manufacture` (`manufacture_sn`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('001', '0002', '001', '112', '700');
INSERT INTO `task` VALUES ('002', '0001', '001', '213', '221');
INSERT INTO `task` VALUES ('003', '0003', '003', '150', '15');
INSERT INTO `task` VALUES ('004', '0004', '004', '154', '851');

-- ----------------------------
-- Table structure for `technology`
-- ----------------------------
DROP TABLE IF EXISTS `technology`;
CREATE TABLE `technology` (
  `technology_id` varchar(40) NOT NULL,
  `technology_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `vital_process_period` varchar(50) DEFAULT NULL,
  `standard_capacity` int(11) DEFAULT NULL,
  `overtime_standard_capacity` int(11) DEFAULT NULL,
  `overtime_overfulfil_capacity` int(11) DEFAULT NULL,
  `double_capacity` int(11) DEFAULT NULL,
  `overfulfil_capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`technology_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology
-- ----------------------------
INSERT INTO `technology` VALUES ('001', '打磨精加工', '33.00', '12', '333', '333', '666', '1200', '1400');
INSERT INTO `technology` VALUES ('002', '打磨粗加工', '8.00', '3', '20', '25', '30', '40', '50');
INSERT INTO `technology` VALUES ('004', '抛光', '156.00', '1', '8', '2', '5', '5', '5');
INSERT INTO `technology` VALUES ('005', '打蜡', '7.00', '7', '7', '7', '7', '7', '7');
INSERT INTO `technology` VALUES ('006', '一体成型', '6.00', '6', '6', '6', '6', '66', '666');

-- ----------------------------
-- Table structure for `technology_plan`
-- ----------------------------
DROP TABLE IF EXISTS `technology_plan`;
CREATE TABLE `technology_plan` (
  `technology_plan_id` varchar(40) NOT NULL,
  `technology_id` varchar(40) DEFAULT NULL,
  `batch_amount` int(11) DEFAULT NULL,
  `start_plan` datetime DEFAULT NULL,
  `end_plan` datetime DEFAULT NULL,
  `commit_plan` datetime DEFAULT NULL,
  `technology_plan_start` datetime DEFAULT NULL,
  `technology_plan_end` datetime DEFAULT NULL,
  PRIMARY KEY (`technology_plan_id`),
  KEY `FK_Reference_31` (`technology_id`),
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`technology_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology_plan
-- ----------------------------
INSERT INTO `technology_plan` VALUES ('0008', '002', '30', '2016-12-29 00:00:00', '2016-12-24 00:00:00', '2017-01-10 00:00:00', null, null);
INSERT INTO `technology_plan` VALUES ('001', '002', '202', '2016-11-16 11:29:11', '2016-11-16 11:29:14', '2016-11-16 11:29:16', null, null);
INSERT INTO `technology_plan` VALUES ('002', '001', '56', '1970-01-01 08:00:00', '1970-01-01 08:00:00', '1970-01-01 08:00:00', null, null);
INSERT INTO `technology_plan` VALUES ('003', '002', '30', '2016-11-16 20:51:09', '2016-11-16 20:51:11', '2016-11-16 20:51:13', null, null);
INSERT INTO `technology_plan` VALUES ('004', '004', '321', '2016-12-21 00:00:00', '2016-12-21 00:00:00', '2016-12-21 00:00:00', null, null);

-- ----------------------------
-- Table structure for `technology_requirement`
-- ----------------------------
DROP TABLE IF EXISTS `technology_requirement`;
CREATE TABLE `technology_requirement` (
  `technology_requirement_id` varchar(40) NOT NULL,
  `technology_id` varchar(40) DEFAULT NULL,
  `requirement` varchar(2000) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `revise_time` datetime DEFAULT NULL,
  PRIMARY KEY (`technology_requirement_id`),
  KEY `FK_Reference_10` (`technology_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`technology_id`) REFERENCES `technology` (`technology_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology_requirement
-- ----------------------------
INSERT INTO `technology_requirement` VALUES ('01', '001', '<strong><em>dgfghfhgjf</em></strong>', '2016-11-30 16:07:08', '2016-11-30 16:07:10');
INSERT INTO `technology_requirement` VALUES ('02', '002', 'hijklmn', '2016-11-16 16:07:30', '2016-11-16 16:07:34');
INSERT INTO `technology_requirement` VALUES ('03', '005', '1321231', '2016-11-16 16:28:04', '2016-11-16 16:28:06');
INSERT INTO `technology_requirement` VALUES ('04', '002', '<strong>fdsfdsfdsafdsfcvvvvvcvffffwudali</strong>', '1970-01-01 08:00:00', '1970-01-01 08:00:00');
INSERT INTO `technology_requirement` VALUES ('05', '001', '<strong>dsafsffdsfafvvvv</strong>', '2016-11-16 19:51:50', '2016-11-16 19:51:51');
INSERT INTO `technology_requirement` VALUES ('06', '004', '抛光需仔细，反射面要达到要求', '2016-12-21 00:00:00', '2016-12-21 00:00:00');
INSERT INTO `technology_requirement` VALUES ('07', '002', '321321321', '2016-12-07 11:10:12', '2016-12-22 11:10:15');

-- ----------------------------
-- Table structure for `unqualify_apply`
-- ----------------------------
DROP TABLE IF EXISTS `unqualify_apply`;
CREATE TABLE `unqualify_apply` (
  `unqualify_apply_id` varchar(40) NOT NULL,
  `product_id` varchar(40) DEFAULT NULL,
  `unqualify_item` varchar(200) DEFAULT NULL,
  `unqualify_count` int(11) DEFAULT NULL,
  `assembly_date` datetime DEFAULT NULL,
  `emp_id` varchar(40) DEFAULT NULL,
  `apply_date` datetime DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`unqualify_apply_id`),
  KEY `FK_Reference_29` (`product_id`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unqualify_apply
-- ----------------------------
INSERT INTO `unqualify_apply` VALUES ('0001', '00001', '成像质量', '2', '2015-05-13 00:00:00', '001', '2015-05-13 00:00:00', '需要返厂');
INSERT INTO `unqualify_apply` VALUES ('0002', '00005', '平整度', '5', '2015-05-13 00:00:00', '002', '2015-05-13 00:00:00', '需要返厂');
INSERT INTO `unqualify_apply` VALUES ('0003', '00002', '音量', '15', '2016-12-21 00:00:00', '002', '2016-12-21 00:00:00', '需要返厂');
INSERT INTO `unqualify_apply` VALUES ('01231', '00003', '电池', '50', '2016-12-21 00:00:00', '003', '2016-12-24 12:15:16', '<span style=\"font-family:SimHei;font-size:16px;\">电池效率不达标，且电池耐久度不合格，<strong><span style=\"color:#E53333;\">存在一定的安全隐患</span></strong>。</span>');

-- ----------------------------
-- Table structure for `work`
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `work_id` varchar(40) NOT NULL,
  `process_number` varchar(40) DEFAULT NULL,
  `product_id` varchar(40) DEFAULT NULL,
  `process_id` varchar(40) DEFAULT NULL,
  `device_id` varchar(40) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`work_id`),
  KEY `FK_Reference_12` (`process_id`),
  KEY `FK_Reference_17` (`device_id`),
  KEY `FK_Reference_7` (`product_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`process_id`) REFERENCES `process` (`process_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('001', '1', '00004', '01', '001', '50');
INSERT INTO `work` VALUES ('002', '5', '00003', '02', '003', '32');
INSERT INTO `work` VALUES ('003', '1', '00002', '02', '002', '13');
INSERT INTO `work` VALUES ('004', '2', '00003', '03', '003', '15');
INSERT INTO `work` VALUES ('005', '3', '00002', '02', '005', '16');
