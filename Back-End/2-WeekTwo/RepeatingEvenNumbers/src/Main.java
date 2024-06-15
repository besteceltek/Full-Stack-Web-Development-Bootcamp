import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {2, 5, 6, 4, 7, 3, 2, 4, 4, 4, 9, 8, 6, 2, 4};
        int[] duplicate = new int[list.length];
        int startIndex = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ((i != j) && list[i] == list[j] && list[i] % 2 == 0) {
                    duplicate[startIndex++] = list[i];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(duplicate));
    }
}