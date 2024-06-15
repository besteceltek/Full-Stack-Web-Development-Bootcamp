import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNumber, secondNumber, total;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        firstNumber = input.nextInt();
        System.out.print("Please enter the second number: ");
        secondNumber = input.nextInt();

        total = Factorial(firstNumber) / (Factorial(secondNumber) * Factorial(firstNumber - secondNumber));
        System.out.println("The combination of these numbers is " + total);
    }
    public static int Factorial (int number) {
        int total = 1;
        for (int i = 1; i <= number; i++) {
            total *= i;
        }
        return total;
    }
}