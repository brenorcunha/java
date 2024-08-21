CREATE SCHEMA IF NOT EXISTS `curso` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `curso`;
ALTER TABLE `curso`.`users` 
DROP COLUMN `last_name`,
DROP COLUMN `first_name`;

create table users(
id integer primary key not null auto_increment,
fName varchar(50),
lName varchar(50),
email varchar(255),
phone varchar(50),
password char(50)
);
INSERT INTO users VALUES(0, "brenorc@email.com", "Breno","da Cunha","(10) 90000-0000","1234"),
(0,"bruno@email.com", "Bruno", "Fontoura","(10) 90000-0001", "1234"),
(0, "brendon@email.com", "Brendon", "Alves", "(10) 90000-00002", "1234");
GRANT ALL PRIVILEGES ON *.* TO 'breno'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
select * from Users;