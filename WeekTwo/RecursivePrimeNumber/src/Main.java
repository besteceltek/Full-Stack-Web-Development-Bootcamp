import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variable
        int number;

        //Called the Scanner class and prompted the number from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        //Checked if the number is prime or not with a method
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

        //Used recursive method to check if the number given from the user is divided by every number
        return isPrime(number, --i);
    }
}