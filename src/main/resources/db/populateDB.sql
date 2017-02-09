DELETE FROM products;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO products (title, description) VALUES
  ('Колбаса', 'Описание колбасы'),
  ('Ветчина', 'Описание ветчины'),
  ('Сосиски', 'Описание сосисок');