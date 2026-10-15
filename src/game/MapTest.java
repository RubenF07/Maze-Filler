package game;

import junit.framework.TestCase;
import static game.Main.direction;
import java.io.FileNotFoundException;


public class MapTest
    extends TestCase
{
    private Map map;

    public void setUp()
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
    }
    
    public void test() {
        assertFalse(map.hasWon(new Coordinate(5, 5)));
    }
}
