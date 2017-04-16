-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2017 at 08:21 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `house_renting_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `barisal`
--

CREATE TABLE `barisal` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barisal`
--

INSERT INTO `barisal` (`Division`) VALUES
('Barisal');

-- --------------------------------------------------------

--
-- Table structure for table `chittagong`
--

CREATE TABLE `chittagong` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chittagong`
--

INSERT INTO `chittagong` (`Division`) VALUES
('Chittagong');

-- --------------------------------------------------------

--
-- Table structure for table `dhaka`
--

CREATE TABLE `dhaka` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dhaka`
--

INSERT INTO `dhaka` (`Division`) VALUES
('Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `Image_ID` int(11) NOT NULL,
  `Division` varchar(255) NOT NULL,
  `TEN` varchar(255) NOT NULL,
  `URL` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`Image_ID`, `Division`, `TEN`, `URL`) VALUES
(1, 'Khulna', 'Niloy Mansion', 'http://192.168.0.103/uploads/Niloy Mansion.jpg'),
(2, 'Dhaka', 'Mifta Mansion', 'http://192.168.0.103/uploads/Mifta Mansion.jpg'),
(3, 'Rajshahi', 'Mahbub Mansion', 'http://192.168.0.103/uploads/Mahbub Mansion.jpg'),
(4, 'Chittagong', 'Momotaz Mansion', 'http://192.168.0.103/uploads/Momotaz Mansion.jpg'),
(5, 'Rangpur', 'Nahar Mansion', 'http://192.168.0.103/uploads/Nahar Mansion.jpg'),
(6, 'Sylhet', 'Rahman Mansion', 'http://192.168.0.103/uploads/Rahman Mansion.jpg'),
(7, 'Barisal', 'Arifur Mansion', 'http://192.168.0.103/uploads/Arifur Mansion.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `khulna`
--

CREATE TABLE `khulna` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khulna`
--

INSERT INTO `khulna` (`Division`) VALUES
('Khulna');

-- --------------------------------------------------------

--
-- Table structure for table `rajshahi`
--

CREATE TABLE `rajshahi` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rajshahi`
--

INSERT INTO `rajshahi` (`Division`) VALUES
('Rajshahi');

-- --------------------------------------------------------

--
-- Table structure for table `rangpur`
--

CREATE TABLE `rangpur` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rangpur`
--

INSERT INTO `rangpur` (`Division`) VALUES
('Rangpur');

-- --------------------------------------------------------

--
-- Table structure for table `sylhet`
--

CREATE TABLE `sylhet` (
  `Division` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sylhet`
--

INSERT INTO `sylhet` (`Division`) VALUES
('Sylhet');

-- --------------------------------------------------------

--
-- Table structure for table `uploader_informations`
--

CREATE TABLE `uploader_informations` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Division` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Description` text NOT NULL,
  `Price` int(16) NOT NULL,
  `Contact` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uploader_informations`
--

INSERT INTO `uploader_informations` (`ID`, `Name`, `Division`, `Address`, `Description`, `Price`, `Contact`) VALUES
(1, 'Niloy', 'Khulna', '89, Gagan Babu Road', 'I Have A House For Rent With Two Bedrooms And One Bathroom', 10000, 1521307958),
(2, 'Mifta', 'Dhaka', '33, Banani Model Town', 'I Have A House For Rent With Two Bedrooms And Two Bathrooms', 15000, 1612004723),
(3, 'Mahbub', 'Rajshahi', '33, Rajshahi Main Road', 'I Have A House For Rent With Two Bedrooms And One Bathroom', 12000, 1711131573),
(4, 'Momotaz', 'Chittagong', '34 , Chittagong Main Road', 'I Have A House For Rent With Two Bedrooms And One Bathroom', 11000, 1912842354),
(5, 'Nahar', 'Rangpur', '36,Rangpur Main Road', 'I Have A House For Rent With Two Bedrooms And One Bathroom', 10000, 1912842341),
(6, 'Rahman', 'Sylhet', '40,Sylhet Main Road', 'I Have A House For Rent With Two Bedrooms And Two Bathrooms', 14000, 1927409858),
(7, 'Arifur', 'Barisal', '44,Barisal Main Road', 'I Have A House For Rent With Three Bedrooms And Two Bathrooms', 17000, 1714073794);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barisal`
--
ALTER TABLE `barisal`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `chittagong`
--
ALTER TABLE `chittagong`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `dhaka`
--
ALTER TABLE `dhaka`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`Image_ID`),
  ADD KEY `Division` (`Division`);

--
-- Indexes for table `khulna`
--
ALTER TABLE `khulna`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `rajshahi`
--
ALTER TABLE `rajshahi`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `rangpur`
--
ALTER TABLE `rangpur`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `sylhet`
--
ALTER TABLE `sylhet`
  ADD PRIMARY KEY (`Division`);

--
-- Indexes for table `uploader_informations`
--
ALTER TABLE `uploader_informations`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Division` (`Division`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `Image_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `uploader_informations`
--
ALTER TABLE `uploader_informations`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
