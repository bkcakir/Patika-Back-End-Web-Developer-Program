package Week_5.Examples.Enums;

public enum WorkTime {
    SUNDAY("09:00 - 17:00"),
    MONDAY("09:00 - 17:00"),
    TUESDAY("09:00 - 17:00"),
    WEDNESDAY("09:00 - 17:00"),
    THURSDAY("09:00 - 17:00"),
    FRIDAY("09:00 - 17:00"),
    SATURDAY("09:00 - 17:00");

    private final  String workTime;
    WorkTime(String time)
    {
        this.workTime=time;
    }

    public String getWorkTime() {
        return workTime;
    }
}
