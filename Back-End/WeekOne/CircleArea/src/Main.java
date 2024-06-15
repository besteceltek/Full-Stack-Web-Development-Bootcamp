import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double PI = 3.14;
        int radius, angle;
        double area, circumference;
        System.out.println("Please enter the radius of the circle: ");
        radius = input.nextInt();
        area = PI * radius * radius;
        circumference = 2 * PI * radius;
        System.out.println("The area of the circle is " + area);
        System.out.println("The circumference of the circle is " + circumference);

        System.out.println("Please enter the angle value of the circle slice: ");
        angle = input.nextInt();
        area = (PI * radius * radius * angle) / 360;
        System.out.println("The area of the circle slice is " + area);
    }
}