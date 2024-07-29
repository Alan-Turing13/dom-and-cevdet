import java.util.ArrayList;
import java.util.List;

public class Compass {
    Point point;
    Direction direction;

    public Point rotate(Point point, Direction direction){
        int currentPointIndex = point.ordinal();
        Point[] pointList = Point.values();
        int updatedPointIndex = 0;

        switch (direction) {
            case Direction.RIGHT -> {
                if (point.equals(Point.WEST)) {
                    updatedPointIndex = currentPointIndex - 3;
                } else {
                    updatedPointIndex = currentPointIndex + 1;
                }
            }

            case Direction.LEFT -> {
                if (point.equals(Point.NORTH)) {
                    updatedPointIndex = currentPointIndex + 3;
                } else {
                    updatedPointIndex = currentPointIndex - 1;
                }

            }
        }
        return pointList[updatedPointIndex];
    }
}
