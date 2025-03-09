package Week_1.Practical;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Pratik_31 {
    /*
    * Bir çalışanın yıllık maaşına göre ödeyeceği vergi miktarını hesaplayan bir program yazınız. Program,
      kullanıcının maaş bilgisini girdikten sonra aşağıdaki vergi dilimlerine göre vergiyi hesaplamalıdır:
        ₺0 - ₺50,000: %5 vergi
        ₺50,001 - ₺150,000: %10 vergi
        ₺150,001 - ₺300,000: %20 vergi
        ₺300,001 ve üzeri: %30 vergi
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Aylık Maaşınızı Giriniz: ");
        double MonthlySalary = scanner.nextDouble();
        scanner.close(); // Kullanım sonrası Scanner kapatılmalı

        if (MonthlySalary <= 0) {
            System.out.println("Lütfen geçerli bir maaş giriniz!");
            return;
        }

        double AnnualSalary = MonthlySalary * 12;
        double Tax = 0;

        if (AnnualSalary <= 50000) {
            Tax = AnnualSalary * 0.05;
        } else if (AnnualSalary <= 150000) {
            Tax = AnnualSalary * 0.10;
        } else if (AnnualSalary <= 300000) {
            Tax = AnnualSalary * 0.20;
        } else {
            Tax = AnnualSalary * 0.30;
        }

        double netSalary = AnnualSalary - Tax;

        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedResult = formatter.format(AnnualSalary);

        System.out.println("Yıllık Maaşınız: " + formattedResult+" TL");

        formattedResult = formatter.format(Tax);
        System.out.println("Ödenecek Vergi: " + formattedResult+" TL");

        formattedResult = formatter.format(netSalary);
        System.out.println("Net Maaşınız: " + formattedResult+" TL");
    }

}
