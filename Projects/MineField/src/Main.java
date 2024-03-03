import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int row, column;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the row size of the mine: ");
        row = input.nextInt();
        System.out.print("Please enter the column size of the mine: ");
        column = input.nextInt();
        MineSweeper mine = new MineSweeper(row,column);
        mine.run();
    }
}