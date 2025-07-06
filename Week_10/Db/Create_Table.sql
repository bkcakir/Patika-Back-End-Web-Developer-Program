-- Veritabanını oluştur
CREATE DATABASE rent_a_car;

-- Veritabanını kullan
\c rent_a_car;

-- Mevcut tabloları sil (varsa)
DROP TABLE IF EXISTS rentals;
DROP TABLE IF EXISTS vehicles;
DROP TABLE IF EXISTS users;

-- Kullanıcılar tablosu
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(20) NOT NULL CHECK (user_type IN ('ADMIN', 'NORMAL', 'CORPORATE')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Kullanıcılar için indeksler
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_user_type ON users(user_type);

-- Araçlar tablosu
CREATE TABLE vehicles (
    id BIGSERIAL PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    vehicle_type VARCHAR(20) NOT NULL CHECK (vehicle_type IN ('CAR', 'MOTORCYCLE', 'HELICOPTER')),
    price DECIMAL(10,2) NOT NULL CHECK (price > 0),
    daily_rate DECIMAL(10,2) NOT NULL CHECK (daily_rate > 0),
    weekly_rate DECIMAL(10,2) NOT NULL CHECK (weekly_rate > 0),
    monthly_rate DECIMAL(10,2) NOT NULL CHECK (monthly_rate > 0),
    available BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Araçlar için indeksler
CREATE INDEX idx_vehicles_brand ON vehicles(brand);
CREATE INDEX idx_vehicles_vehicle_type ON vehicles(vehicle_type);
CREATE INDEX idx_vehicles_available ON vehicles(available);

-- Kiralamalar tablosu
CREATE TABLE rentals (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    vehicle_id BIGINT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    rental_type VARCHAR(20) NOT NULL CHECK (rental_type IN ('HOURLY', 'DAILY', 'WEEKLY', 'MONTHLY')),
    total_price DECIMAL(10,2) NOT NULL CHECK (total_price > 0),
    deposit DECIMAL(10,2) NOT NULL CHECK (deposit > 0),
    status VARCHAR(20) NOT NULL CHECK (status IN ('ACTIVE', 'COMPLETED', 'CANCELLED')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE RESTRICT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE RESTRICT,
    CHECK (end_date > start_date)
);

-- Kiralamalar için indeksler
CREATE INDEX idx_rentals_user_id ON rentals(user_id);
CREATE INDEX idx_rentals_vehicle_id ON rentals(vehicle_id);
CREATE INDEX idx_rentals_status ON rentals(status);
CREATE INDEX idx_rentals_dates ON rentals(start_date, end_date);

-- Güncelleme zamanı için fonksiyon
CREATE OR REPLACE FUNCTION update_timestamp()
RETURNS TRIGGER AS $$
BEGIN
   NEW.updated_at = CURRENT_TIMESTAMP;
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger'lar
CREATE TRIGGER trg_users_updated_at
BEFORE UPDATE ON users
FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE TRIGGER trg_vehicles_updated_at
BEFORE UPDATE ON vehicles
FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE TRIGGER trg_rentals_updated_at
BEFORE UPDATE ON rentals
FOR EACH ROW EXECUTE FUNCTION update_timestamp();