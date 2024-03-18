import java.util.Scanner;

public class Player {
    private Location location;
    private GameChar gameChar;
    private String playerName;
    private Scanner input = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gameChar : charList) {
            System.out.println(gameChar.getId() + ". " + gameChar.getCharName() +
                    "\t| Damage: " + gameChar.getDamage() +
                    "\t| Health: " + gameChar.getHealth() +
                    " | Money: " + gameChar.getMoney());
        }
        System.out.print("Please choose a character to start the game: ");
        int selectChar = input.nextInt();
        if (selectChar >= 1 && selectChar <= charList.length) {
            gameChar = charList[selectChar - 1];
            System.out.println(gameChar.getCharName());
            System.out.println("==========");
        } else {
            System.out.println("Selection is not applicable.");
            System.exit(0);
        }
    }

    public void selectLocation() {
        Location[] locations = {new SafeHouse(this), new ToolStore(this)};
        boolean onLocation = true;
        while (onLocation) {
            System.out.println("Locations:");
            for (Location location : locations) {
                System.out.println(location.getId() + ". " + location.getName());
            }
            System.out.print("Please choose the location you wish to go: ");
            int selectLocation = input.nextInt();
            if (selectLocation >= 1 && selectLocation <= locations.length) {
                location = locations[selectLocation - 1];
                System.out.println(location.getName());
                onLocation = location.onLocation();
                System.out.println("==========");
            } else {
                System.out.println("Selection is not applicable.");
                System.exit(0);
            }
        }

    }

    public String getPlayerName() {
        return playerName;
    }
}