package Week_2.StudentInformation.Week_2.Pratik;

import java.util.Scanner;

public class ExponentNumber {
    public static void main(String[] args) {
        int Number, Pow; // Kullanıcıdan alınacak sayıyı ve üssünü tanımlıyoruz.
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner sınıfını kullanıyoruz.

        // Kullanıcıdan taban sayısını alıyoruz.
        System.out.print("Sayı Giriniz :");
        Number = scanner.nextInt();

        // Kullanıcıdan üssü alıyoruz.
        System.out.print("Üst Giriniz :");
        Pow = scanner.nextInt();

        // Girilen sayının üssünü hesaplayıp ekrana yazdırıyoruz.
        System.out.println(Number + "^" + Pow + "=" + PowNumber(Number, Pow));
    }

    // Recursive (öz yinelemeli) yöntem ile üs alma işlemini gerçekleştiren metod
    public static int PowNumber(int Number, int Pow) {
        if (Pow == 0) { // Eğer üs 0 ise, sonuç her zaman 1'dir.
            return 1;
        } else {
            // Sayıyı üs kadar çarparak recursive şekilde hesaplama yapıyoruz.
            return Number * PowNumber(Number, Pow - 1);
        }
    }
}
