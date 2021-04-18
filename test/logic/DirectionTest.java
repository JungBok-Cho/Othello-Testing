package logic;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void Direction_next_Valid_ShouldReturnNewPointOnMethodCall() {
        int[][] coordinates = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}, {-1, -1}, {+1, +1}, {+1, -1}, {-1, +1}};
        Direction[] directions = Direction.values();

        Point tempPoint;
        Point directionPoint;

        for (int i = 0; i < coordinates.length; i++) {
            tempPoint = new Point(coordinates[i][0], coordinates[i][1]);
            directionPoint = directions[i].next(new Point(0, 0));

            assertEquals(tempPoint, directionPoint);
        }
    }

    @Test
    void Direction_next_Valid_ShouldReturnNewPointOnMethodCallOnNonZeroStart() {
        Point tempPoint = new Point(10, 10);
        tempPoint = Direction.NORTHWEST.next(tempPoint);
        assertEquals(tempPoint, new Point(9, 9));
    }


}