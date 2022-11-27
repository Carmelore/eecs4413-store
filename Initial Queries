CREATE TABLE Product (
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
name VARCHAR(60) NOT NULL UNIQUE,
description VARCHAR(240),
brand VARCHAR(60) NOT NULL,
type VARCHAR(60) NOT NULL,
price DECIMAL(5, 2) NOT NULL,
quantity INT NOT NULL,
CONSTRAINT primary_key PRIMARY KEY (id)
)

ALTER TABLE product ADD image BLOB;

INSERT INTO product(name, description, brand, type, price, quantity) VALUES ('product 1', 'the first product', 'generic', 'product', 9.99, 20);
INSERT INTO product(name, description, brand, type, price, quantity) VALUES ('product 2', 'the second product', 'generic', 'product', 9.99, 20);
INSERT INTO product(name, description, brand, type, price, quantity) VALUES ('product 3', 'the third product', 'special', 'product', 99.99, 2);
INSERT INTO product(name, description, brand, type, price, quantity) VALUES ('product 4', 'the fourth product', 'generic', 'non-product', 9.99, 200);

SELECT * FROM product;