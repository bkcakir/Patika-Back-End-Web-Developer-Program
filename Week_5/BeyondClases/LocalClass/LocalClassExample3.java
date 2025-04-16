package Week_5.BeyondClases.LocalClass;

public class LocalClassExample3 {
    public  void  display()
    {
        final String greeting="Hi,Patika";

        class  Local{

            void  message()
            {
                System.out.println(greeting);
            }
        }
        Local local = new Local();
        local.message();
    }
}
