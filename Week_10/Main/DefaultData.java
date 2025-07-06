package Week_10.Main;

import Week_10.Daos.UserDAO;
import Week_10.Daos.VehicleDAO;
import Week_10.Daos.RentalDAO;
import Week_10.Helpper.PasswordHasher;
import Week_10.Models.User;
import Week_10.Models.Vehicle;
import Week_10.Models.Rental;
import Week_10.Models.UserType;
import Week_10.Models.VehicleType;
import Week_10.Models.RentalType;
import Week_10.Models.RentalStatus;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DefaultData {
    private final UserDAO userDAO;
    private final VehicleDAO vehicleDAO;
    private final RentalDAO rentalDAO;

    public DefaultData() {
        this.userDAO = new UserDAO();
        this.vehicleDAO = new VehicleDAO();
        this.rentalDAO = new RentalDAO();
    }

    public void loadDefaultData() {
        try {
            // Kullanıcıları yükle
            List<User> users = createDefaultUsers();
            for (User user : users) {
                try {
                    // Eğer kullanıcı zaten varsa atla
                    if (userDAO.findByEmail(user.getEmail()).isPresent()) {
                        System.out.println("Kullanıcı zaten mevcut, atlanıyor: " + user.getEmail());
                        continue;
                    }
                    userDAO.save(user);
                } catch (Exception e) {
                    System.err.println("Kullanıcı kaydedilirken hata oluştu: " + user.getEmail() + " - " + e.getMessage());
                }
            }

            // Araçları yükle
            List<Vehicle> vehicles = createDefaultVehicles();
            for (Vehicle vehicle : vehicles) {
                vehicleDAO.save(vehicle);
            }

            System.out.println("Varsayılan veriler başarıyla yüklendi.");
        } catch (Exception e) {
            System.err.println("Varsayılan veriler yüklenirken hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<User> createDefaultUsers() {
        List<User> users = new ArrayList<>();

        // Admin kullanıcıları
        users.add(new User("admin1@rentacar.com", PasswordHasher.hashPassword("Admin123!"), UserType.ADMIN));
        users.add(new User("admin2@rentacar.com", PasswordHasher.hashPassword("Admin123!"), UserType.ADMIN));

        // Normal kullanıcılar
        for (int i = 1; i <= 5; i++) {
            users.add(new User("user" + i + "@example.com",
                    PasswordHasher.hashPassword("User123!"),
                    UserType.NORMAL));
        }

        // Kurumsal kullanıcılar
        for (int i = 1; i <= 5; i++) {
            users.add(new User("corporate" + i + "@company.com",
                    PasswordHasher.hashPassword("Corp123!"),
                    UserType.CORPORATE));
        }

        return users;
    }

    private List<Vehicle> createDefaultVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        // Araçlar
        String[] carBrands = {"Toyota", "Honda", "Ford", "BMW", "Mercedes"};
        String[] carModels = {"Corolla", "Civic", "Focus", "320i", "C200"};
        for (int i = 0; i < 5; i++) {
           vehicles.add(new Vehicle(
                   carBrands[i],
                   carModels[i],
                   VehicleType.CAR,
                   500000.0,  // Fiyat
                   0.1,       // Saatlik oran
                   0.2,       // Günlük oran
                   0.3,       // Haftalık oran
                   0.4,       // Aylık oran
                   true       // Müsait

           ));
        }

        // Helikopterler
        String[] heliBrands = {"Robinson", "Bell"};
        String[] heliModels = {"R44", "206L"};
        for (int i = 0; i < 2; i++) {
            vehicles.add(new Vehicle(
                    heliBrands[i],
                    heliModels[i],
                    VehicleType.HELICOPTER,
                    500000.0,  // Fiyat
                    0.1,       // Saatlik oran
                    0.2,       // Günlük oran
                    0.3,       // Haftalık oran
                    0.4,       // Aylık oran
                    true       // Müsait
            ));
        }

        // Motosikletler
        String[] bikeBrands = {"Honda", "Yamaha", "Kawasaki", "Suzuki", "BMW"};
        String[] bikeModels = {"CBR", "R1", "Ninja", "GSX-R", "S1000RR"};
        for (int i = 0; i < 5; i++) {
            vehicles.add(new Vehicle(
                    bikeBrands[i],
                    bikeModels[i],
                    VehicleType.MOTORCYCLE,
                    50000.0,   // Fiyat
                    0.1,       // Saatlik oran
                    0.2,       // Günlük oran
                    0.3,       // Haftalık oran
                    0.4,       // Aylık oran
                    true       // Müsait
            ));
        }

        return vehicles;
    }
}