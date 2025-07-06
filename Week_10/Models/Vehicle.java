/*
 * Vehicle.java
 *
 * Bu sınıf, araç bilgilerini temsil eden model sınıfıdır. Araçların temel
 * özelliklerini ve fiyatlandırma bilgilerini içerir.
 *
 * Özellikler:
 * - Araç kimlik bilgileri (ID, marka, model)
 * - Araç tipi ve durumu
 * - Fiyatlandırma (günlük, haftalık, aylık ücretler)
 * - Müsaitlik durumu
 * - Oluşturma ve güncelleme zaman damgaları
 *
 */

package Week_10.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private VehicleType vehicleType;
    private BigDecimal price;
    private BigDecimal hourlyRate;
    private BigDecimal dailyRate;
    private BigDecimal weeklyRate;
    private BigDecimal monthlyRate;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Vehicle() {}
    public Vehicle(String brand, String model, VehicleType vehicleType, 
                  double price, double hourlyRate, double dailyRate, 
                  double weeklyRate, double monthlyRate, boolean available) {
        this.brand = brand;
        this.model = model;
        this.vehicleType = vehicleType;
        this.price = BigDecimal.valueOf(price);
        this.hourlyRate = BigDecimal.valueOf(hourlyRate);
        this.dailyRate = BigDecimal.valueOf(dailyRate);
        this.weeklyRate = BigDecimal.valueOf(weeklyRate);
        this.monthlyRate = BigDecimal.valueOf(monthlyRate);
        this.available = available;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public BigDecimal getWeeklyRate() {
        return weeklyRate;
    }

    public void setWeeklyRate(BigDecimal weeklyRate) {
        this.weeklyRate = weeklyRate;
    }

    public BigDecimal getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(BigDecimal monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("Araç: %s %s (%s) - Fiyat: %s TL - Müsait: %s",
                brand, model, vehicleType.getDisplayName(), price, 
                available ? "Evet" : "Hayır");
    }
} 