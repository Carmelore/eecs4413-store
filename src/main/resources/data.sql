INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 1', 'the first product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 2', 'the second product', 'generic', 'product', 9.99, 20);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 3', 'the third product', 'special', 'product', 99.99, 2);
INSERT INTO products(name, description, brand, type, price, quantity) VALUES ('product 4', 'the fourth product', 'generic', 'non-product', 9.99, 200);

INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Carmela', 'carmelal', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Jeeven', 'JeevenDhanoa', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Adam', 'Addma', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Daniel', 'Mandokero', 'password', 'shipping', 'billing', true);
INSERT INTO users(name, username, password, shipping_address, billing_address, admin) VALUES ('Non-Admin User', 'username', 'password', 'shipping', 'billing', false);

INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (1, 1, 1, '2022-12-09');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (1, 3, 2, '2022-12-09');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (2, 1, 10, '2022-12-09');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (2, 4, 1, '2022-12-03');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (2, 3, 20, '2022-11-09');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (3, 1, 1, '2022-12-04');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (3, 1, 1, '2022-12-05');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (3, 1, 1, '2022-12-09');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (4, 2, 11, '2021-12-09');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (4, 2, 11, '2022-11-29');
INSERT INTO sales(user_id, product_id, quantity, created_at) VALUES (4, 2, 11, '2022-12-09');

INSERT INTO visits(ip_address, created_at, product_id, status) VALUES ('159.203.8.58', '2022-12-09', 1, 'VIEWED');
INSERT INTO visits(ip_address, created_at, product_id, status) VALUES ('54.225.144.155', '2022-12-07', 3, 'IN_CART');
INSERT INTO visits(ip_address, created_at, product_id, status) VALUES ('54.8.33.173', '2022-12-05', 4, 'PURCHASED');
INSERT INTO visits(ip_address, created_at, product_id, status) VALUES ('54.8.33.173', '2022-12-04', 4, 'VIEWED');

INSERT INTO reviews(reviewer, stars, details, product_id) VALUES ('anonymous', 5, 'cool', 1);
INSERT INTO reviews(reviewer, stars, details, product_id) VALUES ('anonymous', 1, 'not cool', 1);
INSERT INTO reviews(reviewer, stars, details, product_id) VALUES ('justin', 3, 'justin', 2);
INSERT INTO reviews(reviewer, stars, details, product_id) VALUES ('anonymous', 2, 'I mean, I guess you tried?', 3);
INSERT INTO reviews(reviewer, stars, details, product_id) VALUES ('nice person', 5, '10/10 would purchase again', 4);
INSERT INTO reviews(reviewer, stars, details, product_id) VALUES ('mean person', 1, null, 4);

INSERT INTO Discounts(code, discount, required_spending, type, used) VALUES ('50%OFF', 50, 0, 'percent', 0);
INSERT INTO Discounts(code, discount, required_spending, type, used) VALUES ('SAVE10', 10, 15, 'total', 0);
INSERT INTO Discounts(code, discount, required_spending, type, used) VALUES ('GSHBCN', 10, 15, 'total', 0);