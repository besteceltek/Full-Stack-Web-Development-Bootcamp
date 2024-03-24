public class ToolStore extends NormalLoc {
    int selectMenu = 0;
    int selectionID;

    public ToolStore(Player player) {
        super(2, player, "Tool Store");
    }

    // Store Menu
    public boolean menu() {
        System.out.println("What would you like to buy?");
        // Prints menu items, created a for loop to match the Open-Closed Principle
        String[] menu = {"Weapon", "Armor"};
        for (int i = 1; i <= menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }

        System.out.print("Please select one of the above(Press 0 to exit the Store): ");
        selectMenu = input.nextInt();

        if (selectMenu == 0) {
            return true;
        }
        while (selectMenu < 0 || selectMenu > menu.length) {
            System.out.println("Selection is not applicable. Please enter again: ");
            selectMenu = input.nextInt();
        }
        switch (selectMenu) {
            case 1:
                weaponMenu();
                itemSelection();
                buyWeapon();
                break;
            case 2:
                armorMenu();
                itemSelection();
                buyArmor();
                break;
        }
        return true;
    }

    // Method for selecting item to buy
    public void itemSelection() {
        System.out.print("Choose one of the items you want to buy(Press 0 to go back to Menu) : ");
        selectionID = input.nextInt();
        if (selectionID == 0) {
            menu();
        }
    }

    // Method to buy weapon
    public void buyWeapon() {
        while (selectionID < 0 || selectionID > Weapon.weapons().length) {
            System.out.println("Selection is not applicable. Please enter again: ");
            selectionID = input.nextInt();
        }
        // Created a weapon object with the selected ID
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectionID);

        if (selectedWeapon != null) {
            // Checks if the player balance is enough to buy the item
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You don't have enough money.");
                menu();
            } else {
                System.out.println("You have bought the " + selectedWeapon.getName());
                // Sets the new balance of the player and prints it
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your remaining money is " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    // Method to buy armor
    public void buyArmor() {
        while (selectionID < 0 || selectionID > Armor.armors().length) {
            System.out.println("Selection is not applicable. Please enter again: ");
            selectionID = input.nextInt();
        }
        // Created an armor object with the selected ID
        Armor selectedArmor = Armor.getArmorObjByID(selectionID);

        if (selectedArmor != null) {
            // Checks if the player balance is enough to buy the item
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You don't have enough money.");
                menu();
            } else {
                System.out.println("You have bought the " + selectedArmor.getName() + " Armor");
                // Sets the new balance of the player and prints it
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your remaining money is " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }

    }

    // Method to print Armor Menu
    public void armorMenu() {
        System.out.println("Armors");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + ". " + armor.getName() +
                    "\t| Damage: " + armor.getShield() +
                    "\t| Price: " + armor.getPrice());
        }
    }

    // Method to print Weapon Menu
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
