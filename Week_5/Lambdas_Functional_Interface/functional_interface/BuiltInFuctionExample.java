package Week_5.Lambdas_Functional_Interface.functional_interface;

import java.util.function.Function;

public class BuiltInFuctionExample {
    public static void main(String[] args) {

       Function<String,Integer> LenghtFuction= str ->str.length();
        System.out.println("Kelime Uzunlugu "+ LenghtFuction.apply("Merhaba Patika"));
    }
}
