import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number, total=0;

        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter a number: ");
            number = input.nextInt();
            if (number % 4 == 0) {
                total += number;
            }
        } while (number % 2 == 0);

        System.out.println("The total is " + total);
    }
}