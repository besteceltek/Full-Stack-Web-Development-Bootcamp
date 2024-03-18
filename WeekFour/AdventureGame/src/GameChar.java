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
}
