package Week_3.Dersler.Collections;

import java.util.HashSet;
import java.util.Set;

public class Setmain {
    public static void main(String[] args) {
        // HashSet oluşturma
        Set<String> Fruits = new HashSet<>();

        // En çok kullanılan Set metodları:

        // 1. add() - Eleman ekleme
        Fruits.add("Apple"); // Tekrarlı eleman eklenmez
        Fruits.add("Banana");
        Fruits.add("Orange");
        Fruits.add("Apple"); // Bu eleman eklenmeyecek çünkü zaten var

        // 2. size() - Küme boyutu
        System.out.println("Küme boyutu: " + Fruits.size());

        // 3. contains() - Eleman kontrolü
        System.out.println("Apple var mı? " + Fruits.contains("Apple"));

        // 4. remove() - Eleman silme
        Fruits.remove("Banana");
        System.out.println("Banana silindi mi? " + !Fruits.contains("Banana"));

        // 5. isEmpty() - Küme boş mu kontrolü
        System.out.println("Küme boş mu? " + Fruits.isEmpty());

        // 6. clear() - Tüm elemanları silme
        // Fruits.clear();

        // 7. iterator() - Elemanları gezme
        System.out.println("Küme elemanları:");
        for (String fruit : Fruits) {
            System.out.println(fruit);
        }

        // 8. addAll() - Başka bir kümenin tüm elemanlarını ekleme
        Set<String> newFruits = new HashSet<>();
        newFruits.add("Mango");
        newFruits.add("Pineapple");
        Fruits.addAll(newFruits);

        // 9. retainAll() - İki kümenin kesişimini alma
        Set<String> commonFruits = new HashSet<>(Fruits);
        commonFruits.retainAll(newFruits);
        System.out.println("Ortak meyveler: " + commonFruits);

        // 10. removeAll() - Başka bir kümenin elemanlarını silme
        Fruits.removeAll(newFruits);
        System.out.println("Yeni meyveler silindikten sonra: " + Fruits);

        // 11. toArray() - Diziye dönüştürme
        String[] fruitArray = Fruits.toArray(new String[0]);

        // YAYGIN HATALAR VE ÇÖZÜMLERİ:

        // HATA 1: NullPointerException - null eleman ekleme
        try {
            Fruits.add(null); // Çözüm: null kontrolü yap
        } catch (NullPointerException e) {
            System.out.println("HATA: null eleman eklenemez!");
        }

        // HATA 2: ConcurrentModificationException - Döngüde değişiklik
        try {
            for (String fruit : Fruits) {
                if (fruit.equals("Apple")) {
                    Fruits.remove(fruit); // Çözüm: Iterator kullan
                }
            }
        } catch (Exception e) {
            System.out.println("HATA: Döngüde değişiklik yapılamaz!");
        }

        // HATA 3: ClassCastException - Yanlış tip dönüşümü
        try {
            // Çözüm: Doğrudan String tipinde Set oluştur
            Set<String> stringSet = new HashSet<>();
            stringSet.add("String1");
            stringSet.add("String2");
            
            // String tipindeki Set'i kullan
            for (String item : stringSet) {
                System.out.println(item);
            }
        } catch (ClassCastException e) {
            System.out.println("HATA: Yanlış tip dönüşümü!");
        }

        // HATA 4: OutOfMemoryError - Çok büyük HashSet
        try {
            Set<Integer> bigSet = new HashSet<>();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                bigSet.add(i); // Çözüm: Kapasite sınırı belirle
            }
        } catch (OutOfMemoryError e) {
            System.out.println("HATA: Bellek yetersiz!");
        }

        // HATA 5: equals() ve hashCode() uyumsuzluğu
        try {
            Set<Person> personSet = new HashSet<>();
            personSet.add(new Person("Ahmet", 25));
            personSet.add(new Person("Ahmet", 25)); // Çözüm: equals() ve hashCode() override et
            System.out.println("Kişi sayısı: " + personSet.size());
        } catch (Exception e) {
            System.out.println("HATA: equals() ve hashCode() uyumsuzluğu!");
        }
    }

    // Hata örneği için Person sınıfı
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return 31 * name.hashCode() + age;
        }
    }
}
