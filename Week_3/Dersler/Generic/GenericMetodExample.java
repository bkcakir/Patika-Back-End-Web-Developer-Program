package Week_3.Dersler.Generic;

public class GenericMetodExample {
    public static  <T> void  printArray(T[] array){

        for (T elemnet:array)
        {
            System.out.println(elemnet);
        }
    }
}
