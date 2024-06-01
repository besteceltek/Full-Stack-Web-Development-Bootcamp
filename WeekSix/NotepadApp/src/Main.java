import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "notlar.txt";

    public static void main(String[] args) {
        Main notepad = new Main();
        notepad.run();
    }

    private void run() {
        // Dosya varsa içeriğini oku ve ekrana yazdır
        String content = readFile();
        if (!content.isEmpty()) {
            System.out.println("Son kaydedilen metin:");
            System.out.println(content);
        } else {
            System.out.println("Henüz kaydedilmiş bir metin yok.");
        }

        // Kullanıcıdan metin girişi al
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nYeni metni girin (kaydetmek için Enter'a basın): ");
        String newContent = scanner.nextLine();

        // Girilen metni dosyaya kaydet
        writeFile(newContent);

        System.out.println("Metin başarıyla kaydedildi.");
    }

    private String readFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            // Dosya bulunamadıysa, henüz bir metin kaydedilmemiş demektir
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
        return content.toString().trim();
    }

    private void writeFile(String content) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FILENAME))) {
            printWriter.print(content);
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }
}