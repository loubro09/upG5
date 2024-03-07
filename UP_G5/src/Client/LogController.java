package Client;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import Entity.User;

import javax.swing.*;


public class LogController implements PropertyChangeListener{

    private List<User> allUsers = new ArrayList<>();


    public LogController() {
        //skicka meddelande till en JOptionpane showInputDialog i logView - få tillbaka ett användarnamn
        //kalla logIn metoden med användarnamnet i parameter
        String userName = JOptionPane.showInputDialog("Enter username: ");
        logIn(userName);
    }

    public void logIn(String userName){
        boolean accountExist = false;
        for (User us : allUsers) {
            if(us.equals(userName)) {
                //ändra till inloggad
                //skicka inloggning till server
                accountExist = true;
            }
        }

        if (accountExist == false) {
            createAccount(userName);
        }
    }

    public void createAccount(String userName) {
        //skapa nytt konto
        //skicka nytt konto till server
    }

    public void logOut(){

    }

    public void addUser(String userName, Icon icon){
        User user = new User(userName,icon);
        allUsers.add(user);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
