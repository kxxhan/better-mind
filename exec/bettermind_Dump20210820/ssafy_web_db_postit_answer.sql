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
-- Table structure for table `postit_answer`
--

DROP TABLE IF EXISTS `postit_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postit_answer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `postitquestion_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKliv58dmma73ygac8074feiqf4` (`postitquestion_id`),
  KEY `FKhwvty3sxrf3hy7blbdmg7k2w9` (`user_id`),
  CONSTRAINT `FKhwvty3sxrf3hy7blbdmg7k2w9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKliv58dmma73ygac8074feiqf4` FOREIGN KEY (`postitquestion_id`) REFERENCES `postit_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postit_answer`
--

LOCK TABLES `postit_answer` WRITE;
/*!40000 ALTER TABLE `postit_answer` DISABLE KEYS */;
INSERT INTO `postit_answer` VALUES (9,'1. 가족들과 넷플릭스 영화보기 2. 남편과 저녁외식 데이트 3. 가족과 하이킹, 낚시 4. 아이들이 깔깔대고 웃는 소리','2021-08-19 22:50:38.745000','2021-08-19 22:50:38.745000',2,12),(10,'누군가가 내가 만든 것들을 맛있게 먹는 모습을 보는 일','2021-08-19 22:51:13.085000','2021-08-19 22:51:13.085000',2,2),(12,'도움을 청하거나 무슨일이 있을때 가장 나한테 먼저 연락하는 사람이 내 행복 그 자체에요','2021-08-19 23:26:28.324000','2021-08-19 23:26:28.324000',2,11),(13,'우리 가족','2021-08-20 05:38:27.201000','2021-08-20 05:38:27.201000',2,11);
/*!40000 ALTER TABLE `postit_answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-20  7:23:43
