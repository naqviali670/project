package View;

import Control.ButtonFunctions;
import Control.Result;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Scene4 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        int i=0 , noOfWinners=0;
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        Button exit = new Button("OK");
        exit.setMinSize(50,50);
        exit.setAlignment(Pos.CENTER);
        Label heading = new Label("Top 5 Players");
        heading.setFont(new Font("Arial", 30));
        heading.setAlignment(Pos.TOP_CENTER);
        Label []l = new Label[6];
        root.addRow(0,heading);
        for(i=0; i<6; i++)
        {
            l[i] = new Label();
            l[i].setAlignment(Pos.CENTER);
            l[i].setFont(new Font("Arial", 30));
        }
        Result r = new Result();
        r.sortPlayers();
        noOfWinners=r.displayResult(l);
        for(i=0; i<noOfWinners; i++)
        {
            root.addRow(i+1,l[i]);
        }
        root.addRow(i+1 , exit);
        ButtonFunctions.exitAction(exit);
        Scene s = new Scene(root,600,400);
        stage.setScene(s);
        stage.setTitle("Result");
        stage.show();
    }
}
