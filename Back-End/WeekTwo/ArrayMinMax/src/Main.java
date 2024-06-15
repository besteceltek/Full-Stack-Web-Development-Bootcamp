import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] list = {56, 34, 1, 8, 101, -2, -33};

        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int userInput = input.nextInt();

        boolean minFound = false;
        boolean maxFound = false;
        int min = list[0];
        int max = list[0];

        for (int i : list) {
            int diff = userInput - i;
            if (diff > 0 && (!minFound || diff < userInput - min)) {
                min = i;
                minFound = true;
            } else if (diff < 0 && (!maxFound || -diff < max - userInput)) {
                max = i;
                maxFound = true;
            }
        }

        System.out.println("Minimum Değer " + (minFound ? min : "Bulunamadı"));
        System.out.println("Maximum Değer " + (maxFound ? max : "Bulunamadı"));

    }
}