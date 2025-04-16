package Projects.BookShoppingSystem;

import java.util.Scanner;

public class Main {

    public static void main() {

        int action;
        Scanner scanner = new Scanner(System.in);

        // Ana Menü
        while (true) {
            System.out.println("=====================================================");
            System.out.println("          📚 KitapEvim Sistemine Hoşgeldiniz          ");
            System.out.println("=====================================================");
            System.out.println(" 1️⃣ - Örnek Veri Tablolarını Sisteme Ekle");
            System.out.println(" 2️⃣ - Sistemi Görüntüle");
            System.out.println(" 3️⃣ - Alışveriş Sistemi");
            System.out.println(" 4️⃣ - Sepeti Görüntüle");
            System.out.println(" 5️⃣ - Ödemeyi Yap");
            System.out.println(" 6️⃣ - Çıkış Yap");
            System.out.println("=====================================================");
            System.out.print("Seçiminizi yapınız: ");
            action = scanner.nextInt();

            switch (action) {
                case 1:
                    addSampleData();
                    break;

                case 2:
                    systemOverview();
                    break;

                case 3:
                    productAction();  // Düzeltilmiş metod adı
                    break;

                case 4:
                    Basket.printBasketItems();  // Sepeti görüntüle
                    break;

                case 5:
                    Card.processPayment();  // Ödeme işlemi eklendi
                    break;

                case 6:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Geçersiz seçenek, lütfen tekrar deneyin.");
                    break;
            }
        }
    }

    // Örnek Veri Ekleme
    private static void addSampleData() {
        System.out.println("Örnek Veri Tablolarını Sisteme Ekle:");
        System.out.println("1️⃣ - Örnek Kullanıcı Ekle");
        System.out.println("2️⃣ - Örnek Kitap Ekle");
        System.out.println("3️⃣ - Örnek Kredi Kartı Ekle");
        System.out.print("Seçiminizi yapınız: ");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action) {
            case 1:
                User.defaultUsers();
                System.out.println("Örnek kullanıcılar sisteme eklendi.");
                break;
            case 2:
                Product.defaultProductData();
                System.out.println("Örnek kitaplar sisteme eklendi.");
                break;
            case 3:
                Card.DefaultData();
                System.out.println("Örnek kredi kartları sisteme eklendi.");
                break;
            default:
                System.out.println("Geçersiz seçenek.");
                break;
        }
    }

    // Sistemi Görüntüle
    private static void systemOverview() {
        System.out.println("Sistemi Görüntüle:");
        System.out.println("1️⃣ - Kullanıcılar");
        System.out.println("2️⃣ - Kitaplar");
        System.out.println("3️⃣ - Kredi Kartları");
        System.out.print("Seçiminizi yapınız: ");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action) {
            case 1:
                User.printUsers();
                break;
            case 2:
                Product.printProducts();
                break;
            case 3:
                Card.printCards();
                break;
            default:
                System.out.println("Geçersiz seçenek.");
                break;
        }
    }

    private static void productAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alışveriş Sistemi:");
        System.out.println("1️⃣ - Kitap Listesini Görüntüle");
        System.out.println("2️⃣ - Kitap Satın al");
        System.out.println("3️⃣ - Sepeti Görüntüle");
        System.out.println("4️⃣ - Ödemeyi Yap");
        System.out.println("5️⃣ - Geri Dön");
        System.out.print("Seçiminizi yapınız: ");
        int action = scanner.nextInt();
        
        switch (action) {
            case 1:
                Product.printProducts();
                break;
            case 2:
                Product.buyProduct();
                break;
            case 3:
                Basket.printBasketItems();
                break;
            case 4:
                Card.processPayment();
                break;
            case 5:
                main();
                break;
            default:
                System.out.println("Geçersiz seçenek.");
                break;
        }
    }
}
