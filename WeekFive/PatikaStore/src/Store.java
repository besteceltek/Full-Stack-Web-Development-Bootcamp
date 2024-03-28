import java.util.*;

public class Store {
    private final List<Brand> brands;
    private List<CellPhone> cellPhones;
    private List<Notebook> notebooks;

    private final Scanner input = new Scanner(System.in);

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

    // Method to handle notebook panel operations
    public void notebookOperations() {
        System.out.println("---- Notebook Operations ----");
        System.out.println("1. Add Notebook");
        System.out.println("2. Delete Notebook");
        System.out.println("3. List Notebooks");
        System.out.print("Please choose an action(Press 0 to exit the panel): ");
        int menuSelection = input.nextInt();

        switch (menuSelection) {
            case 0:
                break;
            case 1:
                System.out.print("How many products will you add? ");
                int addProduct = input.nextInt();
                for (int i = 1; i <= addProduct; i++) {
                    addProduct(addProductInputs(), 1);
                }
                break;
            case 2:
                System.out.println("Which product would you like to delete? ");
                int deleteID = input.nextInt();
                deleteProduct(deleteID);
                break;
            case 3:
                listNotebooks();
                break;
        }
    }

    // Method to handle cellphone panel operations
    public void cellphoneOperations() {
        System.out.println("---- Cellphone Operations ----");
        System.out.println("1. Add Cellphone");
        System.out.println("2. Delete Cellphone");
        System.out.println("3. List Cellphone");
        System.out.print("Please choose an action(Press 0 to exit the panel): ");
        int menuSelection = input.nextInt();

        switch (menuSelection) {
            case 0:
                break;
            case 1:
                System.out.print("How many products will you add? ");
                int addProduct = input.nextInt();
                for (int i = 1; i <= addProduct; i++) {
                    addProduct(addProductInputs(), 2);
                }
                break;
            case 2:
                System.out.println("Which product would you like to delete? ");
                int deleteID = input.nextInt();
                deleteProduct(deleteID);
                break;
            case 3:
                listCellphones();
                break;
        }
    }

    // Method to get product info from the user
    public Product addProductInputs() {
        Product product = null;

        System.out.print("Brand ID: ");
        int brandID = input.nextInt();

        Brand brand = this.getBrandByID(brandID);

        if (brand != null) {
            System.out.print("Product Name: ");
            String productName = input.next();

            System.out.print("Unit Price: ");
            double unitPrice = input.nextDouble();

            System.out.print("Stock Amount: ");
            int stockAmount = input.nextInt();

            System.out.print("Storage (GB): ");
            int storage = input.nextInt();

            System.out.print("RAM (GB): ");
            int RAM = input.nextInt();

            System.out.print("Display Size (inch): ");
            int displaySize = input.nextInt();

            switch (Main.menuSelection) {
                case 1:
                    product = new Notebook(unitPrice, stockAmount, productName, brand, RAM, storage, displaySize);
                    break;
                case 2:
                    System.out.print("Battery Power (mAh): ");
                    int batteryPower = input.nextInt();

                    System.out.print("Color: ");
                    String color = input.next();

                    product = new CellPhone(unitPrice, stockAmount, productName, brand, RAM, storage, displaySize, color, batteryPower);
                    break;
            }
        } else {
            System.out.println("Brand ID is not applicable.");
        }
        return product;
    }

    // Method to add product
    public void addProduct(Product product, int techChoice) {
        if (product instanceof Product) {
            for (Brand brand : brands) {
                if (product.getProductBrand().getBrandName().equals(brand.getBrandName())) {
                    if (techChoice == 1) {
                        notebooks.add((Notebook) product);
                    } else if (techChoice == 2) {
                        cellPhones.add((CellPhone) product);
                    } else {
                        System.out.println("Choice is not applicable.");
                    }
                }
            }
        }
    }

    // Method to delete product
    public void deleteProduct(int productID) {
        /* Iterator<Product> iterator = cellPhones.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductID() == productID) {
                iterator.remove();
            }
        } */
        cellPhones.removeIf(product -> product.getProductID() == productID);
        notebooks.removeIf(product -> product.getProductID() == productID);
    }

    // Method to list notebooks
    public void listNotebooks() {
        System.out.println("---- Notebook List ----");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name |    Price    | Stock |  Brand  | Storage | Display | RAM |");
        System.out.println("-------------------------------------------------------------------------------");
        for (Notebook notebook : notebooks) {
            System.out.format("| %-2d | %-12s | %-8.1f TL | %-7d | %-7s | %-7d | %-7.1f | %-3d |\n",
                    notebook.getProductID(), notebook.getProductName(), notebook.getUnitPrice(), notebook.getStockAmount(),
                    notebook.getProductBrand().getBrandName(), notebook.getStorage(),
                    notebook.getDisplaySize(), notebook.getRAM());
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    // Method to list cellphones
    public void listCellphones() {
        System.out.println("---- Cellphone List ----");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name |    Price    | Stock |  Brand  | Storage | Display | RAM | Battery Power | Color |");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (CellPhone cellPhone : cellPhones) {
            System.out.format("| %-2d | %-12s | %-8.1f TL | %-7d | %-7s | %-7d | %-7.1f | %-3d | %-7d | %-7s\n",
                    cellPhone.getProductID(), cellPhone.getProductName(), cellPhone.getUnitPrice(),
                    cellPhone.getProductBrand().getBrandName(), cellPhone.getStorage(), cellPhone.getDisplaySize(),
                    cellPhone.getRAM(), cellPhone.getBatteryPower(), cellPhone.getColor());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    // Method to list available brands
    public void listBrands() {
        System.out.println("---- Brand List ----");
        for (Brand brand : brands) {
            System.out.println("- " + brand.getBrandName());
        }
    }


    public Brand getBrandByID(int brandID) {
        return brands.get(brandID - 1);
    }
}
