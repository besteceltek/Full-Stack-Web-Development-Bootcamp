import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Defined variables
        int[][] matrix = {{1, 2, 3}, {4, 5, 6,}};
        int[][] transpose = new int[matrix[0].length][matrix.length];

        //Printed the initial matrix using foreach loop and Arrays class
        System.out.println("The initial matrix is: ");
        for (int[] numbers : matrix) {
            System.out.println(Arrays.toString(numbers));
        }

        //Performed the transpose using for loop
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        //Printed the transposed matrix using foreach loop and Arrays class
        System.out.println("---------------");
        System.out.println("The new transposed matrix is: ");
        for (int[] numbers : transpose) {
            System.out.println(Arrays.toString(numbers));
        }
    }
}