public abstract class Notebook extends Product {

    public Notebook(double unitPrice, int stockAmount, String productName,
                    Brand productBrand, int RAM, int storage, double displaySize) {
        super(unitPrice, stockAmount, productName, productBrand, RAM, storage, displaySize);
    }
}
