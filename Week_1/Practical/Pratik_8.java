package Week_1.Practical;

public class Pratik_8 {
    public static void main(String[] args) {
        int n = 10; // Üçgenin yüksekliği

        for (int i = 1; i < n; i++) {
            // Boşlukları yazdır
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Yıldızları yazdır
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
