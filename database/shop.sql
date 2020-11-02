-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1:3306
-- Létrehozás ideje: 2020. Nov 02. 14:25
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
-- Adatbázis: `shop`
--
CREATE DATABASE IF NOT EXISTS `shop` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `shop`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `hnumber` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `customer`
--

INSERT INTO `customer` (`id`, `name`, `phone`, `email`, `city`, `street`, `hnumber`) VALUES
(1, 'Customer1', '+362222222', 'customeremail@customer.hu', 'db', 'street', '7');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `laptops`
--

DROP TABLE IF EXISTS `laptops`;
CREATE TABLE IF NOT EXISTS `laptops` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `vendor` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `specid` int(255) NOT NULL,
  `amount` int(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `availability` int(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `specid` (`specid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `laptops`
--

INSERT INTO `laptops` (`id`, `vendor`, `name`, `specid`, `amount`, `description`, `availability`) VALUES
(1, 'Acer', 'Aspire', 1, 1, 'Its good', 1),
(2, 'ASUS', 'TUF FX5050DT', 2, 3, 'Tapasztald meg a simább és magával ragadóbb játékot az új ASUS TUF Gaming FX505 NVIDIA változattal.', 1),
(3, 'Acer', 'Aspire', 3, 3, 'Best budget laptop for this price range.', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `customerid` int(255) NOT NULL,
  `laptopid` int(255) NOT NULL,
  `paymentmethod` varchar(255) NOT NULL,
  `quantity` varchar(255) NOT NULL,
  `finalprice` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer` (`customerid`),
  UNIQUE KEY `laptop` (`laptopid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `orders`
--

INSERT INTO `orders` (`id`, `customerid`, `laptopid`, `paymentmethod`, `quantity`, `finalprice`, `date`) VALUES
(1, 1, 1, 'cash', '1', '500', '20200908');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shop`
--

DROP TABLE IF EXISTS `shop`;
CREATE TABLE IF NOT EXISTS `shop` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `shop`
--

INSERT INTO `shop` (`id`, `address`, `email`, `phone`) VALUES
(1, 'thisisanaddressfortheshop', 'shopemail@shopemail.com', '+36444444'),
(2, 'thisisanaddressfortheshop', 'shopemail@shopemail.com', '+36444444');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `specification`
--

DROP TABLE IF EXISTS `specification`;
CREATE TABLE IF NOT EXISTS `specification` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `cpu` varchar(255) NOT NULL,
  `gpu` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `storage` varchar(255) NOT NULL,
  `screen` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `specification`
--

INSERT INTO `specification` (`id`, `cpu`, `gpu`, `ram`, `storage`, `screen`, `price`) VALUES
(1, 'ryzen 7 4700', 'amd ry7500', '16gb', '2tb ssd', '17 IPS', '500'),
(2, 'AMD Ryzen 3550H', 'nVidia GTX1650', '8GB DDR4', '256GB SSD', '15,6 IPS', '800'),
(4, 'Intel core i5 7200u', 'nVidia 940MX', '4gb DDR4', '750GB HDD', '15,6 TN', '500');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
