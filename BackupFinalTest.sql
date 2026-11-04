-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: db_sistema_uni_test
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id_alumno` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_carrera` int NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id_alumno`),
  UNIQUE KEY `id_usuario` (`id_usuario`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_alumno_carrera` (`id_carrera`),
  CONSTRAINT `fk_alumno_carrera` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`),
  CONSTRAINT `fk_alumno_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,1,1,'U100001','Luis Alberto','Quispe Ramos','70123451','alumno01@mackas.edu.pe','900000001','2004-02-12'),(2,2,1,'U100002','Maria Fernanda','Torres Salazar','70123452','alumno02@mackas.edu.pe','900000002','2003-07-25'),(3,3,1,'U100003','Diego Armando','Flores Huaman','70123453','alumno03@mackas.edu.pe','900000003','2004-11-03'),(4,4,1,'U100004','Camila Andrea','Rojas Paredes','70123454','alumno04@mackas.edu.pe','900000004','2005-01-18'),(5,5,1,'U100005','Jose Manuel','Vargas Cardenas','70123455','alumno05@mackas.edu.pe','900000005','2003-05-09'),(6,6,1,'U100006','Valeria Sofia','Mendoza Castro','70123456','alumno06@mackas.edu.pe','900000006','2004-09-14'),(7,7,2,'U100007','Andres Felipe','Gutierrez Leon','70123457','alumno07@mackas.edu.pe','900000007','2002-12-21'),(8,8,2,'U100008','Lucia Isabel','Chavez Medina','70123458','alumno08@mackas.edu.pe','900000008','2003-03-30'),(9,9,2,'U100009','Miguel Angel','Reyes Soto','70123459','alumno09@mackas.edu.pe','900000009','2004-06-11'),(10,10,3,'U100010','Daniela Nicole','Poma Ruiz','70123460','alumno10@mackas.edu.pe','900000010','2005-08-02'),(11,11,3,'U100011','Fernando Raul','Castillo Vega','70123461','alumno11@mackas.edu.pe','900000011','2003-10-16'),(12,12,4,'U100012','Paola Cristina','Herrera Diaz','70123462','alumno12@mackas.edu.pe','900000012','2004-04-07');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificacion` (
  `id_calificacion` int NOT NULL AUTO_INCREMENT,
  `id_detalle_matricula` int NOT NULL,
  `nombre_evaluacion` varchar(50) NOT NULL,
  `ponderado` decimal(5,2) NOT NULL,
  `nota` decimal(4,2) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_calificacion`),
  KEY `fk_calificacion_detalle` (`id_detalle_matricula`),
  CONSTRAINT `fk_calificacion_detalle` FOREIGN KEY (`id_detalle_matricula`) REFERENCES `detalle_matricula` (`id_detalle_matricula`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (1,1,'Practica 1',0.20,12.35,'2026-11-04 13:28:23'),(2,1,'Evaluacion Parcial',0.30,12.70,'2026-11-04 13:28:23'),(3,1,'Practica 2',0.20,13.05,'2026-11-04 13:28:23'),(4,1,'Examen Final',0.30,13.40,'2026-11-04 13:28:23'),(5,2,'Practica 1',0.20,12.40,'2026-11-04 13:28:23'),(6,2,'Evaluacion Parcial',0.30,12.75,'2026-11-04 13:28:23'),(7,2,'Practica 2',0.20,13.10,'2026-11-04 13:28:23'),(8,2,'Examen Final',0.30,13.45,'2026-11-04 13:28:23'),(9,3,'Practica 1',0.20,14.20,'2026-11-04 13:28:23'),(10,3,'Evaluacion Parcial',0.30,12.80,'2026-11-04 13:28:23'),(11,3,'Practica 2',0.20,13.15,'2026-11-04 13:28:23'),(12,3,'Examen Final',0.30,13.50,'2026-11-04 13:28:23'),(13,4,'Practica 1',0.20,13.75,'2026-11-04 13:28:23'),(14,4,'Evaluacion Parcial',0.30,14.10,'2026-11-04 13:28:23'),(15,4,'Practica 2',0.20,12.70,'2026-11-04 13:28:23'),(16,4,'Examen Final',0.30,13.05,'2026-11-04 13:28:23'),(17,5,'Practica 1',0.20,13.80,'2026-11-04 13:28:23'),(18,5,'Evaluacion Parcial',0.30,14.15,'2026-11-04 13:28:23'),(19,5,'Practica 2',0.20,14.50,'2026-11-04 13:28:23'),(20,5,'Examen Final',0.30,13.10,'2026-11-04 13:28:23'),(21,6,'Practica 1',0.20,13.85,'2026-11-04 13:28:23'),(22,6,'Evaluacion Parcial',0.30,14.20,'2026-11-04 13:28:23'),(23,6,'Practica 2',0.20,14.55,'2026-11-04 13:28:23'),(24,6,'Examen Final',0.30,14.90,'2026-11-04 13:28:23'),(25,7,'Practica 1',0.20,15.00,'2026-11-04 13:28:23'),(26,7,'Evaluacion Parcial',0.30,15.35,'2026-11-04 13:28:23'),(27,7,'Practica 2',0.20,15.70,'2026-11-04 13:28:23'),(28,7,'Examen Final',0.30,16.05,'2026-11-04 13:28:23'),(29,8,'Practica 1',0.20,15.20,'2026-11-04 13:28:23'),(30,8,'Evaluacion Parcial',0.30,13.80,'2026-11-04 13:28:23'),(31,8,'Practica 2',0.20,14.15,'2026-11-04 13:28:23'),(32,8,'Examen Final',0.30,14.50,'2026-11-04 13:28:23'),(33,9,'Practica 1',0.20,15.25,'2026-11-04 13:28:23'),(34,9,'Evaluacion Parcial',0.30,15.60,'2026-11-04 13:28:23'),(35,9,'Practica 2',0.20,14.20,'2026-11-04 13:28:23'),(36,9,'Examen Final',0.30,14.55,'2026-11-04 13:28:23'),(37,10,'Practica 1',0.20,16.40,'2026-11-04 13:28:23'),(38,10,'Evaluacion Parcial',0.30,16.75,'2026-11-04 13:28:23'),(39,10,'Practica 2',0.20,17.10,'2026-11-04 13:28:23'),(40,10,'Examen Final',0.30,15.70,'2026-11-04 13:28:23'),(41,11,'Practica 1',0.20,16.45,'2026-11-04 13:28:23'),(42,11,'Evaluacion Parcial',0.30,16.80,'2026-11-04 13:28:23'),(43,11,'Practica 2',0.20,17.15,'2026-11-04 13:28:23'),(44,11,'Examen Final',0.30,17.50,'2026-11-04 13:28:23'),(45,12,'Practica 1',0.20,14.90,'2026-11-04 13:28:23'),(46,12,'Evaluacion Parcial',0.30,15.25,'2026-11-04 13:28:23'),(47,12,'Practica 2',0.20,15.60,'2026-11-04 13:28:23'),(48,12,'Examen Final',0.30,15.95,'2026-11-04 13:28:23'),(49,13,'Practica 1',0.20,17.80,'2026-11-04 13:28:23'),(50,13,'Evaluacion Parcial',0.30,16.40,'2026-11-04 13:28:23'),(51,13,'Practica 2',0.20,16.75,'2026-11-04 13:28:23'),(52,13,'Examen Final',0.30,17.10,'2026-11-04 13:28:23'),(53,14,'Practica 1',0.20,17.85,'2026-11-04 13:28:23'),(54,14,'Evaluacion Parcial',0.30,18.20,'2026-11-04 13:28:23'),(55,14,'Practica 2',0.20,16.80,'2026-11-04 13:28:23'),(56,14,'Examen Final',0.30,17.15,'2026-11-04 13:28:23'),(57,15,'Practica 1',0.20,17.90,'2026-11-04 13:28:23'),(58,15,'Evaluacion Parcial',0.30,18.25,'2026-11-04 13:28:23'),(59,15,'Practica 2',0.20,18.60,'2026-11-04 13:28:23'),(60,15,'Examen Final',0.30,17.20,'2026-11-04 13:28:23'),(61,16,'Practica 1',0.20,10.85,'2026-11-04 13:28:23'),(62,16,'Evaluacion Parcial',0.30,11.20,'2026-11-04 13:28:23'),(63,16,'Practica 2',0.20,11.55,'2026-11-04 13:28:23'),(64,16,'Examen Final',0.30,11.90,'2026-11-04 13:28:23'),(65,17,'Practica 1',0.20,10.90,'2026-11-04 13:28:23'),(66,17,'Evaluacion Parcial',0.30,11.25,'2026-11-04 13:28:23'),(67,17,'Practica 2',0.20,11.60,'2026-11-04 13:28:23'),(68,17,'Examen Final',0.30,11.95,'2026-11-04 13:28:23'),(69,18,'Practica 1',0.20,12.70,'2026-11-04 13:28:23'),(70,18,'Evaluacion Parcial',0.30,11.30,'2026-11-04 13:28:23'),(71,18,'Practica 2',0.20,11.65,'2026-11-04 13:28:23'),(72,18,'Examen Final',0.30,12.00,'2026-11-04 13:28:23'),(73,19,'Practica 1',0.20,13.85,'2026-11-04 13:28:23'),(74,19,'Evaluacion Parcial',0.30,14.20,'2026-11-04 13:28:23'),(75,19,'Practica 2',0.20,12.80,'2026-11-04 13:28:23'),(76,19,'Examen Final',0.30,13.15,'2026-11-04 13:28:23'),(77,20,'Practica 1',0.20,12.30,'2026-11-04 13:28:23'),(78,20,'Evaluacion Parcial',0.30,12.65,'2026-11-04 13:28:23'),(79,20,'Practica 2',0.20,13.00,'2026-11-04 13:28:23'),(80,20,'Examen Final',0.30,11.60,'2026-11-04 13:28:23'),(81,21,'Practica 1',0.20,12.35,'2026-11-04 13:28:23'),(82,21,'Evaluacion Parcial',0.30,12.70,'2026-11-04 13:28:23'),(83,21,'Practica 2',0.20,13.05,'2026-11-04 13:28:23'),(84,21,'Examen Final',0.30,13.40,'2026-11-04 13:28:23'),(85,22,'Practica 1',0.20,13.50,'2026-11-04 13:28:23'),(86,22,'Evaluacion Parcial',0.30,13.85,'2026-11-04 13:28:23'),(87,22,'Practica 2',0.20,14.20,'2026-11-04 13:28:23'),(88,22,'Examen Final',0.30,14.55,'2026-11-04 13:28:23'),(89,23,'Practica 1',0.20,15.30,'2026-11-04 13:28:23'),(90,23,'Evaluacion Parcial',0.30,13.90,'2026-11-04 13:28:23'),(91,23,'Practica 2',0.20,14.25,'2026-11-04 13:28:23'),(92,23,'Examen Final',0.30,14.60,'2026-11-04 13:28:23'),(93,24,'Practica 1',0.20,13.75,'2026-11-04 13:28:23'),(94,24,'Evaluacion Parcial',0.30,14.10,'2026-11-04 13:28:23'),(95,24,'Practica 2',0.20,12.70,'2026-11-04 13:28:23'),(96,24,'Examen Final',0.30,13.05,'2026-11-04 13:28:23'),(97,25,'Practica 1',0.20,14.90,'2026-11-04 13:28:23'),(98,25,'Evaluacion Parcial',0.30,15.25,'2026-11-04 13:28:23'),(99,25,'Practica 2',0.20,15.60,'2026-11-04 13:28:23'),(100,25,'Examen Final',0.30,14.20,'2026-11-04 13:28:23'),(101,26,'Practica 1',0.20,14.95,'2026-11-04 13:28:23'),(102,26,'Evaluacion Parcial',0.30,15.30,'2026-11-04 13:28:23'),(103,26,'Practica 2',0.20,15.65,'2026-11-04 13:28:23'),(104,26,'Examen Final',0.30,16.00,'2026-11-04 13:28:23'),(105,27,'Practica 1',0.20,15.00,'2026-11-04 13:28:23'),(106,27,'Evaluacion Parcial',0.30,15.35,'2026-11-04 13:28:23'),(107,27,'Practica 2',0.20,15.70,'2026-11-04 13:28:23'),(108,27,'Examen Final',0.30,16.05,'2026-11-04 13:28:23'),(109,28,'Practica 1',0.20,16.30,'2026-11-04 13:28:23'),(110,28,'Evaluacion Parcial',0.30,14.90,'2026-11-04 13:28:23'),(111,28,'Practica 2',0.20,15.25,'2026-11-04 13:28:23'),(112,28,'Examen Final',0.30,15.60,'2026-11-04 13:28:23'),(113,29,'Practica 1',0.20,16.35,'2026-11-04 13:28:23'),(114,29,'Evaluacion Parcial',0.30,16.70,'2026-11-04 13:28:23'),(115,29,'Practica 2',0.20,15.30,'2026-11-04 13:28:23'),(116,29,'Examen Final',0.30,15.65,'2026-11-04 13:28:23'),(117,30,'Practica 1',0.20,16.40,'2026-11-04 13:28:23'),(118,30,'Evaluacion Parcial',0.30,16.75,'2026-11-04 13:28:23'),(119,30,'Practica 2',0.20,17.10,'2026-11-04 13:28:23'),(120,30,'Examen Final',0.30,15.70,'2026-11-04 13:28:23'),(121,31,'Practica 1',0.20,17.55,'2026-11-04 13:28:23'),(122,31,'Evaluacion Parcial',0.30,17.90,'2026-11-04 13:28:23'),(123,31,'Practica 2',0.20,18.25,'2026-11-04 13:28:23'),(124,31,'Examen Final',0.30,18.60,'2026-11-04 13:28:23'),(125,32,'Practica 1',0.20,16.00,'2026-11-04 13:28:23'),(126,32,'Evaluacion Parcial',0.30,16.35,'2026-11-04 13:28:23'),(127,32,'Practica 2',0.20,16.70,'2026-11-04 13:28:23'),(128,32,'Examen Final',0.30,17.05,'2026-11-04 13:28:23'),(129,33,'Practica 1',0.20,17.80,'2026-11-04 13:28:23'),(130,33,'Evaluacion Parcial',0.30,16.40,'2026-11-04 13:28:23'),(131,33,'Practica 2',0.20,16.75,'2026-11-04 13:28:23'),(132,33,'Examen Final',0.30,17.10,'2026-11-04 13:28:23'),(133,34,'Practica 1',0.20,12.35,'2026-11-04 13:28:23'),(134,34,'Evaluacion Parcial',0.30,12.70,'2026-11-04 13:28:23'),(135,34,'Practica 2',0.20,11.30,'2026-11-04 13:28:23'),(136,34,'Examen Final',0.30,11.65,'2026-11-04 13:28:23'),(137,35,'Practica 1',0.20,12.40,'2026-11-04 13:28:23'),(138,35,'Evaluacion Parcial',0.30,12.75,'2026-11-04 13:28:23'),(139,35,'Practica 2',0.20,13.10,'2026-11-04 13:28:23'),(140,35,'Examen Final',0.30,11.70,'2026-11-04 13:28:23'),(141,36,'Practica 1',0.20,10.85,'2026-11-04 13:28:23'),(142,36,'Evaluacion Parcial',0.30,11.20,'2026-11-04 13:28:23'),(143,36,'Practica 2',0.20,11.55,'2026-11-04 13:28:23'),(144,36,'Examen Final',0.30,11.90,'2026-11-04 13:28:23'),(145,37,'Practica 1',0.20,12.00,'2026-11-04 13:28:23'),(146,37,'Evaluacion Parcial',0.30,12.35,'2026-11-04 13:28:23'),(147,37,'Practica 2',0.20,12.70,'2026-11-04 13:28:23'),(148,37,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(149,38,'Practica 1',0.20,13.80,'2026-11-04 13:28:23'),(150,38,'Evaluacion Parcial',0.30,12.40,'2026-11-04 13:28:23'),(151,38,'Practica 2',0.20,12.75,'2026-11-04 13:28:23'),(152,38,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(153,39,'Practica 1',0.20,13.85,'2026-11-04 13:28:23'),(154,39,'Evaluacion Parcial',0.30,14.20,'2026-11-04 13:28:23'),(155,39,'Practica 2',0.20,12.80,'2026-11-04 13:28:23'),(156,39,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(157,40,'Practica 1',0.20,13.40,'2026-11-04 13:28:23'),(158,40,'Evaluacion Parcial',0.30,13.75,'2026-11-04 13:28:23'),(159,40,'Practica 2',0.20,14.10,'2026-11-04 13:28:23'),(160,40,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(161,41,'Practica 1',0.20,13.45,'2026-11-04 13:28:23'),(162,41,'Evaluacion Parcial',0.30,13.80,'2026-11-04 13:28:23'),(163,41,'Practica 2',0.20,14.15,'2026-11-04 13:28:23'),(164,41,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(165,42,'Practica 1',0.20,13.50,'2026-11-04 13:28:23'),(166,42,'Evaluacion Parcial',0.30,13.85,'2026-11-04 13:28:23'),(167,42,'Practica 2',0.20,14.20,'2026-11-04 13:28:23'),(168,42,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(169,43,'Practica 1',0.20,16.40,'2026-11-04 13:28:23'),(170,43,'Evaluacion Parcial',0.30,15.00,'2026-11-04 13:28:23'),(171,43,'Practica 2',0.20,15.35,'2026-11-04 13:28:23'),(172,43,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(173,44,'Practica 1',0.20,14.85,'2026-11-04 13:28:23'),(174,44,'Evaluacion Parcial',0.30,15.20,'2026-11-04 13:28:23'),(175,44,'Practica 2',0.20,13.80,'2026-11-04 13:28:23'),(176,44,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(177,45,'Practica 1',0.20,14.90,'2026-11-04 13:28:23'),(178,45,'Evaluacion Parcial',0.30,15.25,'2026-11-04 13:28:23'),(179,45,'Practica 2',0.20,15.60,'2026-11-04 13:28:23'),(180,45,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(181,46,'Practica 1',0.20,16.05,'2026-11-04 13:28:23'),(182,46,'Evaluacion Parcial',0.30,16.40,'2026-11-04 13:28:23'),(183,46,'Practica 2',0.20,16.75,'2026-11-04 13:28:23'),(184,46,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(185,47,'Practica 1',0.20,16.10,'2026-11-04 13:28:23'),(186,47,'Evaluacion Parcial',0.30,16.45,'2026-11-04 13:28:23'),(187,47,'Practica 2',0.20,16.80,'2026-11-04 13:28:23'),(188,47,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(189,48,'Practica 1',0.20,16.30,'2026-11-04 13:28:23'),(190,48,'Evaluacion Parcial',0.30,14.90,'2026-11-04 13:28:23'),(191,48,'Practica 2',0.20,15.25,'2026-11-04 13:28:23'),(192,48,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(193,49,'Practica 1',0.20,17.45,'2026-11-04 13:28:23'),(194,49,'Evaluacion Parcial',0.30,17.80,'2026-11-04 13:28:23'),(195,49,'Practica 2',0.20,16.40,'2026-11-04 13:28:23'),(196,49,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(197,50,'Practica 1',0.20,17.50,'2026-11-04 13:28:23'),(198,50,'Evaluacion Parcial',0.30,17.85,'2026-11-04 13:28:23'),(199,50,'Practica 2',0.20,18.20,'2026-11-04 13:28:23'),(200,50,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(201,51,'Practica 1',0.20,17.55,'2026-11-04 13:28:23'),(202,51,'Evaluacion Parcial',0.30,17.90,'2026-11-04 13:28:23'),(203,51,'Practica 2',0.20,18.25,'2026-11-04 13:28:23'),(204,51,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(205,52,'Practica 1',0.20,10.50,'2026-11-04 13:28:23'),(206,52,'Evaluacion Parcial',0.30,10.85,'2026-11-04 13:28:23'),(207,52,'Practica 2',0.20,11.20,'2026-11-04 13:28:23'),(208,52,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(209,53,'Practica 1',0.20,12.30,'2026-11-04 13:28:23'),(210,53,'Evaluacion Parcial',0.30,10.90,'2026-11-04 13:28:23'),(211,53,'Practica 2',0.20,11.25,'2026-11-04 13:28:23'),(212,53,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(213,54,'Practica 1',0.20,12.35,'2026-11-04 13:28:23'),(214,54,'Evaluacion Parcial',0.30,12.70,'2026-11-04 13:28:23'),(215,54,'Practica 2',0.20,11.30,'2026-11-04 13:28:23'),(216,54,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(217,55,'Practica 1',0.20,13.50,'2026-11-04 13:28:23'),(218,55,'Evaluacion Parcial',0.30,13.85,'2026-11-04 13:28:23'),(219,55,'Practica 2',0.20,14.20,'2026-11-04 13:28:23'),(220,55,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(221,56,'Practica 1',0.20,11.95,'2026-11-04 13:28:23'),(222,56,'Evaluacion Parcial',0.30,12.30,'2026-11-04 13:28:23'),(223,56,'Practica 2',0.20,12.65,'2026-11-04 13:28:23'),(224,56,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(225,57,'Practica 1',0.20,12.00,'2026-11-04 13:28:23'),(226,57,'Evaluacion Parcial',0.30,12.35,'2026-11-04 13:28:23'),(227,57,'Practica 2',0.20,12.70,'2026-11-04 13:28:23'),(228,57,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(229,58,'Practica 1',0.20,14.90,'2026-11-04 13:28:23'),(230,58,'Evaluacion Parcial',0.30,13.50,'2026-11-04 13:28:23'),(231,58,'Practica 2',0.20,13.85,'2026-11-04 13:28:23'),(232,58,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(233,59,'Practica 1',0.20,14.95,'2026-11-04 13:28:23'),(234,59,'Evaluacion Parcial',0.30,15.30,'2026-11-04 13:28:23'),(235,59,'Practica 2',0.20,13.90,'2026-11-04 13:28:23'),(236,59,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(237,60,'Practica 1',0.20,13.40,'2026-11-04 13:28:23'),(238,60,'Evaluacion Parcial',0.30,13.75,'2026-11-04 13:28:23'),(239,60,'Practica 2',0.20,14.10,'2026-11-04 13:28:23'),(240,60,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(241,61,'Practica 1',0.20,14.55,'2026-11-04 13:28:23'),(242,61,'Evaluacion Parcial',0.30,14.90,'2026-11-04 13:28:23'),(243,61,'Practica 2',0.20,15.25,'2026-11-04 13:28:23'),(244,61,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(245,62,'Practica 1',0.20,14.60,'2026-11-04 13:28:23'),(246,62,'Evaluacion Parcial',0.30,14.95,'2026-11-04 13:28:23'),(247,62,'Practica 2',0.20,15.30,'2026-11-04 13:28:23'),(248,62,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(249,63,'Practica 1',0.20,16.40,'2026-11-04 13:28:23'),(250,63,'Evaluacion Parcial',0.30,15.00,'2026-11-04 13:28:23'),(251,63,'Practica 2',0.20,15.35,'2026-11-04 13:28:23'),(252,63,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(253,64,'Practica 1',0.20,15.95,'2026-11-04 13:28:23'),(254,64,'Evaluacion Parcial',0.30,16.30,'2026-11-04 13:28:23'),(255,64,'Practica 2',0.20,14.90,'2026-11-04 13:28:23'),(256,64,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(257,65,'Practica 1',0.20,16.00,'2026-11-04 13:28:23'),(258,65,'Evaluacion Parcial',0.30,16.35,'2026-11-04 13:28:23'),(259,65,'Practica 2',0.20,16.70,'2026-11-04 13:28:23'),(260,65,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(261,66,'Practica 1',0.20,16.05,'2026-11-04 13:28:23'),(262,66,'Evaluacion Parcial',0.30,16.40,'2026-11-04 13:28:23'),(263,66,'Practica 2',0.20,16.75,'2026-11-04 13:28:23'),(264,66,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(265,67,'Practica 1',0.20,17.20,'2026-11-04 13:28:23'),(266,67,'Evaluacion Parcial',0.30,17.55,'2026-11-04 13:28:23'),(267,67,'Practica 2',0.20,17.90,'2026-11-04 13:28:23'),(268,67,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(269,68,'Practica 1',0.20,17.40,'2026-11-04 13:28:23'),(270,68,'Evaluacion Parcial',0.30,16.00,'2026-11-04 13:28:23'),(271,68,'Practica 2',0.20,16.35,'2026-11-04 13:28:23'),(272,68,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(273,69,'Practica 1',0.20,17.45,'2026-11-04 13:28:23'),(274,69,'Evaluacion Parcial',0.30,17.80,'2026-11-04 13:28:23'),(275,69,'Practica 2',0.20,16.40,'2026-11-04 13:28:23'),(276,69,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(277,70,'Practica 1',0.20,12.00,'2026-11-04 13:28:23'),(278,70,'Evaluacion Parcial',0.30,12.35,'2026-11-04 13:28:23'),(279,70,'Practica 2',0.20,12.70,'2026-11-04 13:28:23'),(280,70,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(281,71,'Practica 1',0.20,12.05,'2026-11-04 13:28:23'),(282,71,'Evaluacion Parcial',0.30,12.40,'2026-11-04 13:28:23'),(283,71,'Practica 2',0.20,12.75,'2026-11-04 13:28:23'),(284,71,'Examen Final',0.30,NULL,'2026-11-04 13:28:23'),(285,72,'Practica 1',0.20,10.50,'2026-11-04 13:28:23'),(286,72,'Evaluacion Parcial',0.30,10.85,'2026-11-04 13:28:23'),(287,72,'Practica 2',0.20,11.20,'2026-11-04 13:28:23'),(288,72,'Examen Final',0.30,NULL,'2026-11-04 13:28:23');
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `id_carrera` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_carrera`),
  UNIQUE KEY `codigo` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'Ingenieria de Software','SIS-01',1),(2,'Ingenieria Industrial','IND-02',1),(3,'Administracion de Empresas','ADM-03',1),(4,'Contabilidad y Finanzas','CON-04',1);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `id_carrera` int NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `creditos` int NOT NULL,
  `ciclo_nivel` int NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `fk_curso_carrera` (`id_carrera`),
  CONSTRAINT `fk_curso_carrera` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,1,'SIS-101','Introduccion a la Programacion',4,1),(2,1,'SIS-201','Programacion Orientada a Objetos',4,2),(3,1,'SIS-301','Estructuras de Datos',4,3),(4,1,'SIS-401','Bases de Datos I',4,4),(5,1,'SIS-501','Ingenieria de Software',3,5),(6,1,'SIS-601','Desarrollo de Aplicaciones Web',4,6),(7,2,'IND-101','Matematica para Ingenieria',4,1),(8,2,'IND-201','Estadistica Aplicada',3,2),(9,2,'IND-301','Investigacion de Operaciones I',4,3),(10,2,'IND-401','Gestion de Procesos',3,4),(11,3,'ADM-101','Fundamentos de Administracion',3,1),(12,3,'ADM-201','Contabilidad General',4,2),(13,3,'ADM-301','Marketing',3,3),(14,4,'CON-101','Contabilidad Basica',4,1),(15,4,'CON-201','Matematica Financiera',3,2),(16,4,'CON-301','Tributacion',4,3);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_matricula`
--

DROP TABLE IF EXISTS `detalle_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_matricula` (
  `id_detalle_matricula` int NOT NULL AUTO_INCREMENT,
  `id_matricula` int NOT NULL,
  `id_seccion` int NOT NULL,
  `promedio_final` decimal(4,2) DEFAULT NULL,
  `estado_curso` varchar(20) DEFAULT 'CURSANDO',
  PRIMARY KEY (`id_detalle_matricula`),
  KEY `fk_detalle_matricula` (`id_matricula`),
  KEY `fk_detalle_seccion` (`id_seccion`),
  CONSTRAINT `fk_detalle_matricula` FOREIGN KEY (`id_matricula`) REFERENCES `matricula` (`id_matricula`) ON DELETE CASCADE,
  CONSTRAINT `fk_detalle_seccion` FOREIGN KEY (`id_seccion`) REFERENCES `seccion` (`id_seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_matricula`
--

LOCK TABLES `detalle_matricula` WRITE;
/*!40000 ALTER TABLE `detalle_matricula` DISABLE KEYS */;
INSERT INTO `detalle_matricula` VALUES (1,1,1,11.90,'APROBADO'),(2,1,2,12.00,'APROBADO'),(3,1,3,12.10,'APROBADO'),(4,2,2,12.30,'APROBADO'),(5,2,3,12.40,'APROBADO'),(6,2,4,12.50,'APROBADO'),(7,3,3,12.70,'APROBADO'),(8,3,4,12.80,'APROBADO'),(9,3,5,12.90,'APROBADO'),(10,4,4,13.10,'APROBADO'),(11,4,5,13.20,'APROBADO'),(12,4,6,13.30,'APROBADO'),(13,5,5,13.50,'APROBADO'),(14,5,6,13.60,'APROBADO'),(15,5,1,13.10,'APROBADO'),(16,6,6,13.90,'APROBADO'),(17,6,1,13.40,'APROBADO'),(18,6,2,13.50,'APROBADO'),(19,7,9,14.50,'APROBADO'),(20,7,10,14.60,'APROBADO'),(21,7,7,14.30,'APROBADO'),(22,8,10,14.90,'APROBADO'),(23,8,7,14.60,'APROBADO'),(24,8,8,14.70,'APROBADO'),(25,9,7,14.90,'APROBADO'),(26,9,8,15.00,'APROBADO'),(27,9,9,15.10,'APROBADO'),(28,10,11,15.60,'APROBADO'),(29,10,12,15.70,'APROBADO'),(30,10,13,15.80,'APROBADO'),(31,11,12,16.00,'APROBADO'),(32,11,13,16.10,'APROBADO'),(33,11,11,15.90,'APROBADO'),(34,12,16,16.70,'APROBADO'),(35,12,14,16.50,'APROBADO'),(36,12,15,16.60,'APROBADO'),(37,13,17,NULL,'CURSANDO'),(38,13,18,NULL,'CURSANDO'),(39,13,19,NULL,'CURSANDO'),(40,14,18,NULL,'CURSANDO'),(41,14,19,NULL,'CURSANDO'),(42,14,20,NULL,'CURSANDO'),(43,15,19,NULL,'CURSANDO'),(44,15,20,NULL,'CURSANDO'),(45,15,21,NULL,'CURSANDO'),(46,16,20,NULL,'CURSANDO'),(47,16,21,NULL,'CURSANDO'),(48,16,22,NULL,'CURSANDO'),(49,17,21,NULL,'CURSANDO'),(50,17,22,NULL,'CURSANDO'),(51,17,17,NULL,'CURSANDO'),(52,18,22,NULL,'CURSANDO'),(53,18,17,NULL,'CURSANDO'),(54,18,18,NULL,'CURSANDO'),(55,19,25,NULL,'CURSANDO'),(56,19,26,NULL,'CURSANDO'),(57,19,23,NULL,'CURSANDO'),(58,20,26,NULL,'CURSANDO'),(59,20,23,NULL,'CURSANDO'),(60,20,24,NULL,'CURSANDO'),(61,21,23,NULL,'CURSANDO'),(62,21,24,NULL,'CURSANDO'),(63,21,25,NULL,'CURSANDO'),(64,22,27,NULL,'CURSANDO'),(65,22,28,NULL,'CURSANDO'),(66,22,29,NULL,'CURSANDO'),(67,23,28,NULL,'CURSANDO'),(68,23,29,NULL,'CURSANDO'),(69,23,27,NULL,'CURSANDO'),(70,24,32,NULL,'CURSANDO'),(71,24,30,NULL,'CURSANDO'),(72,24,31,NULL,'CURSANDO');
/*!40000 ALTER TABLE `detalle_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id_docente` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_docente`),
  UNIQUE KEY `id_usuario` (`id_usuario`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `fk_docente_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,13,'D1001','Ricardo','Salinas Prado','41234561','docente01@mackas.edu.pe','9800000001','Ingenieria de Software'),(2,14,'D1002','Patricia','Gomez Rivas','41234562','docente02@mackas.edu.pe','9800000002','Bases de Datos y Analitica'),(3,15,'D1003','Javier','Nunez Torres','41234563','docente03@mackas.edu.pe','9800000003','Ingenieria Industrial'),(4,16,'D1004','Claudia','Mora Espinoza','41234564','docente04@mackas.edu.pe','9800000004','Administracion y Finanzas'),(5,17,'D1005','Hector','Valdez Campos','41234565','docente05@mackas.edu.pe','9800000005','Matematica y Estadistica');
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `id_horario` int NOT NULL AUTO_INCREMENT,
  `id_seccion` int NOT NULL,
  `dia_semana` varchar(15) NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `aula` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_horario`),
  KEY `fk_horario_seccion` (`id_seccion`),
  CONSTRAINT `fk_horario_seccion` FOREIGN KEY (`id_seccion`) REFERENCES `seccion` (`id_seccion`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,1,'LUNES','08:00:00','10:00:00','A101'),(2,1,'MARTES','10:00:00','12:00:00','A101'),(3,2,'MARTES','10:00:00','12:00:00','A202'),(4,2,'MIERCOLES','14:00:00','16:00:00','A202'),(5,3,'MIERCOLES','14:00:00','16:00:00','A303'),(6,3,'JUEVES','16:00:00','18:00:00','A303'),(7,4,'JUEVES','16:00:00','18:00:00','A104'),(8,4,'VIERNES','08:00:00','10:00:00','A104'),(9,5,'VIERNES','08:00:00','10:00:00','A205'),(10,5,'LUNES','10:00:00','12:00:00','A205'),(11,6,'LUNES','10:00:00','12:00:00','A306'),(12,6,'MARTES','14:00:00','16:00:00','A306'),(13,7,'MARTES','14:00:00','16:00:00','A107'),(14,7,'MIERCOLES','16:00:00','18:00:00','A107'),(15,8,'MIERCOLES','16:00:00','18:00:00','A208'),(16,8,'JUEVES','08:00:00','10:00:00','A208'),(17,9,'JUEVES','08:00:00','10:00:00','A301'),(18,9,'VIERNES','10:00:00','12:00:00','A301'),(19,10,'VIERNES','10:00:00','12:00:00','A102'),(20,10,'LUNES','14:00:00','16:00:00','A102'),(21,11,'LUNES','14:00:00','16:00:00','A203'),(22,11,'MARTES','16:00:00','18:00:00','A203'),(23,12,'MARTES','16:00:00','18:00:00','A304'),(24,12,'MIERCOLES','08:00:00','10:00:00','A304'),(25,13,'MIERCOLES','08:00:00','10:00:00','A105'),(26,13,'JUEVES','10:00:00','12:00:00','A105'),(27,14,'JUEVES','10:00:00','12:00:00','A206'),(28,14,'VIERNES','14:00:00','16:00:00','A206'),(29,15,'VIERNES','14:00:00','16:00:00','A307'),(30,15,'LUNES','16:00:00','18:00:00','A307'),(31,16,'LUNES','16:00:00','18:00:00','A108'),(32,16,'MARTES','08:00:00','10:00:00','A108'),(33,17,'LUNES','08:00:00','10:00:00','A101'),(34,17,'MARTES','10:00:00','12:00:00','A101'),(35,18,'MARTES','10:00:00','12:00:00','A202'),(36,18,'MIERCOLES','14:00:00','16:00:00','A202'),(37,19,'MIERCOLES','14:00:00','16:00:00','A303'),(38,19,'JUEVES','16:00:00','18:00:00','A303'),(39,20,'JUEVES','16:00:00','18:00:00','A104'),(40,20,'VIERNES','08:00:00','10:00:00','A104'),(41,21,'VIERNES','08:00:00','10:00:00','A205'),(42,21,'LUNES','10:00:00','12:00:00','A205'),(43,22,'LUNES','10:00:00','12:00:00','A306'),(44,22,'MARTES','14:00:00','16:00:00','A306'),(45,23,'MARTES','14:00:00','16:00:00','A107'),(46,23,'MIERCOLES','16:00:00','18:00:00','A107'),(47,24,'MIERCOLES','16:00:00','18:00:00','A208'),(48,24,'JUEVES','08:00:00','10:00:00','A208'),(49,25,'JUEVES','08:00:00','10:00:00','A301'),(50,25,'VIERNES','10:00:00','12:00:00','A301'),(51,26,'VIERNES','10:00:00','12:00:00','A102'),(52,26,'LUNES','14:00:00','16:00:00','A102'),(53,27,'LUNES','14:00:00','16:00:00','A203'),(54,27,'MARTES','16:00:00','18:00:00','A203'),(55,28,'MARTES','16:00:00','18:00:00','A304'),(56,28,'MIERCOLES','08:00:00','10:00:00','A304'),(57,29,'MIERCOLES','08:00:00','10:00:00','A105'),(58,29,'JUEVES','10:00:00','12:00:00','A105'),(59,30,'JUEVES','10:00:00','12:00:00','A206'),(60,30,'VIERNES','14:00:00','16:00:00','A206'),(61,31,'VIERNES','14:00:00','16:00:00','A307'),(62,31,'LUNES','16:00:00','18:00:00','A307'),(63,32,'LUNES','16:00:00','18:00:00','A108'),(64,32,'MARTES','08:00:00','10:00:00','A108');
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `id_matricula` int NOT NULL AUTO_INCREMENT,
  `id_alumno` int NOT NULL,
  `id_periodo` int NOT NULL,
  `fecha_matricula` datetime DEFAULT CURRENT_TIMESTAMP,
  `monto_total` decimal(10,2) NOT NULL,
  `estado` varchar(20) DEFAULT 'REGISTRADA',
  PRIMARY KEY (`id_matricula`),
  UNIQUE KEY `uk_alumno_periodo` (`id_alumno`,`id_periodo`),
  KEY `fk_matricula_periodo` (`id_periodo`),
  CONSTRAINT `fk_matricula_alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  CONSTRAINT `fk_matricula_periodo` FOREIGN KEY (`id_periodo`) REFERENCES `periodo_academico` (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,1,1,'2026-11-04 13:28:23',475.00,'REGISTRADA'),(2,2,1,'2026-11-04 13:28:23',500.00,'REGISTRADA'),(3,3,1,'2026-11-04 13:28:23',525.00,'REGISTRADA'),(4,4,1,'2026-11-04 13:28:23',450.00,'REGISTRADA'),(5,5,1,'2026-11-04 13:28:23',475.00,'REGISTRADA'),(6,6,1,'2026-11-04 13:28:23',500.00,'REGISTRADA'),(7,7,1,'2026-11-04 13:28:23',525.00,'REGISTRADA'),(8,8,1,'2026-11-04 13:28:23',450.00,'REGISTRADA'),(9,9,1,'2026-11-04 13:28:23',475.00,'REGISTRADA'),(10,10,1,'2026-11-04 13:28:23',500.00,'REGISTRADA'),(11,11,1,'2026-11-04 13:28:23',525.00,'REGISTRADA'),(12,12,1,'2026-11-04 13:28:23',450.00,'REGISTRADA'),(13,1,2,'2026-11-04 13:28:23',475.00,'REGISTRADA'),(14,2,2,'2026-11-04 13:28:23',500.00,'REGISTRADA'),(15,3,2,'2026-11-04 13:28:23',525.00,'REGISTRADA'),(16,4,2,'2026-11-04 13:28:23',450.00,'REGISTRADA'),(17,5,2,'2026-11-04 13:28:23',475.00,'REGISTRADA'),(18,6,2,'2026-11-04 13:28:23',500.00,'REGISTRADA'),(19,7,2,'2026-11-04 13:28:23',525.00,'REGISTRADA'),(20,8,2,'2026-11-04 13:28:23',450.00,'REGISTRADA'),(21,9,2,'2026-11-04 13:28:23',475.00,'REGISTRADA'),(22,10,2,'2026-11-04 13:28:23',500.00,'REGISTRADA'),(23,11,2,'2026-11-04 13:28:23',525.00,'REGISTRADA'),(24,12,2,'2026-11-04 13:28:23',450.00,'REGISTRADA');
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pension`
--

DROP TABLE IF EXISTS `pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pension` (
  `id_pension` int NOT NULL AUTO_INCREMENT,
  `id_alumno` int NOT NULL,
  `id_matricula` int NOT NULL,
  `numero_cuota` int NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `monto_mora` decimal(10,2) DEFAULT '0.00',
  `fecha_vencimiento` date NOT NULL,
  `fecha_pago` datetime DEFAULT NULL,
  `estado` varchar(20) DEFAULT 'PENDIENTE',
  PRIMARY KEY (`id_pension`),
  KEY `fk_pension_alumno` (`id_alumno`),
  KEY `fk_pension_matricula` (`id_matricula`),
  CONSTRAINT `fk_pension_alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  CONSTRAINT `fk_pension_matricula` FOREIGN KEY (`id_matricula`) REFERENCES `matricula` (`id_matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pension`
--

LOCK TABLES `pension` WRITE;
/*!40000 ALTER TABLE `pension` DISABLE KEYS */;
INSERT INTO `pension` VALUES (1,1,1,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(2,1,1,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(3,1,1,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(4,1,1,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(5,1,1,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(6,2,2,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(7,2,2,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(8,2,2,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(9,2,2,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(10,2,2,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(11,3,3,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(12,3,3,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(13,3,3,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(14,3,3,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(15,3,3,5,90.00,0.00,'2026-07-30','2026-07-15 10:30:00','PAGADO'),(16,4,4,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(17,4,4,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(18,4,4,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(19,4,4,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(20,4,4,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(21,5,5,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(22,5,5,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(23,5,5,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(24,5,5,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(25,5,5,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(26,6,6,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(27,6,6,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(28,6,6,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(29,6,6,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(30,6,6,5,90.00,0.00,'2026-07-30','2026-07-15 10:30:00','PAGADO'),(31,7,7,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(32,7,7,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(33,7,7,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(34,7,7,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(35,7,7,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(36,8,8,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(37,8,8,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(38,8,8,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(39,8,8,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(40,8,8,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(41,9,9,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(42,9,9,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(43,9,9,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(44,9,9,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(45,9,9,5,90.00,0.00,'2026-07-30','2026-07-15 10:30:00','PAGADO'),(46,10,10,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(47,10,10,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(48,10,10,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(49,10,10,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(50,10,10,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(51,11,11,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(52,11,11,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(53,11,11,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(54,11,11,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(55,11,11,5,90.00,0.00,'2026-07-30',NULL,'PENDIENTE'),(56,12,12,1,90.00,0.00,'2026-03-30','2026-03-15 10:30:00','PAGADO'),(57,12,12,2,90.00,0.00,'2026-04-30','2026-04-15 10:30:00','PAGADO'),(58,12,12,3,90.00,0.00,'2026-05-30','2026-05-15 10:30:00','PAGADO'),(59,12,12,4,90.00,0.00,'2026-06-30','2026-06-15 10:30:00','PAGADO'),(60,12,12,5,90.00,0.00,'2026-07-30','2026-07-15 10:30:00','PAGADO'),(61,1,13,1,90.00,10.00,'2026-08-30',NULL,'VENCIDO'),(62,1,13,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(63,1,13,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(64,1,13,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(65,1,13,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(66,2,14,1,90.00,0.00,'2026-08-30','2026-08-15 10:30:00','PAGADO'),(67,2,14,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(68,2,14,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(69,2,14,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(70,2,14,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(71,3,15,1,90.00,10.00,'2026-08-30',NULL,'VENCIDO'),(72,3,15,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(73,3,15,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(74,3,15,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(75,3,15,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(76,4,16,1,90.00,0.00,'2026-08-30','2026-08-15 10:30:00','PAGADO'),(77,4,16,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(78,4,16,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(79,4,16,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(80,4,16,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(81,5,17,1,90.00,10.00,'2026-08-30',NULL,'VENCIDO'),(82,5,17,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(83,5,17,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(84,5,17,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(85,5,17,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(86,6,18,1,90.00,0.00,'2026-08-30','2026-08-15 10:30:00','PAGADO'),(87,6,18,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(88,6,18,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(89,6,18,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(90,6,18,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(91,7,19,1,90.00,10.00,'2026-08-30',NULL,'VENCIDO'),(92,7,19,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(93,7,19,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(94,7,19,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(95,7,19,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(96,8,20,1,90.00,0.00,'2026-08-30','2026-08-15 10:30:00','PAGADO'),(97,8,20,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(98,8,20,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(99,8,20,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(100,8,20,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(101,9,21,1,90.00,10.00,'2026-08-30',NULL,'VENCIDO'),(102,9,21,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(103,9,21,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(104,9,21,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(105,9,21,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(106,10,22,1,90.00,0.00,'2026-08-30','2026-08-15 10:30:00','PAGADO'),(107,10,22,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(108,10,22,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(109,10,22,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(110,10,22,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(111,11,23,1,90.00,10.00,'2026-08-30',NULL,'VENCIDO'),(112,11,23,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(113,11,23,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(114,11,23,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(115,11,23,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE'),(116,12,24,1,90.00,0.00,'2026-08-30','2026-08-15 10:30:00','PAGADO'),(117,12,24,2,90.00,0.00,'2026-09-30',NULL,'PENDIENTE'),(118,12,24,3,90.00,0.00,'2026-10-30',NULL,'PENDIENTE'),(119,12,24,4,90.00,0.00,'2026-11-30',NULL,'PENDIENTE'),(120,12,24,5,90.00,0.00,'2026-12-30',NULL,'PENDIENTE');
/*!40000 ALTER TABLE `pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo_academico`
--

DROP TABLE IF EXISTS `periodo_academico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo_academico` (
  `id_periodo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo_academico`
--

LOCK TABLES `periodo_academico` WRITE;
/*!40000 ALTER TABLE `periodo_academico` DISABLE KEYS */;
INSERT INTO `periodo_academico` VALUES (1,'2026-I','2026-03-01','2026-07-31',0),(2,'2026-II','2026-08-15','2026-12-20',1),(3,'2027-I','2027-03-01','2027-07-31',0);
/*!40000 ALTER TABLE `periodo_academico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion` (
  `id_seccion` int NOT NULL AUTO_INCREMENT,
  `id_curso` int NOT NULL,
  `id_docente` int DEFAULT NULL,
  `id_periodo` int NOT NULL,
  `codigo_seccion` varchar(20) NOT NULL,
  `aula` varchar(50) DEFAULT NULL,
  `cupo_maximo` int DEFAULT '40',
  PRIMARY KEY (`id_seccion`),
  KEY `fk_seccion_curso` (`id_curso`),
  KEY `fk_seccion_docente` (`id_docente`),
  KEY `fk_seccion_periodo` (`id_periodo`),
  CONSTRAINT `fk_seccion_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `fk_seccion_docente` FOREIGN KEY (`id_docente`) REFERENCES `docente` (`id_docente`),
  CONSTRAINT `fk_seccion_periodo` FOREIGN KEY (`id_periodo`) REFERENCES `periodo_academico` (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,1,1,1,'101','A101',35),(2,2,2,1,'102','A202',40),(3,3,3,1,'103','A303',30),(4,4,4,1,'104','A104',35),(5,5,5,1,'105','A205',40),(6,6,1,1,'106','A306',30),(7,7,2,1,'107','A107',35),(8,8,3,1,'108','A208',40),(9,9,4,1,'109','A301',30),(10,10,5,1,'110','A102',35),(11,11,1,1,'111','A203',40),(12,12,2,1,'112','A304',30),(13,13,3,1,'113','A105',35),(14,14,4,1,'114','A206',40),(15,15,5,1,'115','A307',30),(16,16,1,1,'116','A108',35),(17,1,2,2,'201','A101',35),(18,2,3,2,'202','A202',40),(19,3,4,2,'203','A303',30),(20,4,5,2,'204','A104',35),(21,5,1,2,'205','A205',40),(22,6,2,2,'206','A306',30),(23,7,3,2,'207','A107',35),(24,8,4,2,'208','A208',40),(25,9,5,2,'209','A301',30),(26,10,1,2,'210','A102',35),(27,11,2,2,'211','A203',40),(28,12,3,2,'212','A304',30),(29,13,4,2,'213','A105',35),(30,14,5,2,'214','A206',40),(31,15,1,2,'215','A307',30),(32,16,2,2,'216','A108',35);
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `rol` enum('ALUMNO','DOCENTE','ADMIN') NOT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'U100001','123','ALUMNO',1),(2,'U100002','123','ALUMNO',1),(3,'U100003','123','ALUMNO',1),(4,'U100004','123','ALUMNO',1),(5,'U100005','123','ALUMNO',1),(6,'U100006','123','ALUMNO',1),(7,'U100007','123','ALUMNO',1),(8,'U100008','123','ALUMNO',1),(9,'U100009','123','ALUMNO',1),(10,'U100010','123','ALUMNO',1),(11,'U100011','123','ALUMNO',1),(12,'U100012','123','ALUMNO',1),(13,'D1001','123','DOCENTE',1),(14,'D1002','123','DOCENTE',1),(15,'D1003','123','DOCENTE',1),(16,'D1004','123','DOCENTE',1),(17,'D1005','123','DOCENTE',1),(18,'admin','123','ADMIN',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_sistema_uni_test'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_alumno_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_alumno_usuario`(IN p_id_usuario INT)
BEGIN
    SELECT 
        a.id_alumno, 
        a.id_carrera,
        a.nombres, 
        a.apellidos, 
        a.dni, 
        a.email, 
        a.telefono,
        a.fecha_nacimiento
    FROM alumno a
    JOIN usuario u ON a.id_usuario = u.id_usuario
    WHERE u.id_usuario = p_id_usuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_calificar_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_calificar_alumno`(    
    IN p_id_detalle_matricula INT,
    IN p_nombre_evaluacion VARCHAR(50),
    IN p_nota DECIMAL(4,2),
    IN p_ponderado DECIMAL(5,2)
)
BEGIN
    INSERT INTO calificacion (
        id_detalle_matricula, 
        nombre_evaluacion, 
        ponderado, 
        nota
    ) 
    VALUES (
        p_id_detalle_matricula, 
        p_nombre_evaluacion, 
        p_ponderado, 
        p_nota
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_detalle_matricula_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_detalle_matricula_alumno`(
    IN p_id_matricula INT,
    IN p_id_seccion INT
)
BEGIN
    INSERT INTO detalle_matricula (id_matricula, id_seccion, promedio_final, estado_curso) 
    VALUES (p_id_matricula, p_id_seccion, NULL, 'CURSANDO');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_docente_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_docente_usuario`(IN p_id_usuario INT)
BEGIN
    SELECT d.*
    FROM docente d
    JOIN usuario u ON d.id_usuario = u.id_usuario
    WHERE u.id_usuario = p_id_usuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_alumnos_seccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_alumnos_seccion`(IN p_id_seccion INT)
BEGIN
    SELECT 
        a.id_alumno, 
        a.id_carrera,
        a.nombres, 
        a.apellidos, 
        a.dni, 
        a.email, 
        a.telefono,
        a.fecha_nacimiento
    FROM alumno a
    JOIN matricula m ON a.id_alumno = m.id_alumno
    JOIN detalle_matricula dm ON m.id_matricula = dm.id_matricula
    WHERE dm.id_seccion = p_id_seccion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_calificacion_curso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_calificacion_curso`(
    IN p_id_curso INT,
    IN p_id_alumno INT
)
BEGIN
    SELECT 
        c.id_calificacion,
        c.id_detalle_matricula,
        c.nombre_evaluacion,
        c.ponderado,
        c.nota,
        c.fecha_registro
    FROM calificacion c
    JOIN detalle_matricula dt ON c.id_detalle_matricula = dt.id_detalle_matricula
    JOIN matricula m ON dt.id_matricula = m.id_matricula       
    JOIN seccion sc ON dt.id_seccion = sc.id_seccion
    JOIN curso cu ON sc.id_curso = cu.id_curso
    WHERE cu.id_curso = p_id_curso 
      AND m.id_alumno = p_id_alumno;                       
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_cursos_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_cursos_alumno`(IN p_id_alumno INT)
BEGIN
    SELECT 
        c.id_curso,
        c.id_carrera,
        c.codigo AS codigo_curso,
        c.nombre AS nombre_curso,
        c.creditos,
        c.ciclo_nivel
    FROM curso c
    JOIN seccion s ON c.id_curso = s.id_curso
    JOIN detalle_matricula dm ON s.id_seccion = dm.id_seccion
    JOIN matricula m ON dm.id_matricula = m.id_matricula
    JOIN periodo_academico p ON s.id_periodo = p.id_periodo
    WHERE m.id_alumno = p_id_alumno;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_horarios_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_horarios_alumno`(IN p_id_alumno INT)
BEGIN
    SELECT 
        h.id_horario,
        h.id_seccion,
        h.dia_semana,
        h.hora_inicio,
        h.hora_fin,
        h.aula
    FROM horario h
    JOIN detalle_matricula dt ON h.id_seccion = dt.id_seccion
    JOIN matricula m ON dt.id_matricula = m.id_matricula   
    WHERE m.id_alumno = p_id_alumno;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_periodo_academico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_periodo_academico`()
BEGIN
    SELECT * FROM periodo_academico;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_secciones_docente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_secciones_docente`(IN p_id_docente INT)
BEGIN
    SELECT 
        s.id_seccion,
        s.id_curso,
        s.codigo_seccion,
        s.aula,
        s.id_periodo,
        s.cupo_maximo
    FROM seccion s
    WHERE s.id_docente = p_id_docente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_secciones_periodo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_secciones_periodo`(IN p_id_periodo INT)
BEGIN
    SELECT 
        s.id_seccion,
        s.id_curso,
        s.codigo_seccion,
        s.aula,
        s.id_periodo,
        s.cupo_maximo
    FROM seccion s
    WHERE s.id_periodo = p_id_periodo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_login`(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT 
        id_usuario,
        username,
        password_hash,
        rol,
        estado
    FROM usuario
    WHERE username = p_username 
      AND password_hash = p_password 
      AND estado = TRUE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_matricular_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_matricular_alumno`(    
    IN p_id_alumno INT,
    IN p_id_periodo INT,
    IN p_monto_total DECIMAL(10,2)
)
BEGIN
    INSERT INTO matricula (id_alumno, id_periodo, fecha_matricula, monto_total, estado) 
    VALUES (p_id_alumno, p_id_periodo, NOW(), p_monto_total, 'REGISTRADA');
    
    -- Retorna el ID generado para que Java lo lea
    SELECT LAST_INSERT_ID() AS id_matricula;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_matricula_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_matricula_alumno`(IN p_id_alumno INT)
BEGIN
    SELECT *
    FROM matricula m
    WHERE m.id_alumno = p_id_alumno;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pagar_pension_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pagar_pension_alumno`(
    IN p_id_alumno INT,
    IN p_id_pension INT,
    IN p_fecha_pago DATETIME
)
BEGIN
    UPDATE pension
    SET estado = 'PAGADO',
        fecha_pago = p_fecha_pago
    WHERE id_alumno = p_id_alumno
      AND id_pension = p_id_pension;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pensiones_pendientes_alumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pensiones_pendientes_alumno`(IN p_id_alumno INT)
BEGIN
    SELECT 
        id_pension,
        id_alumno,
        id_matricula,
        numero_cuota,
        monto,
        monto_mora,
        fecha_vencimiento,
        fecha_pago,
        estado
    FROM pension
    WHERE id_alumno = p_id_alumno 
      AND estado = 'PENDIENTE'
    ORDER BY numero_cuota ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_procesar_pago_pension` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_procesar_pago_pension`(
    IN p_id_pension INT,
    IN p_monto_pagado DECIMAL(10,2),
    IN p_monto_mora DECIMAL(10,2)
)
BEGIN
    DECLARE v_estado VARCHAR(20);
    SELECT estado INTO v_estado FROM pension WHERE id_pension = p_id_pension;

    IF v_estado = 'PENDIENTE' THEN
        UPDATE pension 
        SET estado = 'PAGADO',
            monto_mora = p_monto_mora,
            fecha_pago = NOW()
        WHERE id_pension = p_id_pension;
        
        SELECT 'SUCCESS' AS resultado, 'Pago registrado correctamente.' AS mensaje;
    ELSE
        SELECT 'ERROR' AS resultado, 'La pensión ya fue pagada o no existe.' AS mensaje;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-04 13:35:03
