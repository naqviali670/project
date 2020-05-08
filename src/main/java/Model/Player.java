package Model;

import org.tinylog.Logger;

public class Player implements Comparable<Player> {

    private String name;
    private String Assignedname;
    private int wins;
    private int turns;
    public Player(String name, String assignedName)
    {
        this.name=name;
        this.Assignedname=assignedName;
        Logger.info("{} has {} assigned name",getName(),getAssignedname());
    }

    public String getName() {
        return name;
    }

    public String getAssignedname() {
        return Assignedname;
    }

    public void setWins(int wins) {
        this.wins = this.wins + wins;
    }

    public int getWins() {
        return wins;
    }

    public void TurnCalculator(int turns) {
        this.turns = this.turns + turns;
    }

    public int getTurns() {
        return turns;
    }




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
        final Player other = (Player) obj;

        if (!this.getName().equals(other.getName())) {
            return false;
        }

        return true;
    }


    public int compareTo(Player o) {
        return -1*(this.getWins()-o.getWins());
    }



}
