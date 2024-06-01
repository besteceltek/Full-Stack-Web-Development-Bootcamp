import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int count;

        //Called the Scanner class and prompted the step count from the user
        Scanner input = new Scanner(System.in);
        System.out.print("How many steps would you like on your triangle? ");
        count = input.nextInt();

        //Printed as many stars as the user prompted
        for(int i = count; i > 0; i--) {
            for(int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}