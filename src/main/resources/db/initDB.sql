ALTER TABLE IF EXISTS public.user_roles DROP CONSTRAINT IF EXISTS user_roles_user_id_fkey;
ALTER TABLE IF EXISTS public.production_product DROP CONSTRAINT IF EXISTS production_product_production_id_fkey;
ALTER TABLE IF EXISTS public.production_product DROP CONSTRAINT IF EXISTS production_product_product_id_fkey;
ALTER TABLE IF EXISTS public.price_product DROP CONSTRAINT IF EXISTS price_product_price_id_fkey;
ALTER TABLE IF EXISTS public.price_product DROP CONSTRAINT IF EXISTS price_product_product_id_fkey;
ALTER TABLE IF EXISTS public.order_product DROP CONSTRAINT IF EXISTS order_product_order_id_fkey;
ALTER TABLE IF EXISTS public.order_product DROP CONSTRAINT IF EXISTS order_product_product_id_fkey;
ALTER TABLE IF EXISTS public.balance DROP CONSTRAINT IF EXISTS balance_product_id_fkey;
ALTER TABLE IF EXISTS public.prices DROP CONSTRAINT IF EXISTS prices_org_id_fkey;
ALTER TABLE IF EXISTS public.prices DROP CONSTRAINT IF EXISTS prices_pc_id_fkey;
ALTER TABLE IF EXISTS public.orders DROP CONSTRAINT IF EXISTS orders_org_id_fkey;
ALTER TABLE IF EXISTS public.orders DROP CONSTRAINT IF EXISTS orders_cli_id_fkey;
ALTER TABLE IF EXISTS public.products DROP CONSTRAINT IF EXISTS products_org_id_fkey;
ALTER TABLE IF EXISTS public.productions DROP CONSTRAINT IF EXISTS productions_org_id_fkey;
ALTER TABLE IF EXISTS public.clients DROP CONSTRAINT IF EXISTS clients_pc_id_fkey;
DROP TABLE IF EXISTS public.user_roles;
DROP TABLE IF EXISTS public.production_product;
DROP TABLE IF EXISTS public.price_product;
DROP TABLE IF EXISTS public.order_product;
DROP TABLE IF EXISTS public.balance;
DROP TABLE IF EXISTS public.prices;
DROP TABLE IF EXISTS public.orders;
DROP TABLE IF EXISTS public.products;
DROP TABLE IF EXISTS public.productions;
DROP TABLE IF EXISTS public.clients;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.price_categories;
DROP TABLE IF EXISTS public.organizations;
DROP SEQUENCE IF EXISTS global_seq;
DROP FUNCTION IF EXISTS update_balance();

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE admins
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  role       VARCHAR
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
  name       VARCHAR NOT NULL,
  description      VARCHAR NOT NULL
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
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id)
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

CREATE TABLE balance
(
  product_id       INT NOT NULL PRIMARY KEY,
  amount        REAL NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE FUNCTION update_balance() RETURNS TRIGGER AS $$
BEGIN
  DELETE FROM balance;
  INSERT INTO balance
    (SELECT T1.product_id, SUM(T1.amount) FROM
      (SELECT product_id, amount FROM production_product UNION ALL SELECT product_id, -amount FROM order_product)
        AS T1 GROUP BY T1.product_id ORDER BY T1.product_id);
  RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tr
AFTER INSERT OR UPDATE OR DELETE ON production_product
FOR EACH STATEMENT EXECUTE PROCEDURE update_balance();

CREATE TRIGGER tr
AFTER INSERT OR UPDATE OR DELETE ON order_product
FOR EACH STATEMENT EXECUTE PROCEDURE update_balance();





