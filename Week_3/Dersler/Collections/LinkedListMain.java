/**
 * LinkedListMain.java
 * 
 * Bu sınıf, Java'da LinkedList veri yapısının kullanımını ve Queue arayüzü ile birlikte
 * nasıl kullanılabileceğini gösterir.
 * 
 * LinkedList Nedir?
 * - Bağlı liste veri yapısının Java'daki implementasyonudur
 * - Her eleman bir sonraki elemana referans içerir
 * - ArrayList'ten farklı olarak, elemanlar fiziksel olarak ardışık değildir
 * - Baştan ve sondan hızlı ekleme/silme işlemleri yapılabilir
 * - Queue arayüzünü implemente eder, bu sayede kuyruk olarak da kullanılabilir
 * 
 * Ne İşe Yarar?
 * - Sık ekleme/silme işlemleri gerektiren durumlarda ArrayList'ten daha verimlidir
 * - Kuyruk (Queue) işlemleri için kullanılabilir
 * - FIFO (First In First Out) mantığıyla çalışan uygulamalarda tercih edilir
 * - Örnek: Mesaj kuyrukları, iş sıralamaları, olay yönetimi
 * 
 * Önemli Metodlar:
 * - add(): Eleman ekleme
 * - remove(): Eleman silme
 * - peek(): İlk elemanı görüntüleme
 * - poll(): İlk elemanı alma ve silme
 * - offer(): Kuyruğa eleman ekleme
 * - element(): İlk elemanı alma (boş kuyrukta hata verir)
 */

package Week_3.Dersler.Collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListMain {
    public static void main(String[] args) {
        // LinkedList'i Queue olarak kullanma
        Queue<String> names = new LinkedList<>();

        // 1. add() - Eleman ekleme
        names.add("cem"); // Listenin sonuna eleman ekler
        names.add("Patika");
        names.add("Java Kursu");
        names.add("Burak");

        // 2. toString() - Tüm listeyi yazdırma
        System.out.println(names);

        // Queue metodları:

        // 3. peek() - İlk elemanı görüntüleme (silmeden)
        System.out.println("İlk eleman (peek): " + names.peek());

        // 4. poll() - İlk elemanı alma ve silme
        System.out.println("İlk eleman (poll): " + names.poll());

        // 5. element() - İlk elemanı alma (boş liste durumunda exception)
        System.out.println("İlk eleman (element): " + names.element());

        // 6. offer() - Sonuna eleman ekleme
        names.offer("Yeni Eleman");

        // YAYGIN HATALAR VE ÇÖZÜMLERİ:

        // HATA 1: NoSuchElementException - Boş listeden eleman alma
        try {
            Queue<String> emptyList = new LinkedList<>();
            System.out.println(emptyList.element()); // Çözüm: isEmpty() kontrolü yap
        } catch (Exception e) {
            System.out.println("HATA: Boş listeden eleman alınamaz!");
        }

        // HATA 2: ConcurrentModificationException - Döngüde değişiklik
        try {
            for (String name : names) {
                if (name.equals("cem")) {
                    names.remove(name); // Çözüm: Iterator kullan
                }
            }
        } catch (Exception e) {
            System.out.println("HATA: Döngüde değişiklik yapılamaz!");
        }

        // HATA 3: NullPointerException - null eleman ekleme
        try {
            names.add(null); // Çözüm: null kontrolü yap
        } catch (NullPointerException e) {
            System.out.println("HATA: null eleman eklenemez!");
        }

        // HATA 4: IndexOutOfBoundsException - Geçersiz indeks
        try {
            // Queue'da indeks kullanılamaz, bu yüzden LinkedList'e dönüştür
            LinkedList<String> list = (LinkedList<String>) names;
            System.out.println(list.get(100)); // Çözüm: size() kontrolü yap
        } catch (IndexOutOfBoundsException e) {
            System.out.println("HATA: Geçersiz indeks!");
        }

        // HATA 5: OutOfMemoryError - Çok büyük LinkedList
        try {
            Queue<Integer> bigList = new LinkedList<>();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                bigList.add(i); // Çözüm: Kapasite sınırı belirle
            }
        } catch (OutOfMemoryError e) {
            System.out.println("HATA: Bellek yetersiz!");
        }

        // HATA 6: StackOverflowError - Çok derin özyineleme
        try {
            recursiveAdd(new LinkedList<>(), 0); // Çözüm: Özyineleme derinliğini sınırla
        } catch (StackOverflowError e) {
            System.out.println("HATA: Stack taşması!");
        }
    }

    // Özyinelemeli ekleme metodu (hata örneği için)
    private static void recursiveAdd(LinkedList<Integer> list, int count) {
        if (count < 1000000) {
            list.add(count);
            recursiveAdd(list, count + 1);
        }
    }
}
