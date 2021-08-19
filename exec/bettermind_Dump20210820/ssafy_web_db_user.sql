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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` tinyblob,
  `certificate` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `point` int NOT NULL,
  `profile_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userid` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0	성추행','',NULL,'tester@ssafy.com','testerhk','$2a$10$ac/crybWehD2mh7vu/cgZuU/fRtWBX7bj3R9JL/VGxKjXooMBkwk.','010-1234-1234',0,NULL,'1','tester1'),(2,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0연애','',NULL,'23gywls@naver.com','효진','$2a$10$n8DRanzHOyJ9haWC57QN7u13Yu8/hsr7WuXB/weS1.PhrK5kU/jka','010-4226-3427',0,NULL,'0','hyojin'),(3,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','',NULL,'tester123@naver.com','tester123','$2a$10$AU20ohFTyC9PLrF7/pan9.v8ZlhRKXpdNeHLSHPEyMeDU9DyZGBlG','010-1234-5678',0,NULL,'0','tester123'),(4,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0일반고민','',NULL,'aaa@bbb.com','오승철','$2a$10$4bpjYdvyC1/zpi/oBCSiA.ZlSIY699iRjdEsQv6xeM0VAkjuiYfUa','010-1111-2222',0,NULL,'0','test_oh'),(8,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0일반고민','131313',NULL,'test@ssafy.com','testerhkhk','$2a$10$To55P2jWR6w2PUlQQ9Rx6.rSibUvYH8fkjke1Eq4kj8x/3j.dXT8e','010-1234-1234',0,NULL,'1','proidhk'),(9,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','',NULL,'a123@naver.com','asd1234','$2a$10$sb7ExDOKuuNTKPSk8Izv6uOFbAcyOwLuI.1QNG0.NjId90TqCDF1y','124124124124',0,NULL,'0','sdafsdfsd'),(11,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0일반고민','000000000','자기 소개','your_email','관리자','$2a$10$Umcmkv5lN1x0SPB7MY0cquHBrJK/o04EnNEIVDS9T6c30brG1w9vO','010-0000-0000',0,'admin.url','2','admin'),(12,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0일반고민','000000000','자기 소개','your_email','사용자','$2a$10$aPuoqs3gqN4qmxgGVAzX1O/YLWkrVgMbp2iabK.yclb.jvRov9mLK','010-0000-0000',0,'ssafy.url','0','ssafy'),(13,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0중독','40866',NULL,'wjsansrk@naver.com','한영미','$2a$10$ZCSM51RoLjFClTXTVAikQOmzR3gHsfW.trpMeGH47PrfqcV5tT2.m','010-7734-5234',0,NULL,'1','expert208'),(14,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','',NULL,'test@ssafy.com','hxxkon','$2a$10$Pbe6ArNfTQ9t5JPstwcLnuc8fo.EMD.XiKz15RksJLkoVgV6zJ58m','010-1234-1234',0,NULL,'0','commonhk'),(15,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','598164',NULL,'jobssafy@ssafy.com','Kim Joon Yeong','$2a$10$4MO43BAH5700TWFPki9VSO0pzfa9f68y4jf30iePI0NgTEd.6BrhC','010-1234-1234',0,NULL,'1','job_consultant'),(16,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','34997',NULL,'expertwis@gmail.com','고경민','$2a$10$j4kgpI0YYrlpEuRr6YbYneo1tuFtalw1x.8F9l9Cz/AZnSILMHSBy','010-2134-7986',0,NULL,'1','expertwis'),(17,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0성격','',NULL,'aaa@bbb.ccc','오승철','$2a$10$mwQnBg2LxtzkfR6nAvPKOO.IMF3c2R474WjdpZfM0lvXMF8cA1vy2','000-1111-2222',0,NULL,'0','tmdcjf103'),(18,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0이별이혼','98126',NULL,'expert123@naver.com','김원준','$2a$10$6a96jMVnrVCbpzxMrRTyB.0ni33O1J6OO0pcPqkBzizWEqMNmcJLO','010-6542-9981',0,NULL,'1','expert123'),(19,_binary '�\�\0~r\0 com.ssafy.db.entity.CategoryEnum\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0취업진로','',NULL,'admin@naver.vom','조효정','$2a$10$WIpqU7MBv2SqTEvG2PZ/s.VjDgS5QS1wQKScH/426gSnjDAbVFfJW','010-1234-5678',0,NULL,'0','whgywjd6794');
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

-- Dump completed on 2021-08-20  7:23:44
