package Sample;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Player sur l'écran en dessinant un cercle coloré
 */
public class PlayerRenderer extends Renderer {

    private Player player;

    public PlayerRenderer(Player player) {
        this.player = player;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = computeScreenY(level, player.getY());

        context.setFill(convertColor(player.getColor()));

        context.fillOval(
                player.getX() - player.getRadius(),
                canvasY - player.getRadius(),
                2 * player.getRadius(),
                2 * player.getRadius());
    }
}
