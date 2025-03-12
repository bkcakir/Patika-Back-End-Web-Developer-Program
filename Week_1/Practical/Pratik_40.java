package Week_1.Practical;

import java.util.Arrays;

public class Pratik_40 {
    public static void main(String[] args) {
        int[] arrayA = new int[5];
        int[] arrayB = new int[5];
        int[] mergedArray = new int[10];

        // Rastgele değerler atama
        for (int i = 0; i < 5; i++) {
            arrayA[i] = (int) (Math.random() * 100);
            arrayB[i] = (int) (Math.random() * 100);
        }

        // System.arraycopy ile dizileri birleştirme
        System.arraycopy(arrayA, 0, mergedArray, 0, arrayA.length);
        System.arraycopy(arrayB, 0, mergedArray, arrayA.length, arrayB.length);

        // Dizileri yazdırma
        System.out.println("A Dizisi: " + Arrays.toString(arrayA));
        System.out.println("B Dizisi: " + Arrays.toString(arrayB));
        System.out.println("C Dizisi: " + Arrays.toString(mergedArray));

    }
}
