package Week_1.Practical;

import java.util.Scanner;

public class Pratik_34 {
    //Kullanıcının girdiği gün numarasına göre haftanın gününü yazdıran bir program yazın.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Day;

        System.out.print("Hangi Gün  Sayısı giriniz  (1-7)  :");
        Day=scanner.nextInt();

        switch (Day)
        {
            case 1:
                System.out.print("Pazartesi");
                break;
            case 2:
                System.out.print("Salı");
                break;
            case 3:
                System.out.print("Çarşamba");
                break;
            case 4:
                System.out.print("Perşembe");
                break;
            case 5:
                System.out.print("Cuma");
                break;
            case 6:
                System.out.print("Cumartesi");
                break;
            case 7:
                System.out.print("Pazar");
                break;
            default:
                System.out.print("Hatalı veri Giriniz !!  Veriniz : "+Day);
        }

    }
}
