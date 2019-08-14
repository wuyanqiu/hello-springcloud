/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 8.0.17 : Database - springcloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springcloud` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `springcloud`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`id`,`departmentname`) values (1,'人力资源部'),(2,'EHS部');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(20) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'qingxiuigai@163.com',
  `gender` int(1) NOT NULL DEFAULT '1',
  `deptId` int(11) DEFAULT '1',
  `birth` date NOT NULL DEFAULT '1970-01-01',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '123456',
  `verification` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deptId` (`deptId`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`deptId`) REFERENCES `dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`lastname`,`email`,`gender`,`deptId`,`birth`,`password`,`verification`) values (1,'zhangsan','zhangsan@163.com',1,1,'2019-06-13','123456',NULL),(2,'a','a@163.com',0,1,'2019-07-26','123456',NULL),(3,'ba','b@163.com',0,1,'2019-08-04','123456',NULL),(12,'lisi9','510756382@qq.com',1,1,'1969-12-31','123456','123456'),(13,'[lisi]','[510756382@qq.com]',1,1,'1970-01-01','123456','[123456]'),(14,'lisi','510756382@qq.com',1,1,'1970-01-01','123456','123456'),(15,'lisi8','510756382@qq.com',1,1,'1970-01-01','888999','666666'),(16,'lisi99','123@qq.com',1,2,'2019-08-01','123456',NULL),(17,'zhangsan2107','510756382@qq.com',1,1,'1970-01-01','123456','980682'),(18,'zhangsan2109','510756382@qq.com',1,1,'1970-01-01','123456','660549'),(19,'quanchaoyang','510756382@qq.com',1,1,'1970-01-01','123456','419279'),(20,'yanglinxiao','510756382@qq.com',1,1,'1970-01-01','123456','844214'),(21,'yanlinxiao8','510756382@qq.com',1,1,'1970-01-01','123456','172383'),(22,'asfdasfdsaf','510756382@qq.com',1,1,'1970-01-01','123456','515032'),(23,'abcdsafd','xxx',1,1,'1970-01-01','123456','286145'),(24,'aadfadfassfdfds','xxxxxxx',1,1,'1970-01-01','123456','164164'),(25,'xxfsdaf','afdsafdsa',1,1,'1970-01-01','123456','920922'),(26,'safdsa','dfsafdsa',1,1,'1970-01-01','123456','231634'),(27,'safds','fdsafds',1,1,'1970-01-01','123456','721082'),(28,'afdsa','dsafdsa',1,1,'1970-01-01','123456','374817'),(29,'fadfdsa','fdsafdsa',1,1,'1970-01-01','123456','298646'),(30,'djhasgjdadgahjud','dkajhdjasjk',1,1,'1970-01-01','123456','879930'),(31,'fsafdsaf','asfdas',1,1,'1970-01-01','123456','964100'),(32,'afsds','afsdsafdsaf',1,1,'1970-01-01','123456','360627'),(33,'fdsafdsa','dsafdsafdsafd',1,1,'1970-01-01','123456','518834'),(34,'fdasfd','fdsafdsa',1,1,'1970-01-01','123456','142745'),(35,'yryry','yryryr',1,1,'1970-01-01','123456','576941'),(36,'534533','534535353',1,1,'1970-01-01','123456','830838'),(37,'fasdf','safdsa',1,1,'1970-01-01','123456','135694'),(38,'6456456','645645',1,1,'1970-01-01','123456','349489'),(39,'dsafdsafd','fdsafdsa',1,1,'1970-01-01','123456','503470'),(40,'dsafd','dsaf',1,1,'1970-01-01','123456','101842'),(41,'张三','510756382@qq.com',1,1,'1970-01-01','123456','337527'),(42,'lisi233','510756382@qq.com',1,2,'1970-01-09','888999','757095'),(43,'强树恒','510756382@qq.com',1,1,'1970-01-01','123456','996435'),(44,'adsafdsa','510756382@qq.com',1,1,'1970-01-01','789789','707696');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
