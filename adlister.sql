DROP DATABASE IF EXISTS adlister_db;
CREATE DATABASE adlister_db;
USE adlister_db;

DROP USER IF EXISTS 'adlister-user'@'localhost';
CREATE USER 'adlister-user'@'localhost' IDENTIFIED BY 'codeup';
GRANT ALL ON adlister_db.* TO 'adlister-user'@'localhost';

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY (id)
    );

insert into users (username, password, email)
values ('kjorgeron','password','kjorgeron@email.com'),
       ('jtdavis','password','jtdavis@email.com'),
       ('rjdonalds','password','rjdonalds@email.com');


DROP TABLE IF EXISTS ads;
CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(30) UNIQUE NOT NULL,
    description VARCHAR(100) UNIQUE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

insert into ads (user_id, title, description)
values (1, 'the duck', 'its a story of a duck that thought he could'),
       (2, 'rogers', 'this guy is something else'),
       (3, 'scoobydoo', 'idk something about a dog');