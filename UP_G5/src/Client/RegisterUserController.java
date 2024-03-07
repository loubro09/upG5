package Client;

import Entity.User;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class RegisterUserController implements PropertyChangeListener {

    private List<User> allUsers = new ArrayList<>();

    public RegisterUserController(){

    }

    public void addUser(String userName, Icon icon){
        User user = new User(userName,icon);
        allUsers.add(user);

    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
