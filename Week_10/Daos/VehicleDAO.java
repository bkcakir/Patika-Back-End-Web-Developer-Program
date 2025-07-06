/*
 * VehicleDAO.java
 *
 * Bu sınıf, araç verilerinin veritabanı işlemlerini yönetir. BaseDAO arayüzünü
 * implement ederek temel CRUD operasyonlarını sağlar ve araçlara özel ek metodlar
 * içerir.
 *
 * Özellikler:
 * - Araç kayıt işlemleri
 * - Araç tipine göre filtreleme
 * - Müsait araçları listeleme
 * - Araç fiyat ve ücret yönetimi
 *
 * Veritabanı Tablosu: vehicles
 */

package Week_10.Daos;

import Week_10.Db.DatabaseConnection;
import Week_10.Models.Vehicle;
import Week_10.Models.VehicleType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleDAO implements BaseDAO<Vehicle> {
    private final Connection connection;

    public VehicleDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSetToVehicle(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Araç aranırken bir hata oluştu", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Araçlar listelenirken bir hata oluştu", e);
        }
        return vehicles;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (brand, model, vehicle_type, price, daily_rate, weekly_rate, monthly_rate, available, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) RETURNING id";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getVehicleType().name());
            stmt.setBigDecimal(4, vehicle.getPrice());
            stmt.setBigDecimal(5, vehicle.getDailyRate());
            stmt.setBigDecimal(6, vehicle.getWeeklyRate());
            stmt.setBigDecimal(7, vehicle.getMonthlyRate());
            stmt.setBoolean(8, vehicle.isAvailable());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                vehicle.setId(rs.getLong("id"));
            }
            return vehicle;
        } catch (SQLException e) {
            throw new RuntimeException("Araç kaydedilirken bir hata oluştu", e);
        }
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET brand = ?, model = ?, vehicle_type = ?, price = ?, " +
                "daily_rate = ?, weekly_rate = ?, monthly_rate = ?, hourly_rate = ?, available = ?, updated_at = CURRENT_TIMESTAMP " +
                "WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getVehicleType().name());
            stmt.setBigDecimal(4, vehicle.getPrice());
            stmt.setBigDecimal(5, vehicle.getDailyRate());
            stmt.setBigDecimal(6, vehicle.getWeeklyRate());
            stmt.setBigDecimal(7, vehicle.getMonthlyRate());
            stmt.setBigDecimal(8, vehicle.getHourlyRate());
            stmt.setBoolean(9, vehicle.isAvailable());
            stmt.setLong(10, vehicle.getId());

            stmt.executeUpdate();
            return vehicle;
        } catch (SQLException e) {
            throw new RuntimeException("Araç güncellenirken bir hata oluştu", e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Araç silinirken bir hata oluştu", e);
        }
    }
    public List<Vehicle> findByType(VehicleType type) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE vehicle_type = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, type.name());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Araçlar listelenirken bir hata oluştu", e);
        }
        return vehicles;
    }

    public List<Vehicle> findAvailable() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE available = true";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Müsait araçlar listelenirken bir hata oluştu", e);
        }
        return vehicles;
    }

    private Vehicle mapResultSetToVehicle(ResultSet rs) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(rs.getLong("id"));
        vehicle.setBrand(rs.getString("brand"));
        vehicle.setModel(rs.getString("model"));
        vehicle.setVehicleType(VehicleType.valueOf(rs.getString("vehicle_type")));
        vehicle.setPrice(rs.getBigDecimal("price"));
        vehicle.setDailyRate(rs.getBigDecimal("daily_rate"));
        vehicle.setWeeklyRate(rs.getBigDecimal("weekly_rate"));
        vehicle.setMonthlyRate(rs.getBigDecimal("monthly_rate"));
        vehicle.setHourlyRate(rs.getBigDecimal("hourly_rate"));
        vehicle.setAvailable(rs.getBoolean("available"));
        vehicle.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        vehicle.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
        return vehicle;
    }
} 