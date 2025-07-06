/*
 * RentalType.java
 *
 * Bu enum, kiralama tiplerini tanımlar. Kiralama süresine göre
 * farklı ücretlendirme seçenekleri sunar.
 *
 * Değerler:
 * - HOURLY: Saatlik kiralama
 * - DAILY: Günlük kiralama
 * - WEEKLY: Haftalık kiralama
 * - MONTHLY: Aylık kiralama
 *
 */

package Week_10.Models;

public enum RentalType {
    HOURLY("Saatlik"),
    DAILY("Günlük"),
    WEEKLY("Haftalık"),
    MONTHLY("Aylık");

    private final String displayName;

    RentalType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
} 