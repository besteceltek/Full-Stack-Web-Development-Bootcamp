import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Asked user for the perpendicular sides of the triangle
        System.out.println("Please enter the length of the first edge: ");
        int firstEdge = input.nextInt();
        System.out.println("Please enter the length of the first edge: ");
        int secondEdge = input.nextInt();
        //Calculated the hypotenuse of the triangle using Math library
        double hypotenuse = Math.sqrt((firstEdge * firstEdge) + (secondEdge * secondEdge));
        System.out.println("Hypotenuse is " + hypotenuse);
        //Calculated the area and printed
        double area = (double) (firstEdge * secondEdge) / 2;
        System.out.println("The area is " + area);
    }
}