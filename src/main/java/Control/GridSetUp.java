package Control;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * GridSetUp represents a controller class to set 6X6 board made of buttons for the game
 *
 * @author Syed Kausar Ali Naqvi
 */
public class GridSetUp {
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

}
