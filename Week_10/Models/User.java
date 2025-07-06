/*
 * User.java
 *
 * Bu sınıf, kullanıcı bilgilerini temsil eden model sınıfıdır. Kullanıcıların
 * temel özelliklerini ve işlemlerini içerir.
 *
 * Özellikler:
 * - Kullanıcı kimlik bilgileri (ID, email, şifre)
 * - Kullanıcı tipi (NORMAL, CORPORATE, ADMIN)
 * - Oluşturma ve güncelleme zaman damgaları
 *
 */

package Week_10.Models;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email;
    private String password;



    private UserType userType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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
        return String.format("ID: %d, E-posta: %s, Kullanıcı Tipi: %s, Oluşturulma: %s, Güncelleme: %s",
                id, email, userType, createdAt, updatedAt);
    }
}