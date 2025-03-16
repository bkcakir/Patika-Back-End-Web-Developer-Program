package CodeWars_Pratik;

public class integrate {
    public static void main(String[] args) {

        System.out.println(integrate(3,2));
        System.out.println(integrate(12,5));
        System.out.println(integrate(20,1));
        System.out.println(integrate(40,3));
        System.out.println(integrate(90,2));



    }
    public static String integrate(int coefficient, int exponent) {

        String A=(coefficient/(exponent+1)+"x^"+(exponent+1));
        return A;
    }
}
