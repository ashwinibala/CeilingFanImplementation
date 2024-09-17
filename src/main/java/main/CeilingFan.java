package main;

public class CeilingFan {

    private int speedControl;
    private boolean direction;

    public CeilingFan() {
        this.speedControl = 0;
        this.direction = false; // false is forward and true is reverse
    }

    public void speedChange() {
        if(speedControl == 3) {
            speedControl = 0;
        } else {
            speedControl++;
        }
    }

    public void setDirection() {
        direction = !direction;
    }

    public int getCurrentSpeed() {
        return speedControl;
    }

    public boolean getCurrentDirection() {
        return direction;
    }

    public static void main(String[] args) {

    }
}
