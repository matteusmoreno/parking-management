CREATE TABLE parking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    cnpj VARCHAR(25),
    cep VARCHAR(15),
    logradouro VARCHAR(255),
    bairro VARCHAR(255),
    localidade VARCHAR(255),
    uf VARCHAR(2),
    motorcycle_spaces INT,
    car_spaces INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    active BOOLEAN
);