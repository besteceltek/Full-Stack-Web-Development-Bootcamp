public abstract class Notebook extends Product {

    public Notebook(int productID, double unitPrice, double discountRate, int stockAmount, String productName,
                    Brand productBrand, int RAM, int storage, double displaySize) {
        super(productID, unitPrice, discountRate, stockAmount, productName, productBrand, RAM, storage, displaySize);
    }
}
