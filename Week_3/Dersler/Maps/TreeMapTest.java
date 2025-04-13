/**
 * TreeMapTest.java
 * 
 * Bu sınıf, Java'da TreeMap veri yapısının kullanımını gösterir.
 * 
 * TreeMap Nedir?
 * - Kırmızı-siyah ağaç (Red-Black Tree) veri yapısını kullanır
 * - Anahtarlar doğal sıralamaya göre saklanır
 * - Anahtarlar Comparable interface'ini implemente etmelidir
 * - null anahtar kullanılamaz
 * - Sıralı erişim sağlar
 * 
 * Ne İşe Yarar?
 * - Sıralı veri saklama gerektiğinde kullanılır
 * - Aralık sorguları ve sıralı erişim için idealdir
 * - Örnek: Sözlük uygulamaları, sıralı raporlar, aralık bazlı aramalar
 * 
 * Önemli Metodlar:
 * - put(): Anahtar-değer çifti ekleme
 * - get(): Anahtara göre değer alma
 * - remove(): Anahtara göre eleman silme
 * - firstKey(): En küçük anahtar
 * - lastKey(): En büyük anahtar
 * - subMap(): Belirli aralıktaki elemanları alma
 * - headMap(): Belirli anahtara kadar olan elemanları alma
 * - tailMap(): Belirli anahtardan sonraki elemanları alma
 */

package Week_3.Dersler.Maps;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        // TreeMap oluşturma - Anahtarlar doğal sıralamaya göre saklanır
        Map<Integer, String> numbers = new TreeMap<>();

        // 1. put() - Anahtar-değer çifti ekleme (sıralı olarak saklanır)
        numbers.put(3, "Three"); // Sayı: 3, Yazı: Three
        numbers.put(1, "One");
        numbers.put(2, "Two");

        // 2. toString() - Tüm haritayı yazdırma (anahtarlara göre sıralı)
        System.out.println("Numbers: " + numbers);

        // 3. containsKey() - Anahtar kontrolü
        boolean containsKey = numbers.containsKey(4);
        System.out.println("4 var mı? " + containsKey);

        // 4. get() - Anahtara göre değer alma
        System.out.println("2'nin yazılışı: " + numbers.get(2));

        // 5. firstKey() - En küçük anahtar
        System.out.println("En küçük sayı: " + ((TreeMap<Integer, String>) numbers).firstKey());

        // 6. lastKey() - En büyük anahtar
        System.out.println("En büyük sayı: " + ((TreeMap<Integer, String>) numbers).lastKey());

        // 7. size() - Harita boyutu
        System.out.println("Sayı adedi: " + numbers.size());

        // 8. keySet() - Tüm anahtarları alma (sıralı)
        System.out.println("Sayılar: " + numbers.keySet());

        // 9. values() - Tüm değerleri alma
        System.out.println("Yazılar: " + numbers.values());

        // 10. remove() - Anahtara göre eleman silme
        numbers.remove(2);
        System.out.println("2 silindikten sonra: " + numbers);

        // YAYGIN HATALAR VE ÇÖZÜMLERİ:

        // HATA 1: Comparable olmayan anahtarlar
        try {
            TreeMap<Object, String> nonComparableMap = new TreeMap<>();
            nonComparableMap.put(new Object(), "Value"); // Çözüm: Comparable interface'ini implement et
        } catch (ClassCastException e) {
            System.out.println("HATA: Anahtar sınıfı Comparable değil!");
        }

        // HATA 2: Null anahtar kullanımı
        try {
            numbers.put(null, "Null"); // Çözüm: null kontrolü yap
        } catch (NullPointerException e) {
            System.out.println("HATA: null anahtar kullanılamaz!");
        }

        // HATA 3: Yanlış sıralama mantığı
        try {
            TreeMap<String, Integer> wrongOrderMap = new TreeMap<>();
            wrongOrderMap.put("10", 10);
            wrongOrderMap.put("2", 2);
            System.out.println("Yanlış sıralama: " + wrongOrderMap); // Çözüm: Comparator kullan
        } catch (Exception e) {
            System.out.println("HATA: Yanlış sıralama mantığı!");
        }

        // HATA 4: ConcurrentModificationException
        try {
            for (Integer key : numbers.keySet()) {
                if (key == 1) {
                    numbers.remove(key); // Çözüm: Iterator kullan
                }
            }
        } catch (Exception e) {
            System.out.println("HATA: Döngüde değişiklik yapılamaz!");
        }

        // HATA 5: Performans sorunları
        try {
            TreeMap<Integer, String> bigMap = new TreeMap<>();
            for (int i = 0; i < 1000000; i++) {
                bigMap.put(i, "Value" + i); // Çözüm: HashMap kullan veya kapasite sınırı belirle
            }
        } catch (OutOfMemoryError e) {
            System.out.println("HATA: Performans sorunu!");
        }
    }
}
