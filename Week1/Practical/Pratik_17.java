package Week1.Practical;

import java.util.Scanner;

public class Pratik_17 {
    public static void main(String[] args) {
        int Number_1;
        int Number_2;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Bir sayı Giriniz : ");
        Number_1 = scanner.nextInt();
        System.out.print("Lütfen Bir sayı Giriniz : ");
        Number_2 = scanner.nextInt();

        if(Number_1<Number_2)
        {
            System.out.println(Number_2+" Büyük Sayıdır");
        }
        else{
            System.out.println(Number_1+" Büyük Sayıdır");
        }
    }
}
