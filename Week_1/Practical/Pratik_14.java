package Week_1.Practical;

import java.util.Scanner;

public class Pratik_14 {
    public static void main(String[] args) {
      int Number_1,Number_2;
      double Total;
        Scanner scanner = new Scanner(System.in);
        //Kullanıcıdan iki tam sayı alarak bunları bölüp sonucu ondalıklı olarak gösterin.
        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number_1=scanner.nextInt();
        System.out.print("Lütfen Bir Sayı Giriniz : ");
        Number_2=scanner.nextInt();

        Total = (double)(Number_1)/(double)(Number_2);

        System.out.print(Number_1+" / "+Number_2+" = "+Total);
    }
}
