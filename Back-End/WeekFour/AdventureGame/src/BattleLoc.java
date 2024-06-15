import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private int maxObstacle;
    private String loot;
    private Random random = new Random();

    public BattleLoc(int id, Player player, String name, Obstacle obstacle, int maxObstacle, String loot) {
        super(id, player, name);
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
        this.loot = loot;
    }

    // Random obstacle number generator
    public int randomObstacleNumber() {
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        // If the chosen location is Mine, set the loot table as random
        if (this.getName().equals("Mine")) {
            randomMineLoot();
        }

        System.out.println("You are here: " + this.getName());
        System.out.println("Be careful! There might be " + obsNumber + " " + this.obstacle.getObsName() + "!");
        System.out.println("F to Fight or R to Run : ");
        String selectAction = input.nextLine().toLowerCase();

        // If player chooses to fight, combat starts
        if (selectAction.equals("f")) {

            // Checks if combat returns true
            if (combat(obsNumber)) {
                System.out.println("You have defeated all the monsters in the " + this.getName() + "!");

                // If the chosen location is Mine, set the isClear true so the player can't choose the location again
                if (this.getName().equals("Mine")) {
                    Mine.isClear = true;
                }
                return true;
            } else {
                System.out.println("You have died!");
                return false;
            }

            // If player chooses to run, returns to Location selection page
        } else if (selectAction.equals("r")) {
            return true;
        } else {
            System.out.println("Selection is not applicable.");
            System.exit(0);
        }
        return true;
    }

    // The combat action method
    public boolean combat(int obsNumber) {

        // This for loop runs for every obstacle in an area
        for (int i = 1; i <= obsNumber; i++) {

            // If there are multiple obstacles in an area, this sets its health to max to fight again
            this.getObstacle().setHealth(this.getObstacle().getMaxHealth());

            // Start combat if both the player and the obstacle are alive and continue until one of them dies
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                firstHit();
                if (firstHit().equals("Player")) {
                    playerHit();

                    // Checks if the obstacle is still alive
                    if (this.getObstacle().getHealth() > 0) {
                        obstacleHit();
                    }
                } else {
                    obstacleHit();

                    // Checks if the player is still alive
                    if (this.getPlayer().getHealth() > 0) {
                        playerHit();
                    }
                }
            }

            // Checks if the obstacle is dead and gives loot
            if (this.getObstacle().getHealth() == 0) {
                System.out.println("You have defeated the monster!");
                System.out.println("Your loot is " + this.getLoot() + " and " + this.getObstacle().getMoney() + " gold.");
                loot();
            }
        }
        // Returns false if the player is dead and true if the player is alive
        return this.getPlayer().getHealth() > 0;
    }

    // Method to set the loot
    public void loot() {
        switch (this.getLoot()) {
            case "Food" -> this.getPlayer().getInventory().setFood(true);
            case "Firewood" -> this.getPlayer().getInventory().setFirewood(true);
            case "Water" -> this.getPlayer().getInventory().setWater(true);
        }
        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
    }

    // Method to call when the player hits
    public void playerHit() {
        System.out.println("You have dealed " + this.getPlayer().getTotalDamage() + " damage.");
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        System.out.println("Remaining health of the " + this.getObstacle().getObsName() +
                " is " + this.getObstacle().getHealth());
        System.out.println();
    }

    // Method to call when the obstacle hits
    public void obstacleHit() {
        //Get Player armor
        int playerShield = this.getPlayer().getInventory().getArmor().getShield();

        //Get Obstacle's damage
        int obsDamage = this.getObstacle().getDamage();

        System.out.println(this.getObstacle().getObsName() + " dealed " + obsDamage + " damage, " + playerShield + " damage is blocked.");

        //Set Player's new health
        this.getPlayer().setHealth(this.getPlayer().getHealth() - obsDamage - playerShield);
        System.out.println("Your remaining health is " + this.getPlayer().getHealth());
        System.out.println();
    }

    // Method for calculating who hits first by 50% chance
    public String firstHit() {
        String firstHit;
        double randomValue = random.nextDouble() * 100;
        if (randomValue < 50) {
            firstHit = "Player";
        } else {
            firstHit = "Obstacle";
        }
        return firstHit;
    }

    // Loot creator method for new location Mine
    public void randomMineLoot() {
        double randomValue = random.nextDouble() * 100;
        double randomItemValue = random.nextDouble() * 100;
        if (randomValue < 15) {
            if (randomItemValue < 20) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
            } else if (randomItemValue < 50) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
            } else {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(0));
            }
        } else if (randomValue < 30) {
            if (randomItemValue < 20) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(0));
            } else if (randomItemValue < 50) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
            } else {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
            }
        } else if (randomValue < 55) {
            this.setLoot("unfortunately nothing");
            if (randomItemValue < 20) {
                this.getObstacle().setMoney(10);
            } else if (randomItemValue < 50) {
                this.getObstacle().setMoney(5);
            } else {
                this.getObstacle().setMoney(1);
            }
        } else {
            this.setLoot("unfortunately nothing");
        }
    }

    // Getters & Setters

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }
}
