import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {10, 20, 20, 10, 10, 20, 5, 20};

        int[] frequencies = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            int currentElement = list[i];
            int count = 1;

            // Eğer bu eleman daha önce kontrol edilmediyse, diğer elemanlarla karşılaştır
            if (frequencies[i] == 0) {
                for (int j = i + 1; j < list.length; j++) {
                    if (list[j] == currentElement) {
                        count++;
                        // Eleman tekrar edildiğinde, frekansı 0 olarak işaretleyerek daha sonra kontrol etmemek için
                        frequencies[j] = -1;
                    }
                }
                // Frekansı dizide sakla
                frequencies[i] = count;
                System.out.println("Eleman: " + currentElement + ", Frekans: " + count);
            }
        }
    }
}