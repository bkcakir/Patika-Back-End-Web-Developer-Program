package Week_5.BeyondClases.Enums;

public enum Direction {
    NORTH(0,"NORTH"),EAST(90,"EAST"),SOUTH(180,"SOUTH"),WEST(270,"WEST");

    private final  int angle;
    private final  String dicretion;
    Direction(int angle,String dicretion)
    {
        this.angle= angle;
        this.dicretion=dicretion;
    }

    public int getAngle() {
        return angle;
    }

    public String getDicretion() {
        return dicretion;
    }
}
