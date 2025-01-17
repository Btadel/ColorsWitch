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


/**
 * Classe principale. Définit la vue.
 */
public class ColorsWitch extends Application {

    public static final double WIDTH = 320, HEIGHT = 480;
    public boolean pressTab;

    private Controller controller;
    private GraphicsContext context;
    private Square square;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Pane root = new Pane(canvas);

        context = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime;

            @Override
            public void handle(long now) {
                controller.tick((now - lastTime) * 1e-9);

                context.setFill(Color.BLACK);
                context.fillRect(0, 0, WIDTH, HEIGHT);

                List<Entity> entities = controller.getEntities();

                for (Entity e : entities) {
                    Renderer r = e.getRepresentation();
                    if (r != null) {
                        r.draw(controller.getCurrentLevel(), context);
                    }
                }

                lastTime = now;
            }
        };
        timer.start();

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                controller.spaceTyped();
            }
            else if (event.getCode() == KeyCode.TAB){
                pressTab = !pressTab;
                if (pressTab){
                    controller.testMode(true);
                }
                else{
                   controller.testMode(false);
                }
            }
        });

        primaryStage.setTitle("Colors Witch");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
