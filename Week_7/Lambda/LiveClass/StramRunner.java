package Week_7.Lambda.LiveClass;

import java.util.ArrayList;
import java.util.Arrays;

public class StramRunner {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ArrayList<String> Names = new ArrayList<>(Arrays.asList("Burak","Velihan","Selin","Burak","samet","Abdullha","Abdullha"));

        Straem01.printNumbers(nums);
        System.out.println();
        /*System.out.println();
        Straem01 stream = new Straem01();
        stream.printNumbers(nums);
        */
         Straem01.printNumbers2(nums);
        System.out.println();
         Straem01.printNumbers3(nums);
        System.out.println();
         Stream02.printNumbers7(nums);
        System.out.println();
         Stream02.maxNumber(nums);
        System.out.println();
         Stream02.maxNumber2(nums);
        System.out.println();
        Stream02.listTotal(nums);
        System.out.println();
        Stream02.listTotal2(nums);
        System.out.println();
        Stream02.listTotal3(nums);


        System.out.println();
        Stream03.printNames1(Names);
        System.out.println();
        Stream03.printNames2(Names);

        System.out.println();
        Stream03.printNames3(Names);


        System.out.println();
        Stream03.printNames4(Names);
    }
}
