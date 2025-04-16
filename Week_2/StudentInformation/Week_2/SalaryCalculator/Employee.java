package Week_2.StudentInformation.Week_2.SalaryCalculator;

public class Employee {
    // Çalışanın temel bilgileri
    String Name;  // Çalışanın adı ve soyadı
    double Salary; // Çalışanın maaşı
    double WorkHours; // Haftalık çalışma saati
    int HireYear;  // İşe başlangıç yılı

    /**
     * Maaşa uygulanan vergiyi hesaplar.
     * Eğer maaş 1000 TL'den azsa vergi uygulanmaz.
     * 1000 TL ve üzerindeki maaşlar için %3 vergi uygulanır.
     *
     * @param Salary Çalışanın mevcut maaşı
     * @return Vergi miktarı
     */
    public double Tax(double Salary) {
        if (Salary < 1000) {
            return 0; // Vergi yok
        } else {
            return (Salary * 3) / 100; // %3 vergi
        }
    }

    /**
     * Fazla mesai bonusunu hesaplar.
     * Haftalık çalışma süresi 40 saati aşarsa,
     * fazla çalışılan her saat için 30 TL bonus eklenir.
     *
     * @param WorkHours Haftalık çalışma saati
     * @return Bonus miktarı
     */
    public double Bonus(double WorkHours) {
        double Bonus = 0.0;
        if (WorkHours > 40) {
            Bonus = WorkHours - 40; // Fazla çalışılan saat hesaplanıyor
            Bonus = Math.floor(Bonus) * 30; // Her ekstra saat için 30 TL ekleniyor
            return Math.floor(Bonus);
        } else {
            return Math.floor(Bonus); // Fazla mesai yoksa bonus sıfır
        }
    }

    /**
     * Maaş artışını hesaplar.
     * Çalışanın kıdemine göre belirli bir yüzdeyle maaş artışı uygulanır:
     * - 10 yıldan az çalışanlar için %5 zam
     * - 10-19 yıl arası çalışanlar için %10 zam
     * - 20 yıl ve üzeri çalışanlar için %15 zam
     *
     * @param HireYear Çalışanın işe giriş yılı
     * @param Salary Çalışanın mevcut maaşı
     * @return Maaş artışı miktarı
     */
    public double RaiseSalary(int HireYear, double Salary) {
        final int Year = 2021; // Güncel yıl (sabit)
        int WorkYear = Year - HireYear; // Çalışma yılı hesaplanıyor

        if (WorkYear < 10) {
            return Salary * 5 / 100; // %5 zam
        } else if (WorkYear >= 10 && WorkYear < 20) {
            return Salary * 10 / 100; // %10 zam
        } else if (WorkYear >= 20) {
            return Salary * 15 / 100; // %15 zam
        }
        return 0; // Hiçbir koşul sağlanmazsa zam yapılmaz
    }

    /**
     * Çalışanın maaş detaylarını ekrana yazdırır.
     * Vergi, bonus ve maaş artışı hesaplanarak toplam maaş gösterilir.
     *
     * @param Name Çalışanın adı
     * @param Salary Çalışanın maaşı
     * @param WorkHours Haftalık çalışma saati
     * @param HireYear İşe başlangıç yılı
     */
    public void PayrollPrinting(String Name, double Salary, double WorkHours, int HireYear) {
        System.out.println("Adı: " + Name);
        System.out.println("Maaşı: " + Salary);
        System.out.println("Çalışma Saati: " + WorkHours);
        System.out.println("Başlangıç Yılı: " + HireYear);

        double tax = Tax(Salary);
        System.out.println("Vergi: " + tax);

        double bonus = Bonus(WorkHours);
        System.out.println("Bonus: " + bonus);

        double raiseSalary = RaiseSalary(HireYear, Salary);
        System.out.println("Maaş Artışı: " + raiseSalary);

        double salaryWithBonusAndTax = Salary + bonus - tax;
        System.out.println("Vergi ve Bonuslar ile birlikte maaş: " + salaryWithBonusAndTax);

        double totalSalary = Salary + bonus + raiseSalary - tax;
        System.out.println("Toplam Maaş: " + totalSalary);
    }
}
