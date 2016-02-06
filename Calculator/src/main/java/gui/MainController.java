package gui;


import core.Calc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by Владимир on 06.02.2016.
 */
public class MainController {
    @FXML
    TextField field;
    StringBuilder str=new StringBuilder(8);
    String first;
    String second;
    char znak;



    public void two(ActionEvent actionEvent) {
        str.append(2);
        field.setText(String.valueOf(str));
    }

    public void one(ActionEvent actionEvent) {
        str.append(1);
        field.setText(String.valueOf(str));
    }

    public void three(ActionEvent actionEvent) {
        str.append(3);
        field.setText(String.valueOf(str));
    }

    public void four(ActionEvent actionEvent) {
        str.append(4);
        field.setText(String.valueOf(str));
    }

    public void five(ActionEvent actionEvent) {
        str.append(5);
        field.setText(String.valueOf(str));
    }

    public void eight(ActionEvent actionEvent) {
        str.append(8);
        field.setText(String.valueOf(str));
    }

    public void six(ActionEvent actionEvent) {
        str.append(6);
        field.setText(String.valueOf(str));
    }

    public void seven(ActionEvent actionEvent) {
        str.append(7);
        field.setText(String.valueOf(str));
    }

    public void nine(ActionEvent actionEvent) {
        str.append(9);
        field.setText(String.valueOf(str));
    }

    public void nul(ActionEvent actionEvent) {
        str.append(0);
        field.setText(String.valueOf(str));
    }

    public void plus(ActionEvent actionEvent) {

        first= String.valueOf(str);
        str.delete(0,str.length());
        znak='+';


    }

    public void minus(ActionEvent actionEvent) {
        first= String.valueOf(str);
        str.delete(0,str.length());
        znak='-';

    }

    public void umnogh(ActionEvent actionEvent) {
        first= String.valueOf(str);
        str.delete(0,str.length());
        znak='*';

    }

    public void del(ActionEvent actionEvent) {
        first= String.valueOf(str);
        str.delete(0,str.length());
        znak='/';

    }

    public void ravno(ActionEvent actionEvent) {
        second= String.valueOf(str);
        str.delete(0,str.length());
        Calc c=new Calc(first,second);
        switch (znak){
            case '+': {field.setText(String.valueOf(c.plus()));break;}
            case '-':{field.setText(String.valueOf(c.minus()));break;}
            case '*':{field.setText(String.valueOf(c.umn()));break;}
            case '/':{field.setText(String.valueOf(c.del()));break;}
        }




    }
}