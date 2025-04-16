package Week_7.Lambda;

public class Lambda01Runner {
    public static void main(String[] args) {
        //Clasicc

        Lambada01.Printer printer1 = new Lambada01.Printer() {
            @Override
            public void print() {
                System.out.println("Classic Yöntem");
            }
        };
        printer1.print();

        Lambada01.Printer printer2=()->System.out.print("Lamda Yöntemi");
        printer2.print();

        //Çok Satır
        Lambada01.Printer printer3=()->
        System.out.println("Printing Line 1");
        System.out.println("Printing Line 2");
        System.out.println("Printing Line 3");

        printer3.print();


        Lambada01.Greeting greeting = name ->{
            System.out.println("Test");
            return "Hello"+ name;
        };
        System.out.println(greeting.greet("mesut"));

        Lambada01.Greeting2 greeting2 = name ->{
            System.out.println(name);
        };
        greeting2.greet("Ali");
    }
}
