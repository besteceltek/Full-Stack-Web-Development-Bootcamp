import java.util.Scanner;

public class Main {
    static int menuSelection;

    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- PatikaStore Product Management Panel ----");
            System.out.println("1. Notebook Operations");
            System.out.println("2. Cellphone Operations");
            System.out.println("3. List Brands");
            System.out.print("Please choose an action(Press 0 to exit the panel): ");
            menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0:
                    System.out.println("Please visit us again");
                    System.exit(0);
                    break;
                case 1:
                    store.notebookOperations();
                    break;
                case 2:
                    store.cellphoneOperations();
                    break;
                case 3:
                    store.listBrands();
                    break;
            }

        }
    }
}