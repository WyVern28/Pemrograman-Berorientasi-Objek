-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2025 at 05:02 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siasat`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `nid` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `id_prodi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`nid`, `name`, `id_prodi`) VALUES
('01151125001', 'Hendra Priwit', 'TI067'),
('01151125002', 'Made Kanaya', 'TI067'),
('01151125003', 'Andaru Sikak', 'TI067');

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

CREATE TABLE `fakultas` (
  `id_fakultas` varchar(20) NOT NULL,
  `nama_fakultas` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `fakultas`
--

INSERT INTO `fakultas` (`id_fakultas`, `nama_fakultas`) VALUES
('F001', 'Fakultas Teknologi Informsi');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_kelas`
--

CREATE TABLE `jadwal_kelas` (
  `id_jadwal` varchar(20) NOT NULL,
  `id_kelas` varchar(20) NOT NULL,
  `id_ruangan` varchar(20) NOT NULL,
  `hari` enum('Senin','Selasa','Rabu','Kamis','Jumat','Sabtu','Minggu') NOT NULL,
  `jam_mulai` time NOT NULL,
  `jam_selesai` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `jadwal_kelas`
--

INSERT INTO `jadwal_kelas` (`id_jadwal`, `id_kelas`, `id_ruangan`, `hari`, `jam_mulai`, `jam_selesai`) VALUES
('JDWL001', 'TC001G', 'FTI465', 'Senin', '13:00:00', '16:00:00'),
('JDWL002', 'TC002D', 'FTI467', 'Rabu', '13:00:00', '16:00:00'),
('JDWL003', 'TC003C', 'FTI465', 'Senin', '13:00:00', '16:00:00'),
('JDWL004', 'TC004H', 'FTI467', 'Senin', '10:00:00', '12:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` varchar(20) NOT NULL,
  `nama_kelas` varchar(120) NOT NULL,
  `nid` varchar(20) NOT NULL,
  `id_matkul` varchar(20) NOT NULL,
  `kapasitas` int(11) NOT NULL DEFAULT 35
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`, `nid`, `id_matkul`, `kapasitas`) VALUES
('TC001G', 'PEMROGRAMAN BERORIENTASI OBJEK G', '01151125002', 'TC001', 35),
('TC002D', 'PEMROGRAMAN WEB D', '01151125001', 'TC002', 35),
('TC003C', 'STRUKTUR DATA C', '01151125002', 'TC003', 35),
('TC004H', 'DPJ H', '01151125003', 'TC001', 38);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `id_prodi` varchar(20) NOT NULL,
  `ipk` decimal(5,2) DEFAULT NULL,
  `total_sks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `name`, `id_prodi`, `ipk`, `total_sks`) VALUES
