package Week_7.Lambda.LiveClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03 {
    //Distinct
    //Task-1
    public  static  void  printNames1(ArrayList<String> list)
    {
      list.stream().map(String::toUpperCase)
              .distinct()
              .sorted()
              .forEach(StreamUtils::yazdirString);
    }
    public  static  void  printNames2(ArrayList<String> list)
    {
        list.stream().map(String::length)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(StreamUtils::yazdir);
    }
    //Task-3
    public  static  void  printNamesMert(ArrayList<String> list)
    {
        list.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(StreamUtils::yazdirString);
    }
    //Collect
    //Task-4
    public  static List<Integer> printNames3(ArrayList<String> list)
    {
      return   list.stream().map(String::length)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    //Task-5
    public static List<String> printNames4(ArrayList<String> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }
    // ***************************** anyMatch() *** allMatch() *** nomeMatch()***************
    //anyMatch()
    //allMatch();
    //nomeMatch();

    //Task-6
    public  static  void  leaghtNamesList(ArrayList<String>list){
        System.out.println("AllMatch :"+list.stream().allMatch(t -> t.length() >= 4));
    }
    public  static  void  leaghtNamesList3(ArrayList<String>list){
        System.out.println("NoneMatch :"+list.stream().allMatch(t -> t.startsWith("w")));
    }

}
