package Client;

import Client.view.ButtonType;
import Client.view.LogInFrame;
import Client.view.MainFrame;

public class ClientViewController {
    private MainFrame mainFrame;
    private ClientMessageController cmc;
    private LogController lc;
    private ContactController cc;

    public ClientViewController(ClientMessageController cmc, LogController lc, ContactController cc) {
        this.cmc = cmc;
        this.lc = lc;
        this.cc = cc;
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

    public LogController getLc() {
        return lc;
    }

    public static void main (String[] args) {
        ClientMessageController cmc = new ClientMessageController();
        LogController lc = new LogController();
        ContactController cc = new ContactController();
        ClientViewController controller = new ClientViewController(cmc, lc, cc);
    }
}
