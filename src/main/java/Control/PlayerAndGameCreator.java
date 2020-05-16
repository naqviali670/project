package Control;

import Model.Game;
import Model.Player1;

/**
 * PlayerAndGameCreator represents a class to create two players and a game for them.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class PlayerAndGameCreator {
    private Player1 p1;
    private Player1 p2;
    private Game g;

    /**
     * To Create 2 new players.
     *
     * @param player1 name of the first player
     * @param player2 name of the second player
     */
    public void playerCreator(String player1, String player2) {

        p1 = new Player1(player1.toLowerCase(), "X");
        p2 = new Player1(player2.toLowerCase(), "O");
    }

    /**
     * To Create a new game with 2 created players
     */
    public void gameCreator() {
        g = new Game(p1, p2);
    }

    /**
     * to get first player
     *
     * @return first player
     */
    public Player1 getP1() {
        return p1;
    }

    /**
     * To get second player.
     *
     * @return second player
     */
    public Player1 getP2() {
        return p2;
    }

    /**
     * To get game created before
     *
     * @return game object
     */
    public Game getGame() {
        return g;
    }

}
