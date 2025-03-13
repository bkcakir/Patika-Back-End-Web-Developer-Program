package Week_2.Pratik;

import java.util.Scanner;

public class Pratik_1 {
    public static void main(String[] args) {
        int Number,Pow;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz :");
        Number=scanner.nextInt();
        System.out.print("Üst Giriniz :");
        Pow=scanner.nextInt();
        System.out.println(Number+"^"+Pow+"="+PowNumber(Number,Pow));
    }

    public  static  int PowNumber(int Number,int Pow)
    {
       if(Pow==0)
       {
           return 1;
       }
       else {
           return Number*PowNumber(Number,Pow-1);
       }
    }
}
