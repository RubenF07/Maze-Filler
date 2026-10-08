package game;

import static game.Main.direction;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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


    public boolean hasWon()
    {
        // TODO
        return false;
    }


    public boolean canMove(Coordinate start, direction dir)
    {
        // TODO
        return false;
    }


    public void importMap(String fileName)
    {
        File mapFile = new File(fileName);

        try (Scanner reader = new Scanner(mapFile))
        {
            while (reader.hasNextLine())
            {
                String row = reader.nextLine();
                // TODO fill map data
            }
        }
        catch (FileNotFoundException e)
        {
            // TODO error handling
        }
    }


    public String toString()
    {
        // TODO
        return null;
    }
}
