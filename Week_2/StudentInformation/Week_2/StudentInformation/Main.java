package Week_2.StudentInformation.Week_2.StudentInformation;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Teacher[] teachers = new Teacher[5];


        Teacher MathTeacher  = new Teacher("Ahmet", "Yılmaz", "0555 123 45 67");
        Teacher PhysicsTeacher = new Teacher("Mehmet", "Kaya", "0543 987 65 43");
        Teacher ChemistryTeacher = new Teacher("Zeynep", "Demir", "0532 456 78 90");
        Teacher Historyteacher = new Teacher("Elif", "Çelik", "0500 112 33 44");
        Teacher EnglishTeacher = new Teacher("Burak", "Arslan", "0512 334 55 66");

        teachers[0]=MathTeacher;
        teachers[1]=PhysicsTeacher;
        teachers[2]=ChemistryTeacher;
        teachers[3]=Historyteacher;
        teachers[4]=EnglishTeacher;

        Course Math = new Course("Matematik", "MATH101", 8);
        Course Physics = new Course("Fizik", "FZK101", 6);
        Course Chemistry = new Course("Kimya", "KMY101", 4);
        Course History = new Course("Tarih", "TRH101", 3);
        Course English = new Course("İngilizce", "ENG101", 5);

        Course[] course = new Course[5];
        course[0]=Math;
        course[1]=Physics;
        course[2]=Chemistry;
        course[3]=History;
        course[4]=English;

        Student student1 = new Student("Burak", "Çakır", LocalDate.of(1997, 5, 12), 2025001);
        Student student2 = new Student("Ali", "Kaya", LocalDate.of(1999, 8, 22), 2025002);
        Student student3 = new Student("Ayşe", "Demir", LocalDate.of(1998, 11, 3), 2025003);
        Student student4 = new Student("Mehmet", "Yılmaz", LocalDate.of(2000, 4, 16), 2025004);
        Student student5 = new Student("Zeynep", "Çelik", LocalDate.of(1997, 2, 28), 2025005);

        Student[] students= new Student[5];

        students[0]=student1;
        students[1]=student2;
        students[2]=student3;
        students[3]=student4;
        students[4]=student5;

        MathTeacher.setCourse(Math);
        PhysicsTeacher.setCourse(Physics);
        ChemistryTeacher.setCourse(Chemistry);
        Historyteacher.setCourse(History);
        EnglishTeacher.setCourse(English);

        Math.setTeacher(MathTeacher);
        Physics.setTeacher(PhysicsTeacher);
        Chemistry.setTeacher(ChemistryTeacher);
        History.setTeacher(Historyteacher);
        English.setTeacher(EnglishTeacher);


        for(Teacher teacher:teachers)
        {
            System.out.println(teacher);
        }
        System.out.println();
        System.out.println("------------------");
        System.out.println();
        for(Course courses:course)
        {
            System.out.println(courses);
        }
        System.out.println();
        System.out.println("------------------");
        System.out.println();
        for(Student student:students)
        {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("------------------");
        System.out.println();

        student1.AddCourse(Math,0);
        student1.AddCourse(Physics,1);
        student1.AddCourse(Chemistry,2);
        student1.AddCourse(History,3);
        student1.AddCourse(English,4);

        student2.AddCourse(Math,0);
        student2.AddCourse(Physics,1);
        student2.AddCourse(Chemistry,2);
        student2.AddCourse(History,3);
        student2.AddCourse(English,4);

        System.out.println();
        System.out.println("------------------");
        System.out.println();

        student1.AddNotes(Math,85);
        student1.AddNotes(Physics,85);
        student1.AddNotes(Chemistry,45);
        student1.AddNotes(English,20);
        student1.AddNotes(History,100);

        student2.AddNotes(Math,85);
        student2.AddNotes(Physics,85);
        student2.AddNotes(Chemistry,45);
        student2.AddNotes(English,20);
        student2.AddNotes(History,100);

        System.out.println();
        System.out.println("------------------");
        System.out.println();
        for (Course c1 : student1.getCourses())
        {
            System.out.println(student1.getName().toUpperCase()+" Ögrencisi "+ c1.getName().toUpperCase()+" Dersi için "+ c1.getNote() +" Notu almıştır");
        }
    }
}
