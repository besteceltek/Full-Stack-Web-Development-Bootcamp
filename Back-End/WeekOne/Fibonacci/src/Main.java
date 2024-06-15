import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int number1 = 0, number2 = 1, count, total;

        //Called the scanner function and prompted the steps from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        count = input.nextInt();

        //Printed the Fibonacci numbers
        for (int i = 0; i < count; i++) {
            total = number1 + number2;
            System.out.print(number1 + " ");
            number1 = number2;
            number2 = total;
        }
    }
}