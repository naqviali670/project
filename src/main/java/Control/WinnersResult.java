package Control;

import Model.Player1;
import Model.StoreData;

import java.util.ArrayList;

/**
 * WinnerResult represents a controller class to evaluate top 5 winners of the game.
 * It is for the Scene3 view class
 */
public class WinnersResult {
    private StoreData sd = new StoreData();
    private ArrayList<Player1> players = new ArrayList<>();

    /**
     * To get top 5 winners of the game
     *
     * @return Top 5 winners of the game in the form of ArrayList
     */
    public ArrayList<Player1> getWinners() {
        int i = 0;
        for (Player1 p : sd.getPlayer()) {
            if (i == 5) {
                break;
            }
            players.add(i, p);
            i++;
        }
        return players;
    }
}
