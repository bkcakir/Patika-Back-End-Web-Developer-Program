package Week_2;

public class NumberRounding {
    public static void main(String[] args) {
        Double Number;
        Number =  Math.random()*100;  // Number 0 ile 100 arasında Double Deger Atar
        System.out.println("Double Sayımız : "+Number);

        System.out.println("Aşağı Yuvarlama: " +Math.floor(Number)); //Math.floor Her zaman Alt Seviye Yuvarllar
        System.out.println("Yukarı  Yuvarlama: "+Math.ceil(Number)); //Math.ceil Her zaman Üst Seviye Yuvarllar
        System.out.println("En Yakın Tam Sayı: "+Math.round(Number)); //Math.randoö Her zaman En Yakın  Seviye Yuvarllar
    }
}
