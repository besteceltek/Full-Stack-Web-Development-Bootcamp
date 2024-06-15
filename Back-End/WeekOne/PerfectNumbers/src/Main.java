import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int number, total = 0;

        //Called the scanner function and prompted a number from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        //Added the divisors of the number
        for (int i = 1; i < number; i++) {
            if(number % i == 0) {
                total += i;
            }
        }

        //Checked if the number is equal to the sum of all its divisors
        if (total == number) {
            System.out.println(number + " is a Perfect Number");
        }
        else {
            System.out.println(number + " is not a Perfect Number");
        }
    }
}