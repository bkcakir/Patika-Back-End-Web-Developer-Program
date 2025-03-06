package Week1.Practical;

import java.util.Scanner;

public class Pratik_29 {
    public static void main(String[] args) {

        String Write,RaveseWirte;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir Kelime giriniz : ");
        Write=scanner.nextLine();

        RaveseWirte = new StringBuilder(Write).reverse().toString();

        if (Write.equalsIgnoreCase(RaveseWirte))
        {
            System.out.print("Kelimeniz :"+Write+" Tersi :  "+RaveseWirte +" Kelimeniz palindrom  Kelimedir");
        }
        else {
            System.out.print("Kelimeniz :"+Write+" Tersi :  "+RaveseWirte +" Kelimeniz palindrom  Kelime Değildir");
        }
    }
}
