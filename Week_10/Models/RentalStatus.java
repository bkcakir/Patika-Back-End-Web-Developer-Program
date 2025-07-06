/*
 * RentalStatus.java
 *
 * Bu enum, kiralama durumlarını tanımlar. Kiralama işleminin
 * mevcut durumunu takip etmek için kullanılır.
 *
 * Değerler:
 * - ACTIVE: Aktif kiralama
 * - COMPLETED: Tamamlanmış kiralama
 * - CANCELLED: İptal edilmiş kiralama
 *
 */

package Week_10.Models;

public enum RentalStatus {
    ACTIVE("Aktif"),
    COMPLETED("Tamamlandı"),
    CANCELLED("İptal Edildi");

    private final String displayName;

    RentalStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
} 