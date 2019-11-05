
CREATE TABLE if not exists user(
                    id int AUTO_INCREMENT not null PRIMARY KEY,
                    firstName varchar(55) NOT NULL,
                    lastName varchar(55) NOT NULL,
                    email VARCHAR(55) NOT NULL unique,
                    password VARCHAR(55) NOT NULL,
                    registrationDate DATE NOT NULL,
                    subscription VARCHAR(55),
                    userRole int,
);

CREATE TABLE if not exists task (
                    id INT not null AUTO_INCREMENT primary key,
                    taskName VARCHAR(55) not null unique,
                    dateOfFinished DATE,
                    description VARCHAR(255),
                    userId INT NOT NULL,
                    priority int NOT NULL,
                    status boolean,
                    FOREIGN KEY(userId) REFERENCES user(id)
);
