
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
        FXMLLoader loader = new FXMLLoader();
        Parent p = null;
        try {
            p = loader.load(getClass().getResource("fxml/main.fxml"));
        } catch (IOException e) {
            e.getStackTrace();
        }
        Scene sc = new Scene(p);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
