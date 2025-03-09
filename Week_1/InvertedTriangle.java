package Week_1;

import java.util.Scanner;

public class InvertedTriangle {
    public static void main(String[] args) {
        int Number; // Kullanıcıdan alınacak basamak sayısını tutan değişken
        Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluşturuluyor.

        System.out.print("Ters Üçgenin Basamak Sayısı Kaçtır: ");
        Number = scanner.nextInt(); // Kullanıcıdan basamak sayısı alınıyor.

        // Ters üçgeni oluşturmak için dış döngü (satırları temsil eder)
        for (int i = Number; i > 0; i--) {
            // Yıldızları yazdıran iç döngü (her satır için yıldızları oluşturur)
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Bir satır tamamlandığında alt satıra geç
        }
    }
}
