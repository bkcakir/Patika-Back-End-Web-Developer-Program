package Week_1.Practical;

import java.util.Scanner;

public class Pratik_32 {
    public static void main(String[] args) {
        double Heat;
        Scanner scanner = new Scanner(System.in);

        //Girilen sıcaklığa göre suyun donma, kaynama veya sıvı halde olduğunu belirten bir program yazın.
        System.out.print("Suyun Sıcaklık Degerini Giriniz : ");
        Heat=scanner.nextDouble();

        if(Heat<0)
        {
            System.out.print(" Su donar ve buz haline gelir.");
        }
        else if (Heat>=0 && Heat<100)
        {
            System.out.print("Su sıvı halde bulunur.");
        }
        else if (Heat>=100) {
            System.out.print("Su kaynar ve gaz fazına geçerek buharlaşır.");

        }
    }
}
