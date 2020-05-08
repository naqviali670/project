package Control;

import Model.Player;
import Model.StoreData;
import View.Scene1;
import View.Scene2;
import View.Scene4;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Model.TurnSet;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.time.LocalTime;

public class ButtonFunctions{


    public static void actionGrid(Button[][] b1, int r, int c1, Stage stage)
    {
        int row,col;


        row=r;
        col=c1;
        Button b[][] = b1;
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try
                {
                    if(b[row][col].getText()=="X"||b[row][col].getText()=="O")
                    {
                        throw new Exception();
                    }

                    String c;
                if(TurnSet.getTurn() == 1)
                {
                    c = "X";
                    Logger.info("{}'s turn",PlayerAndGameCreator.getP1().getName());
                }
                else
                {
                    c = "O";
                    Logger.info("{}'s turn",PlayerAndGameCreator.getP2().getName());
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
                if (TurnSet.getTurn() == 1) {
                    TurnSet.setTurn(2);
                    PlayerAndGameCreator.getP1().TurnCalculator(1);
                } else {
                    TurnSet.setTurn(1);
                    PlayerAndGameCreator.getP2().TurnCalculator(1);
                }

                Scene2.setCount(count);

                if (Scene2.getCount() == 36) {
                    StoreData.setPlayer(PlayerAndGameCreator.getP1());
                    StoreData.setPlayer(PlayerAndGameCreator.getP2());

                    if (TurnSet.getTurn() == 1) {
                        Logger.info("{} is the winner",PlayerAndGameCreator.getP2().getName());
                        for (Player p : StoreData.getPlayer()) {
                            if (p.equals(PlayerAndGameCreator.getP2())) {
                                p.setWins(1);
                                PlayerAndGameCreator.Winner(PlayerAndGameCreator.getP2().getName());
                                StoreData.setGame(PlayerAndGameCreator.getGame());
                            }
                        }
                    }
                    else {
                        Logger.info("{} is the winner",PlayerAndGameCreator.getP1().getName());
                        for (Player p : StoreData.getPlayer()) {
                            if (p.equals(PlayerAndGameCreator.getP1())) {
                                p.setWins(1);
                                PlayerAndGameCreator.Winner(PlayerAndGameCreator.getP1().getName());
                                StoreData.setGame(PlayerAndGameCreator.getGame());
                            }
                        }
                    }
                    TurnSet.setTurn(1);
                    Scene2.Count(0);
                    Scene1 fx = new Scene1();
                    System.out.println(PlayerAndGameCreator.getGame().getLt());
                    try {
                        fx.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            catch(Exception ex)
            {
                Logger.warn("The cell is already filled. Please try a different one!");
            }
            }

        };
        b[row][col].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

    }
    public static void startAction(Button b , Stage stage , TextField t1 , TextField t2)
    {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                PlayerAndGameCreator.playerCreator(t1 , t2);
                PlayerAndGameCreator.gameCreator();
                Logger.info("Players are ready for action!");
                PlayerAndGameCreator.getGame().setLt(LocalTime.now());
                PlayerAndGameCreator.getGame().setLd(LocalDate.now());
                Scene2 s = new Scene2();

                try {
                    s.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        b.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    public static void finishAction(Button b , Stage stage)
    {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Scene4 s= new Scene4();
                Logger.info("You are tired now!");
                try {

                    s.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        };
        b.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

    }
    public static void exitAction(Button b)
    {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Logger.info("Program is finished running!");
                System.exit(0);
            }
        };
        b.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

}
