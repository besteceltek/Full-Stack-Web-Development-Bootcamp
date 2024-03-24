import java.util.Random;

public class Snake extends Obstacle{
    private static Random random = new Random();

    public Snake() {
        super(4, random.nextInt(3) + 3, 12, 0, "Snake");
    }
}
