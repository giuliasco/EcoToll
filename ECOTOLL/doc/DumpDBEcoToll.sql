CREATE DATABASE  IF NOT EXISTS `EcoToll` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `EcoToll`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: EcoToll
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `autostrada`
--

DROP TABLE IF EXISTS `autostrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autostrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_autostrada` varchar(50) NOT NULL,
  `inizio` varchar(50) NOT NULL,
  `fine` varchar(50) NOT NULL,
  `km` double NOT NULL,
  `tariffa_km` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autostrada`
--

LOCK TABLES `autostrada` WRITE;
/*!40000 ALTER TABLE `autostrada` DISABLE KEYS */;
INSERT INTO `autostrada` VALUES (1,'A24-Autostrada dei Parchi','Roma','Teramo',166,0.17),(2,'A25-Autostrada dei Parchi','Torano','Villanova di Cepagatti',114,0.17),(19,'A1-Autostrada del Sole','Milano','Napoli',760,0.09),(20,'A2-Autostrada del Mediterraneo','Salerno','Reggio Calabria',443,0.09),(21,'A3-Autostrada A3','Napoli ','Salerno',52,0.1),(22,'A4-Autostrada Serenissima','Torino ','Trieste',523,0.09),(23,'A5-Autostrada della Valle d\'Aosta','Torino','Monte Bianco',144,0.08),(24,'A6-La Verdemare','Torino','Savona',125,0.12),(25,'A7-Autostrada dei Giovi o Serravalle','Milano','Genova',139,0.1),(26,'A9-Autostrada dei Laghi','Lainate','Chiasso',32,0.1),(27,'A8-Autostrada dei Laghi','Milano','Varese',44,0.1);
/*!40000 ALTER TABLE `autostrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casello`
--

DROP TABLE IF EXISTS `casello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casello` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_casello` varchar(50) NOT NULL,
  `altezza_km` double NOT NULL,
  `id_autostrada` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `autostrada_casello` (`id_autostrada`),
  CONSTRAINT `autostrada_casello` FOREIGN KEY (`id_autostrada`) REFERENCES `autostrada` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casello`
--

LOCK TABLES `casello` WRITE;
/*!40000 ALTER TABLE `casello` DISABLE KEYS */;
INSERT INTO `casello` VALUES (1,'Lunghezza',8,1),(2,'Roma Est',8.1,1),(3,'Tivoli',12.6,1),(4,'Castel Madama',24,1),(5,'Vicovaro-Mandela',33.2,1),(6,'Carsoli Oricola',50.5,1),(7,'Tagliacozzo',61.2,1),(8,'Valle del Salto',75.1,1),(9,'Tornimparte',84.9,1),(10,'L\'Aquila Ovest',101.1,1),(11,'L\'Aquila Est',106.7,1),(12,'Assergi',116.8,1),(13,'San Gabriele Colledara',136.6,1),(14,'Teramo',146,1),(15,'Magliano dei Marsi',83.1,2),(16,'Avezzano',87.9,2),(17,'Aielli-Celano',101.2,2),(18,'Pescina',110.3,2),(19,'Cocullo',121.6,2),(20,'Sulmona-Pratola Peligna',136.8,2),(21,'Bussi  Popoli',149.9,2),(22,'Casauria Torre de\' Passeri',157.2,2),(23,'Scafa-Alanno',166.4,2),(24,'Manoppello',171,2),(25,'Chieti',177.5,2),(26,'Pescara-Villanova',185.4,2);
/*!40000 ALTER TABLE `casello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_europea`
--

DROP TABLE IF EXISTS `classe_europea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe_europea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `aggiunta` double DEFAULT NULL,
  `id_normativa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `classeEU_normativa` (`id_normativa`),
  CONSTRAINT `classeEU_normativa` FOREIGN KEY (`id_normativa`) REFERENCES `normativa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_europea`
--

LOCK TABLES `classe_europea` WRITE;
/*!40000 ALTER TABLE `classe_europea` DISABLE KEYS */;
INSERT INTO `classe_europea` VALUES (1,'0',2,2),(2,'1',1.8,2),(7,'2',1.6,2),(8,'3',1.4,2),(9,'4',1.2,2),(10,'5',1,2),(11,'6',0.8,2);
/*!40000 ALTER TABLE `classe_europea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_italiana`
--

DROP TABLE IF EXISTS `classe_italiana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe_italiana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `aggiunta` double DEFAULT NULL,
  `id_normativa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `classeIT_normativa` (`id_normativa`),
  CONSTRAINT `classeIT_normativa` FOREIGN KEY (`id_normativa`) REFERENCES `normativa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_italiana`
--

LOCK TABLES `classe_italiana` WRITE;
/*!40000 ALTER TABLE `classe_italiana` DISABLE KEYS */;
INSERT INTO `classe_italiana` VALUES (1,'A',1.2,1),(2,'B',1.4,1),(3,'3',1.6,1),(4,'4',1.8,1),(5,'5',2,1);
/*!40000 ALTER TABLE `classe_italiana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `normativa`
--

