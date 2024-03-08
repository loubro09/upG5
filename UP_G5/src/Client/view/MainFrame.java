package Client.view;

import Client.ClientMessageController;
import Client.ClientViewController;
import Client.view.*;
import Entity.Message;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;
    private ClientViewController controller;
    private ClientMessageController messageController;


    public MainFrame(int width, int height, ClientViewController controller) {
        super("Chat room");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        messageController = new ClientMessageController("server_ip", 1234, this);

    }

    /*public void populateLeftPanel(ArrayList<Message> messages) {
        mainPanel.getLeftPanel().populateList(messages);
    }*/

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


    public void populateRightPanel(String[] informationArray) {
        mainPanel.getRightPanel().populateList(informationArray);
    }

    public void clearRightPanel() {
        mainPanel.getRightPanel().clearList();
    }


    public int getSelectionLeftPanel() {
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

    public void disableAndHideAddFriendButton() {
        mainPanel.getRightPanel().getBtnSelectContact().setEnabled(false);
        mainPanel.getRightPanel().getBtnSelectContact().setVisible(false);
    }


    /*public void setTextCostLabelRightPanel(String newText){
        mainPanel.getRightPanel().setTextCostLabel(newText);
    }


    public void setTextTitleLabelRightPanel(String newText){
        mainPanel.getRightPanel().setTextTitleLabel(newText);
    }*/

    public void enableAllButtons() {
        mainPanel.getLeftPanel().getBtnlogIn().setEnabled(true);
        mainPanel.getLeftPanel().getBtnLogOut().setEnabled(true);
        mainPanel.getLeftPanel().getBtnRegUser().setEnabled(true);
        mainPanel.getLeftPanel().getBtnSend().setEnabled(true);
    }


    public void buttonPressed(ButtonType pressedButton) {
        controller.buttonPressed(pressedButton);
    }


    public int printConfirmMessage(String message) {
        return JOptionPane.showConfirmDialog(null, message);
    }


    public void printDialogMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
