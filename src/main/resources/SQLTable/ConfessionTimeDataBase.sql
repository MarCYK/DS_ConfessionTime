-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: confession
-- ------------------------------------------------------
-- Server version	8.0.29

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
  `id` int NOT NULL AUTO_INCREMENT,
  `userID` varchar(45) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Marvin','e73b79a0b10f8cdb6ac7dbe4c0a5e25776e1148784b86cf98f7d6719d472af69','marvincyk02@gmail.com'),(2,'Irfan','e73b79a0b10f8cdb6ac7dbe4c0a5e25776e1148784b86cf98f7d6719d472af69','irfan@gmail.com'),(3,'irfan','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','irfan52@gmail.com'),(4,'Pirvin','0889113e04d3203f0c401c17c0fd8b352b740dc607433779d3edcaa13320b001','pirvin@gmail.com'),(5,'test','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','test@gmail.com');
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
  `content` varchar(5000) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idflag`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flag`
--

LOCK TABLES `flag` WRITE;
/*!40000 ALTER TABLE `flag` DISABLE KEYS */;
INSERT INTO `flag` VALUES (5,'#UM00022','','I am a year 1 student. Want to buy UM shirt or jacket. Does anyone know where to buy it?','2022-06-22 12.01pm'),(6,'#UM00037','','Nak apply for pemudahcara mahasiswa sesi 22/23 but someone said \'kalau kau ada kroni, boleh lah dapat\'. yaa a bit down actually. Can someone give some advice should I continue to apply pm or not. thank you','2022-06-22 11.51am');
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
  `content` varchar(5000) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `score` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (1,'#UM00001','','\"Menarik! Selamat Hari Raya Demokrasi di UM.\n\nTop 10 manifesto terbaik calon fakulti.\n\n1. Amirul Syafiq API NEO\n- Subsidi Sewaan Laptop\n\n2. Ainur APM ANGKATAN\n- Menggiatkan Hak Kesaksamaan dan Peluang Mahasiswa OKU APM\n\n3. Syamir APM ANGKATAN & Shariena FBL SUARA SISWA\n- Pelaksanaan Projek Pemerkasaan Kesejahteraan Mental (Projek PASKAL) di APM (Syamir)\n- Platform atas talian berkaitan kesihatan mental dan pendidikan asas bahasa (Shariena)\n\n4. AIZAT FSKTM MP\n- Mewujudkan program outbound yang lebih berkesan\n\n5. Allysha & Malissa FBL ANGKATAN\n- Pembinaan rumah sampah\n\n6.Muss\'ab FPE MP\n- Financial Calculator\n\n7. Goh Yang Ting & Lee Zhao Long SUARA SISWA\n- Greater UM shufflr bus service frequency - kk 3,4,7\n\n8. Sarah Zulaikha & Malik Chan EDU ANGKATAN\n- Program Care For Kids\n\n9. Dzhaffry FBL MP\n- Memastikan pintu pagar di FBL dibuka pada hari minggu\n\nLast but not least,\n\n10. Siew & Caroline\n-Kafe di pusat sukan\n\nSummary*\n- They deserve the spot sebab manifesto fresh, terkini dan mampu menyelesaikan masalah semasa.\n- Mostly manifesto NEO mcm recycle je kecuali manifesto API. Focus kat API je ke?\n- Faculty Akademi Pengajian Melayu ANGKATAN, Faculty API NEO, FPE Mp amat luar biasa. Manifesto pasal wanita, internship oku, kesihatan mental, program keilmuwan tu memang sangat win lah.\n- tapi banyak manifesto mcm tgkap muat je. Takde reformasi dan benda baru langsung.\n\nAnyways. Goodluck. Dah menang, jangan tak tunaikan manifesto pulak okey!\n\nSekian,\nAkak third year\nLofek.','2022-06-22 06.55am',3),(2,'#UM00002','','Kepada KMUM yang baru nanti tolong sediakan tng reload kat fakulti or kps or um sentral ker. Itu jer saya minta sebagai student yang sentiasa risau akan  baki kad tngo ni cukup tak ? ,,,\n\nsedihnya bila dapat tahu kawan kita panggil bila perlu jee huhu\n','2022-06-22 06.55am',2),(3,'#UM00003','','It\'s sad when we find out that our friends only call when they need us huhu,,,\n\nIs it selfish if i want \'me time\' in room just a moment because she always in the room and cause of that I always go out knowhere even i don\'t have classes because i feel uncomfortable living in room almost 24 hours with her .. :( like can you even consider me a lil bit because I already give you a lot of \'me time\' .. please , I need some privacy , having \'me time\' is everything for me \'),,,\n\nsebelum mengata orang, cermin diri dulu. sibuk cakap orang tak function la, freerider la, tapi diri kita tu tengok tak? satu lagi saya nak pesan dah besar ni saya rasa elakkan la berkelakuan tak matang. kalau tak suka bagitau, tak puas hati bagitau. sedangkan dalam islam pun tak galakkan menyindir-nyidir ni. lagipun awak kan baik tak macam saya, mesti awak tahu... lbnl be profesional and pls atleast have some common sense. saya confess dkat sini sebab saya tahu kalau saya tegur ftf awak tak akan boleh terima. sebab di mata awak buruknya tetap pada saya. saya harap mesej ni sampai lah dekat orang yang sepatutnya baca. mungkin awak boleh tutup diri awak dengan personaliti \"sopan\" awaktu, tapi hati-hati. nanti makan diri :),,,\n','2022-06-22 06.56am',0),(4,'#UM00004','','Aku dah lama ikut politik UM.\n\nAku harap Demokrat boleh keluarkan kenyataan pasal perkara ini.\n\nKalau diam, aku rasa boleh nyatakan kenyataan sebelum ini adalah fitnah daripada Demokrat.\"\n','2022-06-22 06.56am',0),(5,'#UM00005','','its disgusting to admit but i wish someone would pat my head and tell me everything is going to be ok','2022-06-22 06.57am',0),(6,'#UM00006','','This is a shoutout of appreciation to the best roomie I could ever have for the past year (2 sems). Although we\'re of different faculties - you in architorture (your words, not mine) and me in social science - and have very different class schedules, I can\'t thank you enough for being very patient with my antics and for helping me when I\'m at my lowest (you don\'t know it, but you really saved my life a few times without knowing). If I could choose a roommate for the rest of my study period, I would choose you again and again. I hope we will cross paths again, roomie!','2022-06-22 06.59am',0),(7,'#UM00007','#UM00006',' Hampir empat tahun belajar jarang aku nak meradang depan - depan. Tetapi kali ini bahagian kewangan memang melampau!!!. Macam mana kau manage sistem nak update yuran.. Apahal b\"\"*/%:= sangat Pengurusan dan lembap tahap gamban.. Awal-awal setting yuran sekian.. Lepastu bila aku cek maya naik mendadak.. Bila cek nak tengok yuran pengajian or Penginapan sbb penginapan dh withdraw.. Dhla yuran bila aku agak - agak tk tepat dgn dalam sistem. Total sucks UM!!!\"\n','2022-06-22 07.00am',1),(8,'#UM00008','',' Remember others have feelings too, you\'re not the only one who has feelings','2022-06-22 07.00am',-2),(9,'#UM00009','#UM00008','Betul huhu','2022-06-22 07.01am',2),(10,'#UM00010','','Now kk7 macam dah jdi tempat permainan tikus dah. Sekarang ni kitorang dah tak takut kat monyet (takut la jgk) tapi tikus ni lagi takut. Imagine dalam sehari kau boleh terserempak dgn 2-3 ekor tikus weiiiii. Lepastu tikus tu kejap ada kat blok sebelah kejap blok kau kejap aras atas, kejap aras bawah. Sumpah takut. Ada sekali tu cikti ni berjaya masuk bilik kitorang, terpaksa kami merempat tumpang bilik member. Lagi kesian bila cikti tu stay je dalam bilik tu. Even dah tutup pintu pun still tak gune ye sebab tingkap atas pintu or tingkap2 kat zaba ni mostly longgar2 & ada lompong yg mbolehkan diorang msk. \nBoleh tak pihak pengurusan do something dgn masalh tikus ni? Janganlah menuding salah dekat student saja cakap student pengotor la ape la. Yang pengotor tu tak sampai berapa % pown. Kitorang duduk tido makn rehat sini, korang yg xduduk sini senang la ckp student itulah ini la. Bayar kolej mahal2 tapi gitu jgk. Yang terseksa 1 kolej. I percaya bukan i sorang je pernah jadi mangsa cikti ni, ramai lagi penghuni lain yg pernah kena gak. \nPLEASE LA PIHAK PENGURUSAN & JTK DO SOMETHING!','2022-06-22 07.05am',0),(11,'#UM00011','#UM00010','Betul tu, Monyet pun banyak menyerang!!!','2022-06-22 07.06am',0),(12,'#UM00012','#UM00010','se7, it\'s so unhygenic','2022-06-22 07.07am',0),(13,'#UM00013','','I am a year 1 student. Want to buy UM shirt or jacket. Does anyone know where to buy it?','2022-06-22 08.48am',0),(18,'#UM00021','','just want to order whoever wins .. all manifesto needs to be fulfilled.. Don\'t then when you can\'t do it, you\'ll say it\'s \"not the holy book\".,,,\n\nTolonglah jangan jadikan tasik tu tempat kau nak buat maksiat. Kadang-kadang orang macam aku ni pegi tasik nak tenangkan fikiran bukannya nak tengok drama maksiat kau.,,,\n\nSemua lect mmg x nk bagi kita study week ke ek ?','2022-06-22 09.17am',0),(19,'#UM00023','','Week 13 & 14 ni nak bunuh student ka apa? Gilaaaa aku,,,\n\nMember aku dapat dah elaun ramadhan tu, tapi aku tak dapat lagi.. kena inform siapa eh\n','2022-06-22 09.20am',0),(21,'#UM00026','','Hi seniors, I\'m from Faculty of Science studying Physics in my second year.\n\nMay I ask if I want to extend my study duration from minimum 7 semesters to 8 or 9 semesters, do I need to apply for it? If need, may I know what are the conditions and how to apply for it?\n\nThanks in advance.','2022-06-22 10.46am',0),(22,'#UM00027','','Kepada freshies yang introvert, jangan putus asa, beranikan diri untuk masuk apa-apa program, projek kolej, kelab,dll. Nnti korang akan belajar something from there. From zero to hero. Btw saya pun dulu introvert, skrg dah berani nk mingle dengan semua orang bila jadi PM masuk tu masuk ni. Masa ini lah untuk korang mencuba benda baru. Goodluck. Need nasihat dan kata2 semangat dtg cafe kk3, kupi2.','2022-06-22 11.45am',0),(23,'#UM00029','','Swimming pool um bila nak bukak balik. Nak swimming kolam dalam\n','2022-06-22 11.45am',0),(24,'#UM00030','','boleh ke jtk ke siapa ke yang ada kuasa besar sikit dekat kk12 cadangkan buat washing machine & dryer guna duit kertas macam kk lain? kk12 dah la yuran mahal, atleast bagi la mesin yang elok. ni duk tercirit kena cari duit syiling pishang mattt','2022-06-22 11.46am',0),(25,'#UM00032','','Hi everyone, already week 14 but idk what I\'m doin rn I\'m just feel tired, I keep hving suicidal thoughts and I already make a bar code on my hands, you know when I make it I feels nothing plus I feels that all my problems gone idk, I feels lonely, many friends but still feels lonely idk lah what I feels actually\n','2022-06-22 11.46am',0),(26,'#UM00033','','haritu aku ade la belajar kt cube kk3. lepastu datang la satu mamat ni pakai shorts baru habis jogging, abeh intip2 dari luar cube utk tengok siapa tk pakai mask, siapa makan kt dlm.. aku tktau kau siapa, tapi bila kau nk tegur orang2 kt cube tu, blh tak nada suara kau tu elok sikit? kau tegur org pon mcm kau org luar, tk nmpk mcm kau ahli jtk. lpstu nk tnye lagi kita duduk kolej tu ke tak. nk tegur orang tu pon sopan la sikit. kene ada tata cara yg betul. ni tidak. ghisau aku. org nk bljr kt situ pon rase mcm kene halau.. kau buat org2 tk selesa. dah tu je nk ckp.','2022-06-22 11.46am',0),(27,'#UM00034','#UM00033','this','2022-06-22 11.46am',0),(28,'#UM00037','','Nak apply for pemudahcara mahasiswa sesi 22/23 but someone said \'kalau kau ada kroni, boleh lah dapat\'. yaa a bit down actually. Can someone give some advice should I continue to apply pm or not. thank you','2022-06-22 11.51am',1),(29,'#UM00038','#UM00037','Pengalaman peribadi aku, kau apply ja. Kalau kau tak dapat pun atleast kau dah usaha untuk apply, kalau kau dapat Kira bonus (and aku personally doakan kau dapat). Banyak manfaat, connection, bonding, pengalaman yang kau akan dapat kalau kau join PM.','2022-06-22 11.55am',0),(30,'#UM00039','#UM00037','','2022-06-22 11.55am',0),(31,'#UM00022','','I am a year 1 student. Want to buy UM shirt or jacket. Does anyone know where to buy it?','2022-06-22 12.01pm',1),(32,'#UM00041','#UM00001','trump blm','2022-06-22 13.36pm',0),(33,'#UM00042','','this\nis\ngay','2022-06-22 13.37pm',0),(34,'#UM00043','','want to see spicy loli videos? go to www.spicyloli.com','2022-06-22 13.38pm',0),(35,'#UM00045','','This String','2022-06-22 13.44pm',0);
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
  `content` varchar(5000) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idspam`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spam`
