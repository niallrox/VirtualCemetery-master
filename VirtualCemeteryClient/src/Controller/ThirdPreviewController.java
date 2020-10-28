package Controller;

import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ThirdPreviewController {


    @FXML
    Button skip = new Button();
    @FXML
    Button next = new Button();
    @FXML
    Button ru = new Button();
    @FXML
    Button en = new Button();

    @FXML
    void initialize() {
        en.setOnAction(event -> {
            en.setVisible(false);
        });
        ru.setOnAction(event -> {
            en.setVisible(true);
        });
        skip.setOnMouseEntered(event -> {
            skip.setUnderline(true);
        });
        skip.setOnMouseExited(event -> skip.setUnderline(false));
        next.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/LoginFrame.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(fxmlLoader.getRoot(), 1280, 720));
            stage.show();
            Parent root = fxmlLoader.getRoot();
            new FadeIn(root).play();
        });
    }
}
