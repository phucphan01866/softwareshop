-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2024 at 04:30 AM
-- Server version: 8.0.38
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spring_mvc`
--

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int NOT NULL,
  `cost` decimal(9,3) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` int NOT NULL,
  `order_id` int NOT NULL,
  `software_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int NOT NULL,
  `date` date NOT NULL,
  `order_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `software`
--

CREATE TABLE `software` (
  `id` int UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(9,3) NOT NULL,
  `sale_price` decimal(9,3) DEFAULT NULL,
  `quantity` int NOT NULL,
  `category` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `software`
--

INSERT INTO `software` (`id`, `name`, `description`, `price`, `sale_price`, `quantity`, `category`, `image`) VALUES
(1, 'BKAV', 'Antivirus', 99.000, NULL, 0, 'antivirus', 's1.png'),
(2, 'Driver Booster', 'Driver', 99.000, NULL, 0, 'driver', 's2.jpg'),
(3, 'Word', 'Word', 99.000, NULL, 0, 'office', 's3.jpg'),
(4, 'Excel', 'Excel', 99.000, NULL, 0, 'office', 's4.png'),
(5, 'Power Point', 'power point', 99.000, NULL, 0, 'office', 's5.jpg'),
(6, 'Kaspersky Internet Security', 'Antivirus', 99.000, NULL, 0, 'antivirus', 's6.jpg'),
(7, 'Avast Premium Security', 'Antivirus', 99.000, NULL, 0, 'antivirus', 's7.jpg'),
(8, 'Avira Antivirus Pro', 'Antivirus', 99.000, NULL, 0, 'antivirus', 's8.png'),
(9, 'Driver Easy', 'Driver', 99.000, NULL, 0, 'driver', 's9.jpg'),
(10, 'Driver Max', 'Driver', 99.000, NULL, 0, 'driver', 's10.jpg'),
(11, 'AVG Driver Update', 'Driver', 99.000, NULL, 0, 'driver', 's11.jpg'),
(12, 'Adobe Premiere Pro', 'Video edditng', 99.000, NULL, 0, 'video', 's12.jpg'),
(13, 'Davinci Resolve Studio', 'Video edditng', 99.000, NULL, 0, 'video', 's13.jpg'),
(14, 'Filmora', 'Video edditng', 99.000, NULL, 0, 'video', 's14.jpg'),
(15, 'Power Director', 'Video edditng', 99.000, NULL, 0, 'video', 's15.jpg'),
(16, 'Norton Security', 'Antivirus', 99.000, NULL, 0, 'antivirus', 's16.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `software`
--
ALTER TABLE `software`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `software`
--
ALTER TABLE `software`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
