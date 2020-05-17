package Model;

import org.tinylog.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
/**
 * Player1 represents a single player of the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class Player1 {
    @Id
    private String name;
    private String Assignedname;
    @Column
    private int wins;
    @Transient
    private int turns;

    /**
     * Constructor of Player1, sets name and assigned name of the player
     *
     * @param name         name of the player
     * @param assignedName assigned name of the player in the game
     */
    public Player1(String name, String assignedName) {
        this.name = name;
        this.Assignedname = assignedName;
        Logger.info("{} has {} assigned name", getName(), getAssignedname());
    }

    /**
     * default constructor
     */
    public Player1() {

    }

    /**
     * To get the name of the player
     *
     * @return Name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * To get the assigned name of the player
     *
     * @return Assigned name of the player
     */
    public String getAssignedname() {
        return Assignedname;
    }

    /**
     * To set the total wins of the player.
     *
     * @param wins total wins of the player.
     */
    public void setWins(int wins) {
        this.wins = this.wins + wins;
    }

    /**
     * To get the total wins of the player.
     *
     * @return Total wins of the player.
     */
    public int getWins() {
        return wins;
    }

    /**
     * To calculate or add the total turns of the player in the game.
     *
     * @param turns Total turns of the player in the game.
     */
    public void TurnCalculator(int turns) {
        this.turns = this.turns + turns;
    }

    /**
     * To get total turns of the player in the game.
     *
     * @return Total turns of the player in the game.
     */
    public int getTurns() {
        return turns;
    }

    /**
     * Overrided method to check whether two players are equal on the basis of their names.
     *
     * @param obj object of Object Class.
     * @return true if the players are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player1 other = (Player1) obj;

        if (!this.getName().equals(other.getName())) {
            return false;
        }

        return true;
    }
}
