import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int day, month;
        String horoscope = null;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your day of birth: ");
        day = input.nextInt();
        System.out.print("Please enter your month of birth as number (1-12): ");
        month = input.nextInt();

        if (month == 1) horoscope = day <= 21 ? "Oğlak" : "Kova";
        else if (month == 2) horoscope = day <= 19 ? "Kova" : "Balık";
        else if (month == 3) horoscope = day <= 20 ? "Balık" : "Koç";
        else if (month == 4) horoscope = day <= 20 ? "Koç" : "Boğa";
        else if (month == 5) horoscope = day <= 21 ? "Boğa" : "İkizler";
        else if (month == 6) horoscope = day <= 22 ? "İkizler" : "Yengeç";
        else if (month == 7) horoscope = day <= 22 ? "Yengeç" : "Aslan";
        else if (month == 8) horoscope = day <= 22 ? "Aslan" : "Başak";
        else if (month == 9) horoscope = day <= 22 ? "Başak" : "Terazi";
        else if (month == 10) horoscope = day <= 22 ? "Terazi" : "Akrep";
        else if (month == 11) horoscope = day <= 21 ? "Akrep" : "Yay";
        else if (month == 12) horoscope = day <= 21 ? "Yay" : "Oğlak";
        else System.out.println("You have entered a wrong value.");

        System.out.println("Your horoscope is " + horoscope);
    }
}