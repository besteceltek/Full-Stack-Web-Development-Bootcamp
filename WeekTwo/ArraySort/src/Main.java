//imported necessary libraries
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int lenght;
        int[] list;

        //Called the Scanner class and prompted the length of array from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the lenght of the array: ");
        lenght = input.nextInt();

        //Created a new array with length given from teh user
        list = new int[lenght];

        //Collected the elements of the array from the user using for loop
        System.out.println("Please enter the elements of the array: ");
        for (int i = 0; i < lenght; i++) {
            System.out.print((i + 1) + ". Element: ");
            list[i] = input.nextInt();
        }

        //Sorted the array using Arrays class and printed the result
        Arrays.sort(list);
        System.out.println("Your list in order is: " + Arrays.toString(list));
    }
}