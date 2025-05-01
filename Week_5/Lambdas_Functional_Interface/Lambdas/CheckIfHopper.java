package Week_5.Lambdas_Functional_Interface.Lambdas;

public class CheckIfHopper implements CheckTrait{
    @Override
    public boolean test(Animal animal) {
        return animal.canHop();
    }
}
