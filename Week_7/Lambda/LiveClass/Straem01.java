package Week_7.Lambda.LiveClass;

import java.util.ArrayList;
import java.util.List;

public class Straem01 {
    //Taks:3
    public static  void  printNumbers(ArrayList<Integer>list){
        for(Integer w: list)
        {
            System.out.print(w+" ");
        }
    }
    //stream - foreach
    //Taks:4
    public  static  void  printNumbers2(ArrayList<Integer>list) {
    list.stream().forEach(w-> System.out.print(w+" "));
    }
    //Taks:5
    public  static  void  printNumbers3(ArrayList<Integer>list) {
        list.stream().forEach(System.out::print);
    }


}
