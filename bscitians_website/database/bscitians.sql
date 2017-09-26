-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2016 at 08:36 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bscitians`
--

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `notes_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `link` varchar(500) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`notes_id`, `name`, `link`, `subject_id`) VALUES
(1, 'Digital Electronic reference', 'https://www.dropbox.com/s/50kafdyyt1sponb/de.pdf?dl=1', 2),
(3, 'Discrete Mathematics Reference', 'https://www.dropbox.com/s/xvh1sxeom1j3ueo/ebooksclub.org__Discrete_Mathematics_with_Applications.pdf?dl=1', 4),
(4, 'Computer Graphics Reference', 'https://www.dropbox.com/s/sq8fe5sx0r9rp8x/cg.pdf?dl=1', 12),
(5, 'Operating System Reference material', 'https://www.dropbox.com/s/zm3ymj8z7h6wuk4/os.pdf?dl=1', 3),
(6, 'Algorithm and Flowchart', 'https://www.dropbox.com/s/4wxmtlxtsrwn60s/Algorithm_and_Flowchart.pdf?dl=1', 6),
(7, 'C++ Programming Language', 'https://www.dropbox.com/s/ilc7331f51vc80a/Bjarne_Stroustrup_Programming_Language.pdf?dl=1', 6),
(8, 'Basic C++ Programming ', 'https://www.dropbox.com/s/wrrqf9q426lng3j/Bscit%20C%2B%2B.pdf?dl=1', 6),
(9, 'C++ for Beginner  ', 'https://www.dropbox.com/s/6n3wk3w820blt2e/C%2B%2B%20For%20Dummies.pdf?dl=1', 6),
(10, 'Imperative Programming ', 'https://www.dropbox.com/s/avxew576gra3xa7/ip.pdf?dl=1', 1),
(11, 'Let us C++', 'https://www.dropbox.com/s/5yqssz5nznt1krz/Let%20us%20C%2B%2B.pdf?dl=1', 6),
(12, 'The 7C''s of Communication', 'https://www.dropbox.com/s/wtolotaxzsu9kop/The_7Cs_of_Communication.pdf?dl=1', 5),
(13, 'Professional Skills', 'https://www.dropbox.com/s/6506d1m7b3f0r9u/professionalskills.pdf?dl=1', 5),
(14, 'Professional Communication Skills', 'https://www.dropbox.com/s/uy9kdq09eeln1ca/PCS.pdf?dl=1', 5),
(16, 'Body Language', 'https://www.dropbox.com/s/4g8x0elviqj1r70/Body-Lang.pdf?dl=1', 5),
(17, 'Microprocessor Architecture', 'https://www.dropbox.com/s/bhcygbaho3e9kjn/ma.pdf?dl=1', 7),
(18, 'Microprocessor MicroController ', 'https://www.dropbox.com/s/09fkehmi349hn89/mpmc.pdf?dl=1', 7),
(21, 'Web Programming', 'https://www.dropbox.com/s/47c9ugvtkgcsrse/WEB%20PRGM.pdf?dl=1', 8),
(23, 'Web Programming HTML and CSS', 'https://www.dropbox.com/s/aukxuqqy7fbhlp7/wp_html%26css.pdf?dl=1', 8),
(24, 'Web Programming Javascript', 'https://www.dropbox.com/s/uwzw5u2oumsdef8/wp_javascript.pdf?dl=1', 8),
(25, 'Web Programming PHP', 'https://www.dropbox.com/s/5svvwaqliiwzttc/wp_php.pdf?dl=1', 8),
(26, 'Advance SQL', 'https://www.dropbox.com/s/iqy95hw1worwx56/asql.pdf?dl=1', 13),
(27, 'Advance SQL Tutorial', 'https://www.dropbox.com/s/f9vjc45v3smvpge/sql_tutorial.pdf?dl=1', 13),
(28, 'Advance SQL Tutorial-2', 'https://www.dropbox.com/s/pxl7vxprnf8io11/Tutorial.pdf?dl=1', 13),
(29, 'Computer Graphics Reference Material', 'https://www.dropbox.com/s/9n8rsbhr6h4d619/cg.pdf?dl=1', 12),
(30, 'Computer Graphics Reference Material-2', 'https://www.dropbox.com/s/gecl6c4z0k5bbbl/CS321.pdf?dl=1', 12),
(31, 'Computer Graphics Lighting', 'https://www.dropbox.com/s/nxnifbc0pajv7y0/lighting.pdf?dl=1', 12),
(32, 'Computer Graphics Shading', 'https://www.dropbox.com/s/4n9qzxpp3omt5hn/shading.pdf?dl=1', 12),
(33, 'LDMS Reference Material', 'https://www.dropbox.com/s/udpv7pgwvz2b3cc/LDMs.pdf?dl=1', 11),
(34, 'Modern Operating System - Tanenbaum', 'https://www.dropbox.com/s/sr0djr9z4r1gvho/Modern%20Operating%20System%20-%20Tanenbaum.pdf?dl=1', 15),
(35, 'Modern Operating System', 'https://www.dropbox.com/s/rektqq4tos5ja1d/mos1.pdf?dl=1', 15),
(36, 'operating system tutorial', 'https://www.dropbox.com/s/iuom43e7327lpdi/operating_system_tutorial.pdf?dl=1', 15),
(37, 'operating system concepts 7th edition', 'https://www.dropbox.com/s/9jpkbn1m9u72z80/operating_system_concepts_7th_edition.pdf?dl=1', 15),
(38, 'operating system concepts 8th edition', 'https://www.dropbox.com/s/ukao6qc01v9y6bj/OS_8th_Edition.pdf?dl=1', 15),
(40, 'C++ Tutorials', 'https://www.dropbox.com/s/fdjxdkoo4ocsqgp/cpp_tutorial.pdf?dl=1', 14),
(41, 'Object-Oriented Programming in C++ 4th Edition ', 'https://www.dropbox.com/s/l0yrcpxzqlyibg5/Object-Oriented%20Programming%20in%20C%2B%2B%20%284th%20Edition%29%20by%20Robert%20Lafore.www.eeeuniversity.com.pdf?dl=1', 14),
(42, 'Green Computing', 'https://www.dropbox.com/s/ah9dhyctaunn503/gc.pdf?dl=1', 10),
(43, 'Numerical and Statistical Methods', 'https://www.dropbox.com/s/9tptxw2d5fs8lwb/nsm.pdf?dl=1', 9),
(44, 'Software Engineering', 'https://www.dropbox.com/s/gb5c731spbtq84g/se.pdf?dl=1', 16),
(45, 'Software Engineering Pankaj Jalote.', 'https://www.dropbox.com/s/uwd0k58ngoa847z/Software%20Engineering%20Pankaj%20Jalote.pdf?dl=1', 16),
(47, 'Multimedia', 'https://www.dropbox.com/s/613gpp43jsmqxcd/pomm2e.pdf?dl=1', 17),
(49, 'Build Java Program Book', 'https://www.dropbox.com/s/oemg3jz5308gh1p/buildjavaprogrambook.pdf?dl=1', 18),
(50, 'Java 2 Complete Reference', 'https://www.dropbox.com/s/5gf691yyg8zvgwv/Java%202%20Complete%20Reference.pdf?dl=1', 18),
(51, 'Java Tutorials Point', 'https://www.dropbox.com/s/ryaco4942ufon2d/JavaTutorialsPoint.pdf?dl=1', 18),
(52, 'Java Quick Guide', 'https://www.dropbox.com/s/bxexci3s9m56tcm/java_quick_guide.pdf?dl=1', 18),
(53, 'java 2 core language', 'https://www.dropbox.com/s/ln3svc8xiilf0u2/java-2-core-language.pdf?dl=1', 18),
(54, 'Programming with Java A Primer,3E', 'https://www.dropbox.com/s/57slb3njvivz7ps/Programming%20with%20Java%20A%20Primer%2C3E.pdf?dl=1', 18),
(55, 'Numerical Methods', 'https://www.dropbox.com/s/ivlukvj0asmvokb/numerical-methods.pdf?dl=1', 19),
(57, 'Embedded Systems', 'https://www.dropbox.com/s/h1mireqfghcmv3s/ES.pdf?dl=1', 20),
(58, 'Network Security ', 'https://www.dropbox.com/s/06tquv1pxhneupr/Network%20Security.pdf?dl=1', 21),
(61, 'Software Testing', 'https://www.dropbox.com/s/isac0cjt0xwp3ho/st.pdf?dl=1', 23),
(60, 'Asp.Net with c# ', 'https://www.dropbox.com/s/q2zqv6gwyof4864/tyitasp-140918041939-phpapp01.pdf?dl=1', 22),
(62, 'Advanced Java', 'https://www.dropbox.com/s/41mrrh0ryzjacbx/AJAVA.pdf?dl=1', 24),
(63, 'Linux Administration', 'https://www.dropbox.com/s/7nzboh6ilbpau60/linuxadminunit123456finalrevised2-7-2014withcp-140918042903-phpapp01.pdf?dl=1', 25),
(64, 'Internet Technology', 'https://www.dropbox.com/s/t2fqyqofljzdk3s/internettechnologyunit123456withcoverpage-141201132445-conversion-gate02.pdf?dl=1', 26),
(65, 'Project Management', 'https://www.dropbox.com/s/x51h422hy0lbaj9/pm123456withcp-150107155727-conversion-gate01.pdf?dl=1', 27),
(66, 'Data Warehousing', 'https://www.dropbox.com/s/3vyv7ggvy7yzt2u/datawarehousingunit123456final-150107151954-conversion-gate01.pdf?dl=1', 28),
(67, 'Cyber Law', 'https://www.dropbox.com/s/bd1qxw5vzty0gx8/cyberlaw.pdf?dl=1', 29),
(68, 'Digital Signals & Systems', 'https://www.dropbox.com/s/ziy9yuh3mk6hkpt/DSS1.pdf?dl=1', 30),
(69, 'Geographic Information Systems', 'https://www.dropbox.com/s/v2e5wil3ct76b0p/gis.pdf?dl=1', 31);

