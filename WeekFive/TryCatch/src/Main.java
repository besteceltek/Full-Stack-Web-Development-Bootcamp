import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int index = input.nextInt();

        try {
            System.out.println("Element at index " + index + " is " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Prompted index " + index + " is out of bounds.");
        }
    }
}