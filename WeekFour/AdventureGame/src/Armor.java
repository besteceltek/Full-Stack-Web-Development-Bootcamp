public class Armor {
    private String name;
    private int id, shield, price;

    public Armor(String name, int id, int shield, int price) {
        this.name = name;
        this.id = id;
        this.shield = shield;
        this.price = price;
    }

    // List of armors
    public static Armor[] armors() {
        Armor[] armors = new Armor[3];
        armors[0] = new Armor("Light", 1, 1, 15);
        armors[1] = new Armor("Medium", 2, 3, 25);
        armors[2] = new Armor("Heavy", 3, 5, 40);
        return armors;
    }

    // Method for obtaining Armor object by its ID number
    public static Armor getArmorObjByID(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
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

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

