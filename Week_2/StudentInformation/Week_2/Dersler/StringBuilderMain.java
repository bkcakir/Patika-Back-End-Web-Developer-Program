package Week_2.Dersler;

public class StringBuilderMain {
    public static void main(String[] args) {

        String Name= "patika.dev";
        System.out.println(Name);
        var Name2= Name.replace('p','P');

        System.out.println(Name2);

        StringBuilder stringBuilder = new StringBuilder();//Stringler imurtable(Değiştirilemez)
        stringBuilder.append("Patika");

        StringBuilder Alphabet = new StringBuilder(); //nutable bir yapıdır

        for(char current='a'; current<='z';current++)
        {
            Alphabet.append(current);
        }
        System.out.println(Alphabet);


        StringBuilder Builder = new StringBuilder();
        Builder.append("Pakita").append(".dev").append(" Java");
        Builder.append(" Eğiimi");

        System.out.println(Builder);


        var Hello = "Hello Patika";
        var Hello2 = "Hello Patika";

        System.out.println(Hello.equals(Hello2)); //degerleri Eşit mi ?
        System.out.println(Hello==Hello2); // Hafızadaki yerleri Esit mi ?


        String s ="Hello World";
        String s1=" Hello World".trim();
        System.out.println(s==s1); // Hafızadaki yerleri Esit mi ?


        var SingleString ="Hello World";
        var Concat ="Hello";
        Concat+=" World";

        System.out.println();

        System.out.println(SingleString.equals(Concat)); //degerleri Eşit mi ?
        System.out.println(SingleString==Concat); // Hafızadaki yerleri

        System.out.println();
        var Hello3 = "Hello Patika";
        var Hello4 =  new String("Hello Patika").intern();

        System.out.println(Hello3==Hello4); // Hafızadaki yerleri Esit mi ?

    }
}
