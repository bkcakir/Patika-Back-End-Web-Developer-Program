package Week_7.Lambda.LiveClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Stream02 {
    //Task 5: Verilen listedeki çift sayıları bulup, karelerini alan ve yazdıran metod
    public  static  void  printNumbers7(ArrayList<Integer> list)
    {
        list.stream()
                .filter(t->t%2==0)
                .map(t->t*t)
                .forEach(StreamUtils::yazdir);
    }

    //Task 6: Verilen listedeki tek sayıları bulup, küplerini alıp 1 ekleyen ve yazdıran metod
    public  static  void  printNumbers8(ArrayList<Integer> list)
    {
        list.stream()
                .filter(t->t%2!=0)
                .map(t->(t*t*t)+1)
                .forEach(StreamUtils::yazdir);
    }

    //Task 7: Verilen listedeki en büyük sayıyı bulan ve yazdıran metod
    public  static  void  maxNumber(ArrayList<Integer> list)
    {
        Optional<Integer>MaxEleman = list.stream().reduce(Math::max);
        System.out.println(MaxEleman);
        System.out.println("Listenin En Büyük Elemanı : "+MaxEleman.get());
        MaxEleman.ifPresent(System.out::print);
    }

    //Task 8: Verilen listedeki çift sayıların karelerini alıp, en büyük olanı bulan ve yazdıran metod
    public  static  void  maxNumber2(ArrayList<Integer> list)
    {
        Optional<Integer>MaxEleman = list.stream()
                .filter(StreamUtils::ciftBul)
                .map(t->t*t)
                .reduce(Math::max);
        System.out.println(MaxEleman);
        System.out.println("Listenin En Büyük Elemanı : "+MaxEleman.get());
        MaxEleman.ifPresent(System.out::print);
    }

    //Task 9: Verilen listedeki tüm sayıların toplamını bulan ve yazdıran metod
    public  static  void  listTotal(ArrayList<Integer> list)
    {
       int Total= list.stream().reduce(0,(a,b)->a+b);
        System.out.println("Listenin Total  Degeri :" + Total);
    }

    //Task 10: Verilen listedeki tüm sayıların çarpımını bulan ve yazdıran metod (Math::multiplyExact kullanarak)
    public  static  void  listTotal2(ArrayList<Integer> list)
    {
        System.out.println("Listenin Çarpım Total  Degeri :" + list.stream().reduce(Math::multiplyExact));
    }

    //Task 11: Verilen listedeki tüm sayıların çarpımını bulan ve yazdıran metod (Lambda ifadesi kullanarak)
    public  static  void  listTotal3(ArrayList<Integer> list)
    {
        int Total= list.stream().reduce(1,(a,b)->a*b);
        System.out.println("Listenin Total  Degeri :" + Total);
    }

    //Task 12: Verilen listedeki çift sayıları büyükten küçüğe sıralayıp yazdıran metod
    public  static  void  maxMinStorted(ArrayList<Integer> list)
    {
       list.stream().filter(StreamUtils::ciftBul)
               .sorted(Comparator.reverseOrder()) // Büyükten Küçüğe sıralama
               .forEach(StreamUtils::yazdir);
    }
}
