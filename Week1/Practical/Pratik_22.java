package Week1.Practical;

import java.util.Scanner;

public class Pratik_22 {
    public static void main(String[] args) {
        int Number_1,Number_2;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Bir sayı Giriniz : ");
        Number_1=scanner.nextInt();
        System.out.print("Lütfen Bir sayı Giriniz : ");
        Number_2=scanner.nextInt();

        if(Number_1==Number_2)
        {
            System.out.println(Number_1+" = "+Number_2+" birine Eşittir");
        }
        else if (Number_1<Number_2)
        {
            System.out.println(Number_2+" Büyük olan Bir Sayıdır");
        }
        else if (Number_1>Number_2)
        {
            System.out.println(Number_1+" Büyük olan Bir Sayıdır");
        }
    }
}
