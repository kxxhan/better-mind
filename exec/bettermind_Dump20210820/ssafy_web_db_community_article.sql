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
INSERT INTO `community_article` VALUES (3,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','아무것도 하고싶지 않아요.\n나는 지금 취준 슬럼프에 빠진걸까요?','2021-08-19 23:08:10.223000',3,'긴 취업에 점점 지쳐가는 분들 계신가요?','2021-08-19 23:08:10.223000',12),(4,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0일반고민','제가 죽기 전에 전쟁 일어날까요?\n저희 나라가 전쟁이 일어날까봐 또는 공산주의로 바뀔까봐 두려워 잠도 못 잘 것 같은데... 괜찮을까요..?\n정말 너무 무서워요...','2021-08-19 23:11:19.482000',0,'전쟁에 너무 예민해요.','2021-08-19 23:11:19.482000',12),(5,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0학업','내일은 저와 팀원들이 열심히 준비한 프로젝트를 소개하는 날입니당!\n고생한 만큼 좋은 결과가 있으면 좋겠어요~~\n다들 응원해주세욥ㅎㅎㅎ','2021-08-19 23:20:22.978000',3,'내일 엄청 중요한 날인데 응원해주세요!','2021-08-19 23:20:22.978000',2),(6,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0육아','지금은 코로나로 자택근무중이라 육아 병행에 힘들지않지만,\n추후에 코로나가 종식되면 육아에 소홀해질까봐 걱정입니다.','2021-08-19 23:25:38.782000',0,'일과 육아를 병행하시는분','2021-08-19 23:25:38.782000',11);
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
