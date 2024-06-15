import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Created and ask the customer for a price
        int price;
        System.out.println("Please enter the price: ");
        price = input.nextInt();
        //Determined the KDV value compared to the price with if-else
        double kdv;
        if (price > 1000) {
            kdv = 0.08;
        }
        else {
            kdv = 0.18;
        }
        //Calculated and printed the KDV and total price
        double kdvValue = price * kdv;
        double total = price + kdvValue;
        System.out.println("KDV Amount: " + kdvValue);
        System.out.println("Total Amount: " + total);
    }
}