import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int a, b, c, result;

        //Prompted three integer from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        a = input.nextInt();
        System.out.print("Please enter the second number: ");
        b = input.nextInt();
        System.out.print("Please enter the third number: ");
        c = input.nextInt();

        //Calculated the a+b*c-b and printed the result
        result = a+b*c-b;
        System.out.println("The result is " + result);
    }
}