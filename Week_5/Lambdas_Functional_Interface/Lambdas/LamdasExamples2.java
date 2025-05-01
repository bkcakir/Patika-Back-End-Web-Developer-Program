package Week_5.Lambdas_Functional_Interface.Lambdas;

import java.util.ArrayList;
import java.util.List;

public class LamdasExamples2 {
    public static void main(String[] args) {

     var animals = new ArrayList<Animal>();

     animals.add(new Animal("Fish",false,true));
     animals.add(new Animal("Kangaroo",true,false));
     animals.add(new Animal("Rabit",true,false));
     animals.add(new Animal("Turtle",false,true));

     //Java 8 öncesi
        // print(animals,new CheckIfHopper());
        //print(animals,new CheckIfSivm());

     // Java 8Sonrası
        print(animals,a-> a.canHop());
        print(animals,a-> a.canSwim());

        print(animals, (a)->{
            System.out.println("lamdas ifadesileri" +
                    "");
            return !a.canSwim();
        });

//        var invalid= (Animal animal) ->animal.canHop();
//        boolean valid =(Animal a)-> return a.canHop();
    }

    private  static  void  print (List<Animal> animalList, CheckTrait checker)
    {
        for (Animal animal :animalList)
        {
            if (checker.test(animal))
            {
                System.out.print(animal+" ");
            }
        }
        System.out.println();
    }
}
