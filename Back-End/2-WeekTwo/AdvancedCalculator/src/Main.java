import java.util.Scanner;

public class Main {

    static void SUM() {
        Scanner scan = new Scanner(System.in);
        int number, result = 0, i = 1;
        while (true) {
            System.out.print(i++ + ". sayı: ");
            number = scan.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Sonuç: " + result);
    }

    static void SUBTRACT() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz: ");
        int counter = scan.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı: ");
            number = scan.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }

        System.out.println("Sonuç: " + result);
    }

    static void PRODUCT() {
        Scanner scan = new Scanner(System.in);
        int number, result = 1, i = 1;

        while (true) {
            System.out.print(i++ + ". sayı: ");
            number = scan.nextInt();

            if (number == 1)
                break;

            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }

        System.out.println("Sonuç: " + result);
    }

    static void DIVIDE() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz: ");
        int counter = scan.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı: ");
            number = scan.nextDouble();
            if (i != 1 && number == 0) {
                System.out.println("Böleni 0 giremezsiniz.");
                continue;
            }
            if (i == 1) {
                result = number;
                continue;
            }
            result /= number;
        }

        System.out.println("Sonuç: " + result);
    }

    static void POWER() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Taban değeri giriniz: ");
        int base = scan.nextInt();
        System.out.print("Üs değeri giriniz: ");
        int exponent = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println("Sonuç: " + result);
    }

    static void FACT() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int n = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println("Sonuç: " + result);
    }

    static void MOD() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz: ");
        int counter = scan.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı: ");
            number = scan.nextDouble();
            if (i != 1 && number == 0) {
                System.out.println("Böleni 0 giremezsiniz.");
                continue;
            }
            if (i == 1) {
                result = number;
                continue;
            }
            result %= number;
        }

        System.out.println("Sonuç: " + result);
    }

    static void RECT() {
        Scanner scan = new Scanner(System.in);
        System.out.print("İlk kenar uzunluğunu giriniz: ");
        int birinciKenar = scan.nextInt();
        System.out.print("İkinci kenar uzunluğunu giriniz: ");
        int ikinciKenar = scan.nextInt();
        System.out.println("Alan: " + (birinciKenar * ikinciKenar));
        System.out.println("Çevre: " + ((birinciKenar + ikinciKenar) * 2));
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select;
        String menu = """
                1- Toplama İşlemi
                2- Çıkarma İşlemi
                3- Çarpma İşlemi
                4- Bölme işlemi
                5- Üslü Sayı Hesaplama
                6- Faktoriyel Hesaplama
                7- Mod Alma
                8- Dikdörtgen Alan ve Çevre Hesabı
                0- Çıkış Yap""";

        do {
            System.out.println(menu);
            System.out.print("Lütfen bir işlem seçiniz :");
            select = scan.nextInt();
            switch (select) {
                case 1:
                    SUM();
                    break;
                case 2:
                    SUBTRACT();
                    break;
                case 3:
                    PRODUCT();
                    break;
                case 4:
                    DIVIDE();
                    break;
                case 5:
                    POWER();
                    break;
                case 6:
                    FACT();
                    break;
                case 7:
                    MOD();
                    break;
                case 8:
                    RECT();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
            }
        } while (select != 0);


    }
}