package Week_3.Dersler.Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        // PriorityQueue oluşturma (öğeler doğal sıralamaya göre sıralanır)
        Queue<String> BreadQeue = new PriorityQueue<>();

        // En çok kullanılan Queue metodları:

        // 1. add() - Kuyruğa eleman ekleme
        BreadQeue.add("Cem"); // Kuyruğun sonuna eleman ekler
        BreadQeue.add("Emir");
        BreadQeue.add("Ahmet");
        BreadQeue.add("Ayşe");

        // 2. offer() - Kuyruğa eleman ekleme (kapasite sınırı varsa false döner)
        boolean isAdded = BreadQeue.offer("Mehmet");
        System.out.println("Mehmet eklendi mi? " + isAdded);

        // 3. peek() - Kuyruğun başındaki elemanı görüntüleme (silmeden)
        System.out.println("Sıradaki kişi (peek): " + BreadQeue.peek());

        // 4. element() - Kuyruğun başındaki elemanı görüntüleme (boş kuyrukta exception)
        System.out.println("Sıradaki kişi (element): " + BreadQeue.element());

        // 5. poll() - Kuyruğun başındaki elemanı alma ve silme
        String nextPerson = BreadQeue.poll();
        System.out.println("Sıradaki kişi (poll): " + nextPerson);

        // 6. remove() - Kuyruğun başındaki elemanı alma ve silme (boş kuyrukta exception)
        String removedPerson = BreadQeue.remove();
        System.out.println("Silinen kişi (remove): " + removedPerson);

        // 7. size() - Kuyruk boyutu
        System.out.println("Kuyruktaki kişi sayısı: " + BreadQeue.size());

        // 8. isEmpty() - Kuyruk boş mu kontrolü
        System.out.println("Kuyruk boş mu? " + BreadQeue.isEmpty());

        // 9. clear() - Tüm elemanları silme
        // BreadQeue.clear();

        // 10. contains() - Eleman kontrolü
        System.out.println("Cem kuyrukta mı? " + BreadQeue.contains("Cem"));

        // Kuyruktaki tüm elemanları yazdırma
        System.out.println("Kuyruktaki tüm kişiler:");
        while (!BreadQeue.isEmpty()) {
            System.out.println(BreadQeue.poll());
        }
    }
}