DROP TABLE IF EXISTS `normativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `normativa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_normativa` varchar(50) DEFAULT NULL,
  `anno_normativa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normativa`
--

LOCK TABLES `normativa` WRITE;
/*!40000 ALTER TABLE `normativa` DISABLE KEYS */;
INSERT INTO `normativa` VALUES (1,'Italiana','2019'),(2,'Europea','2019'),(3,'Italiana','2018'),(4,'Italiana','2021');
/*!40000 ALTER TABLE `normativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruolo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_utente` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruolo`
--

LOCK TABLES `ruolo` WRITE;
/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
INSERT INTO `ruolo` VALUES (1,'Utente Normale'),(2,'Amministratore');
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_utente` varchar(50) NOT NULL,
  `cognome_utente` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `id_ruolo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `utente_ruolo` (`id_ruolo`),
  CONSTRAINT `utente_ruolo` FOREIGN KEY (`id_ruolo`) REFERENCES `ruolo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Giulia			','Scoccia','giulia@gmail.com','123',1),(2,'Erika','Biondi','erika@hotmail.com','456',2),(3,'Davide','Fontana','davide@gmail.com','789',1),(4,'Miriana','Pompilio','miriana@yahoo.it','123',1),(5,'Alessandro','Di Matteo','alex@hotmail.it','159',1),(6,'Giovanna','Di Cresce','giopina@yahoo.it','123456',1),(7,'Fabiola','Biondi','robbiola@yahoo.it','852',1),(8,'Giorgia','Scoccia','giorgia@gmail.com','258',1),(9,'Federico','Scoccia','federico@gmail.com','3333',1),(10,'Elvira ','Prioli','elvis@alice.it','88888',1),(12,'Sergio','Scoccia','sergio@gmail.com','9999',1),(13,'Roberta ','De Feo','robberta@alice.it','123456',1),(14,'Paolo','Prioli','paoletto@yahoo.it','852',1);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veicolo`
--

DROP TABLE IF EXISTS `veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veicolo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `targa` varchar(50) NOT NULL,
  `id_ci` int(11) NOT NULL,
  `id_ceu` int(11) NOT NULL,
  `id_utente` int(11) NOT NULL,
  `assi` int(11) DEFAULT NULL,
  `altezza_veicolo` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `classeitaliana_veicolo` (`id_ci`),
  KEY `classeuropea_veicolo` (`id_ceu`),
  KEY `utente_veicolo` (`id_utente`),
  CONSTRAINT `classeitaliana_veicolo` FOREIGN KEY (`id_ci`) REFERENCES `classe_italiana` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `classeuropea_veicolo` FOREIGN KEY (`id_ceu`) REFERENCES `classe_europea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utente_veicolo` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicolo`
--

LOCK TABLES `veicolo` WRITE;
/*!40000 ALTER TABLE `veicolo` DISABLE KEYS */;
INSERT INTO `veicolo` VALUES (1,'EK955VH',2,11,1,2,1.5),(5,'EH182HG',2,10,2,2,1.5),(6,'CK492CF',2,2,4,2,1.7),(7,'AQ123BC',4,1,3,3,2);
/*!40000 ALTER TABLE `veicolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-03 16:56:59
