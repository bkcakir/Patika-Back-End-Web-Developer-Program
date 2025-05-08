-- 1. Tüm benzersiz first_name verilerini (birleşim) sıralayalım:
SELECT DISTINCT first_name FROM actor
UNION
SELECT DISTINCT first_name FROM customer
ORDER BY first_name;

-- 2. Benzersiz first_name verilerinin kesişimini (her iki tabloda olanlar) sıralayalım:
SELECT DISTINCT a.first_name
FROM actor a
INNER JOIN customer c ON a.first_name = c.first_name
ORDER BY a.first_name;

-- 3. actor tablosundaki ancak customer tablosunda olmayan benzersiz first_name verileri:
SELECT DISTINCT first_name FROM actor
WHERE first_name NOT IN (
    SELECT DISTINCT first_name FROM customer
)
ORDER BY first_name;

-- 4. Tüm first_name verilerini tekrar edenlerle birlikte sıralayalım (ALL):
SELECT first_name FROM actor
UNION ALL
SELECT first_name FROM customer
ORDER BY first_name;

-- 5. Kesişen first_name verilerini tekrar edenlerle birlikte (JOIN ile):
SELECT a.first_name
FROM actor a
JOIN customer c ON a.first_name = c.first_name
ORDER BY a.first_name;

-- 6. actor tablosundaki fakat customer tablosunda bulunmayan tekrar eden first_name verileri:
SELECT a.first_name
FROM actor a
LEFT JOIN customer c ON a.first_name = c.first_name
WHERE c.first_name IS NULL
ORDER BY a.first_name;
