import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number, digitCount, result = 0, digit, tempNumber, exponent;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();
        tempNumber = number;
        digitCount = DigitCount(number);

        while (tempNumber != 0) {
            digit = tempNumber % 10;
            exponent = 1;
            for (int i = 1; i <= digitCount; i++) {
                exponent *= digit;
            }
            result += exponent;
            tempNumber /= 10;
        }

        if (result == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

    }

    public static int DigitCount(int number) {
        int digitCount = 0;
        while (number != 0) {
            number /= 10;
            digitCount++;
        }
        return digitCount;
    }
}