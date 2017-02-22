DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
DELETE FROM price_categories;
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