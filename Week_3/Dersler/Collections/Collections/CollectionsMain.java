package Week_3.Dersler.Collections.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsMain {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(30);
        ArrayList<Integer> integers1 = new ArrayList<>();

        List<String> ShopingList = new ArrayList<>();

        ShopingList.add("Banana");
        ShopingList.add("Apple");
        ShopingList.add(1,"Mango");

        for (String s : ShopingList)
        {
            System.out.println(s);
        }
        System.out.println("---------------");
        boolean İsAppleRemoved= ShopingList.remove("Apple");
        System.out.println("İsAppleRemoved : "+İsAppleRemoved);
        for (String s : ShopingList)
        {
            System.out.println(s);
        }
        System.out.println("---------------");
        boolean İsBananaRemoved= ShopingList.remove("Muz");
        System.out.println("İsBananaRemoved : "+İsBananaRemoved);

        for (String s : ShopingList)
        {
            System.out.println(s);
        }
        ArrayList<String> ShopingList2 = new ArrayList<>();
        ShopingList2.add("Milk");
        ShopingList2.add("Jacket");
        ShopingList2.add("scaft");
        ShopingList.addAll(ShopingList2);
        System.out.println(ShopingList);

        System.out.println("Urun Var mı ? : "+ShopingList.contains("Milk"));
        System.out.println("Listenizde Ürün Adedi  : "+ShopingList.size() + "Adet Ürün Var");

        System.out.println(ShopingList.getLast());


        System.out.println("LinkedList");

        List<String> names = new LinkedList<>();
        names.add("cem");
        names.add("Patika");
        names.add("Java Kursu");
        names.addLast("Burak");

        System.out.println(names);
    }
}
