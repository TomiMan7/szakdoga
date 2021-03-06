-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1:3306
-- Létrehozás ideje: 2020. Nov 18. 12:48
-- Kiszolgáló verziója: 5.7.26
-- PHP verzió: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `employees`
--
CREATE DATABASE IF NOT EXISTS `employees` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `employees`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `post` varchar(255) NOT NULL,
  `wage` int(255) NOT NULL,
  `whours` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `employees`
--

INSERT INTO `employees` (`id`, `name`, `phone`, `email`, `post`, `wage`, `whours`) VALUES
(1, 'shopOwner', '+36111111', 'email@email.com', 'manager', 999, 8),
(2, 'Dolgozo', '+36111112', 'email@email2.com', 'salesman', 2, 8),
(3, 'Raktaros', '+36204566028', 'raktaros@raktaros.hu', 'raktáros', 900, 8);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `leaves`
--

DROP TABLE IF EXISTS `leaves`;
CREATE TABLE IF NOT EXISTS `leaves` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `startyear` varchar(255) NOT NULL,
  `startmonth` varchar(255) NOT NULL,
  `startday` varchar(255) NOT NULL,
  `endyear` varchar(255) NOT NULL,
  `endmonth` varchar(255) NOT NULL,
  `endday` varchar(255) NOT NULL,
  `sickpay` int(255) NOT NULL,
  `workerid` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `leaves`
--

INSERT INTO `leaves` (`id`, `startyear`, `startmonth`, `startday`, `endyear`, `endmonth`, `endday`, `sickpay`, `workerid`) VALUES
(1, '2020', '11', '3', '2020', '11', '6', 0, 1),
(2, '2020', '11', '2', '2020', '11', '7', 0, 2),
(3, '2020', '11', '10', '2020', '11', '12', 0, 1),
(4, '2020', '11', '19', '2020', '11', '23', 1, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `permissions`
--

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `salesman` int(255) NOT NULL,
  `accountant` int(255) NOT NULL,
  `manager` int(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `password` (`password`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `permissions`
--

INSERT INTO `permissions` (`id`, `name`, `salesman`, `accountant`, `manager`, `password`) VALUES
(1, 'shopOwner', 1, 1, 1, 'proba'),
(2, 'Dolgozo', 1, 0, 0, 'proba2'),
(3, 'Accountant', 0, 1, 0, 'proba3');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `whours`
--

DROP TABLE IF EXISTS `whours`;
CREATE TABLE IF NOT EXISTS `whours` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  `month` varchar(255) NOT NULL,
  `day` varchar(255) NOT NULL,
  `hour` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `whours`
--

INSERT INTO `whours` (`id`, `name`, `year`, `month`, `day`, `hour`) VALUES
(1, 'Dolgozo', '2020', '11', '1', '8'),
(2, 'shopOwner', '2020', '11', '1', '8'),
(3, 'Dolgozo', '2020', '11', '2', '8'),
(4, 'shopOwner', '2020', '11', '17', '8'),
(5, 'Raktaros', '2020', '11', '16', '8'),
(6, 'Raktaros', '2020', '11', '17', '8');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
