package Week_2.Dersler;

public class Methods {
    public static void main(String[] args) {

        AddNumber(5,7);
        System.out.println("Toplam"+AddNumber(5.7,7.8));
    }

    private static   void AddNumber(int Number_1,int Number_2)
    {
        int sum = Number_1+Number_2;

        System.out.println("Toplam: "+sum);
    }
    private static   double AddNumber(double Number_1,double Number_2)
    {
        double sum = Number_1+Number_2;

        return sum;
    }
}
