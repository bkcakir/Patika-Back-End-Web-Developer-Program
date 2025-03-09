package Week_1;
import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {

        // Değişkenler tanımlanıyor: number (sayı), sum (toplam)
        Scanner sc = new Scanner(System.in);
        int number, sum = 0;

        // Kullanıcıdan sayı alınır
        System.out.print("Sayı giriniz: "); // "Enter the number:"
        number = sc.nextInt();

        // Sayının mükemmel olup olmadığı kontrol ediliyor
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) { // Sayı i'ye tam bölünüyorsa
                if (sum == number) {
                    System.out.print(number + " Mükemmel sayıdır"); // "It is a perfect number"
                    break;
                } else if (sum > number) {
                    System.out.print(number + " Mükemmel sayı değildir."); // "It is not a perfect number"
                    break;
                } else {
                    sum += i; // bölenlerin toplamını ekle
                }
            }
        }
    }
}
