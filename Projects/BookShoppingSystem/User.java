package Projects.BookShoppingSystem;

public class User {

    private String name;       // Kullanıcının adı
    private String username;   // Kullanıcı adı (username)
    private String password;   // Şifre
    private Boolean isAdmin;   // Admin yetkisi
    private String userType;   // Kullanıcı türü (Müşteri, Satıcı, vb.)

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    // Estetik toString (Şifre gösterilmez!)
    @Override
    public String toString() {
        return  "----------------------------\n" +
                " Adı            : " + name + "\n" +
                " Kullanıcı Adı  : " + username + "\n" +
                " Kullanıcı Türü : " + userType + "\n" +
                " Admin Yetkisi  : " + (isAdmin ? "Evet" : "Hayır") + "\n" +
                "----------------------------";
    }

    // Default kullanıcılar ekleme
    public static void defaultUsers() {
        User u1 = new User();
        u1.setName("Ahmet Yılmaz");
        u1.setUsername("admin");
        u1.setPassword("admin123");
        u1.setUserType("Yönetici");
        u1.setAdmin(true);

        User u2 = new User();
        u2.setName("Mehmet Demir");
        u2.setUsername("mehmet123");
        u2.setPassword("mehmet2023");
        u2.setUserType("Müşteri");
        u2.setAdmin(false);

        User u3 = new User();
        u3.setName("Elif Kaya");
        u3.setUsername("elif.kaya");
        u3.setPassword("elif1234");
        u3.setUserType("Satıcı");
        u3.setAdmin(false);

        // Örnek kullanıcılar array'e ekleniyor
        users[0] = u1;
        users[1] = u2;
        users[2] = u3;
    }

    // Kullanıcıları yazdır
    public static void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    // Kullanıcılar dizisi
    public static User[] users = new User[3];  // 3 kullanıcı örneği
}
