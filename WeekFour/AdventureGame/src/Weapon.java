public class Weapon {
    private String name;
    private int id, damage, price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    // List of weapons
    public static Weapon[] weapons() {
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon("Pistol", 1, 2, 25);
        weapons[1] = new Weapon("Sword", 2, 3, 35);
        weapons[2] = new Weapon("Rifle", 3, 7, 45);
        return weapons;
    }

    // Method for obtaining Weapon object by its ID number
    public static Weapon getWeaponObjByID(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
