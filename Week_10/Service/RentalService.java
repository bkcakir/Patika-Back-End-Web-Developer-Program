package Week_10.Service;

import Week_10.Daos.RentalDAO;
import Week_10.Daos.UserDAO;
import Week_10.Daos.VehicleDAO;
import Week_10.Models.Rental;
import Week_10.Models.RentalStatus;
import Week_10.Models.RentalType;
import Week_10.Models.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class RentalService implements BaseService<Rental> {
    private final RentalDAO rentalDAO;
    private final VehicleDAO vehicleDAO;
    private final UserDAO userDAO;

    public RentalService() {
        this.rentalDAO = new RentalDAO();
        this.vehicleDAO = new VehicleDAO();
        this.userDAO = new UserDAO();
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return rentalDAO.findById(id);
    }

    @Override
    public List<Rental> findAll() {
        return rentalDAO.findAll();
    }

    @Override
    public Rental save(Rental rental) {
        // Kiralama işlemi başlatıldığında aracın durumunu güncelle
        vehicleDAO.findById(rental.getVehicleId()).ifPresent(vehicle -> {
            vehicle.setAvailable(false);
            vehicleDAO.update(vehicle);
        });

        return rentalDAO.save(rental);
    }

    @Override
    public Rental update(Rental rental) {
        return rentalDAO.update(rental);
    }

    @Override
    public boolean delete(Long id) {
        rentalDAO.delete(id);
        return false;
    }

    public List<Rental> findByUserId(Long userId) {
        return rentalDAO.findByUserId(userId);
    }

    public List<Rental> findByVehicleId(Long vehicleId) {
        return rentalDAO.findByVehicleId(vehicleId);
    }

    public Rental completeRental(Long rentalId) {
        Optional<Rental> rentalOpt = rentalDAO.findById(rentalId);
        if (rentalOpt.isPresent()) {
            Rental rental = rentalOpt.get();
            rental.setStatus(RentalStatus.COMPLETED);

            // Aracın durumunu güncelle
            vehicleDAO.findById(rental.getVehicleId()).ifPresent(vehicle -> {
                vehicle.setAvailable(true);
                vehicleDAO.update(vehicle);
            });

            return rentalDAO.update(rental);
        }
        return null;
    }

    public Rental cancelRental(Long rentalId) {
        Optional<Rental> rentalOpt = rentalDAO.findById(rentalId);
        if (rentalOpt.isPresent()) {
            Rental rental = rentalOpt.get();
            rental.setStatus(RentalStatus.CANCELLED);

            // Aracın durumunu güncelle
            vehicleDAO.findById(rental.getVehicleId()).ifPresent(vehicle -> {
                vehicle.setAvailable(true);
                vehicleDAO.update(vehicle);
            });

            return rentalDAO.update(rental);
        }
        return null;
    }

    public BigDecimal calculateRentalPrice(Long vehicleId, RentalType rentalType, LocalDateTime startDate, LocalDateTime endDate) {
        Optional<Vehicle> vehicleOpt = vehicleDAO.findById(vehicleId);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            long duration;

            switch (rentalType) {
                case HOURLY:
                    duration = ChronoUnit.HOURS.between(startDate, endDate);
                    return vehicle.getDailyRate().divide(new BigDecimal("24")).multiply(new BigDecimal(duration));
                case DAILY:
                    duration = ChronoUnit.DAYS.between(startDate, endDate);
                    return vehicle.getDailyRate().multiply(new BigDecimal(duration));
                case WEEKLY:
                    duration = ChronoUnit.WEEKS.between(startDate, endDate);
                    return vehicle.getWeeklyRate().multiply(new BigDecimal(duration));
                case MONTHLY:
                    duration = ChronoUnit.MONTHS.between(startDate, endDate);
                    return vehicle.getMonthlyRate().multiply(new BigDecimal(duration));
                default:
                    return BigDecimal.ZERO;
            }
        }
        return BigDecimal.ZERO;
    }

    public boolean canUserRentVehicle(Long userId, Long vehicleId) {
        // Kullanıcının aktif kiralama işlemi var mı kontrol et
        List<Rental> userRentals = rentalDAO.findByUserId(userId);
        boolean hasActiveRental = userRentals.stream()
                .anyMatch(rental -> rental.getStatus() == RentalStatus.ACTIVE);

        if (hasActiveRental) {
            return false;
        }

        // Aracın müsait olup olmadığını kontrol et
        Optional<Vehicle> vehicleOpt = vehicleDAO.findById(vehicleId);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            return vehicle.isAvailable();
        }

        return false;
    }
}