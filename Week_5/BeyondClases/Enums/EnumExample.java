package Week_5.BeyondClases.Enums;

public class EnumExample {
    public static void main(String[] args) {

        for (Day day :Day.values())
            System.out.println(day);

        System.out.println("Direction");

        System.out.println(Direction.NORTH.name()+"-"+Direction.NORTH.ordinal()+" - "+ Direction.NORTH.getAngle()+" - "+Direction.NORTH.getDicretion());
        System.out.println(Direction.EAST.name()+"-"+Direction.EAST.ordinal()+" - "+ Direction.EAST.getAngle()+" - "+Direction.EAST.getDicretion());
        System.out.println(Direction.WEST.name()+"-"+Direction.WEST.ordinal()+" - "+ Direction.WEST.getAngle()+"-"+Direction.WEST.getDicretion());
        System.out.println(Direction.SOUTH.name()+"-"+Direction.SOUTH.ordinal()+" - "+ Direction.SOUTH.getAngle()+"-"+Direction.SOUTH.getDicretion());


        System.out.println("Operation");
        System.out.println("5+7 ="+Operation.ADD.apply(5,7));
        System.out.println("5-7 ="+Operation.SUBTRACT.apply(5,7));



    }
}
