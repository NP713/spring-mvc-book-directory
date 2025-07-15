CREATE DATABASE book_management;
USE book_management;
CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);
INSERT INTO book (title, author, price) VALUES
('Spring in Action', 'Craig Walls', 450.00),
('Effective Java', 'Joshua Bloch', 550.50),
('Clean Code', 'Robert C. Martin', 600.75);
