public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        double sum = 0;
        for (int number : numbers) {
            sum += ((double) 1 / number);
        }

        System.out.println(sum);
    }
}