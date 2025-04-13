/**
 * MapMain.java
 * 
 * Bu sınıf, Java'da Map arayüzünün temel kullanımını ve HashMap implementasyonunu gösterir.
 * 
 * Map Nedir?
 * - Anahtar-değer (key-value) çiftlerini saklayan bir veri yapısıdır
 * - Her anahtar benzersizdir (unique)
 * - Anahtarlar null olabilir (HashMap'te)
 * - Değerler null olabilir
 * - Sıralama garantisi yoktur (HashMap'te)
 * 
 * Ne İşe Yarar?
 * - Hızlı arama ve erişim için kullanılır
 * - Veri eşleştirme ve ilişkilendirme için idealdir
 * - Örnek: Öğrenci notları, telefon rehberi, sözlük uygulamaları
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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {
    public static void main(String[] args) {
        // HashMap oluşturma - Anahtar-değer çiftlerini rastgele sırada saklar
        Map<String, Integer> students = new HashMap<>();

        // 1. put() - Anahtar-değer çifti ekleme
        students.put("Burak", 123); // Anahtar: "Burak", Değer: 123
        students.put("Mehmet", 123);
        students.put("Ali", 123);
        students.put("Velihan", 123);
        students.put("Selin", 123);

        // 2. toString() - Tüm haritayı yazdırma
        System.out.println("students:" + students);

        // 3. get() - Anahtara göre değer alma
        System.out.println("Burak Notu : " + students.get("Burak"));

        // 4. keySet() - Tüm anahtarları alma
        System.out.println("Keys:" + students.keySet());

        // 5. values() - Tüm değerleri alma
        System.out.println("Values:" + students.values());

        // 6. remove() - Anahtara göre eleman silme
        students.remove("Ali");
        System.out.println("students:" + students);

        // Tekrar anahtar ve değerleri yazdırma
        System.out.println("Keys:" + students.keySet());
        System.out.println("Values:" + students.values());

        // 7. containsKey() - Anahtar kontrolü
        System.out.println("Burak var mı? " + students.containsKey("Burak"));

        // 8. containsValue() - Değer kontrolü
        System.out.println("123 notu var mı? " + students.containsValue(123));

        // 9. size() - Harita boyutu
        System.out.println("Öğrenci sayısı: " + students.size());

        // 10. isEmpty() - Harita boş mu kontrolü
        System.out.println("Harita boş mu? " + students.isEmpty());

        // 11. clear() - Tüm elemanları silme
        // students.clear();

        // 12. putAll() - Başka bir haritanın tüm elemanlarını ekleme
        Map<String, Integer> newStudents = new HashMap<>();
        newStudents.put("Ahmet", 456);
        newStudents.put("Ayşe", 789);
        students.putAll(newStudents);
        System.out.println("Yeni öğrenciler eklendi: " + students);

        // YAYGIN HATALAR VE ÇÖZÜMLERİ:

        // HATA 1: NullPointerException - null anahtar veya değer kullanımı
        try {
            students.put(null, 100); // Çözüm: null kontrolü yap
            students.put("Ahmet", null);
        } catch (NullPointerException e) {
            System.out.println("HATA: null değer kullanılamaz!");
        }

        // HATA 2: ConcurrentModificationException - Döngüde değişiklik yapma
        try {
            for (String key : students.keySet()) {
                if (key.equals("Burak")) {
                    students.remove(key); // Çözüm: Iterator kullan
                }
            }
        } catch (Exception e) {
            System.out.println("HATA: Döngüde değişiklik yapılamaz!");
        }

        // HATA 3: ClassCastException - Yanlış tip dönüşümü
        try {
            Map<Object, Object> wrongMap = new HashMap<>();
            wrongMap.put(1, "Bir");
            String value = (String) wrongMap.get(1); // Çözüm: Generic kullan
        } catch (ClassCastException e) {
            System.out.println("HATA: Yanlış tip dönüşümü!");
        }

        // HATA 4: OutOfMemoryError - Çok büyük HashMap
        try {
            Map<Integer, String> bigMap = new HashMap<>();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                bigMap.put(i, "Value" + i); // Çözüm: Kapasite sınırı belirle
            }
        } catch (OutOfMemoryError e) {
            System.out.println("HATA: Bellek yetersiz!");
        }

        // HATA 5: IllegalArgumentException - Geçersiz başlangıç kapasitesi
        try {
            Map<String, Integer> invalidMap = new HashMap<>(-1); // Çözüm: Geçerli kapasite kullan
        } catch (IllegalArgumentException e) {
            System.out.println("HATA: Geçersiz kapasite değeri!");
        }
    }
}
