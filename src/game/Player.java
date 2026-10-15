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
        // TODO
    }


    public void move(direction dir)
    {
        // TODO
    }
    
    public boolean canUndo() {
        // Probably display a message before returning false
        // No message needed for true - the move will be undone
        // TODO
        return false;
    }
    
    public void undoMove() {
        
        // TODO
    }


    public Coordinate getPosition()
    {
        return moves.peek();
    }
}
