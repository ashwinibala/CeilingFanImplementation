package main;

public interface Fan {

    int MAX_SPEED = 3; // Assuming max speed will be 3 as default
    enum Direction {
        CLOCKWISE, ANTICLOCKWISE
    }

    /**
     * Increases the speed of the fan till max speed and then to off.
     * It is not thread safe as it does not have a mechanism at present for seamless parallel updates.
     *
     * @param - none
     * @return - none
     */
    void increaseSpeed();

    /**
     * Flips Direction of the fan.
     * It is not thread safe as it does not have a mechanism at present for seamless parallel updates.
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
