package Week1.Practical;

import java.util.Scanner;

public class Pratik_19 {
    public static void main(String[] args) {
        int Number_1;
        int Number_2;

        //Kullanıcıdan alınan iki sayının birbirine bölünüp bölünemediğini bulan bir program yazın.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number_1=scanner.nextInt();

        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number_2=scanner.nextInt();

        if(Number_1%Number_2==0)
        {
            System.out.print(Number_1+" / "+Number_2+" Birbirini Bölünür");
        }
        else
        {
            System.out.print(Number_1+" / "+Number_2+" Birbirini Bölünmez");
        }
    }
}
