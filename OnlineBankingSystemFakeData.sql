CREATE TABLE `users` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `login_username` varchar(50) NOT NULL,
  `login_password` varchar(50) NOT NULL,
  `secret_question` varchar(50) NOT NULL,
  `secret_answer` varchar(50) NOT NULL,
  `num_failed_logins` tinyint(1) unsigned zerofill NOT NULL,
  `lock_status` tinyint(1) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_username_UNIQUE` (`login_username`)
);
INSERT INTO `online_banking_system`.`users`
(`id`,
`name`,
`login_username`,
`login_password`,
`secret_question`,
`secret_answer`,
`num_failed_logins`,
`lock_status`)
VALUES
(2, "Bob", "bobby", "B123", "What is your name?", "Bob", 0, 0);