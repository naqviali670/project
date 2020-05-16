package Model;

import Control.PlayerAndGameCreator;
import javafx.scene.control.Button;
import org.tinylog.Logger;

/**
 * GameRules represets the model class that has the business logic of the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class GameRules {
    private PlayerAndGameCreator pagc;
    private int count = 0;
    TurnSet ts;

    /**
     * To set TurnSet class Object inside GameRules.
     *
     * @param t TurnSet Object
     */
    public void setTurnSet(TurnSet t) {
        ts = t;
    }

    /**
     * To set PlayerAndGameCreator class object inside GameRules.
     *
     * @param p PlayerAndGameCreator object
     */
    public void setPlayerAndGameCreator(PlayerAndGameCreator p) {
        pagc = p;
    }

    /**
     * To set total cells filled at a particular stage of the game
     *
     * @param count Counter to count how much cells are filled at one stage of the game.
     */
    public void setCount(int count) {
        this.count = this.count + count;
    }

    /**
     * To get the total cells filled at a particular stage of the game
     *
     * @return Total cells filled at a particular stage of the game
     */
    public int getCount() {
        return count;
    }

    /**
     * To assign rules to every cell of the board.
     *
     * @param b  Button array
     * @param r1 row number of the button
     * @param c1 column number of the button
     * @throws Exception when player clicks the cell, that is already filled
     */
    public void GridRules(Button[][] b, int r1, int c1) throws Exception {
        int row = r1, col = c1;
        boolean found = false;
        if (b[row][col].getText() == "X" || b[row][col].getText() == "O") {
            throw new Exception();
        }

        String c = "";
        try {
            if (ts.getTurn() == 1) {
                c = "X";
                Logger.info("{}'s turn", pagc.getP1().getName());
            } else {
                c = "O";
                Logger.info("{}'s turn", pagc.getP2().getName());
            }
        } catch (NullPointerException n) {

        }

        int count = 0;

        if (row == 0 && col == 0) {
            b[row][col].setText(c);
            count++;
            if (b[row][col + 1].getText() == "") {
                b[row][col + 1].setText(c);
                count++;

            }

            if (b[row + 1][col].getText() == "") {
                b[row + 1][col].setText(c);
                count++;
            }

        } else if (row == 0 && col == 5) {
            b[row][col].setText(c);
            count++;
            if (b[row][col - 1].getText() == "") {
                b[row][col - 1].setText(c);
                count++;
            }

            if (b[row + 1][col].getText() == "") {
                b[row + 1][col].setText(c);
                count++;
            }

        } else if (row == 5 && col == 0) {
            b[row][col].setText(c);
            count++;
            if (b[row][col + 1].getText() == "") {
                b[row][col + 1].setText(c);
                count++;
            }

            if (b[row - 1][col].getText() == "") {
                b[row - 1][col].setText(c);
                count++;
            }

        } else if (row == 5 && col == 5) {
            b[row][col].setText(c);
            count++;
            if (b[row][col - 1].getText() == "") {
                b[row][col - 1].setText(c);
                count++;
            }
            if (b[row - 1][col].getText() == "") {
                b[row - 1][col].setText(c);
                count++;
            }

        } else if (row == 0) {
            b[row][col].setText(c);
            count++;
            if (b[row][col - 1].getText() == "") {
                b[row][col - 1].setText(c);
                count++;
            }

            if (b[row + 1][col].getText() == "") {
                b[row + 1][col].setText(c);
                count++;
            }

            if (b[row][col + 1].getText() == "") {
                b[row][col + 1].setText(c);
                count++;
            }

        } else if (row == 5) {
            b[row][col].setText(c);
            count++;
            if (b[row][col - 1].getText() == "") {
                b[row][col - 1].setText(c);
                count++;
            }

            if (b[row - 1][col].getText() == "") {
                b[row - 1][col].setText(c);
                count++;
            }

            if (b[row][col + 1].getText() == "") {
                b[row][col + 1].setText(c);
                count++;
            }
        } else if (col == 0) {
            b[row][col].setText(c);
            count++;
            if (b[row][col + 1].getText() == "") {
                b[row][col + 1].setText(c);
                count++;
            }
            if (b[row - 1][col].getText() == "") {
                b[row - 1][col].setText(c);
                count++;
            }

            if (b[row + 1][col].getText() == "") {
                b[row + 1][col].setText(c);
                count++;
            }

        } else if (col == 5) {
            b[row][col].setText(c);
            count++;
            if (b[row][col - 1].getText() == "") {
                b[row][col - 1].setText(c);
                count++;
            }

            if (b[row - 1][col].getText() == "") {
                b[row - 1][col].setText(c);
                count++;
            }

            if (b[row + 1][col].getText() == "") {
                b[row + 1][col].setText(c);
                count++;
            }

        } else {
            b[row][col].setText(c);
            count++;
            if (b[row][col - 1].getText() == "") {
                b[row][col - 1].setText(c);
                count++;
            }

            if (b[row - 1][col].getText() == "") {
                b[row - 1][col].setText(c);
                count++;
            }

            if (b[row + 1][col].getText() == "") {
                b[row + 1][col].setText(c);
                count++;
            }

            if (b[row][col + 1].getText() == "") {
                b[row][col + 1].setText(c);
                count++;
            }

        }
        try {
            if (ts.getTurn() == 1) {
                ts.setTurn(2);
                pagc.getP1().TurnCalculator(1);
            } else {
                ts.setTurn(1);
                pagc.getP2().TurnCalculator(1);
            }
        } catch (NullPointerException n) {

        }
        setCount(count);
    }

}
