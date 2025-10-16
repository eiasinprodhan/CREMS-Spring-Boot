-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: crems
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `attendances`
--

DROP TABLE IF EXISTS `attendances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendances` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `stage_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendances`
--

LOCK TABLES `attendances` WRITE;
/*!40000 ALTER TABLE `attendances` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `down_payment` double NOT NULL,
  `due_amount` double DEFAULT NULL,
  `emi_amount` double DEFAULT NULL,
  `interest_rate` double DEFAULT NULL,
  `is_loan` bit(1) NOT NULL,
  `year` int DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `floor_id` int DEFAULT NULL,
  `unit_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgou7km7b1vj0q2pcklgd49kl1` (`building_id`),
  KEY `FKbvfibgflhsb0g2hnjauiv5khs` (`customer_id`),
  KEY `FKbqsud3nbcw4t2ky4b9901dc51` (`floor_id`),
  KEY `FKkfprbsuaxp1ilg0h8u2ufagka` (`unit_id`),
  CONSTRAINT `FKbqsud3nbcw4t2ky4b9901dc51` FOREIGN KEY (`floor_id`) REFERENCES `floors` (`id`),
  CONSTRAINT `FKbvfibgflhsb0g2hnjauiv5khs` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `FKgou7km7b1vj0q2pcklgd49kl1` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`),
  CONSTRAINT `FKkfprbsuaxp1ilg0h8u2ufagka` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buildings`
--

DROP TABLE IF EXISTS `buildings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buildings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `floor_count` int NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit_count` int NOT NULL,
  `project_id` int DEFAULT NULL,
  `site_manager_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs69rv0w3otrf38mu6ssa7hll5` (`project_id`),
  KEY `FK5qlmqmhohj8mjs7aiok6snug3` (`site_manager_id`),
  CONSTRAINT `FK5qlmqmhohj8mjs7aiok6snug3` FOREIGN KEY (`site_manager_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FKs69rv0w3otrf38mu6ssa7hll5` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buildings`
--

LOCK TABLES `buildings` WRITE;
/*!40000 ALTER TABLE `buildings` DISABLE KEYS */;
INSERT INTO `buildings` VALUES (1,50,'Dhanmondi, Dhaka','Building A','Building A_bd1d779b-250d-4944-a532-a38d19f2c763.jpg','Mixed-use',150,1,4),(2,100,'Agargaon, Dhaka','Building B','Building B_003aa36a-f635-4694-9654-a1fdced42b2b.jpg','Residential',200,2,5);
/*!40000 ALTER TABLE `buildings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Lalbagh, Dhaka','sathekhanom@gmail.com','Sathe Khanom','01700000000','https://avatars.githubusercontent.com/u/196038150?v=4'),(2,'Azimpur, Dhaka','halimaakter@gmail.com','Halima Akter','01800000000','https://avatars.githubusercontent.com/u/195928727?v=4');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `joining_date` datetime(6) DEFAULT NULL,
  `last_salary` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nid` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `salary_type` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `total_salary` double DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKj9xgmd0ya5jmus09o0b8pqrpb` (`email`),
  UNIQUE KEY `UKd8bwoo3gih7wh99ypv19f4oq` (`nid`),
  UNIQUE KEY `UKgnponadwwxr5nm2tqe5b905hs` (`phone`),
  UNIQUE KEY `UKj2dmgsma6pont6kf7nic9elpd` (`user_id`),
  CONSTRAINT `FK69x3vjuy1t5p18a5llb8h2fjx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Gazaria, Munshiganj','Bangladesh','eiasinprodhan@gmail.com','2025-10-16 06:00:00.000000',NULL,'Eiasin Prodhan',1010101010,'12345678','01888118271','Eiasin Prodhan_2c422e4b-55de-4ccd-946f-9b1987d582c0.jpg','ADMIN',100000,'Monthly',_binary '\0',NULL,1),(2,'Kallanpur, Dhaka','Bangladesh','rahmatullah@gmail.com','2025-10-16 06:00:00.000000',NULL,'Rahmat Ullah',1111111111,'12345678','01700000000','Rahmat Ullah_22809397-fc76-4865-963d-d42879ffc4e5.png','PROJECT_MANAGER',50000,'Monthly',_binary '\0',NULL,2),(3,'Azimpur, Dhaka','Bangladesh','mdimranmia@gmail.com','2025-10-16 06:00:00.000000',NULL,'Md. Imran Mia',2222222222,'12345678','01711111111','Md. Imran Mia_f9ae36f0-3092-469b-87bb-e528569b80fd.png','PROJECT_MANAGER',50000,'Monthly',_binary '\0',NULL,3),(4,'Mohammadpur, Dhaka','Bangladesh','mdatiqulislam@gmail.com','2025-10-16 06:00:00.000000',NULL,'Md Atiqul Islam',3333333333,'12345678','01722222222','Md Atiqul Islam_90bf2e16-3a2c-44a1-9251-af10bd98884d.png','SITE_MANAGER',30000,'Monthly',_binary '\0',NULL,4),(5,'Mohammadpur, Dhaka','Bangladesh','mdrakibislam@gmail.com','2025-10-16 06:00:00.000000',NULL,'Md Rakib Islam',4444444444,'12345678','01733333333','Md Rakib Islam_8f8569db-22d2-4db7-aaac-6ba263e8a264.png','SITE_MANAGER',30000,'Monthly',_binary '\0',NULL,5),(6,'Dhaka','Bangladesh','laboura@gmail.com','2025-10-16 06:00:00.000000',NULL,'Labour A',1584695875,'12345678','01800000000','Labour A_9f5b7bac-de96-4b38-a36b-04e0d049c87d.png','LABOUR',1000,'Daily',_binary '\0',NULL,6),(7,'Dhaka','Bangladesh','labourb@gmail.com','2025-10-16 06:00:00.000000',NULL,'Labour B',1035698575,'12345678','01800000001','Labour B_7ff4a707-c7a1-4f1c-9fa5-32a9c140e7a7.png','LABOUR',1500,'Daily',_binary '\0',NULL,7),(8,'Dhaka','Bangladesh','labourc@gmail.com','2025-10-16 06:00:00.000000',NULL,'Labour C',6532158754,'12345678','01800000002','Labour C_2e7a82f3-56c2-4df6-bcc8-42011af2a8c2.png','LABOUR',1200,'Monthly',_binary '\0',NULL,8),(9,'Dhaka','Bangladesh','labourd@gmail.com','2025-10-16 06:00:00.000000',NULL,'Labour D',1345679845,'12345678','01800000003','Labour D_1f113605-4d6c-4e17-bd3a-b550095fd68f.png','LABOUR',800,'Daily',_binary '\0',NULL,9),(10,'Dhaka','Bangladesh','laboure@gmail.com','2025-10-16 06:00:00.000000',NULL,'Labour E',6854254857,'12345678','01800000004','Labour E_36d578ec-6883-49eb-aaf9-bccd038b6faa.png','LABOUR',1000,'Daily',_binary '\0',NULL,10);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floors`
--

DROP TABLE IF EXISTS `floors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `expected_end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdhibx5frs3cwiltccr79uks37` (`building_id`),
  CONSTRAINT `FKdhibx5frs3cwiltccr79uks37` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floors`
--

LOCK TABLES `floors` WRITE;
/*!40000 ALTER TABLE `floors` DISABLE KEYS */;
INSERT INTO `floors` VALUES (1,'2026-01-23 06:00:00.000000','Ground',1),(2,'2026-01-16 06:00:00.000000','1st Floor',1),(3,'2026-01-30 06:00:00.000000','Ground',2);
/*!40000 ALTER TABLE `floors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanpayments`
--

DROP TABLE IF EXISTS `loanpayments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loanpayments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `booking_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpky6ypwlme9js4mgjpf4ghbl4` (`booking_id`),
  CONSTRAINT `FKpky6ypwlme9js4mgjpf4ghbl4` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanpayments`
--

LOCK TABLES `loanpayments` WRITE;
/*!40000 ALTER TABLE `loanpayments` DISABLE KEYS */;
/*!40000 ALTER TABLE `loanpayments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `budget` bigint DEFAULT NULL,
  `description` longtext,
  `expected_end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `project_manager_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjhkgnbg8chh6ke9y4110vcpx0` (`project_manager_id`),
  CONSTRAINT `FKjhkgnbg8chh6ke9y4110vcpx0` FOREIGN KEY (`project_manager_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,50000000,'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).','2026-01-24 06:00:00.000000','Project A','Mixed-use','2025-10-16 06:00:00.000000',2),(2,90000000,'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).','2026-02-28 06:00:00.000000','Project B','Mixed-use','2025-11-13 06:00:00.000000',3);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raw_materials`
--

DROP TABLE IF EXISTS `raw_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raw_materials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raw_materials`
--

LOCK TABLES `raw_materials` WRITE;
/*!40000 ALTER TABLE `raw_materials` DISABLE KEYS */;
INSERT INTO `raw_materials` VALUES (1,'Sand',0,'Cubic Feet'),(2,'Gravel',0,'Cubic Feet'),(3,'Crushed Stone',0,'Cubic Feet'),(4,'Cement',0,'Bags'),(5,'Lime',0,'Kg'),(6,'Fly Ash',0,'Kg'),(7,'Slag',0,'Kg'),(8,'Concrete',0,'Cubic Feet'),(9,'Mortar',0,'Kg'),(10,'Clay Bricks',0,'Pieces'),(11,'Concrete Blocks',0,'Pieces'),(12,'Fly Ash Bricks',0,'Pieces'),(13,'Aac Blocks',0,'Pieces'),(14,'Tmt Bars',0,'Kg'),(15,'Steel Rods',0,'Kg'),(16,'Wire Mesh',0,'Square Feet'),(17,'Structural Steel',0,'Kg'),(18,'Plywood',0,'Sheets'),(19,'Timber',0,'Cubic Feet'),(20,'Pvc Pipes',0,'Feet'),(21,'Plastic Sheets',0,'Square Feet'),(22,'Glass',0,'Square Feet'),(23,'Bitumen',0,'Liters'),(24,'Asphalt',0,'Tons'),(25,'Paint',0,'Liters'),(26,'Primer',0,'Liters'),(27,'Ceramic Tiles',0,'Square Feet'),(28,'Vitrified Tiles',0,'Square Feet'),(29,'Plaster Of Paris',0,'Kg'),(30,'Water',0,'Liters'),(31,'Admixtures',0,'Liters'),(32,'Insulation Foam',0,'Sheets'),(33,'Rock Wool',0,'Kg'),(34,'Sealant',0,'Tubes'),(35,'Adhesive',0,'Liters');
/*!40000 ALTER TABLE `raw_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage_labours`
--

DROP TABLE IF EXISTS `stage_labours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stage_labours` (
  `stage_id` int NOT NULL,
  `labours` int DEFAULT NULL,
  KEY `FK16cd67x23cdn897wjdepl67ky` (`stage_id`),
  CONSTRAINT `FK16cd67x23cdn897wjdepl67ky` FOREIGN KEY (`stage_id`) REFERENCES `stages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage_labours`
--

LOCK TABLES `stage_labours` WRITE;
/*!40000 ALTER TABLE `stage_labours` DISABLE KEYS */;
INSERT INTO `stage_labours` VALUES (1,6),(1,7),(1,8),(1,9),(1,10),(2,6),(2,7),(2,8),(2,9),(2,10),(3,6),(3,7),(3,8),(3,9),(3,10),(4,6),(4,7),(4,8),(4,9),(4,10);
/*!40000 ALTER TABLE `stage_labours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage_payment`
--

DROP TABLE IF EXISTS `stage_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stage_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `paid` bit(1) NOT NULL,
  `stage_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage_payment`
--

LOCK TABLES `stage_payment` WRITE;
/*!40000 ALTER TABLE `stage_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `stage_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stages`
--

DROP TABLE IF EXISTS `stages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `floor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2wkah2gdhlxodklfo3tixlf94` (`floor_id`),
  CONSTRAINT `FK2wkah2gdhlxodklfo3tixlf94` FOREIGN KEY (`floor_id`) REFERENCES `floors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stages`
--

LOCK TABLES `stages` WRITE;
/*!40000 ALTER TABLE `stages` DISABLE KEYS */;
INSERT INTO `stages` VALUES (1,'2025-12-20 06:00:00.000000','Pilling','2025-10-16 06:00:00.000000',1),(2,'2026-01-31 06:00:00.000000','Slabbing','2025-10-16 06:00:00.000000',1),(3,'2026-02-07 06:00:00.000000','Flooring','2025-10-16 06:00:00.000000',2),(4,'2025-12-06 06:00:00.000000','Pilling','2025-10-16 06:00:00.000000',3);
/*!40000 ALTER TABLE `stages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_in_details`
--

DROP TABLE IF EXISTS `stock_in_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_in_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `raw_materials_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4b0w4q74gn2ufrsqeq7f724tm` (`raw_materials_id`),
  CONSTRAINT `FK4b0w4q74gn2ufrsqeq7f724tm` FOREIGN KEY (`raw_materials_id`) REFERENCES `raw_materials` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_in_details`
--

LOCK TABLES `stock_in_details` WRITE;
/*!40000 ALTER TABLE `stock_in_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_in_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_out_details`
--

DROP TABLE IF EXISTS `stock_out_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_out_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `raw_materials_id` int DEFAULT NULL,
  `stage_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72c7s71fbqkvx78l56pk1ucwm` (`raw_materials_id`),
  KEY `FKqrtu6sbaapbubui3mjb7xy50k` (`stage_id`),
  CONSTRAINT `FK72c7s71fbqkvx78l56pk1ucwm` FOREIGN KEY (`raw_materials_id`) REFERENCES `raw_materials` (`id`),
  CONSTRAINT `FKqrtu6sbaapbubui3mjb7xy50k` FOREIGN KEY (`stage_id`) REFERENCES `stages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_out_details`
--

LOCK TABLES `stock_out_details` WRITE;
/*!40000 ALTER TABLE `stock_out_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_out_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_log_out` bit(1) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8rfw4x0wjjyibfqq566j4qng` (`user_id`),
  CONSTRAINT `FKj8rfw4x0wjjyibfqq566j4qng` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWFzaW5wcm9kaGFuQGdtYWlsLmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc2MDYyODQxNiwiZXhwIjoxNzYwNzE0ODE2fQ.FC8Qd3jqPmTvEcimwzZYAu_HNi_OEGmq7nH8r-IE7bw',1),(2,_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWFzaW5wcm9kaGFuQGdtYWlsLmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc2MDYyODQ0MywiZXhwIjoxNzYwNzE0ODQzfQ.uEJ3EIbu-iVnGOdpZz_g6vOBDuvdUd-vUUm3ec5vT0c',1),(3,_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWFzaW5wcm9kaGFuQGdtYWlsLmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc2MDYyODQ1OSwiZXhwIjoxNzYwNzE0ODU5fQ.6xSFC0Hm7w1VJyacHrxXzXnQZF6oeZy39DQ-Ki4Lsrk',1),(4,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWhtYXR1bGxhaEBnbWFpbC5jb20iLCJyb2xlIjoiUFJPSkVDVF9NQU5BR0VSIiwiaWF0IjoxNzYwNjI4OTUyLCJleHAiOjE3NjA3MTUzNTJ9.Rc3K7PS4xV1lMY1aDbPAeI8jYO-91-LGSW0SwJamdF8',2),(5,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZGltcmFubWlhQGdtYWlsLmNvbSIsInJvbGUiOiJQUk9KRUNUX01BTkFHRVIiLCJpYXQiOjE3NjA2MjkwMzksImV4cCI6MTc2MDcxNTQzOX0.C2gnwZDJCcspErnUo1Y1Y-PE4eaTvS8Pauq1WiGUw4w',3),(6,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZGF0aXF1bGlzbGFtQGdtYWlsLmNvbSIsInJvbGUiOiJTSVRFX01BTkFHRVIiLCJpYXQiOjE3NjA2MjkxMjIsImV4cCI6MTc2MDcxNTUyMn0.jfEq61lLuXoqFZFUUPDnLMI7SqXVADDpPg-lWRD2udY',4),(7,_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWFzaW5wcm9kaGFuQGdtYWlsLmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc2MDYyOTE2MCwiZXhwIjoxNzYwNzE1NTYwfQ.XZ0CnslRDY3flk1NdPIEUYZVuN1pMwXvgKyjc4sPvmU',1),(8,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWFzaW5wcm9kaGFuQGdtYWlsLmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc2MDYyOTE4MiwiZXhwIjoxNzYwNzE1NTgyfQ.0kkjDbu20r8UxRRBiHxtp2DEUTdpU2VP5DDTaGAj0m8',1),(9,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZHJha2liaXNsYW1AZ21haWwuY29tIiwicm9sZSI6IlNJVEVfTUFOQUdFUiIsImlhdCI6MTc2MDYyOTMwMiwiZXhwIjoxNzYwNzE1NzAyfQ.dfR6MsduD2hRPneo5ux8nLkxr_Q_H0b963OefiEJ90M',5),(10,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWJvdXJhQGdtYWlsLmNvbSIsInJvbGUiOiJMQUJPVVIiLCJpYXQiOjE3NjA2Mjk0NzAsImV4cCI6MTc2MDcxNTg3MH0.cJ3UpsduAFCVUDCQaq7ogymkpq3z6QVbo2750h0U8vA',6),(11,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWJvdXJiQGdtYWlsLmNvbSIsInJvbGUiOiJMQUJPVVIiLCJpYXQiOjE3NjA2Mjk1MDUsImV4cCI6MTc2MDcxNTkwNX0.gfBZ9mroxR0P6GhMt0h5ZaW5JyNtm8uw6GKTzHWGKW4',7),(12,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWJvdXJjQGdtYWlsLmNvbSIsInJvbGUiOiJMQUJPVVIiLCJpYXQiOjE3NjA2Mjk1MzQsImV4cCI6MTc2MDcxNTkzNH0.YfG8gPiUY2i8PCOqZeZ7a4430JSIHyF04tolrfoWlR4',8),(13,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWJvdXJkQGdtYWlsLmNvbSIsInJvbGUiOiJMQUJPVVIiLCJpYXQiOjE3NjA2Mjk1NjYsImV4cCI6MTc2MDcxNTk2Nn0.Ju5D9UlHZT9UsgAdLIZM1-3g3Cc6j0zzhZDhaeek8XU',9),(14,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYWJvdXJlQGdtYWlsLmNvbSIsInJvbGUiOiJMQUJPVVIiLCJpYXQiOjE3NjA2Mjk1OTQsImV4cCI6MTc2MDcxNTk5NH0.MbrsfiAVMPBcGXtNZugOyWulRHWSbs9fw_hrj2xF8zg',10);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `credit` bit(1) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_photo_urls`
--

DROP TABLE IF EXISTS `unit_photo_urls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_photo_urls` (
  `unit_id` int NOT NULL,
  `photo_urls` varchar(255) DEFAULT NULL,
  KEY `FK4mcnxbpkx8h0d2f7be46u6vnc` (`unit_id`),
  CONSTRAINT `FK4mcnxbpkx8h0d2f7be46u6vnc` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_photo_urls`
--

LOCK TABLES `unit_photo_urls` WRITE;
/*!40000 ALTER TABLE `unit_photo_urls` DISABLE KEYS */;
INSERT INTO `unit_photo_urls` VALUES (1,'G101_8885eaff-9b27-40ca-88b2-e00d26993ec9.jpg'),(1,'G101_79df0ee3-8a56-4493-bb0f-2dcbe28cd96e.jpg'),(1,'G101_75f77620-91d3-467e-ad75-12b75a8c1b25.jpg'),(1,'G101_3a15ad43-36bc-4cd1-9078-9dbb5de941f4.jpg'),(1,'G101_e7ba4a66-a5d3-4b30-a906-4eb23a012e34.jpg'),(2,'G102_8a1daab4-b9d3-44c6-92fb-3a96959b595f.jpg'),(2,'G102_f90958d2-e7b0-42fa-b4d4-56776d03a61a.jpg'),(2,'G102_3cfab4bd-3016-41b6-b6c8-aeb5aca7e85d.jpg'),(2,'G102_2af04076-b086-4487-a958-2df6b952bcd1.jpg'),(2,'G102_d73f312b-83de-4947-bfd8-dc1fbc438db9.jpg'),(3,'A101_b07d6dcc-dc5d-43f9-a267-c20de0d2c9b1.jpg'),(3,'A101_d8a71de1-04d6-4c36-a35f-6807a69e082f.jpg'),(3,'A101_ccf6d913-ee56-43a5-b4ce-33b4f45f87ae.jpg'),(3,'A101_97403c8b-a078-481f-ad83-71eb1b4aa48a.jpg'),(3,'A101_bae18cb1-fac5-4275-80fa-eb7f8350f512.jpg'),(4,'G101_72692173-09d4-4b6b-abc7-dbb80116d3ad.jpg'),(4,'G101_f7c71f11-67e6-427f-aebd-7f78ee7e1359.jpg'),(4,'G101_5d7f4860-f369-4bca-8e87-e1e7054bda47.jpg'),(4,'G101_244d9207-7913-4031-bdc8-511cd4c468f0.jpg'),(4,'G101_47c63e8a-429e-405e-ba35-de61c252580f.jpg'),(5,'G102_acb1a52a-f3d4-4238-af20-d1d7411d5504.jpg'),(5,'G102_f9bdf4bd-986d-4647-97f7-3fe1494d7521.jpg'),(5,'G102_84c021b1-b10b-4ee6-a435-a9c545c27cf9.jpg'),(5,'G102_529f1c25-296c-4e14-99d6-053cfc8dfc41.jpg'),(5,'G102_f58f13a9-50ef-42a8-8653-beef5ba15535.jpg');
/*!40000 ALTER TABLE `unit_photo_urls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `id` int NOT NULL AUTO_INCREMENT,
  `area` double DEFAULT NULL,
  `bathrooms` int NOT NULL,
  `bedrooms` int NOT NULL,
  `interest_rate` double DEFAULT NULL,
  `is_booked` bit(1) NOT NULL,
  `price` double DEFAULT NULL,
  `unit_number` varchar(255) DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  `floor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfh6oa3mlbu97mwuves70ylio` (`building_id`),
  KEY `FKgn7mo9pri7ll55lwc7fyi7frb` (`floor_id`),
  CONSTRAINT `FKfh6oa3mlbu97mwuves70ylio` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`),
  CONSTRAINT `FKgn7mo9pri7ll55lwc7fyi7frb` FOREIGN KEY (`floor_id`) REFERENCES `floors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,5000,5,10,20,_binary '\0',15000000,'G101',1,1),(2,5000,5,10,20,_binary '\0',15000000,'G102',1,1),(3,1000,5,5,10,_binary '\0',10000000,'A101',1,2),(4,10000,5,10,20,_binary '\0',20000000,'G101',2,3),(5,10000,5,10,20,_binary '\0',25000000,'G102',2,3);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `is_lock` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','CUSTOMER','LABOUR','PROJECT_MANAGER','SITE_MANAGER') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UKdu5v5sr43g5bfnji4vb8hg5s3` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '','eiasinprodhan@gmail.com',_binary '\0','Eiasin Prodhan','$2a$10$Q8ZBSJF9snYiWgD.oXjer.oBKJRZ/7aaKGDTvRQ6TnT6nmpZMEKem','01888118271','Eiasin Prodhan_2c422e4b-55de-4ccd-946f-9b1987d582c0.jpg','ADMIN'),(2,_binary '','rahmatullah@gmail.com',_binary '\0','Rahmat Ullah','$2a$10$POOw/UHrJg7RlXRzGqn5xulRgODluty1axJd8KxsEfrVHOuz1Y20G','01700000000','Rahmat Ullah_22809397-fc76-4865-963d-d42879ffc4e5.png','PROJECT_MANAGER'),(3,_binary '','mdimranmia@gmail.com',_binary '\0','Md. Imran Mia','$2a$10$j7RlT33jtWPLK1kZUJV13.YCPbIi5x3NfiLYGpHkDasEmyt9omfmC','01711111111','Md. Imran Mia_2aebe25f-459b-40bb-8c11-68500a15387a.png','PROJECT_MANAGER'),(4,_binary '','mdatiqulislam@gmail.com',_binary '\0','Md Atiqul Islam','$2a$10$vVS/6hxIX2wTbbIDNVFJfucgoFNE.62pIVbbie0gOTHys8vDrc8iS','01722222222','Md Atiqul Islam_d7910dfe-1ee2-4d20-b373-418ab483b997.png','SITE_MANAGER'),(5,_binary '','mdrakibislam@gmail.com',_binary '\0','Md Rakib Islam','$2a$10$zDMc/VKyzSwYZF3lC8s3gOJq3SoIwwRIWZBcEu5GcBG/kcedGDzzO','01733333333','Md Rakib Islam_8f8569db-22d2-4db7-aaac-6ba263e8a264.png','SITE_MANAGER'),(6,_binary '','laboura@gmail.com',_binary '\0','Labour A','$2a$10$f9epvo8SlmAhPlASD.0FAehz2zZ9H2PEfmSDJnpyA7pH4t97JFkfu','01800000000','Labour A_9f5b7bac-de96-4b38-a36b-04e0d049c87d.png','LABOUR'),(7,_binary '','labourb@gmail.com',_binary '\0','Labour B','$2a$10$0tFFEg2xX0xwMPpZ9ZTLwukA5A2uxWtJVg9rVylgWpMAceKgy3V12','01800000001','Labour B_7ff4a707-c7a1-4f1c-9fa5-32a9c140e7a7.png','LABOUR'),(8,_binary '','labourc@gmail.com',_binary '\0','Labour C','$2a$10$y.uj7oQMIHi918y8io3Ci.bzCB3fjouayCuBVMoFiC62r.strygIu','01800000002','Labour C_2e7a82f3-56c2-4df6-bcc8-42011af2a8c2.png','LABOUR'),(9,_binary '','labourd@gmail.com',_binary '\0','Labour D','$2a$10$.tI6vLtIsfACmFhKKf6IiuInw5g4wVtBh9D.ZthNX5n1TYZQsJi9W','01800000003','Labour D_1f113605-4d6c-4e17-bd3a-b550095fd68f.png','LABOUR'),(10,_binary '','laboure@gmail.com',_binary '\0','Labour E','$2a$10$Urud2as/kgsvkmaHWAcpde0HMKIa9InMA9CoRlwkCKBSWEdkBzWpK','01800000004','Labour E_36d578ec-6883-49eb-aaf9-bccd038b6faa.png','LABOUR');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_tokens`
--

DROP TABLE IF EXISTS `users_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_tokens` (
  `user_id` int NOT NULL,
  `tokens_id` int NOT NULL,
  UNIQUE KEY `UKf4rxms009ktbqt31o6p4y8vhw` (`tokens_id`),
  KEY `FK1xl95grn90nu35htsi9o5kbxw` (`user_id`),
  CONSTRAINT `FK1xl95grn90nu35htsi9o5kbxw` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK2b23nqo552bhfydxn9plx4vod` FOREIGN KEY (`tokens_id`) REFERENCES `token` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_tokens`
--

LOCK TABLES `users_tokens` WRITE;
/*!40000 ALTER TABLE `users_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_tokens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-16 22:05:15
