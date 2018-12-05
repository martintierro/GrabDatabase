CREATE DATABASE  IF NOT EXISTS `grab_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `grab_db`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: grab_db
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL,
  `riderID` int(11) NOT NULL,
  `driverID` int(11) NOT NULL,
  `tripID` int(11) NOT NULL,
  `timeDate` datetime NOT NULL,
  `totalPrice` float NOT NULL,
  `rating` float NOT NULL,
  PRIMARY KEY (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,2,1,1,'2018-11-30 08:30:00',220,5),(2,4,7,6,'2018-12-01 08:31:15',230,4),(3,5,6,4,'2018-12-02 08:32:30',240,4.5),(4,1,5,3,'2018-12-03 08:33:45',250,5),(5,3,3,7,'2018-12-04 08:34:55',260,4);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `car` (
  `carID` int(11) NOT NULL,
  `driverID` int(11) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `plateNo` varchar(45) NOT NULL,
  `rideType` enum('GrabShare','GrabCar','GrabCar6','GrabTaxi','Premium') NOT NULL,
  PRIMARY KEY (`carID`),
  UNIQUE KEY `plateNum_UNIQUE` (`plateNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,1,'Mitsubishi','Mirage','Red','ABP7759','GrabCar'),(2,2,'Honda','Civic','Black','ABP7760','GrabCar'),(3,3,'Toyota','Fortuner','Pink','ABP7761','GrabShare'),(4,4,'Mitsubishi','Montero Sport','Blue','ABP7762','GrabShare'),(5,5,'Mitsubishi','Adventure','Green','ABP7763','GrabCar6'),(6,6,'Toyota','Revo','Purple','ABP7764','GrabCar6'),(7,7,'Toyota','Vios','Brown','ABP7765','GrabTaxi'),(8,8,'Toyota','Comfort','Black','ABP7766','GrabTaxi'),(9,9,'Toyota','Camry','Black','ABP7767','Premium'),(10,10,'Honda','Accord','Grey','ABP7768','Premium');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver` (
  `driverID` int(11) NOT NULL,
  `givenName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `contactNo` varchar(11) NOT NULL,
  `rating` float NOT NULL,
  PRIMARY KEY (`driverID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'Carlo','Abate','0917000111',4),(2,'George','Abecassis','0917000222',5),(3,'Kenny','Acheson','0917000333',3),(4,'Philippe','Adams','0917000444',4),(5,'Walt','Ader','0917000555',4.5),(6,'Kurt','Adolf','0917000666',3.5),(7,'Fred','Agabashian','0917000777',4),(8,'Michele','Alboreto','0917000888',5),(9,'Red','Amick','0917000999',4.5),(10,'Chris','Amon','0917111000',4);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rider`
--

DROP TABLE IF EXISTS `rider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rider` (
  `riderID` int(11) NOT NULL,
  `givenName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `mobileNo` varchar(11) NOT NULL,
  `creditCard` varchar(16) NOT NULL,
  PRIMARY KEY (`riderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rider`
--

LOCK TABLES `rider` WRITE;
/*!40000 ALTER TABLE `rider` DISABLE KEYS */;
INSERT INTO `rider` VALUES (1,'Martin','Tierro','09178854297','8365836501848376'),(2,'Jade','Tan','09179876543','7165928562856279'),(3,'Schuyler','Ng','09178432312','0174669274927592'),(4,'Jarrett','Singian','09399205868','9472918739383928'),(5,'Stephen','Ngo','09736585728','6482695738294687');
/*!40000 ALTER TABLE `rider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trip` (
  `tripID` int(11) NOT NULL,
  `startPoint` varchar(45) NOT NULL,
  `endPoint` varchar(45) NOT NULL,
  `distance` float NOT NULL,
  `basePrice` float NOT NULL,
  PRIMARY KEY (`tripID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,'De La Salle University','Ateneo De Manila University',21,150),(2,'De La Salle University','University of the Philippines',19,120),(3,'De La Salle University','University of Santo Tomas',6,75),(4,'Ateneo De Manila University','De La Salle University',21,150),(5,'Ateneo De Manila University','Univeristy of the Philippines',3.5,60),(6,'Ateneo De Manila University','University of Santo Tomas',16,105),(7,'University of the Philippines','De La Salle University',19,120),(8,'University of the Philippines','Ateneo De Manila University',3.5,60),(9,'University of the Philippines','University of Santo Tomas',13,90),(10,'University of Santo Tomas','De La Salle University',6,75),(11,'University of Santo Tomas','Ateneo De Manila University',16,105),(12,'University of Santo Tomas','University of the Philippines',13,90);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'grab_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-05 12:40:00
