package Week_2.StudentInformation.Week_2.Dersler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateMain {
    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());

        System.out.println();

        System.out.println(LocalDate.now().plusDays(30));
        System.out.println(LocalDate.now().plusMonths(3));
        System.out.println(LocalDate.now().plusYears(1));


        var date = LocalDate.of(2033,8,5);

        System.out.println(date);

        System.out.println( LocalDate.now().minusDays(5));
        System.out.println( LocalDate.now().minusMonths(3));
        System.out.println( LocalDate.now().minusYears(5));


        var ExpireDate = LocalDate.of(2024,12,1);

        boolean isBefore =ExpireDate.isBefore(LocalDate.now());

        if(isBefore)
        {
            System.out.println("Paketinizin Süresi Dolmuştur");
        }
        boolean after = ExpireDate.plusMonths(5).isAfter(LocalDate.now());

        System.out.println(after);


    }
}
