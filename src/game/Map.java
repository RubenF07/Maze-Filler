package game;

import static game.Main.direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private enum mapElement {
        TILE_OFF, TILE_ON, WALL, PLAYER_TEMP;
    }

    private mapElement[][] map;
    private LinkedChain<TileState> tiles;
    
    private Coordinate startPos;

    public Map(String firstMapFile) throws FileNotFoundException {
        tiles = new LinkedChain<>();
        try{
            importMap(firstMapFile);
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }


    public boolean hasWon() {
        // TODO
        return false;
    }


    public boolean canMove(Coordinate start, direction dir) {
        int xDiff = 0;
        int yDiff = 0;
        switch (dir) {
            case RIGHT:
                xDiff = 1;
            case LEFT:
                xDiff = -1;
            case UP:
                yDiff = 1;
            case DOWN:
                yDiff = -1;
        }
        mapElement try_tile = map[start.getY() + yDiff][start.getX() + xDiff];
        return (try_tile == mapElement.TILE_OFF
            || try_tile == mapElement.TILE_ON);
    }


    public boolean undoMove() {

        return false;
    }


    public void importMap(String fileName) throws FileNotFoundException {
        File mapFile = new File(fileName);

        try (Scanner reader = new Scanner(mapFile)) {

            int row = 0;

            while (reader.hasNextLine()) {
                String row_text = reader.nextLine();

                // Initialize map
                if (map == null) {
                    int side = row_text.length();
                    map = new mapElement[side][side];
                }

                for (int col = 0; col < row_text.length(); col++) {
                     mapElement e = parseMapElement(row_text.substring(col, col + 1));
                     
                     if(e == mapElement.PLAYER_TEMP) {
                         startPos= new Coordinate(col,row);
                     }
                     
                     map[row][col] = e;
                }
                row++;
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }


    public String toString() {
        // TODO
        return null;
    }


    private mapElement parseMapElement(String str) {
        switch (str) {
            case "#":
                return mapElement.WALL;
            case " ":
                return mapElement.TILE_OFF;
            case "P":
                return mapElement.PLAYER_TEMP;
        }
        throw new Error("Invalid Map Element");

    }
    
    public Coordinate getPlayerStart() {
        return startPos;
    }
}
