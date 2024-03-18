public abstract class Obstacle {
    private int id, damage, health, money;
    private String obsName;

    public Obstacle(int id, int damage, int health, int money, String obsName) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.obsName = obsName;
    }

    public int obstacleNumber() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getObsName() {
        return obsName;
    }

    public void setObsName(String obsName) {
        this.obsName = obsName;
    }
}
