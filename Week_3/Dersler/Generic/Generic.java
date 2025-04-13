/**
 * Generic.java
 * 
 * Bu sınıf, Java'da Generic (Jenerik) programlamanın temel kullanımını gösterir.
 * 
 * Generic Nedir?
 * - Java 5 ile gelen bir özelliktir
 * - Tip güvenliğini sağlar
 * - Kod tekrarını azaltır
 * - Derleme zamanında tip kontrolü yapar
 * - Runtime'da tip dönüşümü gerektirmez
 * 
 * Ne İşe Yarar?
 * - Tip güvenliği sağlar
 * - Kod tekrarını önler
 * - Daha okunabilir kod yazmayı sağlar
 * - Hata ayıklamayı kolaylaştırır
 * - Örnek: Koleksiyonlar, veri yapıları, algoritmalar
 * 
 * En Çok Kullanılan Metodlar:
 * - get(): Generic tip döndüren metodlar
 * - set(): Generic tip parametre alan metodlar
 * - printArray(): Generic tip dizileri işleyen metodlar
 * - getContent(): Sınırlandırılmış generic metodlar
 * 
 * En Çok Yapılan Hatalar:
 * - Primitive tipler kullanma (int, double yerine Integer, Double)
 * - Sınırlandırma kurallarına uymama (extends, super)
 * - Raw type kullanma (Generic olmayan tipler)
 * - Tip dönüşümü yapma (cast)
 * - Null değer atama
 * 
 */

package Week_3.Dersler.Generic;

public class Generic {
    public static void main(String[] args) {
        // 1. Generic Sınıf Örneği
        System.out.println("1. Generic Sınıf Örneği:");
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Merhaba Generic");
        System.out.println("String Box İçeriği: " + stringBox.getContent());

        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(42);
        System.out.println("Integer Box İçeriği: " + integerBox.getContent());


        // 2. Generic Metod Örneği
        System.out.println("\n2. Generic Metod Örneği:");
        String[] stringArray = {"Java", "Python", "C++"};
        System.out.println("String Dizisi:");
        GenericMetodExample.printArray(stringArray);

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Integer Dizisi:");
        GenericMetodExample.printArray(intArray);

        // Hata: Primitive tip kullanımı
        // int[] primitiveArray = {1, 2, 3};
        // GenericMetodExample.printArray(primitiveArray); // Compile time error

        // 3. Bounded Generic Örneği
        System.out.println("\n3. Bounded Generic Örneği:");
        BoundedGenericExample<Animal> animalBox = new BoundedGenericExample<>();
        Animal animal = new Animal();
        animalBox.setContent(animal);
        System.out.println("Animal Box İçeriği: " + animalBox.getContent(animal));

        // Hata: Sınırlandırma kuralına uymama
        // BoundedGenericExample<Integer> intBox = new BoundedGenericExample<>(); // Compile time error
        // BoundedGenericExample<String> stringBox = new BoundedGenericExample<>(); // Compile time error
    }
}

