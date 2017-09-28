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

INSERT INTO organizations (name, full_name, inn, address) VALUES
  ('ООО "Рога и Копыта"', 'Общество с ограниченной ответственностью "Рога и Копыта"', 8888888888, 'г.Нижний Новгород');

INSERT INTO products (org_id, title, description) VALUES
  (100003, 'Колбаса', 'Описание колбасы'),
  (100003, 'Ветчина', 'Описание ветчины'),
  (100003, 'Сосиски', 'Описание сосисок');

INSERT INTO price_categories (name, description) VALUES
  ('ИП', 'Прайс для индивидуального предпринимателя'),
  ('ЮЛ', 'Прайс для юридического лица');


INSERT INTO prices (org_id, pc_id, date) VALUES
  (100003, 100007, '2017-08-20'),
  (100003, 100007, '2017-09-20'),
  (100003, 100008, '2017-08-20'),
  (100003, 100008, '2017-09-20');

INSERT INTO price_product (price_id, product_id, value) VALUES
  (100009, 100004, 150),
  (100009, 100005, 180),
  (100009, 100006, 120),
  (100010, 100004, 152),
  (100010, 100005, 182),
  (100010, 100006, 122),
  (100011, 100004, 160),
  (100011, 100005, 190),
  (100011, 100006, 130),
  (100012, 100004, 163),
  (100012, 100005, 193),
  (100012, 100006, 133);

INSERT INTO clients (name, full_name, inn, address, pc_id) VALUES
  ('ИП Иванов И.И.', 'Индивидуальный предприниматель Иванов Иван Иванович', 111111111111, 'г.Нижний Новгород', 100007),
  ('ООО "Маг"', 'Общество с ограниченной ответственностью Магазин', 2222222222, 'г.Нижний Новгород', 100008);

INSERT INTO orders (org_id, cli_id, total, date, time) VALUES
  (100003, 100025, 750, '2017-08-28', '12:00:00');

INSERT INTO order_product (order_id, product_id, cost, amount) VALUES
  (100027, 100004, 150, 3),
  (100027, 100005, 180, 1),
  (100027, 100006, 120, 1);

INSERT INTO productions (org_id, date, time) VALUES
  (100003, '2017-08-28', '10:00');

INSERT INTO production_product (production_id, product_id, amount) VALUES
  (100031, 100004, 5),
  (100031, 100005, 5),
  (100031, 100006, 5);