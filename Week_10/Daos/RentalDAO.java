/*
 * RentalDAO.java
 *
 * Bu sınıf, kiralama işlemlerinin veritabanı operasyonlarını yönetir. BaseDAO arayüzünü
 * implement ederek temel CRUD operasyonlarını sağlar ve kiralamalara özel ek metodlar
 * içerir.
 *
 * Özellikler:
 * - Kiralama kayıt işlemleri
 * - Kullanıcıya göre kiralama geçmişi
 * - Araca göre kiralama geçmişi
 * - Kiralama durumu yönetimi
 *
 * Veritabanı Tablosu: rentals
 *
 */

package Week_10.Daos;

import Week_10.Db.DatabaseConnection;
import Week_10.Models.Rental;
import Week_10.Models.RentalStatus;
import Week_10.Models.RentalType;
import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentalDAO implements BaseDAO<Rental> {
    private final Connection connection;

    public RentalDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Optional<Rental> findById(Long id) {
        String sql = "SELECT * FROM rentals WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSetToRental(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Rental> findAll() {
        List<Rental> rentals = new ArrayList<>();
        String sql = "SELECT * FROM rentals";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rentals.add(mapResultSetToRental(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    @Override
    public Rental save(Rental rental) {
        String sql = "INSERT INTO rentals (user_id, vehicle_id, start_date, end_date, " +
                    "rental_type, total_price, deposit, status, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, rental.getUserId());
            stmt.setLong(2, rental.getVehicleId());
            stmt.setTimestamp(3, Timestamp.valueOf(rental.getStartDate()));
            stmt.setTimestamp(4, Timestamp.valueOf(rental.getEndDate()));
            stmt.setString(5, rental.getRentalType().name());
            stmt.setBigDecimal(6, rental.getTotalPrice());
            stmt.setBigDecimal(7, rental.getDeposit());
            stmt.setString(8, RentalStatus.ACTIVE.name());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                rental.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rental;
    }

    @Override
    public Rental update(Rental rental) {
        String sql = "UPDATE rentals SET user_id = ?, vehicle_id = ?, start_date = ?, " +
                    "end_date = ?, rental_type = ?, total_price = ?, deposit = ?, " +
                    "status = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, rental.getUserId());
            stmt.setLong(2, rental.getVehicleId());
            stmt.setTimestamp(3, Timestamp.valueOf(rental.getStartDate()));
            stmt.setTimestamp(4, Timestamp.valueOf(rental.getEndDate()));
            stmt.setString(5, rental.getRentalType().name());
            stmt.setBigDecimal(6, rental.getTotalPrice());
            stmt.setBigDecimal(7, rental.getDeposit());
            stmt.setString(8, rental.getStatus().name());
            stmt.setLong(9, rental.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rental;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM rentals WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rental> findByUserId(Long userId) {
        List<Rental> rentals = new ArrayList<>();
        String sql = "SELECT * FROM rentals WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                rentals.add(mapResultSetToRental(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    public List<Rental> findByVehicleId(Long vehicleId) {
        List<Rental> rentals = new ArrayList<>();
        String sql = "SELECT * FROM rentals WHERE vehicle_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                rentals.add(mapResultSetToRental(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    private Rental mapResultSetToRental(ResultSet rs) throws SQLException {
        Rental rental = new Rental();
        rental.setId(rs.getLong("id"));
        rental.setUserId(rs.getLong("user_id"));
        rental.setVehicleId(rs.getLong("vehicle_id"));
        rental.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
        rental.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
        rental.setRentalType(RentalType.valueOf(rs.getString("rental_type")));
        rental.setTotalPrice(rs.getBigDecimal("total_price"));
        rental.setDeposit(rs.getBigDecimal("deposit"));
        rental.setStatus(RentalStatus.valueOf(rs.getString("status")));
        rental.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        rental.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
        return rental;
    }
} 