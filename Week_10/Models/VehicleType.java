package Week_10.Models;
public enum VehicleType {
    CAR("Otomobil"),
    MOTORCYCLE("Motosiklet"),
    HELICOPTER("Helikopter");

    private final String displayName;

    VehicleType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}