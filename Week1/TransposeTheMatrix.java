package Week1;

public class TransposeTheMatrix {
    public static void main(String[] args) {

        int[][] Matrix = new int[2][3];  // 2x3 boyutunda matris
        int[][] Matrix2 = new int[3][2]; // 3x2 boyutunda transpoze matris

        // Matrix matrisini rastgele sayılarla doldur
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                Matrix[i][j] = (int) (Math.random() * 100);
            }
        }

        // Transpoz alma işlemi (satırlar ve sütunlar yer değiştirir)
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                Matrix2[j][i] = Matrix[i][j];  // Transpoz işlemi
            }
        }

        // Matrix matrisini yazdır
        System.out.println("Matris:");
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                System.out.print(Matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Matrix2 (Transpoze Matris) yazdır
        System.out.println("Matris Transpoze:");
        for (int i = 0; i < Matrix2.length; i++) {
            for (int j = 0; j < Matrix2[i].length; j++) {
                System.out.print(Matrix2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
