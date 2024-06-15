import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Created the variables
        int math, phys, chem, turkish, music, classCount = 5;

        //Requested the data for previously created variables from user
        //and checked whether the grades are between 0 and 100
        System.out.println("Please enter your Mathematics grade: ");
        math = input.nextInt();
        if (math < 0 || math > 100) {
            System.out.println("Invalid grade! Will not be included in the mean grade calculation.");
            classCount -= 1;
            math = 0;
        }
        System.out.println("Please enter your Physics grade: ");
        phys = input.nextInt();
        if (phys < 0 || phys > 100) {
            System.out.println("Invalid grade! Will not be included in the mean grade calculation.");
            classCount -= 1;
            phys = 0;
        }
        System.out.println("Please enter your Chemistry grade: ");
        chem = input.nextInt();
        if (chem < 0 || chem > 100) {
            System.out.println("Invalid grade! Will not be included in the mean grade calculation.");
            classCount -= 1;
            chem = 0;
        }
        System.out.println("Please enter your Turkish grade: ");
        turkish = input.nextInt();
        if (turkish < 0 || turkish > 100) {
            System.out.println("Invalid grade! Will not be included in the mean grade calculation.");
            classCount -= 1;
            turkish = 0;
        }
        System.out.println("Please enter your Music grade: ");
        music = input.nextInt();
        if (music < 0 || music > 100) {
            System.out.println("Invalid grade! Will not be included in the mean grade calculation.");
            classCount -= 1;
            music = 0;
        }

        //Calculated the mean grade
        int meanGrade = (math + phys + chem + turkish + music) / classCount;

        //Checked whether the user has passed or failed
        if (meanGrade >= 55) {
            System.out.println("Class passed!");
        }
        else {
            System.out.println("Class failed!");
        }
        System.out.println("Your average: " + meanGrade);
    }
}