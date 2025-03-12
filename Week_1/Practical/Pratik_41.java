package Week_1.Practical;

import java.util.Arrays;

public class Pratik_41 {
    public static void main(String[] args) {
        int[] Numbers =  new  int[10];

        for (int i = 0; i<Numbers.length; i++)
        {
            Numbers[i] = (int)(Math.random()*100);

        }

        System.out.println("Dizi: " + Arrays.toString(Numbers));
        System.out.println("Dizideki En Büyük Sayı : "+ Arrays.stream(Numbers).max() +" "+" Dizideki En Küçük Sayı : "+ Arrays.stream(Numbers).min().toString());



    }
}
