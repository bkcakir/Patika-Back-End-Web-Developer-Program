// Record tanımı
record Person(String name, int age, String email) {
    // Record içinde ek metod tanımlayabiliriz
    public String getInfo() {
        return name + " (" + age + ") - " + email;
    }
}

public class RecordsExample {
    public static void main(String[] args) {
        // Record örneği oluşturma
        Person person = new Person("Ahmet Yılmaz", 25, "ahmet@example.com");
        
        // Record özelliklerine erişim
        System.out.println("İsim: " + person.name());
        System.out.println("Yaş: " + person.age());
        System.out.println("Email: " + person.email());
        
        // Record metodunu kullanma
        System.out.println("Kişi Bilgisi: " + person.getInfo());
        
        // Record'lar immutable'dır
        // person.name = "Yeni İsim"; // Hata verir
        
        // Yeni bir record oluşturma
        Person updatedPerson = new Person("Mehmet Demir", 30, "mehmet@example.com");
        System.out.println("Güncellenmiş Bilgi: " + updatedPerson.getInfo());
    }
} 