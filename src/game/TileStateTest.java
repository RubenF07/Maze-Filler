package game;

import junit.framework.TestCase;

public class TileStateTest
    extends TestCase
{
    private TileState tile;

    public void setUp()
    {
        tile = new TileState(false);
    }


    public void testGetState()
    {
        assertFalse(tile.getState());
    }


    public void testToggle()
    {
        tile.toggle();
        assertTrue(tile.getState());
    }
}
