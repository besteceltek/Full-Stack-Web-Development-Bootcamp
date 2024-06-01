import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int year;
        String zodiac = null;

        //Prompted the year of birth from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your birth year: ");
        year = input.nextInt();

        //Calculated and determined the Chinese zodiac according to year of birth
        zodiac = switch (year % 12) {
            case 0 -> "Monkey";
            case 1 -> "Rooster";
            case 2 -> "Dog";
            case 3 -> "Pig";
            case 4 -> "Rat";
            case 5 -> "Ox";
            case 6 -> "Tiger";
            case 7 -> "Rabbit";
            case 8 -> "Dragon";
            case 9 -> "Snake";
            case 10 -> "Horse";
            case 11 -> "Goat";
            default -> zodiac;
        };
        System.out.println("Your Chinese zodiac is " + zodiac);
    }
}