import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        count = input.nextInt();

        Pattern(count);
    }

    static void Pattern(int number) {
        if (number <= 0) {
            System.out.print(number + " ");
            return;
        }
        System.out.print(number + " ");
        Pattern(number - 5);
        System.out.print(number + " ");
    }
}