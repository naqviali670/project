package Control;

import Model.GameRules;
import Model.Player1;
import Model.StoreData;
import Model.TurnSet;
import View.Scene1;
import View.Scene2;
import View.Scene3;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * ButtonFunctions represents the controller class, which has functions which controls different scenes of the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class ButtonFunctions {
    GameRules gr = new GameRules();
    TurnSet ts = new TurnSet();
    int check;

    /**
     * It represents the Scene2 controller function.
     * It calls business logic function from GameRules(model class) to set logic on each cell.
     * It uses StoreData(model_class), calls functions of StoreData to store Game in Game table.
     * After this, it changes second scene to first scene.
     *
     * @param b1    Button Array,  represents cells of the board.
     * @param r     row number of specific cell.
     * @param c1    column number of the specific cell.
     * @param stage stage, created in the Scene1
     * @param pagc  PlayerAndGameCreator object, to perform necessary functionality.
     */
    public void actionGrid(Button[][] b1, int r, int c1, Stage stage, PlayerAndGameCreator pagc) {
        gr.setTurnSet(ts);
        gr.setPlayerAndGameCreator(pagc);
        int row, col;
        row = r;
        col = c1;
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    gr.GridRules(b1, r, c1); // Business logic
                } catch (Exception e) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Cell is already filled", ButtonType.OK);
                    a.show();
                }
                if (gr.getCount() == 36) //to store data
                {
                    pagc.getGame().setPlayer1Turn(pagc.getP1().getTurns());
                    pagc.getGame().setPlayer2Turn(pagc.getP2().getTurns());
                    StoreData sd = new StoreData();
                    if (ts.getTurn() == 1) {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, pagc.getP2().getName() + " is the winner", ButtonType.OK);
                        a.showAndWait();
                        pagc.getGame().setWinner(pagc.getP2().getName());
                        Logger.info("{} is the winner", pagc.getP2().getName());
                        for (Player1 p : sd.getPlayer()) {

                            if (p.equals(pagc.getP2())) {
                                sd.updateData(p);

                            }
                        }
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, pagc.getP1().getName() + " is the winner", ButtonType.OK);
                        a.show();
                        pagc.getGame().setWinner(pagc.getP1().getName());
                        Logger.info("{} is the winner", pagc.getP1().getName());
                        for (Player1 p : sd.getPlayer()) {
                            if (p.equals(pagc.getP1())) {
                                sd.updateData(p);
                                pagc.getGame().setWinner(pagc.getP1().getName());
                            }
                        }
                    }
                    sd.setGame(pagc.getGame());


                    ts.setTurn(1);
                    Scene1 fx = new Scene1();

                    try {
                        fx.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        b1[row][col].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

    }

    /**
     * It represents the Scene1 controller function.
     * It also assigns the functionality to start button in Scene1(first scene).
     * It uses StoreData(model_class), calls functions of StoreData(model_class) to store player in Player1 table.
     *
     * @param b     Button, represents start button.
     * @param stage stage, created in the Scene1.
     * @param t1    TextField, contains the first player name.
     * @param t2    TextField contains the second player name.
     */
    public void startAction(Button b, Stage stage, TextField t1, TextField t2) {
        PlayerAndGameCreator pagc = new PlayerAndGameCreator();
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (t1.getText().trim().equals("") || t2.getText().trim().equals("")) {
                    t1.setText("");
                    t2.setText("");

                    Alert a = new Alert(Alert.AlertType.ERROR, "Players Names are required", ButtonType.OK);
                    a.show();
                    t1.requestFocus();
                } else if (t1.getText().trim().equals(t2.getText().trim())) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Players Names are same", ButtonType.OK);
                    a.show();
                    t1.requestFocus();
                } else {
                    pagc.playerCreator(t1.getText(), t2.getText());
                    pagc.gameCreator();
                    StoreData sd = new StoreData();
                    sd.setPlayer(pagc.getP1());
                    sd.setPlayer(pagc.getP2());
                    Logger.info("Players are ready for action!");
                    pagc.getGame().setLt(LocalTime.now());
                    pagc.getGame().setLd(LocalDate.now());
                    pagc.getGame().setPlayer1(pagc.getP1().getName());
                    pagc.getGame().setPlayer2(pagc.getP2().getName());
                    Scene2 s = new Scene2();
                    s.setPlayerAndGameCreator(pagc);
                    try {
                        s.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        b.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    /**
     * It changes first scene to third scene
     * It assigns this functionality to finish button in Scene1.
     *
     * @param b     Button object, represents finish button
     * @param stage stage, created in the Scene1.
     */
    public void finishAction(Button b, Stage stage) {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Scene3 s = new Scene3();
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

}
