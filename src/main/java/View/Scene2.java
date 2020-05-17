package View;

import Control.GridSetUp;
import Control.ButtonFunctions;
import Control.PlayerAndGameCreator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Scene2 represents view class, representing the second scene of the game
 *
 * @author Syed Kausar Ali Naqvi
 */
public class Scene2 extends Application {
    PlayerAndGameCreator pagc;
    private Button exit = new Button("Exit");

    /**
     * It has functionality to display second scene of the game.
     * Second scene will have the 6x6 board(made of buttons).
     * It will be ended when 6x6 will be completely filled.
     *
     * @param stage first stage, made in the first scene
     * @throws Exception when something goes wrong with the stage or scene.
     */
    @Override
    public void start(Stage stage) throws Exception {
        ButtonFunctions bf = new ButtonFunctions();
        GridSetUp gs = new GridSetUp();
        gs.setButton();
        Button[][] b = gs.getButtonArray();
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        FileInputStream backgroundImage = new FileInputStream("src/main/resources/Background Images/background.BMP");
        Image image = new Image(backgroundImage);
        BackgroundImage bi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        root.setMinSize(600, 400);
        root.setBackground(background);
        Scene scene = new Scene(root, 600, 400);

        int i = 0, j = 0;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                root.add(b[i][j], j, i);
            }
        }

        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                gs.actionGrid(i, j, stage, pagc);
            }
        }
        stage.setScene(scene);
        stage.setTitle("FirstExample");
        stage.show();
    }

    /**
     * Set PlayerAndGameCreator object inside Scene2, we have to pass it to actionGrid() for further functionality.
     *
     * @param p PlayerAndGameCreator object
     */
    public void setPlayerAndGameCreator(PlayerAndGameCreator p) {
        pagc = p;
    }

}
