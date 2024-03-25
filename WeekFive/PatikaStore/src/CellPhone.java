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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
