import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Created the variables
        double height, weight, bmi;

        //Asked the height and weight data from user
        System.out.println("Please enter your height in meters: ");
        height = input.nextDouble();
        System.out.println("Please enter your weight in kilograms: ");
        weight = input.nextDouble();

        //Calculated and printed the body mass index
        bmi = weight / (height * height);
        System.out.println("Your Body Mass Index is: " + bmi);
    }
}