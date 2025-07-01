import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.Point;

public class Floor {
    private final Image image = new Image(getClass().getResource(Globals.FLOOR_IMG_PATH).toExternalForm());
    public final Point pos;
    public final Button button;
    public double floorTimer = 0;
    public boolean isElvOnTheWay = false;

    public Floor(int floorNum) {
        pos = new Point(Globals.FLOOR_POS_X, Globals.GROUND_FLOOR_POS_Y - Globals.FLOOR_HEIGHT * floorNum);
        button = new Button(floorNum);
    }

    public void update(double deltaTime) {
        if (floorTimer > 0) {
            isElvOnTheWay = true;
            floorTimer -= deltaTime;
            button.setColor(Color.ROSYBROWN);
        } else {
            isElvOnTheWay = false;
            floorTimer = 0;
            button.setColor(Color.LIGHTGRAY);
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, pos.x, pos.y, Globals.FLOOR_WIDTH, Globals.FLOOR_HEIGHT);
        gc.setFill(Color.BLACK);
        gc.fillRect(pos.x, pos.y, Globals.FLOOR_WIDTH, Globals.FLOOR_SPACER_HEIGHT);

        if (floorTimer > 0) {
            drawTimer(gc);
        }
        button.draw(gc);
    }

    public void drawTimer(GraphicsContext gc) {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRoundRect(Globals.TIMER_BOX_POS_X, pos.y + Globals.TIMER_BOX_POS_Y_ON_FLOOR, Globals.TIMER_BOX_WIDTH, Globals.TIMER_BOX_HEIGHT,
                Globals.TIMER_BOX_ROUND, Globals.TIMER_BOX_ROUND);
        gc.setFill(Color.BLACK);
        gc.fillText(String.format("%.2f", floorTimer), Globals.TIMER_TEXT_POS_X, pos.y + Globals.TIMER_TEXT_POS_Y_ON_FLOOR);
    }
}
