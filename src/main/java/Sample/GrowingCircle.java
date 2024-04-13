package Sample;

public class GrowingCircle extends Obstacle{
    public GrowingCircle(double x, double v, int i) {
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void tick(double dt) {

    }

    @Override
    public boolean intersects(Player player) {
        return false;
    }
}
