package Control;

import Model.Player;
import Model.StoreData;
import javafx.scene.control.Label;

import java.util.Collections;

public class Result {
    public int displayResult(Label l[]){
        int i=0;
        for (Player p : StoreData.getPlayer()) {
            if (i == 5) {
                break;
            }
            l[i].setText(p.getName()+" "+p.getWins());

            i++;
        }
        return i;
    }
    public void sortPlayers(){
        Collections.sort(StoreData.getPlayer());
    }
}
