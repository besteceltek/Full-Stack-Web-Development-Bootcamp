import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int year;
        boolean leapYear = false;

        //Called Scanner function and prompted a year from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a year: ");
        year = input.nextInt();

        //Checked if the year is divided by 4
        if (year % 4 == 0) {
            //Checked if the year is divided by 100
            if (year % 100 == 0) {
                //Checked if the year is divided by 400
                if (year % 400 == 0) {
                    leapYear = true;
                }
                else {
                    leapYear = false;
                }
            }
            else {
                leapYear = true;
            }
        }
        else {
            leapYear =  false;
        }

        //Printed whether the year is a leap year or not
        if (leapYear)
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");
    }
}