package Client.view;

import Entity.Message;

import javax.swing.*;
import java.util.ArrayList;

public class LPanel extends JPanel {
    private JList<Object> leftPanelList;
    private JButton btnlogIn;
    private JButton btnRegUser;
    private JButton btnLogOut;
    private JButton btnSend;
    private JButton btnExit;


    private int width;
    private int height;

    private MainFrame mainFrame;

    public LPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();
    }

    private void setUp() {


        leftPanelList = new JList<>();
        leftPanelList.setLocation(0, 23);
        leftPanelList.setSize(width, height - 100);
        this.add(leftPanelList);

        btnlogIn = new JButton("Log In");
        btnlogIn.setEnabled(true);
        btnlogIn.setSize(width / 5, 30);
        btnlogIn.setLocation(0, height - 75);
        btnlogIn.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Log_In));
        this.add(btnlogIn);

        btnRegUser = new JButton("Register user");
        btnRegUser.setEnabled(true);
        btnRegUser.setSize(width / 5, 30);
        btnRegUser.setLocation(width / 5, height - 75);
        btnRegUser.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Register_new_user));
        this.add(btnRegUser);

        btnSend = new JButton("Send Message");
        btnSend.setEnabled(true);
        btnSend.setSize(width / 5, 30);
        btnSend.setLocation((width / 5) * 2, height - 75);
        btnSend.addActionListener(l -> mainFrame.buttonPressed(ButtonType.send));
        this.add(btnSend);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setEnabled(true);
        btnLogOut.setSize(width / 5, 30);
        btnLogOut.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Log_Out));
        btnLogOut.setLocation((width / 5) * 3, height - 75);
        this.add(btnLogOut);

        btnExit = new JButton("Exit Program");
        btnExit.setEnabled(true);
        btnExit.setSize(width / 5, 30);
        btnExit.addActionListener(l -> mainFrame.buttonPressed(ButtonType.exit));
        btnExit.setLocation((width / 5) * 5, height - 75);
        this.add(btnExit);


    }

    protected JList<Object> getLeftPanelList() {
        return leftPanelList;
    }

    protected JButton getBtnSend() {
        return btnSend;
    }


    protected JButton getBtnLogOut() {
        return btnLogOut;
    }


    protected JButton getBtnlogIn() {
        return btnlogIn;
    }

    protected JButton getBtnExit() {
        return btnExit;
    }

    protected JButton getBtnRegUser() {
        return btnRegUser;

    }


    public void populateList(ArrayList<Message> messages) {
        DefaultListModel<Object> listModel = new DefaultListModel<>();
        for (Message message : messages) {
            String senderName = message.getSender() != null ? message.getSender().getUserName() : "Unknown";
            listModel.addElement(senderName + ": " + message.getText());
        }
        leftPanelList.setModel(listModel);

    }

}
