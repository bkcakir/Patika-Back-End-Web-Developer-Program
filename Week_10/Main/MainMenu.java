/*
 * MainMenu.java
 *
 * Bu sınıf, Rent A Car uygulamasının ana menüsünü ve kullanıcı arayüzünü yönetir.
 * Kullanıcı girişi, kayıt, araç işlemleri, kiralama işlemleri ve admin işlemleri gibi
 * tüm kullanıcı etkileşimlerini bu sınıf üzerinden gerçekleştirir.
 *
 * Özellikler:
 * - Kullanıcı girişi ve kayıt işlemleri
 * - Araç listeleme, arama ve kategori bazlı filtreleme
 * - Kiralama işlemleri (kirala, iptal et, tamamla)
 * - Admin işlemleri (araç ekleme, güncelleme, silme ve kullanıcı listeleme)
 *
 * Kullanılan Servisler:
 * - UserService: Kullanıcı işlemleri için
 * - VehicleService: Araç işlemleri için
 * - RentalService: Kiralama işlemleri için
 *
 * Tarih: 2023-10-01
 * Yazar: Rent A Car Ekibi
 */

package Week_10.Main;

import Week_10.Models.*;
import Week_10.Service.UserService;
import Week_10.Service.VehicleService;
import Week_10.Service.RentalService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private final UserService userService;
    private final VehicleService vehicleService;
    private final RentalService rentalService;
    private User currentUser;
    private final DateTimeFormatter dateFormatter;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.userService = new UserService();
        this.vehicleService = new VehicleService();
        this.rentalService = new RentalService();
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    public void start() {
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("\n=== Giriş Menüsü ===");
        System.out.println("1. Giriş Yap");
        System.out.println("2. Kayıt Ol");
        System.out.println("3. Verileri Yükle");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                loadXData();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Ana Menü ===");
        System.out.println("1. Araç İşlemleri");
        System.out.println("2. Kiralama İşlemleri");
        System.out.println("3. Kiralama Geçmişi");
        if (userService.isAdmin(currentUser.getId())) {
            System.out.println("4. Admin İşlemleri");
        }
        System.out.println("0. Çıkış Yap");
        System.out.print("Seçiminiz: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        switch (choice) {
            case 1:
                showVehicleMenu();
                break;
            case 2:
                showRentalMenu();
                break;
            case 3:
                showRentalHistory();
                break;
            case 4:
                if (userService.isAdmin(currentUser.getId())) {
                    showAdminMenu();
                }
                break;
            case 0:
                logout();
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }

    private void showVehicleMenu() {
        System.out.println("\n=== Araç İşlemleri ===");
        System.out.println("1. Tüm Araçları Listele");
        System.out.println("2. Araç Ara");
        System.out.println("3. Araç Tipi Bazlı Araç Listele");
        System.out.println("0. Ana Menüye Dön");
        System.out.print("Seçiminiz: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        switch (choice) {
            case 1:
                listAllVehicles();
                break;
            case 2:
                searchVehicle();
                break;
            case 3:
                listVehiclesByType();
                break;
            case 0:
                return;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }

    private void showRentalMenu() {
        System.out.println("\n=== Kiralama İşlemleri ===");
        System.out.println("1. Araç Kirala");
        System.out.println("2. Kiralama İptal Et");
        System.out.println("3. Kiralama Tamamla");
        System.out.println("0. Ana Menüye Dön");
        System.out.print("Seçiminiz: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        switch (choice) {
            case 1:
                rentVehicle();
                break;
            case 2:
                cancelRental();
                break;
            case 3:
                completeRental();
                break;
            case 0:
                return;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menüsü ===");
            System.out.println("1. Kullanıcı İşlemleri");
            System.out.println("2. Araç İşlemleri");
            System.out.println("3. Kiralama İşlemleri");
            System.out.println("4. Varsayılan Verileri Yükle");
            System.out.println("5. X-Verileri Yükle");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme
            
            switch (choice) {
                case 1:
                    showUserManagementMenu();
                    break;
                case 2:
                    showVehicleManagementMenu();
                    break;
                case 3:
                    showRentalManagementMenu();
                    break;
                case 4:
                    loadDefaultData();
                    break;
                case 5:
                    loadXData();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void login() {
        System.out.print("E-posta: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        if (userService.authenticate(email, password)) {
            Optional<User> userOpt = userService.findByEmail(email);
            if (userOpt.isPresent()) {
                currentUser = userOpt.get();
                System.out.println("Giriş başarılı!");
            }
        } else {
            System.out.println("Geçersiz e-posta veya şifre!");
        }
    }

    private void register() {
        System.out.print("E-posta: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();
        System.out.println("Kullanıcı Tipi:");
        System.out.println("1. Normal Kullanıcı");
        System.out.println("2. Kurumsal Kullanıcı");
        System.out.print("Seçiminiz: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        UserType userType = typeChoice == 2 ? UserType.CORPORATE : UserType.NORMAL;

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserType(userType);

        userService.save(user);
        System.out.println("Kayıt başarılı! Giriş yapabilirsiniz.");
    }

    private void logout() {
        currentUser = null;
        System.out.println("Çıkış yapıldı.");
    }

    private void listAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAll();
        if (vehicles.isEmpty()) {
            System.out.println("Araç bulunamadı!");
            return;
        }

        System.out.println("\nAraç Listesi:");
        for (Vehicle vehicle : vehicles) {
            System.out.printf("ID: %d, Marka: %s, Model: %s, Tip: %s, Fiyat: %s TL, Müsait: %s%n",
                    vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getPrice(),
                    vehicle.isAvailable() ? "Evet" : "Hayır");
        }
    }

    private void searchVehicle() {
        System.out.print("Arama terimi (marka/model): ");
        String searchTerm = scanner.nextLine().toLowerCase();

        List<Vehicle> vehicles = vehicleService.findAll();
        vehicles.stream()
                .filter(v -> v.getBrand().toLowerCase().contains(searchTerm) ||
                        v.getModel().toLowerCase().contains(searchTerm))
                .forEach(v -> System.out.printf("ID: %d, Marka: %s, Model: %s, Tip: %s, Fiyat: %s TL%n",
                        v.getId(), v.getBrand(), v.getModel(), v.getVehicleType(), v.getPrice()));
    }

    private void listVehiclesByType() {
        System.out.println("\nAraç Tipi Seçin:");
        System.out.println("1. Araba");
        System.out.println("2. Motosiklet");
        System.out.println("3. Helikopter");
        System.out.print("Seçiminiz: ");
        
        int choice = scanner.nextInt();
        VehicleType vehicleType;
        
        switch (choice) {
            case 1:
                vehicleType = VehicleType.CAR;
                break;
            case 2:
                vehicleType = VehicleType.MOTORCYCLE;
                break;
            case 3:
                vehicleType = VehicleType.HELICOPTER;
                break;
            default:
                System.out.println("Geçersiz seçim!");
                return;
        }
        
        List<Vehicle> vehicles = vehicleService.findByType(vehicleType);
        if (vehicles.isEmpty()) {
            System.out.println("Bu tipte araç bulunamadı!");
        } else {
            System.out.println("\nAraç Listesi:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private void rentVehicle() {
        listAllVehicles();
        System.out.print("Kiralamak istediğiniz aracın ID'sini girin: ");
        Long vehicleId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        if (!rentalService.canUserRentVehicle(currentUser.getId(), vehicleId)) {
            System.out.println("Bu aracı kiralayamazsınız!");
            return;
        }

        System.out.println("Kiralama Tipi:");
        System.out.println("1. Saatlik");
        System.out.println("2. Günlük");
        System.out.println("3. Haftalık");
        System.out.println("4. Aylık");
        System.out.print("Seçiminiz: ");

        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        RentalType rentalType = switch (typeChoice) {
            case 1 -> RentalType.HOURLY;
            case 2 -> RentalType.DAILY;
            case 3 -> RentalType.WEEKLY;
            case 4 -> RentalType.MONTHLY;
            default -> null;
        };

        if (rentalType == null) {
            System.out.println("Geçersiz kiralama tipi!");
            return;
        }

        // Kurumsal kullanıcılar için aylık kiralama zorunluluğu
        if (userService.isCorporate(currentUser.getId()) && rentalType != RentalType.MONTHLY) {
            System.out.println("Kurumsal kullanıcılar sadece aylık kiralama yapabilir!");
            return;
        }

        System.out.print("Başlangıç tarihi (GG/AA/YYYY SS:DD): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Bitiş tarihi (GG/AA/YYYY SS:DD): ");
        String endDateStr = scanner.nextLine();

        try {
            LocalDateTime startDate = LocalDateTime.parse(startDateStr, dateFormatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateStr, dateFormatter);

            BigDecimal totalPrice = rentalService.calculateRentalPrice(vehicleId, rentalType, startDate, endDate);
            BigDecimal deposit = vehicleService.calculateDeposit(vehicleId);

            System.out.printf("Toplam Fiyat: %s TL%n", totalPrice);
            System.out.printf("Depozito: %s TL%n", deposit);
            System.out.print("Onaylıyor musunuz? (E/H): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("E")) {
                Rental rental = new Rental();
                rental.setUserId(currentUser.getId());
                rental.setVehicleId(vehicleId);
                rental.setStartDate(startDate);
                rental.setEndDate(endDate);
                rental.setRentalType(rentalType);
                rental.setTotalPrice(totalPrice);
                rental.setDeposit(deposit);
                rental.setStatus(RentalStatus.ACTIVE);

                rentalService.save(rental);
                System.out.println("Kiralama işlemi başarıyla tamamlandı!");
            }
        } catch (Exception e) {
            System.out.println("Geçersiz tarih formatı!");
        }
    }

    private void cancelRental() {
        List<Rental> userRentals = rentalService.findByUserId(currentUser.getId());
        userRentals.stream()
                .filter(r -> r.getStatus() == RentalStatus.ACTIVE)
                .forEach(r -> System.out.printf("ID: %d, Araç ID: %d, Başlangıç: %s, Bitiş: %s%n",
                        r.getId(), r.getVehicleId(), r.getStartDate().format(dateFormatter),
                        r.getEndDate().format(dateFormatter)));

        System.out.print("İptal etmek istediğiniz kiralama ID'sini girin: ");
        Long rentalId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        Rental rental = rentalService.cancelRental(rentalId);
        if (rental != null) {
            System.out.println("Kiralama işlemi iptal edildi!");
        } else {
            System.out.println("Kiralama işlemi bulunamadı!");
        }
    }

    private void completeRental() {
        List<Rental> userRentals = rentalService.findByUserId(currentUser.getId());
        userRentals.stream()
                .filter(r -> r.getStatus() == RentalStatus.ACTIVE)
                .forEach(r -> System.out.printf("ID: %d, Araç ID: %d, Başlangıç: %s, Bitiş: %s%n",
                        r.getId(), r.getVehicleId(), r.getStartDate().format(dateFormatter),
                        r.getEndDate().format(dateFormatter)));

        System.out.print("Tamamlamak istediğiniz kiralama ID'sini girin: ");
        Long rentalId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        Rental rental = rentalService.completeRental(rentalId);
        if (rental != null) {
            System.out.println("Kiralama işlemi tamamlandı!");
        } else {
            System.out.println("Kiralama işlemi bulunamadı!");
        }
    }

    private void showRentalHistory() {
        List<Rental> userRentals = rentalService.findByUserId(currentUser.getId());
        if (userRentals.isEmpty()) {
            System.out.println("Kiralama geçmişi bulunamadı!");
            return;
        }

        System.out.println("\nKiralama Geçmişi:");
        for (Rental rental : userRentals) {
            System.out.printf("ID: %d, Araç ID: %d, Başlangıç: %s, Bitiş: %s, Durum: %s%n",
                    rental.getId(), rental.getVehicleId(),
                    rental.getStartDate().format(dateFormatter),
                    rental.getEndDate().format(dateFormatter),
                    rental.getStatus().getDisplayName());
        }
    }

    private void addVehicle() {
        System.out.print("Marka: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.println("Araç Tipi:");
        System.out.println("1. Otomobil");
        System.out.println("2. Motosiklet");
        System.out.println("3. Helikopter");
        System.out.print("Seçiminiz: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        VehicleType vehicleType = switch (typeChoice) {
            case 1 -> VehicleType.CAR;
            case 2 -> VehicleType.MOTORCYCLE;
            case 3 -> VehicleType.HELICOPTER;
            default -> null;
        };

        if (vehicleType == null) {
            System.out.println("Geçersiz araç tipi!");
            return;
        }

        System.out.print("Fiyat: ");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.print("Günlük Ücret: ");
        BigDecimal dailyRate = scanner.nextBigDecimal();
        System.out.print("Haftalık Ücret: ");
        BigDecimal weeklyRate = scanner.nextBigDecimal();
        System.out.print("Aylık Ücret: ");
        BigDecimal monthlyRate = scanner.nextBigDecimal();
        scanner.nextLine(); // Buffer temizleme

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setVehicleType(vehicleType);
        vehicle.setPrice(price);
        vehicle.setDailyRate(dailyRate);
        vehicle.setWeeklyRate(weeklyRate);
        vehicle.setMonthlyRate(monthlyRate);
        vehicle.setAvailable(true);

        vehicleService.save(vehicle);
        System.out.println("Araç başarıyla eklendi!");
    }

    private void updateVehicle() {
        listAllVehicles();
        System.out.print("Güncellemek istediğiniz aracın ID'sini girin: ");
        Long vehicleId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        Optional<Vehicle> vehicleOpt = vehicleService.findById(vehicleId);
        if (vehicleOpt.isEmpty()) {
            System.out.println("Araç bulunamadı!");
            return;
        }

        Vehicle vehicle = vehicleOpt.get();
        System.out.print("Yeni Marka (mevcut: " + vehicle.getBrand() + "): ");
        String brand = scanner.nextLine();
        if (!brand.isEmpty()) {
            vehicle.setBrand(brand);
        }

        System.out.print("Yeni Model (mevcut: " + vehicle.getModel() + "): ");
        String model = scanner.nextLine();
        if (!model.isEmpty()) {
            vehicle.setModel(model);
        }

        System.out.print("Yeni Günlük Ücret (mevcut: " + vehicle.getDailyRate() + "): ");
        String dailyRateStr = scanner.nextLine();
        if (!dailyRateStr.isEmpty()) {
            vehicle.setDailyRate(new BigDecimal(dailyRateStr));
        }

        System.out.print("Yeni Haftalık Ücret (mevcut: " + vehicle.getWeeklyRate() + "): ");
        String weeklyRateStr = scanner.nextLine();
        if (!weeklyRateStr.isEmpty()) {
            vehicle.setWeeklyRate(new BigDecimal(weeklyRateStr));
        }

        System.out.print("Yeni Aylık Ücret (mevcut: " + vehicle.getMonthlyRate() + "): ");
        String monthlyRateStr = scanner.nextLine();
        if (!monthlyRateStr.isEmpty()) {
            vehicle.setMonthlyRate(new BigDecimal(monthlyRateStr));
        }

        vehicleService.update(vehicle);
        System.out.println("Araç başarıyla güncellendi!");
    }

    private void deleteVehicle() {
        listAllVehicles();
        System.out.print("Silmek istediğiniz aracın ID'sini girin: ");
        Long vehicleId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        vehicleService.delete(vehicleId);
        System.out.println("Araç başarıyla silindi!");
    }

    private void showUserManagementMenu() {
        while (true) {
            System.out.println("\n=== KULLANICI YÖNETİMİ ===");
            System.out.println("1. Tüm Kullanıcıları Listele");
            System.out.println("2. Kullanıcı Ara");
            System.out.println("3. Kullanıcı Sil");
            System.out.println("4. Kullanıcı Bilgilerini Güncelle");
            System.out.println("0. Ana Menüye Dön");

            System.out.print("\nSeçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    listAllUsers();
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    updateUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void listAllUsers() {
        System.out.println("\n=== TÜM KULLANICILAR ===");
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            System.out.println("Kayıtlı kullanıcı bulunamadı.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void searchUser() {
        System.out.println("\n=== KULLANICI ARA ===");
        System.out.print("E-posta adresi: ");
        String email = scanner.nextLine();
        
        Optional<User> userOpt = userService.findByEmail(email);
        if (userOpt.isPresent()) {
            System.out.println("\nKullanıcı bulundu:");
            System.out.println(userOpt.get());
        } else {
            System.out.println("Kullanıcı bulunamadı!");
        }
    }

    private void deleteUser() {
        System.out.println("\n=== KULLANICI SİL ===");
        System.out.print("Silinecek kullanıcının e-posta adresi: ");
        String email = scanner.nextLine();
        
        Optional<User> userOpt = userService.findByEmail(email);
        if (userOpt.isPresent()) {
            if (userService.delete(userOpt.get().getId())) {
                System.out.println("Kullanıcı başarıyla silindi.");
            } else {
                System.out.println("Kullanıcı silinirken bir hata oluştu!");
            }
        } else {
            System.out.println("Kullanıcı bulunamadı!");
        }
    }

    private void updateUser() {
        System.out.println("\n=== KULLANICI GÜNCELLE ===");
        System.out.print("Güncellenecek kullanıcının e-posta adresi: ");
        String email = scanner.nextLine();
        
        Optional<User> userOpt = userService.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("\nMevcut bilgiler:");
            System.out.println(user);
            
            System.out.print("\nYeni e-posta adresi (değiştirmek istemiyorsanız boş bırakın): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                user.setEmail(newEmail);
            }
            
            System.out.print("Yeni şifre (değiştirmek istemiyorsanız boş bırakın): ");
            String newPassword = scanner.nextLine();
            if (!newPassword.isEmpty()) {
                user.setPassword(newPassword);
            }
            
            try {
                userService.update(user);
                System.out.println("Kullanıcı bilgileri başarıyla güncellendi.");
            } catch (Exception e) {
                System.out.println("Kullanıcı güncellenirken bir hata oluştu: " + e.getMessage());
            }
        } else {
            System.out.println("Kullanıcı bulunamadı!");
        }
    }

    private void showVehicleManagementMenu() {
        while (true) {
            System.out.println("\n=== ARAÇ YÖNETİMİ ===");
            System.out.println("1. Araç Ekle");
            System.out.println("2. Araç Güncelle");
            System.out.println("3. Araç Sil");
            System.out.println("4. Tüm Araçları Listele");
            System.out.println("5. Araç Ara");
            System.out.println("6. Araç Tipi Bazlı Araç Listele");
            System.out.println("0. Ana Menüye Dön");

            System.out.print("\nSeçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    updateVehicle();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    listAllVehicles();
                    break;
                case 5:
                    searchVehicle();
                    break;
                case 6:
                    listVehiclesByType();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void showRentalManagementMenu() {
        while (true) {
            System.out.println("\n=== KİRALAMA YÖNETİMİ ===");
            System.out.println("1. Tüm Kiralamaları Listele");
            System.out.println("2. Kullanıcıya Göre Kiralamaları Listele");
            System.out.println("3. Araca Göre Kiralamaları Listele");
            System.out.println("4. Kiralama İptal Et");
            System.out.println("5. Kiralama Tamamla");
            System.out.println("0. Ana Menüye Dön");

            System.out.print("\nSeçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    listAllRentals();
                    break;
                case 2:
                    listRentalsByUser();
                    break;
                case 3:
                    listRentalsByVehicle();
                    break;
                case 4:
                    cancelRental();
                    break;
                case 5:
                    completeRental();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void listAllRentals() {
        System.out.println("\n=== TÜM KİRALAMALAR ===");
        List<Rental> rentals = rentalService.findAll();
        if (rentals.isEmpty()) {
            System.out.println("Kiralama kaydı bulunamadı.");
            return;
        }
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    private void listRentalsByUser() {
        System.out.println("\n=== KULLANICI KİRALAMALARI ===");
        System.out.print("Kullanıcı ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        List<Rental> rentals = rentalService.findByUserId(userId);
        if (rentals.isEmpty()) {
            System.out.println("Bu kullanıcıya ait kiralama kaydı bulunamadı.");
            return;
        }
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    private void listRentalsByVehicle() {
        System.out.println("\n=== ARAÇ KİRALAMALARI ===");
        System.out.print("Araç ID: ");
        Long vehicleId = scanner.nextLong();
        scanner.nextLine(); // Buffer temizleme

        List<Rental> rentals = rentalService.findByVehicleId(vehicleId);
        if (rentals.isEmpty()) {
            System.out.println("Bu araca ait kiralama kaydı bulunamadı.");
            return;
        }
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    private void loadDefaultData() {
        System.out.println("\nVarsayılan veriler yükleniyor...");
        DefaultData defaultData = new DefaultData();
        defaultData.loadDefaultData();
    }

    private void loadXData() {
        System.out.println("\nX-Verileri yükleniyor...");
        DefaultData defaultData = new DefaultData();
        defaultData.loadDefaultData();
    }
}