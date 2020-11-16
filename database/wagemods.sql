-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1:3306
-- Létrehozás ideje: 2020. Nov 16. 15:59
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
-- Adatbázis: `wagemods`
--
CREATE DATABASE IF NOT EXISTS `wagemods` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `wagemods`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `wagemods`
--

DROP TABLE IF EXISTS `wagemods`;
CREATE TABLE IF NOT EXISTS `wagemods` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `nyugdij` varchar(255) NOT NULL,
  `tb` varchar(255) NOT NULL,
  `szja` varchar(255) NOT NULL,
  `mpj` varchar(255) NOT NULL,
  `nyugdijtakarek` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `wagemods`
--

INSERT INTO `wagemods` (`id`, `name`, `nyugdij`, `tb`, `szja`, `mpj`, `nyugdijtakarek`) VALUES
(1, 'shopOwner', '10', '7', '15', '1.5', '24'),
(2, 'Dolgozo', '10', '7', '15', '1.5', '20');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
