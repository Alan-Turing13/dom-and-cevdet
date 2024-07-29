import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {
    Compass compass;

    @BeforeEach
    void setUp(){
         compass = new Compass();
    }

    @Test
    @DisplayName("rotates a given point according to a given direction")
    void testRotate() {
        Point currentP = compass.rotate(Point.NORTH, Direction.RIGHT);
        assertEquals(Point.EAST, currentP);
    }

    @Test
    @DisplayName("rotating right")
    void testRotateRight() {
        assertAll(
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        assertEquals(Point.EAST, compass.rotate(Point.NORTH, Direction.RIGHT));
                    }
                },
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        assertEquals(Point.EAST, compass.rotate(Point.NORTH, Direction.RIGHT));
                    }
                },
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        assertEquals(Point.WEST, compass.rotate(Point.SOUTH, Direction.RIGHT));
                    }
                },
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        assertEquals(Point.NORTH, compass.rotate(Point.WEST, Direction.RIGHT));
                    }
                }
        );

    }

    private void assertAll(Point rotate, Point rotate1, Point rotate2, Point rotate3) {
    }
}