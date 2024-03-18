public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(2, player, "Tool Store");
    }

    public boolean menu() {
        System.out.println("What would you like to buy?");
        System.out.println("1. Weapon");
        System.out.println("2. Armor");
        System.out.println("3. Exit Store");
        System.out.print("Please select one of the above: ");
        int selectMenu = input.nextInt();
        while (selectMenu < 1 || selectMenu > 3) {
            System.out.println("Selection is not applicable. Please enter again: ");
            selectMenu = input.nextInt();
        }
        switch (selectMenu) {
            case 1:
                weaponMenu();
                //buy();
                break;
            case 2:
                armorMenu();
                //buy();
                break;
            case 3:
                return true;
        }
        return true;
    }
    public void buy() {}
    public void armorMenu() {
        System.out.println("Armors");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + ". " + armor.getName() +
                    "\t| Damage: " + armor.getDodge() +
                    "\t| Price: " + armor.getPrice());
        }
    }
    public void weaponMenu() {
        System.out.println("Weapons");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + ". " + weapon.getName() +
                    "\t| Damage: " + weapon.getDamage() +
                    "\t| Price: " + weapon.getPrice());
        }
    }

    @Override
    public boolean onLocation() {
        boolean onLocation = false;
        System.out.println("Welcome to the Tool Store");
        onLocation = menu();
        return onLocation;
    }
}
