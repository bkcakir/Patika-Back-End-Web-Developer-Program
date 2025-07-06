# MyList - Generic Dinamik Liste Sınıfı

Bu proje, Java'da generic yapısını kullanarak Collection sınıflarını kullanmadan kendi dinamik liste sınıfımızı oluşturmayı amaçlamaktadır.

## Özellikler

### Constructor Metodları
- `MyList()`: Varsayılan constructor, başlangıç kapasitesi 10
- `MyList(int capacity)`: Kapasite belirterek constructor

### Temel Metodlar
- `size()`: Dizideki eleman sayısını döndürür
- `getCapacity()`: Dizinin kapasitesini döndürür
- `add(T data)`: Diziye eleman ekler, gerekirse kapasiteyi 2 katına çıkarır

### Erişim ve Değiştirme Metodları
- `get(int index)`: Verilen indeksteki değeri döndürür
- `set(int index, T data)`: Verilen indeksteki veriyi yenisi ile değiştirir
- `remove(int index)`: Verilen indeksteki veriyi siler ve sonrasındaki verileri sola kaydırır

### Arama Metodları
- `indexOf(T data)`: Parametrede verilen nesnenin listedeki ilk indeksini verir
- `lastIndexOf(T data)`: Belirtilen öğenin listedeki son indeksini verir
- `contains(T data)`: Parametrede verilen değerin dizide olup olmadığını kontrol eder

### Yardımcı Metodlar
- `isEmpty()`: Listenin boş olup olmadığını kontrol eder
- `toArray()`: Listedeki öğeleri array haline getirir
- `clear()`: Listedeki bütün öğeleri siler
- `subList(int start, int finish)`: Parametrede verilen indeks aralığına ait bir liste döner
- `toString()`: Dizideki elemanları listeleyen bir metot

## Kullanım Örnekleri

### Temel Kullanım
```java
MyList<Integer> liste = new MyList<>();
liste.add(10);
liste.add(20);
liste.add(30);
System.out.println("Eleman sayısı: " + liste.size());
System.out.println("Kapasite: " + liste.getCapacity());
```

### Kapasite Belirterek
```java
MyList<String> stringList = new MyList<>(5);
stringList.add("Java");
stringList.add("Python");
System.out.println(stringList.toString());
```

### Arama İşlemleri
```java
MyList<Integer> liste = new MyList<>();
liste.add(10);
liste.add(20);
liste.add(30);
liste.add(20);

System.out.println("20'nin ilk indeksi: " + liste.indexOf(20));
System.out.println("20'nin son indeksi: " + liste.lastIndexOf(20));
System.out.println("100 var mı: " + liste.contains(100));
```

## Çalıştırma

Programı çalıştırmak için:

```bash
javac MyList.java MyListTest.java
java MyListTest
```

## Test Sonuçları

Program çalıştırıldığında aşağıdaki gibi çıktılar alınır:

```
=== MyList Sınıfı Test Programı ===

Test 1: Temel işlemler
Dizideki Eleman Sayısı : 0
Dizinin Kapasitesi : 10
Dizideki Eleman Sayısı : 4
Dizinin Kapasitesi : 10
Dizideki Eleman Sayısı : 11
Dizinin Kapasitesi : 20

Test 2: get, remove, set işlemleri
2. indisteki değer : 30
2. indisteki değer : 40
[100,20,40]
```

## Önemli Notlar

1. **Collection Sınıfları Kullanılmamıştır**: Bu proje, Java'nın built-in Collection sınıflarını kullanmadan tamamen sıfırdan yazılmıştır.

2. **Dinamik Büyüme**: Dizi dolduğunda kapasite otomatik olarak 2 katına çıkarılır.

3. **Generic Yapı**: Tüm veri tipleriyle çalışabilir (Integer, String, Double, vb.).

4. **Null Güvenliği**: Null değerler için güvenli kontroller yapılmıştır.

5. **Bellek Optimizasyonu**: Gereksiz bellek kullanımını önlemek için dinamik büyüme stratejisi kullanılmıştır. 