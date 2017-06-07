-- phpMyAdmin SQL Dump
-- version 4.6.4deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 07, 2017 at 11:24 PM
-- Server version: 5.7.18-0ubuntu0.16.10.1
-- PHP Version: 7.0.18-0ubuntu0.16.10.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dmr`
--

-- --------------------------------------------------------

--
-- Table structure for table `all_users`
--

CREATE TABLE `all_users` (
  `meter_id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_no` int(10) NOT NULL,
  `address` varchar(150) NOT NULL,
  `area_office` varchar(50) NOT NULL,
  `transformer_id` int(10) NOT NULL,
  `category` varchar(25) DEFAULT 'domestic'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `all_users`
--

INSERT INTO `all_users` (`meter_id`, `first_name`, `last_name`, `nic`, `email`, `phone_no`, `address`, `area_office`, `transformer_id`, `category`) VALUES
(1001, 'Sudesh', 'Madushanka', '922252020V', 'sudeshm40@gmail.com', 702122494, 'matara', 'Weligama', 1234, 'domestic'),
(1002, 'Hasiru ', 'Kavishan', '932554322V', 'kgs.madu99@gmail.com', 711787142, 'Matara', 'Weligama', 1234, 'domestic'),
(123456789, 'Sudesh', 'Madushanka', '922252025V', 'madushankaks40@gmail.com', 702122494, '242/A Lindakoratuwa Epitamulla Kamburugamuwa Matara', 'Matara', 123, 'domestic'),
(1231229112, 'Dilini', 'Sharmali', '921223243V', 'madushankaks40@gmail.com', 711787142, 'Kandy', 'Kandy', 13, 'domestic'),
(1231229123, 'Kasun', 'Madumadawa', '921231243V', 'madushankaks40@gmail.com', 711787142, 'Matara', 'Matara', 122, 'domestic'),
(1234109123, 'Sudesh', 'Madushanka', '123123123V', 'sudeshm40@gmail.com', 702122494, 'Kandy', 'Kandy', 13, 'domestic'),
(1234109876, 'Sudesh', 'Madushanka', '123123123V', 'sudeshm40@gmail.com', 702122494, 'Kandy', 'Kandy', 12, 'domestic'),
(1234121222, 'Kasun', 'Madushanka', '123123123V', 'madushankaks40@gmail.com', 702122494, 'Matara', 'Matara', 122, 'domestic'),
(1234121233, 'Kasun', 'Madushanka', '921221243V', 'madushankaks40@gmail.com', 712122494, 'Matara', 'Matara', 122, 'domestic'),
(1234123412, 'Chamara', 'Munasingha', '123123123V', 'chamara@gmail.com', 702122494, 'Kandy', 'Kandy', 14, 'domestic'),
(1234123413, 'Dinesh', 'Munasingha', '931232343V', 'dinesh@gmail.com', 712893518, 'Kandy', 'Kandy', 14, 'domestic'),
(1234129123, 'Sudesh', 'Madushanka', '921232343V', 'sudeshm40@gmail.com', 712893518, 'Kandy', 'Kandy', 12, 'domestic'),
(1234567890, 'Hasiru ', 'Kavishan', '933283780V', 'sudeshm40@gmail.com', 712893518, 'Matara Sri Lanka', 'Matara', 123, 'domestic'),
(1234567891, 'Chishan', 'Hettiarachchi', '123123123V', 'chishan.hettiarachchi@gmail.com', 702122494, 'Matara', 'Weligama', 1234, 'domestic'),
(1234567899, 'Akila', 'Nilakshi', '932554925V', 'kgs.madu99@gmail.com', 711787142, ' Tangalla Matara', 'Matara', 123, 'domestic');

-- --------------------------------------------------------

--
-- Table structure for table `dmr_bill`
--

CREATE TABLE `dmr_bill` (
  `bill_id` int(11) NOT NULL,
  `last_bill` double NOT NULL,
  `current_bill` double NOT NULL,
  `meter_id` int(11) NOT NULL,
  `redBill_status` varchar(10) NOT NULL DEFAULT 'no'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmr_bill`
--

INSERT INTO `dmr_bill` (`bill_id`, `last_bill`, `current_bill`, `meter_id`, `redBill_status`) VALUES
(1, 8201.4, 3467.88, 1001, 'no'),
(2, 2476.81, 675.9, 1002, 'no'),
(3, 4588.2, 307.64, 1003, 'no'),
(4, 3397.73, 303.27, 1004, 'no'),
(5, 1965.48, 304.24, 1005, 'no'),
(6, 5186.74, 2655.18, 1006, 'no'),
(7, 1143.88, 306.18, 1007, 'no'),
(8, 3724.01, 1901.55, 1008, 'no'),
(9, 1262.24, 230.02, 1009, 'no'),
(10, 3868.6, 3083.9, 1010, 'no'),
(11, 1038.7, 750.9, 1011, 'no');

