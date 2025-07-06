/*
 * UserDAO.java
 *
 * Bu sınıf, kullanıcı verilerinin veritabanı işlemlerini yönetir. BaseDAO arayüzünü
 * implement ederek temel CRUD operasyonlarını sağlar ve kullanıcıya özel ek metodlar
 * içerir.
 *
 * Özellikler:
 * - Kullanıcı kayıt işlemleri
 * - Kullanıcı girişi ve doğrulama
 * - E-posta ile kullanıcı arama
 * - Kullanıcı tipi kontrolü
 *
 * Veritabanı Tablosu: users
 *
 */

package Week_10.Daos;
import Week_10.Db.DatabaseConnection;
import Week_10.Models.User;
import Week_10.Models.UserType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements BaseDAO<User> {
    private final Connection connection;

    public UserDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToUser(rs));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı bulunamadı: " + e.getMessage(), e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY id";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcılar listelenemedi: " + e.getMessage(), e);
        }
    }

    @Override
    public User save(User user) {
        String sql = "INSERT INTO users (email, password, user_type, created_at, updated_at) " +
                    "VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUserType().name());
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Kullanıcı kaydedilemedi, hiçbir satır etkilenmedi.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getLong(1));
                    return user;
                } else {
                    throw new RuntimeException("Kullanıcı kaydedilemedi, ID alınamadı.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı kaydedilemedi: " + e.getMessage(), e);
        }
    }

    @Override
    public User update(User user) {
        String sql = "UPDATE users SET email = ?, password = ?, user_type = ?, updated_at = CURRENT_TIMESTAMP " +
                    "WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUserType().name());
            stmt.setLong(4, user.getId());
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Kullanıcı güncellenemedi, kullanıcı bulunamadı.");
            }
            
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı güncellenemedi: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Kullanıcı silinemedi, kullanıcı bulunamadı.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı silinemedi: " + e.getMessage(), e);
        }
    }
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToUser(rs));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı bulunamadı: " + e.getMessage(), e);
        }
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setUserType(UserType.valueOf(rs.getString("user_type")));
        user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        user.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
        return user;
    }
} 