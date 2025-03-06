package Week1.Practical;

import java.util.Scanner;

public class Pratik_23 {
    public static void main(String[] args) {
        int[] Numbers = new int[3];
        int Number,Ln;
        Scanner scanner = new Scanner(System.in);

        for(int i =0; i<Numbers.length;i++)
        {
            System.out.print("Lütfen Bir Sayı Giriniz: ");
            Number=scanner.nextInt();
            Numbers[i]=Number;
        }
        Ln=Numbers[0];

        System.out.print("Dizinin İlk Hali: {");
        for (int i = 0; i <Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");

        for (int i=0;i<Numbers.length;i++)
        {
            if(Numbers[i]>Ln)
            {
                Ln=Numbers[i];
            }
        }
        System.out.println();
        System.out.print("Dizinin En Büyük Sayısı : "+Ln);
    }
}
