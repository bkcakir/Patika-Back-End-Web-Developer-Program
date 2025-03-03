package Week1;

import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        // Değişken tanımlanıyor: year (yıl)
        int year;
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan yıl alınır
        System.out.print("Yıl Giriniz : "); // "Enter the year:"
        year = input.nextInt();

        // Artık yıl kontrolü yapılır: Yıl 4'e tam bölünüp 400'e de tam bölünmeli
        if(year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
            System.out.println(year + " bir artık yıldır !"); // "It is a leap year!"
        } else {
            System.out.println(year + " bir artık yıldır değildir !"); // "It is not a leap year!"
        }
    }
}
