package Week1.Practical;
//Satranç tahtası (8x8) şeklinde # ve * kullanarak desen oluşturan bir program yazın.
public class Pratik_10 {
    public static void main(String[] args) {
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                if(j%2==0)
                {
                    System.out.print("#");
                }
                else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }
}
