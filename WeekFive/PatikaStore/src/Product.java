public class Product {
    private static int idCounter = 1;
    private int productID;
    private double unitPrice;
    private double discountRate;
    private int stockAmount;
    private String productName;
    private Brand productBrand;
    private int RAM;
    private int storage;
    private double displaySize;

    public Product(int productID, double unitPrice, double discountRate, int stockAmount, String productName,
                   Brand productBrand, int RAM, int storage, double displaySize) {
        idCounter++;
        this.productID = productID;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.productName = productName;
        this.productBrand = productBrand;
        this.RAM = RAM;
        this.storage = storage;
        this.displaySize = displaySize;
    }

    public int getProductID() {
        return productID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getProductName() {
        return productName;
    }

    public Brand getProductBrand() {
        return productBrand;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public double getDisplaySize() {
        return displaySize;
    }
}
