import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        System.out.printf("| %-6s | %-6s |%n", "4", "5");
        System.out.printf("-------------------%n");
        for (int i = 1; i <= number; i++) {
            System.out.printf("| %-6d | %-6d |%n", (int)Math.pow(4,i), (int)Math.pow(5,i));
        }
        System.out.printf("-------------------%n");
    }
}