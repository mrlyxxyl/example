package flappybird;

public interface Parameter {
    public static final int BIRD_X = 150;
    public static final int BIRD_Y = 300;
    public static final int BIRD_WIDTH = 37;
    public static final int BIRD_HEIGHT = 29;

    public static final int BARRIER_WIDTH = 80;
    public static final int BARRIER_HEIGHT = 80;

    public static final int ROWS_COUNT = 9;
    public static final int COLUMNS_COUNT = 8;

    public static final int TITLE_BAR_HEIGHT = 25; // 由getInsets().top得到的标题栏高度
    public static final int SCREEN_WIDTH = BARRIER_WIDTH * COLUMNS_COUNT;
    public static final int SCREEN_HEIGHT = TITLE_BAR_HEIGHT + BARRIER_HEIGHT * ROWS_COUNT;
    public static final int SCREEN_WIDTH_HALF = BARRIER_WIDTH * (COLUMNS_COUNT / 2);

    public static final int GROUND_WIDTH = SCREEN_WIDTH;
    public static final int GROUND_HEIGHT = BARRIER_HEIGHT;

}
