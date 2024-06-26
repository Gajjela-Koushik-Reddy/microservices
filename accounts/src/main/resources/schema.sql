CREATE TABLE customers (
    `customer_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `mobile_number` VARCHAR(20) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(20) DEFAULT NULL
);

CREATE TABLE accounts (
    `customer_id` INT PRIMARY KEY,
    `account_number` VARCHAR(20) NOT NULL,
    `account_type` DECIMAL(10, 2) NOT NULL,
    `branch_address` VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(20) DEFAULT NULL
);