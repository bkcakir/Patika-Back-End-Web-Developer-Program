-- 1. film tablosunda bulunan filmleri rating değerlerine göre grupla
SELECT rating, COUNT(*) AS film_sayisi
FROM films
GROUP BY rating
ORDER BY rating;

-- 2. replacement_cost sütununa göre gruplayıp, film sayısı 50'den fazla olan replacement_cost değeri ve film sayısını sıralayalım
SELECT replacement_cost, COUNT(*) AS film_sayisi
FROM films
GROUP BY replacement_cost
HAVING COUNT(*) > 50
ORDER BY film_sayisi DESC;

-- 3. customer tablosunda store_id'ye göre müşteri sayılarını sıralayalım
SELECT store_id, COUNT(*) AS musteri_sayisi
FROM customers
GROUP BY store_id
ORDER BY store_id;

-- 4. city tablosunda country_id'ye göre gruplayıp, en fazla şehir sayısı barındıran country_id ve şehir sayısını bulalım
SELECT country_id, COUNT(*) AS sehir_sayisi
FROM city
