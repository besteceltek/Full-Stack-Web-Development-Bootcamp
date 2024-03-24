import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String maxFreq = null;
        int maxCount = 0;

        // Create a HashMap to store the words and their frequency
        HashMap<String,Integer> wordFreq = new HashMap<String, Integer>();

        // Create a Scanner object and get a text from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a text: ");
        String text = input.nextLine();

        // Split input words
        String[] words = text.toLowerCase().split(" ");

        // Mapping each word
        for (String word : words) {
            int wordCount = 1;
            if (!wordFreq.containsKey(word)) {
                wordFreq.put(word, wordCount);
            } else {
                wordFreq.replace(word,wordFreq.get(word) + 1);
            }
        }

        // Find most frequent word
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxFreq = entry.getKey();
            }
        }

        // Printing result
        System.out.println("The most mentioned word in the text is " + maxFreq);
    }
}