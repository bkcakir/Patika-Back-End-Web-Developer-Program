package Week1.Practical;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Pratik2 {
//Bir sabit kullanarak ışık hızını metre/saniye cinsinden tanımlayın ve bir kullanıcının girdiği sürede ışığın ne kadar yol aldığını hesaplayın.
    public static void main(String[] args) {
        final int Speed = 300000;
        int Time;
        long Conclusion; // Büyük sayılar için long kullanıyoruz
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Süreyi Giriniz (saniye): ");
        Time = scanner.nextInt();
        Conclusion = (long) Speed * Time; // Çarpma işlemi büyük olacağı için long kullandık

        // Sayıyı 3'lü basamak ayırarak formatlamak için DecimalFormat kullanıyoruz
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedResult = formatter.format(Conclusion);

        System.out.println("Işık " + Time + " saniyede " + formattedResult + " kilometre yol alır.");

        scanner.close();
    }
}
