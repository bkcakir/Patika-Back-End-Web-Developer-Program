/**
 * ArrayListMain.java
 * 
 * Bu sınıf, Java'da ArrayList veri yapısının kullanımını ve özelliklerini gösterir.
 * 
 * ArrayList Nedir?
 * - Dinamik boyutlu dizi veri yapısının Java'daki implementasyonudur
 * - Elemanlar fiziksel olarak ardışık bellek konumlarında saklanır
 * - Boyutu otomatik olarak büyüyebilir ve küçülebilir
 * - List arayüzünü implemente eder
 * - Thread-safe değildir (eşzamanlı erişimde sorun çıkarabilir)
 * 
 * Ne İşe Yarar?
 * - Sık erişim gerektiren durumlarda LinkedList'ten daha verimlidir
 * - Rastgele erişim (random access) için optimize edilmiştir
 * - Veri depolama ve yönetimi için temel veri yapısıdır
 * - Örnek: Veri listeleri, önbellekler, geçici depolama
 * 
 * Önemli Metodlar:
 * - add(): Eleman ekleme
 * - get(): İndeks ile eleman alma
 * - remove(): Eleman silme
 * - size(): Boyut bilgisi
 * - contains(): Eleman kontrolü
 * - clear(): Tüm elemanları temizleme
 */

package Week_3.Dersler.Collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        // ArrayList oluşturma yöntemleri
        ArrayList<Integer> integers = new ArrayList<>(30); // Başlangıç kapasitesi 30 olan ArrayList
        ArrayList<Integer> integers1 = new ArrayList<>(); // Varsayılan kapasiteli ArrayList

        List<String> ShopingList = new ArrayList<>();

        // 1. add() - Eleman ekleme
        ShopingList.add("Banana"); // Listenin sonuna eleman ekler
        ShopingList.add("Apple");
        ShopingList.add(1, "Mango"); // Belirtilen indekse eleman ekler

        // 2. for-each döngüsü ile elemanları yazdırma
        System.out.println("Alışveriş listesi:");
        for (String s : ShopingList) {
            System.out.println(s);
        }
        System.out.println("---------------");

        // 3. remove() - Eleman silme
        boolean İsAppleRemoved = ShopingList.remove("Apple"); // Belirtilen elemanı siler ve başarılı olup olmadığını döndürür
        System.out.println("İsAppleRemoved : " + İsAppleRemoved);
        
        System.out.println("Güncellenmiş liste:");
        for (String s : ShopingList) {
            System.out.println(s);
        }
        System.out.println("---------------");
        
        boolean İsBananaRemoved = ShopingList.remove("Muz");
        System.out.println("İsBananaRemoved : " + İsBananaRemoved);

        // 4. addAll() - Başka bir koleksiyonun tüm elemanlarını ekleme
        ArrayList<String> ShopingList2 = new ArrayList<>();
        ShopingList2.add("Milk");
        ShopingList2.add("Jacket");
        ShopingList2.add("scaft");
        ShopingList.addAll(ShopingList2); // Tüm elemanları ekler
        System.out.println("Birleştirilmiş liste: " + ShopingList);

        // 5. contains() - Eleman kontrolü
        System.out.println("Urun Var mı ? : " + ShopingList.contains("Milk")); // Elemanın listede olup olmadığını kontrol eder

        // 6. size() - Liste boyutu
        System.out.println("Listenizde Ürün Adedi  : " + ShopingList.size() + " Adet Ürün Var"); // Listenin eleman sayısını döndürür

        // 7. get() - İndeks ile eleman alma
        System.out.println("Son ürün: " + ShopingList.get(ShopingList.size() - 1)); // Son elemanı getirir

        // 8. set() - Belirtilen indeksteki elemanı değiştirme
        ShopingList.set(0, "NewBanana"); // 0. indeksteki elemanı değiştirir
        System.out.println("İlk ürün değiştirildi: " + ShopingList);

        // 9. indexOf() - Elemanın indeksini bulma
        System.out.println("Milk'in indeksi: " + ShopingList.indexOf("Milk"));

        // 10. lastIndexOf() - Elemanın son görüldüğü indeksi bulma
        ShopingList.add("Milk");
        System.out.println("Milk'in son görüldüğü indeks: " + ShopingList.lastIndexOf("Milk"));

        // 11. subList() - Belirtilen aralıktaki elemanları alma
        System.out.println("İlk 3 ürün: " + ShopingList.subList(0, 3));

        // 12. clear() - Tüm elemanları silme
        // ShopingList.clear();

        // 13. isEmpty() - Liste boş mu kontrolü
        System.out.println("Liste boş mu? " + ShopingList.isEmpty());

        // 14. toArray() - Diziye dönüştürme
        String[] array = ShopingList.toArray(new String[0]);
        System.out.println("Diziye dönüştürülen liste:");
        for (String item : array) {
            System.out.println(item);
        }

        // YAYGIN HATALAR VE ÇÖZÜMLERİ:

        // HATA 1: IndexOutOfBoundsException - Geçersiz indeks kullanımı
        try {
            System.out.println(ShopingList.get(100)); // Çözüm: size() kontrolü yap
        } catch (IndexOutOfBoundsException e) {
            System.out.println("HATA: Geçersiz indeks!");
        }

        // HATA 2: ConcurrentModificationException - Döngüde değişiklik
        try {
            for (String item : ShopingList) {
                if (item.equals("Milk")) {
                    ShopingList.remove(item); // Çözüm: Iterator kullan
                }
            }
        } catch (Exception e) {
            System.out.println("HATA: Döngüde değişiklik yapılamaz!");
        }

        // HATA 3: NullPointerException - null eleman ekleme
        try {
            ShopingList.add(null); // Çözüm: null kontrolü yap
        } catch (NullPointerException e) {
            System.out.println("HATA: null eleman eklenemez!");
        }

        // HATA 4: OutOfMemoryError - Çok büyük ArrayList
        try {
            ArrayList<Integer> bigList = new ArrayList<>();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                bigList.add(i); // Çözüm: Kapasite sınırı belirle
            }
        } catch (OutOfMemoryError e) {
            System.out.println("HATA: Bellek yetersiz!");
        }

        // HATA 5: IllegalArgumentException - Geçersiz başlangıç kapasitesi
        try {
            ArrayList<String> invalidList = new ArrayList<>(-1); // Çözüm: Geçerli kapasite kullan
        } catch (IllegalArgumentException e) {
            System.out.println("HATA: Geçersiz kapasite değeri!");
        }
    }
}
