public abstract class CellPhone extends Product{
    private String color;
    private int batteryPower;

    public CellPhone(int productID, double unitPrice, double discountRate, int stockAmount, String productName,
                     Brand productBrand, int RAM, int storage, double displaySize, String color, int batteryPower) {
        super(productID, unitPrice, discountRate, stockAmount, productName, productBrand, RAM, storage,
                displaySize);
        this.color = color;
        this.batteryPower = batteryPower;
    }
}
