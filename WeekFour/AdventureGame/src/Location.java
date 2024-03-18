public abstract class Location {
    private Player player;
    private String name;
    private int id;

    public Location(int id, Player player, String name) {
        this.player = player;
        this.name = name;
        this.id = id;
    }

    public abstract boolean onLocation();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
