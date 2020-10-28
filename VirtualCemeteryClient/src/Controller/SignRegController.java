package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.text.html.ImageView;

public class SignRegController {
    @FXML
    DatePicker dater = new DatePicker();
    @FXML
    TextField daterText = new TextField();
    @FXML
    Button tickTrue=new Button();
    @FXML
    Button tickFalse = new Button();

    @FXML
    void initialize() {
        dater.getEditor().textProperty().addListener(observable -> {
             daterText.setText(dater.getEditor().getText());
        });
        tickFalse.setOnAction(event -> {
            tickFalse.setVisible(false);
        });
        tickTrue.setOnAction(event -> {
            tickFalse.setVisible(true);
        });
    }
}
