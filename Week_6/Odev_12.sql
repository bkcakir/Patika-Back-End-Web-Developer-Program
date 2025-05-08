-- 1. Ortalama film uzunluğundan daha uzun kaç film var?
SELECT COUNT(*) AS Uzun_Film_Sayisi
FROM film
WHERE length > (
    SELECT AVG(length) FROM film
);

-- 2. En yüksek rental_rate değerine sahip kaç film var?
SELECT COUNT(*) AS En_Yuksek_Rental_Rate_Film_Sayisi
FROM film
WHERE rental_rate = (
    SELECT MAX(rental_rate) FROM film
);

-- 3. En düşük rental_rate ve en düşük replacement_cost değerine sahip filmleri listele:
SELECT *
FROM film
WHERE rental_rate = (SELECT MIN(rental_rate) FROM film)
  AND replacement_cost = (SELECT MIN(replacement_cost) FROM film);

-- 4. payment tablosunda en çok işlem yapan müşterileri customer_id sayıya göre azalan şekilde sıralayınız:
SELECT customer_id, COUNT(*) AS toplam_odeme_sayisi
FROM payment
GROUP BY customer_id
ORDER BY toplam_odeme_sayisi DESC;
