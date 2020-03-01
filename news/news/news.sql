-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2019 年 12 月 18 日 15:22
-- 服务器版本: 5.6.12-log
-- PHP 版本: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `news`
--

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) COLLATE utf8_german2_ci NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`category_id`, `name`) VALUES
(1, '国内'),
(2, '国际'),
(3, '军事'),
(4, '财经'),
(5, '娱乐'),
(7, '健康'),
(8, '汽车');

-- --------------------------------------------------------

--
-- 表的结构 `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `title` char(100) COLLATE utf8_german2_ci NOT NULL,
  `content` text COLLATE utf8_german2_ci,
  `publish_time` datetime DEFAULT NULL,
  `clicked` int(11) DEFAULT NULL,
  `attachment` char(100) COLLATE utf8_german2_ci DEFAULT NULL,
  PRIMARY KEY (`news_id`),
  KEY `FK_news_user` (`user_id`),
  KEY `FK_news_category` (`category_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `news`
--

INSERT INTO `news` (`news_id`, `user_id`, `category_id`, `title`, `content`, `publish_time`, `clicked`, `attachment`) VALUES
(1, 1, 1, '中方回应美批准成立太空部队：防止外空沦为新战场', '中方回应美批准成立太空部队：表明外空武器化风险上升 对此深感担忧\r\n\r\n　　中新网北京12月18日电 (黄钰钦)针对美国会参议院通过法案批准美成立太空部队，中国外交部发言人耿爽18日在例行记者会上表示，这进一步表明当前外空武器化和战场化风险日趋上升，中方对此深感担忧\r\n\r\n　　有记者提问，美国会参议院通过2020财年国防授权法案，批准美成立太空部队。中方对此有何评论？\r\n\r\n　　耿爽表示，中方注意到有关报道，这进一步表明当前外空武器化和战场化风险日趋上升，中方对此深感担忧。外空是全人类的共同财富。确保外空的和平利用，防止外空武器化和军备竞赛，不仅符合各国共同利益，也是各国共同责任。当前形势下，谈判达成外空军控国际法律文书的必要性和紧迫性进一步上升。中方希望国际社会特别是有关大国采取慎重、负责的态度，防止外空沦为新的战场，共同努力维护外空持久和平与安宁。\r\n\r\n　　另有记者提问，特朗普政府尤其是商务部门正在制定措施，禁止向中国出口尖端技术。中方对此有何评论？\r\n\r\n　　耿爽指出，中方坚决反对美方泛化国家安全概念，滥用出口管制措施，干涉、限制企业间正常交往与合作。中方敦促美方要多做有利于促进中美互信与合作的事情，而不是相反。\r\n\r\n　　“美方不要以为限制对华出口尖端科技能够阻止中国科技创新，能够迟滞中国发展进步，他们有些太自以为是了。新中国成立70年来取得的伟大成就，是中国人民自力更生、艰苦奋斗、流血流汗拼搏出来的。”耿爽强调说，“无论美方限制也好，干扰也好，破坏也好，封锁也好，对中方都造不成太大困难。暂时的挫折只会激发中国人民的聪明才智和昂扬斗志，我们对中国的科技进步和发展壮大充满信心。	', '2019-12-16 06:25:38', 353, '1576422661287_531.png'),
(3, 1, 1, '2020年全国硕士研究生招生考试21日开考 341万人报名', '&lt;p&gt;\r\n	&lt;span style=&quot;font-size:14px;&quot;&gt;&lt;span style=&quot;color: rgb(51, 51, 51); font-family: &amp;quot;microsoft yahei&amp;quot;; letter-spacing: 1px;&quot;&gt;　&lt;/span&gt;&lt;a href=&quot;http://www.chinanews.com/&quot; style=&quot;text-decoration-line: none; color: rgb(30, 118, 226); font-family: &amp;quot;microsoft yahei&amp;quot;; font-size: 20px; letter-spacing: 1px;&quot; target=&quot;_blank&quot;&gt;中新网&lt;/a&gt;&lt;span style=&quot;color: rgb(51, 51, 51); font-family: &amp;quot;microsoft yahei&amp;quot;; letter-spacing: 1px;&quot;&gt;12月18日电 据教育部网站消息，2020年全国硕士研究生招生考试将于12月21日至23日举行，报考人数341万人。为严厉打击涉考违法活动，严肃考试纪律，维护考生合法权益，教育部18日在官网公布2020年全国硕士研究生招生考试违规违法行为举报电话，提醒广大考生知法守法，诚信考试。&lt;/span&gt;&lt;/span&gt;&lt;span style=&quot;color: rgb(51, 51, 51); font-family: &amp;quot;microsoft yahei&amp;quot;; font-size: 20px; letter-spacing: 1px;&quot;&gt;&lt;span style=&quot;font-size:14px;&quot;&gt;　教育部指出，近期，各地教育、公安、网信、工信、市场监管等相关部门正联合开展考试环境综合治理。对涉考违法违规活动，有关部门将依法严厉打击，发现一起、查处一起，坚决维护研招考试公平公正。&lt;/span&gt;&lt;/span&gt;&lt;/p&gt;\r\n&lt;p style=&quot;margin: 15px 0px; padding: 0px; color: rgb(51, 51, 51); letter-spacing: 1px; font-family: &amp;quot;microsoft yahei&amp;quot;; font-size: 20px;&quot;&gt;\r\n	&lt;span style=&quot;font-size:14px;&quot;&gt;　　根据2019年9月4日起施行的《最高人民法院、最高人民检察院关于办理组织考试作弊等刑事案件适用法律若干问题的解释》，在研究生招生考试中&amp;ldquo;组织考试作弊&amp;rdquo;&amp;ldquo;非法出售或者提供试题、答案&amp;rdquo;等情形，均应认定为刑法第二百八十四条规定之一的&amp;ldquo;情节严重&amp;rdquo;，将依法从重追究刑事责任。&lt;/span&gt;&lt;/p&gt;\r\n&lt;p style=&quot;margin: 15px 0px; padding: 0px; color: rgb(51, 51, 51); letter-spacing: 1px; font-family: &amp;quot;microsoft yahei&amp;quot;; font-size: 20px;&quot;&gt;\r\n	&lt;span style=&quot;font-size:14px;&quot;&gt;　　教育部郑重提醒广大考生，要切实增强法制观念，提高法律意识，自觉学法知法、尊法守法，诚信考试，不参与涉考违法犯罪活动，同时，不要听信一些社会培训机构&amp;ldquo;包过&amp;rdquo;&amp;ldquo;保过&amp;rdquo;的虚假宣传，不购买所谓&amp;ldquo;试题&amp;rdquo;&amp;ldquo;答案&amp;rdquo;，谨防受骗。&lt;/span&gt;&lt;/p&gt;\r\n&lt;p style=&quot;margin: 15px 0px; padding: 0px; color: rgb(51, 51, 51); letter-spacing: 1px; font-family: &amp;quot;microsoft yahei&amp;quot;; font-size: 20px;&quot;&gt;\r\n	&lt;span style=&quot;font-size:14px;&quot;&gt;　　教育部指出，欢迎社会各界和广大考生积极参与监督，共同维护公平公正的考试环境。&lt;/span&gt;&lt;/p&gt;\r\n&lt;p&gt;\r\n	&amp;nbsp;&lt;/p&gt;\r\n', '2019-12-18 14:00:57', 23, 'new2.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_id` int(11) DEFAULT NULL,
  `content` text COLLATE utf8_german2_ci,
  `publish_time` datetime DEFAULT NULL,
  `state` char(10) COLLATE utf8_german2_ci DEFAULT NULL,
  `ip` char(15) COLLATE utf8_german2_ci DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK_review_news` (`news_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `review`
--

INSERT INTO `review` (`review_id`, `news_id`, `content`, `publish_time`, `state`, `ip`) VALUES
(1, 1, '不错，写得好', '2019-12-16 06:40:21', '已审核', '127.0.0.1'),
(2, 1, '很好！', '2019-12-18 13:44:19', '已审核', '::1');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) COLLATE utf8_german2_ci NOT NULL,
  `password` char(32) COLLATE utf8_german2_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`user_id`, `name`, `password`) VALUES
(1, 'admin', '202cb962ac59075b964b07152d234b70'),
(2, 'ZB1018144', '202cb962ac59075b964b07152d234b70'),
(3, 'wjn', '202cb962ac59075b964b07152d234b70');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
