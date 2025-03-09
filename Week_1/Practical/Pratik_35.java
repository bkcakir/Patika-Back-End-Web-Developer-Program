package Week_1.Practical;

import java.util.Scanner;

public class Pratik_35
{
    //Kullanıcının girdiği harfe göre sesli veya sessiz harf olup olmadığını belirleyen bir program yazın.
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String Vowels;

            System.out.print("Harf Giriniz :");
            Vowels=scanner.nextLine();

            switch (Vowels.toUpperCase())
            {
                case "A":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "E":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "İ":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "I":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "O":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "Ö":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "U":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                case "Ü":
                    System.out.print("Sesli Harfdir Girdiniz Harf : "+ Vowels.toUpperCase());
                    break;
                default:
                    System.out.print("Sesli Harf Degildir Giriniz Harf : "+Vowels);
            }

        }

}
