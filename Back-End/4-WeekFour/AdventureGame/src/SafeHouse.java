public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(1, player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        // Sets the player health to maximum
        this.getPlayer().setHealth(getPlayer().getMaxHealth());

        System.out.println("You are in safe house, your health is full.");
        return true;
    }
}
