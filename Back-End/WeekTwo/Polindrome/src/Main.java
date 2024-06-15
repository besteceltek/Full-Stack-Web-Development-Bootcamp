import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        if(isPalindrome(number)) {
            System.out.println(number + " is a Palindrome number.");
        }
        else {
            System.out.println(number + " is not a Palindrome number.");
        }
    }
    static boolean isPalindrome(int number) {
        int temp = number, reverseNumber = 0, lastNumber;
        while (temp != 0) {
            lastNumber = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastNumber;
            temp /= 10;
        }
        if (reverseNumber == number) {
            return true;
        }
        else {
            return false;
        }
    }
}