package Controller;

import animatefx.animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginFrameController {
    @FXML
    Button skip = new Button();
    @FXML
    Button next = new Button();
    @FXML
    Button nextBad = new Button();
    @FXML
    Button ru = new Button();
    @FXML
    Button en = new Button();
    @FXML
    TextField login = new TextField();
    @FXML
    PasswordField password = new PasswordField();

    @FXML
    void initialize() {
        Node graphicStyle = next.getGraphic();
        String borderStyle = login.getStyle();
        AtomicBoolean badLogPas = new AtomicBoolean(false);
        en.setOnAction(event -> {
            en.setVisible(false);
        });
        next.setOnAction(event -> {
            badLogPas.set(true);
            login.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(login).play();
            password.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(password).play();
            next.setGraphic(nextBad.getGraphic());
            new Shake(next.getGraphic()).play();
        });
        ru.setOnAction(event -> {
            en.setVisible(true);
        });
        skip.setOnMouseEntered(event -> {
            skip.setUnderline(true);
        });
        login.textProperty().addListener(observable -> {
            badLogPas.set(false);
            login.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
        });
        password.textProperty().addListener(observable -> {
            password.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");

        });
        next.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                next.setGraphic(graphicStyle);
            }
        });
        next.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        next.setGraphic(graphicStyle);
                    }
                }
        );
        login.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                login.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        login.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        login.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        password.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                password.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        password.setOnMouseExited(event -> {
            if (!badLogPas.get()) {
                password.setStyle(borderStyle + "-fx-text-inner-color: white;");
            }
        });
        skip.setOnMouseExited(event -> skip.setUnderline(false));
        skip.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/SecondPreview.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            next.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(fxmlLoader.getRoot(), 1280, 720));
            stage.show();

        });
    }
}

