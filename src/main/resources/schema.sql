CREATE TABLE Products (
id SERIAL,
name VARCHAR(60) NOT NULL UNIQUE,
description VARCHAR(240),
brand VARCHAR(60) NOT NULL,
type VARCHAR(60) NOT NULL,
price DECIMAL(5, 2) NOT NULL,
quantity INT NOT NULL,
image VARCHAR(120),
CONSTRAINT primary_key PRIMARY KEY (id)
);

CREATE TABLE Users (
id SERIAL,
name VARCHAR(60) NOT NULL,
username VARCHAR(20) NOT NULL UNIQUE,
password VARCHAR(20) NOT NULL,
shipping_address VARCHAR(200) NOT NULL,
billing_address VARCHAR(200) NOT NULL,
admin BOOLEAN DEFAULT FALSE,
PRIMARY KEY (id)
);

CREATE TABLE Sales (
id SERIAL,
user_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT NOT NULL DEFAULT 1,
created_at DATE NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES Users,
FOREIGN KEY (product_id) REFERENCES Products
);

CREATE TABLE Visits (
id SERIAL,
ip_address VARCHAR(20) NOT NULL,
created_at DATE NOT NULL,
product_id INT NOT NULL,
status VARCHAR(12) NOT NULL DEFAULT 'VIEWED',
FOREIGN KEY (product_id) REFERENCES Products
);

CREATE TABLE Discounts (
id SERIAL,
code VARCHAR(15) NOT NULL,
discount INTEGER() NOT NULL,
required_spending INTEGER() NOT NULL,
discount_type enum('percent','total') NOT NULL,
used BOOLEAN,
PRIMARY KEY (id)
);
