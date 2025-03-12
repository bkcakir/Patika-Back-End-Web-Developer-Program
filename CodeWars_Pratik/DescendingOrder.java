package CodeWars_Pratik;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        String str = String.valueOf(num);
        Integer[] numbers = new Integer[str.length()];

        // Sayıyı rakamlara ayır
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Character.getNumericValue(str.charAt(i));
        }

        // Büyükten küçüğe sırala
        Arrays.sort(numbers, Collections.reverseOrder());

        // Yeni sıralanmış string oluştur
        StringBuilder sortedStr = new StringBuilder();
        for (int n : numbers) {
            sortedStr.append(n);
        }

        // String'i integer'a çevirip döndür
        return Integer.parseInt(sortedStr.toString());
    }

    public static void main(String[] args) {
        System.out.println(sortDesc(21445)); // Çıktı: 54421
        System.out.println(sortDesc(145263)); // Çıktı: 654321
        System.out.println(sortDesc(123456789)); // Çıktı: 987654321
    }
}
