package game;

import static game.Main.direction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private enum mapElement {
        TILE, WALL, PLAYER;
    }

    private mapElement[][] map;
    private LinkedChain<TileState> tiles;

    public Map() {
        tiles = new LinkedChain<>();
        // TODO
    }


    public boolean hasWon() {
        // TODO
        return false;
    }


    public boolean canMove(Coordinate start, direction dir) {
        // TODO
        return false;
    }
    
    public boolean undoMove() {
        
        return false;
    }


    public void importMap(String fileName) throws FileNotFoundException {
        File mapFile = new File(fileName);

        try (Scanner reader = new Scanner(mapFile)) {

            int col = 0;

            while (reader.hasNextLine()) {
                String row = reader.nextLine();

                // Initialize map
                if (map == null) {
                    int side = row.length();
                    map = new mapElement[side][side];
                }

                for (int i = 0; i < row.length(); i++) {
                    map[col][i] = parseMapElement(row.substring(i, i + 1));
                }
                col++;
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
                return mapElement.TILE;
            case "P":
                return mapElement.PLAYER;
        }
        throw new Error("Invalid Map Element");

    }
}
