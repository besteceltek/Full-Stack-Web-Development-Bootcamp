public class Mine extends BattleLoc{
    static boolean isClear;

    public Mine(Player player) {
        super(6, player, "Mine", new Snake(), 5, "Weapon, Armor, or Money");
        this.isClear = false;
    }
}
