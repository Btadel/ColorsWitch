package Sample;

import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Square en dessinant un carré coloré sur l'écran.
 */
public class SquareRenderer extends Renderer {

    private Square carre;

    public SquareRenderer(Square c) {
        this.carre = c;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = computeScreenY(level, carre.getY());

        context.setFill(convertColor(carre.getColor()));

        context.fillRect(
                carre.getX() - carre.getWidth() / 2,
                canvasY - carre.getWidth() / 2,
                carre.getWidth(),
                carre.getWidth());
    }
}
