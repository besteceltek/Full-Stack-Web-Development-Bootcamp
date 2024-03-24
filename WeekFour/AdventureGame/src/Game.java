import java.util.Scanner;

public class Game {
    private Player player;
    private final String[] menuOptions = {"Player", "Inventory", "Locations", "Exit Game"};
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure Game!");

        System.out.println("---- CHARACTERS ----");
        selectPlayer();
        selectMenu();
    }

    // Player Selection
    public void selectPlayer() {
        // Created Player objects
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
            System.out.print("Selection is not applicable. Please enter again: ");
            selectChar = input.nextInt();
        }

        // Set the player by selection ID
        player = playerList[selectChar - 1];
        System.out.println("You have chosen " + player.getName());
    }

    // Menu Selection
    public void selectMenu() {
        System.out.println("---- MENU ----");
        int i = 1;
        for (String menuOption : menuOptions) {
            System.out.println(i + ". " + menuOption);
            i++;
        }
        System.out.print("Please select an option: ");
        int menuSelection = input.nextInt();
        while (menuSelection < 1 || menuSelection > 4) {
            System.out.println("Selection is not applicable. Please enter again: ");
            menuSelection = input.nextInt();
        }
        switch (menuSelection) {
            case 1:
                player.printPlayer();
                System.out.print("Press 0 to go back to Menu: ");
                int press = input.nextInt();
                if (press == 0) {
                    selectMenu();
                }
                break;
            case 2:
                player.getInventory().printInventory();
                System.out.print("Press 0 to go back to Menu: ");
                press = input.nextInt();
                if (press == 0) {
                    selectMenu();
                }
                break;
            case 3:
                selectLocation();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Selection is not applicable.");
                break;
        }
    }

    // Location Selection
    public void selectLocation() {
        Location[] locations = {new SafeHouse(player), new ToolStore(player), new Cave(player), new Forest(player), new River(player), new Mine(player)};
        boolean onLocation = true;
        while (onLocation) {
            System.out.println("---- LOCATIONS ----");
            for (Location location : locations) {
                System.out.println(location.getId() + ". " + location.getName());
            }
            System.out.print("Please choose the location you wish to go (Press 0 to go back to Menu): ");
            int selectLocation = input.nextInt();

            if (selectLocation == 0) {
                selectMenu();
            }

            while (selectLocation < 1 || selectLocation > locations.length) {
                System.out.println("Selection is not applicable. Please enter again: ");
                selectLocation = input.nextInt();
            }

            // Checks if the chosen location has been cleared before
            if (this.player.getInventory().getFood() && selectLocation == 3 ||
                    this.player.getInventory().getFirewood() && selectLocation == 4 ||
                    this.player.getInventory().getWater() && selectLocation == 5 ||
                    Mine.isClear && selectLocation == 6) {
                System.out.print("You have cleared this area. Please enter again: ");
                selectLocation = input.nextInt();
            }

            Location location = locations[selectLocation - 1];
            onLocation = location.onLocation();

            // If the player is dead Game Over
            if (!onLocation) {
                System.out.println("GAME OVER!");
                break;
            }
        }

    }

}
