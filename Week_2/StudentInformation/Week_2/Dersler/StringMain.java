package Week_2.StudentInformation.Week_2.Dersler;

public class StringMain {
    public static void main(String[] args) {

        String Flower = "Papatya"; //7


        System.out.println(Flower+" Karakter Uzunlugu : "+Flower.length()+" Karakterdir");

        System.out.print("Heceleri : {");
        for (int i = 0; i < Flower.length(); i++) {
            System.out.print(Flower.charAt(i));
            if (i < Flower.length() - 1) {
                System.out.print(" - "); // Son elemandan sonra virgül eklenmemeli
            }
        }
        System.out.print("}");
        System.out.println();

        for(int j=0; j<Flower.length();j++)
        {

                System.out.println("Aradıgınız Harf : "+Flower.charAt(j)+" Bulundugu İndex :"+Flower.indexOf(Flower.charAt(j)) );
        }

        System.out.println(Flower.substring(0,3)+" - "+Flower.substring(3,7));






    }

}
