import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Store {
    private List<Brand> brands;
    private List<Product> cellPhones;
    private List<Product> notebooks;

    public Store() {
        this.brands = new ArrayList<>();
        this.cellPhones = new ArrayList<>();
        this.notebooks = new ArrayList<>();

        brands.add(new Brand(1, "Apple"));
        brands.add(new Brand(2, "Asus"));
        brands.add(new Brand(3, "Casper"));
        brands.add(new Brand(4, "HP"));
        brands.add(new Brand(5, "Huawei"));
        brands.add(new Brand(6, "Lenovo"));
        brands.add(new Brand(7, "Monster"));
        brands.add(new Brand(8, "Samsung"));
        brands.add(new Brand(9, "Xiaomi"));
        brands.sort(Comparator.comparing(Brand::getBrandName));
    }

    public void addProduct(Product product, int techChoice) {
        if (product instanceof Product) {
            for (Brand brand : brands) {
                if (product.getProductBrand().getBrandName().equals(brand.getBrandName())) {

                    //BURAYA WHILE DONGUSU EKLE!!!!
                    if (techChoice == 1) {
                        cellPhones.add(product);
                    } else if (techChoice == 2) {
                        notebooks.add(product);
                    } else {
                        System.out.println("Choice is not applicable.");
                    }
                }
            }
        }
    }

    public void deleteProduct(int productID) {
//        Iterator<Product> iterator = cellPhones.iterator();
//        while (iterator.hasNext()) {
//            Product product = iterator.next();
//            if (product.getProductID() == productID) {
//                iterator.remove();
//            }
//        }
        cellPhones.removeIf(product -> product.getProductID() == productID);
        notebooks.removeIf(product -> product.getProductID() == productID);
    }

    public void listProduct() {
        System.out.println("Notebook List");
        System.out.println("--------------");
        System.out.println("| ID | Product Name | Price | Brand | Storage | Display | RAM |");
        System.out.println("--------------");
        for (Product product : notebooks) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-9f |");
        }
    }
}
