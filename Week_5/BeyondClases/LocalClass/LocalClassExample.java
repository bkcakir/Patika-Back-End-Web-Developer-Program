package Week_5.BeyondClases.LocalClass;

public class LocalClassExample {

    public  void  display()
    {
        class Local{
            void message()
            {
                System.out.println("Local Class!");
            }
        }
        Local local = new Local();
        local.message();
    }

}
