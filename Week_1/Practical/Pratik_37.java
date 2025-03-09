package Week_1.Practical;

import java.util.Arrays;
import java.util.Scanner;

public class Pratik_37 {
    public static void main(String[] args) {
        //Kullanıcıdan 5 adet sayı alıp bunları küçükten büyüğe sıralayan bir program yazın.
        int[] Numbers = new int[5];
        int Number;
        Scanner scanner = new Scanner(System.in);

        for (int i =0; i<Numbers.length; i++)
        {
            System.out.print("Lütfen Bir Sayı Giriniz :");
            Number=scanner.nextInt();
            Numbers[i]=Number;
        }

        // Numbers dizisini yazdır
        System.out.print("Dizinin İlk Hali: {");
        for (int i = 0; i < Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.print("}");
        System.out.println();

        // Diziyi sıraladıktan sonra yazdır
        Arrays.sort(Numbers);

        System.out.print("Dizinin Son Hali: {");
        for (int i = 0; i < Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.print("}");

    }
}
