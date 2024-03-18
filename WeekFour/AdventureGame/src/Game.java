import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure Game!");

        System.out.println("Characters: ");
        selectPlayer();
        selectLocation();
    }

    public void selectPlayer() {
        Player[] playerList = {new Samurai(), new Archer(), new Knight()};
        for (Player player : playerList) {
            System.out.println(player.getId() + ". " + player.getName() +
                    "\t| Damage: " + player.getDamage() +
                    "\t| Health: " + player.getHealth() +
                    " | Money: " + player.getMoney());
        }
        System.out.print("Please choose a character to start the game: ");
        int selectChar = input.nextInt();

        while (selectChar < 1 || selectChar > playerList.length) {
            System.out.println("Selection is not applicable. Please enter again: ");
            selectChar = input.nextInt();
        }

        player = playerList[selectChar - 1];
        System.out.println(player.getName());
        System.out.println("==========");
    }

    public void selectLocation() {
        Location[] locations = {new SafeHouse(player), new ToolStore(player), new Cave(player), new Forest(player), new River(player)};
        boolean onLocation = true;
        while (onLocation) {
            System.out.println("Locations:");
            for (Location location : locations) {
                System.out.println(location.getId() + ". " + location.getName());
            }
            System.out.print("Please choose the location you wish to go: ");
            int selectLocation = input.nextInt();

            while (selectLocation < 1 || selectLocation > locations.length) {
                System.out.println("Selection is not applicable. Please enter again: ");
                selectLocation = input.nextInt();
            }
            location = locations[selectLocation - 1];
            System.out.println(location.getName());
            onLocation = location.onLocation();
            System.out.println("==========");
        }

    }

}
