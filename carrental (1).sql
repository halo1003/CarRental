-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2016 at 08:37 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrental`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdName` varchar(20) NOT NULL,
  `AdPass` varchar(20) NOT NULL,
  `AdFName` varchar(20) NOT NULL,
  `AdPhone` int(11) NOT NULL,
  `AdAddress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdName`, `AdPass`, `AdFName`, `AdPhone`, `AdAddress`) VALUES
('Admin', '123456', 'Dogi', 908112233, '69 - Nguyen Thi Minh Khai - District 1');

-- --------------------------------------------------------

--
-- Table structure for table `ban`
--

CREATE TABLE `ban` (
  `CID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ban`
--

INSERT INTO `ban` (`CID`) VALUES
(18),
(16),
(3);

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `CarID` int(4) NOT NULL,
  `CarName` varchar(20) NOT NULL,
  `Discount` int(3) DEFAULT NULL,
  `CarType` varchar(10) NOT NULL,
  `Seats` int(2) NOT NULL,
  `Color` varchar(10) NOT NULL,
  `Img` varchar(50) DEFAULT NULL,
  `Introduce` varchar(100) DEFAULT NULL,
  `Price` int(50) NOT NULL,
  `Like` int(50) DEFAULT NULL,
  `Status` varchar(1) NOT NULL,
  `Dislike` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`CarID`, `CarName`, `Discount`, `CarType`, `Seats`, `Color`, `Img`, `Introduce`, `Price`, `Like`, `Status`, `Dislike`) VALUES
(7, 'Aventador', 5, 'Sport', 2, 'White', 'img/lamborghini Aventador lp700.jpg', 'Super Car, can reach 100k/h in 3 second', 1000, 69, 'A', 5),
(13, 'Chevrolet Camaro', 12, 'Sport', 2, 'Black', 'img/camaro.jpg', 'Strong Engine', 250, 5, 'A', 10),
(14, 'Chevrolet Cruze', 11, 'Family', 2, 'Red', 'img/hyundai avante.jpg', 'Luxury, beauty', 165, 8, 'A', 5),
(4, 'Ford Ranger', 10, 'Sport', 4, 'Orange', 'img/ford-ranger.png', 'Suitalbe for camping', 130, 9, 'U', 10),
(8, 'Honda Civic', 5, 'Sport', 5, 'Gray', 'img/Honda civic.jpg', 'New car', 140, 20, 'A', 12),
(12, 'Huyndai Accent', 13, 'Sport', 5, 'White', 'img/hyundai accent.jpg', 'Luxury, beauty', 170, 17, 'A', 7),
(10, 'Huyndai Avente', 10, 'Sport', 5, 'Red', 'img/hyundai avante.jpg', 'Luxury, beauty', 180, 23, 'A', 13),
(11, 'Huyndai Santafe', 15, 'Travel', 7, 'White', 'img/huyndai santafe.jpg', 'Luxury, beauty', 160, 44, 'A', 26),
(9, 'Huyndai Sonata', 10, 'Family', 5, 'White', 'img/hyundai sonata.jpg', 'Luxury, beauty', 100, 12, 'A', 16),
(5, 'Mazda 3', 10, 'Family', 5, 'Red', 'img/mazda 3.jpg', 'Luxury, beauty', 90, 46, 'A', 13),
(6, 'Mercedes benz 313', 10, 'Travel', 16, 'White', 'img/Mercedes-Benz Sprinter 313 ESP.jpg', 'Suitable for Big family to traveling', 120, 32, 'A', 9),
(2, 'Toyota Camry', 5, 'Family', 5, 'Black', 'img/toyota-camry.jpg', 'Style:Luxury, Furniture:Modern', 100, 11, 'A', 5),
(3, 'Toyota InnovaG', 5, 'Family', 7, 'White', 'img/Toyota-innovaG.jpg', 'Suitable for family to traveling', 60, 29, 'A', 22),
(1, 'Versiones y Precios', 0, 'Normal', 4, 'While', 'img/Versiones y Precios.jpg', 'Version: XLI', 200, 45, 'U', 33);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CID` int(4) NOT NULL,
  `CName` varchar(20) NOT NULL,
  `CPass` int(20) NOT NULL,
  `CFName` varchar(20) NOT NULL,
  `CPhone` int(11) NOT NULL,
  `CAddress` varchar(20) DEFAULT NULL,
  `CINumber` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CID`, `CName`, `CPass`, `CFName`, `CPhone`, `CAddress`, `CINumber`) VALUES
(5, 'daothekien', 123456, 'Dao The Kien', 1645544887, 'Hai Phong', 665231554),
(4, 'dosongtoan', 123456, 'Do Song Toan', 906123498, 'My Tho', 334578994),
(3, 'hoangly', 123456, 'Ly Thanh Hoang', 903114177, 'Tra Vinh', 335447846),
(1, 'huynhtrungnghia', 123456, 'Huynh Trung Nghia', 989524684, 'Soc Trang', 645587624),
(16, 'langtu_bat_sutu', 123456, 'Nguyen Duy Minh', 165487998, 'HCM city', 665487958),
(2, 'lythanhhuy', 123456, 'Ly Thanh Huy', 1687561830, 'Tra Vinh', 332455789),
(15, 'nguyenthanhvy', 123456, 'Nguyen Thanh Vy', 16654877, 'Hue', 665487759),
(17, 'quachkimtoan', 123456, 'Quach Kim Toan', 125448768, 'HCM city', 887459987),
(18, 'tretrau', 123456, 'Tre Trau', 115548769, 'HCM city', 846422456);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `CFName` varchar(20) NOT NULL,
  `CarName` varchar(20) NOT NULL,
  `TimeRent` datetime NOT NULL,
  `TimeReturn` datetime NOT NULL,
  `Payment` int(50) NOT NULL,
  `CID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`CFName`, `CarName`, `TimeRent`, `TimeReturn`, `Payment`, `CID`) VALUES
('Valak', 'Car of Valak', '2016-12-01 04:00:00', '2016-12-09 07:00:00', 1000000, 100),
('Lucier', 'Car of Lucifer', '2016-12-05 07:00:00', '2016-12-10 02:00:00', 2000000, 200);

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `CID` int(4) NOT NULL,
  `CarID` int(4) NOT NULL,
  `TimeRent` datetime NOT NULL,
  `RentType` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`CID`, `CarID`, `TimeRent`, `RentType`) VALUES
(4, 12, '2016-12-14 12:09:28', 'W');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdName`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`CarName`),
  ADD KEY `CarID` (`CarID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CName`),
  ADD UNIQUE KEY `CName` (`CName`),
  ADD KEY `CID` (`CID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `CarID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
