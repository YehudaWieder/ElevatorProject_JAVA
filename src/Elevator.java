import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private final Point pos;
    private double preciseY;
    private final Image image = new Image(getClass().getResource(Globals.ELV_ING_PATH).toExternalForm());
    private final Image activeElvImage = new Image(getClass().getResource(Globals.ACTIVE_ELV_ING_PATH).toExternalForm());
    private final AudioClip beepSound = new AudioClip(getClass().getResource(Globals.DING_FILE_PATH).toExternalForm());
    private final Queue<Integer> tasks = new LinkedList<>();
    private int lastTask;
    private double tasksTime;
    private double suspendingInFloor = 2;

    public Elevator(int elevatorNum) {
        pos = new Point(Globals.BASE_ELEVATOR_POS_X + elevatorNum * Globals.ELEVATOR_WIDTH, Globals.BASE_ELEVATOR_POS_Y);
        preciseY = pos.y;
        lastTask = pos.y;
    }

    public void update(double deltaTime) {
        if (tasks.peek() != null) {
            int currentTask = tasks.peek();
            double velocityY = Globals.ELEVATOR_VELOCITY * deltaTime;

            if (pos.y > currentTask) {
                preciseY = Math.max(currentTask, preciseY - velocityY);
            } else if (pos.y < currentTask) {
                preciseY = Math.min(currentTask, preciseY + velocityY);
            } else {
                setSuspendingInFloor(deltaTime);
            }
            pos.y = (int) preciseY;
        }
        tasksTime = Math.max(tasksTime - deltaTime, 0);
    }

    public void draw(GraphicsContext gc) {
        Image img;
        if (tasksTime <= 0) {
            img = image;
        } else {
            img = activeElvImage;
        }
        gc.drawImage(img, pos.x, pos.y, Globals.ELEVATOR_WIDTH, Globals.ELEVATOR_HEIGHT);
    }

    public void addElevatorTask(int newTask) {
        tasks.add(newTask);
        tasksTime += getCurrentTaskTime(newTask) + 2;
        setLastTask(newTask);
    }

    public double getCurrentTaskTime(int newTask) {
        return (double) Math.abs(lastTask - newTask) / Globals.ELEVATOR_VELOCITY;
    }

    public double getTasksTime() {
        return tasksTime;
    }

    public int getLastTask() {
        return lastTask;
    }

    public void setLastTask(int lastTask) {
        this.lastTask = lastTask;
    }

    public double getSuspendingInFloor() {
        return suspendingInFloor;
    }

    private void setSuspendingInFloor(double deltaTime) {
        if (suspendingInFloor == 2) {
            beepSound.play();
        }
        if (suspendingInFloor == 0) {
            suspendingInFloor = 2;
            tasks.remove();
        } else {
            suspendingInFloor = Math.max(suspendingInFloor - deltaTime, 0);
        }
    }
}


