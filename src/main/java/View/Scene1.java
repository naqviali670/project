package View;

import Control.ButtonFunctions;
import Control.PlayerAndGameCreator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Scene1 represents the view class, representing the first scene appears when player start the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class Scene1 extends Application {
    PlayerAndGameCreator p;
    String player1, player2;

    /**
     * It has the functionality to set the first scene of the game, in which game asks both players to enter
     * their names.
     * It will get names from players using textfields.
     * It has start button, which has functionality to start the game on click.
     * It has Quit button to quit game.
     *
     * @param stage primary stage of the game
     * @throws Exception when something goes wrong with the stage or scene.
     */
    @Override

    public void start(Stage stage) throws Exception {
        ButtonFunctions bf = new ButtonFunctions();
        GridPane root = new GridPane();
        root.setMinSize(600, 400);
        root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(60, 20, 20, 20));
        root.setVgap(15);
        Font defaultFOnt = new Font("TimesNewRoman", 15);
        Button start = new Button("Start");
        start.setMinSize(80, 60);
        Button finish = new Button("Quit");
        finish.setMinSize(80, 60);
        start.setTranslateY(30);
        finish.setTranslateY(30);
        finish.setTranslateX(110);
        Label gameName = new Label("Last Move");
        gameName.setFont(new Font("TimesNewRoman", 40));
        gameName.setTranslateX(90);
        Label firstPlayer = new Label("First Player: \t");
        firstPlayer.setFont(defaultFOnt);
        Label secondPlayer = new Label("Second Player:\t");
        secondPlayer.setFont(defaultFOnt);
        TextField t1 = new TextField();
        t1.setFont(defaultFOnt);
        t1.setPromptText("Player 1 Name");
        TextField t2 = new TextField();
        t2.setFont(defaultFOnt);
        t2.setPromptText("Player 2 Name");
        root.addRow(0, gameName);
        root.addRow(1, firstPlayer, t1);
        root.addRow(2, secondPlayer, t2);
        root.addRow(3, start, finish);

        bf.startAction(start, stage, t1, t2);
        bf.finishAction(finish, stage);
        Scene s = new Scene(root, 600, 400);
        stage.setScene(s);
        stage.setTitle("Game");
        stage.show();
    }


}
