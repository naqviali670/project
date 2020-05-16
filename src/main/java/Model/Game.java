package Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * Game represents a single game, one instance of Game represents one single game with 2 created players
 * @author Syed Kausar Ali Naqvi
 */
public class Game {

    @Transient
    ArrayList<Player1> player = new ArrayList<Player1>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column
    private String winner;
    @Column
    private LocalTime lt;
    @Column
    private LocalDate ld;
    @Column
    private int turn1;
    @Column
    private int turn2;
    @Column
    private String player1;
    @Column
    private String player2;

    /**
     * To set date when the game is being played
     *
     * @param ld Date when the game is being played
     */
    public void setLd(LocalDate ld) {
        this.ld = ld;
    }

    /**
     * To set first player of the game
     *
     * @param player1 First player's name of the game
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * To get specific Id of the Game;
     *
     * @return Id of the Game
     */
    public int getID() {
        return ID;
    }

    /**
     * To get first player of the Game
     *
     * @return first player of the Game
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * To get second player of the Game
     *
     * @return second player of the Game
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * To set second player of the game
     *
     * @param player2 Second player's name of the game
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * To get Date when the game is being played
     *
     * @return Date when the game is being played
     */
    public LocalDate getLd() {
        return ld;
    }

    /**
     * Game Constructor, adding both players to ArrayList
     *
     * @param p1 first player object
     * @param p2 second player object
     */
    public Game(Player1 p1, Player1 p2) {
        player.add(0, p1);
        player.add(1, p2);
    }

    /**
     * To get the ArrayList of the two players of the game
     *
     * @return ArrayList of the two players of the game
     */
    public ArrayList<Player1> getPlayer() {
        return player;
    }

    /**
     * To set winner of the game
     *
     * @param winner winner of the game
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * To get the winner of the game
     *
     * @return Winner of the game
     */
    public String getWinner() {
        return winner;
    }

    /**
     * To set the time when the game is being played
     *
     * @param lt Time when the game is being played
     */
    public void setLt(LocalTime lt) {
        this.lt = lt;
    }

    /**
     * To get the time when the game is being played
     *
     * @return Time when the game is being played
     */
    public LocalTime getLt() {
        return lt;
    }

    /**
     * To set total turns, first player played during the game
     *
     * @param turn1 Total turns, first player played during the game
     */
    public void setPlayer1Turn(int turn1) {
        this.turn1 = turn1;
    }

    /**
     * To set total turns, second player played during the game
     *
     * @param turn2 Total turns, second player played during the game
     */
    public void setPlayer2Turn(int turn2) {
        this.turn2 = turn2;
    }
}