-- --------------------------------------------------------

--
-- Table structure for table `paper`
--

CREATE TABLE `paper` (
  `paper_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `link` varchar(500) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paper`
--

INSERT INTO `paper` (`paper_id`, `name`, `link`, `subject_id`) VALUES
(5, 'ADV.SQL 2014-15', 'https://www.dropbox.com/s/2bgnlb5jel15zvy/adsql1.pdf?dl=1', 13),
(6, 'ADV.SQL 2015-16', 'https://www.dropbox.com/s/y8o0s15mbtma0bm/adsql2.pdf?dl=1', 13),
(7, 'CG 2014-15', 'https://www.dropbox.com/s/vrjizp2b5ecxvx2/cg1.pdf?dl=1', 12),
(8, 'CG 2015-16', 'https://www.dropbox.com/s/mr2spybqxujtyrr/cg2.pdf?dl=1', 12),
(9, 'LDMS 2014-15', 'https://www.dropbox.com/s/vmuc9ts8hoxcv06/ldms2.pdf?dl=1', 11),
(10, 'LDMS 2015-16', 'https://www.dropbox.com/s/6ehpqpqv3e72w33/ldms.pdf?dl=1', 11),
(11, 'MOS 2014-15', 'https://www.dropbox.com/s/uic5a8bkctz09z0/mos1.pdf?dl=1', 15),
(12, 'MOS 2015-16', 'https://www.dropbox.com/s/g8is6q1jz1rq4li/mos2.pdf?dl=1', 15),
(13, 'OOPS C++ 2014-15', 'https://www.dropbox.com/s/sj4pwh7cdzq4i17/oopC2.pdf?dl=1', 14),
(14, 'OOPS C++ 2015-16', 'https://www.dropbox.com/s/je7nogk06umjpnl/oopsC1.pdf?dl=1', 14),
(15, 'ES 2015-16', 'https://www.dropbox.com/s/2jdooujms1f8d5g/Es1.pdf?dl=1', 20),
(16, 'JAVA 2014-15', 'https://www.dropbox.com/s/pivcg0bw18ghflb/java1.pdf?dl=1', 18),
(17, 'JAVA 2015-16', 'https://www.dropbox.com/s/xr7kpvb0hqive4q/java2.pdf?dl=1', 18),
(18, 'Multimedia 2015-16', 'https://www.dropbox.com/s/2rxzgsc6a5x7th0/mm.pdf?dl=1', 17),
(19, 'ADV JAVA 2013-14', 'https://www.dropbox.com/s/d6yegn4logb3dzz/advanced_java_old.pdf?dl=1', 24),
(20, 'ADV JAVA Solutions 2013-14', 'https://www.dropbox.com/s/yga7ng7bwdhbabo/advanced_java_answers.pdf?dl=1', 24),
(21, 'ADV JAVA  2014-15', 'https://www.dropbox.com/s/z5aio7c9tahrnox/advanced_java_questions.pdf?dl=1', 24),
(22, 'ADV JAVA Solution 2014-15', 'https://www.dropbox.com/s/9fvr1268xkddk0q/aj_SOL_2013.pdf?dl=1', 24),
(23, 'ADV JAVA  2015-16', 'https://www.dropbox.com/s/6lksdgn7k9ucp10/aj-bsc-it-oct-2014.pdf?dl=1', 24),
(24, 'ADV JAVA Solution 2015-16', 'https://www.dropbox.com/s/1l59arql3q7ztms/AJ_solution.pdf?dl=1', 24),
(25, 'ADV JAVA Question Bank 2015-16', 'https://www.dropbox.com/s/s8n08foex80kvsi/advanced-java_QuestionBank.pdf?dl=1', 24),
(26, 'ASP.NET Solution 2013-14', 'https://www.dropbox.com/s/a2yn3anfpbaqogz/asp_oct_2013.pdf?dl=1', 22),
(33, 'ASP.NET Solution 2015-16', 'https://www.dropbox.com/s/j08z0f1isb18n7a/asp-net-c-bsc-it-oct-2014.pdf?dl=1', 22),
(28, 'ASP.NET Solution 2014-15', 'https://www.dropbox.com/s/ups5ltof93y9w1o/asp.net_with_c_answers.pdf?dl=1', 22),
(27, 'ASP.NET 2013-14', 'https://www.dropbox.com/s/73nmz4o24lzpe11/asp.net_with_c_old.pdf?dl=1', 22),
(30, 'ASP.NET 2014-15', 'https://www.dropbox.com/s/sofwtwf1v3dgmwz/asp.net_with_c_questions.pdf?dl=1', 22),
(31, 'ASP.NET Solution 2015-16', 'https://www.dropbox.com/s/ot20ens1f3ai42y/asp.net_with_c_solution.pdf?dl=1', 22),
(32, 'ASP.NET Question Bank 2015-16', 'https://www.dropbox.com/s/crmhpsx0f0ikbua/asp.net-with-cQTSbank.pdf?dl=1', 22),
(34, 'Linux 2013-14', 'https://www.dropbox.com/s/h4nfsotqu52q1dr/LA_solution_2014-15.pdf?dl=1', 25),
(35, 'Linux Solution 2013-14', 'https://www.dropbox.com/s/qvcbwbi944pztfr/LA_Solution_2013-14.pdf?dl=1', 25),
(36, 'Linux 2014-15', 'https://www.dropbox.com/s/c7fssajjz1m170y/las_oct_2013.pdf?dl=1', 25),
(37, 'Linux Solution 2014-15', 'https://www.dropbox.com/s/wml69rdtvwlcsnc/linux_administration_answers.pdf?dl=1', 25),
(38, 'Linux 2015-16', 'https://www.dropbox.com/s/2pyu69r8uyq1ld6/linux_administration_old.pdf?dl=1', 25),
(39, 'Linux 2015-16', 'https://www.dropbox.com/s/vdkey7evv1werco/linux_administration_questions.pdf?dl=1', 25),
(40, 'Network Security Solution 2013-14', 'https://www.dropbox.com/s/iq4xr9zc3ft59uy/network_security_answres.pdf?dl=1', 21),
(41, 'Network Security 2014-15', 'https://www.dropbox.com/s/0j12jzo9z57aces/network_security_old.pdf?dl=1', 21),
(42, 'Network Security Solution 2014-15', 'https://www.dropbox.com/s/mtn59aethtbw8li/network_security_oct_sol.pdf?dl=1', 21),
(43, 'Network Security 2015-16', 'https://www.dropbox.com/s/fpz771v0kedszos/network_security_questions.pdf?dl=1', 21),
(44, 'Network Security Solution 2015-16', 'https://www.dropbox.com/s/xlq9w7b7m1rg7lk/ns-bsc-it-oct-2014_sol.pdf?dl=1', 21),
(45, 'Software Testing Solution 2013-14', 'https://www.dropbox.com/s/keyvs6jh3fx2u4l/software_testing_answers.pdf?dl=1', 23),
(46, 'Software Testing 2013-14', 'https://www.dropbox.com/s/liappvqk4fprmsp/software_testing_old.pdf?dl=1', 23),
(47, 'Software Testing Solution 2014-15', 'https://www.dropbox.com/s/ko6n4tyu7t203r2/st_oct_2013_sol.pdf?dl=1', 23),
(48, 'Software Testing 2014-15', 'https://www.dropbox.com/s/p7dg05kaeovv2t8/software_testing_questions.pdf?dl=1', 23),
(49, 'Software Testing 2015-16', 'https://www.dropbox.com/s/2fk3gl7fsq9hotb/ST_2015-16.pdf?dl=1', 23),
(50, 'Software Testing Solution 2015-16', 'https://www.dropbox.com/s/4d4e1ajtjwf6qiw/st_oct-2014_sol.pdf?dl=1', 23),
(51, 'DatawareHouse 2013-14', 'https://www.dropbox.com/s/rkn4i9kc9o48cjm/DW1314-1-1.pdf?dl=1', 28),
(54, 'DatawareHouse 2014-15', 'https://www.dropbox.com/s/l9xtznxvbkksohf/DW_2015.pdf?dl=1', 28),
(53, 'DatawareHouse 2015-16', 'https://www.dropbox.com/s/hsfsu8o3qkw4d42/dw.pdf?dl=1', 28),
(55, 'GIS 2013-14', 'https://www.dropbox.com/s/y1jezk0m79n92ha/GIS1314-2-3.pdf?dl=1', 31),
(56, 'GIS Solution', 'https://www.dropbox.com/s/jlrz500lpp71qzq/gis_answers.pdf?dl=1', 31),
(57, 'GIS 2014-15', 'https://www.dropbox.com/s/k55je73ne8jf8op/gis_2015.pdf?dl=1', 31),
(58, 'GIS 2015-16', 'https://www.dropbox.com/s/usqmk80wxmrihqt/gis2016.pdf?dl=1', 31),
(59, 'IT 2013-14', 'https://www.dropbox.com/s/sulc6q8rxghk97p/IT1314-5-5.pdf?dl=1', 26),
(60, 'IT Solution', 'https://www.dropbox.com/s/rdls160oawrfm64/it_answers.pdf?dl=1', 26),
(61, 'IT 2014-15', 'https://www.dropbox.com/s/lj0o39mh50itnp1/IT_2015.pdf?dl=1', 26),
(62, 'IT 2015-16', 'https://www.dropbox.com/s/oovo2rvuz01st28/IT.pdf?dl=1', 26),
(63, 'PM 2013-14', 'https://www.dropbox.com/s/20k95ixlib678ce/PM1314-4-4.pdf?dl=1', 27),
(64, 'PM Solution', 'https://www.dropbox.com/s/yuk0iaqqbw5cqvg/pm_answers.pdf?dl=1', 27),
(65, 'PM 2014-15', 'https://www.dropbox.com/s/iyykqhyygyaw4vl/pm_2015.pdf?dl=1', 27),
(66, 'PM 2015-16', 'https://www.dropbox.com/s/rb1w00htmoqoimt/pm.pdf?dl=1', 27),
(67, 'IPR 2014-15', 'https://www.dropbox.com/s/2x8s7as133pjtds/ipr_2015.pdf?dl=1', 29),
(68, 'IPR 2015', 'https://www.dropbox.com/s/q1yw8xdl5cw2r3d/ipr2014-15.pdf?dl=1', 29),
(69, 'DSS 2014-15', 'https://www.dropbox.com/s/mbrrudqe3qv0vak/dss2014-15.pdf?dl=1', 30),
(70, 'DSS 2015-16', 'https://www.dropbox.com/s/oe265inev67tdiu/dss2015-16.pdf?dl=1', 30),
(71, 'QT 2014-15', 'https://www.dropbox.com/s/e2m40w5310kziqk/S.Y.B.Sc_.I.T.Sem-IV-April-2015-5-6.pdf?dl=1', 19),
(72, 'QT 2015-16', 'https://www.dropbox.com/s/058d1ngn8y8owri/S.Y.B.Sc-IT-Sem-IV-May-2016-5-6.pdf?dl=1', 19),
(73, 'SE 2014-15', 'https://www.dropbox.com/s/uzb5ee7bh4gd52q/S.Y.B.Sc_.I.T.Sem-IV-April-2015-1-1.pdf?dl=1', 16),
(74, 'SE 2015-16', 'https://www.dropbox.com/s/2dil4ec3aiyhjw4/S.Y.B.Sc-IT-Sem-IV-May-2016-1-1.pdf?dl=1', 16),
(75, 'IP Question Bank', 'https://www.dropbox.com/s/tfjkenf8f185zps/FYBSCIT%20Sem-I%20IP%20QuestionBank.pdf?dl=1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `semester_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`semester_id`, `description`) VALUES
(1, 'Semester 1'),
(2, 'Semester 2'),
(3, 'Semester 3'),
(4, 'Semester 4'),
(5, 'Semester 5'),
(6, 'Semester 6');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `semester_id` int(11) NOT NULL,
  `practicals` tinyint(1) NOT NULL COMMENT '1 : Has Practicals , 0 : Doesn''t Has Practicals',
  `pdf_link` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `name`, `description`, `image_path`, `semester_id`, `practicals`, `pdf_link`) VALUES
(1, 'Imperative Programming', 'Programming in C', 'http://bscitians.ml/images/subject/sem1/ip.png', 1, 1, 'https://www.dropbox.com/s/taomhszlyg2xbh7/IP%20Pracs%20till%20Q5Explain.pdf?dl=1'),
(2, 'Digital Electronics', 'Digital Computing Concepts', 'http://bscitians.ml/images/subject/sem1/de.png', 1, 1, 'https://www.dropbox.com/s/crsyzcmv4pjub14/Digital_Systems.pdf?dl=1'),
(3, 'Operating Systems', 'Learning Linux Os and its commands ', 'http://bscitians.ml/images/subject/sem1/os.png', 1, 0, ''),
(4, 'Discrete Mathematics', 'Computational Maths', 'http://bscitians.ml/images/subject/sem1/maths.png', 1, 1, 'https://www.dropbox.com/s/el1wz1ksl70geva/Maths%20Pracs.pdf?dl=1'),
(5, 'Communication Skills', 'Professional Communication Skills', 'http://bscitians.ml/images/subject/sem1/pcs.png', 1, 0, ''),
(6, 'Object Oriented Programming', 'Programming in C++ OOPS', 'http://bscitians.ml/images/subject/sem2/oops.png', 2, 0, ''),
(7, 'Microprocessor Architecture', 'Programming in Mp/Mc with c', 'http://bscitians.ml/images/subject/sem2/mp.png', 2, 0, ''),
(8, 'Web Programming', 'Programming in HTML/CSS/XML/JS/PHP/MYSQL', 'http://bscitians.ml/images/subject/sem2/wd.png', 2, 0, ''),
(9, 'Numerical and Statistical Methods', 'Mathematical Programming', 'http://bscitians.ml/images/subject/sem2/maths2.png', 2, 0, ''),
(10, 'Green Computing', 'Green Computing ', 'http://bscitians.ml/images/subject/sem2/gc.png', 2, 0, ''),
(11, 'Logic and Discrete Mathematics', 'Logic and Discrete Mathematatics', 'http://bscitians.ml/images/subject/sem3/ldms.png', 3, 0, ''),
(12, 'Computer Graphics', 'Computer Graphics', 'http://bscitians.ml/images/subject/sem3/cg.png', 3, 0, ''),
(13, 'Advanced SQL', 'Learning PL/SQL and Advanced concept of SQL ', 'http://bscitians.ml/images/subject/sem3/advsql.png', 3, 1, 'https://www.dropbox.com/s/r9vhbu1w7xvqoek/advsql.pdf?dl=1'),
(14, 'Object Oriented Programming', 'Programming in C++ OOPS', 'http://bscitians.ml/images/subject/sem3/cpp.png', 3, 0, ''),
(15, 'Modern Operating Systems', 'Learning how an operating system works', 'http://bscitians.ml/images/subject/sem3/os.png', 3, 0, ''),
(16, 'Software Engineering', 'Software Engineering', 'http://bscitians.ml/images/subject/sem4/se.png', 4, 0, ''),
(17, 'Multimedia', 'Multimedia', 'http://bscitians.ml/images/subject/sem4/multimedia.png', 4, 0, ''),
(18, 'Java and Data structures', 'Java and Data structures', 'http://bscitians.ml/images/subject/sem4/java.png', 4, 0, ''),
(19, 'Quantitative Analysis', 'Quantitative Analysis', 'http://bscitians.ml/images/subject/sem4/qt.png', 4, 0, ''),
(20, 'Embedded Systems', 'learning about and programming embedded systems', 'http://bscitians.ml/images/subject/sem4/es.png', 4, 1, 'https://www.dropbox.com/s/yqgzqjnhb3bphn7/es-1.pdf?dl=1'),
(21, 'Network Security', 'learning about securing networks', 'http://bscitians.ml/images/subject/sem5/ns.png', 5, 1, 'https://www.dropbox.com/s/vj6bo89k1du4d80/NS.pdf?dl=1'),
(22, 'Asp.Net With C#', 'Asp.Net With C#', 'http://bscitians.ml/images/subject/sem5/asp.png', 5, 1, 'https://www.dropbox.com/s/a82q0gj89w2xskm/ASP-Pracs.pdf?dl=1'),
(23, 'Software Testing', 'Software Testing', 'http://bscitians.ml/images/subject/sem5/st.png', 5, 1, 'https://www.dropbox.com/s/dprtmlvo5b93627/Software%20testing.pdf?dl=1'),
(24, 'Advanced Java', 'Advanced concepts of java programming language', 'http://bscitians.ml/images/subject/sem5/java.png', 5, 1, 'https://www.dropbox.com/s/lwxw9c8ten7hdfz/Advanced-Java.pdf?dl=1'),
(25, 'Linux Administration', 'Linux Administration', 'http://bscitians.ml/images/subject/sem5/linux.png', 5, 1, 'https://www.dropbox.com/s/noqwfrv8i9341qw/linux.pdf?dl=1'),
(26, 'Internet Technology', 'Internet Technology', 'http://bscitians.ml/images/subject/sem6/it.png', 6, 1, 'https://www.dropbox.com/s/hm9r0xvcxadgi8b/IT-.pdf?dl=1'),
(27, 'Project Management', 'Project Management', 'http://bscitians.ml/images/subject/sem6/pm.png', 6, 0, ''),
(28, 'Data Warehousing', 'Data Warehousing', 'http://bscitians.ml/images/subject/sem6/dw.png', 6, 1, 'https://www.dropbox.com/s/80ociygreqe3pfl/dwpractical.pdf?dl=1'),
(29, 'IPR and Cyber Laws(Elective)', 'IPR and Cyber Laws', 'http://bscitians.ml/images/subject/sem6/cyberLaw.png', 6, 0, ''),
(30, 'Digital Signals and Systems(Elective)', 'Digital Signals and Systems', 'http://bscitians.ml/images/subject/sem6/dss.png', 6, 1, 'https://www.dropbox.com/s/gq2u4xxyqnmvtga/DSS.pdf?dl=1'),
(31, 'Geographic Information Systems(Elective)', 'Geographic Information Systems', 'http://bscitians.ml/images/subject/sem6/gis.png', 6, 1, 'https://www.dropbox.com/s/pbehqdiqr8cmi2u/gis-.pdf?dl=1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`notes_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `paper`
--
ALTER TABLE `paper`
  ADD PRIMARY KEY (`paper_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`semester_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `semester_id` (`semester_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `notes_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;
--
-- AUTO_INCREMENT for table `paper`
--
ALTER TABLE `paper`
  MODIFY `paper_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
  MODIFY `semester_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
