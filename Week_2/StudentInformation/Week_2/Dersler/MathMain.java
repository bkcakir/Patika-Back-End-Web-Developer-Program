package Week_2.StudentInformation.Week_2.Dersler;

public class MathMain {
    public static void main(String[] args) {

        // İki sayı arasından en küçüğünü döndürür
        System.out.println(Math.min(3,7));  // Çıktı: 3
        System.out.println(Math.min(-13,-7));  // Çıktı: -13

        System.out.println();

        // İki sayı arasından en büyüğünü döndürür
        System.out.println(Math.max(3,7));  // Çıktı: 7
        System.out.println(Math.max(13,7));  // Çıktı: 13

        System.out.println();

        // Sayıyı en yakın tam sayıya yuvarlar
        System.out.println(Math.round(123.45));  // Çıktı: 123
        System.out.println(Math.round(123.50));  // Çıktı: 124

        System.out.println();

        // Üs alma işlemi yapar (5^2 ve 5^3)
        System.out.println(Math.pow(5,2));  // Çıktı: 25.0
        System.out.println(Math.pow(5,3));  // Çıktı: 125.0

        System.out.println();

        // 0 ile 100 arasında rastgele bir tam sayı üretir
        System.out.println((int)(Math.random()*100));  // Çıktı: 0 ile 99 arasında rastgele bir sayı
    }
}
