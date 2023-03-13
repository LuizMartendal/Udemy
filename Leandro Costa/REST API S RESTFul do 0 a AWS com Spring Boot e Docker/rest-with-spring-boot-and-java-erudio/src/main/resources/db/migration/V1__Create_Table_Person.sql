CREATE TABLE IF NOT EXISTS `person` (
  `id` binary(16) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
);

