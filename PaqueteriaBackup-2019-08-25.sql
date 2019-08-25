-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: paquetes
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `codigo` int(11) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `nit` int(11) DEFAULT NULL,
  `nombre` varchar(35) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (440000,'4-32 Zona2 Quetzaltenango',123456789,'Pedro Sanchez'),(440001,'7-28 Zona2 San Juan',123456790,'Juan Perez'),(440002,'1-20 Zona2 San Juan',123456791,'Jose Gonzalez'),(440003,'3-18 Zona2 Salcaja',123456792,'Josh Perez'),(440004,'4-20 Zona2 Salcaja',111222333,'Jorge Lopez');
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Destino`
--

DROP TABLE IF EXISTS `Destino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Destino` (
  `nombre` varchar(15) NOT NULL,
  `codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Destino`
--

LOCK TABLES `Destino` WRITE;
/*!40000 ALTER TABLE `Destino` DISABLE KEYS */;
INSERT INTO `Destino` VALUES ('Quetzaltenango',330000),('Mexico',330001),('San Juan',330002),('USA',330003),('Honduras',330004);
/*!40000 ALTER TABLE `Destino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paquete`
--

DROP TABLE IF EXISTS `Paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Paquete` (
  `codigo` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `codigoRuta` int(11) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `priorizado` tinyint(1) NOT NULL,
  `fechaIngreso` datetime DEFAULT NULL,
  `fechaRecibido` datetime DEFAULT NULL,
  `numeroENCola` int(11) DEFAULT NULL,
  `codigoPunto` int(11) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `precioPerdido` float DEFAULT NULL,
  `preciopagado` float DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_RUTA_CODIGO_PACK` (`codigoRuta`),
  KEY `FK_CLIENTE_CODIGO` (`codigoCliente`),
  KEY `FK_PUNTODECONTROL_CODIGO_PACK` (`codigoPunto`),
  CONSTRAINT `FK_CLIENTE_CODIGO` FOREIGN KEY (`codigoCliente`) REFERENCES `Cliente` (`codigo`),
  CONSTRAINT `FK_PUNTODECONTROL_CODIGO_PACK` FOREIGN KEY (`codigoPunto`) REFERENCES `PuntoDeControl` (`codigo`),
  CONSTRAINT `FK_RUTA_CODIGO_PACK` FOREIGN KEY (`codigoRuta`) REFERENCES `Ruta` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paquete`
--

LOCK TABLES `Paquete` WRITE;
/*!40000 ALTER TABLE `Paquete` DISABLE KEYS */;
INSERT INTO `Paquete` VALUES (550000,7,110000,440000,0,'2019-08-18 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,10,8),(550001,2,110001,440001,0,'2019-08-19 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,9,7),(550002,3,110002,440002,0,'2019-08-20 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,10,7),(550003,4,110003,440003,0,'2019-08-21 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,10.5,8),(550004,2,110004,440004,0,'2019-08-18 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,10,8),(550005,3,110000,440000,0,'2019-08-19 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,9,8),(550006,4,110001,440001,0,'2019-08-20 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,15,7),(550007,5,110002,440002,0,'2019-08-21 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,10,8),(550008,6,110003,440003,0,'2019-08-18 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,8,6),(550009,2,110004,440004,0,'2019-08-19 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,12,7),(550010,3,110000,440000,0,'2019-08-20 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,12.45,6),(550011,4,110001,440001,0,'2019-08-21 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,12,6.5),(550012,6,110002,440002,0,'2019-08-18 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,10,8.25),(550013,3,110003,440003,0,'2019-08-19 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,11,8),(550014,2,110004,440004,0,'2019-08-20 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,10,8.45),(550015,4,110000,440000,0,'2019-08-21 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,13,8),(550016,2,110001,440001,0,'2019-08-18 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,10,8),(550017,3,110002,440002,0,'2019-08-19 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,15,7.8),(550018,4,110003,440003,0,'2019-08-20 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,10,8),(550019,2,110004,440004,0,'2019-08-21 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,10,8),(550020,3,110000,440000,0,'2019-08-18 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,9,6),(550021,4,110001,440001,0,'2019-08-18 00:00:00','2019-08-25 00:00:00',NULL,NULL,4,10,5.89),(550022,2,110001,440002,0,'2019-08-18 00:00:00','2019-08-24 00:00:00',NULL,NULL,4,12,8),(550023,3,110001,440003,0,'2019-08-19 00:00:00','2019-08-22 00:00:00',NULL,NULL,4,13,6),(550024,4,110000,440004,0,'2019-08-18 00:00:00','2019-08-23 00:00:00',NULL,NULL,4,10,8),(550025,5,110002,440001,0,'2019-08-23 00:00:00',NULL,1,220008,2,30,0),(550026,4,110003,440002,0,'2019-08-23 00:00:00',NULL,1,220012,2,30,0),(550027,8,110004,440003,1,'2019-08-23 00:00:00',NULL,1,220016,2,29.25,0),(550028,4,110000,440004,0,'2019-08-23 00:00:00',NULL,1,220000,2,32,0),(550029,3,110001,440000,0,'2019-08-23 00:00:00',NULL,1,220004,2,34,0),(550030,2,110001,440001,0,'2019-08-24 00:00:00',NULL,2,220004,2,25,0),(550031,5,110000,440002,1,'2019-08-24 00:00:00',NULL,2,220000,2,30,0),(550032,3,110000,440003,0,'2019-08-22 00:00:00',NULL,3,220001,2,36,4),(550033,7,110002,440004,0,'2019-08-24 00:00:00',NULL,2,220008,2,31.5,0),(550034,6,110000,440000,0,'2019-08-22 00:00:00',NULL,1,220001,2,30,5),(550035,4,110002,440001,0,'2019-08-22 00:00:00',NULL,1,220009,2,30,2),(550036,2,110000,440002,0,'2019-08-22 00:00:00',NULL,2,220001,2,30.4,4.25),(550037,3,110000,440003,0,'2019-08-21 00:00:00',NULL,1,220002,2,30.8,8),(550038,4,110004,440004,0,'2019-08-24 00:00:00',NULL,2,220016,2,33.3,0),(550039,4,110000,440000,0,'2019-08-21 00:00:00',NULL,1,220003,2,30,10);
/*!40000 ALTER TABLE `Paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PrecioDestino`
--

DROP TABLE IF EXISTS `PrecioDestino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PrecioDestino` (
  `fecha` datetime NOT NULL,
  `tarifa` float DEFAULT NULL,
  `codigoDestino` int(11) DEFAULT NULL,
  PRIMARY KEY (`fecha`),
  KEY `FK_DESTINO_CODIGO_P` (`codigoDestino`),
  CONSTRAINT `FK_DESTINO_CODIGO_P` FOREIGN KEY (`codigoDestino`) REFERENCES `Destino` (`codigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PrecioDestino`
--

LOCK TABLES `PrecioDestino` WRITE;
/*!40000 ALTER TABLE `PrecioDestino` DISABLE KEYS */;
INSERT INTO `PrecioDestino` VALUES ('2019-08-05 00:00:00',15.25,330000),('2019-08-22 00:00:00',20,330004),('2019-08-23 00:00:00',10,330002),('2019-08-24 00:00:00',25,330001),('2019-08-24 10:00:00',40.45,330003);
/*!40000 ALTER TABLE `PrecioDestino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PrecioPunto`
--

DROP TABLE IF EXISTS `PrecioPunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PrecioPunto` (
  `fecha` datetime NOT NULL,
  `tarifa` float DEFAULT NULL,
  `codigoPuntoDeControl` int(11) DEFAULT NULL,
  PRIMARY KEY (`fecha`),
  KEY `FK_PUNTODECONTROL_CODIGO` (`codigoPuntoDeControl`),
  CONSTRAINT `FK_PUNTODECONTROL_CODIGO` FOREIGN KEY (`codigoPuntoDeControl`) REFERENCES `PuntoDeControl` (`codigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PrecioPunto`
--

LOCK TABLES `PrecioPunto` WRITE;
/*!40000 ALTER TABLE `PrecioPunto` DISABLE KEYS */;
INSERT INTO `PrecioPunto` VALUES ('2019-08-20 00:00:00',4,220000),('2019-08-20 08:00:00',5.45,220013),('2019-08-20 10:00:00',6,220007),('2019-08-21 00:00:00',3.9,220002),('2019-08-21 08:00:00',5.45,220014),('2019-08-21 10:00:00',4.45,220012),('2019-08-22 00:00:00',5.9,220001),('2019-08-22 08:00:00',5.45,220015),('2019-08-22 10:00:00',5.45,220008),('2019-08-23 00:00:00',6,220003),('2019-08-23 08:00:00',5.45,220016),('2019-08-23 10:00:00',4.8,220009),('2019-08-24 00:00:00',5.45,220004),('2019-08-24 08:00:00',5.45,220017),('2019-08-24 10:00:00',5.45,220010),('2019-08-25 00:00:00',5.45,220005),('2019-08-25 08:00:00',5.45,220018),('2019-08-25 10:00:00',5.45,220011),('2019-08-26 00:00:00',5.45,220006),('2019-08-26 08:00:00',5.45,220019);
/*!40000 ALTER TABLE `PrecioPunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PreciosAdmin`
--

DROP TABLE IF EXISTS `PreciosAdmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PreciosAdmin` (
  `fecha` datetime NOT NULL,
  `porLibra` float DEFAULT NULL,
  `porPriorizacion` float DEFAULT NULL,
  `porOperacion` float DEFAULT NULL,
  PRIMARY KEY (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PreciosAdmin`
