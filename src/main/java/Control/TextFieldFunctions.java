package Control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TextFieldFunctions {
    private static String name;
    public static String setName(TextField t){

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                name=t.getText();
            }
        };
        t.setOnAction(event);
        return name;
    }
}
