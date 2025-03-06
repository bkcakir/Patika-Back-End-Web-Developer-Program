package Week1.Practical;

import java.util.Scanner;

public class Pratik_13 {
    public static void main(String[] args) {
        int intNumber;
        double DoubleNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen bir Ondalıklı Sayı Giriniz : ");
        DoubleNumber=scanner.nextDouble();
        intNumber =(int)(DoubleNumber);
        System.out.print("Ondalıklı Sayınız : "+DoubleNumber+" İnteger Tipi :"+intNumber);


    }
}
