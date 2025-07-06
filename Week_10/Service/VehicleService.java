package Week_10.Service;

import Week_10.Daos.VehicleDAO;
import Week_10.Models.Vehicle;
import Week_10.Models.VehicleType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class VehicleService implements BaseService<Vehicle> {
    private final VehicleDAO vehicleDAO;

    public VehicleService() {
        this.vehicleDAO = new VehicleDAO();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleDAO.findById(id);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleDAO.findAll();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleDAO.update(vehicle);
    }

    @Override
    public boolean delete(Long id) {
        vehicleDAO.delete(id);
        return false;
    }

    public List<Vehicle> findByType(VehicleType vehicleType) {
        return vehicleDAO.findByType(vehicleType);
    }

    public List<Vehicle> findAvailable() {
        return vehicleDAO.findAvailable();
    }

    public boolean isVehicleAvailable(Long vehicleId) {
        Optional<Vehicle> vehicleOpt = vehicleDAO.findById(vehicleId);
        return vehicleOpt.map(Vehicle::isAvailable).orElse(false);
    }

    public boolean isVehiclePriceOverTwoMillion(Long vehicleId) {
        Optional<Vehicle> vehicleOpt = vehicleDAO.findById(vehicleId);
        return vehicleOpt.map(vehicle ->
                vehicle.getPrice().compareTo(new BigDecimal("2000000")) > 0
        ).orElse(false);
    }

    public BigDecimal calculateDeposit(Long vehicleId) {
        Optional<Vehicle> vehicleOpt = vehicleDAO.findById(vehicleId);
        return vehicleOpt.map(vehicle ->
                vehicle.getPrice().multiply(new BigDecimal("0.10"))
        ).orElse(BigDecimal.ZERO);
    }
}