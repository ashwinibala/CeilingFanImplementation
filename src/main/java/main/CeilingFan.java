package main;

public class CeilingFan implements Fan {

    public static final int MAX_SPEED = 3;
    private int currentSpeed;
    private Direction direction;

    /**
     * Initializing the values for Ceiling Fan
     * The current implementation is not thread safe as it does not have a mechanism at present for seamless parallel updates.
     *
     * @param -
     * currentSpeed - assuming the currentSpeed to be 0 at the start.
     * direction - assuming the direction is CLOCKWISE when the CeilingFan starts.
     */
    public CeilingFan() {
        this.currentSpeed = 0;
        this.direction = Direction.CLOCKWISE;
    }

    @Override
    public void increaseSpeed() {
        currentSpeed = (currentSpeed + 1) % (MAX_SPEED + 1);
    }

    @Override
    public void flipDirection() {
        direction = getCurrentDirection() == Direction.CLOCKWISE ? Direction.ANTICLOCKWISE : Direction.CLOCKWISE;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public Fan.Direction getCurrentDirection() {
        return direction;
    }

    @Override
    public boolean isRunning() {
        return getCurrentSpeed() != 0;
    }

    public static void main(String[] args) {

    }

}
