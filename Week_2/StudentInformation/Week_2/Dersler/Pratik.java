package Week_2.StudentInformation.Week_2.Dersler;

public class Pratik {
    public static void main(String[] args) {

        System.out.println("Factorial : "+Factorial(5));
        System.out.println("Fibonacci : "+Fibonacci(9));
    }

    public  static  int Factorial(int number)
    {
        if(number==0)
        {
            return 1;
        }
        else
        {
            return number * (Factorial(number-1));
        }

    }

    private static int Fibonacci(int Number)
    {
        if(Number==0)
        {
            return 0;
        }
        else if (Number==1) {
            return 1;
        }
        else {
            return Fibonacci(Number - 1) + Fibonacci(Number - 2);
        }
    }
}
