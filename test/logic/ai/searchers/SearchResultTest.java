package logic.ai.searchers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchResultTest {

    @Test
    void SearchResult_Valid_Object_Should_Be_Created() {
        Point point = new Point(3,5);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);

        Assertions.assertNotEquals(result, null);
    }

    @Test
    void getScore_Valid_Should_Return_Integer_MAX_VALUE() {
        Point point = new Point(3,5);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);

        Assertions.assertEquals(result.getScore(), Integer.MAX_VALUE);
    }

    @Test
    void getPoint_Valid_Should_Be_Null() {
        SearchResult result = new SearchResult(null, Integer.MAX_VALUE);

        assertNull(result.getPoint());
    }

    @Test
    void getPoint_Valid_Should_Not_Be_Null() {
        int x = 3;
        int y = 5;
        Point point = new Point(x,y);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);

        Assertions.assertNotEquals(result.getPoint(), null);
    }

    @Test
    void getPoint_Valid_X_Should_Be_3() {
        int x = 3;
        int y = 5;
        Point point = new Point(x,y);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);

        Assertions.assertEquals(result.getPoint().x, x);
    }

    @Test
    void getPoint_Valid_Y_Should_Be_5() {
        int x = 3;
        int y = 5;
        Point point = new Point(x,y);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);

        Assertions.assertEquals(result.getPoint().y, y);
    }

    @Test
    void negated_Valid_Point_Should_Be_Null() {
        SearchResult result = new SearchResult(null, Integer.MAX_VALUE);
        SearchResult temp = result.negated();

        assertNull(temp.getPoint());
    }

    @Test
    void negated_Valid_Should_Be_Same_Point_X() {
        int x = 3;
        int y = 5;
        Point point = new Point(x,y);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);
        SearchResult temp = result.negated();

        Assertions.assertEquals(result.getPoint().x, temp.getPoint().x);
    }

    @Test
    void negated_Valid_Should_Be_Same_Point_Y() {
        int x = 3;
        int y = 5;
        Point point = new Point(x,y);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);
        SearchResult temp = result.negated();

        Assertions.assertEquals(result.getPoint().y, temp.getPoint().y);
    }

    @Test
    void negated_Valid_Should_Be_Opposite_Number() {
        int x = 3;
        int y = 5;
        Point point = new Point(x,y);
        SearchResult result = new SearchResult(point, Integer.MAX_VALUE);
        SearchResult temp = result.negated();

        Assertions.assertEquals(-result.getScore(), temp.getScore());
    }
}