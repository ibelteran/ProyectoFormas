CREATE DATABASE IF NOT EXISTS proyecto_formas;

USE proyecto_formas;

CREATE TABLE IF NOT EXISTS formas (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      tipo VARCHAR(50) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    area DOUBLE NOT NULL,
    perimetro DOUBLE NOT NULL,
    volumen DOUBLE NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );