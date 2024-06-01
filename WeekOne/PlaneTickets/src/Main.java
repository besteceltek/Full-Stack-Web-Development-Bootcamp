import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int distance, age, travel;

        //Called the Scanner function and prompted necessary data from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the distance in km: ");
        distance = input.nextInt();
        System.out.print("Please enter your age: ");
        age = input.nextInt();
        System.out.print("Please enter the travel type (1 => one way, 2 => two way): ");
        travel = input.nextInt();

        //Checked if the data given from user is valid or not
        if (distance < 0 || age < 0 || (travel != 1 && travel != 2)) {
            System.out.println("Wrong entry!");
        } else {
            double distancePrice, ageDiscount, discountedPrice, travelDiscount, totalPrice;
            //Calculated the price according to distance
            distancePrice = distance * 0.1;

            //Checked if the user is subjected to age discount
            if (age < 12) {
                ageDiscount = distancePrice * 0.5;
            } else if (age <= 24) {
                ageDiscount = distancePrice * 0.1;
            } else if (age > 65) {
                ageDiscount = distancePrice * 0.3;
            } else {
                ageDiscount = 0;
            }

            //Applied the age discount to the previous price
            discountedPrice = distancePrice - ageDiscount;

            //Checked if the travel type is one-way or two-way and applied the discount accordingly
            if (travel == 2) {
                travelDiscount = discountedPrice * 0.2;
                totalPrice = (discountedPrice - travelDiscount) * 2;
            } else {
                travelDiscount = 0;
                totalPrice = discountedPrice;
            }

            System.out.println("Normal Tutar = " + distancePrice);
            System.out.println("Yaş İndirimi = " + ageDiscount);
            System.out.println("İndirimli Tutar = " + discountedPrice);
            System.out.println("Gidiş Dönüş Bilet İndirimi = " + travelDiscount);
            System.out.println("Total Amount = " + totalPrice);
        }
    }
}