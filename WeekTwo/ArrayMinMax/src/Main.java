import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] list = {56, 34, 1, 8, 101, -2, -33};
        System.out.println(Arrays.toString(list));
        Scanner input = new Scanner(System.in);
        System.out.print("Please neter a number: ");
        int number = input.nextInt();
        Arrays.sort(list);


        System.out.println("Minimum Değer " + min);
        System.out.println("Maximum Değer " + max);

    }
}