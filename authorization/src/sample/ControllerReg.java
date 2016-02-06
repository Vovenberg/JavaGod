package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Владимир on 01.02.2016.
 */
public class ControllerReg extends Main {
    @FXML
    TextField log;
    @FXML
    TextField par;
    @FXML
    TextField par1;

    ArrayList<User> list;

    public void onClickMethod(ActionEvent actionEvent) throws IOException, InterruptedException, SQLException, ClassNotFoundException {

        if (proverka(log.getText(),users.getList())==true){

            if (par.getText().equals(par1.getText())){
                //list.add( new User(log.getText(), par.getText()));
                //users.list.add(new User(log.getText(), par.getText()));

                new DataBase().Insert(log.getText(), par.getText());


                Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
                Scene scene=new Scene(root,300,275);
                Node source=(Node)actionEvent.getSource();
                Stage st=(Stage) source.getScene().getWindow();
                st.setScene(scene);
                st.show();
                modalWindowsucks();

            }
            else {
                modalWindowpar();
            }
        }
        else modalWindowpol();

    }


    public boolean proverka (String str, ArrayList<User> list){
        Boolean b=true;
        //SimpleStringProperty ss=new SimpleStringProperty(str);
        for (User u :list) {
            if (u.login.equals(str))
            { b=false;

                break;}
            else b=true;
        }
        return b;
    }




    private void modalWindowpol() throws IOException {
        Stage st=new Stage ();
        Parent root= FXMLLoader.load(getClass().getResource("pol.fxml"));
        Scene scene=new Scene(root);
        st.setTitle("Регистрация");
        st.setResizable(false);
        st.initModality(Modality.WINDOW_MODAL);

        st.setScene(scene);
        st.show();
    }
    private void modalWindowsucks() throws IOException {
        Stage st=new Stage ();
        Parent root= FXMLLoader.load(getClass().getResource("sucks.fxml"));
        Scene scene=new Scene(root);
        st.setTitle("Регистрация");
        st.setResizable(false);
        st.initModality(Modality.WINDOW_MODAL);

        st.setScene(scene);
        st.show();
    }



    public void modalWindowpar() throws IOException {
        Stage st=new Stage ();
        Parent root= FXMLLoader.load(getClass().getResource("par.fxml"));
        Scene scene=new Scene(root);
        st.setTitle("Регистрация");
        st.setResizable(false);
        st.initModality(Modality.WINDOW_MODAL);
        st.setScene(scene);
        st.show();

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(root,300,275);
        Node source=(Node)actionEvent.getSource();
        Stage st=(Stage) source.getScene().getWindow();
        st.setScene(scene);
        st.show();
    }
}
