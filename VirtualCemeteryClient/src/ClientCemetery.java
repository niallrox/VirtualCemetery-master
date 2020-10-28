import ClientWork.ClientConnection;
import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClientCemetery extends Application {
    public static void main(String[] args) {
        launch(args);
//        ClientConnection clientConnection = new ClientConnection();
//        clientConnection.connection();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("GUI/FirstPreview.fxml"));
        fxmlLoader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(fxmlLoader.getRoot(),1280,720));
        primaryStage.show();
        Parent root = fxmlLoader.getRoot();
        new FadeIn(root).play();
    }
}
