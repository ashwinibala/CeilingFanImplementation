package main;

public interface Fan {

    enum Direction {
        CLOCKWISE, ANTICLOCKWISE
    }

    /**
     * Increases the speed of the fan by one unit till max speed and then to off.
     *
     * @param - none
     * @return - none
     */
    void increaseSpeed();

    /**
     * Flips Direction of the fan.
     *
     * @param - none
     * @return - none
     */
    void flipDirection();

    /**
     * Fetch the current speed of the fan.
     *
     * @param - none
     * @return - current speed of the fan.
     */
    int getCurrentSpeed();

    /**
     * Fetch the current direction of the fan.
     *
     * @param - none
     * @return - DIRECTION
     */
    Direction getCurrentDirection();

    /**
     * Fetch whether the fan is ON / OFF
     *
     * @param - none
     * @return - boolean
     */
    boolean isRunning();
}
