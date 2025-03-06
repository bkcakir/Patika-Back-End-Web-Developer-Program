package Week1.Practical;

import java.util.Scanner;

public class Pratik_24 {
    public static void main(String[] args) {
        int Number;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Bir Sayı Giriniz :");
        Number=scanner.nextInt();

        if(Number<0)
        {
            System.out.print("Sayınız Negatifdir");
        }
        else if (Number>0)
        {
            System.out.print("Sayınız Pozitiftir");
        }
        else if (Number==0) {
            System.out.print("Sayınız 0 Eşitir");
        }
    }
}
