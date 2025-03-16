package Week_2.StudentInformation;

import java.time.LocalDate;

public class Student {

    private  String Name;
    private  String Surname;
    private LocalDate BirthDate;
    private  Integer StudentNo;
    private  Course[]  Courses = new Course[5];

    public Student(String name, String surname, LocalDate birthDate, Integer studentNo) {
        Name = name;
        Surname = surname;
        BirthDate = birthDate;
        StudentNo = studentNo;
    }

    public  void AddCourse(Course course,int index)
    {
        if(index>=0 && index<Courses.length)
        {
            Courses[index]=course;
            System.out.println(course.getName()+" Başarılı Bir Şekilde eklendi");
        }
        else {
            System.out.println("Maksimum ders Sayısını Aştınız !( 5 Ders Ekleye bilirsiniz)");
        }
    }

    public  void   AddNotes(Course course,int Note)
    {
        for (Course c1 : getCourses())
        {
            if(c1.getName().equals(course.getName()))
            {
                c1.setNote(Note);
                System.out.println(c1.getName()+" Dersi için "+Note+ " Notunu Giridiniz !");
            }
            else
            {
                System.out.println("Bu Ögrenci bu Dersi almadıgı için Not girişi yapamazsınız !");
            }
        }
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

    public LocalDate getBirthDate() {
        return BirthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public Integer getStudentNo() {
        return StudentNo;
    }
    public void setStudentNo(Integer studentNo) {
        StudentNo = studentNo;
    }

    public Course[] getCourses() {
        return Courses;
    }
    private void setCourses(Course[] courses) {
        Courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }
}
