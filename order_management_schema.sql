
-- Users Table
CREATE TABLE users (
    userId INT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(10) CHECK (role IN ('Admin', 'User')) NOT NULL
);

-- Products Table
CREATE TABLE products (
    productId INT PRIMARY KEY,
    productName VARCHAR(100) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    quantityInStock INT NOT NULL,
    type VARCHAR(20) CHECK (type IN ('Electronics', 'Clothing')) NOT NULL
);

-- Electronics Table
CREATE TABLE electronics (
    productId INT PRIMARY KEY,
    brand VARCHAR(50),
    warrantyPeriod INT,
    FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE
);

-- Clothing Table
CREATE TABLE clothing (
    productId INT PRIMARY KEY,
    size VARCHAR(10),
    color VARCHAR(30),
    FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE
);

-- Orders Table
CREATE TABLE orders (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE
);

-- Order_Products Table
CREATE TABLE order_products (
    orderId INT,
    productId INT,
    quantity INT NOT NULL,
    PRIMARY KEY (orderId, productId),
    FOREIGN KEY (orderId) REFERENCES orders(orderId) ON DELETE CASCADE,
    FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE
);
