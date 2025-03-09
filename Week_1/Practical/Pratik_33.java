package Week_1.Practical;

import java.util.Scanner;

public class Pratik_33 {
    //Kullanıcının şifre girip doğru olup olmadığını kontrol eden bir program yazın.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Psw ;

        System.out.print("Şifrenizi Giriniz : ");
        Psw=scanner.nextLine();

        if(Psw.equalsIgnoreCase("Admin123*!!"))
        {
            System.out.println("Şifre Dogru");
        }
        else
        {
            System.out.println("Şifre Hatalı");
        }


    }
}
