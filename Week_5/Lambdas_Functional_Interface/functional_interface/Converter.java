package Week_5.Lambdas_Functional_Interface.functional_interface;

public interface Converter {
    double convert (double value);

    default void printConversion(double value)
    {
        System.out.println("Sonuc:"+convert(value));

    }
}
