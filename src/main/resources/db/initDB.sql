DROP TABLE IF EXISTS user_roles;
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
  inn        INTEGER NOT NULL,
  address      VARCHAR NOT NULL
);

CREATE TABLE price_categories
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL
);

CREATE TABLE clients
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  inn        INTEGER NOT NULL,
  address    VARCHAR NOT NULL,
  pc_id      INTEGER NOT NULL,
  FOREIGN KEY (pc_id) REFERENCES price_categories (id)
);

CREATE TABLE prices
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  pc_id      INTEGER NOT NULL,
  product_id      INTEGER NOT NULL,
  value      INTEGER NOT NULL,
  FOREIGN KEY (pc_id) REFERENCES price_categories (id),
  FOREIGN KEY (product_id) REFERENCES products (id)
);





