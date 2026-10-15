package game;

import static game.Main.direction;

public class Player
{
    private LinkedChain<Coordinate> moves;
    private Coordinate position;

    public Player(Coordinate start)
    {
        moves = new LinkedChain<>();
        position = start;
    }


    public void move(direction dir)
    {
        int xDiff = 0;
        int yDiff = 0;
        switch (dir) {
            case RIGHT:
                xDiff = 1;
                break;
            case LEFT:
                xDiff = -1;
                break;
            case UP:
                yDiff = 1;
                break;
            case DOWN:
                yDiff = -1;
                break;
        }
        
        moves.add(position);
        position = new Coordinate(position.getX()+xDiff, position.getY()+yDiff);
    }
    
    public boolean canUndo() {
        if (moves.isEmpty()) {
            System.out.println("Invalid operation, no more past moves");
            return false;
        }
        return true;
    }
    
    public void undoMove() {
        position = moves.remove();
    }


    public Coordinate getPosition()
    {
        return position;
    }
}
