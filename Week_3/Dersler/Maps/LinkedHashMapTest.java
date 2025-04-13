/**
 * LinkedHashMapTest.java
 * 
 * Bu sınıf, Java'da LinkedHashMap veri yapısının kullanımını gösterir.
 * 
 * LinkedHashMap Nedir?
 * - HashMap'in özel bir implementasyonudur
 * - Elemanlar eklenme sırasına göre saklanır
 * - Çift yönlü bağlı liste yapısı kullanır
 * - HashMap'ten daha fazla bellek kullanır
 * - Erişim sırası korunur (access-order veya insertion-order)
 * 
 * Ne İşe Yarar?
 * - Sıralı veri saklama gerektiğinde kullanılır
 * - LRU (Least Recently Used) önbellek implementasyonları için idealdir
 * - Örnek: Tarayıcı geçmişi, son kullanılan dosyalar, işlem sıralaması
 * 
 * Önemli Metodlar:
 * - put(): Anahtar-değer çifti ekleme
 * - get(): Anahtara göre değer alma
 * - remove(): Anahtara göre eleman silme
 * - containsKey(): Anahtar kontrolü
 * - containsValue(): Değer kontrolü
 * - keySet(): Tüm anahtarları alma
 * - values(): Tüm değerleri alma
 */

package Week_3.Dersler.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        // LinkedHashMap oluşturma - Elemanlar eklenme sırasına göre saklanır
        Map<String, String> contries = new LinkedHashMap<>();

        // 1. put() - Anahtar-değer çifti ekleme
        contries.put("TR", "Türkiye"); // Ülke kodu: TR, Ülke adı: Türkiye
        contries.put("DE", "Alamanya");
        contries.put("US", "Amerika");

        // 2. toString() - Tüm haritayı yazdırma (eklenme sırasına göre)
        System.out.println("Contries: " + contries);

        // 3. remove() - Anahtara göre eleman silme
        contries.remove("DE"); // Almanya'yı sil

        // 4. put() - Yeni eleman ekleme
        contries.put("FR", "France"); // Fransa'yı ekle

        // Güncellenmiş haritayı yazdırma
        System.out.println("Contries: " + contries);

        // 5. get() - Anahtara göre değer alma
        System.out.println("TR ülkesi: " + contries.get("TR"));

        // 6. containsKey() - Anahtar kontrolü
        System.out.println("US var mı? " + contries.containsKey("US"));

        // 7. containsValue() - Değer kontrolü
        System.out.println("Türkiye var mı? " + contries.containsValue("Türkiye"));

        // 8. size() - Harita boyutu
        System.out.println("Ülke sayısı: " + contries.size());

        // 9. keySet() - Tüm anahtarları alma
        System.out.println("Ülke kodları: " + contries.keySet());

        // 10. values() - Tüm değerleri alma
        System.out.println("Ülke isimleri: " + contries.values());

        // YAYGIN HATALAR VE ÇÖZÜMLERİ:

        // HATA 1: AccessOrder ile ilgili hatalar
        try {
            LinkedHashMap<String, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
            accessOrderMap.put("TR", "Türkiye");
            accessOrderMap.put("US", "Amerika");
            accessOrderMap.get("TR"); // Erişim sırasını değiştirir
            System.out.println("Erişim sırası: " + accessOrderMap); // Çözüm: accessOrder parametresini doğru kullan
        } catch (Exception e) {
            System.out.println("HATA: Erişim sırası hatası!");
        }

        // HATA 2: Sıralama kaybı
        try {
            Map<String, String> unorderedMap = new LinkedHashMap<>();
            unorderedMap.put("B", "Beta");
            unorderedMap.put("A", "Alpha");
            unorderedMap.put("C", "Charlie");
            // Sıralama korunur ama yanlış beklenti olabilir
            System.out.println("Sıralı liste: " + unorderedMap); // Çözüm: TreeMap kullan veya sıralama beklentisini düzelt
        } catch (Exception e) {
            System.out.println("HATA: Sıralama hatası!");
        }

        // HATA 3: Bellek sızıntısı
        try {
            LinkedHashMap<String, byte[]> memoryLeakMap = new LinkedHashMap<>();
            for (int i = 0; i < 1000000; i++) {
                memoryLeakMap.put("key" + i, new byte[1000]); // Çözüm: removeEldestEntry kullan
            }
        } catch (OutOfMemoryError e) {
            System.out.println("HATA: Bellek sızıntısı!");
        }

        // HATA 4: Yanlış kapasite ve yük faktörü
        try {
            LinkedHashMap<String, String> wrongCapacityMap = new LinkedHashMap<>(0, 2.0f); // Çözüm: Uygun değerler kullan
        } catch (IllegalArgumentException e) {
            System.out.println("HATA: Geçersiz kapasite veya yük faktörü!");
        }

        // HATA 5: Eşzamanlı erişim
        try {
            final LinkedHashMap<String, String> concurrentMap = new LinkedHashMap<>();
            new Thread(() -> concurrentMap.put("Thread1", "Value1")).start();
            new Thread(() -> concurrentMap.put("Thread2", "Value2")).start(); // Çözüm: ConcurrentHashMap kullan
        } catch (Exception e) {
            System.out.println("HATA: Eşzamanlı erişim hatası!");
        }
    }
}
