package Week1.Practical;

import java.util.Scanner;

public class Pratik_27 {
    public static void main(String[] args) {
        int angle, total = 0;
        Scanner scanner = new Scanner(System.in);

        //Kullanıcının girdiği üçgen kenar uzunluklarının bir üçgen oluşturup oluşturmadığını belirleyen bir program yazın.

        for (int i = 0; i < 3; i++) {
            System.out.print("Üçgenin bir açısını giriniz: ");
            angle = scanner.nextInt();

            // Negatif veya sıfır açı kontrolü
            if (angle <= 0) {
                System.out.println("Geçersiz açı girdiniz! Açılar 0 veya negatif olamaz.");
                scanner.close();
                return; // Programı sonlandır
            }

            total += angle;
        }

        scanner.close(); // Scanner'ı kapat

        // Açılar toplamı 180° ise üçgendir
        if (total == 180) {
            System.out.println("Bu bir üçgendir.");
        } else {
            System.out.println("Bu bir üçgen değildir.");
        }
    }
}
