import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}