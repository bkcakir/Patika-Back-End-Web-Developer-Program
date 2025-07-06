/*
 * PasswordHasher.java
 *
 * Bu sınıf, kullanıcı şifrelerinin güvenli bir şekilde hash'lenmesi ve doğrulanması
 * işlemlerini yönetir. SHA-256 algoritması kullanılarak şifrelerin güvenli bir
 * şekilde saklanmasını sağlar.
 *
 * Özellikler:
 * - Şifre hash'leme (SHA-256)
 * - Şifre doğrulama
 * - Güvenli şifre saklama
 * - Salt ve hash ayrı saklama (hashedPassword$$Salt formatı)
 *
 * Güvenlik Notları:
 * - Şifreler asla açık metin olarak saklanmaz
 * - SHA-256 algoritması güvenli hash'leme sağlar
 * - Her hash işlemi için benzersiz salt kullanılır
 * - Salt ve hash ayrı ayrı saklanır
 *
 */

package Week_10.Helpper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {
    private static final SecureRandom random = new SecureRandom();

    public static String hashPassword(String password) {
        try {
            // Rastgele salt oluştur
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // SHA-256 ile hash'le
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Salt ve hash'i birleştir
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);

            // Base64 ile encode et
            return Base64.getEncoder().encodeToString(combined);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Şifre hash'lenemedi", e);
        }
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        try {
            // Base64 decode
            byte[] combined = Base64.getDecoder().decode(hashedPassword);

            // Salt'ı ayır
            byte[] salt = new byte[16];
            System.arraycopy(combined, 0, salt, 0, salt.length);

            // Gelen şifreyi aynı salt ile hash'le
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedInput = md.digest(password.getBytes());

            // Hash'leri karşılaştır
            int diff = combined.length - 16 - hashedInput.length;
            if (diff != 0) return false;

            for (int i = 0; i < hashedInput.length; i++) {
                if (hashedInput[i] != combined[i + 16]) return false;
            }

            return true;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Şifre doğrulanamadı", e);
        }
    }
} 