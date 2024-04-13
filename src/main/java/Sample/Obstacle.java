package Sample;

/**
 * Obstacle dans un niveau.
 *
 * Lorsque le joueur entre en collision avec un obstacle, la partie est
 * terminée.
 */
public abstract class Obstacle extends LevelElement {

    protected int color;

    public Obstacle(double x, double y) {
        super(x, y);
    }

    public Obstacle() {
        super();
    }


    public int getColor(){
        return 0;
    }
    @Override
    /**
     * Gestion de la collision entre le joueur et l'obstacle
     *
     * @param player Le joueur
     * @param game La partie en cours
     */
    public void handleCollision(Player player, Game game) {
        game.loose();
    }
}
