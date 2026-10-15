package game;

import junit.framework.TestCase;
import static game.Main.direction;


public class PlayerTest
    extends TestCase
{
    private Player player;

    protected void setUp()
    {
        player = new Player(new Coordinate(1, 1));
    }


    public void testMove()
    {
        assertFalse(player.canUndo());
        player.move(direction.UP);
        assertTrue(player.canUndo());
        
        Coordinate coord = player.getPosition();
        
        assertEquals(1, coord.getX());
        assertEquals(2, coord.getY());
    }
}
