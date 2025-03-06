package Week1.Practical;

import java.util.Scanner;

public class Pratik_26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen birinci sayıyı giriniz: ");
        int number1 = scanner.nextInt();
        System.out.print("Lütfen ikinci sayıyı giriniz: ");
        int number2 = scanner.nextInt();

        // Mutlak değerleri hesaplayalım
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);

        // Mutlak değerleri ekrana yazdıralım
        System.out.println("[" + number1 + "] Mutlak Değeri: [" + absNumber1 + "]");
        System.out.println("[" + number2 + "] Mutlak Değeri: [" + absNumber2 + "]");

        // Hangi sayının mutlak değeri daha büyükse ekrana yazdır
        if (absNumber1 > absNumber2) {
            System.out.println("[" + number1 + "] sayısının mutlak değeri daha büyüktür.");
        } else if (absNumber2 > absNumber1) {
            System.out.println("[" + number2 + "] sayısının mutlak değeri daha büyüktür.");
        } else {
            System.out.println("İki sayının mutlak değerleri eşittir.");
        }
    }
}
