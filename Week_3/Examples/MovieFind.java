package Week_3.Examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MovieFind {
    public static void main(String[] args) {
        movie[] movies = new movie[5];

        movies[0] = new movie("The Shawshank Redemption", 1994, "Drama", 9.3);
        movies[1] = new movie("Inception", 2010, "Science Fiction", 8.8);
        movies[2] = new movie("The Dark Knight", 2008, "Action", 9.0);
        movies[3] = new movie("Forrest Gump", 1994, "Romance/Drama", 8.8);
        movies[4] = new movie("Interstellar", 2014, "Science Fiction", 8.6);

        System.out.println("-----Film Listesi-----");
        for (movie movie : movies) {
            movie.printInfo();
        }
        System.out.println("----------------------");

        System.out.println();

        Arrays.sort(movies, new Comparator<movie>() {
            @Override
            public int compare(movie m1, movie m2) {
                return Double.compare(m2.getImdbPoint(),m1.getImdbPoint());
            }
        });
        System.out.println("IMDb Puanına Göre Sıralanmış Filmler:");
        for (movie movie : movies) {
            movie.printInfo();
        }
        System.out.println("----------------------");


        Arrays.sort(movies, new Comparator<movie>() {
            @Override
            public int compare(movie o1, movie o2) {
                return Integer.compare(o1.getMovieYear(),o2.getMovieYear());
            }
        });

        System.out.println("Çıkış Tarihene Göre Sıralanmış Filmler:");
        for (movie movie : movies) {
            movie.printInfo();
        }
        System.out.println("----------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Film Tür Kodunu Giriniz (1-4):\n1- Drama\n2- Science Fiction\n3- Action\n4- Romance\nSeçim: ");
        int typeNumber = scanner.nextInt();

        String selectedType = "";

        switch (typeNumber) {
            case 1:
                selectedType = "Drama";
                break;
            case 2:
                selectedType = "Science Fiction";
                break;
            case 3:
                selectedType = "Action";
                break;
            case 4:
                selectedType = "Romance";
                break;
            default:
                System.out.println("Lütfen 1-4 arasında geçerli bir tür numarası giriniz.");
                return;
        }

        System.out.println("\nSeçilen Tür: " + selectedType + "\nFilmler:");
        for (movie m : movies) {
            if (m.getMovieType().equalsIgnoreCase(selectedType)) {
                m.printInfo();
            }
        }

    }
}
