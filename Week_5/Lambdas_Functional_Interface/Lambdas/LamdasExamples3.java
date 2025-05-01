package Week_5.Lambdas_Functional_Interface.Lambdas;

public class LamdasExamples3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Çalışıyor");
            }
        };
        new  Thread(runnable).start();

        Runnable runnable1 = () ->     System.out.println("Runnable Çalışıyor");

        new  Thread(runnable1).start();
    }
}
