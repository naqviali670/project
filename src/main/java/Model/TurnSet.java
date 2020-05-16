package Model;

/**
 * TurnSet represents a model class, has functionality to set turn of the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class TurnSet {
    private int turn = 1;

    /**
     * To Set turn.
     *
     * @param t turn
     */
    public void setTurn(int t) {
        turn = t;
    }

    /**
     * To get turn, 1 represents first player turn , 2 represents second player turn
     *
     * @return turn
     */
    public int getTurn() {
        return turn;
    }
}
