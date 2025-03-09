package Week_1.Practical;

import java.util.Scanner;

public class Pratik_38 {
    public static void main(String[] args) {
        //Kullanıcının girdiği bir sayıyı dizide arayıp olup olmadığını bulan bir program yazın.
        int[] Numbers = new int[10];
        Scanner scanner = new Scanner(System.in);
        int Rnd,Number;
        for (int i = 0 ; i<Numbers.length; i++)
        {
            Rnd = (int) (Math.random() * 1000);
            Numbers[i]=Rnd;
        }

        // Numbers dizisini yazdır
        System.out.print("{");
        for (int i = 0; i < Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.println();
        System.out.print("Bir deger giriniz : ");
        Number=scanner.nextInt();
        for(int j=0; j<Numbers.length;j++)
        {
            if(Numbers[j]==Number)
            {
                System.out.print("Aradanız Sayı  Dizide : "+"["+j+"]"+" Sırasında Bulundu!!" );
                break;
            }
        }



    }
}
