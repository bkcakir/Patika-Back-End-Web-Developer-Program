package Week1.Practical;

import java.util.Scanner;

public class Pratik_21 {
    public static void main(String[] args) {
        String Name;
        int Age;
        Scanner scanner =new Scanner(System.in);

        //Kullanıcıdan adı ve yaşı alarak ona kaç yıl sonra 100 yaşına gireceğini söyleyen bir program yazın.
        System.out.print("İsminiz Nedir ? : ");
        Name=scanner.nextLine();

        System.out.print("Kaç Yaşındasınız : ");
        Age=scanner.nextInt();

        System.out.print(Name + ", 100 yaşına " + (100 - Age) + " yıl sonra ulaşacaksınız.");
    }
}
