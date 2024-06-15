import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is hte temperature outside? ");
        int temp = input.nextInt();
        String activity;
        if (temp < 5) {
            activity = "Skiing";
        } else if (temp < 15) {
            activity = "Cinema";
        } else if (temp < 25) {
            activity = "Picnic";
        } else {
            activity = "Swimming";
        }

        System.out.println("The activity you can do in this weather is " + activity);
    }
}