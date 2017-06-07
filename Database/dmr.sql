-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2017 at 08:23 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

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
-- Table structure for table `dmr_meter`
--

CREATE TABLE `dmr_meter` (
  `meterId` int(6) NOT NULL,
  `userId` varchar(15) NOT NULL,
  `requestDate` datetime NOT NULL,
  `IssueDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmr_meter`
--

INSERT INTO `dmr_meter` (`meterId`, `userId`, `requestDate`, `IssueDate`) VALUES
(1001, '931005289V', '2017-04-12 00:08:22', '2017-04-28 21:53:34'),
(1002, '971234567V', '2017-04-11 23:36:46', '2017-04-28 21:55:08');

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

--
-- Dumping data for table `dmr_request`
--

INSERT INTO `dmr_request` (`requestId`, `first_name`, `last_name`, `address`, `national_id`, `email`, `mobile_number`, `ceb_account`, `area_office`, `request_dateTime`, `request_status`) VALUES
(1, 'Chamara', 'Munasinghe', '25,Danthure road,Pilimatalawa', '931710621V', 'chamaramewan1993@gmail.com', 755204225, 1705297005, 'Peradeniya', '2017-04-11 23:33:42', 'false'),
(2, 'Thlina', 'Munasinghe', 'Welikala Hela osu,Danthure road,Pilimatalawa,Kandy 20450', '971234567V', 'thilinaAravinda@gmail.com', 712345678, 1705297123, 'Kandy', '2017-04-11 23:36:46', 'true'),
(3, 'Isuru', 'Munasinghe', '100,Peradeniya road,Kandy', '931005289V', 'isuru.methsiri@yahoo.com', 759977856, 1701234567, 'Kandy', '2017-04-12 00:08:22', 'true'),
(4, 'Aravinda', 'Dananjaya', 'No,25 Danthure road,Pilimathalawa', '973040014v', 'aravindadananjaya1997@gmail.com', 715956528, 1705297006, 'Peradeniya', '2017-04-14 12:53:08', 'false'),
(5, 'Hasiru', 'Kavishan', '10, main street, Middeniya', '934508119V', 'hasirukavishan@gmail.com', 715956528, 1705297006, 'Middeniya', '2017-04-25 06:09:15', 'true'),
(6, 'Akila', 'nilakshi', 'tangalle', '938164401V', 'johns@gmail.com', 715956528, 24516678, 'tangalle', '2017-04-26 09:11:08', 'false'),
(7, 'ruwani', 'Dananjaya', 'kandy', '938164401V', 'johns@gmail.com07', 715956528, 1234, 'tangalle', '2017-04-26 09:56:21', 'false');

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
  `address` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmr_user`
--

INSERT INTO `dmr_user` (`username`, `firstname`, `lastname`, `password`, `email`, `mobileNumber`, `address`) VALUES
('931005289V', 'Isuru', 'Munasinghe', '030167e8ff4d2c1210b1baecd6515752d914b4b3f7e3ee49c215bd0f5e9fd211', 'isuru.methsiri@yahoo.com', 759977856, '100,Peradeniya road,Kandy'),
('934508119V', 'Hasiru', 'Kavishan', '35c94ae88efd354452d214c1a18946e87695650c6ef1c84cad79301e19a968f9', 'hasirukavishan@gmail.com', 715956528, '10, main street, Middeniya'),
('971234567V', 'Thlina', 'Munasinghe', '644494f5cdc3d805e720f28a3d9f4a6df063c72f8117d4002744863158046e22', 'thilinaAravinda@gmail.com', 712345678, 'Welikala Hela osu,Danthure road,Pilimatalawa,Kandy 20450'),
('admin', 'Chamara ', 'Munasinghe', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, NULL, NULL);

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dmr_meter`
--
ALTER TABLE `dmr_meter`
  ADD PRIMARY KEY (`meterId`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dmr_meter`
--
ALTER TABLE `dmr_meter`
  MODIFY `meterId` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1003;
--
-- AUTO_INCREMENT for table `dmr_request`
--
ALTER TABLE `dmr_request`
  MODIFY `requestId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
