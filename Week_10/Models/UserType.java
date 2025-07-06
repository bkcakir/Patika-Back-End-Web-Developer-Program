package Week_10.Models;

public enum UserType {
    ADMIN("Admin"),
    NORMAL("Normal Kullanıcı"),
    CORPORATE("Kurumsal Kullanıcı");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return name();
    }
}