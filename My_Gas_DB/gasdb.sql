-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 22 Ιουν 2023 στις 22:41:10
-- Έκδοση διακομιστή: 10.4.25-MariaDB
-- Έκδοση PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `gasdb`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `requests`
--

CREATE TABLE `requests` (
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `subject` varchar(20) NOT NULL,
  `message` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `requests`
--

INSERT INTO `requests` (`name`, `phone`, `department`, `email`, `subject`, `message`) VALUES
('matzounis', '2106435957', 'Τμήμα 1', 'giorgis@gmail.com', 'egw', 'egwq'),
('matzounis', '2106435957', 'Τμήμα 3', 'asddaw@gmail.com', 'egw', 'asdasda'),
('matzounis', '2106435957', 'Τμήμα 3', 'asddaw@gmail.com', 'egw', 'asdasda'),
('Mantzounis', '6945562738', 'Τμήμα 4', 'mantzounis.giorgos@g', 'thelw na parw', 'programma programma '),
('Mantzounis', '2106435957', 'Τμήμα 3', 'mantzounis.giorgos@g', 'thelw na parw', 'ασδασδασδαδ'),
('Mantzounis', '6945562738', 'Τμήμα 1', 'mantzounis.giorgos@g', 'thelw na parw', ';ςε;ςε;');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `subscribers`
--

CREATE TABLE `subscribers` (
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `subscribers`
--

INSERT INTO `subscribers` (`username`, `name`, `email`) VALUES
('123', '123', 'asddaw@gmail.com'),
('ασδ', 'ασδασ', 'asddaw@gmail.com'),
('123', 'matzounis', 'asddaw@gmail.com'),
('123', 'matzounis', 'asddaw@gmail.com'),
('123', 'matzounis', 'asddaw@gmail.com'),
('123', '213', 'mantzounis.giorgos@g'),
('123', '123', 'adasdfasasd@gmail.co'),
('asdas', 'asdasdasdasdas', 'adasdfasasd@gmail.co'),
('mantzounis.giorgos@g', '123123', '123@gmail.com'),
('123', '213', 'mantzounis.giorgos@g'),
('123', '123', 'mantzounis.giorgos@g'),
('Georgios', 'Mantzounis', 'mantzounis.giorgos@g'),
('Georgios', 'Mantzounis', 'mantzounis.giorgos@g');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
