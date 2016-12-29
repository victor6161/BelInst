-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `text` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `username` varchar(45) NOT NULL,
  `id_picture` int(11) NOT NULL,
  `id_comment` int(11) NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `comment_user__fk` (`username`),
  KEY `comment_picture_id_fk` (`id_picture`),
  CONSTRAINT `comment_picture_id_fk` FOREIGN KEY (`id_picture`) REFERENCES `picture` (`id`),
  CONSTRAINT `comment_user__fk` FOREIGN KEY (`username`) REFERENCES `user` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES ('красиво','2016-12-26 21:03:03','vlad_polt',152,1),('Китай','2016-12-26 22:13:05','vlad_polt',153,2),('Вишни','2016-12-26 22:13:12','vlad_polt',154,3),('Осень','2016-12-26 22:13:24','vlad_polt',161,4),('листья','2016-12-26 22:14:41','oleg7788',161,5),('падают','2016-12-26 22:15:16','vlad_polt',161,6),('озеро','2016-12-26 22:15:43','vlad_polt',156,7);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `username` varchar(255) DEFAULT NULL,
  `friend` varchar(255) DEFAULT NULL,
  UNIQUE KEY `friend__pk` (`username`,`friend`),
  KEY `friend` (`friend`),
  CONSTRAINT `friend_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`Name`),
  CONSTRAINT `friend_ibfk_2` FOREIGN KEY (`friend`) REFERENCES `user` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` VALUES ('iliy_7788','oleg7788'),('oleg7788','vlad_polt'),('vlad_polt','oleg7788'),('Ольга','oleg7788'),('Ольга','vlad_polt');
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `reference` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `picture_user__Name_fk` (`username`),
  CONSTRAINT `picture_user__Name_fk` FOREIGN KEY (`username`) REFERENCES `user` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES ('photo/2d22a4e4-deab-49d3-b5cf-d5c9b538fbbb.jpg','Зима!','2016-12-26 21:02:45','vlad_polt',152),('photo/a440e38b-c9d4-45c8-83be-7823960bf68c.jpg','Мост','2016-12-26 21:05:32','vlad_polt',153),('photo/282eb8ee-f8ff-42b6-8c68-38983c055456.jpg','','2016-12-26 21:07:17','vlad_polt',154),('photo/01671ce3-7072-4d23-8a72-30eb61947b97.jpg','','2016-12-26 21:12:49','oleg7788',155),('photo/619abef5-01ea-48f9-957b-ff43e47ba52e.jpg','','2016-12-26 21:13:11','oleg7788',156),('photo/2027227c-b928-480f-a3dd-3982171fef5a.jpg','','2016-12-26 21:20:22','iliy_7788',157),('photo/3c028efd-954b-4314-a92b-7162133d0f82.jpg','','2016-12-26 21:20:46','iliy_7788',158),('photo/62fb84e9-ee85-4cff-82bf-d33c51bd390d.jpg','','2016-12-26 21:28:04','iliy_7788',159),('photo/a33057ae-b44f-49b6-a3f3-b9cdfff3b20d.jpg','','2016-12-26 21:49:37','vlad_polt',160),('photo/7ee2a14f-7ebc-49b3-8390-01d675ae7367.jpg','Осень','2016-12-26 22:12:44','vlad_polt',161),('photo/08db63f8-1c13-4869-8401-f5072d27aa22.jpg','Осень','2016-12-26 22:25:06','Ольга',162),('photo/499ce53f-070d-4340-bedd-a6529ea9ce1b.jpg','Озеро','2016-12-26 22:25:28','Ольга',163);
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(70) NOT NULL,
  `role` varchar(45) NOT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Name`),
  UNIQUE KEY `user_Name_uindex` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','ads@mail.ru','$2a$10$AODVISVODHjwzcAebkF1g.S2OE3QjAUhT7NHb48XRab8RII.50NXK','ROLE_ADMIN','Админ админ'),('iliy_7788','iliy_7788@gmail.com','$2a$10$w4mfonq0I0xEl1JNQ3Z9r.0amtQOR19SLiEijOKi7lm3M.09K.Kzu','ROLE_USER','Илья Шпаковский'),('oleg7788','olegbestboy@mail.ru','$2a$10$72JMmx4oQUHbHysfD9yDiOp5lnFttgn4CAfKQjg9IAYv6q0PGTLsa','ROLE_USER','Пашкевич Олег Владимирович'),('vlad_polt','vlad_polt@rambler.ru','$2a$10$F2OG7/Lhx7zPnMTTNkH4D.5oPp7MX0GjT2mZLr7oHZcgeXXuTmKcm','ROLE_USER','Влад Полторин'),('Ольга','ee@mail.com','$2a$10$XeuuO4HmKfMA/oGXpBRr5epV6.xRX0Dwd3YBpBbESMRkuMRbhsp.q','ROLE_USER','Ольга Сент');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-26 22:40:00
