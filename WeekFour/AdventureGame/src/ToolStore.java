public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(2, player, "Tool Store");
    }

    public void menu() {}
    public void buy() {}

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Tool Store");
        return true;
    }
}
