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
    private int sidelength;
    private LinkedChain<TileState> tileHistory;
    
    private Coordinate startPos;

    public Map(String firstMapFile) throws FileNotFoundException {
        tileHistory = new LinkedChain<>();
        try{
            importMap(firstMapFile);
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }


    public boolean hasWon() {
        for(int row = 0;row<sidelength;row++) {
            for(int col=0;col<sidelength;col++) {
                if (map[row][col]==mapElement.TILE_OFF) {
                    return false;
                }
            }
        }
        return true;
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
    
    public void playerMoved(Coordinate oldPos) {
        int row = oldPos.getX();
        int col = sidelength - oldPos.getY() -1;
        

        // Toggle tile and add save state
        if (map[row][col] == mapElement.TILE_OFF) {
            tileHistory.add(new TileState(false));
            map[row][col] = mapElement.TILE_ON;
        }
        else {
            tileHistory.add(new TileState(true));
            map[row][col] = mapElement.TILE_OFF;
        } 
        
    }


    public void undoMove(Coordinate newPos) {
        int row = newPos.getX();
        int col = sidelength - newPos.getY() -1;
        
        if(tileHistory.remove().getState()) {
            map[row][col] = mapElement.TILE_ON;
        }
        else {
            map[row][col] = mapElement.TILE_OFF;
        }
    }


    public void importMap(String fileName) throws FileNotFoundException {
        File mapFile = new File(fileName);

        try (Scanner reader = new Scanner(mapFile)) {

            int row = 0;

            while (reader.hasNextLine()) {
                String row_text = reader.nextLine();

                // Initialize map
                if (map == null) {
                    sidelength = row_text.length();
                    map = new mapElement[sidelength][sidelength];
                }

                for (int col = 0; col < row_text.length(); col++) {
                     mapElement e = parseMapElement(row_text.substring(col, col + 1));
                     
                     if(e == mapElement.PLAYER_TEMP) {
                         startPos= new Coordinate(col,sidelength - row - 1);
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


    public void printMap(Coordinate playerPos) {
        String res = "\n";
        
        for(int row = 0;row<sidelength;row++) {
            for(int col=0;col<sidelength;col++) {
                if(playerPos.getX()==col && playerPos.getY()==(sidelength - row - 1)) {
                    res += "P";
                    continue;
                }
                
                switch(map[row][col]) {
                    case WALL:
                        res += "#";
                    case TILE_ON:
                        res+="🔳";
                    case TILE_OFF:
                        res+="🔲";
                    default:
                        res+="x";
                   
                }
                res+="\n";
            }
        }
        System.out.println(res);
        
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
