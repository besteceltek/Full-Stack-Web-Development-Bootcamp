import java.util.Scanner;

public abstract class GameChar {
    private int id, damage, health, money;
    private String charName;
    private GameChar gameChar;
    private Scanner input = new Scanner(System.in);

    public GameChar(int id, int damage, int health, int money, String charName) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.charName = charName;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public String getCharName() {
        return charName;
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
        } else {
            System.out.println("Selection is not applicable.");
            System.exit(0);
        }
    }
}
