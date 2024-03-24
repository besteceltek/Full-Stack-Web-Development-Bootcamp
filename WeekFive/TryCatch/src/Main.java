import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a 10 element array
        int[] array = {0,1,2,3,4,5,6,7,8,9};

        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Index prompt from user
        System.out.print("Please enter a number: ");
        int index = input.nextInt();

        // try-catch block to handle the error
        try {
            System.out.println("Element at index " + index + " is " + arrayElementAtIndex(array, index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Prompted index " + index + " is out of bounds.");
        }
    }

    // Method returns array element in an index prompted
    public static int arrayElementAtIndex(int[] array, int index) {
        return array[index];
    }
}