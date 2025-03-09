package Week_1.Practical;

public class Pratik_36 {
    public static void main(String[] args) {
        //10 elemanlı bir dizinin elemanlarını kullanıcıdan alıp ortalamasını hesaplayan bir program yazın.
        int[] Numbers = new int[10];
        int Rnd,Avg=0;
        for (int i = 0 ; i<Numbers.length; i++)
        {
            Rnd = (int) (Math.random() * 1000);
            Numbers[i]=Rnd;
            Avg+=Rnd;
        }

        // Numbers dizisini yazdır
        System.out.print("{");
        for (int i = 0; i < Numbers.length; i++) {
            System.out.print(Numbers[i]);
            if (i < Numbers.length - 1) {
                System.out.print(", "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.print("\nDizinin Ortalaması : "+(Avg/Numbers.length));

    }
}
