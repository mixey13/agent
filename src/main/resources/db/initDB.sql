DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS price_product;
DROP TABLE IF EXISTS prices;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS price_categories;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  password   VARCHAR NOT NULL
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  title       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL
);

CREATE TABLE organizations
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  full_name       VARCHAR NOT NULL,
  inn        BIGINT NOT NULL,
  address      VARCHAR NOT NULL
);

CREATE TABLE price_categories
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL
);

CREATE TABLE prices
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  number      INTEGER NOT NULL,
  pc_id      INTEGER NOT NULL,
  date    DATE NOT NULL,
  FOREIGN KEY (pc_id) REFERENCES price_categories (id)
);

CREATE TABLE price_product
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  price_id      INTEGER NOT NULL,
  product_id      INTEGER NOT NULL,
  value      REAL NOT NULL,
  FOREIGN KEY (price_id) REFERENCES prices (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE clients
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  full_name       VARCHAR NOT NULL,
  inn        BIGINT NOT NULL,
  address    VARCHAR NOT NULL,
  pc_id      INTEGER NOT NULL,
  FOREIGN KEY (pc_id) REFERENCES price_categories (id)
);

CREATE TABLE orders
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  org_id      INTEGER NOT NULL,
  cli_id      INTEGER NOT NULL,
  total        REAL NOT NULL,
  date    DATE NOT NULL,
  time    TIME NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id),
  FOREIGN KEY (cli_id) REFERENCES clients (id)
);

CREATE TABLE order_product
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  order_id      INTEGER NOT NULL,
  product_id      INTEGER NOT NULL,
  cost        REAL NOT NULL,
  amount        REAL NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders (id),
  FOREIGN KEY (product_id) REFERENCES products (id)
);







