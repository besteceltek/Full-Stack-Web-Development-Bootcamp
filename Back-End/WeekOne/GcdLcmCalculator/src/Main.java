import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int number1, number2;

        //Called the Scanner class and prompted the input from user.
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        number1 = input.nextInt();
        System.out.print("Please enter the second number: ");
        number2 = input.nextInt();

        System.out.println(GCD(number1,number2));
        System.out.println(LCM(number1,number2));
    }
    //Created a class to calculate Greatest Common Divisor
    public static int GCD (int n1, int n2) {
        int i = 1, gcd = 1;
        while (i <= n1) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
            i++;
        }
        return gcd;
    }
    //Created a class to calculate Least Common Multiple
    public static int LCM (int n1, int n2) {
        int i = 1, lcm = 1;
        while (i <= (n1 * n2)) {
            if (i % n1 == 0 && i % n2 == 0) {
                lcm = i;
                break;
            }
            i += 1;
        }
        return lcm;
    }
}