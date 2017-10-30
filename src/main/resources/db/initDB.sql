DROP VIEW IF EXISTS public.balance RESTRICT;
ALTER TABLE IF EXISTS public.user_roles DROP CONSTRAINT IF EXISTS user_roles_user_id_fkey;
ALTER TABLE IF EXISTS public.production_product DROP CONSTRAINT IF EXISTS production_product_production_id_fkey;
ALTER TABLE IF EXISTS public.production_product DROP CONSTRAINT IF EXISTS production_product_product_id_fkey;
ALTER TABLE IF EXISTS public.price_product DROP CONSTRAINT IF EXISTS price_product_price_id_fkey;
ALTER TABLE IF EXISTS public.price_product DROP CONSTRAINT IF EXISTS price_product_product_id_fkey;
ALTER TABLE IF EXISTS public.order_product DROP CONSTRAINT IF EXISTS order_product_order_id_fkey;
ALTER TABLE IF EXISTS public.order_product DROP CONSTRAINT IF EXISTS order_product_product_id_fkey;
ALTER TABLE IF EXISTS public.contracts DROP CONSTRAINT IF EXISTS contracts_org_id_fkey;
ALTER TABLE IF EXISTS public.contracts DROP CONSTRAINT IF EXISTS contracts_cli_id_fkey;
ALTER TABLE IF EXISTS public.contracts DROP CONSTRAINT IF EXISTS contracts_pc_id_fkey;
ALTER TABLE IF EXISTS public.admin_roles DROP CONSTRAINT IF EXISTS admin_roles_admin_id_fkey;
ALTER TABLE IF EXISTS public.prices DROP CONSTRAINT IF EXISTS prices_org_id_fkey;
ALTER TABLE IF EXISTS public.prices DROP CONSTRAINT IF EXISTS prices_pc_id_fkey;
ALTER TABLE IF EXISTS public.orders DROP CONSTRAINT IF EXISTS orders_org_id_fkey;
ALTER TABLE IF EXISTS public.orders DROP CONSTRAINT IF EXISTS orders_cli_id_fkey;
ALTER TABLE IF EXISTS public.users DROP CONSTRAINT IF EXISTS users_org_id_fkey;
ALTER TABLE IF EXISTS public.products DROP CONSTRAINT IF EXISTS products_org_id_fkey;
ALTER TABLE IF EXISTS public.productions DROP CONSTRAINT IF EXISTS productions_org_id_fkey;
ALTER TABLE IF EXISTS public.price_categories DROP CONSTRAINT IF EXISTS price_categories_org_id_fkey;
DROP TABLE IF EXISTS public.user_roles;
DROP TABLE IF EXISTS public.production_product;
DROP TABLE IF EXISTS public.price_product;
DROP TABLE IF EXISTS public.order_product;
DROP TABLE IF EXISTS public.contracts;
DROP TABLE IF EXISTS public.admin_roles;
DROP TABLE IF EXISTS public.prices;
DROP TABLE IF EXISTS public.orders;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.products;
DROP TABLE IF EXISTS public.productions;
DROP TABLE IF EXISTS public.price_categories;
DROP TABLE IF EXISTS public.organizations;
DROP TABLE IF EXISTS public.clients;
DROP TABLE IF EXISTS public.admins;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE admins
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  password   VARCHAR NOT NULL
);

CREATE TABLE admin_roles
(
  admin_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT admin_roles_idx UNIQUE (admin_id, role),
  FOREIGN KEY (admin_id) REFERENCES admins (id) ON DELETE CASCADE
);

CREATE TABLE organizations
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  full_name       VARCHAR NOT NULL,
  inn        BIGINT NOT NULL,
  address      VARCHAR NOT NULL
);

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  org_id      INTEGER NOT NULL,
  name       VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id)
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
  org_id      INTEGER NOT NULL,
  title       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE price_categories
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  org_id      INTEGER NOT NULL,
  name       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE prices
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  org_id      INTEGER NOT NULL,
  pc_id      INTEGER NOT NULL,
  date    DATE NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id),
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
  address    VARCHAR NOT NULL
);

CREATE TABLE productions
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  org_id      INTEGER NOT NULL,
  date    DATE NOT NULL,
  time    TIME NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE production_product
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  production_id      INTEGER NOT NULL,
  product_id      INTEGER NOT NULL,
  amount        REAL NOT NULL,
  FOREIGN KEY (production_id) REFERENCES productions (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE contracts
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  org_id      INTEGER NOT NULL,
  cli_id      INTEGER NOT NULL,
  pc_id      INTEGER NOT NULL,
  FOREIGN KEY (org_id) REFERENCES organizations (id),
  FOREIGN KEY (cli_id) REFERENCES clients (id),
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
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE VIEW balance AS
  SELECT id, product_id, amount, org_id, date FROM
    (SELECT production_product.id, product_id, amount, org_id, date FROM productions LEFT JOIN production_product ON productions.id = production_product.production_id
     UNION ALL
     SELECT order_product.id, product_id, -amount, org_id, date FROM orders LEFT JOIN order_product ON orders.id = order_product.order_id
    ) AS T