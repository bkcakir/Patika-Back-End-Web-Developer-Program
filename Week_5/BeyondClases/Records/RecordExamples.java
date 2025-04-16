package Week_5.BeyondClases.Records;

import Week_5.BeyondClases.Sealed.Rectangel;

import java.util.List;

public class RecordExamples {


    public static void main(String[] args) {
        Point point = new Point(3,4);
        System.out.println(point);
        Point point1 = new Point(1,1);
        System.out.println(point1);


        System.out.println("Rectangel");
        Rectangle rectangel = new Rectangle(3,4);
        System.out.println(rectangel.area());


        System.out.println("Bird");
        Bird mommy = new Bird(4,"Maviş");
        System.out.println( mommy.numberEggs()+"-"+mommy.name());
        var child = new  Bird(0,"Sarı");
        //child.name="Lavcivet"; Compile Olmuyor
        List.of(mommy.getClass().getDeclaredMethods()).forEach(System.out::println);
        List.of(mommy.getClass().getDeclaredConstructors()).forEach(System.out::println);
        var child2 = new  Bird(0,"Sarı","Kanarya");

    }
}
