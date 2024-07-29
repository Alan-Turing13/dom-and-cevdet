import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {
    Compass compass;

    @BeforeEach
    void setUp() {
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
        assertAll("rotates the compass point to the right direction",
                () -> assertEquals(Point.EAST, compass.rotate(Point.NORTH, Direction.RIGHT)),
                () -> assertEquals(Point.SOUTH, compass.rotate(Point.EAST, Direction.RIGHT)),
                () -> assertEquals(Point.WEST, compass.rotate(Point.SOUTH, Direction.RIGHT)),
                () -> assertEquals(Point.NORTH, compass.rotate(Point.WEST, Direction.RIGHT)));

    }

    @Test
    @DisplayName("rotating left")
    void testRotateLeft() {
        assertAll("rotates the compass point to the left direction",
                () -> assertEquals(Point.WEST, compass.rotate(Point.NORTH, Direction.LEFT)),
                () -> assertEquals(Point.NORTH, compass.rotate(Point.EAST, Direction.LEFT)),
                () -> assertEquals(Point.EAST, compass.rotate(Point.SOUTH, Direction.LEFT)),
                () -> assertEquals(Point.SOUTH, compass.rotate(Point.WEST, Direction.LEFT)));
    }

}