--

LOCK TABLES `PreciosAdmin` WRITE;
/*!40000 ALTER TABLE `PreciosAdmin` DISABLE KEYS */;
INSERT INTO `PreciosAdmin` VALUES ('2019-08-12 10:40:00',12,5,10.25),('2019-08-12 11:06:00',12,5,11.35),('2019-08-12 18:43:49',13,6,11.45);
/*!40000 ALTER TABLE `PreciosAdmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PuntoDeControl`
--

DROP TABLE IF EXISTS `PuntoDeControl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PuntoDeControl` (
  `codigo` int(11) NOT NULL,
  `numeroEnRuta` int(11) NOT NULL,
  `codigoRuta` int(11) NOT NULL,
  `cantidadDePaquetes` int(11) NOT NULL,
  `userNameUsuario` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_RUTA_CODIGO` (`codigoRuta`),
  KEY `FK_USUARIO_USERNAME` (`userNameUsuario`),
  CONSTRAINT `FK_RUTA_CODIGO` FOREIGN KEY (`codigoRuta`) REFERENCES `Ruta` (`codigo`) ON DELETE CASCADE,
  CONSTRAINT `FK_USUARIO_USERNAME` FOREIGN KEY (`userNameUsuario`) REFERENCES `Usuario` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PuntoDeControl`
--

LOCK TABLES `PuntoDeControl` WRITE;
/*!40000 ALTER TABLE `PuntoDeControl` DISABLE KEYS */;
INSERT INTO `PuntoDeControl` VALUES (220000,1,110000,2,'SimonP'),(220001,2,110000,3,'Daniel8'),(220002,3,110000,4,'Gomez8'),(220003,4,110000,2,'SimonP'),(220004,1,110001,3,'SimonP'),(220005,2,110001,4,'Gomez8'),(220006,3,110001,2,'Daniel8'),(220007,4,110001,3,'Gomez8'),(220008,1,110002,4,'SimonP'),(220009,2,110002,2,'SimonP'),(220010,3,110002,3,'Daniel8'),(220011,4,110002,4,'Gomez8'),(220012,1,110003,2,'SimonP'),(220013,2,110003,3,'Gomez8'),(220014,3,110003,4,'Daniel8'),(220015,4,110003,2,'SimonP'),(220016,1,110004,3,'Daniel8'),(220017,2,110004,4,'Daniel8'),(220018,3,110004,2,'Daniel8'),(220019,4,110004,3,'Daniel8');
/*!40000 ALTER TABLE `PuntoDeControl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ruta`
--

DROP TABLE IF EXISTS `Ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ruta` (
  `codigo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `codigoDestino` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_DESTINO_CODIGO` (`codigoDestino`),
  CONSTRAINT `FK_DESTINO_CODIGO` FOREIGN KEY (`codigoDestino`) REFERENCES `Destino` (`codigo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ruta`
--

LOCK TABLES `Ruta` WRITE;
/*!40000 ALTER TABLE `Ruta` DISABLE KEYS */;
INSERT INTO `Ruta` VALUES (110000,1,330000),(110001,1,330001),(110002,1,330002),(110003,1,330003),(110004,1,330004);
/*!40000 ALTER TABLE `Ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `userName` varchar(20) NOT NULL,
  `jerarquia` int(11) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('Antony9',3,'password'),('Daniel8',2,'password2'),('Gomez8',2,'password3'),('Jorge24',1,'password2'),('Juan123',1,'password1'),('Lopez2',3,'12345678'),('Lopezxx',1,'password3'),('Marcoxxx',3,'passxxx'),('SimonP',2,'password1');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-25 16:48:02
