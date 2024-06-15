import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;
        int result = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        for (int i = 1; i <= number; i++) {
            result += (1 / result);
        }

        System.out.println("The harmonic series for the number " + number + " is " + result);
    }
}