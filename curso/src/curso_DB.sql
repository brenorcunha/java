CREATE SCHEMA IF NOT EXISTS `curso` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `curso`;
create table Users(
id integer primary key not null auto_increment,
firstName varchar(50),
lastName varchar(50),
email varchar(255),
phone varchar(50),
password char(50)
);
INSERT INTO users VALUES(0, "Breno","da Cunha","breno@email.com","(10) 90000-0000","1234"),
(0,"Bruno", "Fontoura","bruno@email.com","(10) 90000-0001", "1234"),
(0, "Brendon", "A", "brendon@email.com","(10) 90000-00002", "1234");
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
select * from users;