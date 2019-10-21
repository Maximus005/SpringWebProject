CREATE DATABASE webproject;
USE webproject;
CREATE TABLE user(
id_user INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name varchar(55) NOT NULL,
last_name varchar(55) NOT NULL,
email VARCHAR(55) NOT NULL unique,
password VARCHAR(55) NOT NULL,
registration_date DATE NOT NULL);

CREATE TABLE task(
id_task INT not null AUTO_INCREMENT primary key,
task_name VARCHAR(60) not null unique,
status VARCHAR(60) not null,
start_date DATE not null,
end_date DATE not null,
id_user INT NOT NULL,
FOREIGN KEY(id_user) REFERENCES user(id_user),
CONSTRAINT CONSTRAINT_STATUS CHECK(status in ('DONE', 'IN PROCESS', 'PAUSED')) );

