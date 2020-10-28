import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ClientCemetery extends Application {
    public static void main(String[] args) {
        launch(args);
//        ClientConnection clientConnection = new ClientConnection();
//        clientConnection.connection();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("GUI/Preview.fxml"));
        fxmlLoader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(fxmlLoader.getRoot(),1280,720));
        primaryStage.show();
        Parent root = fxmlLoader.getRoot();
        new FadeIn(root).play();
    }
}
