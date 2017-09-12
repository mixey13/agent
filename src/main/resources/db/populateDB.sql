DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
DELETE FROM price_categories;
DELETE FROM prices;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, password) VALUES
  ('admin', ''),
  ('operator', ''),
  ('agent', '');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100000),
  ('ROLE_OPERATOR', 100001),
  ('ROLE_AGENT', 100002);

INSERT INTO products (title, description) VALUES
  ('Колбаса', 'Описание колбасы'),
  ('Ветчина', 'Описание ветчины'),
  ('Сосиски', 'Описание сосисок');

INSERT INTO price_categories (name, description) VALUES
  ('ИП', 'Прайс для индивидуального предпринимателя'),
  ('ЮЛ', 'Прайс для юридического лица');


INSERT INTO prices (number, pc_id, date) VALUES
  (1, 100006, '2017-02-28');

INSERT INTO price_product (price_id, product_id, value) VALUES
  (100008, 100003, 150),
  (100008, 100004, 180),
  (100008, 100005, 120);

INSERT INTO organizations (name, full_name, inn, address) VALUES
  ('ООО "Рога и Копыта"', 'Общество с ограниченной ответственностью "Рога и Копыта"', 8888888888, 'г.Нижний Новгород');

INSERT INTO clients (name, full_name, inn, address, pc_id) VALUES
  ('ИП Иванов И.И.', 'Индивидуальный предприниматель Иванов Иван Иванович', 111111111111, 'г.Нижний Новгород', 100006);

INSERT INTO orders (org_id, cli_id, total, date, time) VALUES
  (100012, 100013, 750, '2017-02-28', '12:00:00');

INSERT INTO order_product (order_id, product_id, cost, amount) VALUES
  (100014, 100003, 150, 3),
  (100014, 100004, 180, 1),
  (100014, 100005, 120, 1);

INSERT INTO productions (org_id, date, time) VALUES
  (100012, '2017-02-28', '10:00');

INSERT INTO production_product (production_id, product_id, amount) VALUES
  (100018, 100003, 5),
  (100018, 100004, 5),
  (100018, 100005, 5);