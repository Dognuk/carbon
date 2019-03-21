package carbon.util;

/**
 * An ordered pair.
 * 
 * @author Jonathan Redeker
 */
public class Position {

    public int x = 0;
    public int y = 0;

    public Position(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public String toString() {

        return "(" + x + ", " + y + ")";

    }

}