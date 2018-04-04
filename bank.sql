-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) NOT NULL,
  `serie` varchar(45) NOT NULL,
  `cnp` varchar(45) NOT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cnp`),
  UNIQUE KEY `idClient_UNIQUE` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Luca Andrada','CJ 98765','12345678900','Mehedinti 21','0758390774'),(5,'Popescu Andreea','CJ 47523','24578931254','Bucuresti nr.17','0784623691'),(12,'Moldovan Mihai','BM 12345','3747548547','Constanta nr 12','076538985'),(6,'Bogdan','CJ 2844','438758458','nn','4783875'),(2,'Badareu Victoria','CJ 475739','45698712365','Campului nr 23 M3','0123659874');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cont`
--

DROP TABLE IF EXISTS `cont`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cont` (
  `idcont` int(11) NOT NULL AUTO_INCREMENT,
  `tip` int(11) NOT NULL,
  `bani` int(11) NOT NULL,
  `data` varchar(45) NOT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`idcont`),
  UNIQUE KEY `idcont_UNIQUE` (`idcont`),
  KEY `idClient_idx` (`idClient`),
  CONSTRAINT `idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cont`
--

LOCK TABLES `cont` WRITE;
/*!40000 ALTER TABLE `cont` DISABLE KEYS */;
INSERT INTO `cont` VALUES (1,1,1823,'12/17',1),(3,3,777,'03/17',1),(4,3,2219,'12/17',5),(5,1,4941,'12/17',5);
/*!40000 ALTER TABLE `cont` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raport`
--

DROP TABLE IF EXISTS `raport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raport` (
  `idraport` int(11) NOT NULL AUTO_INCREMENT,
  `idangajat` int(11) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `actiune` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idraport`),
  UNIQUE KEY `idraport_UNIQUE` (`idraport`),
  KEY `idAngajat_idx` (`idangajat`),
  CONSTRAINT `idAngajat` FOREIGN KEY (`idangajat`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raport`
--

LOCK TABLES `raport` WRITE;
/*!40000 ALTER TABLE `raport` DISABLE KEYS */;
INSERT INTO `raport` VALUES (1,1,'29/03/2018','A fost introdus Clientul cu id-ul: 2'),(2,1,'29/03/2018','A fost introdus Clientul cu id-ul: 1'),(3,1,'29/03/2018','A fost introdus Clientul cu id-ul: 10'),(4,1,'29/03/2018','A fost actualizat Clientul cu id-ul: 10'),(5,1,'29/03/2018','Au fost vizualizate conturile'),(6,1,'29/03/2018','A fost introdus Clientului cu id-ul: 4 contul cu id-ul'),(7,1,'29/03/2018','Au fost vizualizate conturile'),(8,1,'29/03/2018','A fost introdus Clientului cu id-ul: 4 contul cu id-ul'),(9,1,'29/03/2018','Au fost vizualizate conturile'),(10,1,'29/03/2018','A fost introdus Clientului cu id-ul: 5 contul cu id-ul'),(11,1,'29/03/2018','Au fost vizualizate conturile'),(12,1,'29/03/2018','S-a facut update la contul cu id-ul4 cu suma de 260 cu tipul 3 cu data 12/17'),(13,1,'29/03/2018','A fost introdus Clientului cu id-ul: 5 contul cu id-ul'),(14,1,'29/03/2018','Au fost vizualizate conturile'),(15,1,'29/03/2018','A fost introdus Clientului cu id-ul: 5 contul cu id-ul'),(16,1,'29/03/2018','Au fost vizualizate conturile'),(17,1,'29/03/2018','A fost efectuat transferul din contul cu id-ul5 in contul cu id-ul4 cu suma de 100'),(18,1,'29/03/2018','Au fost vizualizate conturile'),(19,1,'29/03/2018','Au fost vizualizate conturile'),(20,1,'29/03/2018','A fost efectuat transferul din contul cu id-ul5 in contul cu id-ul4 cu suma de 690'),(21,1,'29/03/2018','Plata utilitatilor efectuata de contul cu id-ul 5'),(22,15,'29/03/2018','Au fost vizualizate conturile'),(23,15,'29/03/2018','A fost efectuat transferul din contul cu id-ul5 in contul cu id-ul4 cu suma de 621'),(24,15,'29/03/2018','Plata utilitatilor efectuata de contul cu id-ul 5'),(25,15,'29/03/2018','Au fost vizualizate conturile'),(26,1,'29/03/2018','A fost introdus Clientul cu id-ul: 1'),(27,1,'29/03/2018','A fost actualizat Clientul cu id-ul: 11'),(28,1,'29/03/2018','A fost introdus Clientul cu id-ul: 11'),(29,1,'29/03/2018','A fost introdus Clientul cu id-ul: 11'),(30,1,'29/03/2018','Au fost vizualizate conturile'),(31,1,'29/03/2018','A fost introdus Clientului cu id-ul: 6 contul cu id-ul'),(32,1,'29/03/2018','Au fost vizualizate conturile'),(33,1,'29/03/2018','S-a facut update la contul cu id-ul2 cu suma de 5000 cu tipul 2 cu data 03/18'),(34,1,'29/03/2018','Au fost vizualizate conturile'),(35,1,'29/03/2018','A fost sters contul cu id-ul 2'),(36,1,'29/03/2018','Au fost vizualizate conturile'),(37,1,'29/03/2018','A fost efectuat transferul din contul cu id-ul5 in contul cu id-ul3 cu suma de 100'),(38,1,'29/03/2018','Au fost vizualizate conturile'),(39,1,'29/03/2018','A fost efectuat transferul din contul cu id-ul5 in contul cu id-ul4 cu suma de 548'),(40,1,'29/03/2018','Plata utilitatilor efectuata de contul cu id-ul 5'),(41,1,'29/03/2018','Au fost vizualizate conturile');
/*!40000 ALTER TABLE `raport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tip` int(11) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'andrada','luca',1,'Luca Andrada','Mehedinti'),(2,'andradaaa','luca',2,'Luca Andrada','d'),(15,'aaaa','aaaa',1,'Luca','hhh');
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

-- Dump completed on 2018-03-29 22:47:20
