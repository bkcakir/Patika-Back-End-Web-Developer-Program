package Week1.Practical;

import java.util.Scanner;

public class Pratik_11 {
    public static void main(String[] args) {
        double Number_1,Number_2;
        int Total;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ondalıklı bir sayı Giriniz : ");
        Number_1=scanner.nextDouble();
        System.out.print("Ondalıklı bir sayı Giriniz : ");
        Number_2=scanner.nextDouble();
        Total=((int)(Number_1))*((int)(Number_2));
        System.out.println((int)(Number_1)+" X "+(int)(Number_2)+" = "+Total);

    }
}
