package Week1.Dersler.Pratikler;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPratik_1 {

    public static void main(String[] args) {

        int Line, Column, Rnd, Ln, Sn, Z = 0,Number,Counter=0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Matris Kaç Satırlı Olacak: ");
        Line = scanner.nextInt();
        System.out.print("Matris Kaç Sütunlu Olacak: ");
        Column = scanner.nextInt();

        int[][] RandomNumber = new int[Line][Column];
        int[] Numbers = new int[Line * Column];

        // Matris elemanlarını doldur ve Array dizisini oluştur
        for (int i = 0; i < Line; i++) {
            for (int j = 0; j < Column; j++) {
                Rnd = (int) (Math.random() * 100);
                RandomNumber[i][j] = Rnd;
                Numbers[Z] = RandomNumber[i][j];
                Z++;
            }
        }

        // İlk elemanı en büyük ve en küçük değer olarak başlat
        Ln = Sn = RandomNumber[0][0];

        // En büyük ve en küçük sayıyı bul
        for (int i = 0; i < Line; i++) {
            for (int j = 0; j < Column; j++) {
                if (RandomNumber[i][j] < Sn) {
                    Sn = RandomNumber[i][j];
                }
                if (RandomNumber[i][j] > Ln) {
                    Ln = RandomNumber[i][j];
                }
            }
        }

        // En büyük ve en küçük sayıyı yazdır
        System.out.print("Matrixdeki En Büyük Sayı: " + Ln + "\tEn Küçük Sayı: " + Sn);
        System.out.println();

        // Matrisin elemanlarını yazdır
        System.out.println("Matris:");
        for (int i = 0; i < Line; i++) {
            for (int j = 0; j < Column; j++) {
                System.out.print(RandomNumber[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        // Numbers dizisini yazdır
        System.out.print("Dizinin İlk Hali: {");
        for (int i = 0; i < Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.print("}");
        System.out.println();

        // Diziyi sıraladıktan sonra yazdır
        Arrays.sort(Numbers);

        System.out.print("Dizinin Son Hali: {");
        for (int i = 0; i < Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.print("}");

        System.out.println();
        System.out.print("Aramak İstediğiniz Sayıyı Giriniz: ");
        Number=scanner.nextInt();

        for(int i=0; i<Numbers.length;i++)
        {
            if(Numbers[i]==Number)
            {
                Counter++;
            }

        }
        System.out.print("Aradığınız Sayı : "+Number+" Dizide Bu Sayı "+Counter+" Defa Tekrar Etmiştir !!");
    }
}
