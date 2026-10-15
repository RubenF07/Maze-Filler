package game;

public class TileState
{
    private boolean state;

    public TileState(boolean state)
    {
        this.state = state;
    }


    public boolean getState()
    {
        return state;
    }


    public void toggle()
    {
        state = !state;
    }
}
