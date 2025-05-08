-- 1. rental_rate sütunundaki değerlerin ortalaması nedir?
SELECT AVG(rental_rate) AS ortalama_rental_rate
FROM films;

-- 2. Film isimlerinden (title) kaç tanesi 'C' karakteri ile başlar?
SELECT COUNT(*) AS c_ile_baslayan_film_sayisi
FROM films
WHERE title LIKE 'C%';

-- 3. rental_rate değeri 0.99'a eşit olan en uzun (length) film kaç dakikadır?
SELECT MAX(length) AS en_uzun_film_dakika
FROM films
WHERE rental_rate = 0.99;

-- 4. Film uzunluğu 150 dakikadan büyük olan filmlerden kaç farklı replacement_cost değeri vardır?
SELECT COUNT(DISTINCT replacement_cost) AS farkli_replacement_cost_sayisi
FROM films
WHERE length > 150;
