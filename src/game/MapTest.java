package game;

import junit.framework.TestCase;
import static game.Main.direction;
import java.io.FileNotFoundException;

public class MapTest
    extends TestCase
{
    private Map map;

    public void testImport()
    {
        Exception fail = null;

        try
        {
            map = new Map("mapqq.txt");
        }
        catch (FileNotFoundException e)
        {
            fail = e;
        }

        assertNotNull(fail);
    }


    public void testGetPlayerStart()
    {
        Exception pass = null;

        try
        {
            map = new Map("map1.txt");
        }
        catch (FileNotFoundException e)
        {
            pass = e;
        }

        assertNull(pass);

        Coordinate coord = map.getPlayerStart();

        assertEquals(1, coord.getX());
        assertEquals(1, coord.getY());
    }


    public void testHasWon()
    {
        Exception pass = null;

        try
        {
            map = new Map("map1.txt");
        }
        catch (FileNotFoundException e)
        {
            pass = e;
        }

        assertNull(pass);

        assertFalse(map.hasWon(new Coordinate(5, 5)));
    }
}
