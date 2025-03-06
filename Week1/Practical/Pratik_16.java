package Week1.Practical;

import java.util.Scanner;

public class Pratik_16 {
    public static void main(String[] args) {

        //Bir sayının tek mi çift mi olduğunu kontrol eden bir program yazın.
        int Number;
        Scanner scanner = new Scanner(System.in);


        System.out.print("Lütfen Bir sayı Giriniz : ");
        Number=scanner.nextInt();

        if(Number%2==0)
        {
            System.out.print("Çift Sayısıdır.");
        }
        else
        {
            System.out.print("Tek Sayısıdır.");
        }
    }
}
