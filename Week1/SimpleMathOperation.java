package Week1;

import java.util.Scanner;

public class SimpleMathOperation {
    public static void main(String[] args) {
        // Kullanıcıdan alınacak değişkenler (Variables to be taken from the user)
        int numberA, numberB, numberC, total;

        // Kullanıcıdan giriş almak için Scanner sınıfı (Scanner object to get user input)
        Scanner scanner = new Scanner(System.in);

        System.out.print("A Sayısını Giriniz: "); // Enter number A
        numberA = scanner.nextInt();

        System.out.print("B Sayısını Giriniz: "); // Enter number B
        numberB = scanner.nextInt();

        System.out.print("C Sayısını Giriniz: "); // Enter number C
        numberC = scanner.nextInt();

        // Matematiksel işlem yapılır (Mathematical operation is performed)
        total = (numberA + numberB) * (numberC - numberB);

        // Sonuç ekrana yazdırılır (Print the result to the screen)
        System.out.print("Sonuç: " + total);

        // Scanner'ı kapat (Close the scanner object)
        scanner.close();
    }
}
