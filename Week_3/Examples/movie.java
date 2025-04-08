package Week_3.Examples;

public class movie {

    String MovieName;
    int MovieYear;
    String MovieType;
    double ImdbPoint;

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public int getMovieYear() {
        return MovieYear;
    }

    public void setMovieYear(int movieYear) {
        MovieYear = movieYear;
    }

    public String getMovieType() {
        return MovieType;
    }

    public void setMovieType(String movieType) {
        MovieType = movieType;
    }

    public double getImdbPoint() {
        return ImdbPoint;
    }

    public void setImdbPoint(double imdbPoint) {
        ImdbPoint = imdbPoint;
    }

    public movie(String movieName, int movieYear, String movieType, double imdbPoint) {
        this.MovieName = movieName;
        this.MovieYear = movieYear;
        this.MovieType = movieType;
        this.ImdbPoint = imdbPoint;
    }

    public void printInfo() {
        System.out.println("Film Adı: " + MovieName+" Yıl: " + MovieYear+ " Tür: " + MovieType+" IMDb Puanı: " + ImdbPoint);
    }
    public void printTypeInfo(int index) {
        System.out.println(index + ". Tür: " + MovieType);
    }

}
