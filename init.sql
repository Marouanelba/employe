-- Script de création de la base de données et de la table employe (Étape 1.6 du TP)
CREATE DATABASE IF NOT EXISTS employedb;
USE employedb;

CREATE TABLE IF NOT EXISTS employe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

-- Insertion de données de test (comme montré dans la capture du TP: id=10, name='Benali', age=25)
INSERT INTO employe (id, name, age) VALUES 
(10, 'Benali', 25),
(11, 'Alami', 30),
(12, 'Idrissi', 28)
ON DUPLICATE KEY UPDATE name=VALUES(name), age=VALUES(age);
