package Week_5.BeyondClases.InnerClass;

public class NestedClassMain {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerDisplay();

        Outer.Nested nested =new Outer.Nested();
        nested.NestedDisplay();

        //Outer2.Inner inner = new Outer2.Inner();


    }
}
