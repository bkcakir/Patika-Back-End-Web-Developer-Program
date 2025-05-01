package Week_5.Lambdas_Functional_Interface.functional_interface;

public class FunctionalInterfaceExample2 {
    public static void main(String[] args) {
       NumberChecker isEvenNumberChecker =number ->number%2==0;

        System.out.println("10 Çift Sayısı mı ?: "+ isEvenNumberChecker.checker(10));
        System.out.println("8 Çift Sayısı mı ?: "+ isEvenNumberChecker.checker(8));
        System.out.println("9 Çift Sayısı mı ?: "+ isEvenNumberChecker.checker(9));

    }
}
