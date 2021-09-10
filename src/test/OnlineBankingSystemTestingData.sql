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
(3, "Candy", "candy", "C123", "What is your name?", "Candy", 0, 0);

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
(4, "Danny", "danny", "D123", "What is your name?", "Danny", 0, 0);

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
(5, "Eliane", "elin", "E123", "What is your name?", "Eliane", 0, 0);

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
(6, "Gor", "gor", "G123", "What is your name?", "Gor", 0, 0);

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
(7, "Helen", "helen", "H123", "What is your name?", "Helen", 0, 0);

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
(8 "Iris", "iris", "I123", "What is your name?", "Iris", 0, 0);

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
(9, "Jack", "jacky", "J123", "What is your name?", "Jack", 0, 0);

INSERT INTO `online_banking_system`.`users`
(`id`,
`name`,
`login_username`,
`login_password`,
`secret_question`,
`secret_answer`,
`num_failed_logins`,
`lock_status`)
VALUESs
(10, "Ken", "ken", "K123", "What is your name?", "Ken", 0, 0);