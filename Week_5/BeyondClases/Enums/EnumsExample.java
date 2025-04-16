// Enum tanımı
enum Day {
    MONDAY("Pazartesi", 1),
    TUESDAY("Salı", 2),
    WEDNESDAY("Çarşamba", 3),
    THURSDAY("Perşembe", 4),
    FRIDAY("Cuma", 5),
    SATURDAY("Cumartesi", 6),
    SUNDAY("Pazar", 7);
    
    private final String turkishName;
    private final int dayNumber;
    
    Day(String turkishName, int dayNumber) {
        this.turkishName = turkishName;
        this.dayNumber = dayNumber;
    }
    
    public String getTurkishName() {
        return turkishName;
    }
    
    public int getDayNumber() {
        return dayNumber;
    }
    
    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

public class EnumsExample {
    public static void main(String[] args) {
        // Enum değerlerini kullanma
        Day today = Day.MONDAY;
        
        System.out.println("Bugün: " + today);
        System.out.println("Türkçe adı: " + today.getTurkishName());
        System.out.println("Gün numarası: " + today.getDayNumber());
        System.out.println("Hafta sonu mu: " + today.isWeekend());
        
        // Tüm enum değerlerini listeleme
        System.out.println("\nTüm günler:");
        for (Day day : Day.values()) {
            System.out.println(day + " - " + day.getTurkishName());
        }
        
        // Switch-case ile enum kullanımı
        switch (today) {
            case MONDAY:
                System.out.println("\nHaftanın ilk günü!");
                break;
            case FRIDAY:
                System.out.println("\nHafta sonuna yaklaşıyoruz!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("\nHafta sonu!");
                break;
            default:
                System.out.println("\nHafta içi günlerden biri!");
        }
    }
} 