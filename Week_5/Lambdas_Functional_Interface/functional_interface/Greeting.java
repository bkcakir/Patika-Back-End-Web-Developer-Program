package Week_5.Lambdas_Functional_Interface.functional_interface;

@FunctionalInterface
public interface Greeting {
    void  sayhello();

//    void  sayhello3(); FunctionalInterface İçerisinde birden fazla abstract metod olmaz

    default void sayhello2()
    {
        System.out.println("default method");
    }

}
