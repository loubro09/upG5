package Client.view;
import Client.ClientViewController;
import Client.view.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;
    private ClientViewController controller;


    public MainFrame(int width, int height, ClientViewController controller) {
        super("Chat room");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void populateLeftPanel(String[] informationArray){
        mainPanel.getLeftPanel().populateList(informationArray);
    }


    public void populateRightPanel(String[] informationArray){
        mainPanel.getRightPanel().populateList(informationArray);
    }

    public void clearRightPanel(){
        mainPanel.getRightPanel().clearList();
    }


    public int getSelectionLeftPanel(){
        return mainPanel.getLeftPanel().getLeftPanelList().getSelectedIndex();
    }

    public void disableLogOutButton() {
        mainPanel.getLeftPanel().getBtnLogOut().setEnabled(false);
    }

    public void disableSendMessageButton() {
        mainPanel.getLeftPanel().getBtnSend().setEnabled(false);
    }

    public void disableFriendsButton() {
        mainPanel.getRightPanel().getBtnFriends().setEnabled(false);
    }


    /*public void setTextCostLabelRightPanel(String newText){
        mainPanel.getRightPanel().setTextCostLabel(newText);
    }


    public void setTextTitleLabelRightPanel(String newText){
        mainPanel.getRightPanel().setTextTitleLabel(newText);
    }*/

    public void enableAllButtons(){
        mainPanel.getLeftPanel().getBtnExit().setEnabled(true);
        mainPanel.getLeftPanel().getBtnlogIn().setEnabled(true);
        mainPanel.getLeftPanel().getBtnLogOut().setEnabled(true);
        mainPanel.getLeftPanel().getBtnRegUser().setEnabled(true);
        mainPanel.getLeftPanel().getBtnSend().setEnabled(true);
    }


    public void buttonPressed(ButtonType pressedButton){
        controller.buttonPressed(pressedButton);
    }


    public int printConfirmMessage(String message) {
        return JOptionPane.showConfirmDialog(null, message);
    }


    public void printDialogMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
