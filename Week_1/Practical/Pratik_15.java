package Week_1.Practical;

import java.util.Scanner;

public class Pratik_15 {
    public static void main(String[] args) {
        int Number_1;
        int Number_2;
        Scanner scanner = new Scanner(System.in);
        //İki sayı alıp dört temel matematiksel işlemi gerçekleştiren bir hesap makinesi yazın.

        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number_1=scanner.nextInt();
        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number_2=scanner.nextInt();

        System.out.println(Number_1+" + "+ Number_2 +" = "+(Number_1+Number_2));
        System.out.println(Number_1+" - "+ Number_2 +" = "+(Number_1-Number_2));
        System.out.println(Number_1+" * "+ Number_2 +" = "+(Number_1*Number_2));
        System.out.println(Number_1+" / "+ Number_2 +" = "+(Number_1/Number_2));

    }
}
