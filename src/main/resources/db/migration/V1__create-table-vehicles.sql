CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255),
    model VARCHAR(255),
    color VARCHAR(255),
    plate VARCHAR(255),
    type VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
