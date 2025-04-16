package Week_5.Examples.Records;

public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student(1034,"Burak","Çakır");
        Student student2 = new Student(1034,"Burak","Çakır");
        Student student3 = new Student(1065,"Kaan","Yılmaz");
        System.out.println(student);
        System.out.println(student.hashCode());
        System.out.println(student.equals(student2));
    }

}
