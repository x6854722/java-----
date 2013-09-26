-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 09 月 09 日 06:14
-- 服务器版本: 5.5.16
-- PHP 版本: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `hotelmanager`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_hotel`
--

CREATE TABLE IF NOT EXISTS `t_hotel` (
  `hotel_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hotel_Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hotel_Address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hotel_Price` float DEFAULT NULL,
  `hotel_Quantity` int(11) DEFAULT NULL,
  `hotel_Star` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hotel_Image` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `hotel_Description` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 转存表中的数据 `t_hotel`
--

INSERT INTO `t_hotel` (`hotel_Id`, `hotel_Name`, `hotel_Address`, `hotel_Price`, `hotel_Quantity`, `hotel_Star`, `hotel_Image`, `hotel_Description`) VALUES
('A001', '北京高级温泉会馆', '北京', 300, 101, '5', 'images.jpg', '高级会馆');

-- --------------------------------------------------------

--
-- 表的结构 `t_manager`
--

CREATE TABLE IF NOT EXISTS `t_manager` (
  `man_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `man_Password` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 转存表中的数据 `t_manager`
--

INSERT INTO `t_manager` (`man_Id`, `man_Password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `t_reserve`
--

CREATE TABLE IF NOT EXISTS `t_reserve` (
  `reserve_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_RoomId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_UserId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_Price` float DEFAULT NULL,
  `reserve_Total` float DEFAULT NULL,
  `reserve_StartTime` datetime DEFAULT NULL,
  `reserve_OverTime` datetime DEFAULT NULL,
  `reserve_Status` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_needchk` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_HotelId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_Quantity` int(11) DEFAULT NULL,
  `reserve_People` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 转存表中的数据 `t_reserve`
--

INSERT INTO `t_reserve` (`reserve_Id`, `reserve_RoomId`, `reserve_UserId`, `reserve_Price`, `reserve_Total`, `reserve_StartTime`, `reserve_OverTime`, `reserve_Status`, `reserve_needchk`, `reserve_HotelId`, `reserve_Quantity`, `reserve_People`) VALUES
('R001', 'N001', 'smilethat', 300, 600, '2013-09-09 17:32:24', '2013-09-12 09:24:12', '预定', '需要审查', 'A001', 1, 20),
('R002', 'N002', 'smilethat', 323, 9367, '2013-09-11 05:22:17', '2013-09-30 05:41:25', '预定', '拒绝', 'A001', 1, 20),
('R007', 'N003', 'smilethat', 566, 566, '2012-02-25 00:00:00', '2012-02-29 00:00:00', '预定', '需要审查', 'A001', 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `t_room`
--

CREATE TABLE IF NOT EXISTS `t_room` (
  `room_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `room_Status` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `room_Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `room_Available` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `room_Price` float DEFAULT NULL,
  `room_DiscoutPrice` float DEFAULT NULL,
  `room_hotelId` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 转存表中的数据 `t_room`
--

INSERT INTO `t_room` (`room_Id`, `room_Status`, `room_Name`, `room_Available`, `room_Price`, `room_DiscoutPrice`, `room_hotelId`) VALUES
('N001', '预定', '高等间', 'N', 300, 200, 'A001'),
('N002', '预定', '经济间', 'N', 323, 211, 'A001'),
('N003', '预定', '高等间', 'N', 566, 245, 'A001'),
('N004', '预定', '桃园套房', 'N', 3000, 250, 'A001'),
('N005', '预定', '总统套房', 'N', 5000, 4000, 'A001'),
('A006', '预定', '桃园套房', 'Y', 300, 230, 'A001'),
('A008', '预定', '高等间', 'Y', 1000, 630, 'A001'),
('A009', '预定', '总统套房', 'Y', 4000, 2630, 'A001'),
('B001', '预定', '经济间', 'Y', 300, 230, 'A001');

-- --------------------------------------------------------

--
-- 表的结构 `t_user`
--

CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_pwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_sex` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `user_mobile` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_certitype` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_certinum` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  `user_point` int(11) DEFAULT NULL,
  `user_money` int(11) DEFAULT NULL,
  `user_birthday` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 转存表中的数据 `t_user`
--

INSERT INTO `t_user` (`user_id`, `user_pwd`, `user_name`, `user_age`, `user_sex`, `user_mobile`, `user_email`, `user_certitype`, `user_certinum`, `user_address`, `user_level`, `user_point`, `user_money`, `user_birthday`) VALUES
('smilethat', '123456', '林峰', 35, '男', '22844354', '3290@qq.com', '身份证', '5445645645654645', '福建福州', 0, 0, NULL, '2009-11-12'),
('admin', 'admin', 'admin', 0, '', '', '', '', '', '', 0, 0, NULL, ''),
('likeyou', '123456', '李天白', 18, '男', '18227691573', 'zhoudadd@gmail.com', '省份证', '734568435673568', '四川成都双流', 0, 0, NULL, '02/11/2012'),
('mrzhou', '123456', '周亮', 18, '男', '13409808888', 'zhadhad@qq.com', '良民证', '3465766767', '四川成都双流', 0, 0, NULL, '02/16/12'),
('', '', '', 18, '男', '', '', '', '', '', 0, 0, NULL, '02/16/12');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
