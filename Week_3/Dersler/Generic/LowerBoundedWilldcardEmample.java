package Week_3.Dersler.Generic;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWilldcardEmample {

    public  static  void  add(List<?super Integer> list){
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        add(numbers);
        System.out.println(numbers);
        List<Double> doubleList = List.of(1.5,2.5,3.5,4.5);
        //add(doubleList);
    }
}
