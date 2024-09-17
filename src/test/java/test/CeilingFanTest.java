package test;

import main.Fan;
import main.CeilingFan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CeilingFanTest {

    @Test
    public void whenCeilingFanIsInitiated_thenExpectZeroSpeedAndClockwiseDirection() {
        CeilingFan fan = new CeilingFan();
        assertEquals(0, fan.getCurrentSpeed(), "Initial speed should be 0");
        assertEquals(Fan.Direction.CLOCKWISE, fan.getCurrentDirection(), "Initial direction should be forward");
        assertFalse(fan.isRunning(), "Fan is in OFF state");
    }

    @Test
    public void whenIncreasedSpeed_thenExpectSpeedIncreasesFrom1To3AndOff() {
        CeilingFan fan = new CeilingFan();

        fan.increaseSpeed();
        assertEquals(1, fan.getCurrentSpeed(), "Speed should be 1 after first speed change");
        assertTrue(fan.isRunning(), "Fan is in ON state");

        fan.increaseSpeed();
        assertEquals(2, fan.getCurrentSpeed(), "Speed should be 2 after second speed change");
        assertTrue(fan.isRunning(), "Fan is in ON state");

        fan.increaseSpeed();
        assertEquals(3, fan.getCurrentSpeed(), "Speed should be 3 after third speed change");
        assertTrue(fan.isRunning(), "Fan is in ON state");

        fan.increaseSpeed();
        assertEquals(0, fan.getCurrentSpeed(), "Speed should return to 0 after fourth speed change");
        assertFalse(fan.isRunning(), "Fan is in OFF state");
    }

    @Test
    public void whenDirectionIsFlipped_thenExpectDirectionChangesFromClockwiseToAnticlockwiseAndViceVersa() {
        CeilingFan fan = new CeilingFan();

        fan.flipDirection();
        assertEquals(Fan.Direction.ANTICLOCKWISE, fan.getCurrentDirection(), "Direction set to true");

        fan.flipDirection();
        assertEquals(Fan.Direction.CLOCKWISE, fan.getCurrentDirection(), "Direction set to false");
    }

    @Test
    public void whenDirectionAndSpeedAreChangedSimultaneously_thenExpectSpeedGoesMaximumTo3AndOffAndDirectionFlipsClockwiseAndAntiClockwise() {
        CeilingFan fan = new CeilingFan();

        assertFalse(fan.isRunning(), "Fan is in OFF state");

        fan.increaseSpeed();
        fan.flipDirection();

        assertEquals(1, fan.getCurrentSpeed(), "Speed should be 1 after first speed change");
        assertEquals(Fan.Direction.ANTICLOCKWISE, fan.getCurrentDirection(), "Direction should be reversed after first direction change");
        assertTrue(fan.isRunning(), "Fan is in ON state");

        fan.increaseSpeed();
        assertEquals(2, fan.getCurrentSpeed(), "Speed should be 2 after second speed change");
        assertEquals(Fan.Direction.ANTICLOCKWISE, fan.getCurrentDirection(), "Direction should still be reversed");

        fan.flipDirection();
        assertEquals(2, fan.getCurrentSpeed(), "Speed should still be 2");
        assertEquals(Fan.Direction.CLOCKWISE, fan.getCurrentDirection(), "Direction should now be changed to forward");
        assertTrue(fan.isRunning(), "Fan is in ON state");

        fan.increaseSpeed();
        fan.increaseSpeed();

        assertFalse(fan.isRunning(), "Fan is in OFF state");
    }
}
