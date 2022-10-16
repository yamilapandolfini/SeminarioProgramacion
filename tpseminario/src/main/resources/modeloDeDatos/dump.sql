-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: grupotp
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `aseguradora`
--

DROP TABLE IF EXISTS `aseguradora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aseguradora` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aseguradora`
--

LOCK TABLES `aseguradora` WRITE;
/*!40000 ALTER TABLE `aseguradora` DISABLE KEYS */;
INSERT INTO `aseguradora` VALUES (0,'SANCOR'),(1,'FEDERACION PATRONAL'),(2,'LA SEGUNDA');
/*!40000 ALTER TABLE `aseguradora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `APELLIDO` varchar(50) DEFAULT NULL,
  `TIPO_DOCUMENTO` int DEFAULT NULL,
  `DOCUMENTO` int DEFAULT NULL,
  `TELEFONO` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'CRISTIAN','RODRIGUEZ',0,29844123,54413321),(2,'SOFIA','MARQUEZ',0,33012442,44227742),(3,'OSCAR','BERTOLDO',0,22454775,40405543);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insumo` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `MARCA` varchar(50) DEFAULT NULL,
  `MODELO` varchar(50) DEFAULT NULL,
  `NUMEROPARTE` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
INSERT INTO `insumo` VALUES (1,'FILTRO DE AIRE','K6N','BICONICO',995050),(2,'FILTRO ACEITE','HONDA','PLM2',984432),(3,'ESCOBILLAS','FORD','FLEX',124633);
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanico`
--

DROP TABLE IF EXISTS `mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanico` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `APELLIDO` varchar(50) DEFAULT NULL,
  `TIPODOCUMENTO` int DEFAULT NULL,
  `NUMERODOCUMENTO` int DEFAULT NULL,
  `LEGAJO` int DEFAULT NULL,
  `ESPECIALIDAD` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanico`
--

LOCK TABLES `mecanico` WRITE;
/*!40000 ALTER TABLE `mecanico` DISABLE KEYS */;
INSERT INTO `mecanico` VALUES (1,'JUAN','PEREZ',0,12345678,45678,0),(2,'MARIA','LOPEZ',0,25738924,23414,1),(3,'JOSE','ROBLES',0,14532562,35262,2),(4,'JULIA','FLORES',0,45325527,34235,3),(5,'ROBERTO','IGLESIAS',0,36343426,35256,4),(6,'ANA','BELEN',0,45523425,23525,5);
/*!40000 ALTER TABLE `mecanico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CONFORME` tinyint DEFAULT NULL,
  `COMENTARIOS` varchar(250) DEFAULT NULL,
  `TURNO_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SERVICIO_TURNO_idx` (`TURNO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,1,'',2),(2,0,NULL,3);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_insumo`
--

DROP TABLE IF EXISTS `servicio_insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio_insumo` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SERVICIO_ID` int DEFAULT NULL,
  `INSUMOS_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SERVICIO_INSUMO_SERVICIO_idx` (`SERVICIO_ID`),
  KEY `FK_SERVICIO_INSUMO_INSUMO` (`INSUMOS_ID`),
  CONSTRAINT `FK_SERVICIO_INSUMO_INSUMO` FOREIGN KEY (`INSUMOS_ID`) REFERENCES `insumo` (`ID`),
  CONSTRAINT `FK_SERVICIO_INSUMO_SERVICIO` FOREIGN KEY (`SERVICIO_ID`) REFERENCES `servicio` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_insumo`
--

LOCK TABLES `servicio_insumo` WRITE;
/*!40000 ALTER TABLE `servicio_insumo` DISABLE KEYS */;
INSERT INTO `servicio_insumo` VALUES (1,1,2);
/*!40000 ALTER TABLE `servicio_insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_servicios`
--

DROP TABLE IF EXISTS `servicio_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio_servicios` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SERVICIO_ID` int DEFAULT NULL,
  `SERVICIOS_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SERVICIO_SERVICIOS_SERVICIO` (`SERVICIO_ID`),
  KEY `FK_SERVICIO_SERVICIOS_SERVICIOS` (`SERVICIOS_ID`),
  CONSTRAINT `FK_SERVICIO_SERVICIOS_SERVICIO` FOREIGN KEY (`SERVICIO_ID`) REFERENCES `servicios` (`ID`),
  CONSTRAINT `FK_SERVICIO_SERVICIOS_SERVICIOS` FOREIGN KEY (`SERVICIOS_ID`) REFERENCES `servicios` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_servicios`
--

LOCK TABLES `servicio_servicios` WRITE;
/*!40000 ALTER TABLE `servicio_servicios` DISABLE KEYS */;
INSERT INTO `servicio_servicios` VALUES (2,5,3),(3,5,4);
/*!40000 ALTER TABLE `servicio_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_trabajo`
--

DROP TABLE IF EXISTS `servicio_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio_trabajo` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SERVICIO_ID` int DEFAULT NULL,
  `TRABAJOS_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SERVICIO_TRABAJO_SERVICIO_idx` (`SERVICIO_ID`),
  KEY `FK_SERVICIO_TRABAJO_TRABAJO` (`TRABAJOS_ID`),
  CONSTRAINT `FK_SERVICIO_TRABAJO_SERVICIO` FOREIGN KEY (`SERVICIO_ID`) REFERENCES `servicio` (`ID`),
  CONSTRAINT `FK_SERVICIO_TRABAJO_TRABAJO` FOREIGN KEY (`TRABAJOS_ID`) REFERENCES `trabajo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_trabajo`
