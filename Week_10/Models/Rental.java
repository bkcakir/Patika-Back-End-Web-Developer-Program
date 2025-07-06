/*
 * Rental.java
 *
 * Bu sınıf, kiralama işlemlerini temsil eden model sınıfıdır. Kiralama
 * detaylarını ve durumunu içerir.
 *
 * Özellikler:
 * - Kiralama kimlik bilgileri (ID, kullanıcı ID, araç ID)
 * - Kiralama tarihleri (başlangıç, bitiş)
 * - Kiralama tipi (saatlik, günlük, haftalık, aylık)
 * - Toplam fiyat
 * - Kiralama durumu (aktif, tamamlandı, iptal edildi)
 * - Oluşturma ve güncelleme zaman damgaları
 *
 */

package Week_10.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Rental {
    private Long id;
    private Long userId;
    private Long vehicleId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private RentalType rentalType;
    private BigDecimal totalPrice;
    private BigDecimal deposit;
    private RentalStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Rental() {
    }

    public Rental(Long userId, Long vehicleId, LocalDateTime startDate, 
                 LocalDateTime endDate, RentalType rentalType, 
                 BigDecimal totalPrice, BigDecimal deposit, RentalStatus status) {
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalType = rentalType;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.status = status;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
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
        return String.format("Kiralama ID: %d - Kullanıcı ID: %d - Araç ID: %d - Başlangıç: %s - Bitiş: %s - Durum: %s",
                id, userId, vehicleId, startDate, endDate, status);
    }
} 