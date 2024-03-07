package Client;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Entity.User;


public class LogController implements PropertyChangeListener{


    private RegisterUserController registerUserController;

    public LogController() {
        //skicka meddelande till en JOptionpane showInputDialog i logView - få tillbaka ett användarnamn
        //kalla logIn metoden med användarnamnet i parameter
    }

    public void logIn(String userName){
        //hämta lista av alla användare från metod i registerUserController
        //loopa igenom listan och jämför om userName finns i listan
        //om nej, skicka error meddelande till JOptionPane metoden? ska denna metod returnera ett värde?
        //om ja, ändra view till att vara inloggad = chatfönster ska synas och kontaktlista, disabla/ enabla
        //          vissa knappar
        //skicka aktivitet (inloggningen) till servern via clientNetworkBoundary?
    }

    public void logOut(){

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
