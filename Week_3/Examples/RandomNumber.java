package Week_3.Examples;

import java.util.ArrayList;
import java.util.Collections;

public class RandomNumber {

    public static void main(String[] args) {
        ArrayList<Integer> Numbers = new ArrayList<>();
        int Number_1 = 0, Number_2 = 0;

        // 10 tane rastgele sayı ekleniyor
        for (int i = 0; i < 10; i++) {
            int Number = (int) (Math.random() * 1000); // 0-999 arası sayı üretir
            Numbers.add(Number);
        }

        System.out.println("Üretilen sayılar: " + Numbers);

        // Sayıları sırala
        Collections.sort(Numbers);

        int minFark = Integer.MAX_VALUE;

        // Komşuların farklarını kontrol et
        for (int i = 0; i < Numbers.size() - 1; i++) {
            int fark = Math.abs(Numbers.get(i + 1) - Numbers.get(i));
            if (fark < minFark) {
                minFark = fark;
                Number_1 = Numbers.get(i);
                Number_2 = Numbers.get(i + 1);
            }
        }

        System.out.println("En yakın iki sayı: " + Number_1 + " ve " + Number_2 + " (Fark: " + minFark + ")");
    }
}
