package Week1;

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        // Değişkenler tanımlanıyor: birthYear (doğum yılı) ve chineseZodiac (Çin Zodyağı)
        int birthYear, chineseZodiac;
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan doğum yılı alınır
        System.out.print("Doğum Yılınızı Giriniz : "); // "Enter your birth year"
        birthYear = scanner.nextInt();

        // Çin Zodyağı hesaplaması yapılır: doğum yılı % 12
        chineseZodiac = birthYear % 12;

        // Çin Zodyağı'na göre burç belirleniyor
        switch (chineseZodiac)
        {
            case 0:
                System.out.print("Çin Zodyağı Burcunuz : Maymun"); // "Your Chinese zodiac sign: Monkey"
                break;
            case 1:
                System.out.print("Çin Zodyağı Burcunuz : Horoz"); // "Your Chinese zodiac sign: Rooster"
                break;
            case 2:
                System.out.print("Çin Zodyağı Burcunuz : Köpek"); // "Your Chinese zodiac sign: Dog"
                break;
            case 3:
                System.out.print("Çin Zodyağı Burcunuz : Domuz"); // "Your Chinese zodiac sign: Pig"
                break;
            case 4:
                System.out.print("Çin Zodyağı Burcunuz : Fare"); // "Your Chinese zodiac sign: Rat"
                break;
            case 5:
                System.out.print("Çin Zodyağı Burcunuz : Öküz"); // "Your Chinese zodiac sign: Ox"
                break;
            case 6:
                System.out.print("Çin Zodyağı Burcunuz : Kaplan"); // "Your Chinese zodiac sign: Tiger"
                break;
            case 7:
                System.out.print("Çin Zodyağı Burcunuz : Tavşan"); // "Your Chinese zodiac sign: Rabbit"
                break;
            case 8:
                System.out.print("Çin Zodyağı Burcunuz : Ejderha"); // "Your Chinese zodiac sign: Dragon"
                break;
            case 9:
                System.out.print("Çin Zodyağı Burcunuz : Yılan"); // "Your Chinese zodiac sign: Snake"
                break;
            case 10:
                System.out.print("Çin Zodyağı Burcunuz : At"); // "Your Chinese zodiac sign: Horse"
                break;
            case 11:
                System.out.print("Çin Zodyağı Burcunuz : Koyun"); // "Your Chinese zodiac sign: Sheep"
                break;
            default:
                System.out.print("Hatalı Veri Girdiniz!!"); // "Invalid input!!"
                break;
        }
    }
}
