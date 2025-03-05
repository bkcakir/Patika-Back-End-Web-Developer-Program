package Week1.Practical;
import java.text.DecimalFormat;
import java.util.Scanner;

//Bir sabit kullanarak 1 günün saniye cinsinden değerini tutan bir program yazın ve kullanıcının girdiği gün sayısını saniyeye çevirin.

public class Pratik_3 {
    public static void main(String[] args) {
        final int Second = 86400;
        int Day,Conclusion;
        Scanner scanner= new Scanner(System.in);

        System.out.print("Kaç Gün Hesaplamak İstiyorsunuz : ");
        Day=scanner.nextInt();
        Conclusion=Day*Second;
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedResult = formatter.format(Conclusion);

        System.out.println(Day+"Gün Şu kadar Saniye Yapar :"+formattedResult+"s");


    }
}
