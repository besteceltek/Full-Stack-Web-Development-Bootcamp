public abstract class Player {
    private int id, damage, health, money, maxHealth;
    private String name;
    private Inventory inventory;

    public Player(int id, int damage, int maxHealth, int money, String charName) {
        this.id = id;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.money = money;
        this.name = charName;
        this.health = maxHealth;
        this.inventory = new Inventory();
    }

    // Method to print Player
    public void printPlayer() {
        System.out.println("---- PLAYER ----");
        System.out.println(this.getName());
        System.out.println("Damage: " + this.getTotalDamage());
        System.out.println("Shield: " + this.getInventory().getArmor().getShield());
        System.out.println("Health: " + this.getHealth());
        System.out.println("Money: " + this.getMoney());
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}