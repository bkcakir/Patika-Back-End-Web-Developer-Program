package Week_5.Lambdas_Functional_Interface.method_reference;

import Week_5.Lambdas_Functional_Interface.functional_interface.MathOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MetodReferenceExample {
    public static void main(String[] args) {
        //1: static metod reference ->ClassName :: metodName
        //2 Instance  metod reference ->odjectReference::instanceMetod
        //3 Instance Metod reference(sınıf Üzerinden) -> ClassName:: MetodName
        //4 Constructor metod referance -> ClassName::new

        //1: static metod reference ->ClassName :: metodName
        BiFunction<Integer,Integer,Integer>sum =MathOperations::sum;
        System.out.println("Toplam:"+sum.apply(10,11));

        //2 Instance  metod reference ->odjectReference::instanceMetod
        Printer printer = new Printer();
        Consumer<String> stringConsumer = printer::print;
        stringConsumer.accept("Merhaba Metod Referans");

        //3 Instance Metod reference(sınıf Üzerinden) -> ClassName:: MetodName
        List<String> names = Arrays.asList("Ahmet","Veli","Ayşe","Fatma");
        names.forEach(System.out::println);
        //4 Constructor metod referance -> ClassName::new
        Supplier<Car>carSupplier =Car::new;
        carSupplier.get();

    }
}
