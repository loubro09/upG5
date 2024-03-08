package Client;

import Client.view.ButtonType;
import Client.view.LogInFrame;
import Client.view.MainFrame;
import Client.view.RegisterUserFrame;

public class ClientViewController {
    private MainFrame mainFrame;
    private LogController lc;

    public ClientViewController(LogController lc) {
        this.lc = lc;
        mainFrame = new MainFrame(1000, 500, this);
        mainFrame.enableAllButtons();
        mainFrame.disableLogOutButton();
        mainFrame.disableFriendsButton();
        mainFrame.disableSendMessageButton();
        //ta emot instanser av controllers?
    }

    public void buttonPressed(ButtonType button) {
        switch (button) {
            case Log_In:
                //skapa instans av LogController
                new LogInFrame(this);
                break;
            case Log_Out:
                break;
            case Register_new_user:
                new RegisterUserFrame(this);
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

    public static void main (String[] args) {
        LogController lc = new LogController();
        ClientViewController controller = new ClientViewController(lc);

       // ClientMessageController msgController = new ClientMessageController();

    }

    public LogController getLc() {
        return lc;
    }
}