('672024001', 'Amanda Amelia', 'TI067', NULL, NULL),
('672024002', 'Junatan Krisna', 'TI067', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `master_biaya`
--

CREATE TABLE `master_biaya` (
  `id_biaya` varchar(20) NOT NULL,
  `nama_biaya` varchar(50) NOT NULL,
  `jumlah` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `master_biaya`
--

INSERT INTO `master_biaya` (`id_biaya`, `nama_biaya`, `jumlah`) VALUES
('SKS', 'Biaya Per SKS', 250000.00);

-- --------------------------------------------------------

--
-- Table structure for table `matkul`
--

CREATE TABLE `matkul` (
  `id_matkul` varchar(20) NOT NULL,
  `nama_matkul` varchar(120) NOT NULL,
  `id_prodi` varchar(20) NOT NULL,
  `sks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `matkul`
--

INSERT INTO `matkul` (`id_matkul`, `nama_matkul`, `id_prodi`, `sks`) VALUES
('TC001', 'Pemrograman Berorientasi Objek', 'TI067', 3),
('TC002', 'Pemrograman Web', 'TI067', 3),
('TC003', 'Struktur Data', 'TI067', 3);

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `id_nilai` varchar(20) NOT NULL,
  `nim` varchar(20) NOT NULL,
  `id_kelas` varchar(20) NOT NULL,
  `nilai_akhir` decimal(5,2) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `status_bayar` enum('LUNAS','BELUM') NOT NULL DEFAULT 'BELUM'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`id_nilai`, `nim`, `id_kelas`, `nilai_akhir`, `status`, `status_bayar`) VALUES
('NL001', '672024001', 'TC001G', 90.00, 1, 'LUNAS'),
('NL002', '672024001', 'TC003C', 85.00, 0, 'LUNAS'),
('NL003', '672024002', 'TC001G', 75.50, 1, 'BELUM'),
('NL004', '672024002', 'TC002D', 68.00, 0, 'BELUM');

-- --------------------------------------------------------

--
-- Table structure for table `prodi`
--

CREATE TABLE `prodi` (
  `id_prodi` varchar(20) NOT NULL,
  `nama_prodi` varchar(50) NOT NULL,
  `id_fakultas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `prodi`
--

INSERT INTO `prodi` (`id_prodi`, `nama_prodi`, `id_fakultas`) VALUES
('BD084', 'Bisnis Digital', 'F001'),
('D3TI056', 'D3 Teknik Informatika', 'F001'),
('DKV069', 'Desain Komunikasi Visual', 'F001'),
('PR059', 'Public Relations', 'F001'),
('SI068', 'Sistem Informasi', 'F001'),
('TI067', 'Teknik Informatika', 'F001');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` varchar(20) NOT NULL,
  `nama_ruangan` varchar(50) NOT NULL,
  `lokasi_gedung` varchar(50) NOT NULL,
  `kapasitas_ruangan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama_ruangan`, `lokasi_gedung`, `kapasitas_ruangan`) VALUES
('FTI465', 'Lab 465', 'FTI', 0),
('FTI467', 'Lab 467', 'FTI', 0);

-- --------------------------------------------------------

--
-- Table structure for table `superadmin`
--

CREATE TABLE `superadmin` (
  `id_sa` varchar(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `kontak` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `superadmin`
--

INSERT INTO `superadmin` (`id_sa`, `nama`, `jabatan`, `kontak`) VALUES
('a123', 'Budi Krsitanto', 'kaprodi', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('mahasiswa','dosen','superadmin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `password`, `role`) VALUES
('01151125001', '123', 'dosen'),
('01151125002', '123', 'dosen'),
('01151125003', '123', 'dosen'),
('672024001', '1234', 'mahasiswa'),
('672024002', '1234', 'mahasiswa'),
('a123', '123', 'superadmin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`nid`),
  ADD KEY `fk_dosen_prodi` (`id_prodi`);

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD PRIMARY KEY (`id_fakultas`);

--
-- Indexes for table `jadwal_kelas`
--
ALTER TABLE `jadwal_kelas`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `fk_jadwal_kelas` (`id_kelas`),
  ADD KEY `fk_jadwal_ruangan` (`id_ruangan`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`),
  ADD KEY `fk_kelas_dosen` (`nid`),
  ADD KEY `fk_kelas_matkul` (`id_matkul`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `fk_mahasiswa_prodi` (`id_prodi`);

--
-- Indexes for table `master_biaya`
--
ALTER TABLE `master_biaya`
  ADD PRIMARY KEY (`id_biaya`);

--
-- Indexes for table `matkul`
--
ALTER TABLE `matkul`
  ADD PRIMARY KEY (`id_matkul`),
  ADD KEY `fk_matkul_prodi` (`id_prodi`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_nilai`),
  ADD KEY `fk_nilai_kelas` (`id_kelas`),
  ADD KEY `fk_nilai_mahasiswa` (`nim`);

--
-- Indexes for table `prodi`
--
ALTER TABLE `prodi`
  ADD PRIMARY KEY (`id_prodi`),
  ADD KEY `fk_prodi_fakultas` (`id_fakultas`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruangan`);

--
-- Indexes for table `superadmin`
--
ALTER TABLE `superadmin`
  ADD PRIMARY KEY (`id_sa`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dosen`
--
ALTER TABLE `dosen`
  ADD CONSTRAINT `fk_dosen_prodi` FOREIGN KEY (`id_prodi`) REFERENCES `prodi` (`id_prodi`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_dosen_user` FOREIGN KEY (`nid`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jadwal_kelas`
--
ALTER TABLE `jadwal_kelas`
  ADD CONSTRAINT `fk_jadwal_kelas` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_jadwal_ruangan` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`) ON UPDATE CASCADE;

--
-- Constraints for table `kelas`
--
ALTER TABLE `kelas`
  ADD CONSTRAINT `fk_kelas_dosen` FOREIGN KEY (`nid`) REFERENCES `dosen` (`nid`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kelas_matkul` FOREIGN KEY (`id_matkul`) REFERENCES `matkul` (`id_matkul`) ON UPDATE CASCADE;

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `fk_mahasiswa_prodi` FOREIGN KEY (`id_prodi`) REFERENCES `prodi` (`id_prodi`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_mahasiswa_user` FOREIGN KEY (`nim`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `matkul`
--
ALTER TABLE `matkul`
  ADD CONSTRAINT `fk_matkul_prodi` FOREIGN KEY (`id_prodi`) REFERENCES `prodi` (`id_prodi`) ON UPDATE CASCADE;

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `fk_nilai_kelas` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_nilai_mahasiswa` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prodi`
--
ALTER TABLE `prodi`
  ADD CONSTRAINT `fk_prodi_fakultas` FOREIGN KEY (`id_fakultas`) REFERENCES `fakultas` (`id_fakultas`) ON UPDATE CASCADE;

--
-- Constraints for table `superadmin`
--
ALTER TABLE `superadmin`
  ADD CONSTRAINT `fk_admin_user` FOREIGN KEY (`id_sa`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
