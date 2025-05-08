-- 1. film tablosunda replacement_cost sütununda bulunan birbirinden farklı değerleri sırala
SELECT DISTINCT replacement_cost
FROM films
ORDER BY replacement_cost;

-- 2. film tablosunda replacement_cost sütunundaki farklı değerlerin sayısı
SELECT COUNT(DISTINCT replacement_cost) AS farkli_replacement_cost_sayisi
FROM films;

-- 3. film isimlerinden 'T' karakteri ile başlayan ve rating'i 'G' olan kaç film vardır?
SELECT COUNT(*) AS t_ile_baslayan_g_ratingli_film_sayisi
FROM films
WHERE title LIKE 'T%' AND rating = 'G';

-- 4. country tablosunda 5 karakterden oluşan ülke isimlerinin sayısı
SELECT COUNT(*) AS bes_karakterli_ulke_sayisi
FROM country
WHERE LENGTH(country) = 5;

-- 5. city tablosundaki şehir isimlerinden kaç tanesi 'R' veya 'r' ile bitmektedir?
SELECT COUNT(*) AS r_ile_biten_sehir_sayisi
FROM city
WHERE city ILIKE '%r';
