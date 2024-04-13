package Sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
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

/**
 * Item : champignon.
 * Ramasser un champignon permet de gagner le niveau actuel
 */
public class Mushroom extends Item {
    private double deltaTime = 0;

    public Mushroom(double x, double y) {
        super(x, y);

        this.renderer = new AnimationRenderer("mushroom_animation", 26, 20, this);
    }
    public double getDeltaTime(){
        return deltaTime;
    }
    @Override
    public void tick(double dt) {
      deltaTime += dt;
    }

    @Override
    public double getWidth() {
        return 64;
    }

    @Override
    public double getHeight() {
        return 64;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        game.win();
    }

    @Override
    public boolean intersects(Player player) {
        return player.getX() < this.getX() + this.getWidth() / 2
                && player.getX() > this.getX() - this.getWidth() / 2
                && player.getY() < this.getY() + this.getHeight() / 2
                && player.getY() > this.getY() - this.getHeight() / 2;
    }
}
