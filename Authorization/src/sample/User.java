package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ArrayChangeListener;
import javafx.collections.ObservableArray;

/**
 * Created by Владимир on 01.02.2016.
 */
public class User {
    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
