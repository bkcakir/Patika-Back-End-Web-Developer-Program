package Week_1.Practical;

public class Pratik_39 {
    public static void main(String[] args) {
        int[] Numbers = new int[5];
        int Number;

        for(int i = 0; i< Numbers.length; i++ )
        {
            Numbers[i]=(int)(Math.random()*100);
        }
        for(int i = 0; i< Numbers.length; i++ )
        {
            System.out.print(Numbers[i]+" - ");
        }
        System.out.println();

        for (int i = 0; i < Numbers.length / 2; i++) {
            Number = Numbers[i];  // Geçici değişkende sakla
            Numbers[i] = Numbers[Numbers.length - 1 - i];  // Son elemanı başa al
            Numbers[Numbers.length - 1 - i] = Number;  // Başa aldığımızı sona koy
        }

        for(int i = 0; i< Numbers.length; i++ )
        {
            System.out.print(Numbers[i]+" - ");
        }
    }
}
