package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerMain extends Main
{

    @FXML
    private Button into;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button b1;


    public void onClickMethod(ActionEvent actionEvent) throws IOException {
            //Stage st=new Stage ();
        Parent root= FXMLLoader.load(getClass().getResource("reg.fxml"));
        Scene scene=new Scene(root,300,275);

        Node source=(Node)actionEvent.getSource();
        Stage st=(Stage) source.getScene().getWindow();

        st.setScene(scene);
        st.show();
    }

    public void enter(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (proverka(login.getText(),password.getText())==true){
            System.out.println("вы вошли в программу!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }

    }

    private boolean proverka( String l,String p) throws SQLException, ClassNotFoundException {

            String par= new DataBase().SelectLogin(l);
           if (par.equals(p)) return true;
            else { System.out.println("Неправильно введен пароль или логин"); return false;}

    }
}
