package Week_1.Practical;

import java.util.Scanner;

public class Pratik_28 {
    public static void main(String[] args) {
        //Kullanıcıdan alınan bir kelimenin tersini ekrana yazdıran bir program oluşturun.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir Kelime Yazınız  : ");
         String Write=scanner.nextLine();

        String RevaseWrite =  new StringBuilder(Write).reverse().toString();

        System.out.print("Kelimeniz : "+Write +"Tersi : "+RevaseWrite );

    }
}
