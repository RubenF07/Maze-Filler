package game;

public class TileState {
    private boolean state;
    
    public TileState() {
        state = false;
    }
    
    public boolean getState() {
        return state;
    }
    
    public void toggle() {
        state = !state;
    }
}
