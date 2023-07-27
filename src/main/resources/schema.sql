CREATE TABLE IF NOT EXISTS Employee(
    id SERIAL  PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number BIGINT,
    address VARCHAR(500) NOT NULL,
    city VARCHAR(50) NOT NULL,
    zip_code VARCHAR(255)
    
);
