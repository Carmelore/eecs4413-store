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
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
admin BOOLEAN DEFAULT FALSE,
PRIMARY KEY (id)
);

CREATE TABLE Discounts (
code VARCHAR(15) NOT NULL,
discount INTEGER() NOT NULL,
required_spending INTEGER() NOT NULL,
discount_type enum('percent','total') NOT NULL,
used BOOLEAN,
PRIMARY KEY (id)
);


