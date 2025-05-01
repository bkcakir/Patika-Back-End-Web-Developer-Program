package Week_5.Lambdas_Functional_Interface.functional_interface;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MathOperation sum = (number1,number2)->number1+number2;
        MathOperation multiply = (A,B)->A*B;

        System.out.println("Toplam: "+sum.operate(2,5));
        System.out.println("Çarpma: "+multiply.operate(2,5));
    }
}
