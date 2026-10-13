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


    public boolean move(direction dir)
    {
        // TODO
        return false;
    }
    
    public boolean undoMove() {
        
        return false;
    }


    public Coordinate getPosition()
    {
        return moves.peek();
    }
}
