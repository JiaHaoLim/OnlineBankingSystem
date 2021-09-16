INSERT INTO `hibernate_sequence` VALUES (3);

INSERT INTO `user` (id, date_created, is_locked, password, username, name, num_failed_logins, secret_answer, secret_question, role) VALUES (1,'2021-09-10 16:38:19.173000',_binary '\0','A123','alicE','Alice',0,'A','What are your initials?', 'BANK_ADMIN'),(2,'2021-09-10 16:38:19.308000',_binary '\0','B123','BobbY','Bobby',0,'B','What are your initials?', 'ACCOUNT_HOLDER');

INSERT INTO `account_holder` (address, email, mobile_number, id) VALUES ('wherever Bobby lives','bob@email.com','98765432',2);

INSERT INTO `bank_admin` VALUES (1);

INSERT INTO `account` (id, account_number, balance, type, account_holder_id) VALUES (1, 138123456789, 5003, 'Savings', 2);

INSERT INTO `transaction` (id, account_id, amount, date_created, description, type) VALUES (1, 2, 30, '2021-09-13', 'Test1', 'Salary'), (2, 2, -10, '2021-09-15', 'Test2', 'Bills');