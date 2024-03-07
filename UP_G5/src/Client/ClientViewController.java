package Client;

import Client.view.ButtonType;
import Client.view.MainFrame;

public class ClientViewController {
    private MainFrame mainFrame;

    public ClientViewController() {
        mainFrame = new MainFrame(1000, 500, this);
        mainFrame.enableAllButtons();
        //ta emot instanser av controllers?
    }

    public void buttonPressed(ButtonType button) {
        switch (button) {
            case Log_In:
                //skapa instans av LogController
                break;
            case Log_Out:
                break;
            case Register_new_user:
                break;
            case exit:
                break;
            case send:
                break;
            case Choose_Contact:
                break;
            case friends:
                break;
            case allUsers:
                break;
        }
    }

    public static void main (String[] args) {ClientViewController controller = new ClientViewController();}
}
