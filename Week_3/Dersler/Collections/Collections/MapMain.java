package Week_3.Dersler.Collections.Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {

        Map<String,Integer> students = new HashMap<>();
        students.put("Burak",123);
        students.put("Mehmet",123);
        students.put("Ali",123);
        students.put("Velihan",123);
        students.put("Selin",123);

        System.out.println("students:"+students);

        System.out.println("Burak Notu : "+students.get("Burak"));

        System.out.println("Keys:"+students.keySet());

        System.out.println("Values:"+students.values());

        students.remove("Ali");
        System.out.println("students:"+students);

        System.out.println("Keys:"+students.keySet());

        System.out.println("Values:"+students.values());

       Map<String,String> contries = new LinkedHashMap<>();

       contries.put("TR","Türkiye");
       contries.put("DE","Alamanya");
       contries.put("US","Amerika");
    }
}
