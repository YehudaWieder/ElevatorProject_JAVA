public class Globals {

    /*users input*/
    public static final int NUMBER_OF_FLOORS = 20;
    public static final int NUMBER_OF_ELEVATORS = 3;

    /*General*/
    public static final int ELEVATOR_VELOCITY = 160;

    /* files paths */
    public static final String ELV_ING_PATH = "/images/elv.png";
    public static final String ACTIVE_ELV_ING_PATH = "images/active_elv.png";
    public static final String FLOOR_IMG_PATH = "/images/floor.jpg";
    public static final String DING_FILE_PATH = "/sounds/ding.mp3";

    /*sizes*/
    public static final int MARGIN = 8;
    public static final int BUTTON_SIZE = 35;
    public static final int FONT_SIZE = 20;
    public static final int FLOOR_SPACER_HEIGHT = 5;
    public static final int ELEVATOR_WIDTH = 65;
    public static final int ELEVATOR_HEIGHT = 70;
    public static final int FLOOR_WIDTH = 150;
    public static final int FLOOR_HEIGHT = 80;
    public static final int SCREEN_WIDTH = Math.max(500, 280 + ELEVATOR_WIDTH * NUMBER_OF_ELEVATORS);
    public static final int SCREEN_HEIGHT = 650;
    public static final int ENVIRONMENT_WIDTH = SCREEN_WIDTH;
    public static final int ENVIRONMENT_HEIGHT = Math.max(SCREEN_HEIGHT, 3 * MARGIN + NUMBER_OF_FLOORS * FLOOR_HEIGHT);
    public static final int TIMER_BOX_WIDTH = 90;
    public static final int TIMER_BOX_HEIGHT = 40;
    public static final int TIMER_BOX_ROUND = 40;

    /*positions*/
    public static final int BUTTON_POS_X = MARGIN + FLOOR_WIDTH / 2 - BUTTON_SIZE / 2;
    public static final int BUTTON_TEXT_POS_X = BUTTON_POS_X + 5;
    public static final int BUTTON_TEXT_POS_Y_ON_BUTTON = 25;
    public static final int BASE_BUTTON_POS_Y = ENVIRONMENT_HEIGHT - FLOOR_HEIGHT / 2 - MARGIN - BUTTON_SIZE / 2;
    public static final int FLOOR_POS_X = MARGIN;
    public static final int GROUND_FLOOR_POS_Y = ENVIRONMENT_HEIGHT - FLOOR_HEIGHT - MARGIN;
    public static final int BASE_ELEVATOR_POS_X = MARGIN + FLOOR_WIDTH;
    public static final int BASE_ELEVATOR_POS_Y = ENVIRONMENT_HEIGHT - FLOOR_HEIGHT - MARGIN;
    public static final int TIMER_BOX_POS_X = FLOOR_POS_X + 6;
    public static final int TIMER_BOX_POS_Y_ON_FLOOR = 20;
    public static final int TIMER_TEXT_POS_X = TIMER_BOX_POS_X + 4;
    public static final int TIMER_TEXT_POS_Y_ON_FLOOR = 48;

    private Globals() {
    }
}


