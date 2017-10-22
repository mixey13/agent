DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
DELETE FROM price_categories;
DELETE FROM prices;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO admins (name, password, role) VALUES
  ('root', 'root', 'ROLE_ROOT');

INSERT INTO organizations (name, full_name, inn, address) VALUES
  ('ООО "Рога и Копыта"', 'Общество с ограниченной ответственностью "Рога и Копыта"', 8888888888, 'г.Нижний Новгород');

INSERT INTO users (org_id, name, password) VALUES
  (100001, 'admin', '123'),
  (100001, 'operator', '123'),
  (100001, 'agent', '123');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100002),
  ('ROLE_OPERATOR', 100003),
  ('ROLE_AGENT', 100004);

INSERT INTO products (org_id, title, description) VALUES
  (100001, 'Колбаса', 'Описание колбасы'),
  (100001, 'Ветчина', 'Описание ветчины'),
  (100001, 'Сосиски', 'Описание сосисок');

INSERT INTO price_categories (name, description) VALUES
  ('ИП', 'Прайс для индивидуального предпринимателя'),
  ('ЮЛ', 'Прайс для юридического лица');


INSERT INTO prices (org_id, pc_id, date) VALUES
  (100001, 100008, '2017-08-20'),
  (100001, 100008, '2017-09-20'),
  (100001, 100009, '2017-08-20'),
  (100001, 100009, '2017-09-20');

INSERT INTO price_product (price_id, product_id, value) VALUES
  (100010, 100005, 150),
  (100010, 100006, 180),
  (100010, 100007, 120),
  (100011, 100005, 152),
  (100011, 100006, 182),
  (100011, 100007, 122),
  (100012, 100005, 160),
  (100012, 100006, 190),
  (100012, 100007, 130),
  (100013, 100005, 163),
  (100013, 100006, 193),
  (100013, 100007, 133);

INSERT INTO clients (name, full_name, inn, address, pc_id) VALUES
  ('ИП Иванов И.И.', 'Индивидуальный предприниматель Иванов Иван Иванович', 111111111111, 'г.Нижний Новгород', 100008),
  ('ООО "Маг"', 'Общество с ограниченной ответственностью Магазин', 2222222222, 'г.Нижний Новгород', 100009);

-- INSERT INTO orders (org_id, cli_id, total, date, time) VALUES
--   (100003, 100025, 750, '2017-08-28', '12:00:00');
--
-- INSERT INTO order_product (order_id, product_id, cost, amount) VALUES
--   (100027, 100004, 150, 3),
--   (100027, 100005, 180, 1),
--   (100027, 100006, 120, 1);
--
-- INSERT INTO productions (org_id, date, time) VALUES
--   (100003, '2017-08-28', '10:00');
--
-- INSERT INTO production_product (production_id, product_id, amount) VALUES
--   (100031, 100004, 5),
--   (100031, 100005, 5),
--   (100031, 100006, 5);