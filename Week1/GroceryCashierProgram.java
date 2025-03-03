package Week1;

import java.util.Scanner;

public class GroceryCashierProgram {

    public static void main(String[] args) {
        // Kullanıcıdan veri almak için Scanner nesnesi oluşturulur.
        // Creating a Scanner object to get user input.
        Scanner scanner = new Scanner(System.in);

        // Meyve ve sebzelerin fiyatlarını hesaplamak için değişkenler tanımlanır.
        // Declaring variables to calculate the prices of fruits and vegetables.
        double Pear, Apple, Tomatoes, Banana, Aubergine, weight;

        // Kullanıcıdan armut kilogramını al ve fiyatı hesapla.
        // Get the weight of pears from the user and calculate the price.
        System.out.print("Armut Kaç Kilo ? : ");
        weight = scanner.nextDouble();
        Pear = weight * 2.14; // 1 kg armut fiyatı: 2.14 TL (Price per kg: 2.14 TL)

        // Kullanıcıdan elma kilogramını al ve fiyatı hesapla.
        // Get the weight of apples from the user and calculate the price.
        System.out.print("Elma Kaç Kilo ? ");
        weight = scanner.nextDouble();
        Apple = weight * 3.67; // 1 kg elma fiyatı: 3.67 TL (Price per kg: 3.67 TL)

        // Kullanıcıdan domates kilogramını al ve fiyatı hesapla.
        // Get the weight of tomatoes from the user and calculate the price.
        System.out.print("Domates Kaç Kilo ? : ");
        weight = scanner.nextDouble();
        Tomatoes = weight * 1.11; // 1 kg domates fiyatı: 1.11 TL (Price per kg: 1.11 TL)

        // Kullanıcıdan muz kilogramını al ve fiyatı hesapla.
        // Get the weight of bananas from the user and calculate the price.
        System.out.print("Muz Kaç Kilo ? : ");
        weight = scanner.nextDouble();
        Banana = weight * 0.95; // 1 kg muz fiyatı: 0.95 TL (Price per kg: 0.95 TL)

        // Kullanıcıdan patlıcan kilogramını al ve fiyatı hesapla.
        // Get the weight of aubergines from the user and calculate the price.
        System.out.print("Patlıcan Kaç Kilo ? : ");
        weight = scanner.nextDouble();
        Aubergine = weight * 5.00; // 1 kg patlıcan fiyatı: 5.00 TL (Price per kg: 5.00 TL)

        // Toplam tutarı hesapla.
        // Calculate the total price.
        double totalPrice = Apple + Pear + Tomatoes + Banana + Aubergine;

        // Sonucu ekrana yazdır.
        // Print the total amount to the screen.
        System.out.println("Toplam Tutar : " + totalPrice + " TL");

        // Scanner nesnesini kapat.
        // Close the Scanner object.
        scanner.close();
    }
}
