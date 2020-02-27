
-- schema creation

CREATE TABLE customer (
  id         BIGINT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email  VARCHAR(50),
  phone_number VARCHAR(50)
);

CREATE TABLE address (
  id         BIGINT PRIMARY KEY,
  building VARCHAR(30),
  street VARCHAR(30),
  country VARCHAR(30),
  customer_id BIGINT,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE account (
  id         BIGINT PRIMARY KEY,
  balance DOUBLE,
  account_name  VARCHAR(30),
  date_opened DATE,
  customer_id BIGINT,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);