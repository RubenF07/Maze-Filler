package game;

import static game.Main.direction;

public class Map
{
    private enum mapElement
    {
        TILE,
        WALL;
    }

    private mapElement[][] map;
    private LinkedChain<TileState> tiles;

    public Map()
    {
        tiles = new LinkedChain<>();
        // TODO
    }

    public boolean hasWon() {
        // TODO
        return false;
    }

    public boolean canMove(Coordinate start, direction dir)
    {
        // TODO
        return false;
    }


    public void importMap()
    {
        // TODO
    }


    public String toString()
    {
        // TODO
        return null;
    }
}
