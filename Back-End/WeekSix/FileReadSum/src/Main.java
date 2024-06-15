import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Read from file
        try (BufferedReader br = new BufferedReader(new FileReader("myFile.txt"))) {
            String line;
            int sum = 0;
            System.out.println("The numbers in the file are: ");
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
                System.out.print(line + " ");
            }
            System.out.println("\nThe sum of numbers in the file is: " + sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}