-- DROP TABLE IF EXISTS Users_tb;
-- DROP TABLE IF EXISTS Movies_tb;
-- DROP TABLE IF EXISTS Reviews_tb;

CREATE TABLE Users_tb
(
    id       INT PRIMARY KEY Auto_increment,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE Movies_tb
(
    id           INT PRIMARY KEY Auto_increment,
    title        VARCHAR(255),
    director    VARCHAR(255),
    genre        VARCHAR(255),
    release_date DATE
);

CREATE TABLE Reviews_tb
(
    id         INT PRIMARY KEY Auto_increment,
    user_id    INT,
    movie_id   INT,
    content    VARCHAR(255),
    rating DOUBLE,
    created_at DATE,
    FOREIGN KEY (user_id) REFERENCES Users_tb(id),
    FOREIGN KEY (movie_id) REFERENCES movies_tb(id)
);

