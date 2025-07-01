import java.awt.*;

public class Management {
    public static Object[] getQuickestElevator(Building building, int taskPosY) {
        Elevator quickestElv = null;
        double minTime = Double.POSITIVE_INFINITY;

        for (Elevator elv : building.elevators) {
            if (elv.getLastTask() == taskPosY && elv.getSuspendingInFloor() == 2) {
                return new Object[]{elv, 0.0};
            } else if (elv.getLastTask() == taskPosY) {
                return null;
            } else {
                double currentTaskTime = elv.getCurrentTaskTime(taskPosY);
                double elvTasksTime = elv.getTasksTime();
                if (elvTasksTime + currentTaskTime < minTime) {
                    quickestElv = elv;
                    minTime = elvTasksTime + currentTaskTime;
                }
            }
        }
        return new Object[]{quickestElv, minTime};
    }

    public static void isButtonClicked(Building building, Point clickPos) {
        Floor floorClicked = building.isSomeButtonClicked(clickPos);
        if (floorClicked != null && !floorClicked.isElvOnTheWay) {
            Object[] quickestElvAndTime = getQuickestElevator(building, floorClicked.pos.y);
            if (quickestElvAndTime != null) {
                Elevator quickestElv = (Elevator) quickestElvAndTime[0];
                floorClicked.floorTimer = (double) quickestElvAndTime[1];
                quickestElv.addElevatorTask(floorClicked.pos.y);
            }
        }
    }

    private Management() {
    }
}
