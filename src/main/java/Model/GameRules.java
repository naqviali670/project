package Model;

import Control.GridSetUp;
import Control.PlayerAndGameCreator;
import javafx.scene.control.Button;
import org.tinylog.Logger;

import java.util.ArrayList;

/**
 * GameRules represets the model class that has the business logic of the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class GameRules {
    private PlayerAndGameCreator pagc;
    private GridSetUp gridSetUp;
    private String[][] b = new String[6][6];
    public GameRules()
    {
        int i=0 , j=0;
        for(i=0; i<b.length; i++)
        {
            for(j=0; j<b.length; j++)
            {
                b[i][j] = " - ";
            }
        }
    }
    private int count = 0 , i = 0;
    private String c = "";
    String data = "";
    TurnSet ts = new TurnSet();

    /**
     * To set TurnSet class Object inside GameRules.
     *
     * @param t TurnSet Object
     */


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


    public void setGridSet(GridSetUp gsu){
        gridSetUp = gsu;
    }
    public String getCellData()
    {
        return c;
    }
    /**
     * To assign rules to every cell of the board.
     *
     * @param r1 row number of the button
     * @param c1 column number of the button
     * @throws Exception when player clicks the cell, that is already filled
     */
    public ArrayList<Integer> GridRules(int r1, int c1){

        i=0;
        ArrayList<Integer> indexes = new ArrayList<>();
        int row = r1, col = c1 , j=0 , k=0;
        c = "";
        boolean found = false;
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
            b[row][col] = c;
            indexes.add(i,row);
            indexes.add(i+1,col);
            count++;
            i=i+2;
            if (b[row][col + 1] == " - " ) {
                b[row][col + 1] = c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col+1);
                i=i+2;
            }

            if (b[row + 1][col] == " - ") {
                b[row + 1][col] = c;
                count++;
                indexes.add(i,row+1);
                indexes.add(i+1,col);
                i=i+2;
            }

        } else if (row == 0 && col == 5) {
            b[row][col] = c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col - 1] == " - ") {
                b[row][col - 1] = c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col-1);
                i=i+2;
            }

            if (b[row + 1][col] == " - ") {
                b[row + 1][col] = c;
                count++;
                indexes.add(i,row+1);
                indexes.add(i+1,col);
                i=i+2;
            }

        } else if (row == 5 && col == 0) {
            b[row][col] = c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col + 1] == " - ") {
                b[row][col + 1] = c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col+1);
                i=i+2;
            }

            if (b[row - 1][col] == " - ") {
                b[row - 1][col] = c;
                count++;
                indexes.add(i,row-1);
                indexes.add(i+1,col);
                i=i+2;
            }

        } else if (row == 5 && col == 5) {
            b[row][col] = c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col - 1] == " - ") {
                b[row][col - 1]=c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col-1);
                i=i+2;
            }
            if (b[row - 1][col] == " - ") {
                b[row - 1][col]=c;
                count++;
                indexes.add(i,row-1);
                indexes.add(i+1,col);
                i=i+2;
            }

        } else if (row == 0) {
            b[row][col]=c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col - 1] == " - ") {
                b[row][col - 1]=c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col-1);
                i=i+2;
            }

            if (b[row + 1][col] == " - ") {
                b[row + 1][col]=c;
                count++;
                indexes.add(i,row+1);
                indexes.add(i+1,col);
                i=i+2;
            }

            if (b[row][col + 1] == " - ") {
                b[row][col + 1]=c;
                count++;

                indexes.add(i,row);
                indexes.add(i+1,col+1);
                i=i+2;
            }

        } else if (row == 5) {
            b[row][col]=c;
            count++;

            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col - 1] == " - ") {
                b[row][col - 1]=c;
                count++;

                indexes.add(i,row);
                indexes.add(i+1,col-1);
                i=i+2;
            }

            if (b[row - 1][col] == " - ") {
                b[row - 1][col]=c;
                count++;
                indexes.add(i,row-1);
                indexes.add(i+1,col);
                i=i+2;
            }

            if (b[row][col + 1] == " - ") {
                b[row][col + 1]=c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col+1);
                i=i+2;
            }
        } else if (col == 0) {
            b[row][col]=c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col + 1] == " - ") {
                b[row][col + 1]=c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col+1);
                i=i+2;
            }
            if (b[row - 1][col] == " - ") {
                b[row - 1][col]=c;
                count++;
                indexes.add(i,row-1);
                indexes.add(i+1,col);
                i=i+2;
            }

            if (b[row + 1][col] == " - ") {
                b[row + 1][col]=c;
                count++;
                indexes.add(i,row+1);
                indexes.add(i+1,col);
                i=i+2;
            }

        } else if (col == 5) {
            b[row][col]=c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col - 1] == " - ") {
                b[row][col - 1]=c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col-1);
                i=i+2;
            }

            if (b[row - 1][col] == " - ") {
                b[row - 1][col]=c;
                count++;
                indexes.add(i,row-1);
                indexes.add(i+1,col);
                i=i+2;
            }

            if (b[row + 1][col] == " - ") {
                b[row + 1][col]=c;
                count++;
                indexes.add(i,row+1);
                indexes.add(i+1,col);
                i=i+2;
            }

        } else {
            b[row][col]=c;
            count++;
            indexes.add(i,row);
            indexes.add(i+1,col);
            i=i+2;
            if (b[row][col - 1] == " - ") {
                b[row][col - 1]=c;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col-1);
                i=i+2;
            }

            if (b[row - 1][col] == " - ") {
                b[row - 1][col]=c;
                count++;
                indexes.add(i,row-1);
                indexes.add(i+1,col);
                i=i+2;
            }

            if (b[row + 1][col] == " - ") {
                b[row + 1][col]=c;
                count++;
                indexes.add(i,row+1);
                indexes.add(i+1,col);
                i=i+2;
            }

            if (b[row][col + 1] == " - ") {
                b[row][col + 1]=c+1;
                count++;
                indexes.add(i,row);
                indexes.add(i+1,col+1);
                i=i+2;
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

        System.out.println(indexes);

        System.out.println("------------------");
        System.out.println(getCount());
        return indexes;
    }

}
