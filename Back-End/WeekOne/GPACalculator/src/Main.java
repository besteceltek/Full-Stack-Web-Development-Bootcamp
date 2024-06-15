import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Created the variables
        int math, phys, chem, turkish, hist, music;

        //Requested the data for previously created variables from user
        System.out.println("Please enter your Mathematics grade: ");
        math = input.nextInt();

        System.out.println("Please enter your Physics grade: ");
        phys = input.nextInt();

        System.out.println("Please enter your Chemistry grade: ");
        chem = input.nextInt();

        System.out.println("Please enter your Turkish grade: ");
        turkish = input.nextInt();

        System.out.println("Please enter your History grade: ");
        hist = input.nextInt();

        System.out.println("Please enter your Music grade: ");
        music = input.nextInt();

        //Calculated the mean grade
        int mean_grade = (math + phys + chem + turkish + hist + music) / 6;

        //Checked whether the user has passed or failed
        if(mean_grade > 60) {
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed!");
        }
    }
}