import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Created kilogram variables
        double pearKg, appleKg, tomatoesKg, bananaKg, eggplantKg;
        //Created price variables and assigned the static value
        final double pearPrice = 2.14, applePrice = 3.67, tomatoesPrice = 1.11,
                bananaPrice = 0.95, eggplantPrice = 5.00, totalPrice;

        //Grocery amount prompted from user
        System.out.println("Please enter how many kilograms of pears you have bought: ");
        pearKg = input.nextDouble();
        System.out.println("Please enter how many kilograms of apples you have bought: ");
        appleKg = input.nextDouble();
        System.out.println("Please enter how many kilograms of tomatoes you have bought: " );
        tomatoesKg = input.nextDouble();
        System.out.println("Please enter how many kilograms of bananas you have bought: " );
        bananaKg = input.nextDouble();
        System.out.println("Please enter how many kilograms of eggplants you have bought: ");
        eggplantKg = input.nextDouble();

        //Calculated the total price according to static price values and user entries
        totalPrice = (pearKg * pearPrice) + (appleKg * applePrice) + (tomatoesKg * tomatoesPrice)
                + (bananaKg * bananaPrice) + (eggplantKg * eggplantPrice);
        System.out.println("Total Price: " + totalPrice + "TL");
    }
}