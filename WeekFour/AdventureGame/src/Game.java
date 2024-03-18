import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure Game!");

        System.out.print("Please enter your name: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Welcome to the game " + player.getPlayerName() + "!");

        System.out.println("Characters: ");
        player.selectChar();
        player.selectLocation();
    }


}
