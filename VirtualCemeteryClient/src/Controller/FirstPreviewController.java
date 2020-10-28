package Controller;

import animatefx.animation.Shake;
import animatefx.animation.SlideInLeft;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirstPreviewController {
    @FXML
    Button skip1 = new Button();
    @FXML
    Button skip2 = new Button();
    @FXML
    Button skip3 = new Button();
    @FXML
    Button skip4 = new Button();
    @FXML
    Button next1 = new Button();
    @FXML
    Button next2 = new Button();
    @FXML
    Button next3 = new Button();
    @FXML
    Button next4 = new Button();
    @FXML
    Button nextBad = new Button();
    @FXML
    Button ru1 = new Button();
    @FXML
    Button en1 = new Button();
    @FXML
    Button ru2 = new Button();
    @FXML
    Button en2 = new Button();
    @FXML
    Button ru3 = new Button();
    @FXML
    Button en3 = new Button();
    @FXML
    Button ru4 = new Button();
    @FXML
    Button en4 = new Button();
    @FXML
    Pane pane2 = new Pane();
    @FXML
    Pane pane3 = new Pane();
    @FXML
    Pane loginPane = new Pane();
    @FXML
    Pane pane1 = new Pane();
    @FXML
    TextField login = new TextField();
    @FXML
    PasswordField password = new PasswordField();

    @FXML
    void initialize() {
        en1.setOnAction(event -> {
            en1.setVisible(false);
        });
        ru1.setOnAction(event -> {
            en1.setVisible(true);
        });
        skip1.setOnMouseEntered(event -> {
            skip1.setUnderline(true);
        });
        skip1.setOnMouseExited(event -> skip1.setUnderline(false));
        next1.setOnAction(event -> {
            pane1.setVisible(false);
            pane2.setVisible(true);
            new SlideInLeft(pane2).play();
        });
        next2.setOnAction(event -> {
            pane2.setVisible(false);
            pane3.setVisible(true);
            new SlideInLeft(pane3).play();
        });
        next3.setOnAction(event -> {
            pane3.setVisible(false);
            loginPane.setVisible(true);
            new SlideInLeft(loginPane).play();
        });
//        skip1.setOnAction(event -> {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("../GUI/LoginFrame.fxml"));
//            try {
//                fxmlLoader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            next1.getScene().getWindow().hide();
//            Stage stage = new Stage();
//            stage.initStyle(StageStyle.UNDECORATED);
//            stage.setScene(new Scene(fxmlLoader.getRoot(), 1280, 720));
//            stage.show();
//
//        });
        Node graphicStyle = next4.getGraphic();
        String borderStyle = login.getStyle();
        AtomicBoolean badLogPas = new AtomicBoolean(false);
        en4.setOnAction(event -> {
            en4.setVisible(false);
        });
        next4.setOnAction(event -> {
            badLogPas.set(true);
            login.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(login).play();
            password.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(password).play();
            next4.setGraphic(nextBad.getGraphic());
            new Shake(next4.getGraphic()).play();
        });
        ru4.setOnAction(event -> {
            en4.setVisible(true);
        });
        skip4.setOnMouseEntered(event -> {
            skip4.setUnderline(true);
        });
        login.textProperty().addListener(observable -> {
            badLogPas.set(false);
            login.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
        });
        password.textProperty().addListener(observable -> {
            password.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");

        });
        next4.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                next4.setGraphic(graphicStyle);
            }
        });
        next4.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        next4.setGraphic(graphicStyle);
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
        skip4.setOnMouseExited(event -> skip4.setUnderline(false));
        skip4.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/FirstPreview.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            next4.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(fxmlLoader.getRoot(), 1280, 720));
            stage.show();

        });
    }
}
