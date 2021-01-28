-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 25, 2021 at 08:10 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.3.24

 

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

 

--
-- Database: `inventory`
--
CREATE DATABASE IF NOT EXISTS `inventory` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `inventory`;

 

-- --------------------------------------------------------

 

--
-- Table structure for table `inventory`
--

 

CREATE TABLE `inventory` (
  `product_id` int(128) NOT NULL,
  `product_name` varchar(128) NOT NULL,
  `product_price` float NOT NULL,
  `product_av` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 

--
-- Dumping data for table `inventory`
--

 

INSERT INTO `inventory` (`product_id`, `product_name`, `product_price`, `product_av`) VALUES
(1234, 'Sugar', 43.5, 200),
(1235, 'Soap', 25, 80),
(1236, 'Biscuit', 20, 64),
(7057, 'Hair Oil', 35, 150);

 

-- --------------------------------------------------------

 

--
-- Table structure for table `users`
--

 

CREATE TABLE `users` (
  `user_id` int(128) NOT NULL,
  `user_name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 

--
-- Dumping data for table `users`
--

 

INSERT INTO `users` (`user_id`, `user_name`, `password`) VALUES
(4005, 'Hrishikesh', '1'),
(4012, 'Akash Mahajan', 'akash@123'),
(4014, 'Aditya', 'gta5'),
(4017, 'Shubham', 'teke'),
(4025, 'Sanket', 'sank');

 

--
-- Indexes for dumped tables
--

 

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`product_id`);

 

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

 

--
-- AUTO_INCREMENT for dumped tables
--

 

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(128) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4026;
COMMIT;
