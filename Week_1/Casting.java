package Week_1;

import java.util.Scanner;

public class Casting {
    public static void main(String[] args) {
        int intNumber;
        double doubleNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen bir Tam Sayı Giriniz: ");
        intNumber = scanner.nextInt();

        System.out.print("Lütfen Bir Ondalıklı Sayı Giriniz: ");
        doubleNumber = scanner.nextDouble();

        System.out.println("Ondalıklı Sayı: " + doubleNumber + " Tam Sayı Değeri: " + (int)(doubleNumber) + " Tam Sayı: " + intNumber + " Ondalıklı Sayı Değeri: " + (double)(intNumber));

        scanner.close();
    }
}
