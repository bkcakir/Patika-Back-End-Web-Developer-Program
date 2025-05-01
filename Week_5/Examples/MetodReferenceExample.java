package Week_5.Examples;

import java.util.ArrayList;
import java.util.List;

public class MetodReferenceExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ahmet");
        names.add("Ayşe");
        names.add("Mehmet");
        names.add("Zeynep");
        names.forEach(System.out::println);

    }
}

