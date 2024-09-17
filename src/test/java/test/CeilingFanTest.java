package test;

import main.CeilingFan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeilingFanTest {

    @Test
    public void whenCheckingInitialState_returnInitialState() {
        CeilingFan fan = new CeilingFan();
        assertEquals(0, fan.getCurrentSpeed(), "Initial speed should be 0");
        assertFalse(fan.getCurrentDirection(), "Initial direction should be forward");
    }

    @Test
    public void whenSpeedChangeOccur_thenSpeedChangesAsExpected() {
        CeilingFan fan = new CeilingFan();

        fan.speedChange();
        assertEquals(1, fan.getCurrentSpeed(), "Speed should be 1 after first speed change");

        fan.speedChange();
        assertEquals(2, fan.getCurrentSpeed(), "Speed should be 2 after second speed change");

        fan.speedChange();
        assertEquals(3, fan.getCurrentSpeed(), "Speed should be 3 after third speed change");

        fan.speedChange();
        assertEquals(0, fan.getCurrentSpeed(), "Speed should return to 0 after fourth speed change");
    }

    @Test
    public void whenDirectionReversed_thenDirectionStatusIsUpdated() {
        CeilingFan fan = new CeilingFan();

        fan.setDirection();
        assertTrue(fan.getCurrentDirection(), "Direction set to true");

        fan.setDirection();
        assertFalse(fan.getCurrentDirection(), "Direction set to false");
    }

    @Test
    public void whenDirectionAndSpeedAreChangedSimultaneously_thenTheActionsAreAsExpected() {
        CeilingFan fan = new CeilingFan();

        fan.speedChange();
        fan.setDirection();

        assertEquals(1, fan.getCurrentSpeed(), "Speed should be 1 after first speed change");
        assertTrue(fan.getCurrentDirection(), "Direction should be reversed after first direction change");

        fan.speedChange();
        assertEquals(2, fan.getCurrentSpeed(), "Speed should be 2 after second speed change");
        assertTrue(fan.getCurrentDirection(), "Direction should still be reversed");

        fan.setDirection();
        assertEquals(2, fan.getCurrentSpeed(), "Speed should still be 2");
        assertFalse(fan.getCurrentDirection(), "Direction should now be changed to forward");
    }
}