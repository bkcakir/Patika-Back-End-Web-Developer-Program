public class MyListTest {
    public static void main(String[] args) {
        System.out.println("=== MyList Sınıfı Test Programı ===\n");
        
        // Test 1: Temel işlemler
        System.out.println("Test 1: Temel işlemler");
        MyList<Integer> liste = new MyList<>();
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        System.out.println();
        
        // Test 2: get, remove, set işlemleri
        System.out.println("Test 2: get, remove, set işlemleri");
        MyList<Integer> liste2 = new MyList<>();
        liste2.add(10);
        liste2.add(20);
        liste2.add(30);
        System.out.println("2. indisteki değer : " + liste2.get(2));
        liste2.remove(2);
        liste2.add(40);
        liste2.set(0, 100);
        System.out.println("2. indisteki değer : " + liste2.get(2));
        System.out.println(liste2.toString());
        System.out.println();
        
        // Test 3: Gelişmiş işlemler
        System.out.println("Test 3: Gelişmiş işlemler");
        MyList<Integer> liste3 = new MyList<>();
        System.out.println("Liste Durumu : " + (liste3.isEmpty() ? "Boş" : "Dolu"));
        liste3.add(10);
        liste3.add(20);
        liste3.add(30);
        liste3.add(40);
        liste3.add(20);
        liste3.add(50);
        liste3.add(60);
        liste3.add(70);

        System.out.println("Liste Durumu : " + (liste3.isEmpty() ? "Boş" : "Dolu"));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + liste3.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks :" + liste3.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste3.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = liste3.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);

        // Liste veri türünde alt bir liste oluşturdu
        MyList<Integer> altListem = liste3.subList(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 20 değeri : " + liste3.contains(20));
        System.out.println("Listemde 120 değeri : " + liste3.contains(120));

        // Listeyi tamamen boşaltır ve varsayılan boyutuna çevirir
        liste3.clear();
        System.out.println(liste3.toString());
        System.out.println();
        
        // Test 4: String tipinde liste
        System.out.println("Test 4: String tipinde liste");
        MyList<String> stringList = new MyList<>();
        stringList.add("Java");
        stringList.add("Python");
        stringList.add("C++");
        stringList.add("JavaScript");
        System.out.println("String Listesi: " + stringList.toString());
        System.out.println("Python'un indeksi: " + stringList.indexOf("Python"));
        System.out.println("Kapasite: " + stringList.getCapacity());
        System.out.println();
        
        // Test 5: Kapasite belirterek constructor testi
        System.out.println("Test 5: Kapasite belirterek constructor");
        MyList<Double> doubleList = new MyList<>(5);
        System.out.println("Başlangıç kapasitesi: " + doubleList.getCapacity());
        doubleList.add(3.14);
        doubleList.add(2.718);
        doubleList.add(1.618);
        System.out.println("Double Listesi: " + doubleList.toString());
        System.out.println("Eleman sayısı: " + doubleList.size());
    }
} 