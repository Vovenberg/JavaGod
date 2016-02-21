
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Владимир on 06.02.2016.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("gui/main.fxml"));
        Parent p = null;
        try {
            p = loader.load();
        } catch (IOException e) {
            e.getStackTrace();
        }
        primaryStage.setScene(new Scene(p));
        primaryStage.show();
    }
}
