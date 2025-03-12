package Week_1.Practical;

import java.util.Arrays;
import java.util.Scanner;

public class Pratik_42 {
    public static void main(String[] args) {
        String[] Lines = new  String[5];

        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<Lines.length;i++)
        {
            System.out.print("Kelime giriniz : ");
            Lines[i]=scanner.nextLine();

        }
        String Ln=Lines[0];
        for (int i = 0; i < Lines.length; i++) {
            System.out.print(Lines[i]);
            if (i < Lines.length - 1) {
                System.out.print(","); // Son elemandan sonra virgül eklenmemeli
            }
            if(Lines[i].length()>Ln.length())
            {
                Ln=Lines[i];
            }
        }
        System.out.println();
        System.out.println("Dizideki En uzun Kelime : "+ Ln);

    }
}
