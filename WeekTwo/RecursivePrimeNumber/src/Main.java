import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        if (isPrime(number, number - 1)) {
            System.out.println(number + " is a Prime number.");
        } else {
            System.out.println(number + " is a not Prime number.");
        }
    }

    static boolean isPrime(int number, int i) {
        if (number <= 1) {
            return false;
        }

        if (i == 1) {
            return true;
        }

        if (number % i == 0) {
            return false;
        }

        return isPrime(number, --i);
    }
}