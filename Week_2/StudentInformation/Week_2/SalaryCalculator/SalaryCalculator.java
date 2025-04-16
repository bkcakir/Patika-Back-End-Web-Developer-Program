package Week_2.StudentInformation.Week_2.SalaryCalculator;

import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için Scanner nesnesi oluşturuluyor
        Scanner scanner = new Scanner(System.in);

        // Employee sınıfından bir nesne oluşturuluyor
        Employee employee = new Employee();

        // Kullanıcıdan çalışanın adını alıyoruz
        System.out.print("Çalışanın İsmini Giriniz: ");
        employee.Name = scanner.nextLine();

        // Kullanıcıdan çalışanın maaşını alıyoruz
        System.out.print("Çalışanın Maaşını Giriniz: ");
        employee.Salary = scanner.nextDouble();

        // Kullanıcıdan haftalık çalışma saatini alıyoruz
        System.out.print("Çalışanın Haftalık Çalışma Saatini Giriniz: ");
        employee.WorkHours = scanner.nextDouble();

        // Kullanıcıdan çalışanın işe başlama yılını alıyoruz
        System.out.print("Çalışanın İşe Başlangıç Yılını Giriniz: ");
        employee.HireYear = scanner.nextInt();

        // Çalışanın maaş detaylarını ekrana yazdırıyoruz
        employee.PayrollPrinting(employee.Name, employee.Salary, employee.WorkHours, employee.HireYear);

        // Scanner nesnesini kapatıyoruz (Kaynak sızıntısını önlemek için)
        scanner.close();
    }
}