--

LOCK TABLES `servicio_trabajo` WRITE;
/*!40000 ALTER TABLE `servicio_trabajo` DISABLE KEYS */;
INSERT INTO `servicio_trabajo` VALUES (1,1,2);
/*!40000 ALTER TABLE `servicio_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SERVICIO` varchar(45) DEFAULT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (3,'ALINEACION','Alineación 4 ruedas'),(4,'BALANCEO','Balanceo 4 ruedas'),(5,'FILTROS','Cambio de filtros');
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajo`
--

DROP TABLE IF EXISTS `trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajo` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TRABAJO` varchar(45) DEFAULT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajo`
--

LOCK TABLES `trabajo` WRITE;
/*!40000 ALTER TABLE `trabajo` DISABLE KEYS */;
INSERT INTO `trabajo` VALUES (1,'ALINEACION','ALINEACION 4 RUEDAS'),(2,'BALANCEO','BALANCEO 4 RUEDAS'),(3,'FILTROS','CAMBIO DE FILTROS'),(4,'ACEITE','CAMBIO DE ACEITE');
/*!40000 ALTER TABLE `trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CLIENTE_ID` int DEFAULT NULL,
  `VEHICULO_ID` int DEFAULT NULL,
  `MECANICO_ID` int DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `HORARIO` time DEFAULT NULL,
  `ESTADO` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TURNO_CLIENTE` (`CLIENTE_ID`),
  KEY `FK_TURNO_VEHICULO` (`VEHICULO_ID`),
  KEY `FK_TURNO_MECANICO` (`MECANICO_ID`),
  CONSTRAINT `FK_TURNO_CLIENTE` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `FK_TURNO_MECANICO` FOREIGN KEY (`MECANICO_ID`) REFERENCES `mecanico` (`ID`),
  CONSTRAINT `FK_TURNO_VEHICULO` FOREIGN KEY (`VEHICULO_ID`) REFERENCES `vehiculo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,1,1,1,'2022-10-22','11:00:00',2),(2,2,2,3,'2022-10-17','11:00:00',6),(3,3,3,5,'2022-10-19','15:00:00',6);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `APELLIDO` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(150) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `USUARIO_ID` int NOT NULL,
  `ROL_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_USUARIO_ROL_USUARIO` (`USUARIO_ID`),
  KEY `FK_USUARIO_ROL_ROL` (`ROL_ID`),
  CONSTRAINT `FK_USUARIO_ROL_ROL` FOREIGN KEY (`ROL_ID`) REFERENCES `rol` (`ID`),
  CONSTRAINT `FK_USUARIO_ROL_USUARIO` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MARCA` varchar(50) DEFAULT NULL,
  `MODELO` varchar(50) DEFAULT NULL,
  `ANOFABRICACION` int DEFAULT NULL,
  `PATENTE` varchar(15) DEFAULT NULL,
  `NUMEROPOLIZA` varchar(50) DEFAULT NULL,
  `CLIENTE_ID` int DEFAULT NULL,
  `ASEGURADORA_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_VEHICULO_CLIENTE` (`CLIENTE_ID`),
  KEY `FK_VEHICULO_ASEGURADORA_idx` (`ASEGURADORA_ID`),
  CONSTRAINT `FK_VEHICULO_ASEGURADORA` FOREIGN KEY (`ASEGURADORA_ID`) REFERENCES `aseguradora` (`ID`),
  CONSTRAINT `FK_VEHICULO_CLIENTE` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'MAZDA','MIATA',2002,'TRA-441','TTA-343-G',1,0),(2,'JEEP','RENEGADE',2020,'AC442MA','TTS-554-T',2,2),(3,'FIAT','DUNA',1996,'SHR532','FRA-001-S',3,1);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-16  0:04:32
