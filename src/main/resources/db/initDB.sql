DROP TABLE IF EXISTS products;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE products
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  title       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL
);