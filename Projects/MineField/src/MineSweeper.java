import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber, colNumber, mineCount;
    String[][] playerMine, actualMine;
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    void run() {
        if (this.colNumber < 2 && this.rowNumber < 2) {
            matrixFixer();
        }
        setPlayerMineField(playerMine);
        setMineField(actualMine);
    }

    void matrixFixer() {
        boolean check = true;
        while (check) {
            System.out.println("Field size is not applicable, please create a field 2x2 at minimum.");
            System.out.print("Please enter a new row number: ");
            this.rowNumber = input.nextInt();
            System.out.print("Please enter a new column number: ");
            this.colNumber = input.nextInt();
            if (this.colNumber >= 2 && this.rowNumber >= 2) {
                check = false;
            }
        }
    }
    void setMineCount() {
        mineCount = (this.colNumber * this.rowNumber) / 4;
    }
    void setPlayerMineField(String[][] mine) {
        mine = new String[rowNumber][colNumber];
        for (String[] strings : mine) {
            Arrays.fill(strings, " - ");
            System.out.println(Arrays.toString(strings));
        }
    }
    void setMineField(String[][] mine) {
        setMineCount();
        mine = new String[rowNumber][colNumber];
        for (String[] strings : mine) {
            Arrays.fill(strings, " - ");
        }
        for (int i = 0; i < mineCount; i++) {
            int randomRow = random.nextInt(this.rowNumber);
            int randomColumn = random.nextInt(this.colNumber);
            mine[randomRow][randomColumn] = " * ";
        }
        for (String[] strings : mine) {
            System.out.println(Arrays.toString(strings));
        }
    }
}
