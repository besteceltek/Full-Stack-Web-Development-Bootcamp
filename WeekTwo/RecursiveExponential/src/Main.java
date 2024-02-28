import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int base, exponent;

        //Called the Scanner class and prompted the base and exponent numbers from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the base number: ");
        base = input.nextInt();
        System.out.print("Please enter the exponent number: ");
        exponent = input.nextInt();

        System.out.println(base + " to the power of " + exponent + " is " + Exponential(base, exponent));
    }

    //Created a method to calculate the exponential numbers
    static int Exponential(int base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        else {
            //Used recursive method to multiply the base number as many as exponential value
            int result = base * Exponential(base,exponent - 1);
            return result;
        }
    }
}