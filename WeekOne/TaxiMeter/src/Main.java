import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startPrice = 10;
        double distance, distancePrice, totalPrice;
        System.out.println("Please enter the distance you traveled in km: ");
        distance = input.nextInt();
        distancePrice = distance * 2.20;
        totalPrice = distancePrice + startPrice;
        if (totalPrice < 20) {
            totalPrice = 20;
        }
        System.out.println("Total price is: " + totalPrice);
    }
}