import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String username, password, newPassword;
        int reset;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        username = input.nextLine();
        System.out.print("Please enter your password: ");
        password = input.nextLine();

        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Successful Login!");
        }
        else {
            System.out.print("Wrong password! Would you like to reset your password? (1-Yes / 2-No) ");
            reset = input.nextInt();
            if (reset == 1) {
                System.out.print("Enter new password: ");
                newPassword = input.nextLine();
                if (newPassword.equals(password)) {
                    System.out.println("New password cannot be the same with the old password. Please try again.");
                } else {
                    System.out.println("Password changed successfully!");
                }
            }
            else {
                System.out.println("Login failed!");
            }
        }
    }
}