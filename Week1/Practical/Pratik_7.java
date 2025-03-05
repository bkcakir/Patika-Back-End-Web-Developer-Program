package Week1.Practical;

import java.util.Scanner;

//Kullanıcıdan alınan bir sayıya kadar olan asal sayıları bulan bir program oluşturun.
public class Pratik_7 {
    public static void main(String[] args) {
        int Number;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number=scanner.nextInt();

        for (int i = 2; i <= Number; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i+" ");
            }
        }
    }
}
