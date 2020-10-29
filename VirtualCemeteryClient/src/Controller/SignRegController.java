package Controller;

import animatefx.animation.Shake;
import animatefx.animation.SlideInLeft;
import animatefx.animation.SlideInRight;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.concurrent.atomic.AtomicBoolean;

public class SignRegController {
    AtomicBoolean badLogPas = new AtomicBoolean(false);
    @FXML
    DatePicker dater = new DatePicker();
    @FXML
    TextField daterText = new TextField();
    @FXML
    Button tickTrue = new Button();
    @FXML
    Button tickFalse = new Button();
    @FXML
    Button skip1 = new Button();
    @FXML
    Button next1 = new Button();
    @FXML
    Button close = new Button();
    @FXML
    Button nextBad = new Button();
    @FXML
    Button ru1 = new Button();
    @FXML
    Button en1 = new Button();
    @FXML
    TextField login1 = new TextField();
    @FXML
    PasswordField password1 = new PasswordField();
    @FXML
    TextField name1 = new TextField();
    @FXML
    TextField surname1 = new TextField();
    @FXML
    TextField passwordOneMore = new TextField();
    @FXML
    Pane reg = new Pane();
    @FXML
    Pane rules = new Pane();


    @FXML
    void initialize() {
        String borderStyle = login1.getStyle();
        Node graphicStyle = next1.getGraphic();
        dater.getEditor().textProperty().addListener(observable -> {
            daterText.setText(dater.getEditor().getText());
        });
        tickFalse.setOnAction(event -> {
            tickFalse.setVisible(false);
        });
        tickTrue.setOnAction(event -> {
            tickFalse.setVisible(true);
        });
        en1.setOnAction(event -> {
            en1.setVisible(false);
        });
        ru1.setOnAction(event -> {
            en1.setVisible(true);
        });
        next1.setOnAction(event -> {
            badLogPas.set(true);
            login1.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(login1).play();
            password1.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(password1).play();
            daterText.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(daterText).play();
            next1.setGraphic(nextBad.getGraphic());
            new Shake(next1.getGraphic()).play();
            name1.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(name1).play();
            surname1.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(surname1).play();
            passwordOneMore.setStyle("-fx-border-color: red;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
            new Shake(passwordOneMore).play();
        });
        next1.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                next1.setGraphic(graphicStyle);
            }
        });
        next1.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        next1.setGraphic(graphicStyle);
                    }
                }
        );
        login1.textProperty().addListener(observable -> {
            badLogPas.set(false);
            login1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
        });
        password1.textProperty().addListener(observable -> {
            badLogPas.set(false);
            password1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");

        });
        name1.textProperty().addListener(observable -> {
            badLogPas.set(false);
            name1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
        });
        surname1.textProperty().addListener(observable -> {
            badLogPas.set(false);
            surname1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
        });
        daterText.textProperty().addListener(observable -> {
            badLogPas.set(false);
            daterText.setStyle(borderStyle + "-fx-text-inner-color: white;");
        });
        passwordOneMore.textProperty().addListener(observable -> {
            badLogPas.set(false);
            passwordOneMore.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #333333 #333333; -fx-font-family: Open Sans ; -fx-font-weight: 400; -fx-font-style: normal ; -fx-font-size: 18px; -fx-text-inner-color: white;");
        });
        login1.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                login1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        login1.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        login1.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        name1.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                name1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        name1.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        name1.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        password1.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                password1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        password1.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        password1.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        surname1.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                surname1.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        surname1.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        surname1.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        passwordOneMore.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                passwordOneMore.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        passwordOneMore.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        passwordOneMore.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        dater.setOnMouseEntered(event -> {
            if (!badLogPas.get()) {
                daterText.setStyle("-fx-border-color: #67EBF3;  -fx-border-radius: 5px; -fx-border-style: solid; -fx-background-color: #262626#262626 #262626#262626; -fx-font-family: Open Sans; -fx-font-weight: 400; -fx-font-style: normal; -fx-font-size: 18px; -fx-text-inner-color: white;");
            }
        });
        dater.setOnMouseExited(event -> {
                    if (!badLogPas.get()) {
                        daterText.setStyle(borderStyle + "-fx-text-inner-color: white;");
                    }
                }
        );
        skip1.setOnAction(event -> {
            reg.setVisible(false);
            rules.setVisible(true);
            new SlideInLeft(rules).play();
        });
        close.setOnAction(event -> {
            rules.setVisible(false);
            reg.setVisible(true);
            new SlideInRight(reg).play();
        });
    }
}

