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
-- Table structure for table `program_review`
--

DROP TABLE IF EXISTS `program_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program_review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `program_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhsaxxx0i4ottf7axsaefti1i` (`program_id`),
  KEY `FKfkh8qlskv0j28y81pqy4dpy3r` (`user_id`),
  CONSTRAINT `FKfkh8qlskv0j28y81pqy4dpy3r` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKhsaxxx0i4ottf7axsaefti1i` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_review`
--

LOCK TABLES `program_review` WRITE;
/*!40000 ALTER TABLE `program_review` DISABLE KEYS */;
INSERT INTO `program_review` VALUES (2,'자존감이 올라갈 수 있도록 사라들과 소통하고 감정을 공유할 수 있어서 좋았어요! ','2021-08-20 03:44:31.645000','2021-08-20 03:44:31.645000',29,12),(3,'알코올 의지 상태를 항상 고치고 싶었습니다. 이번 기회로 그룹 테라피를 통해 같은 경험을 가진 사람들과 의지를 다질 수 있었고, 상담가님의 따뜻한 응원과 조언으로 중독에 벗어날 수 있었습니다!','2021-08-20 03:50:04.953000','2021-08-20 03:50:04.953000',4,12),(4,'긴 취업기간으로 슬럼프가 오고있었는데, 그룹 테라피 상담을 통해 편하게 이야기하면서 취업에 대한 자신감을 얻을 수 있었습니다. ','2021-08-20 05:08:11.123000','2021-08-20 05:08:11.123000',9,12);
/*!40000 ALTER TABLE `program_review` ENABLE KEYS */;
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
