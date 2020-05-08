package Control;

import State.Game;
import State.Player;
import State.StoreData;
import javafx.scene.control.TextField;

public class PlayerAndGameCreator {
     static private Player p1;
     static private Player p2;
     static private Game g;
    public static void playerCreator(TextField player1 , TextField player2){
         p1 = new Player(player1.getText(),"X");
         p2 = new Player(player2.getText(),"O");
    }
    public static void gameCreator(){
        g = new Game(p1 , p2);

    }

    public static Player getP1() {
        return p1;
    }

    public static Player getP2() {
        return p2;
    }

    public static Game getGame() {
        return g;
    }
    public static void Winner(String name){
        g.setWinner(name);
    }
}
