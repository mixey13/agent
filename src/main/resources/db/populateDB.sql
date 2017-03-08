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

/*INSERT INTO price_product (price_id, product_id, value) VALUES
  (100008, 100003, 150),
  (100008, 100004, 180),
  (100008, 100005, 120);*/

