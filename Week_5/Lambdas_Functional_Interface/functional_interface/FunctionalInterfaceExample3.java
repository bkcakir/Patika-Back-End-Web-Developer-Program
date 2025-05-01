package Week_5.Lambdas_Functional_Interface.functional_interface;

public class FunctionalInterfaceExample3 {
    public static void main(String[] args) {

        Converter celsiusToFahreheit= celsius->(celsius*1.8)+32;
        celsiusToFahreheit.printConversion(25);
    }
}
