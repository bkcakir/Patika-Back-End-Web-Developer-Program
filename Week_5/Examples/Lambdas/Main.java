package Week_5.Examples.Lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Sayıları iki katına çıkarma (Lambda kullanarak, indeksli güncelleme)
        IntStream.range(0, numbers.size())
                .forEach(i -> numbers.set(i, numbers.get(i) * 2));

        // Sonuçları yazdırma (Lambda ile)
        numbers.forEach(number -> System.out.println(number));
    }
}
