package Week1;

import java.util.Scanner;

public class Average_of_Numbers_Divisible_by_3_and_4 {
    public static void main(String[] args) {
        int Number, Total = 0, Avg, Piece = 0; // Gerekli değişkenler tanımlanıyor.
        Scanner scanner = new Scanner(System.in); // Scanner nesnesi oluşturuluyor.

        System.out.print("Döngünün Son Sayısı Kaçtır ? : ");
        Number = scanner.nextInt(); // Kullanıcıdan sayı alınıyor.

        // 0'dan girilen sayıya kadar döngü oluşturuluyor.
        for (int i = 0; i <= Number; i++) {
            if (i % 12 == 0) { // Sayı hem 3'e hem de 4'e bölünebiliyorsa
                Total += i; // Sayıyı toplama ekle
                Piece++; // Bölünebilen sayı adedini artır
                System.out.println(i + " Sayısı Hem 3 Hem 4'e Bölünebilir");
            }
        }

        // Eğer hiç uygun sayı bulunamazsa sıfıra bölme hatasını önlemek için kontrol ekleniyor.
        if (Piece > 0) {
            Avg = Total / Piece; // Ortalamayı hesapla
            System.out.println("0'dan " + Number + "'e kadar olan sayılardan 3 ve 4'e tam bölünen sayıların ortalaması: " + Avg);
        } else {
            System.out.println("3 ve 4'e tam bölünebilen herhangi bir sayı bulunamadı.");
        }
    }
}
