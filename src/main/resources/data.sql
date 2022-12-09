INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 1', 'the first product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 2', 'the second product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 3', 'the third product', 'special', 'product', 99.99, 2);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 4', 'the fourth product', 'generic', 'non-product', 9.99, 200);

INSERT INTO users(name, username, password, admin) VALUES ('Carmela', 'carmelal', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Jeeven', 'JeevenDhanoa', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Adam', 'Addma', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Daniel', 'Mandokero', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Non-Admin User', 'username', 'password', false);

--INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES ();

--INSERT INTO visits(ip_address) VALUES ();