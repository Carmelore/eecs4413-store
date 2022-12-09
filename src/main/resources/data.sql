INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 1', 'the first product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 2', 'the second product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 3', 'the third product', 'special', 'product', 99.99, 2);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 4', 'the fourth product', 'generic', 'non-product', 9.99, 200);

INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Carmela', 'carmelal', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Jeeven', 'JeevenDhanoa', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Adam', 'Addma', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Daniel', 'Mandokero', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Non-Admin User', 'username', 'password', 'shipping', 'billing', false);