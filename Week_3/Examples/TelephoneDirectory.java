package Week_3.Examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> Directory  = new HashMap<>();
        String Name;
        String PhoneNumber;
        int Action;
        while (true) {
            System.out.println();
            System.out.println("----------İşlemler--------- \n"
                    + "1-Kişi Ekle \n"
                    + "2-Kişi Sil\n"
                    + "3-Kişi Güncelle \n"
                    + "4-Rehberi Listele\n"
                    + "5-Kişi Ara \n"
                    + "6-Çıkış");

            System.out.print("Bir İşlem Şeçiniz :");
            Action = scanner.nextInt();
            scanner.nextLine();
            switch (Action) {
                case 1:
                    System.out.println();
                    System.out.print("İsim Giriniz: ");
                    Name = scanner.nextLine().trim();
                    System.out.print("Telefon Numarası Giriniz: ");
                    PhoneNumber = scanner.nextLine();

                    Directory.put(Name,PhoneNumber);

                    System.out.println(Name + " kişisinin " + PhoneNumber + " numaralı telefonu başarıyla eklendi.");
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Silmek istediğiniz ismi giriniz: ");
                    Name = scanner.nextLine();

                    if (Directory.containsKey(Name)) {
                        Directory.remove(Name);
                        System.out.println(Name + " kişisi rehberden başarıyla silindi.");
                    } else {
                        System.out.println(Name + " isimli kişi rehberde bulunamadı.");
                    }

                    break;
                case 3:
                    System.out.println();
                    System.out.print("Güncellemek istediğiniz ismi giriniz: ");
                    Name = scanner.nextLine();

                    if (Directory.containsKey(Name)) {
                        System.out.print(Name + " kişisinin yeni numarasını giriniz: ");
                        PhoneNumber = scanner.nextLine();

                        Directory.replace(Name, PhoneNumber);
                        System.out.println(Name + " kişisinin telefon numarası başarıyla güncellendi.");
                    } else {
                        System.out.println(Name + " isimli kişi rehberde bulunamadı.");
                    }
                    break;
                case 4:
                    System.out.println();
                    int Count=0;
                    if (Directory.isEmpty()) {
                        System.out.println("Rehberde kayıtlı kişi bulunmamaktadır.");
                    } else {
                        System.out.println("📒 Rehberdeki Kişiler:");
                        for (Map.Entry<String, String> entry : Directory.entrySet()) {
                            System.out.println("👤 " + entry.getKey() + " ➤ 📞 " + entry.getValue());
                            Count++;
                        }
                    }
                    System.out.print("Rehberdeki 👤 Kişi Sayısı : "+Count);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Aramak istediğiniz ismi giriniz: ");
                    Name = scanner.nextLine();

                    if (Directory.containsKey(Name)) {
                        System.out.println(Name + " kişisinin telefon numarası: " + Directory.get(Name));
                    } else {
                        System.out.println(Name + " isimli kişi rehberde bulunamadı.");
                    }
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Programdan çıkılıyor... Teşekkürler!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("1-6 Arasında Bir Giriniz");
            }
        }
    }
}
