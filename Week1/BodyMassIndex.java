package Week1;

import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {
        // Kullanıcıdan kilo (kg) ve boy (metre) bilgisi alınır.
        // Getting weight (kg) and height (meters) from the user.
        double weight, height;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz: ");
        height = scanner.nextDouble(); // Kullanıcının boyunu okuma (Reading user's height)

        System.out.print("Lütfen kilonuzu giriniz: ");
        weight = scanner.nextDouble(); // Kullanıcının kilosunu okuma (Reading user's weight)

        // BMI hesaplama formülü: kilo / (boy * boy)
        // BMI calculation formula: weight / (height * height)
        double bmi = weight / (height * height);

        // Sonucu ekrana yazdırma (Printing the result)
        System.out.println("Vücut Kitle İndeksiniz (BMI): " + bmi);

        // Scanner nesnesini kapatma (Closing the scanner)
        scanner.close();
    }
}
