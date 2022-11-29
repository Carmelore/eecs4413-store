--DROP TABLE Products;
--DROP TABLE Users;

CREATE TABLE Products (
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
name VARCHAR(60) NOT NULL UNIQUE,
description VARCHAR(240),
brand VARCHAR(60) NOT NULL,
type VARCHAR(60) NOT NULL,
price DECIMAL(5, 2) NOT NULL,
quantity INT NOT NULL,
image BLOB,
PRIMARY KEY (id)
);

INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 1', 'the first product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 2', 'the second product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 3', 'the third product', 'special', 'product', 99.99, 2);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 4', 'the fourth product', 'generic', 'non-product', 9.99, 200);

CREATE TABLE Users (
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
name VARCHAR(60) NOT NULL,
username VARCHAR(20) NOT NULL UNIQUE,
password LONG VARCHAR NOT NULL,
admin BOOLEAN DEFAULT FALSE,
PRIMARY KEY (id)
);