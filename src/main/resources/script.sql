CREATE TABLE `USERS` (
                         `id` INT PRIMARY KEY AUTO_INCREMENT,
                         `username` VARCHAR(40),
                         `admin` BOOLEAN NOT NULL DEFAULT false,
                         `email` VARCHAR(255),
                         `password` VARCHAR(255),
                         `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);