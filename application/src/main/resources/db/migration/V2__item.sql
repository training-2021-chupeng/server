CREATE TABLE `item`
(
`id` int(11) NOT NULL AUTO_INCREMENT,
barcode varchar(20) NOT NULL,
name varchar(50) NOT NULL,
unit varchar(10) NOT NULL,
price decimal(10, 2) NOT NULL,
`type` varchar(20) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;