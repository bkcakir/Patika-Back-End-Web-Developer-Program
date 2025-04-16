package Week_2.StudentInformation.Week_2;

import java.util.Scanner;

public class PswControl {
    public static void main(String[] args) {
        String psw;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kurallar \n" +
                "1- En az 8 karakter içermeli\n" +
                "2- Space karakteri içermemeli\n" +
                "3- İlk harf büyük harf olmalı\n" +
                "4- Son karakteri '?' olmalı"
        );

        System.out.print("Kurallara Göre Bir Şifre Giriniz: ");
        psw = scanner.nextLine();

        // Şartları kontrol et
        boolean uzunlukUygun = psw.length() >= 8; // Uzunlugu Kontrol Ediyor
        boolean boslukIcermez = !psw.contains(" "); //Boşluk Kontrol Ediyor
        boolean ilkHarfBuyuk = psw.matches("^[A-Z].*");// Büyük Harfle mi Başladıgını Kontrol Ediyor
        boolean sonKarakterSoruIsareti = psw.endsWith("?"); //Son Karakterin ? oldugunu Kontrol Ediyor

        // Bütün koşulları sağlayıp sağlamadığını kontrol et
        if (uzunlukUygun && boslukIcermez && ilkHarfBuyuk && sonKarakterSoruIsareti) {
            System.out.println("Geçerli Şifre");
        } else {
            System.out.println("Geçersiz Şifre");
        }

        scanner.close();
    }
}
