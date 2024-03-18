import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private int maxObstacle;

    public BattleLoc(int id, Player player, String name, Obstacle obstacle, int maxObstacle) {
        super(id, player, name);
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are here: " + this.getName());
        System.out.println("Be careful! There might be " + obsNumber + " " + this.obstacle.getObsName() + "!");
        System.out.println("F to Fight or R to Run : ");
        String selectAction = input.nextLine().toLowerCase();
        if (selectAction.equals("f")) {
            //fight
        } else if (selectAction.equals("r")) {
            //run
        } else {
            System.out.println("Selection is not applicable.");
            System.exit(0);
        }
        return true;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
