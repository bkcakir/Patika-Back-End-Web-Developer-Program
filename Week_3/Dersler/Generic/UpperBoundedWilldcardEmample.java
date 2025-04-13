package Week_3.Dersler.Generic;

import java.util.List;

public class UpperBoundedWilldcardEmample {

    public  static  double sum (List<? extends  Number>list)
    {
        double sum = 0;

        for (Number number: list)
        {
            sum+=number.doubleValue();
        }
        return  sum;
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4);
        List<Double> doubleList = List.of(1.5,2.5,3.5,4.5);
        List<String>stringList = List.of("Pyhton");

        System.out.println(sum(doubleList));
        System.out.println(sum(integerList));

        //sum(stringList);

    }
}
