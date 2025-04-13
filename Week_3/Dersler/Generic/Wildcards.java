package Week_3.Dersler.Generic;

import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3);
        List<String>stringList = List.of("java","Pyhton");

        Print(integerList);
        Print(stringList);
    }

    public  static  void  Print(List<?>List)
    {
        for (Object object : List)
        {
            System.out.println(object);
        }
    }
}
