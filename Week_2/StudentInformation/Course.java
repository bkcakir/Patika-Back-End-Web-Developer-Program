package Week_2.StudentInformation;

public class Course {
    private  String Name;
    private  String Code;
    private  Integer HourseOfWeek;
    private  Teacher teacher;
    private  Integer Note;

    public Course(String name, String code, Integer hourseOfWeek) {
        Name = name;
        Code = code;
        HourseOfWeek = hourseOfWeek;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Integer getHourseOfWeek() {
        return HourseOfWeek;
    }

    public void setHourseOfWeek(Integer hourseOfWeek) {
        HourseOfWeek = hourseOfWeek;
    }

    public Integer getNote() {
        return Note;
    }

    public void setNote(Integer note) {
        Note = note;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Name='" + Name + '\'' +
                ", Code='" + Code + '\'' +
                ", HourseOfWeek=" + HourseOfWeek +
                '}';
    }
}
