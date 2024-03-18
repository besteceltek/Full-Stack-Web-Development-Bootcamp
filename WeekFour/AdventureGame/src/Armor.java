public class Armor {
    private String name;
    private int id, dodge, price;

    public Armor(String name, int id, int dodge, int price) {
        this.name = name;
        this.id = id;
        this.dodge = dodge;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armors = new Armor[3];
        armors[0] = new Armor("Light", 1, 1, 15);
        armors[1] = new Armor("Medium", 2, 3, 25);
        armors[2] = new Armor("Heavy", 3, 5, 40);
        return armors;
    }

    public static Armor getArmorObjByID(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }

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

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

