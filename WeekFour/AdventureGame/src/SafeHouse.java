public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(1, player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house, your health is full.");
        return true;
    }
}
