package State;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Game {

        ArrayList<Player> players = new ArrayList<Player>();
        private String winner;
        private LocalTime lt;
        private LocalDate ld;

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }
    public LocalDate getLd() {
        return ld;
    }
    public Game(Player p1, Player p2)
        {
            players.add(p1);
            players.add(p2);
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public void setWinner(String winner) {
            this.winner = winner;
        }

        public String getWinner() {
            return winner;
        }

        public void setLt(LocalTime lt) {
            this.lt = lt;
        }

    public LocalTime getLt() {
        return lt;
    }
}
