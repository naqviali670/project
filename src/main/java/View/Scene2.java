package View;

import Control.ButtonFunctions;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Scene2 extends Application {
    private Button exit = new Button("Exit");
    private Button b[][] = new Button[6][6];
    static int count=0;
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 600, 400);
        int i = 0, j = 0, count = 0;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                b[i][j] = new Button();
                b[i][j].setMinSize(50,50);
                root.add(b[i][j], j, i);
            }
        }

        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                ButtonFunctions.actionGrid(b, i, j,stage);
            }
        }


        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                if(b[i][j].getText().equals("X")||b[i][j].getText().equals("O")){
                    count++;
                }
            }
        }

        stage.setScene(scene);
        stage.setTitle("FirstExample");
        stage.show();

    }
    public static void setCount(int count){
        Scene2.count=Scene2.count+count;
    }
    public static void Count(int count){
        Scene2.count=count;
    }
    public static int getCount(){
        return Scene2.count;
    }
}
