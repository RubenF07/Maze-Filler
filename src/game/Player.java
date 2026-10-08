package game;

public class Player
{
    private enum direction
    {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

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
