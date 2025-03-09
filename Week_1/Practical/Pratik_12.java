package Week_1.Practical;

import java.util.Scanner;

public class Pratik_12 {
    public static void main(String[] args) {
        //Kullanıcının girdiği metni sayıya çevirip karesini hesaplayan bir program yazın.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen Rakam olarak Bir Sayı Giriniz : ");

        String Number = scanner.nextLine();

        // String'i int'e dönüştür
        int number = Integer.parseInt(Number);

        // Sayının karesi hesaplanır ve ekrana yazdırılır
        System.out.println(number + " Sayısının Karesi : " + (Math.pow(number, 2)));
    }
}
