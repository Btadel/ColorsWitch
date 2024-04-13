package Sample;

public class RotatingCircle extends Obstacle{
    public RotatingCircle(double x, double v, int i, double v1, double v2) {
        super();
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
