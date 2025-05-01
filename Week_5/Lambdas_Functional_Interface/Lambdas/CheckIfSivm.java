package Week_5.Lambdas_Functional_Interface.Lambdas;

public class CheckIfSivm implements CheckTrait{

    @Override
    public boolean test(Animal animal) {
        return animal.canSwim();
    }
}
