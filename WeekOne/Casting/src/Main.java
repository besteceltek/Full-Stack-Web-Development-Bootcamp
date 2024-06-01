import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int myInt;
        double myDouble;

        //Called the scanner class and prompted an integer and a double from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        myInt = input.nextInt();
        System.out.print("Please enter a double: ");
        myDouble = input.nextDouble();

        //Type cast the inputs and printed them
        System.out.println("The double form of " + myInt + " is " + (double) myInt);
        System.out.println("The integer form of " + myDouble + " is " + (int) myDouble);
    }
}