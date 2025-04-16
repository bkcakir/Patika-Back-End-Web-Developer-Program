package Week_5.Examples.Enums;

import java.util.Scanner;

public class EnumsMain {

    public static void main(String[] args) {
        int Action;
        Scanner scanner = new Scanner(System.in);
        for (WorkTime time :WorkTime.values())
            System.out.println(time.ordinal()+1+"-"+time.name());

        System.out.print("Lütfen Bir Gün Seçiniz :");
        Action=scanner.nextInt();

        switch (Action)
        {
            case 1:
                System.out.println(WorkTime.SUNDAY.name()+" için çalışma saati : "+WorkTime.SUNDAY.getWorkTime());
                break;
            case 2:
                System.out.println(WorkTime.MONDAY.name()+" için çalışma saati :"+WorkTime.MONDAY.getWorkTime());
                break;
            case 3:
                System.out.println(WorkTime.TUESDAY.name()+" için çalışma saati :"+WorkTime.TUESDAY.getWorkTime());
                break;
            case 4:
                System.out.println(WorkTime.WEDNESDAY.name()+" için çalışma saati :"+WorkTime.WEDNESDAY.getWorkTime());
                break;
            case 5:
                System.out.println(WorkTime.THURSDAY.name()+" için çalışma saati :"+WorkTime.THURSDAY.getWorkTime());
                break;
            case 6:
                System.out.println(WorkTime.FRIDAY.name()+" için çalışma saati :"+WorkTime.FRIDAY.getWorkTime());
                break;
            case 7:
                System.out.println(WorkTime.SATURDAY.name()+" için çalışma saati :"+WorkTime.SATURDAY.getWorkTime());
                break;
            default:
                System.out.println("Lütfen 1-7 Arasında Bir gün Şeçiniz");
                break;



        }

    }
}
