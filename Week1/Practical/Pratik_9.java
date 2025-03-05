package Week1.Practical;

import java.math.BigInteger;
import java.util.Scanner;

public class Pratik_9 {
    // Pascal üçgenini iç içe döngülerle yazdıran fonksiyon
    public static void printPascalTriangle(int rows) {
        // Satırları yazdıran dış döngü
        for (int n = 0; n < rows; n++) {
            // Her satırda öncelikle boşlukları yazdıran iç döngü
            for (int space = 0; space < rows - n - 1; space++) {
                System.out.print(" ");
            }

            // Her satırdaki elemanları hesaplayıp yazdıran iç döngü
            int coefficient = 1; // Binom katsayısının başlangıcı 1'dir
            for (int k = 0; k <= n; k++) {
                System.out.print(coefficient + " ");
                // Binom katsayısını güncellemek için faktör hesaplama
                coefficient = coefficient * (n - k) / (k + 1);
            }

            // Satır sonu
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan satır sayısını al
        System.out.print("Pascal Üçgeni için satır sayısını girin: ");
        int rows = scanner.nextInt();

        // Pascal üçgenini yazdır
        printPascalTriangle(rows);
    }
}
