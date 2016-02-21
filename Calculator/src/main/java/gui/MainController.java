package gui;


import core.Calc;
import core.EnamZnak;
import interfaces.InterfaceCalc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Владимир on 06.02.2016.
 */
public class MainController {
    @FXML
    private TextField field;

    private Socket sock;

    StringBuilder str = new StringBuilder(8);
    String first;
    String second;
    EnamZnak enamZnak;

//    public ArrayList<String> list;
    public PrintWriter writer;
    public ObjectInputStream reader = null;

    @FXML
    private void two(ActionEvent actionEvent) {
        str.append(2);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void one(ActionEvent actionEvent) {
        str.append(1);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void three(ActionEvent actionEvent) {
        str.append(3);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void four(ActionEvent actionEvent) {
        str.append(4);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void five(ActionEvent actionEvent) {
        str.append(5);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void eight(ActionEvent actionEvent) {
        str.append(8);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void six(ActionEvent actionEvent) {
        str.append(6);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void seven(ActionEvent actionEvent) {
        str.append(7);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void nine(ActionEvent actionEvent) {
        str.append(9);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void nul(ActionEvent actionEvent) {
        str.append(0);
        field.setText(String.valueOf(str));
    }

    @FXML
    private void plus(ActionEvent actionEvent) {

        first = String.valueOf(str);
        str.delete(0, str.length());
        enamZnak = EnamZnak.PLUS;


    }

    @FXML
    private void minus(ActionEvent actionEvent) {
        first = String.valueOf(str);
        str.delete(0, str.length());
        enamZnak = EnamZnak.MINUS;

    }

    @FXML
    private void umnogh(ActionEvent actionEvent) {
        first = String.valueOf(str);
        str.delete(0, str.length());
        enamZnak = EnamZnak.MULT;

    }

    @FXML
    private void del(ActionEvent actionEvent) {
        first = String.valueOf(str);
        str.delete(0, str.length());
        enamZnak = EnamZnak.DIVIDE;
    }

    @FXML
    private void ravno(ActionEvent actionEvent) {
        second = String.valueOf(str);
        str.delete(0, str.length());
        Calc c = new Calc(first, second, enamZnak);
        setUpNetworking(c);
    }

    private void setUpNetworking(InterfaceCalc c) {
//        list = new ArrayList<>();
        Thread th = new Thread(new IncomingRead());
        try {
                sock = new Socket("localhost", 8000);
            ObjectOutput objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(sock.getOutputStream()));
            objectOutputStream.writeObject(c);
            objectOutputStream.flush();
            reader = new ObjectInputStream(new BufferedInputStream(sock.getInputStream()));
            th.start();
            System.out.println("связь установлена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class IncomingRead implements Runnable {
        public void run() {
            String msg;
            try {
                if ((msg = (String) reader.readObject()) != null) {
                    field.setText(msg);
//                    list.add(msg);
                    System.out.println(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
