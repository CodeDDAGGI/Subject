-- Users 테이블
CREATE TABLE Users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Movies 테이블
CREATE TABLE Movies (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        director VARCHAR(100),
                        genre VARCHAR(50),
                        release_date DATE NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Reviews 테이블
CREATE TABLE Reviews (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         movie_id BIGINT NOT NULL,
                         user_id BIGINT NOT NULL,
                         rating DECIMAL(2,1) CHECK (rating >= 0 AND rating <= 5),
                         content TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (movie_id) REFERENCES Movies(id) ON DELETE CASCADE,
                         FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
);
