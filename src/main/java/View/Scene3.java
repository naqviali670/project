package View;

import Control.WinnersResult;
import Model.Player1;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Scene3 represents a view class, representing the third scene of the game.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class Scene3 extends Application {
    /**
     * It has functionality to show a table view which will contain the records of top 5 winners on the basis of theirwins
     *
     * @param stage first stage, made in the first scene
     * @throws Exception when something goes wrong with the stage or scene.
     */
    @Override
    public void start(Stage stage) throws Exception {
        TableView<Player1> table = new TableView<Player1>();
        WinnersResult wr = new WinnersResult();
        table.setItems(FXCollections.observableArrayList(wr.getWinners()));
        TableColumn playerName = new TableColumn("Player Name");
        playerName.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn noOfWins = new TableColumn("Wins");
        noOfWins.setCellValueFactory(new PropertyValueFactory("wins"));
        table.getColumns().addAll(playerName, noOfWins);
        table.setPrefWidth(600);
        table.setPrefHeight(400);
        playerName.setMinWidth(300);
        noOfWins.setMinWidth(300);
        Scene s = new Scene(table, 600, 400);
        stage.setScene(s);
        stage.setTitle("Top 5 Winners");
        stage.show();
    }
}
