package Projects.ChortBookShoppingSystem;

import Projects.ChortBookShoppingSystem.Modal.Author;
import Projects.ChortBookShoppingSystem.Modal.Product;
import Projects.ChortBookShoppingSystem.Modal.enums.Gender;
import Projects.ChortBookShoppingSystem.Service.AuthorService;
import Projects.ChortBookShoppingSystem.Service.ProductService;
import Projects.ChortBookShoppingSystem.Service.UserService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.SortedMap;

public class ChortBookShoppingSystem {
    static int Action,gender;
    static String name,email,password,authorName,surname;
    static double price;
    static Scanner scanner = new Scanner(System.in);
    static ProductService productService = new ProductService();
    static UserService userService = new UserService();
    static AuthorService authorService = new AuthorService();
    public static void main(String[] args) {

        userService.created("Cem","cem@patika.com","password");
        userService.created("Ayşe","Ayşe@patika.com","password");
        userService.created("Fatma","Fatma@patika.com","password");

        authorService.created("Patika","Plus",Gender.WOMAN);
        Author author = authorService.findAuthor("Patika");


        productService.create("java Pogramlama",155,author,LocalDate.of(2022,01,01));
        productService.create("java Pogramlama-2",155,author,LocalDate.of(2023,01,01));
        productService.create("java İleri Pogramlama",155,author,LocalDate.of(2024,01,01));

        productService.create("Aylık Patika Dev Teknologi Dergisi",99.9);

        loginpage();

    }
    private static void loginpage() {
        while (true) {
            // Kullanıcıdan işlem seçmesini iste
            System.out.println("=======================================");
            System.out.println("  Kitap Alışveriş Sistemi Ana Menü    ");
            System.out.println("=======================================");
            System.out.println("1 - Giriş Yap");
            System.out.println("2 - Kayıt Ol");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçiminizi yapın: ");
            Action = scanner.nextInt();
            scanner.nextLine(); // nextInt() sonrasında nextLine() kullanmak önemli

            switch (Action) {
                case 1:
                    while (true) {
                        System.out.println("=======================================");
                        System.out.println("        🔐 Giriş Yap Ekranı");
                        System.out.println("=======================================");
                        System.out.print("📧 Email Adresinizi Giriniz: ");
                        email = scanner.nextLine();

                        System.out.println(); // Boşluk

                        System.out.print("🔑 Şifrenizi Giriniz: ");
                        password = scanner.nextLine();

                        System.out.println("=======================================");

                        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                            System.out.println("⚠️  Lütfen tüm bilgileri eksiksiz giriniz.\n");
                        } else {
                            if (userService.islogin(email, password)) {
                                System.out.println("✅ Giriş başarılı. Hoş geldiniz, " + email + "!");
                                homepage(); // Ana sayfa yönlendirmesi
                            } else {
                                System.out.println("❌ Giriş başarısız. Email veya şifre hatalı.");
                            }
                            break;
                        }
                    }
                case 2:
                    while (true) {
                        System.out.println("=======================================");
                        System.out.println("         📝 Kayıt Olma Ekranı");
                        System.out.println("=======================================");
                        System.out.println("Kayıt işleminden çıkmak için herhangi bir alana '0' yazabilirsiniz.\n");

                        System.out.print("👤 İsminizi Giriniz: ");
                        name = scanner.nextLine();
                        if (name.equals("0")) break;

                        System.out.print("📧 Email Adresinizi Giriniz: ");
                        email = scanner.nextLine();
                        if (email.equals("0")) break;

                        System.out.print("🔑 Şifrenizi Giriniz: ");
                        password = scanner.nextLine();
                        if (password.equals("0")) break;

                        System.out.println("=======================================");

                        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                            System.out.println("⚠️  Lütfen tüm bilgileri eksiksiz giriniz.\n");
                        } else {
                            boolean isCreated = userService.created(name, email, password);

                            if (isCreated) {
                                System.out.println("✅ Kayıt başarılı. Hoş geldiniz, " + name + "!\n");
                                loginpage();
                                break; // Kayıt başarılıysa döngüden çık
                            } else {
                                System.out.println("❌ Bu email adresi ile daha önce kayıt olunmuş. Lütfen farklı bir adres deneyin.\n");
                            }
                        }
                    }
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);  // Programı sonlandırır
                    break;
                default:
                    System.out.println("Geçersiz bir seçenek girdiniz, lütfen tekrar deneyin.");
                    break;
            }
        }
    }

    public static void homepage()
    {
        while (true) {
            System.out.println("=======================================");
            System.out.println("  Kitap Alışveriş Sistemi Ana Menü    ");
            System.out.println("=======================================");
            System.out.println("1 - Yeni Kitap Ekle");
            System.out.println("2 - Yazar Ekle");
            System.out.println("3 - Ürün Listesi Göster");
            System.out.println("4 - Yazarları Listesi Göster");
            System.out.println("5 - Çıkış Yap");
            System.out.print("Seçiminizi yapın: ");
            Action = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (Action)
            {
                case 1:
                    while (true) {
                        System.out.println("=======================================");
                        System.out.println("         Ürün Ekleme Ekranı");
                        System.out.println("=======================================");
                        System.out.println("Çıkmak için herhangi bir alana 'Exit' yazabilirsiniz.\n");

                        System.out.print("Ürün İsmini Giriniz: ");
                        name = scanner.nextLine();
                        if (name.equals("Exit"))
                        {
                            break;
                        };

                        System.out.print("Ürün Fiyatını Giriniz: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("⚠️  Lütfen geçerli bir fiyat giriniz (örn: 15.99)");
                            scanner.nextLine();
                            continue;
                        }

                        price = scanner.nextDouble();
                        scanner.nextLine(); // Enter karakterini temizle
                        if (price == 0) break;

                        System.out.print("Yazar İsmini Giriniz: ");
                        authorName = scanner.nextLine();
                        if (authorName.equals("Exit"))
                        {
                            break;
                        }

                        System.out.println("=======================================");

                        if (name.isEmpty() || authorName.isEmpty() || price <= 0) {
                            System.out.println("⚠️  Lütfen tüm bilgileri eksiksiz ve geçerli şekilde giriniz.");
                        } else {
                            Author author = authorService.findAuthor(authorName);

                            if (author == null) {
                                System.out.println("⚠️  Belirtilen yazar bulunamadı. Lütfen geçerli bir yazar ismi giriniz.");
                            } else {
                                productService.create(name, price, author, LocalDate.now());
                                System.out.println("✅ Ürün başarıyla eklendi: " + name + " - " + price + "₺ (Yazar: " + author.getName() + ")");
                            }
                        }

                        System.out.println(); // Satır boşluğu
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("=======================================");
                        System.out.println("         Yazar Ekleme Ekranı");
                        System.out.println("=======================================");
                        System.out.println("Çıkmak için '0' yazıp Enter'a basabilirsiniz.");

                        System.out.print("Yazarın İsmini Giriniz: ");
                        name = scanner.nextLine();
                        if (name.equals("0")) break;

                        System.out.print("Yazarın Soyadını Giriniz: ");
                        surname = scanner.nextLine();
                        if (surname.equals("0")) break;

                        System.out.println("==========");
                        System.out.println("   Cinsiyet");
                        System.out.println("==========");
                        System.out.println("1 - Erkek");
                        System.out.println("2 - Kadın");
                        System.out.print("Seçiminizi yapın: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("⚠️  Geçerli bir sayı giriniz.");
                            scanner.nextLine(); // Temizle
                            continue;
                        }

                        gender = scanner.nextInt();
                        scanner.nextLine(); // Enter karakterini temizlemek için

                        System.out.println("=======================================");

                        if (name.isEmpty() || surname.isEmpty()) {
                            System.out.println("⚠️  Lütfen tüm bilgileri eksiksiz ve geçerli şekilde giriniz.");
                        } else {
                            switch (gender) {
                                case 1:
                                    authorService.created(name, surname, Gender.MAN);
                                    System.out.println("✅ Yazar başarıyla eklendi: " + name + " " + surname + " (Erkek)");
                                    break;
                                case 2:
                                    authorService.created(name, surname, Gender.WOMAN);
                                    System.out.println("✅ Yazar başarıyla eklendi: " + name + " " + surname + " (Kadın)");
                                    break;
                                default:
                                    System.out.println("⚠️  Geçersiz cinsiyet seçimi yaptınız. Lütfen 1 ya da 2 girin.");
                                    break;
                            }
                        }

                        System.out.println(); // Bir satır boşluk bırak
                    }
                    break;
                case 3:
                    productService.list();
                    homepage();
                    break;
                case 4:
                    authorService.list();
                    homepage();
                case 5:
                    loginpage();
                    return;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                    break;
            }
        }
    }


}
