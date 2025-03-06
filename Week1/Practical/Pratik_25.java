package Week1.Practical;

import java.util.Scanner;

public class Pratik_25 {
    public static void main(String[] args) {
        int Age;
        Scanner scanner = new Scanner(System.in);
        //Kullanıcının yaşına göre ehliyet alıp alamayacağını söyleyen bir program oluşturun.

        System.out.print("Yaşınızı Giriniz ");
        Age= scanner.nextInt();

        if(Age>18)
        {
            System.out.println("Ehliyet Alabilirsiniz  ");
        }
        else
        {
            System.out.println("Ehliyet Alamazsınız  ");
        }
    }
}
