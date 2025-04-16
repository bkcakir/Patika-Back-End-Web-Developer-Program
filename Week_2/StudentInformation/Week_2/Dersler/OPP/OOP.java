package Week_2.StudentInformation.Week_2.Dersler.OPP;

public class OOP {
    public static void main(String[] args) {

        Car car = new Car();

       car.SetBrand("BMV");
       car.SetModel("M5");
       car.SetMaxSpeed(305);
       car.SetMaxSpeed(600);

       car.move();
       car.IncrementGear(2);
       int gear = car.getGear();
        System.out.println(gear);

    }
}

