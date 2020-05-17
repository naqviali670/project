package Control;

import Model.GameRules;
import Model.Player1;
import Model.StoreData;
import Model.TurnSet;
import View.Scene1;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.util.ArrayList;

/**
 * GridSetUp represents a controller class to set 6X6 board made of buttons for the game
 *
 * @author Syed Kausar Ali Naqvi
 */
public class GridSetUp {
    GameRules gr = new GameRules();
    TurnSet ts = new TurnSet();
    private Button[][] b = new Button[6][6];

    /**
     * Setting button array (6X6).
     */
    public void setButton() {
        int i = 0, j = 0;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                b[i][j] = new Button();
                setStyling(b[i][j]);
            }
        }
    }

    /**
     * @return b where b is the Button array (6x6)
     */
    public Button[][] getButtonArray() {
        return b;
    }

    /**
     * To style the passed button
     *
     * @param button (specific button passed for styling)
     */
    public void setStyling(Button button) {
        button.setMinSize(50, 50);
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void actionGrid(int r, int c, Stage stage, PlayerAndGameCreator pagc) {

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                int i = 0;
                if (b[r][c].getText() == "X" || b[r][c].getText() == "O") {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Cell is already filled", ButtonType.OK);
                    alert.show();
                }
                if (b[r][c].getText() == "") {
                    ArrayList<Integer> indexes = gr.GridRules(r, c);


                    for (i = 0; i < indexes.size(); i = i + 2) {

                        if (gr.getCellData() == "X") {

                            b[indexes.get(i)][indexes.get(i + 1)].setText("X");
                        } else if (gr.getCellData() == "O") {
                            b[indexes.get(i)][indexes.get(i + 1)].setText("O");
                        }
                    }
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
        b[r][c].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
