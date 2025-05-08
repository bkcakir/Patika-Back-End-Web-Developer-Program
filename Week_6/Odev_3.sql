-- 1. 'A' harfi ile başlayıp 'a' harfi ile biten ülke isimlerini getir
SELECT country
FROM country
WHERE country LIKE 'A%a';

-- 2. En az 6 karakter uzunluğunda ve 'n' harfi ile biten ülke isimlerini getir
SELECT country
FROM country
WHERE LENGTH(country) >= 6 AND country LIKE '%n';

-- 3. Film isminde büyük/küçük harf duyarsız şekilde en az 4 adet 'T' içerenleri getir
-- PostgreSQL'de regexp_matches ile eşleşme sayısı bulunabilir
SELECT title
FROM films
WHERE array_length(regexp_matches(LOWER(title), 't', 'g'), 1) >= 4;

-- 4. Title 'C' ile başlayan, length > 90 ve rental_rate = 2.99 olan tüm filmleri getir
SELECT *
FROM films
WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;
