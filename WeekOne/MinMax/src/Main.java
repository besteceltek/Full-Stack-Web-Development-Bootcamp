import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int count, min, max;

        //Called the Scanner class and prompted the input from user.
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers you will enter? ");
        count = input.nextInt();

        //Created an integer array to store the numbers given from the user
        int [] numbers = new int[count];

        //Numbers were prompted from the user with the for loop and put into the integer array.
        for (int i = 0; i < count; i++) {
            System.out.print("Enter the " + (i + 1) + ". number ");
            numbers[i] = input.nextInt();
        }

        //Defined the minimum and maximum variables
        min = numbers[1];
        max = numbers[1];

        //Data in the array was compared to find the minimum and maximum value
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        System.out.println("The smallest number is " + min);
        System.out.println("The greatest number is " + max);
    }
}