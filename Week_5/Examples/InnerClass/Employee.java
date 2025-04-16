package Week_5.Examples.InnerClass;

public class Employee {
    String employeeName;
    String employeeSurname;

    // İç sınıf (inner class)
    private class ContactInfo {
        String phoneNumber;
        String email;
    }

    public void printEmployee() {
        this.employeeName = "Ahmet";
        this.employeeSurname = "Yılmaz";

        ContactInfo contactInfo = new ContactInfo();
        contactInfo.email = "ahmetyilmaz@gmail.com";
        contactInfo.phoneNumber = "+90 555 555 55 55";

        System.out.println(employeeName + " " + employeeSurname +
                " Çalışanın İletişim Bilgileri:\n" +
                "E-Posta: " + contactInfo.email + "\n" +
                "Telefon: " + contactInfo.phoneNumber);
    }

    // main metodu test için
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.printEmployee();
    }
}
