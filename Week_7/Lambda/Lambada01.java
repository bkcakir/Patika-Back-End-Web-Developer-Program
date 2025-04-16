package Week_7.Lambda;

public class Lambada01 {
    interface  Printer{
        void  print();

        public default void  run2()
        {
            System.out.println();
        }
    }
    @FunctionalInterface
    interface  Greeting{
        String greet(String name);
    }

    interface  Greeting2{
        void  greet(String name);
    }


}
