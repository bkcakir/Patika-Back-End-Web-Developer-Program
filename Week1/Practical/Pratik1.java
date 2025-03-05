package Week1.Practical;

import java.util.Scanner;

//Sabit bir pi değeri tanımlayarak dairenin alanını hesaplayan bir program yazın.
//A=π×r2
public class Pratik1 {
    public static void main(String[] args) {
        final double Pi =3.14;
        int Radius;
        double Area;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dairenin Yarı Çapını Giriniz : ");
        Radius=scanner.nextInt();
        Area=Pi* Math.pow(Radius,2);

        System.out.println("Dairenizin Alanı : "+Area);
    }
}
