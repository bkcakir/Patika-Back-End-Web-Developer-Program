package Week_7.Lambda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.*;

public class Built_In_Interfaces {
    /*
    Supplier<T>
    Consumer<T> ve BiConsumer<T,U>
    Predicate<T> ve BiConsumer<T,U>

     */
    public static void main(String[] args) {
        //Supplier<T>
        Supplier<String> name =()->"Mesut";
        System.out.println(name.get());

        Supplier<LocalDate> time =()->LocalDate.now();
        System.out.println(time.get());
        
        //  Consumer<T> ve BiConsumer<T,U>
        Consumer<String>printName =  Name2 -> System.out.println("Merhaba"+ Name2);
        printName.accept("Velihan");

        BiConsumer<String,Integer> printNameAge= (name3,age)-> System.out.println(name3+ age+" Yaşında");
        printNameAge.accept("Velihan",25);

        /*
        Bir Degeralır Koşulla Tabi tutar boolean
         */
        Predicate<Integer>isEven = num->num%2==0;
        System.out.println(isEven.test(10));

        BiPredicate<String,String>start = (str,prefix)->str.startsWith(prefix);
        System.out.println( "Pakita :"+start.test("patika","pa"));
        System.out.println("Burak"+start.test("Burak","a"));
    }

}
