package game;

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
