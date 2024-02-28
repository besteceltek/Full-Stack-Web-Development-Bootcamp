import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int base, exponent;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the base number: ");
        base = input.nextInt();
        System.out.print("Please enter the exponent number: ");
        exponent = input.nextInt();

        System.out.println(base + " to the power of " + exponent + " is " + Exponential(base, exponent));
    }

    static int Exponential(int base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        else {
            int result = base * Exponential(base,exponent - 1);
            return result;
        }
    }
}