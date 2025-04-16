package Week_2.StudentInformation.Week_2;

import java.util.Scanner;

public class Primenumber {
    static boolean AsalSayi(int A,int i)
    {
        if (A <= 2) {
            return (A == 2);
        }
        if (A % i == 0) {
            return false;
        }
        if (i * i > A) {
            return true;
        }
        return AsalSayi(A, i + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        int sayi = scanner.nextInt();

        if (AsalSayi(sayi,2 )) {
            System.out.println(sayi + " bir asal sayıdır.");
        } else {
            System.out.println(sayi + " bir asal sayı değildir.");
        }

        scanner.close();
    }
}
