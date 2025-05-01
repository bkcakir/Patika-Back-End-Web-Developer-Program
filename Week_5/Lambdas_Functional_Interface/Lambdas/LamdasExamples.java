package Week_5.Lambdas_Functional_Interface.Lambdas;

public class LamdasExamples {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void metod(String string) {
                System.out.println("Hello "+string);
            }
        };
        greeting.metod("cem");

        //java 8 sonrası
        Greeting greeting1 =(name)->System.out.println("Hello "+name);
        Greeting greeting2 =(name)->{
            System.out.println("Hello "+name);
            System.out.println("Ben bir Lamda Metodum");
        };
        greeting1.metod("Burak");
        greeting2.metod("Burak");

        //Lamdas

        //(parmetre) ->{metodGövdesi}
        //eğer Tek Parametre varsa parametre ->metodGövdesi = Greeting greeting1 =(name)->System.out.println("Hello "+name);

    }
}
