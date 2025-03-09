package Week_1.Practical;

import java.util.Scanner;

//Sabitlerle matematik işlemleri yaparak bir silindirin hacmini hesaplayan bir program yazın.

public class Pratik_5 {
    public static void main(String[] args) {
        final double Pi = 3.14;
        int Radius,Height;
        double Conclusion;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Slindirin Yarı Capı Giriniz : ");
        Radius=scanner.nextInt();
        System.out.print("Slindirin Yüksekliğini  Giriniz : ");
        Height=scanner.nextInt();

        Conclusion =(Pi*Math.pow(Radius,2)*Height)/4;

        System.out.print("Silindirin Hacmi :"+Conclusion);
    }
}
