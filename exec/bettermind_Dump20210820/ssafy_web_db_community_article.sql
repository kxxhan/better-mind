-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 13.124.26.183    Database: ssafy_web_db
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `community_article`
--

DROP TABLE IF EXISTS `community_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_article` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` tinyblob,
  `content` longtext COLLATE utf8mb4_general_ci,
  `created_at` datetime(6) DEFAULT NULL,
  `like_count` int DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi6f4niup6ab6abmqglmrpdwk5` (`user_id`),
  CONSTRAINT `FKi6f4niup6ab6abmqglmrpdwk5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_article`
--

LOCK TABLES `community_article` WRITE;
/*!40000 ALTER TABLE `community_article` DISABLE KEYS */;
INSERT INTO `community_article` VALUES (3,_binary '¬\ķ\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0ģ·Øģģ§ė”','ģė¬“ź²ė ķź³ ģ¶ģ§ ģģģ.\nėė ģ§źø ģ·Øģ¤ ģ¬ė¼ķģ ė¹ ģ§ź±øź¹ģ?','2021-08-19 23:08:10.223000',3,'źø“ ģ·Øģģ ģ ģ  ģ§ģ³ź°ė ė¶ė¤ ź³ģ ź°ģ?','2021-08-19 23:08:10.223000',12),(4,_binary '¬\ķ\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0ģ¼ė°ź³ ėÆ¼','ģ ź° ģ£½źø° ģ ģ ģ ģ ģ¼ģ“ė ź¹ģ?\nģ ķ¬ ėė¼ź° ģ ģģ“ ģ¼ģ“ė ź¹ė“ ėė ź³µģ°ģ£¼ģė” ė°ėź¹ė“ ėė ¤ģ ģ ė ėŖ» ģ ź² ź°ģė°... ź“ģ°®ģź¹ģ..?\nģ ė§ ėė¬“ ė¬“ģģģ...','2021-08-19 23:11:19.482000',0,'ģ ģģ ėė¬“ ģėÆ¼ķ“ģ.','2021-08-19 23:11:19.482000',12),(5,_binary '¬\ķ\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0ķģ','ė“ģ¼ģ ģ ģ ķģė¤ģ“ ģ“ģ¬ķ ģ¤ė¹ķ ķė”ģ ķøė„¼ ģź°ķė ė ģėė¹!\nź³ ģķ ė§ķ¼ ģ¢ģ ź²°ź³¼ź° ģģ¼ė©“ ģ¢ź² ģ“ģ~~\nė¤ė¤ ģģķ“ģ£¼ģøģ„ććć','2021-08-19 23:20:22.978000',3,'ė“ģ¼ ģģ²­ ģ¤ģķ ė ģøė° ģģķ“ģ£¼ģøģ!','2021-08-19 23:20:22.978000',2),(6,_binary '¬\ķ\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0ģ”ģ','ģ§źøģ ģ½ė”ėė” ģķź·¼ė¬“ģ¤ģ“ė¼ ģ”ģ ė³ķģ ķė¤ģ§ģģ§ė§,\nģ¶ķģ ģ½ė”ėź° ģ¢ģėė©“ ģ”ģģ ģķķ“ģ§ź¹ė“ ź±±ģ ģėė¤.','2021-08-19 23:25:38.782000',0,'ģ¼ź³¼ ģ”ģė„¼ ė³ķķģėė¶','2021-08-19 23:25:38.782000',11);
/*!40000 ALTER TABLE `community_article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-20  7:23:44
