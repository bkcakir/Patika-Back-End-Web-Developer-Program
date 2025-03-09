package Week_1;

import java.util.Scanner;

public class Min_Max_Number {
    public static void main(String[] Args) {
        int Piece, Number; // Kullanıcıdan alınacak sayı adedi ve girilen sayı değişkenleri tanımlanıyor.
        Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluşturuluyor.

        System.out.print("Kaç Adet Sayı Gireceksiniz : ");
        Piece = scanner.nextInt(); // Kullanıcıdan kaç adet sayı gireceği alınıyor.

        for (int i = 0; i < Piece; i++) { // Kullanıcının belirttiği kadar sayı girmesi için döngü başlatılıyor.
            System.out.print(i + 1 + ". Sayıyı Giriniz : ");
            Number = scanner.nextInt(); // Kullanıcıdan sayı alınıyor.

            // Girilen sayının çift veya tek olduğunu kontrol ediyoruz.
            if (Number % 2 == 0) {
                System.out.println(Number + " Sayısı Çift Sayıdır");
            } else {
                System.out.println(Number + " Sayısı Tek Sayıdır");
            }
        }
    }
}

