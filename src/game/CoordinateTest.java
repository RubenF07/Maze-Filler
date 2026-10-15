package game;

import junit.framework.TestCase;

public class CoordinateTest
    extends TestCase
{
    private Coordinate coord;

    public void setUp()
    {
        coord = new Coordinate(5, 8);
    }
    
    public void testGet() {
        assertEquals(5, coord.getX());
        assertEquals(8, coord.getY());
    }
}
