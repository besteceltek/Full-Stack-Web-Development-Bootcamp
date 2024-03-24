public class Inventory {
    private boolean water, food, firewood;
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon("Unarmed", 0, 0,0);
        this.armor = new Armor("Rags", 0, 0, 0);
    }

    // Method to print Inventory
    public void printInventory() {
        System.out.println("---- INVENTORY ----");
        System.out.println("Weapon: " + this.getWeapon().getName() + "\t| Damage: " + this.getWeapon().getDamage());
        System.out.println("Armor: " + this.getArmor().getName() + "\t| Shield: " + this.getArmor().getShield());
        System.out.println("Water: " + this.getWater());
        System.out.println("Food: " + this.getFood());
        System.out.println("Firewood: " + this.getFirewood());
    }

    // Getters & Setters

    public boolean getWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean getFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean getFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
