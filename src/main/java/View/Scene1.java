package View;

import Control.ButtonFunctions;
import Control.PlayerAndGameCreator;
import Control.TextFieldFunctions;
import State.Player;
import State.StoreData;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Scene1 extends Application {
    PlayerAndGameCreator p;
    String player1,player2;
    @Override
    public void start(Stage stage) throws Exception {

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        Button start = new Button("Start");
        Button finish = new Button("Finish");
        Label firstPlayer = new Label("First Player: ");
        Label secondPlayer = new Label("Second Player: ");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        root.addRow(0,firstPlayer,t1);
        root.addRow(1,secondPlayer,t2);
        root.addRow(2,start);
        root.addRow(3,finish);
        ButtonFunctions.startAction(start , stage , t1 , t2);
        ButtonFunctions.finishAction(finish , stage);
        Scene s = new Scene(root,500,500);
        stage.setScene(s);
        stage.setTitle("Game");
        stage.show();
    }


}
