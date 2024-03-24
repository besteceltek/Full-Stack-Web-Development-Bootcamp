import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Unit Price: ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Stock Amount: ");
                    int stockAmount = scanner.nextInt();
                    System.out.print("Brand ID: ");
                    int brandID = scanner.nextInt();

                    int techChoice = scanner.nextInt();
                    scanner.nextLine();
                    Brand brand = store.getBrandByID(brandID);
                    if(brand != null) {
                        int st
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Yine Bekleriz.");
                    System.exit(0);
            }
        }
    }
}