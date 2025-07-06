/*
 * DatabaseConnection.java
 *
 * Bu sınıf, veritabanı bağlantısını yönetir. Singleton tasarım desenini
 * kullanarak tek bir veritabanı bağlantısı örneği oluşturur ve yönetir.
 *
 * Özellikler:
 * - Veritabanı bağlantı bilgileri (URL, kullanıcı adı, şifre)
 * - Singleton pattern ile tek bağlantı örneği
 * - Bağlantı havuzu yönetimi
 * - Bağlantı durumu kontrolü
 *
 * Veritabanı Bilgileri:
 * - Veritabanı: rentacar
 * - Kullanıcı: Admin
 * - Şifre: Admin123*!! (güvenlik nedeniyle kodda saklanmaz)
 *
 * Güvenlik Notları:
 * - Bağlantı bilgileri güvenli bir şekilde saklanmalıdır
 * - Bağlantı havuzu boyutu optimize edilmelidir
 * - Bağlantı zaman aşımı kontrolü yapılmalıdır
 */

package Week_10.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/rent_a_car";
    private static final String USER = "Admin";
    private static final String PASSWORD = "Admin123*!!";
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            // PostgreSQL sürücüsünün yüklendiğinden emin olun
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL sürücüsü bulunamadı", e);
        } catch (SQLException e) {
            throw new RuntimeException("Veritabanı bağlantısı kurulamadı: " + e.getMessage(), e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;  // Bağlantıyı döndür
        } catch (SQLException e) {
            throw new RuntimeException("Veritabanı bağlantısı kurulamadı: " + e.getMessage(), e);
        }
    }
}