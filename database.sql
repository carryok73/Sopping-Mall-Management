CREATE DATABASE IF NOT EXISTS shopping_mall_db;
USE shopping_mall_db;

DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS owners;

CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE owners (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255) NOT NULL,
    company_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE shops (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    floor VARCHAR(255) NOT NULL,
    shop_number VARCHAR(255) NOT NULL UNIQUE,
    monthly_rent DOUBLE NOT NULL,
    owner_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_shops_owner
        FOREIGN KEY (owner_id)
        REFERENCES owners(id)
);

INSERT INTO customers (name, email, phone, address) VALUES
('Aarav Sharma', 'aarav.sharma@example.com', '9876543210', 'Mumbai, Maharashtra'),
('Priya Mehta', 'priya.mehta@example.com', '9876501234', 'Pune, Maharashtra'),
('Rahul Verma', 'rahul.verma@example.com', '9988776655', 'Delhi');

INSERT INTO owners (name, email, phone, company_name) VALUES
('Neha Kapoor', 'neha.kapoor@example.com', '9123456780', 'Kapoor Retail Pvt Ltd'),
('Vikram Singh', 'vikram.singh@example.com', '9090909090', 'Singh Foods'),
('Ananya Rao', 'ananya.rao@example.com', '9000012345', 'Rao Electronics');

INSERT INTO shops (name, category, floor, shop_number, monthly_rent, owner_id) VALUES
('Fashion Point', 'Fashion', 'Ground Floor', 'G-01', 45000.00, 1),
('Food Fiesta', 'Food Court', 'Second Floor', 'F-12', 60000.00, 2),
('Tech World', 'Electronics', 'First Floor', 'E-07', 52000.00, 3);
