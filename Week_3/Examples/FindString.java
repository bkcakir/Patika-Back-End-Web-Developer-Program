package Week_3.Examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> letters = new ArrayList<>();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Rastgele 4 harf oluştur
        for (int i = 0; i < 4; i++) {
            int index = (int) (Math.random() * 26); // 0-25 arası olmalı
            letters.add(String.valueOf(chars.charAt(index)));
        }

        System.out.println("Rastgele Harf Listesi: " + letters); // Debug amaçlı

        // Kullanıcıdan 4 harf alın
        for (int i = 0; i < 4; i++) {
            System.out.print("Bir harf giriniz: ");
            String input = scanner.nextLine().toUpperCase();

            if (letters.contains(input)) {
                System.out.println("Bulundu!");
            } else {
                System.out.println("Harf bulunamadı. Listeye ekleniyor.");
                letters.add(input);
            }
        }

        System.out.println("Güncel Harf Listesi: " + letters);
    }
}
