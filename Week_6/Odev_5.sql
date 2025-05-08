-- 1. 'n' karakteri ile biten en uzun 5 filmi sırala (title, length)
SELECT title, length
FROM films
WHERE title LIKE '%n'
ORDER BY length DESC
LIMIT 5;

-- 2. 'n' karakteri ile biten en kısa (6,7,8,9,10) 5 filmi sırala (title, length)
SELECT title, length
FROM films
WHERE title LIKE '%n' AND length IN (6, 7, 8, 9, 10)
ORDER BY length ASC
LIMIT 5;

-- 3. store_id 1 olan ve last_name'e göre azalan sırada ilk 4 müşteri
SELECT *
FROM customers
WHERE store_id = 1
ORDER BY last_name DESC
LIMIT 4;
