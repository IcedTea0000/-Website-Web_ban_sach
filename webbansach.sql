-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: web_ban_sach
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.37-MariaDB

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` int(11) NOT NULL,
  `author` varchar(45) NOT NULL,
  `stock` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `picture_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'The Godfather, a Novel','The Godfather is a crime novel written by American author Mario Puzo. Originally published in 1969 by G. P. Putnam\'s Sons, the novel details the story of a fictional Mafia family based in New York City (and Long Beach, New York), headed by Vito Corleone. Puzo\'s dedication for The Godfather is \"For Anthony Cleri\". The epigraph for The Godfather is \"Behind every great fortune there is a crime. -Balzac.\" The novel covers the years 1945 to 1955, and also provides the back story of Vito Corleone from early childhood to adulthood.',35.94,3,'Mario Puzzo',58,'top','thegodfather1.jpg'),(2,'Whitefang','White Fang is a novel by American author Jack London (1876–1916) — and the name of the book\'s eponymous character, a wild wolfdog. First serialized in Outing magazine, it was published in 1906. The story takes place in Yukon Territory and the Northwest Territories, Canada, during the 1890s Klondike Gold Rush and details White Fang\'s journey to domestication. It is a companion novel (and a thematic mirror) to London\'s best-known work, The Call of the Wild, which is about a kidnapped, domesticated dog embracing his wild ancestry to survive and thrive in the wild.',8.75,10,'Jack London',58,'new','whitefang1.jpg'),(3,'The Adventures of Tom Sawyer','The Adventures of Tom Sawyer by Mark Twain is an 1876 novel about a young boy growing up along the Mississippi River. It is set in the 1840s in the fictional town of St. Petersburg, inspired by Hannibal, Missouri, where Twain lived as a boy. In the novel Tom Sawyer has several adventures, often with his friend, Huckleberry Finn. Originally a commercial failure, the book ended up being the best selling of any of Twain\'s works during his lifetime',9.95,1,'Mark Twain',82,'new','theadventureoftomsawyer1.jpg'),(4,'Pet Sematary','Pet Sematary is a 1983 horror novel by American writer Stephen King, nominated for a World Fantasy Award for Best Novel in 1986,[1] and adapted into a 1989 film of the same name. A second film adaptation is scheduled to be released in April 2019. In November 2013, PS Publishing released Pet Sematary in a limited 30th Anniversary Edition.',18.3,8,'Stephen King',20,'top','petsematary1.jpg'),(5,'Aesop\'s Fables','The most well known and well loved of Aesop’s Fables have been brought to life with NYT #1 bestselling illustrator Charles Santore’s beloved and breathtaking artwork. These classic and captivating tales help to illustrate basic moral issues through the amazing artwork and simple stories we all know and love.',13.96,4,'Charles Santore',50,'top','aesopsfables1.jpg'),(6,'The Lost Girls of Paris','The Lost Girls of Paris is an emotional story of friendship and betrayal during the second world war, inspired by true event - from the international bestseller Pam Jenoff.1940s With the world at war, Eleanor Trigg leads a mysterious ring of female secret agents in London. Twelve of these women are sent to aid the resistance. They never return home.1946 Passing through Grand Central Station, New York, Grace Healey finds an abandoned suitcase tucked beneath a bench. The case is filled with a dozen photographs, each of a different woman. Setting out to find the women behind the pictures, Grace is drawn into the mystery of the lost girls of Paris. And as she delves deeper into the secrets of the past, she uncovers a story of fierce friendship, unthinkable bravery - and, ultimately, the worst kind of betrayal.',17.7,7,'Pam Jenoff',68,'top','thelostgirlofparis1.jpg'),(7,'How to Win Friends & Influence People','How to Win Friends and Influence People is a self-help book written by Dale Carnegie, published in 1936. Over 15 million copies have been sold worldwide, making it one of the best-selling books of all time.[1] In 2011, it was number 19 on Time Magazine\'s list of the 100 most influential books.',9.6,9,'Dale Carnegie',55,'top','howtowinfriendandinfluencepeople1.jpg'),(8,'The Power of Habit: Why We Do What We Do in Life and Business','The Power of Habit: Why We Do What We Do in Life and Business is a book by Charles Duhigg, a New York Times reporter, published in February 2012 by Random House. It explores the science behind habit creation and reformation. The book reached the best seller list for The New York Times, Amazon.com, and USA Today. It was long listed for the Financial Times and McKinsey Business Book of the Year Award in 2012.',12.38,9,'Charles Duhigg ',47,'top','thepowerofhabit1.jpg'),(9,'The Lord of the Rings','The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien. The story began as a sequel to Tolkien\'s 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels ever written, with over 150 million copies sold. The title of the novel refers to the story\'s main antagonist, the Dark Lord Sauron, who had in an earlier age created the One Ring to rule the other Rings of Power as the ultimate weapon in his campaign to conquer and rule all of Middle-earth. From quiet beginnings in the Shire, a hobbit land not unlike the English countryside, the story ranges across Middle-earth, following the course of the War of the Ring through the eyes of its characters, not only the hobbits Frodo Baggins, Samwise \"Sam\" Gamgee, Meriadoc \"Merry\" Brandybuck and Peregrin \"Pippin\" Took, but also the hobbits\' chief allies and travelling companions: the Men, Aragorn, a Ranger of the North, and Boromir, a Captain of Gondor; Gimli, a Dwarf warrior; Legolas Greenleaf, an Elven prince; and Gandalf, a wizard.',15.99,10,'J.R.R Tolkien',100,'top','lordoftherings1.jpg'),(10,'Harry Potter Series','Harry Potter is a series of fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harry\'s struggle against Lord Voldemort, a dark wizard who intends to become immortal, overthrow the wizard governing body known as the Ministry of Magic, and subjugate all wizards and Muggles (non-magical people). Since the release of the first novel, Harry Potter and the Philosopher\'s Stone, on 26 June 1997, the books have found immense popularity, critical acclaim and commercial success worldwide. They have attracted a wide adult audience as well as younger readers and are often considered cornerstones of modern young adult literature. As of February 2018, the books have sold more than 500 million copies worldwide, making them the best-selling book series in history, and have been translated into eighty languages. The last four books consecutively set records as the fastest-selling books in history, with the final instalment selling roughly eleven million copies in the United States within twenty-four hours of its release.',94.35,10,'J.K Rowling',100,'sale','harrypotter1.jpg'),(11,'The Da Vinci Code','The Da Vinci Code is a 2003 mystery thriller novel by Dan Brown. It follows \"symbologist\" Robert Langdon and cryptologist Sophie Neveu after a murder in the Louvre Museum in Paris causes them to become involved in a battle between the Priory of Sion and Opus Dei over the possibility of Jesus Christ having been a companion to Mary Magdalene. The title of the novel refers to the finding of the first murder victim in the Grand Gallery of the Louvre, naked and posed similar to Leonardo da Vinci\'s famous drawing, the Vitruvian Man, with a mathematical message written beside his body and a pentagram drawn on his chest in his own blood. The novel explores an alternative religious history, whose central plot point is that the Merovingian kings of France were descended from the bloodline of Jesus Christ and Mary Magdalene, ideas derived from Clive Prince\'s The Templar Revelation (1997) and books by Margaret Starbird. The book also refers to The Holy Blood and the Holy Grail (1982) though Dan Brown has stated that it was not used as research material.',8.99,3,'Dan Brown',100,'sale','davincicode1.jpg'),(12,'The Alchemist','The Alchemist (Portuguese: O Alquimista) is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller. An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there. The Alchemist follows the journey of an Andalusian shepherd boy named Santiago. Believing a recurring dream to be prophetic, he asks a Romani fortune teller in a nearby town about its meaning. The woman interprets the dream as a prophecy telling the boy that he will discover a treasure at the Egyptian pyramids.',22.95,6,'Paulo Coelho',100,'sale','thealchemist1.jpg'),(13,'Kane and Abel','Kane and Abel is a 1979 novel by British author Jeffrey Archer. Released in the United Kingdom in 1979 and in the United States in February 1980, the book was an international success. It reached No. 1 on the New York Times best-seller list. The sequel to Kane and Abel is The Prodigal Daughter, in which Florentyna Kane is the protagonist. Kane & Abel is among the top 100 list of best-selling books in the world, with a similar number of copies sold as To Kill a Mockingbird and Gone with the Wind. In 2003, Kane and Abel was listed at number 96 on the BBC\'s survey The Big Read.',5,6,'Jeffery Archer',100,'sale','kaneabel1.jpg'),(14,'The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life','The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life is the FCC first book by blogger and author Mark Manson. In it Manson argues that life\'s struggles give it meaning, and that the mindless positivity of typical self-help books is neither practical nor helpful. It was a bestseller. The book is a reaction to the self-help industry and what Manson saw as a culture of mindless positivity that isn\'t practical or helpful for most people. Manson uses many of his own personal experiences to illustrate how life\'s struggles often give it more meaning, which, he argues, is a better approach than constantly trying to be happy. Manson\'s approach and writing style have been categorized by some as contrarian to the general self-help industry, using blunt honesty and profanity to illustrate his ideas.',14.99,9,'Mark Manson',100,'new','subtleart1.jpg'),(15,'A Wrinkle in Time (Time Quintet)','It was a dark and stormy night; Meg Murry, her small brother Charles Wallace, and her mother had come down to the kitchen for a midnight snack when they were upset by the arrival of a most disturbing stranger. \"Wild nights are my glory,\" the unearthly stranger told them. \"I just got caught in a downdraft and blown off course. Let me sit down for a moment, and then I\'ll be on my way. Speaking of ways, by the way, there is such a thing as a tesseract.\" A tesseract (in case the reader doesn\'t know) is a wrinkle in time. To tell more would rob the reader of the enjoyment of Miss L\'Engle\'s unusual book. A Wrinkle in Time, winner of the Newbery Medal in 1963, is the story of the adventures in space and time of Meg, Charles Wallace, and Calvin O\'Keefe (athlete, student, and one of the most popular boys in high school). They are in search of Meg\'s father, a scientist who disappeared while engaged in secret work for the government on the tesseract problem. A Wrinkle in Time is the winner of the 1963 Newbery Medal.',6.19,6,'Madeleine L\'Engle ',100,'new','wrinkleintime1.jpg'),(16,'Alice’s Adventures in Wonderland','Alice\'s Adventures in Wonderland (commonly shortened to Alice in Wonderland) is an 1865 novel written by English author Charles Lutwidge Dodgson under the pseudonym Lewis Carroll. It tells of a young girl named Alice falling through a rabbit hole into a fantasy world populated by peculiar, anthropomorphic creatures. The tale plays with logic, giving the story lasting popularity with adults as well as with children. It is considered to be one of the best examples of the literary nonsense genre. Its narrative course, structure, characters, and imagery have been enormously influential in both popular culture and literature, especially in the fantasy genre.',2.7,5,'Lewis Carroll',100,'sale','alice1.jpg'),(17,'Mere Christianity','Mere Christianity is a theological book by C. S. Lewis, adapted from a series of BBC radio talks made between 1941 and 1944, while Lewis was at Oxford during the Second World War. Considered a classic of Christian apologetics, the transcripts of the broadcasts originally appeared in print as three separate pamphlets: The Case for Christianity (Broadcast Talks in the UK) (1942), Christian Behaviour (1943), and Beyond Personality (1944). Lewis was invited to give the talks by James Welch, the BBC Director of Religious Broadcasting, who had read his 1940 book, The Problem of Pain.',13.15,1,'C.S Lewis',100,'top','merechristianity1.jpg'),(18,'1984','As literary political fiction and dystopian science fiction, Nineteen Eighty-Four is a classic novel in content, plot, and style. Many of its terms and concepts, such as Big Brother, doublethink, thoughtcrime, Newspeak, Room 101, telescreen, 2 + 2 = 5, and memory hole, have entered into common usage since its publication in 1949. Nineteen Eighty-Four popularised the adjective Orwellian, which connotes official deception, secret surveillance, brazenly misleading terminology and manipulation of recorded history by a totalitarian or authoritarian state. In 2005, the novel was chosen by Time magazine as one of the 100 best English-language novels from 1923 to 2005. It was awarded a place on both lists of Modern Library 100 Best Novels, reaching number 13 on the editors\' list, and 6 on the readers\' list. In 2003, the novel was listed at number 8 on the BBC\'s survey The Big Read.',7.49,6,'George Orwell',100,'sale','1984.jpg');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cart_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (1,1,2,2,10),(2,1,3,3,10),(13,1,1,1,10),(14,1,2,1,11),(17,1,8,1,0),(18,1,2,2,0),(19,1,3,1,0),(20,1,1,5,0);
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_order`
--

DROP TABLE IF EXISTS `cart_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `day_buy` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_order`
--

LOCK TABLES `cart_order` WRITE;
/*!40000 ALTER TABLE `cart_order` DISABLE KEYS */;
INSERT INTO `cart_order` VALUES (10,1,'04-04-2019','processing'),(11,1,'04-04-2019','processing');
/*!40000 ALTER TABLE `cart_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `picture_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Classic','Fiction that has become part of an accepted literary canon, widely taught in schools','classic1.jpg'),(2,'Comics/graphic novel','Fiction that has become part of an accepted literary canon, widely taught in schools','graphicnovel1.png'),(3,'Crime/detective','Fiction about a crime, how the criminal gets caught and serve time, and the repercussions of the crime ','crime1.jpg'),(4,'Fable','Legendary, supernatural tale demonstrating a useful truth','fable1.jpg'),(5,'Fairy tale','Story about fairies or other magical creature','fairy1.jpg'),(6,'Fantasy','Fiction in a unreal setting that often includes magic, magical creatures, or the supernatural','fantasy1.jpg'),(7,'Historical fiction','Story with fictional characters and events in an historical setting','historical1.jpg'),(8,'Horror','Fiction in which events evoke a feeling of dread and sometimes fear in both the characters and the reader','horror1.png'),(9,'Self-help','Information with the intention of instructing readers on solving personal problems.','selfhelp1.jpg'),(10,'Adventure','An adventure is an event or series of events that happens outside the course of the protagonist\'s ordinary life, usually accompanied by danger, often by physical action. Adventure stories almost always move quickly, and the pace of the plot is at least as important as characterization, setting and other elements of a creative work.','adventure1.jpg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `info` varchar(1000) DEFAULT NULL,
  `picture_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'WebMaster','','admin','admin','admin','WebMaster',NULL),(2,'Lam Ngo','12 Lo Duc, Hbt, Hn','lamngo0000','123','member',NULL,NULL),(14,'UserTest','test','user','user','member','User for testing',NULL);
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

-- Dump completed on 2019-04-11 11:59:05
