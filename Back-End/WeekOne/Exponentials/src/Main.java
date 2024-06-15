import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNumber, secondNumber, total = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        firstNumber = input.nextInt();
        System.out.print("Please enter the second number: ");
        secondNumber = input.nextInt();

        for (int i = 1; i <= secondNumber; i++) {
            total *= firstNumber;
        }

        System.out.println(firstNumber + " to the power of " + secondNumber + " is " + total);
    }
}