-- --------------------------------------------------------

--
-- Table structure for table `dmr_meter`
--

CREATE TABLE `dmr_meter` (
  `meterId` int(6) NOT NULL,
  `userId` varchar(15) NOT NULL,
  `requestDate` datetime NOT NULL,
  `IssueDate` datetime NOT NULL,
  `transformerID` int(11) NOT NULL,
  `category` varchar(30) NOT NULL DEFAULT 'domestic'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmr_meter`
--

INSERT INTO `dmr_meter` (`meterId`, `userId`, `requestDate`, `IssueDate`, `transformerID`, `category`) VALUES
(1001, '931005289V', '2017-04-12 00:08:22', '2017-04-28 21:53:34', 1, 'hotel'),
(1002, '971234567V', '2017-04-11 23:36:46', '2017-04-28 21:55:08', 2, 'religious'),
(1003, '931710621V', '2017-04-11 23:33:42', '2017-05-16 11:05:59', 5, 'domestic'),
(1004, '973040014v', '2017-04-14 12:53:08', '2017-05-16 11:07:44', 6, 'domestic'),
(1005, '938164401V', '2017-04-26 09:11:08', '2017-05-16 11:08:41', 7, 'domestic'),
(1006, '922252025V', '2017-05-27 00:08:22', '2017-04-28 21:53:34', 3, 'hotel'),
(1007, '922252026V', '2017-05-27 00:08:22', '2017-04-28 21:53:34', 8, 'domestic'),
(1008, '922252027V', '2017-05-27 00:08:22', '2017-04-28 21:53:34', 9, 'domestic'),
(1009, '922252028V', '2017-05-27 00:08:22', '2017-04-28 21:53:34', 4, 'religious'),
(1010, '922252029V', '2017-05-27 00:08:22', '2017-04-28 21:53:34', 10, 'domestic'),
(1011, '922252030V', '2017-05-27 00:08:22', '2017-04-28 21:53:34', 11, 'domestic');

-- --------------------------------------------------------

--
-- Table structure for table `dmr_readings`
--

CREATE TABLE `dmr_readings` (
  `readingId` int(11) NOT NULL,
  `readings` double DEFAULT '0',
  `current_units` double DEFAULT '0',
  `meterId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmr_readings`
--

INSERT INTO `dmr_readings` (`readingId`, `readings`, `current_units`, `meterId`) VALUES
(1, 10023, 0, 1001),
(2, 122, 0, 1002),
(3, 11123, 0, 1003),
(4, 1234, 0, 1004),
(5, 100023, 0, 1005),
(6, 100234, 0, 1006),
(7, 0, 0, 1007),
(8, 0, 0, 1008),
(9, 12345, 0, 1009),
(10, 1235, 0, 1010),
(11, 0, 0, 1011);

-- --------------------------------------------------------

--
-- Table structure for table `dmr_request`
--

CREATE TABLE `dmr_request` (
  `requestId` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `national_id` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_number` int(10) NOT NULL,
  `ceb_account` int(10) NOT NULL,
  `area_office` varchar(30) NOT NULL,
  `request_dateTime` datetime NOT NULL,
  `request_status` varchar(10) NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dmr_user`
--

CREATE TABLE `dmr_user` (
  `username` varchar(15) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobileNumber` int(10) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `meterId` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmr_user`
--

INSERT INTO `dmr_user` (`username`, `firstname`, `lastname`, `password`, `email`, `mobileNumber`, `address`, `meterId`) VALUES
('931005289V', 'Isuru', 'Munasinghe', '030167e8ff4d2c1210b1baecd6515752d914b4b3f7e3ee49c215bd0f5e9fd211', 'isuru.methsiri@yahoo.com', 759977856, '100,Peradeniya road,Kandy', 1001),
('934508119V', 'Hasiru', 'Kavishan', '35c94ae88efd354452d214c1a18946e87695650c6ef1c84cad79301e19a968f9', 'hasirukavishan@gmail.com', 715956528, '10, main street, Middeniya', 1002),
('971234567V', 'Thlina', 'Munasinghe', '644494f5cdc3d805e720f28a3d9f4a6df063c72f8117d4002744863158046e22', 'thilinaAravinda@gmail.com', 712345678, 'Welikala Hela osu,Danthure road,Pilimatalawa,Kandy 20450', 1003),
('admin', 'Chamara ', 'Munasinghe', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NULL, NULL, 0),
('931710621V', 'Chamara', 'Munasinghe', '13d426a0b5420989d53fa5eb0630dd86bdb93d657d5ad6fd47ee110e343044ac', 'chamaramewan1993@gmail.com', 755204225, '25,Danthure road,Pilimatalawa', 1004),
('973040014v', 'Aravinda', 'Dananjaya', 'c28bd1d484f14fe012a7cbc0d9aed98bd12b9d70e122f3af1b087856ee60b45d', 'aravindadananjaya1997@gmail.com', 715956528, 'No,25 Danthure road,Pilimathalawa', 1005),
('938164401V', 'Akila', 'nilakshi', '29fa736aa17f917d3186714e44d541ea921b25b3ed60d1c0e2a71a025290fa91', 'madushankaks40@gmail.com', 715956528, 'tangalle', 1012),
('922252025V', 'sudesh', 'madushanka', '39f9d3cb8e1a42d3ba4cfae6cbe14c9e457041a0bf8fe4213e9c4b449d5af0c0', 'sudeshm40@gmail.com', 702122494, 'Matara', 1006),
('922252026V', 'sudesh', 'madushanka', '39f9d3cb8e1a42d3ba4cfae6cbe14c9e457041a0bf8fe4213e9c4b449d5af0c0', 'sudeshm40@gmail.com', 702122494, 'Matara', 1007),
('922252027V', 'sudesh', 'madushanka', '39f9d3cb8e1a42d3ba4cfae6cbe14c9e457041a0bf8fe4213e9c4b449d5af0c0', 'sudeshm40@gmail.com', 702122494, 'Matara', 1008),
('922252028V', 'sudesh', 'madushanka', '39f9d3cb8e1a42d3ba4cfae6cbe14c9e457041a0bf8fe4213e9c4b449d5af0c0', 'sudeshm40@gmail.com', 702122494, 'Matara', 1009),
('922252029V', 'sudesh', 'madushanka', '39f9d3cb8e1a42d3ba4cfae6cbe14c9e457041a0bf8fe4213e9c4b449d5af0c0', 'sudeshm40@gmail.com', 702122494, 'Matara', 1010),
('922252030V', 'sudesh', 'madushanka', '39f9d3cb8e1a42d3ba4cfae6cbe14c9e457041a0bf8fe4213e9c4b449d5af0c0', 'sudeshm40@gmail.com', 702122494, 'Matara', 1011);

-- --------------------------------------------------------

--
-- Table structure for table `domestic1`
--

CREATE TABLE `domestic1` (
  `consumption` double NOT NULL,
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `domestic1`
--

INSERT INTO `domestic1` (`consumption`, `energy_charge`, `fixed_charge`) VALUES
(30, 2.5, 30),
(60, 4.85, 60);

-- --------------------------------------------------------

--
-- Table structure for table `domestic2`
--

CREATE TABLE `domestic2` (
  `consumption` double NOT NULL,
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `domestic2`
--

INSERT INTO `domestic2` (`consumption`, `energy_charge`, `fixed_charge`) VALUES
(60, 7.85, 0),
(90, 10, 90),
(120, 27.75, 480),
(180, 32, 480),
(181, 45, 540);

-- --------------------------------------------------------

--
-- Table structure for table `general1`
--

CREATE TABLE `general1` (
  `consumption` double NOT NULL,
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `general1`
--

INSERT INTO `general1` (`consumption`, `energy_charge`, `fixed_charge`) VALUES
(300, 18.3, 0),
(301, 22.85, 240);

-- --------------------------------------------------------

--
-- Table structure for table `government1`
--

CREATE TABLE `government1` (
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL,
  `dimand_charge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `government1`
--

INSERT INTO `government1` (`energy_charge`, `fixed_charge`, `dimand_charge`) VALUES
(14.65, 600, 0);

-- --------------------------------------------------------

--
-- Table structure for table `government2`
--

CREATE TABLE `government2` (
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL,
  `dimand_charge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `government2`
--

INSERT INTO `government2` (`energy_charge`, `fixed_charge`, `dimand_charge`) VALUES
(14.55, 3000, 1100);

-- --------------------------------------------------------

--
-- Table structure for table `government3`
--

CREATE TABLE `government3` (
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL,
  `dimand_charge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `government3`
--

INSERT INTO `government3` (`energy_charge`, `fixed_charge`, `dimand_charge`) VALUES
(14.35, 3000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `hotel1`
--

CREATE TABLE `hotel1` (
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL,
  `dimand_charge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotel1`
--

INSERT INTO `hotel1` (`energy_charge`, `fixed_charge`, `dimand_charge`) VALUES
(21.5, 600, 0);

-- --------------------------------------------------------

--
-- Table structure for table `industrial1`
--

CREATE TABLE `industrial1` (
  `consumption` double NOT NULL,
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `industrial1`
--

INSERT INTO `industrial1` (`consumption`, `energy_charge`, `fixed_charge`) VALUES
(300, 10.8, 0),
(301, 12.2, 600);

-- --------------------------------------------------------

--
-- Table structure for table `logging_table`
--

CREATE TABLE `logging_table` (
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logging_table`
--

INSERT INTO `logging_table` (`username`, `email`, `password`) VALUES
('admin', '', 'admin'),
('chamara', 'chamaramewan1993@gmail.com', '1234'),
('tempuser', 'chamaramewan1993@gmail.com', 'tempuser');

-- --------------------------------------------------------

--
-- Table structure for table `religious`
--

CREATE TABLE `religious` (
  `consumption` double NOT NULL,
  `energy_charge` double NOT NULL,
  `fixed_charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `religious`
--

INSERT INTO `religious` (`consumption`, `energy_charge`, `fixed_charge`) VALUES
(30, 1.9, 30),
(90, 2.8, 60),
(120, 6.75, 180),
(180, 7.5, 180),
(181, 9.4, 240);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`username`, `password`) VALUES
('chamara', '123'),
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `transformers`
--

CREATE TABLE `transformers` (
  `transformerId` int(11) NOT NULL,
  `area` varchar(30) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transformers`
--

INSERT INTO `transformers` (`transformerId`, `area`, `location`) VALUES
(1, 'Matara', 'Matara'),
(2, 'Matara', 'Hiththatiya'),
(3, 'Matara', 'Polhena'),
(4, 'Weligama', 'Kamburugamuwa'),
(5, 'Weligama', 'weligama'),
(6, 'Weligama', 'Mirissa'),
(7, 'Kandy', 'Kandy'),
(8, 'Kandy', 'Buwalikada'),
(9, 'Kandy', 'Pilimathalawa'),
(10, 'Thangalla', 'Thangalla'),
(11, 'Thangalla', 'Town');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `all_users`
--
ALTER TABLE `all_users`
  ADD PRIMARY KEY (`meter_id`);

--
-- Indexes for table `dmr_bill`
--
ALTER TABLE `dmr_bill`
  ADD PRIMARY KEY (`bill_id`),
  ADD KEY `meter_id` (`meter_id`);

--
-- Indexes for table `dmr_meter`
--
ALTER TABLE `dmr_meter`
  ADD PRIMARY KEY (`meterId`);

--
-- Indexes for table `dmr_readings`
--
ALTER TABLE `dmr_readings`
  ADD PRIMARY KEY (`readingId`),
  ADD KEY `meterId` (`meterId`);

--
-- Indexes for table `dmr_request`
--
ALTER TABLE `dmr_request`
  ADD PRIMARY KEY (`requestId`);

--
-- Indexes for table `dmr_user`
--
ALTER TABLE `dmr_user`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `logging_table`
--
ALTER TABLE `logging_table`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `transformers`
--
ALTER TABLE `transformers`
  ADD PRIMARY KEY (`transformerId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dmr_bill`
--
ALTER TABLE `dmr_bill`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `dmr_meter`
--
ALTER TABLE `dmr_meter`
  MODIFY `meterId` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1012;
--
-- AUTO_INCREMENT for table `dmr_readings`
--
ALTER TABLE `dmr_readings`
  MODIFY `readingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `dmr_request`
--
ALTER TABLE `dmr_request`
  MODIFY `requestId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `dmr_bill`
--
ALTER TABLE `dmr_bill`
  ADD CONSTRAINT `dmr_bill_ibfk_1` FOREIGN KEY (`meter_id`) REFERENCES `dmr_meter` (`meterId`);

--
-- Constraints for table `dmr_readings`
--
ALTER TABLE `dmr_readings`
  ADD CONSTRAINT `dmr_readings_ibfk_1` FOREIGN KEY (`meterId`) REFERENCES `dmr_meter` (`meterId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
