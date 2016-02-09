package gui;


import core.Calc;
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
    TextField field;
    StringBuilder str = new StringBuilder(8);
    String first;
    String second;
    char znak;
    public ArrayList<String> list;
    public PrintWriter writer;
    public BufferedReader reader;

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

        first = String.valueOf(str);
        str.delete(0, str.length());
        znak = '+';


    }

    public void minus(ActionEvent actionEvent) {
        first = String.valueOf(str);
        str.delete(0, str.length());
        znak = '-';

    }

    public void umnogh(ActionEvent actionEvent) {
        first = String.valueOf(str);
        str.delete(0, str.length());
        znak = '*';

    }

    public void del(ActionEvent actionEvent) {
        first = String.valueOf(str);
        str.delete(0, str.length());
        znak = '/';

    }

    public void ravno(ActionEvent actionEvent) throws IOException {
        second = String.valueOf(str);
        str.delete(0, str.length());
        InterfaceCalc c = new Calc(first, second, znak);
        setUpNetworking(c);
    }

    private void setUpNetworking(InterfaceCalc c) {
        Socket sock = null;
        list = new ArrayList<String>();
        Thread th = new Thread(new IncomingRead());
        th.start();
        try {

            sock = new Socket("127.0.0.1", 8000);
            ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(c);

            oos.close();
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            System.out.println("связь установлена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class IncomingRead implements Runnable {
        public void run() {
            String msg;
            try {
                while ((msg = reader.readLine()) != null) {
                    field.setText(msg);
                    list.add(msg);
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
