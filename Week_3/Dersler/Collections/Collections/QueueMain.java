package Week_3.Dersler.Collections.Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> BreadQeue = new PriorityQueue<>();

        BreadQeue.add("Cem");
        BreadQeue.add("Emir");
        BreadQeue.add("Ahmet");
        BreadQeue.add("Ayşe");

        System.out.println(BreadQeue);
    }
}
