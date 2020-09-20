CREATE TABLE `user_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `email` UNIQUE varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX(`nickname`),
  UNIQUE INDEX(`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `friend_tb` (
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `valid` tinyint(1) DEFAULT '0',
  primary key(user_id,friend_id)
  foreign key (user_id) references user(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;