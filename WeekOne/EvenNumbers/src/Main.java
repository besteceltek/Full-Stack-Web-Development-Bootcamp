import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k, total = 0, count = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        k = input.nextInt();

        for (int i = 0; i < k; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                total += i;
                count += 1;
            }
        }
        System.out.println("The average of numbers divisible by 3 and 4 is " + total/count);
    }
}