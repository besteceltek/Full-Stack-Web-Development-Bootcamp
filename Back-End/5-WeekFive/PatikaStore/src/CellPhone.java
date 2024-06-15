public class CellPhone extends Product{
    private String color;
    private int batteryPower;

    public CellPhone(double unitPrice, int stockAmount, String productName,
                     Brand productBrand, int RAM, int storage, double displaySize, String color, int batteryPower) {
        super(unitPrice, stockAmount, productName, productBrand, RAM, storage,
                displaySize);
        this.color = color;
        this.batteryPower = batteryPower;
    }

    // Getters

    public String getColor() {
        return color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }
}
