package Week_2.StudentInformation.Week_2.StudentInformation;

public class Teacher {
    private  String Name;
    private  String Surname;
    private  String Phone;
    private Week_2.StudentInformation.Week_2.StudentInformation.Course Course;

    public Teacher(String name, String surname, String phone) {
        Name = name;
        Surname = surname;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }

    public Week_2.StudentInformation.Week_2.StudentInformation.Course getCourse() {
        return Course;
    }
    public void setCourse(Week_2.StudentInformation.Week_2.StudentInformation.Course course) {
        Course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Course=" + Course +
                '}';
    }
}
