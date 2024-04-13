package Sample;

public class VerticalBar extends Obstacle{

    private double width;
    private double height;
    private double speed;
    private double direction = 1; // 1 pour déplacement vers la droite, -1 pour déplacement vers la gauche

    public VerticalBar(double x, double y, double width, double height, double speed) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.renderer = new VerticalBarRenderer(this);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void tick(double dt) {
        // Déplacement horizontal avec rebondissement aux bords du niveau
        double newX = getX() + speed * direction * dt;
        if (newX < 0 || newX + width > Level.screenWidth) {
            direction *= -1; // Inverser la direction en cas de collision avec les bords
        } else {
            setX(newX);
        }
    }

    @Override
    public boolean intersects(Player player) {
        return player.getX() < getX() + width &&
                player.getX() + player.getWidth() > getX() &&
                player.getY() < getY() + height &&
                player.getY() + player.getHeight() > getY();
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
}