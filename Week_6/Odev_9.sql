-- 1. CITY ve COUNTRY tablosunu birleştirerek şehir (city) ve ülke (country) isimlerini almak:
SELECT CITY.Name AS City, COUNTRY.Name AS Country
FROM CITY
INNER JOIN COUNTRY ON CITY.CountryCode = COUNTRY.Code;

-- 2. CUSTOMER ve PAYMENT tablosunu birleştirerek payment_id ile first_name ve last_name isimlerini almak:
SELECT PAYMENT.payment_id, CUSTOMER.first_name, CUSTOMER.last_name
FROM CUSTOMER
INNER JOIN PAYMENT ON CUSTOMER.customer_id = PAYMENT.customer_id;

-- 3. CUSTOMER ve RENTAL tablosunu birleştirerek rental_id ile first_name ve last_name isimlerini almak:
SELECT RENTAL.rental_id, CUSTOMER.first_name, CUSTOMER.last_name
FROM CUSTOMER
INNER JOIN RENTAL ON CUSTOMER.customer_id = RENTAL.customer_id;
