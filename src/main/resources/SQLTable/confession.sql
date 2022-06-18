-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: confession
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL,
  `userID` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'U200','gay'),(2,'U300','notgay'),(3,NULL,NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flag`
--

DROP TABLE IF EXISTS `flag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flag` (
  `idflag` int NOT NULL AUTO_INCREMENT,
  `thisID` varchar(45) DEFAULT NULL,
  `replyID` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idflag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flag`
--

LOCK TABLES `flag` WRITE;
/*!40000 ALTER TABLE `flag` DISABLE KEYS */;
/*!40000 ALTER TABLE `flag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `node` (
  `id` int NOT NULL AUTO_INCREMENT,
  `thisID` varchar(45) NOT NULL,
  `replyID` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (77,'#UM-0001','','content 1','2022-06-18 18.49pm'),(78,'#UM00078','U1','content 2','2022-06-18 18.49pm'),(79,'#UM00079','U1','content 3','2022-06-18 18.50pm'),(80,'#UM00080','U3','content 4','2022-06-18 18.50pm'),(81,'#UM00081','','content 5','2022-06-18 18.50pm'),(82,'#UM00082','U4','content 6','2022-06-18 18.50pm'),(83,'#UM00083','U4','content 7','2022-06-18 18.50pm'),(84,'#UM00084','','content 8','2022-06-18 18.50pm'),(85,'#UM00085','','content 9','2022-06-18 18.50pm'),(86,'#UM00086','U6','content 10','2022-06-18 18.50pm'),(87,'#UM00087','','content 1','2022-06-18 19.05pm'),(88,'#UM00088','U1','content 2','2022-06-18 19.05pm'),(89,'#UM00089','U1','content 3','2022-06-18 19.05pm'),(90,'#UM00090','U3','content 4','2022-06-18 19.05pm'),(91,'#UM00091','','content 5','2022-06-18 19.05pm'),(92,'#UM00092','U4','content 6','2022-06-18 19.05pm'),(93,'#UM00093','U4','content 7','2022-06-18 19.05pm'),(94,'#UM00094','','content 8','2022-06-18 19.05pm'),(95,'#UM00095','','content 9','2022-06-18 19.06pm'),(96,'#UM00096','U6','content 10','2022-06-18 19.06pm'),(97,'#UM00097','','content 1','2022-06-18 19.06pm'),(98,'#UM00098','U1','content 2','2022-06-18 19.07pm'),(99,'#UM00099','U1','content 3','2022-06-18 19.07pm'),(100,'#UM00100','U3','content 4','2022-06-18 19.07pm'),(101,'#UM00101','','content 5','2022-06-18 19.07pm'),(102,'#UM00102','U4','content 6','2022-06-18 19.07pm'),(103,'#UM00103','U4','content 7','2022-06-18 19.07pm'),(104,'#UM00104','','content 8','2022-06-18 19.07pm'),(105,'#UM00105','','content 9','2022-06-18 19.07pm'),(106,'#UM00106','U6','content 10','2022-06-18 19.07pm'),(107,'#UM00107','','content 1','2022-06-18 20.30pm'),(108,'#UM00108','U1','content 2','2022-06-18 20.30pm'),(109,'#UM00109','U1','content 3','2022-06-18 20.30pm'),(110,'#UM00110','U3','content 4','2022-06-18 20.30pm'),(111,'#UM00111','','content 5','2022-06-18 20.30pm'),(112,'#UM00112','U4','content 6','2022-06-18 20.30pm'),(113,'#UM00113','U4','content 7','2022-06-18 20.30pm'),(114,'#UM00114','','content 8','2022-06-18 20.30pm'),(115,'#UM00115','','content 9','2022-06-18 20.30pm'),(116,'#UM00116','U6','content 10','2022-06-18 20.30pm'),(117,'#UM00117','','content 1','2022-06-18 20.31pm'),(118,'#UM00118','U1','content 2','2022-06-18 20.31pm'),(119,'#UM00119','U1','content 3','2022-06-18 20.31pm'),(120,'#UM00120','U3','content 4','2022-06-18 20.31pm'),(121,'#UM00121','','content 5','2022-06-18 20.31pm'),(122,'#UM00122','U4','content 6','2022-06-18 20.31pm'),(123,'#UM00123','U4','content 7','2022-06-18 20.31pm'),(124,'#UM00124','','content 8','2022-06-18 20.31pm'),(125,'#UM00125','','content 9','2022-06-18 20.31pm'),(126,'#UM00126','U6','content 10','2022-06-18 20.31pm'),(127,'#UM00127','','content 1','2022-06-18 20.32pm'),(128,'#UM00128','U1','content 2','2022-06-18 20.32pm'),(129,'#UM00129','U1','content 3','2022-06-18 20.32pm'),(130,'#UM00130','U3','content 4','2022-06-18 20.32pm'),(131,'#UM00131','','content 5','2022-06-18 20.32pm'),(132,'#UM00132','U4','content 6','2022-06-18 20.32pm'),(133,'#UM00133','U4','content 7','2022-06-18 20.32pm'),(134,'#UM00134','','content 8','2022-06-18 20.32pm'),(135,'#UM00135','','content 9','2022-06-18 20.32pm'),(136,'#UM00136','U6','content 10','2022-06-18 20.32pm'),(137,'#UM00137','','content 1','2022-06-18 20.33pm'),(138,'#UM00138','U1','content 2','2022-06-18 20.33pm'),(139,'#UM00139','U1','content 3','2022-06-18 20.33pm'),(140,'#UM00140','U3','content 4','2022-06-18 20.33pm'),(141,'#UM00141','','content 5','2022-06-18 20.33pm'),(142,'#UM00142','U4','content 6','2022-06-18 20.33pm'),(143,'#UM00143','U4','content 7','2022-06-18 20.33pm'),(144,'#UM00144','','content 8','2022-06-18 20.33pm'),(145,'#UM00145','','content 9','2022-06-18 20.33pm'),(146,'#UM00146','U6','content 10','2022-06-18 20.33pm'),(147,'#UM00147','','content 1','2022-06-18 20.33pm'),(148,'#UM00148','U1','content 2','2022-06-18 20.33pm'),(149,'#UM00149','U1','content 3','2022-06-18 20.33pm'),(150,'#UM00150','U3','content 4','2022-06-18 20.33pm'),(151,'#UM00151','','content 5','2022-06-18 20.33pm'),(152,'#UM00152','U4','content 6','2022-06-18 20.33pm'),(153,'#UM00153','U4','content 7','2022-06-18 20.33pm'),(154,'#UM00154','','content 8','2022-06-18 20.33pm'),(155,'#UM00155','','content 9','2022-06-18 20.33pm'),(156,'#UM00156','U6','content 10','2022-06-18 20.33pm'),(157,'#UM00157','','content 1','2022-06-18 20.41pm'),(158,'#UM00158','U1','content 2','2022-06-18 20.41pm'),(159,'#UM00159','U1','content 3','2022-06-18 20.41pm'),(160,'#UM00160','U3','content 4','2022-06-18 20.41pm'),(161,'#UM00161','','content 5','2022-06-18 20.41pm'),(162,'#UM00162','U4','content 6','2022-06-18 20.41pm'),(163,'#UM00163','U4','content 7','2022-06-18 20.41pm'),(164,'#UM00164','','content 8','2022-06-18 20.41pm'),(165,'#UM00165','','content 9','2022-06-18 20.41pm'),(166,'#UM00166','U6','content 10','2022-06-18 20.41pm'),(167,'#UM00167','','content 1','2022-06-18 20.46pm'),(168,'#UM00168','U1','content 2','2022-06-18 20.47pm'),(169,'#UM00169','U1','content 3','2022-06-18 20.48pm'),(170,'#UM00170','U3','content 4','2022-06-18 20.49pm'),(171,'#UM00171','','content 5','2022-06-18 20.50pm'),(172,'#UM00172','U4','content 6','2022-06-18 20.51pm'),(173,'#UM00173','U4','content 7','2022-06-18 20.52pm'),(174,'#UM00174','','content 8','2022-06-18 20.54pm'),(175,'#UM00175','','content 9','2022-06-18 20.55pm'),(176,'#UM00176','U6','content 10','2022-06-18 20.56pm');
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spam`
--

DROP TABLE IF EXISTS `spam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spam` (
  `idspam` int NOT NULL AUTO_INCREMENT,
  `thisID` varchar(45) DEFAULT NULL,
  `replyID` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idspam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spam`
--

LOCK TABLES `spam` WRITE;
/*!40000 ALTER TABLE `spam` DISABLE KEYS */;
/*!40000 ALTER TABLE `spam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waitinglist`
--

DROP TABLE IF EXISTS `waitinglist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waitinglist` (
  `num` int NOT NULL AUTO_INCREMENT,
  `thisID` varchar(45) DEFAULT NULL,
  `replyID` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waitinglist`
--

LOCK TABLES `waitinglist` WRITE;
/*!40000 ALTER TABLE `waitinglist` DISABLE KEYS */;
/*!40000 ALTER TABLE `waitinglist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-18 22:17:38
