public class BouncingBall {

    private static final int NOT_FULFILLED = -1;
    private static final int FALL_AND_BOUNCE = 2;
    private static final int FALL = 1;
    private final double height;
    private final double bounce;
    private final double window;

    public BouncingBall(double height, double bounce, double window) {
        this.height = height;
        this.bounce = bounce;
        this.window = window;
    }

    public int bouncingBall() {
        return areAllConditionsFullFilled() ? howManyTimesWillTheMotherSeeTheBall() : NOT_FULFILLED;
    }

    private int howManyTimesWillTheMotherSeeTheBall() {
        int seen = 0;
        for (double rebound = height; rebound > window; rebound *= bounce)
            seen += see(rebound);

        return seen;
    }

    private int see(double rebound) {
        return isTheBallBounceGreaterThanWindow(rebound) ? FALL_AND_BOUNCE : FALL;
    }

    private boolean isTheBallBounceGreaterThanWindow(double rebound) {
        return rebound * bounce > window;
    }

    private boolean areAllConditionsFullFilled() {
        return isHeightGreaterThanZero() && isaBounceGreaterThanZeroAndLessThanOne() && isWindowParamLessThanHeight();
    }

    private boolean isHeightGreaterThanZero() {
        return height > 0;
    }

    private boolean isWindowParamLessThanHeight() {
        return window < height;
    }

    private boolean isaBounceGreaterThanZeroAndLessThanOne() {
        return bounce > 0 || bounce < 1;
    }
}
