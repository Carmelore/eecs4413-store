INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 1', 'the first product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 2', 'the second product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 3', 'the third product', 'special', 'product', 99.99, 2);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 4', 'the fourth product', 'generic', 'non-product', 9.99, 200);

INSERT INTO users(name, username, password, admin) VALUES ('Carmela', 'carmelal', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Jeeven', 'JeevenDhanoa', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Adam', 'Addma', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Daniel', 'Mandokero', 'password', true);
INSERT INTO users(name, username, password, admin) VALUES ('Non-Admin User', 'username', 'password', false);

INSERT INTO Discounts(code, discount, required_spending, discount_type, used) VALUES ('50%OFF', 50, 0, 'percent', 0);
INSERT INTO Discounts(code, discount, required_spending, discount_type, used) VALUES ('SAVE10', 10, 15, 'total', 0);
INSERT INTO Discounts(code, discount, required_spending, discount_type, used) VALUES ('GSHBCN', 10, 15, 'total', 0);