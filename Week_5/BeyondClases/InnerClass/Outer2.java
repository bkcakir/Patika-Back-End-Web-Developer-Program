package Week_5.BeyondClases.InnerClass;

public class Outer2 {
    private  static  String message ="message";
  private final   class Inner{

        private  static  String message ="message";
        void  innerdisplay()
        {
            System.out.println("Inner Class");
        }
    }
    public  void  Outer2Display()
    {
        Outer2 outer2 = new Outer2();
        Outer2.Inner inner = outer2.new Inner();
        System.out.println("Outer 2 Class");
    }
}
