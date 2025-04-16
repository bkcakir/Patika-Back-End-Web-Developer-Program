package Week_5.BeyondClases.AnonymousClass;

public class AnonymousExample {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Merhaba ben bir anonim classım");
            }
        };
        greeting.sayHello();


        //---
        Greeting greeting1 = new GreetingImpl();
        greeting1.sayHello();


       Animal dog = new Animal(){
           @Override
           void sound() {
               System.out.println("Köpekler Havlar");
           }
       };
       dog.sound();

       Animal animal = new Animal();
       animal.sound();

       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               System.out.println("Anonim Bir sınıfta Çalışır");
           }
       };
       new Thread(runnable).start();
    }
}
