package Model;

import org.tinylog.Logger;

import java.util.ArrayList;

public class StoreData {
    private static ArrayList<Game> game = new ArrayList<Game>();
    private static ArrayList<Player> player = new ArrayList<Player>();

    public static void setGame(Game game) {
        StoreData.game.add(game);
        Logger.info("Game data has been stored successfully!");
    }

    public static void setPlayer(Player player) {
        boolean found = false;
        for(Player p : StoreData.player)
        {
            if(p.equals(player)==true)
            {
                found = true;
            }
        }
        if(found == false)
        StoreData.player.add(player);
    }

    public static ArrayList<Game> getGame() {
        return game;
    }

    public static ArrayList<Player> getPlayer() {
        return player;
    }
}
