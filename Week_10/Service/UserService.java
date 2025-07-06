package Week_10.Service;

import Week_10.Daos.UserDAO;
import Week_10.Helpper.PasswordHasher;
import Week_10.Models.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserService implements BaseService<User> {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User save(User user) {
        // Şifreyi hashle
        user.setPassword(PasswordHasher.hashPassword(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userDAO.save(user);
    }

    @Override
    public User update(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        return userDAO.update(user);
    }

    @Override
    public boolean delete(Long id) {
        userDAO.delete(id);
        return false;
    }

    public Optional<User> findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public boolean authenticate(String email, String password) {
        Optional<User> userOpt = userDAO.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return PasswordHasher.verifyPassword(password, user.getPassword());
        }
        return false;
    }

    public boolean isAdmin(Long userId) {
        Optional<User> userOpt = userDAO.findById(userId);
        return userOpt.map(user -> "ADMIN".equals(user.getUserType())).orElse(false);
    }

    public boolean isCorporate(Long userId) {
        Optional<User> userOpt = userDAO.findById(userId);
        return userOpt.map(user -> "CORPORATE".equals(user.getUserType())).orElse(false);
    }
}