-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2020 at 09:50 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel_2017102078`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_travel_2017102078`
--

CREATE TABLE `tbl_travel_2017102078` (
  `kd_travel` int(11) NOT NULL,
  `nm_kendaraan` varchar(50) NOT NULL DEFAULT '',
  `keterangan` text NOT NULL,
  `harga` double NOT NULL DEFAULT '0',
  `jumlah_travel` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_travel_2017102078`
--

INSERT INTO `tbl_travel_2017102078` (`kd_travel`, `nm_kendaraan`, `keterangan`, `harga`, `jumlah_travel`) VALUES
(1, 'Bus Mini Travel', 'bus travel mini dengan kapasistas 10 penumpang', 200000, -4),
(2, 'Isuzu Elf Minibus', 'Mobil jenis daya tampung untu penumpangnya bisa mencapai hingga 16 orang', 150000, -3),
(3, 'Toyota Hiace', 'Mobil jenis ini dapat menampung penumpang sebanyak 12 orang', 250000, 7),
(4, 'Nissan Evalia', 'Mobil jenis ini mempunyai pintu geser, untuk kursi yang ada di dalam mobil ini yaitu lebih tebal', 500000, -2),
(5, 'Suzuki APV', 'Kapasitas yang terdapat dalam mobil ini yaitu mulai bisa digunakan untuk menampung sekitar 8 orang penumpang', 450000, 10),
(6, 'Daihatsu Luxio', 'Mobil jenis ini juga menggunakan teknologi canggih yaitu dengan menggunakan pintu geser', 400000, 15);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_travel_kembali_2017102078`
--

CREATE TABLE `tbl_travel_kembali_2017102078` (
  `id_kembali` int(11) NOT NULL,
  `no_sewa` varchar(15) NOT NULL DEFAULT '',
  `tgl_kembali` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_travel_kembali_2017102078`
--

INSERT INTO `tbl_travel_kembali_2017102078` (`id_kembali`, `no_sewa`, `tgl_kembali`) VALUES
(1, '1', '2020-07-25'),
(2, '2', '2020-07-25');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_travel_sewa_2017102078`
--

CREATE TABLE `tbl_travel_sewa_2017102078` (
  `id_sewa` int(11) NOT NULL,
  `no_sewa` varchar(15) NOT NULL DEFAULT '',
  `tgl_sewa` date NOT NULL,
  `nm_penyewa` varchar(40) NOT NULL DEFAULT '',
  `kd_travel` int(11) NOT NULL DEFAULT '0',
  `jumlah_sewa` int(11) NOT NULL DEFAULT '0',
  `total_bayar` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_travel_sewa_2017102078`
--

INSERT INTO `tbl_travel_sewa_2017102078` (`id_sewa`, `no_sewa`, `tgl_sewa`, `nm_penyewa`, `kd_travel`, `jumlah_sewa`, `total_bayar`) VALUES
(2, '1', '2020-07-24', 'anwar', 1, 2, 400000),
(3, '2', '2020-07-24', 'khaerul', 2, 2, 300000),
(4, '3', '2020-07-25', 'gerry', 4, 3, 1500000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` int(11) NOT NULL,
  `nm_user` varchar(40) NOT NULL DEFAULT '',
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `nm_user`, `username`, `password`) VALUES
(1, 'Khaerul Anwar', 'anwar', 'anwar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_travel_2017102078`
--
ALTER TABLE `tbl_travel_2017102078`
  ADD PRIMARY KEY (`kd_travel`);

--
-- Indexes for table `tbl_travel_kembali_2017102078`
--
ALTER TABLE `tbl_travel_kembali_2017102078`
  ADD PRIMARY KEY (`id_kembali`);

--
-- Indexes for table `tbl_travel_sewa_2017102078`
--
ALTER TABLE `tbl_travel_sewa_2017102078`
  ADD PRIMARY KEY (`id_sewa`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_travel_kembali_2017102078`
--
ALTER TABLE `tbl_travel_kembali_2017102078`
  MODIFY `id_kembali` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_travel_sewa_2017102078`
--
ALTER TABLE `tbl_travel_sewa_2017102078`
  MODIFY `id_sewa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
