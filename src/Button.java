import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.Point;

public class Button {
    private final int floorLevel;
    private final Point pos;
    private Color color;

    public Button(int floorLevel) {
        this.floorLevel = floorLevel;
        pos = new Point(Globals.BUTTON_POS_X, Globals.BASE_BUTTON_POS_Y - (Globals.FLOOR_HEIGHT * this.floorLevel));

    }

    public boolean isButtonClicked(Point clickPos) {
        int x = clickPos.x;
        int y = clickPos.y;
        int bx = pos.x + Globals.BUTTON_SIZE / 2;
        int by = pos.y + Globals.BUTTON_SIZE / 2;
        return Math.pow(Math.pow(x - bx, 2) + Math.pow(y - by, 2), 0.5) <= (double) Globals.BUTTON_SIZE / 2;
    }

    public static void main(String[] args) {
        Button button = new Button(5);
        System.out.print(button.pos);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(pos.x, pos.y, Globals.BUTTON_SIZE, Globals.BUTTON_SIZE);

        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, Globals.FONT_SIZE));
        gc.fillText(String.valueOf(floorLevel), Globals.BUTTON_TEXT_POS_X, pos.y + Globals.BUTTON_TEXT_POS_Y_ON_BUTTON);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
