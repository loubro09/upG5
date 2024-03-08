package Client;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.Message;
import Entity.MessageType;
import Entity.User;

import javax.swing.*;


public class LogController implements PropertyChangeListener{

    private List<User> allUsers = new ArrayList<>();


    public LogController() {
        //skicka meddelande till en JOptionpane showInputDialog i logView - få tillbaka ett användarnamn
        //kalla logIn metoden med användarnamnet i parameter
    }

    //public void logIn(String userName, String ip, String port, Icon userIcon){
    public void logIn(String userName, Icon userIcon) {
        boolean accountExist = false;
        for (User us : allUsers) {
            if(us.getUserName().equals(userName)) {
                User user = us;
                ClientNetworkBoundary cnb = new ClientNetworkBoundary("localhost", 1234);
                Message message = new Message(MessageType.logIn, null, user, null, LocalDateTime.now(), null);
                cnb.sendMessage(message);
                //ändra till inloggad
                //skapa klient
                //skicka inloggning till server
                accountExist = true;
            }
        }
        if (accountExist == false) {
            //createAccount(userName, userIcon);
            addUser(userName, userIcon);
        }
    }

    public void createAccount(String userName, Icon userIcon) {
        //Icon userImage = JFileChooser
        //skapa nytt konto
        //addUser(userName, userImage);
        //skicka nytt konto till server
        //User user = new User(userName, userIcon);
        //addUser(userName, userIcon);
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
