package Week_5.BeyondClases.LocalClass;

public class LocalClassExample2 {
    public  void  calculate(int number1,int number2)
    {

        class  Calculatation{
            int sum()
            {
                return number1+number2;
            }
        }
        Calculatation calculatation = new  Calculatation();
        int sum =calculatation.sum();
        System.out.println(sum);
    }
}
