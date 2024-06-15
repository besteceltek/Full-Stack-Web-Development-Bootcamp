import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined the variables
        int count;

        //Called the Scanner class and prompted the number from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        count = input.nextInt();

        Pattern(count);
    }

    //Created the method for printing the pattern
    static void Pattern(int number) {
        if (number <= 0) {
            System.out.print(number + " ");
            return;
        }
        //Used mirroring technique for printing the numbers after negative value
        System.out.print(number + " ");
        Pattern(number - 5);
        System.out.print(number + " ");
    }
}