package Week_1.Practical;

import java.util.Scanner;

public class Pratik_30 {
    public static void main(String[] args) {
        //Kullanıcının notuna göre harf karşılığını belirleyen bir program yazın.
        int Note;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Notunu Giriniz : ");
        Note=scanner.nextInt();
        if(Note>=0 && Note<30)
        {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : FF" );
        }
        else if (Note>=30 && Note<50) {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : DD" );
        }
        else if (Note>=50 && Note<60) {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : DC" );
        }
        else if (Note>=60 && Note<70) {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : CC" );
        }
        else if (Note>=60 && Note<80) {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : BC" );
        }
        else if (Note>=80 && Note<95) {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : BB" );
        }
        else if (Note>=95 && Note<100) {
            System.out.println("Notunuz : "+ Note + " Harf Notunuz : AA" );
        }
        else {
            System.out.println("Lütfen Notunu 0  ile 100 Arasında Giriniz \n Girdiniz Note : "+ Note);
        }
    }
}
