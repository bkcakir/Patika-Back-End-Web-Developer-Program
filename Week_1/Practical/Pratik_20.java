package Week_1.Practical;

import java.util.Scanner;

public class Pratik_20 {
    public static void main(String[] args) {
        int Number,Avg = 0;
        Scanner scanner = new Scanner(System.in);

        //Kullanıcının girdiği üç sayının ortalamasını hesaplayan bir program yazın.
        for(int i=0; i<=2;i++)
        {
            System.out.print("Lütfen bir Sayısı Giriniz : ");
            Number=scanner.nextInt();

            Avg+=Number;
        }
        System.out.println("Ortalaması : "+(Avg/3));
    }
}
