package Week_5.BeyondClases.InnerClass;

public class Outer {

    static  class  Nested{
        public void NestedDisplay() {
            System.out.println("Static nested Class public ");
        }
        private void privateNestedDisplay() {
            System.out.println("Static  nested Class private method");
        }
    }
    public  void  outerDisplay()
    {
        Outer.Nested nested = new Outer.Nested();
        nested.NestedDisplay();
        nested.privateNestedDisplay();
    }
}
