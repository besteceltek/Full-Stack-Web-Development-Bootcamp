import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int n1, n2, select;

        //Called the Scanner function and prompted the input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        n1 = input.nextInt();
        System.out.print("Please enter the second number: ");
        n2 = input.nextInt();

        System.out.println("Please select the operation you would like to make");
        System.out.println("1-Addition\n2-Subtraction\n3-Multiplication\n4-Division");
        System.out.print("Your choice: ");
        select = input.nextInt();

        //Created the switch-case block for arithmetic operations
        switch(select) {
            case 1:
                System.out.println("Addition: " + (n1 + n2));
                break;
            case 2:
                System.out.println("Subtraction: " + (n1 - n2));
                break;
            case 3:
                System.out.println("Multiplication: " + (n1 * n2));
                break;
            case 4:
                if(n2 != 0) {
                    System.out.println("Division: " + (n1 / n2));
                }
                else {
                    System.out.println("You cannot divide a number by 0!");
                }
                break;
            default:
                System.out.println("You've made the wrong choice!");
                break;
        }
    }
}