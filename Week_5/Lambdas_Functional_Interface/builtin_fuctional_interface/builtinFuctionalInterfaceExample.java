package Week_5.Lambdas_Functional_Interface.builtin_fuctional_interface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.function.*;

public class builtinFuctionalInterfaceExample {
    public static void main(String[] args) {
        Supplier<LocalDate>localTimeSupplier= LocalDate::now;
        Supplier<LocalDate>LambdaSupplier =()->LocalDate.now();

        LocalDate localDate =localTimeSupplier.get();
        LocalDate  localDate1=LambdaSupplier.get();
        System.out.println(localTimeSupplier);
        System.out.println(LambdaSupplier);
        //Consumer

        Consumer<String>stringConsumer =System.out::println;
        stringConsumer.accept("Patika");
        var map = new HashMap<String,Integer>();
        BiConsumer<String,Integer>integerBiConsumer=map::put;
        integerBiConsumer.accept("Patika",7);
        integerBiConsumer.accept("Patika.dev",13);

        System.out.println(map);

        //Predicate -

        Predicate<String>stringPredicate = String::isEmpty;
        System.out.println(stringPredicate.test(""));
        System.out.println(stringPredicate.test("Patika"));

        BiPredicate<String,String> stringStringBiPredicate = String::startsWith;
        System.out.println(stringStringBiPredicate.test("chicken","Chi"));
        System.out.println(stringStringBiPredicate.test("chicken","Patika"));
        //funciton -BiFaction

        Function<String,Integer> stringIntegerFunction = String::length;
        Function<String,Integer> LambdaFunction= x->x.length();
        System.out.println(stringIntegerFunction.apply("Patikad.dev"));
        System.out.println(LambdaFunction.apply("Patikad.dev"));

        BiFunction<String,String,String>stringStringStringBiFunction=String::concat;

        System.out.println(stringStringStringBiFunction.apply("Patika",".dev"));
    }
}
