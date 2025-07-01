import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

import java.awt.*;

public class Main extends Application {

    private Building myBuikding = new Building(Globals.NUMBER_OF_FLOORS, Globals.NUMBER_OF_ELEVATORS);

    @Override
    public void start(Stage stage) {
        Canvas screen = new Canvas(Globals.ENVIRONMENT_WIDTH, Globals.ENVIRONMENT_HEIGHT);

        screen.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                double x = event.getX();
                double y = event.getY();
                Point clickPos = new Point((int) x, (int) y);
                Management.isButtonClicked(myBuikding, clickPos);
            }
        });

        GraphicsContext gc = screen.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate > 0) {
                    double deltaTime = (now - lastUpdate) / 1_000_000_000.0;
                    draw(deltaTime, gc);
                }
                lastUpdate = now;
            }
        };
        timer.start();

        ScrollPane scrollPane = new ScrollPane(screen);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        stage.setTitle("Elevator Simulation");
        stage.setScene(new Scene(scrollPane, Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
        stage.setResizable(false);
        stage.show();
    }

    private void draw(double deltaTime, GraphicsContext gc) {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());  // תיקון כאן
        myBuikding.update(deltaTime, gc);
    }


    public static void main(String[] args) {
        launch();
    }
}
