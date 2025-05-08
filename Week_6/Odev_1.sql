SELECT title, description
FROM films
ORDER BY title;

SELECT *
FROM films
WHERE length > 60 AND length < 75
ORDER BY length;

SELECT *
FROM films
WHERE rental_rate = 0.99 AND (replacement_cost = 12.99 OR replacement_cost = 28.99);

SELECT last_name
FROM customers
WHERE first_name = 'Mary';

SELECT *
FROM films
WHERE NOT (length > 50) AND rental_rate NOT IN (2.99, 4.99);
