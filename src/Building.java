import javafx.scene.canvas.GraphicsContext;

import java.awt.Point;

public class Building {
    public Floor[] floors;
    public Elevator[] elevators;

    public Building(int floorsNum, int elevatorsNum) {
        floors = new Floor[floorsNum];
        for (int i = 0; i < floorsNum; i++) {
            floors[i] = new Floor(i);
        }
        elevators = new Elevator[elevatorsNum];
        for (int i = 0; i < elevatorsNum; i++) {
            elevators[i] = new Elevator(i);
        }
    }

    public void update(double deltaTime, GraphicsContext gc) {
        for (Floor floor : floors) {
            floor.update(deltaTime);
            floor.draw(gc);
        }

        for (Elevator elv : elevators) {
            elv.update(deltaTime);
            elv.draw(gc);
        }
    }

    public Floor isSomeButtonClicked(Point clickPos) {
        for (Floor floor : floors) {
            if (floor.button.isButtonClicked(clickPos)) {
                return floor;
            }
        }
        return null;
    }
}
