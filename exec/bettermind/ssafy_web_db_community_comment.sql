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
-- Table structure for table `community_comment`
--

DROP TABLE IF EXISTS `community_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `communityarticle_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqa3a6d9n725q4a1sjkp7j7jao` (`communityarticle_id`),
  KEY `FK9oaji7qtsspwvxbp5yuy5a5em` (`user_id`),
  CONSTRAINT `FK9oaji7qtsspwvxbp5yuy5a5em` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqa3a6d9n725q4a1sjkp7j7jao` FOREIGN KEY (`communityarticle_id`) REFERENCES `community_article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_comment`
--

LOCK TABLES `community_comment` WRITE;
/*!40000 ALTER TABLE `community_comment` DISABLE KEYS */;
INSERT INTO `community_comment` VALUES (1,'속도는 중요하지 않습니다! 각자 자신만의 속도가 있는거니까요! 당신을 응원합니다^_^','2021-08-19 23:17:21.396000','2021-08-19 23:17:21.396000',3,2),(2,'와아! 축하합니다! 열심히 노력한만큼 좋은 결과가 있길 응원합니다!','2021-08-20 03:56:53.640000','2021-08-20 03:56:53.640000',5,12),(3,'특정 주제에 너무 예민하다는건 현재 마음이 힘들다는 알림일 수 있어요. 그룹 테라피를 통해 표현을 통해 감정을 배출하시는걸 추천드립니다.','2021-08-20 03:58:27.061000','2021-08-20 03:58:27.061000',4,12),(4,'화이팅입니다!','2021-08-20 05:33:03.751000','2021-08-20 05:33:03.751000',3,17);
/*!40000 ALTER TABLE `community_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-20  6:40:35
