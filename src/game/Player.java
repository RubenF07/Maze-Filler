package game;

import static game.Main.direction;

public class Player
{
    private LinkedChain<Coordinate> moves;

    public Player()
    {
        moves = new LinkedChain<>();
        // TODO
    }


    public boolean move(direction dir)
    {
        // TODO
        return false;
    }


    public Coordinate getPosition()
    {
        return moves.peek();
    }
}