--

LOCK TABLES `spam` WRITE;
/*!40000 ALTER TABLE `spam` DISABLE KEYS */;
INSERT INTO `spam` VALUES (2,'#UM00016','','FREE UNLIMITED HARDCORE PORN direct 2 your mobile Txt PORN to 69200 & get FREE access for 24 hrs then chrgd@50p per day txt Stop 2exit. This msg is free','2022-06-22 08.51am'),(3,'#UM00017','','UR GOING 2 BAHAMAS! CallFREEFONE 08081560665 and speak to a live operator to claim either Bahamas cruise of�2000 CASH 18+only. To opt out txt X to 07786200117','2022-06-22 08.52am'),(6,'#UM00025','','Week 13 & 14 ni nak bunuh student ka apa? Gilaaaa aku,,,  Member aku dapat dah elaun ramadhan tu, tapi aku tak dapat lagi.. kena inform siapa eh ','2022-06-22 10.46am'),(7,'#UM00028','','Kepada freshies yang introvert, jangan putus asa, beranikan diri untuk masuk apa-apa program, projek kolej, kelab,dll. Nnti korang akan belajar something from there. From zero to hero. Btw saya pun dulu introvert, skrg dah berani nk mingle dengan semua orang bila jadi PM masuk tu masuk ni. Masa ini lah untuk korang mencuba benda baru. Goodluck. Need nasihat dan kata2 semangat dtg cafe kk3, kupi2.','2022-06-22 11.45am'),(8,'#UM00031','','its disgusting to admit but i wish someone would pat my head and tell me everything is going to be ok','2022-06-22 11.46am'),(9,'#UM00036','#UM00033','this','2022-06-22 11.46am'),(10,'#UM00040','','testttt','2022-06-22 12.01pm'),(11,'#UM00044','','','2022-06-22 13.38pm');
/*!40000 ALTER TABLE `spam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `idtag` int NOT NULL AUTO_INCREMENT,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtag`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (0,'a'),(1,'a'),(2,'a'),(3,'a'),(4,'a'),(5,'a'),(6,'a'),(7,'a'),(8,'a'),(9,'a'),(10,'a'),(11,'a'),(12,'a'),(13,'a'),(14,'a'),(15,'a'),(16,'a'),(17,'a'),(18,'a'),(19,'a'),(20,'a'),(21,'a'),(22,'a'),(23,'a'),(24,'a'),(25,'a'),(26,'a'),(27,'a'),(28,'a'),(29,'a'),(30,'a'),(31,'a'),(32,'a'),(33,'a'),(34,'a'),(35,'a'),(36,'a'),(37,'a'),(38,'a'),(39,'a'),(40,'a'),(41,'a'),(42,'a'),(43,'a'),(44,'a'),(45,'a'),(46,'a'),(47,'a'),(48,'a'),(49,'a'),(50,'a'),(51,'a'),(52,'a'),(53,'a');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waitinglist`
--

DROP TABLE IF EXISTS `waitinglist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waitinglist` (
  `num` int NOT NULL AUTO_INCREMENT,
  `thisID` varchar(45) NOT NULL,
  `replyID` varchar(45) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waitinglist`
--

LOCK TABLES `waitinglist` WRITE;
/*!40000 ALTER TABLE `waitinglist` DISABLE KEYS */;
INSERT INTO `waitinglist` VALUES (46,'#UM00046','#UM00001','I\'ve been following UM politics for a long time.\n\nI hope Democrats can release a statement on this.\n\nIf silent, I think stating a prior statement is slander from Democrats. \",,,\n\nI ade kemusykilan ni, for those yang bertanding untuk pilihanraya kampus, I tahu ade certain yang akan go for internship next semester which most probably akan start after current semester habis, so my question is if they got chosen but they are not at campus due to insternship so mereka ni dikira tak buat kerja la kan ? If got internship kat kl then issokay but what if placement this person outside kl or selangor.,,,\n\nwe as woman will voice out fr another woman. Previously the guy who talk bad about women safety initiative has to apologise in public. We don\'t care, which party win, u fight within you. Nobody given rights to humiliate a woman work for her community. His post literally talk bad about girls. He mention \'pleasure \' which nearly defined self defence keychain. We will fight until the guy get caught. Don\'t think we afraid of you. We woman can do more than you cn imagine.,,,\n\nNAK NYANYI KE NAK PASANG LAGU KUAT2 KAT BILIK KE NAK OTP KE EVEN PAKAI EARPHONE SUARA KAU TETAP MENGANGGU. SILA KELUAR !! PAHAM SIKIT ORANG TENGAH TIDO GILE !! YE AKU MARAHH\n','2022-06-25 21.02pm','1'),(47,'#UM00052','','UM ni indah khabar dari rupa. Semua buruk buruk and tak function fasilitynya tapi yuran mahal nak mampuss! Kolej buruk, wifi lembab buat hal, etc tapi yuran 1k lebih!! Kepala otak diaaaaa!!!\n','2022-06-25 21.05pm','1'),(48,'#UM00053','','\"Boleh share tips, macam mana nak luahkan perasaan kita kepada orang yang kita suka?\n\nTolong bantu saya \"','2022-06-25 21.06pm','1');
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

-- Dump completed on 2022-06-25 21:07:08
