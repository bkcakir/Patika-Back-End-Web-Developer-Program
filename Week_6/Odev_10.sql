-- 1. CITY ile COUNTRY tablolarını LEFT JOIN ile birleştirerek şehir ve ülke isimlerini listeleme
SELECT CITY.Name AS City, COUNTRY.Name AS Country
FROM CITY
LEFT JOIN COUNTRY ON CITY.CountryCode = COUNTRY.Code;

-- 2. CUSTOMER ile PAYMENT tablolarını RIGHT JOIN ile birleştirerek payment_id ve müşteri bilgilerini listeleme
SELECT PAYMENT.payment_id, CUSTOMER.first_name, CUSTOMER.last_name
FROM CUSTOMER
RIGHT JOIN PAYMENT ON CUSTOMER.customer_id = PAYMENT.customer_id;

-- 3. CUSTOMER ile RENTAL tablolarını FULL JOIN ile birleştirerek rental_id ve müşteri bilgilerini listeleme
SELECT RENTAL.rental_id, CUSTOMER.first_name, CUSTOMER.last_name
FROM CUSTOMER
FULL JOIN RENTAL ON CUSTOMER.customer_id = RENTAL.customer_id;
