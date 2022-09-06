CREATE TABLE IF NOT EXISTS `Product` (
  `id` int(12) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uk` (`name`),
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
commit;